package Javacore_2_Exceptions;

public class Main {

    static int total = 0;

    public static int CalcArray (String [][] Setka) throws MyArraySizeException, MyArrayDataException {
        if (Setka.length != 4 || Setka[0].length != 4)
            throw new MyArraySizeException("Одна из осей массива не равна 4" + "\n" + "Длинна оси i = " + Setka.length
                    + "\n" + "Длинна оси y = " + Setka[0].length);


        for (int i = 0; i < Setka.length; i++) {
            for (int y = 0; y < Setka[i].length; y++) {
                try {
                    total += (Integer.parseInt(Setka[i][y]));
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Не удаётся конвертировать ячейку  " + (i+1) + " " + (y+1));
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        String[][] testArray = new String[][]{{"44", "45", "55", "17"}, {"25", "54", "54", "54"}, {"77", "475", "54", "22"}, {"14", "54", "75", "14"}};
        //String[][] testArray1 = new String[][]{{"44", "45", "55"}, {"25", "54", "54", "54"}, {"77", "475", "54", "22"}, {"14", "54", "75", "14"}};
        String[][] testArray2 = new String[][]{{"44", "45", "55", "as"}, {"25", "54", "54", "54"}, {"77", "475", "54", "22"}, {"14", "54", "75", "14"}};

            System.out.println(CalcArray(testArray));
           // System.out.println(CalcArray(testArray1));
            System.out.println(CalcArray(testArray2));

    }
}









