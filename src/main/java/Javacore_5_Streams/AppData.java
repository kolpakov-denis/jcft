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

    public String toMyString (Object[] a) {
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();

        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append("").toString();
            b.append("; ").toString();
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

            for (int[] row : data) {
                Object[] x = (Integer) row;
                writer.write(toMyString() + "\n");
            }

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


