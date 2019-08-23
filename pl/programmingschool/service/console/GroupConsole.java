package pl.programmingschool.service.console;

import pl.programmingschool.Commands;
import pl.programmingschool.service.operations.GroupOperations;

import java.util.Scanner;

public class GroupConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GroupOperations administrationConsoleEGroup = new GroupOperations();
        /*add ,edi,delete,quit */
        String commandEnteredByAdmin = "";
        while (!commandEnteredByAdmin.equals(Commands.QUIT_COMMAND)) {
            commandEnteredByAdmin = scanner.nextLine();
            if (commandEnteredByAdmin.equals(Commands.ADD_COMMAND)) {
                administrationConsoleEGroup.add(scanner);
            } else if (commandEnteredByAdmin.equals(Commands.EDIT_COMMAND)) {
                administrationConsoleEGroup.edit(scanner);
            } else if (commandEnteredByAdmin.equals(Commands.DELETE_COMMAND)) {
                administrationConsoleEGroup.delete(scanner);
            } else {
                System.out.println("Unknown command: " + commandEnteredByAdmin);
            }
            System.out.println("Co dalej chcesz zrobić?");


        }
    }
}
