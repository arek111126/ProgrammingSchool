package pl.programmingschool;

import pl.programmingschool.dao.ExerciseDao;
import pl.programmingschool.dao.UserDao;
import pl.programmingschool.model.Exercise;
import pl.programmingschool.model.User;

import javax.swing.text.View;
import java.util.List;
import java.util.Scanner;

import static pl.programmingschool.AdministrationConsoleUser.*;


public class AdministrationConsoleAddExercisetoCurrentUser {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*add ,edi,delete,quit */
        String commandEnteredByAdmin = "";
        while (!commandEnteredByAdmin.equals(Commands.QUIT_COMMAND)) {
            commandEnteredByAdmin = scanner.nextLine();
            if (commandEnteredByAdmin.equals(Commands.ADD_COMMAND)) {
                AdministrationConsoleAddExercisetoCurrentUser.add(scanner);
            }
            if (commandEnteredByAdmin.equals(Commands.VIEW_COMMAND)) {
                AdministrationConsoleAddExercisetoCurrentUser.add(scanner);
            } else {
                System.out.println("Unknown command: " + commandEnteredByAdmin);
            }
            System.out.println("Co dalej chcesz zrobić?");


        }
    }

    public static void add(Scanner scanner) {
        System.out.println("Lista wszystkich pracownikow");
        List<User> all = UserDao.findAll();
        for (User item : all) {
            System.out.println(item.getId() + " " + item.getUserName() + " " + item.getEmail() + " " + item.getGroupId());
        }
        System.out.println("Get user id. I create his new exercise");
        int userId = scanner.nextInt();

    }
}


