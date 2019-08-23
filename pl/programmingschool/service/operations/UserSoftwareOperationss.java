package pl.programmingschool.service.operations;

import pl.programmingschool.dao.ExerciseDao;
import pl.programmingschool.dao.SolutionDao;
import pl.programmingschool.model.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserSoftwareOperationss {
    SolutionDao solutionDao;
    ExerciseDao exerciseDao;

    public UserSoftwareOperationss() {
        this.solutionDao = new SolutionDao();
        this.exerciseDao = new ExerciseDao();
    }

    public void add(Scanner scanner, int userId) {
        List<Solution> allByUserId = Optional.ofNullable(solutionDao.findAllByUserId(userId))
                .map(List::stream)
                .orElseGet(Stream::empty)
                .filter(item -> item.getDescription() == null)
                .collect(Collectors.toList());
        if (!(allByUserId.size() == 0)) {

            System.out.println("Dear user you didn 't add solutions for this exercise");
            for (Solution item : allByUserId) {
                System.out.println(item.toString());

            }

            System.out.println("to which exercise I should add a solution ? ");
            int exerciseId = scanner.nextInt();
            List<Solution> idOutOfRange = Optional.ofNullable(allByUserId)
                    .map(List::stream)
                    .orElseGet(Stream::empty)
                    .filter(item -> item.getExerciseId() == exerciseId)
                    .collect(Collectors.toList());
            if (idOutOfRange.size() == 0) {
                System.out.println("out of range. You wrote incorrect solution id");
            } else {
                Solution solutionRecord = solutionDao.findAllByExerciseId(exerciseId)
                        .stream()
                        .filter(item -> item.getUserId()==userId)
                        .collect(Collectors.toList()).get(0);
                System.out.println("Wrote solution");
                scanner.nextLine();
                String solutionDescription = scanner.nextLine();
                solutionRecord.setDescription(solutionDescription);
                solutionDao.update(solutionRecord);
                System.out.println("data saved");
            }



        } else{
            System.out.println("You haven't any not ended task");
        }


    }

    public void view(Scanner scanner, int userId){
        System.out.println("view your solutions:");
        List<Solution> allByUserId = solutionDao.findAllByUserId(userId);

        for (Solution item : allByUserId){
            System.out.println(item.toString());
        }
    }
}
