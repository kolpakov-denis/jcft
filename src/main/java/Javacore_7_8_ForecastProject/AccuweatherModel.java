package Javacore_7_8_ForecastProject;

import Javacore_7_8_ForecastProject.entity.WeatherExample;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccuweatherModel extends DataBaseRepository implements WeatherModel {
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
    //http://dataservice.accuweather.com/forecasts/v1/daily/5day/
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "pXJd8MokcZCdrd2MsoGl2DBZAyCa0zvv";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    private static final String LANGUAGE_KEY = "language";
    private static final String LANGUAGE_VAL = "en-EN";
    private static final String TEMP_KEY = "metric";
    private static final String TEMP_VAL = "true";

    //I needed these because of accuweather API request limits...

   /* private static final String DEBUG_WEATHER_1 = "{\n" +
            "  \"Headline\": {\n" +
            "    \"EffectiveDate\": \"2022-06-10T19:00:00+05:00\",\n" +
            "    \"EffectiveEpochDate\": 1654869600,\n" +
            "    \"Severity\": 5,\n" +
            "    \"Text\": \"Expect showers Friday evening\",\n" +
            "    \"Category\": \"rain\",\n" +
            "    \"EndDate\": \"2022-06-11T01:00:00+05:00\",\n" +
            "    \"EndEpochDate\": 1654891200,\n" +
            "    \"MobileLink\": \"http://www.accuweather.com/en/ru/perm/294922/daily-weather-forecast/294922?unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ru/perm/294922/daily-weather-forecast/294922?unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  \"DailyForecasts\": [\n" +
            "    {\n" +
            "      \"Date\": \"2022-06-10T07:00:00+05:00\",\n" +
            "      \"EpochDate\": 1654826400,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 11,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 21.8,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 4,\n" +
            "        \"IconPhrase\": \"Intermittent clouds\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Rain\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 40,\n" +
            "        \"IconPhrase\": \"Mostly cloudy w/ showers\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Rain\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://www.accuweather.com/en/ru/perm/294922/daily-weather-forecast/294922?day=1&unit=c&lang=en-us\",\n" +
            "      \"Link\": \"http://www.accuweather.com/en/ru/perm/294922/daily-weather-forecast/294922?day=1&unit=c&lang=en-us\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    private static final String DEBUG_WEATHER_5 = "{\n" +
            "  \"Headline\": {\n" +
            "    \"EffectiveDate\": \"2022-06-10T19:00:00+05:00\",\n" +
            "    \"EffectiveEpochDate\": 1654869600,\n" +
            "    \"Severity\": 5,\n" +
            "    \"Text\": \"Expect showers Friday evening\",\n" +
            "    \"Category\": \"rain\",\n" +
            "    \"EndDate\": \"2022-06-11T01:00:00+05:00\",\n" +
            "    \"EndEpochDate\": 1654891200,\n" +
            "    \"MobileLink\": \"http://www.accuweather.com/en/ru/perm/294922/daily-weather-forecast/294922?unit=c&lang=en-us\",\n" +
            "    \"Link\": \"http://www.accuweather.com/en/ru/perm/294922/daily-weather-forecast/294922?unit=c&lang=en-us\"\n" +
            "  },\n" +
            "  \"DailyForecasts\": [\n" +
            "    {\n" +
            "      \"Date\": \"2022-06-10T07:00:00+05:00\",\n" +
            "      \"EpochDate\": 1654826400,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 11,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 21.8,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 4,\n" +
            "        \"IconPhrase\": \"Intermittent clouds\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Rain\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 40,\n" +
            "        \"IconPhrase\": \"Mostly cloudy w/ showers\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Rain\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://www.accuweather.com/en/ru/perm/294922/daily-weather-forecast/294922?day=1&unit=c&lang=en-us\",\n" +
            "      \"Link\": \"http://www.accuweather.com/en/ru/perm/294922/daily-weather-forecast/294922?day=1&unit=c&lang=en-us\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Date\": \"2022-06-11T07:00:00+05:00\",\n" +
            "      \"EpochDate\": 1654912800,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 9.9,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 20.3,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 13,\n" +
            "        \"IconPhrase\": \"Mostly cloudy w/ showers\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Rain\",\n" +
            "        \"PrecipitationIntensity\": \"Heavy\"\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 12,\n" +
            "        \"IconPhrase\": \"Showers\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Rain\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://www.accuweather.com/en/ru/perm/294922/daily-weather-forecast/294922?day=2&unit=c&lang=en-us\",\n" +
            "      \"Link\": \"http://www.accuweather.com/en/ru/perm/294922/daily-weather-forecast/294922?day=2&unit=c&lang=en-us\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Date\": \"2022-06-12T07:00:00+05:00\",\n" +
            "      \"EpochDate\": 1654999200,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 8.2,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 12.4,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 12,\n" +
            "        \"IconPhrase\": \"Showers\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Rain\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 12,\n" +
            "        \"IconPhrase\": \"Showers\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Rain\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://www.accuweather.com/en/ru/perm/294922/daily-weather-forecast/294922?day=3&unit=c&lang=en-us\",\n" +
            "      \"Link\": \"http://www.accuweather.com/en/ru/perm/294922/daily-weather-forecast/294922?day=3&unit=c&lang=en-us\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Date\": \"2022-06-13T07:00:00+05:00\",\n" +
            "      \"EpochDate\": 1655085600,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 7.1,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 19.8,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 4,\n" +
            "        \"IconPhrase\": \"Intermittent clouds\",\n" +
            "        \"HasPrecipitation\": false\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 34,\n" +
            "        \"IconPhrase\": \"Mostly clear\",\n" +
            "        \"HasPrecipitation\": false\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://www.accuweather.com/en/ru/perm/294922/daily-weather-forecast/294922?day=4&unit=c&lang=en-us\",\n" +
            "      \"Link\": \"http://www.accuweather.com/en/ru/perm/294922/daily-weather-forecast/294922?day=4&unit=c&lang=en-us\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Date\": \"2022-06-14T07:00:00+05:00\",\n" +
            "      \"EpochDate\": 1655172000,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 9.2,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 22.9,\n" +
            "          \"Unit\": \"C\",\n" +
            "          \"UnitType\": 17\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 3,\n" +
            "        \"IconPhrase\": \"Partly sunny\",\n" +
            "        \"HasPrecipitation\": false\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 33,\n" +
            "        \"IconPhrase\": \"Clear\",\n" +
            "        \"HasPrecipitation\": false\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://www.accuweather.com/en/ru/perm/294922/daily-weather-forecast/294922?day=5&unit=c&lang=en-us\",\n" +
            "      \"Link\": \"http://www.accuweather.com/en/ru/perm/294922/daily-weather-forecast/294922?day=5&unit=c&lang=en-us\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    */

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();


    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case ONE_DAY:
              HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE_KEY, LANGUAGE_VAL)
                        .addQueryParameter(TEMP_KEY, TEMP_VAL)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();

              //  String weatherResponse = DEBUG_WEATHER_1;
                WeatherResponse w1 = new WeatherResponse(1, weatherResponse, selectedCity);
                DataBaseRepository db1 = new DataBaseRepository();

                System.out.println(w1.WeatherCalculations());
                try {
                    System.out.println(db1.saveWeatherToDataBase(w1.WeatherCalculations()));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                break;
            case FIVE_DAYS:
                HttpUrl httpUrl1 = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE_KEY, LANGUAGE_VAL)
                        .addQueryParameter(TEMP_KEY, TEMP_VAL)
                        .build();
                Request request1 = new Request.Builder()
                        .url(httpUrl1)
                        .build();
                Response fiveDayForecastResponse = okHttpClient.newCall(request1).execute();
                String weatherResponse1 = fiveDayForecastResponse.body().string();

               // String weatherResponse1 = DEBUG_WEATHER_5;
                WeatherResponse w2 = new WeatherResponse(5, weatherResponse1, selectedCity);
                DataBaseRepository db2 = new DataBaseRepository();

                System.out.println(w2.WeatherCalculations());
                try {
                    System.out.println(db2.saveWeatherToDataBase(w2.WeatherCalculations()));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

        }
    }



    private String detectCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter(LANGUAGE_KEY, LANGUAGE_VAL)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }
}
