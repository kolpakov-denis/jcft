package Lesson_3_Generics;

public class Fruit {
    public float fruit_w;

    public Fruit (float fruit_w) {
       this.fruit_w = fruit_w;
    }

    public float getFruit_w() {
        return fruit_w;
    }

    public void setFruit_w(float fruit_w) {
        this.fruit_w = fruit_w;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "fruit_w=" + fruit_w +
                '}';
    }
}

