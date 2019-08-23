package pl.programmingschool.service.console;

import pl.programmingschool.service.operations.AddExercisetoCurrentUserOperations;
import pl.programmingschool.Commands;

import java.util.Scanner;

public class AddExerciseToCurrentUserConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddExercisetoCurrentUserOperations administrationConsoleAddExercisetoCurrentUser = new AddExercisetoCurrentUserOperations();
        String commandEnteredByAdmin = "";
        while (!commandEnteredByAdmin.equals(Commands.QUIT_COMMAND)) {
            commandEnteredByAdmin = scanner.nextLine();
            if (commandEnteredByAdmin.equals(Commands.ADD_COMMAND)) {
                administrationConsoleAddExercisetoCurrentUser.add(scanner);
            } else if (commandEnteredByAdmin.equals(Commands.VIEW_COMMAND)) {
                administrationConsoleAddExercisetoCurrentUser.getUserSolution(scanner);
            } else {
                System.out.println("Unknown command: " + commandEnteredByAdmin);
            }

            scanner.nextLine();

            System.out.println("Co dalej chcesz zrobić?");


        }
    }
}
