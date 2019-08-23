package pl.programmingschool.dao;

import pl.programmingschool.SqlConnection;
import pl.programmingschool.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class UserDao {
    /*CRUD CREATE read update delete */
    private static final String INSERT_STRING = "Insert INTO users(email,username,password,group_id) values (?,?,?,?)";
    private static final String SELECT_STRING = "SELECT id, email,username,password,group_id FROM users";
    private static final String UPDATE_STRING = "UPDATE users SET email= ?,username = ?,password = ?,group_id = ?  WHERE id= ?";
    private static final String DELETE_STRING = "DELETE FROM users WHERE id =?";

    public  User create(User user) {
        try {
            final Connection connection = SqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STRING, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getGroupId());
            preparedStatement.executeUpdate();
            final ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                final int idOfInsertedUser = generatedKeys.getInt(1);
                user.setId(idOfInsertedUser);
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    public  List<User> findAll() {
        List<User> users = new ArrayList<>();

        final Connection connection;
        try {
            connection = SqlConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id,email,userName,password,group_id FROM users");
            return ResulTSetToUserList(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

   public   User read(int userId) {
        try {

            final Connection connection = SqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STRING);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = new User();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int groupId = resultSet.getInt("group_id");
                if (id == userId) {
                    user.setEmail(email);
                    user.setUserName(username);
                    user.setPassword(password);
                    user.setGroupId(groupId);
                    return user;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public  void update(User user) {
        final Connection connection;
        try {
            connection = SqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STRING);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getGroupId());
            preparedStatement.setInt(5, user.getId());
            int numberOfUpdatedItems = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public   int delete(User user) {
        final Connection connection;
        try {
            connection = SqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STRING);
            preparedStatement.setInt(1, user.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    public  List<User> findAllByGroupId(int groupId) {
        final Connection connection;
        List<User> users = new ArrayList<>();
        try {
            connection = SqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,email,userName,password,group_id FROM users WHERE group_id = ?");
            preparedStatement.setInt(1, groupId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return ResulTSetToUserList(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    private  List<User> ResulTSetToUserList(ResultSet resultSet) {
        List<User> users = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
                final int id = resultSet.getInt("id");
                final String email = resultSet.getString("email");
                final String userName = resultSet.getString("userName");
                final String password = resultSet.getString("password");
                final int groupID = resultSet.getInt("group_id");
                User user = new User(id, email, userName, password, groupID);
                users.add(user);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }

        }
        return users;
    }


    public  static  void main(String[] args) {
        final UserDao userDao = new UserDao();
        User user = new User();
        user.setEmail("arek13326@gmail.com");
        user.setUserName("arek");
        user.setPassword("admin");
        user.setGroupId(1);
        final User userInsertedIntoDatabase = userDao.create(user);
        //System.out.println(userInsertedIntoDatabase);
        User user1 = new User();
        user1 = userDao.read(4);
        System.out.println(user1);

        user.setUserName("DAMIAN");
        user.setPassword("password1");
        user.setEmail("fff@gmail.com");
        user.setId(2);
        user.setGroupId(1);
        userDao.delete(user);
        userDao.create(new User("damian", "Michale Jackson", "Black or white", 1));

        List<User> userList = userDao.findAll();
        List<User> userList2 = userDao.findAllByGroupId(1);

    }
}


