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
        while (!commandEnteredByAdmin.equals(QUIT_COMMAND)) {
            commandEnteredByAdmin= scanner.nextLine();
            if (commandEnteredByAdmin.equals(ADD_COMMAND)) {
                addNewExercise(scanner);
            } else if (commandEnteredByAdmin.equals(EDIT_COMMAND)) {
            //    editExistingExercise(scanner);
            } else if (commandEnteredByAdmin.equals(DELETE_COMMAND)) {
               // deleteExerciseById(scanner);
            } else {
                System.out.println("Unknown command: " + commandEnteredByAdmin);
            }
            System.out.println("Co dalej chcesz zrobić?");


        }
    }
    public static void addNewExercise(Scanner scanner){
        System.out.println("Add exercise title");
        final String title = scanner.nextLine();
        System.out.println("Add exercise description");
        final String description = scanner.nextLine();
        ExerciseDao.create(new Exercise(title,description ));
    }

}
