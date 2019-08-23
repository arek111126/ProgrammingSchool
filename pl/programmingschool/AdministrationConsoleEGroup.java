package pl.programmingschool;

import pl.programmingschool.dao.ExerciseDao;
import pl.programmingschool.dao.GroupsDao;
import pl.programmingschool.model.Exercise;
import pl.programmingschool.model.Group;

import java.util.Scanner;

import static pl.programmingschool.AdministrationConsoleUser.*;


public class AdministrationConsoleEGroup {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*add ,edi,delete,quit */
        String commandEnteredByAdmin = "";
        while (!commandEnteredByAdmin.equals(Commands.QUIT_COMMAND)) {
            commandEnteredByAdmin = scanner.nextLine();
            if (commandEnteredByAdmin.equals(Commands.ADD_COMMAND)) {
                AdministrationConsoleEGroup.add(scanner);
            } else if (commandEnteredByAdmin.equals(Commands.EDIT_COMMAND)) {
                AdministrationConsoleEGroup.edit(scanner);
            } else if (commandEnteredByAdmin.equals(Commands.DELETE_COMMAND)) {
                AdministrationConsoleEGroup.delete(scanner);
            } else {
                System.out.println("Unknown command: " + commandEnteredByAdmin);
            }
            System.out.println("Co dalej chcesz zrobić?");


        }
    }

    public static void add(Scanner scanner) {
        System.out.println("Add group name");
        final String name = scanner.nextLine();

        GroupsDao.create(new Group(name));
    }

    public static void edit(Scanner scanner) {
        System.out.println("Add  new changed group title");
        final String title = scanner.nextLine();

        Group group = new Group(title);

        GroupsDao.update(group);
    }

    private static void delete(Scanner scanner) {
        System.out.println("Get id groups to delete");
        final int id = scanner.nextInt();

        GroupsDao.delete(new Group(id, ""));
    }

}
