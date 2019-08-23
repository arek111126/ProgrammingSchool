package pl.programmingschool.service.operations;

import pl.programmingschool.dao.GroupsDao;
import pl.programmingschool.model.Group;

import java.util.Scanner;


public class GroupOperations {


    public  void add(Scanner scanner) {
        System.out.println("Add group name");
        final String name = scanner.nextLine();

        GroupsDao.create(new Group(name));
    }

    public  void edit(Scanner scanner) {
        System.out.println("Add  new changed group title");
        final String title = scanner.nextLine();

        Group group = new Group(title);

        GroupsDao.update(group);
    }

    public  void delete(Scanner scanner) {
        System.out.println("Get id groups to delete");
        final int id = scanner.nextInt();

        GroupsDao.delete(new Group(id, ""));
    }

}
