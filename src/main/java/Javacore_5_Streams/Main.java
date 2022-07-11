package Javacore_5_Streams;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AppData appdata = new AppData();
        appdata.load("data.txt");
        System.out.println("Заголовок: " + Arrays.toString(appdata.getHeader()));
        System.out.println("Данные: " + Arrays.deepToString(appdata.getData()));
        appdata.save("data1.txt");
    }
}
