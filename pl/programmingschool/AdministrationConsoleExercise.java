package pl.programmingschool;

import pl.programmingschool.dao.ExerciseDao;
import pl.programmingschool.model.Exercise;

import java.util.Scanner;

import static pl.programmingschool.AdministrationConsoleUser.*;


public class AdministrationConsoleExercise {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*add ,edi,delete,quit */
        String commandEnteredByAdmin = "";
        while (!commandEnteredByAdmin.equals(Commands.QUIT_COMMAND)) {
            commandEnteredByAdmin = scanner.nextLine();
            if (commandEnteredByAdmin.equals(Commands.ADD_COMMAND)) {
                AdministrationConsoleExercise.add(scanner);
            } else if (commandEnteredByAdmin.equals(Commands.EDIT_COMMAND)) {
                AdministrationConsoleExercise.edit(scanner);
            } else if (commandEnteredByAdmin.equals(Commands.DELETE_COMMAND)) {
                AdministrationConsoleExercise.delete(scanner);
            } else {
                System.out.println("Unknown command: " + commandEnteredByAdmin);
            }
            System.out.println("Co dalej chcesz zrobić?");


        }
    }

    public static void add(Scanner scanner) {
        System.out.println("Add exercise title");
        final String title = scanner.nextLine();
        System.out.println("Add exercise description");
        final String description = scanner.nextLine();
        ExerciseDao.create(new Exercise(title, description));
    }

    public static void edit(Scanner scanner) {
        System.out.println("Add exercse title");
        final String title = scanner.nextLine();
        System.out.println("Add exercise description");
        final String description = scanner.nextLine();
        System.out.println("Add exercise id");
        final int id = scanner.nextInt();
        Exercise exercise = new Exercise(id, title, description);

        ExerciseDao.update(exercise);
    }

    private static void delete(Scanner scanner) {
        System.out.println("Get id exercise to delete");
        final int id = scanner.nextInt();

        ExerciseDao.delete(new Exercise(id, "", ""));
    }

}
