package Javacore_4_Lists;

import java.util.*;

public class Main {
    public static void countAppearingFreq(ArrayList<String> list){

        //Задание 1
        //Создадим хэшмэп, чтобы записывать частоту повторения элемента.
        Map<String, Integer> hshmp = new HashMap<String, Integer>();
        for (String i : list) {
            Integer j = hshmp.get(i);
            hshmp.put(i, (j == null) ? 1 : j + 1);
        }
        //Выводим результат
        for (Map.Entry<String, Integer> val : hshmp.entrySet()) {
                System.out.println(val.getKey() + " повторяется: " + val.getValue() + " раз.");
            }
        }



            public static void main(String[] args) {
        ArrayList<String> stringsList = new ArrayList<>(Arrays.asList("Lorem", "ipsum",
                "dolor", "sit", "amet", "consectetur", "adipiscing", "elit.", "Vestibulum", "sagittis", "Lorem", "ipsum"));
        System.out.println(stringsList); //Проверяем список
        System.out.println();
        HashSet<String> hset = new HashSet<String>(stringsList); //Здесь только уникальные
        System.out.println(hset);
        System.out.println();
        countAppearingFreq(stringsList); //Применяем метод поиска частоты повторения слов
        System.out.println();
        //Задание 2, телефонная книга
        Phonebook phoneBook = new Phonebook();
        phoneBook.newEntry("Kolpakov", "+79323333333");
        phoneBook.newEntry("Kolpakov", "+79129129129");
        phoneBook.newEntry("Bykov", "+79119119119");
        phoneBook.newEntry("Popova", "+79011099019");
        System.out.println("Найденные номера: " + phoneBook.get("Kolpakov"));



    }
}
