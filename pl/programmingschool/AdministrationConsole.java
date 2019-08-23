package pl.programmingschool;

import jdk.nashorn.internal.ir.WhileNode;
import pl.programmingschool.dao.UserDao;
import pl.programmingschool.model.User;

import java.util.Scanner;

public class AdministrationConsole {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*add ,edi,delete,quit */
        String commandEnteredByAdmin = "";

        while (!commandEnteredByAdmin.equals(Commands.QUIT_COMMAND)) {
            if (commandEnteredByAdmin.equals(Commands.ADD_COMMAND)) {
                addNewUser(scanner);
            } else if (commandEnteredByAdmin.equals(Commands.EDIT_COMMAND)) {
                editExistingUser();
            } else if (commandEnteredByAdmin.equals(Commands.DELETE_COMMAND)) {
                deleteUserById();
            } else {
                System.out.println("Unknown command: " + commandEnteredByAdmin);
            }

        }
    }

    private static void deleteUserById() {
    }

    private static void editExistingUser() {

    }

    private static void addNewUser(Scanner scanner) {
        System.out.println("Add user");
        System.out.println("Addd name");
        final String name = scanner.nextLine();
        System.out.println("Add email");
        final String email = scanner.nextLine();
        System.out.println("Add password");
        final String password = scanner.nextLine();
        System.out.println("Add group");
        final int groupId = scanner.nextInt();
        final User user = new UserDao().create(new User(email, name, password,groupId));
        System.out.println("Created user with id: " + user.getId());
    }


}
