package Lesson_3_Generics;

import java.util.ArrayList;

public class Box <T extends Fruit> {

    private ArrayList<T> frutList = new ArrayList<>();

    public Box() {};

    public ArrayList<T> getFrutList() {
        return frutList;
    }

    public void addFruit(T fruit) {
        frutList.add(fruit);
    }

    public String getWeight() {
        return "Вес этой коробки: " + frutList.size() * frutList.get(0).getFruit_w();
    }

    public boolean compare (Box<?> box) {
        return getWeight().equals(box.getWeight());
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruitcheck=" + frutList +
                '}';
    }


}



