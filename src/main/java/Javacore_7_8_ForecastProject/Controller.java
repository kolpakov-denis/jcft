package Javacore_7_8_ForecastProject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModel = new AccuweatherModel();
    private Map<Integer, Period> variants = new HashMap<>();

    public Controller() {
        variants.put(1, Period.ONE_DAY);
        variants.put(5, Period.FIVE_DAYS);
        variants.put(2, Period.DB);
    }

    public void getWeather(String userInput, String selectedCity) throws IOException, SQLException {
        Integer userIntegerInput = Integer.parseInt(userInput);

        switch (variants.get(userIntegerInput)) {
            case ONE_DAY:
                weatherModel.getWeather(selectedCity, Period.ONE_DAY);
                break;
            case FIVE_DAYS:
                weatherModel.getWeather(selectedCity, Period.FIVE_DAYS);
                break;
           case DB:
               DataBaseRepository db = new DataBaseRepository();
               System.out.println(db.getSavedToDBWeather(selectedCity));
                break;


        }
    }


}


