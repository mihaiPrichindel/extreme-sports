import com.sda.controller.SportController;
import com.sda.entity.Sport;
import com.sda.hibernate_utils.HibernateUtil;
import com.sda.service.IsportDAO;
import com.sda.service.SportDAO;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class SportMain {
    private static SportController sportController;

    public static void main(String[] args) {
        sportController = new SportController();
        String input = null;
        while(!"stop".equalsIgnoreCase(input)) {
            input = displayOptions();
            sportController.control(input);
        }
    }

    private static String displayOptions() {
        System.out.println("Choose between: create, findAll, update, delete");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }



}

