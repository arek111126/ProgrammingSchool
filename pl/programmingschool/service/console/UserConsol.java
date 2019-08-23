package pl.programmingschool.service.console;

import pl.programmingschool.Commands;
import pl.programmingschool.service.operations.UserOperations;

import java.util.Scanner;

public class UserConsol {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*add ,edi,delete,quit */
        UserOperations administrationConsoleUser = new UserOperations();


        String commandEnteredByAdmin = "";
        commandEnteredByAdmin = scanner.nextLine();
        while (!commandEnteredByAdmin.equals(Commands.QUIT_COMMAND)) {

            if (commandEnteredByAdmin.equals(Commands.ADD_COMMAND)) {
                administrationConsoleUser.add(scanner);
            } else if (commandEnteredByAdmin.equals(Commands.EDIT_COMMAND)) {
                administrationConsoleUser.edit(scanner);
            } else if (commandEnteredByAdmin.equals(Commands.DELETE_COMMAND)) {
                administrationConsoleUser.delete(scanner);
            } else {
                System.out.println("Unknown command: " + commandEnteredByAdmin);
            }
            System.out.println("Co dalej chcesz zrobić?");
            commandEnteredByAdmin = scanner.nextLine();


        }
    }
}
