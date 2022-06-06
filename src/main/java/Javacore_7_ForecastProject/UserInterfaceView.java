package Javacore_7_ForecastProject;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название города кириллицей: ");
            String city = scanner.nextLine();
          /*  if (!Pattern.matches("[A-Za-z]", city)) {
                System.out.println("Город не найден...");
                continue;
            }

           */



            System.out.println("Введите 1 для получения погоды на сегодня;" + "\n" +
                  //  "Введите 2 для получения данных из базы;" + "\n" +
                    "Введите 5 для прогноза на 5 дней;" + "\n" +
                    "Введите 0 для выхода:");

            String command = scanner.nextLine();

            if (command.equals("0")) break;

            if (!Pattern.matches("[1,5,0]", command)) {
                System.out.println("Введите корректную цифру...");
                continue;
            }

            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        UserInterfaceView userInterfaceView = new UserInterfaceView();
        userInterfaceView.runInterface();
    }
}