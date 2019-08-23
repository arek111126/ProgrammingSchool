package pl.programmingschool.service.operations;

import pl.programmingschool.dao.ExerciseDao;
import pl.programmingschool.dao.SolutionDao;
import pl.programmingschool.dao.UserDao;
import pl.programmingschool.model.Exercise;
import pl.programmingschool.model.Solution;
import pl.programmingschool.model.User;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class AddExercisetoCurrentUserOperations {

    SolutionDao solutionDao;
    ExerciseDao exerciseDao;
    UserDao userDao;

    public AddExercisetoCurrentUserOperations() {
        this.solutionDao = new SolutionDao();
        this.exerciseDao = new ExerciseDao();
        this.userDao = new UserDao();
    }

    public void add(Scanner scanner) {

        System.out.println("List All workers");
        List<User> all = userDao.findAll();
        for (User item : all) {
            System.out.println(item.toString());
        }
        System.out.println("Wrote user id. I create his new exercise");
        int userId = scanner.nextInt();
        List<Exercise> allExercise = exerciseDao.findAll();
        for (Exercise item : allExercise) {
            System.out.println(item.toString());
        }
        System.out.println("Get exercise id");
        final int exerciseId = scanner.nextInt();
        Date rename = new Date();
        SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = simpleDateFormat.format(rename);
        Solution solution = new Solution(currentTime, exerciseId, userId);
        solutionDao.create(solution);


    }

    public void getUserSolution(Scanner scanner) {
        System.out.println(" Write user id which solution ould like to see");
        int userId = scanner.nextInt();
        List<Solution> allUserSolution = solutionDao.findAllByUserId(userId);
        for (Solution item: allUserSolution){
            System.out.println(item.toString());
        }


    }


}


