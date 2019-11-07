import com.sda.controller.PlaceController;

import java.util.Scanner;

public class PlaceMain {


    private static PlaceController placeController;

    public static void main(String[] args) {
        placeController = new PlaceController();
        String input = null;
        while (!"stop".equalsIgnoreCase(input)) {
            input = displayOptions();
            placeController.control(input);
        }
    }

    private static String displayOptions() {
        System.out.println("Choose between: create, findAll, update, delete");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}

