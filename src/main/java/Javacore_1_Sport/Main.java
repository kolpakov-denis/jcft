package Javacore_1_Sport;

public class Main {

    public static void main(String[] args) {
        Course course1 = new Course(new Track(50), new Weightlifting(40), new PoleVaulting(20)); //Создаём полосу препятствий (параметры испытаний)

        Team team1 = new Team("Pelmenis", new Athlete[] //Создаём команду из четырёх атлетов
                {new Athlete("Stas", "Kornyushin", 6, 70, 8),
                 new Athlete("Sergey", "Astakhov", 14, 5,66),
                 new Athlete("Denis", "Kolpakov", 30, 30, 30),
                 new Athlete("Vitaly", "Verigo", 50,50,22)});

        System.out.println(team1.League()); //Выводим информацию обо всех атлетах

        course1.doIt(team1); //Начинаются соревнования, выводится победитель

    }
}
