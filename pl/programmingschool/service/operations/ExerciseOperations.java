package pl.programmingschool.service.operations;

import pl.programmingschool.dao.ExerciseDao;
import pl.programmingschool.model.Exercise;

import java.util.Scanner;


public class ExerciseOperations {

    ExerciseDao exerciseDao;
    public ExerciseOperations() {
        this.exerciseDao = new ExerciseDao();
    }

    public void add(Scanner scanner) {
        System.out.println("Add exercise title");
        final String title = scanner.nextLine();
        System.out.println("Add exercise description");
        final String description = scanner.nextLine();
        exerciseDao.create(new Exercise(title, description));
    }

    public void edit(Scanner scanner) {
        System.out.println("Add exercse title");
        final String title = scanner.nextLine();
        System.out.println("Add exercise description");
        final String description = scanner.nextLine();
        System.out.println("Add exercise id");
        final int id = scanner.nextInt();
        Exercise exercise = new Exercise(id, title, description);

        exerciseDao.update(exercise);
    }

    public void delete(Scanner scanner) {
        System.out.println("Wrote id exercise to delete");
        final int id = scanner.nextInt();

        exerciseDao.delete(new Exercise(id, "", ""));
    }

}
