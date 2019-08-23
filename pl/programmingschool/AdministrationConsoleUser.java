package pl.programmingschool;

import pl.programmingschool.model.User;
import pl.programmingschool.dao.UserDao;

import java.util.Scanner;

public class AdministrationConsoleUser {

    static UserDao userDao;

    final static String QUIT_COMMAND = "quit";
    final static  String ADD_COMMAND = "add";
    final static String EDIT_COMMAND = "edit";
    final static  String DELETE_COMMAND = "delete";

    private static void deleteUserById(Scanner scanner) {
        System.out.println("Podaj id usera do usuniecia");
        final int id = scanner.nextInt();

        userDao.delete(new User(id, "", "", "", 1));
    }

    private static void editExistingUser(Scanner scanner) {
        System.out.println("Add user name");
        final String name = scanner.nextLine();
        System.out.println("Add email");
        final String email = scanner.nextLine();
        System.out.println("Add password");
        final String password = scanner.nextLine();
        System.out.println("a do jakiej grupy należy ? podaj numer");
        final int groupId = scanner.nextInt();
        System.out.println("Jaki jest jego id");
        final int id = scanner.nextInt();
        final User user = new User(id, name, email, password, groupId);
        userDao.update(user);
    }

    private static void  addNewUser(Scanner scanner) {
        System.out.println("Add user name");
        final String name = scanner.nextLine();
        System.out.println("Add email");
        final String email = scanner.nextLine();
        System.out.println("Add password");
        final String password = scanner.nextLine();
        System.out.println("a do jakiej grupy należy ? podaj numer");
        final int groupId = scanner.nextInt();
        userDao.create(new User(email, name, password, groupId));

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*add ,edi,delete,quit */

        String commandEnteredByAdmin = "";
        commandEnteredByAdmin = scanner.nextLine();
        while (!commandEnteredByAdmin.equals(QUIT_COMMAND)) {

            if (commandEnteredByAdmin.equals(ADD_COMMAND)) {
                addNewUser(scanner);
            } else if (commandEnteredByAdmin.equals(EDIT_COMMAND)) {
                editExistingUser(scanner);
            } else if (commandEnteredByAdmin.equals(DELETE_COMMAND)) {
                deleteUserById(scanner);
            } else {
                System.out.println("Unknown command: " + commandEnteredByAdmin);
            }
            System.out.println("Co dalej chcesz zrobić?");
            commandEnteredByAdmin = scanner.nextLine();


        }
    }


}
