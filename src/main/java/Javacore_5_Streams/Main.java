package Javacore_5_Streams;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        AppData appdata = new AppData();
       /* File file = new File("1.txt");
        file.createNewFile();
        System.out.println(file.exists());
        file.delete();

        */
        appdata.load("data.txt");

        appdata.save("data1.txt");
    }
}
