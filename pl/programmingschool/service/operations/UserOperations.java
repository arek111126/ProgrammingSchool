package pl.programmingschool.service.operations;

import pl.programmingschool.model.User;
import pl.programmingschool.dao.UserDao;

import java.util.Scanner;


public class UserOperations {

    public  UserDao userDao;



    public  void delete(Scanner scanner) {
        System.out.println("Give userId to delete");
        final int id = scanner.nextInt();

        userDao.delete(new User(id, "", "", "", 1));
    }

    public  void edit(Scanner scanner) {
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

    public  void add(Scanner scanner) {
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



}
