import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) {
        Map<String, String> weatherData = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/DELL/Downloads/DataStructuresProject-master/DataStructuresProject-master/weatherdata.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String city = parts[0].trim();
                    String data = parts[1].trim();
                    weatherData.put(city, data); 
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading weatherdata.txt: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a city name (or 'exit' to quit): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            String cityData = weatherData.get(userInput);

            if (cityData != null) {
                System.out.println("Weather data for " + userInput + ": " + cityData);
            } else {
                System.out.println("City not found in the data.");
            }
        }

        scanner.close();
    }
}
