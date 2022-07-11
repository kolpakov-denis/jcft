package Lesson_3_Generics;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //Использование метода перестановки элементов массива
        ArrSwapper<Integer> arrSwapper = new ArrSwapper<>(new Integer []{1, 2, 3, 4, 5}, 1, 2);
        System.out.println();
        ArrSwapper<String> arrSwapper1 = new ArrSwapper<>(new String[]{"Dog", "Cat", "Cow", "Fly", "Bug"}, 2, 1);
        System.out.println();
        ArrSwapper<Character> arrSwapper2 = new ArrSwapper<>(new Character[]{'*', '%', '^', '&', '#'}, 4 ,2 );
        System.out.println();
        //Далее коробки с фруктами.
        Box <Apple> applBox = new Box <> ();
        //Добавляем три яблока в ArrList
        applBox.addFruit(new Apple(1));
        applBox.addFruit(new Apple(1));
        applBox.addFruit(new Apple(1));
        System.out.println(applBox.getFrutList()); //Вывод содержимого коробки с яблоками
        System.out.println(applBox.getWeight()); //Взвешивание коробки с яблоками

        Box <Orange> orangeBox = new Box <> ();
        orangeBox.addFruit(new Orange(1)); //Добавляем апельсины
        orangeBox.addFruit(new Orange(1));
        System.out.println(orangeBox.getFrutList());
        System.out.println(orangeBox.getWeight());

        System.out.println("Результат сравнения веса коробок: " + orangeBox.compare(applBox)); //Сравниваем вес коробки яблок и апельсинов

        //Метод с "пересыпанием" я писать не стал, посмотрел его на гите.




    }
}
