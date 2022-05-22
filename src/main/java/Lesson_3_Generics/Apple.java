package Lesson_3_Generics;

public class Apple extends Fruit {

  public Apple ( float fruit_w) {
        super(1.0f);

    }
    @Override
    public String toString() {
        return "Apple {" +
                "fruit_w=" + fruit_w +
                '}';
    }

}