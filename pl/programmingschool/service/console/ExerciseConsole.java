package pl.programmingschool.service.console;

import pl.programmingschool.Commands;
import pl.programmingschool.service.operations.ExerciseOperations;

import java.util.Scanner;

public class ExerciseConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExerciseOperations administrationConsoleExercise = new ExerciseOperations();
        /*add ,edi,delete,quit */
        String commandEnteredByAdmin = "";
        while (!commandEnteredByAdmin.equals(Commands.QUIT_COMMAND)) {
            commandEnteredByAdmin = scanner.nextLine();
            if (commandEnteredByAdmin.equals(Commands.ADD_COMMAND)) {
                administrationConsoleExercise.add(scanner);
            } else if (commandEnteredByAdmin.equals(Commands.EDIT_COMMAND)) {
                administrationConsoleExercise.edit(scanner);
            } else if (commandEnteredByAdmin.equals(Commands.DELETE_COMMAND)) {
                administrationConsoleExercise.delete(scanner);
            } else {
                System.out.println("Unknown command: " + commandEnteredByAdmin);
            }
            scanner.nextLine();
            System.out.println("Co dalej chcesz zrobić?");


        }
    }
}
