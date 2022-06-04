package Javacore_6_Connections;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;


public class PermWeather {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .build();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("dataservice.accuweather.com")
                .addQueryParameter("apikey", "JZGCTIE22ENfiFRHxtPKuVAAroxWASoT")
                .addQueryParameter("metric", "true")
                .addPathSegments("/forecasts/v1/daily/5day/294922")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.headers());
        String body = response.body().string();
        System.out.println(body);
    }
}
