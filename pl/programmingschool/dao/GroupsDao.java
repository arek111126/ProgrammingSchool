package pl.programmingschool.dao;

import pl.programmingschool.SqlConnection;
import pl.programmingschool.model.Group;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupsDao {
    private static final String INSERT_STRING = "Insert INTO groups(name) values (?)";
    private static final String DELETE_STRING = "DELETE FROM groups WHERE id =?";
    private static final String SELECT_STRING = "SELECT id, name FROM groups";
    private static final String UPDATE_STRING = "UPDATE groups SET  name = ?  WHERE id= ?";

    public static Group create(Group groups) {

        try {
            final Connection connection = SqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STRING, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, groups.getName());
            preparedStatement.executeUpdate();
            final ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                final int idOfInsertedUser = generatedKeys.getInt(1);
                groups.setId(idOfInsertedUser);
            }
            return groups;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
        List<Group> findAll(){
            List<Group> groups = new ArrayList<>();

            final Connection connection;
            try {
                connection = SqlConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT name FROM groups");
                return ResulTSetToUserList(resultSet);

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }





    }
    private List<Group> ResulTSetToUserList(ResultSet resultSet) {
        List<Group> groups  = new ArrayList<>();
        while (true){
            try {
                if (!resultSet.next()) break;
                final int id = resultSet.getInt("id");
                final String name = resultSet.getString("name");

                Group newGroup = new Group(id,name);
                groups.add(newGroup);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }

        }
        return groups;
    }
    public static int  delete(Group groups){
        final Connection connection;
        try {
            connection = SqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STRING);
            preparedStatement.setInt(1,groups.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }
    public static Group  read(int groupId) {
        try {

            final Connection connection = SqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STRING);
            ResultSet resultSet = preparedStatement.executeQuery();
            Group group = new Group();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                if (id == groupId) {
                    group.setId(id);
                    group.setName(name);

                    return group;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public static  void  update(Group groups){
        final Connection connection;
        try {
            connection = SqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STRING);
            preparedStatement.setString(1,groups.getName());
            preparedStatement.setInt(2,groups.getId());
            int numberOfUpdatedItems = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
