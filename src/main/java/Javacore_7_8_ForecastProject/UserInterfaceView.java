package Javacore_7_8_ForecastProject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter city name (latin symbols, english): ");
            String city = scanner.nextLine();
            System.out.println("Enter '1' for today's weather forecast online;" + "\n" +
                    "Enter '2' for loading forecasts from database;" + "\n" + //Loads last 5 saved records, date sorted.
                    "Enter '5' for a five day weather forecast online;" + "\n" +
                    "Enter '0' for exit.");

            String command = scanner.nextLine();

            if (command.equals("0")) break;

            if (!Pattern.matches("[1,2,5,0]", command)) {
                System.out.println("Incorrect command...");
                continue;
            }

            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        UserInterfaceView userInterfaceView = new UserInterfaceView();
        userInterfaceView.runInterface();
    }
}