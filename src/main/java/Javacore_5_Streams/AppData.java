package Javacore_5_Streams;

import java.io.*;
import java.util.Arrays;

public class AppData {
    private String[] header;
    private int[][] data;


    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    //Интересно, кто-нибудь ещё сделал так-же? (:
    public String toMyString (Object[] a) {
        int iMax = a.length - 1;

        StringBuilder b = new StringBuilder();

        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.toString();
            b.append(";").toString();
        }
    }

    private int[] stringToRow(String str) {
        String[] string = str.split(";");

        int[] integer = new int[string.length];
        for (int i = 0; i < string.length; i++) {
            integer[i] = Integer.parseInt(string[i]);
        }
        return integer;
    }

    public void save(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write((toMyString(header)) + "\n");
         //   System.out.println(Arrays.deepToString(data));
            String[] arrStr = new String[3];
            for (int i = 0; i < data[0].length; i++) {
                arrStr[i] = String.valueOf(data[0][i]);
            }
            writer.write((toMyString(arrStr)) + "\n");
            String[] arrStr1 = new String[3];

            for (int y = 0; y < data[1].length; y++) {
                    arrStr1[y] = String.valueOf(data[1][y]);
                }
            writer.write((toMyString(arrStr1)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            header = bufferedReader.readLine().split(";");
            String tempString;
            int tempint[][] = new int[2][2];


            for (int i = 0; i < tempint.length; i++) {
                {
                    tempString = bufferedReader.readLine();
                    tempint[i] = (stringToRow(tempString));
                }
                data = tempint;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


