package Lesson_3_Generics;

import java.util.Arrays;

public class ArrSwapper<T> { //Ладно, по крайней мере, оно использует дженерик.

    int pos1;
    int pos2;
    T cache;
    T [] targetArr;

    public ArrSwapper(T [] targetArr, int pos1, int pos2) {
        this.pos1 = pos1+1;
        this.pos2 = pos2+1;
        this.targetArr = targetArr;
        System.out.println("Принят массив: " + Arrays.toString(targetArr) + "\n" +
                "Пытаемся поменять местами элемент " + (pos1+1) + " и " + (pos2+1));
        if (pos1 >= 0 && pos1 < targetArr.length && pos2 >= 0 && pos2 < targetArr.length) { //Вообще, тут наверное, можно было бы и исключение швырнуть, но лень, да и зачем?..
            T cache = targetArr[pos1];
            targetArr[pos1] = targetArr[pos2];
            targetArr[pos2] = cache;
            System.out.println("Новый массив: " + Arrays.toString(targetArr));
        } else {
            System.out.println("Один или оба элемента за границей массива. Размер массива: " + targetArr.length +
                    "  Заданные эдементы: " + (pos1+1) + " и " + (pos2+1));
        }

    }
}
