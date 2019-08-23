package pl.programmingschool;

import pl.programmingschool.model.User;
import pl.programmingschool.dao.UserDao;

import java.util.Scanner;


public class AdministrationConsoleUser {

    public static UserDao userDao;



    private static void delete(Scanner scanner) {
        System.out.println("Podaj id usera do usuniecia");
        final int id = scanner.nextInt();

        userDao.delete(new User(id, "", "", "", 1));
    }

    private static void edit(Scanner scanner) {
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

    private static void add(Scanner scanner) {
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
        while (!commandEnteredByAdmin.equals(Commands.QUIT_COMMAND)) {

            if (commandEnteredByAdmin.equals(Commands.ADD_COMMAND)) {
                AdministrationConsoleUser.add(scanner);
            } else if (commandEnteredByAdmin.equals(Commands.EDIT_COMMAND)) {
                AdministrationConsoleUser.edit(scanner);
            } else if (commandEnteredByAdmin.equals(Commands.DELETE_COMMAND)) {
                AdministrationConsoleUser.delete(scanner);
            } else {
                System.out.println("Unknown command: " + commandEnteredByAdmin);
            }
            System.out.println("Co dalej chcesz zrobić?");
            commandEnteredByAdmin = scanner.nextLine();


        }
    }


}
