package pl.programmingschool;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.Scanner;

public class AdministrationConsole {
    public static final String QUIT_COMMAND = "add";
    private static final String ADD_COMMAND = "add";
    private static final String EDIT_COMMAND = "edit";
    private static final String DELETE_COMMAND = "delete";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*add ,edi,delete,quit */
        String commandEnteredByAdmin = "";

        while (!commandEnteredByAdmin.equals(QUIT_COMMAND)) {
            if (commandEnteredByAdmin.equals(ADD_COMMAND)) {
                addNewUser(scanner);
            } else if (commandEnteredByAdmin.equals(EDIT_COMMAND)) {
                editExistingUser();
            } else if (commandEnteredByAdmin.equals(DELETE_COMMAND)) {
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
        final User user = new UserDao().create(new User(email, name, password));
        System.out.println("Created user with id: " + user.getId());
    }


}
