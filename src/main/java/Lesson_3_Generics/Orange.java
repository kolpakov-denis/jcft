package Lesson_3_Generics;

public class Orange extends Fruit {

   public Orange (float fruit_w) {
        super(1.5f);
    }
    @Override
    public String toString() {
        return "Orange {" +
                "fruit_w=" + fruit_w +
                '}';
    }


}
