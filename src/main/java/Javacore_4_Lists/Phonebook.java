package Javacore_4_Lists;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void newEntry(String surname, String number) {
        ArrayList<String> numbersInSurname = phoneBook.getOrDefault(surname, new ArrayList<>());
        numbersInSurname.add(number);
        phoneBook.put(surname, numbersInSurname);
    }
    public ArrayList<String> get(String surname) {
        return phoneBook.get(surname);
    }




}
