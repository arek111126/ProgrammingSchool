package pl.programmingschool.service.console;

import pl.programmingschool.Commands;
import pl.programmingschool.service.operations.UserSoftwareOperationss;


import java.util.Scanner;

public class UserSoftware {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id");
         int userId = scanner.nextInt();
        UserSoftwareOperationss userSoftwareOperations = new UserSoftwareOperationss();

        String commandEnteredByAdmin = "";
        while (!commandEnteredByAdmin.equals(Commands.QUIT_COMMAND)) {

            if (commandEnteredByAdmin.equals(Commands.ADD_COMMAND)) {
                userSoftwareOperations.add(scanner,userId);
            } else if (commandEnteredByAdmin.equals(Commands.VIEW_COMMAND)) {
                userSoftwareOperations.view(scanner,userId);
            } else {
                System.out.println("Unknown command: " + commandEnteredByAdmin);
            }
            System.out.println("Co dalej chcesz zrobić?");
            commandEnteredByAdmin = scanner.nextLine();


        }
    }
}
