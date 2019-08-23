package pl.programmingschool.dao;

import pl.programmingschool.SqlConnection;
import pl.programmingschool.model.Solution;
import pl.programmingschool.model.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class SolutionDao {

    /*CRUD CREATE read update delete */
    private static final String INSERT_STRING = "Insert INTO solutions(created ,updated,description,exercise_id, user_id) values (?,?,?,?,?)";
    private static final String SELECT_STRING = "SELECT id, created, updated, description, exercise_id, user_id FROM solutions";
    private static final String UPDATE_STRING = "UPDATE solutions SET  created = ?, updated = ?, description = ?, exercise_id = ?, user_id = ?  WHERE id= ?";
    private static final String DELETE_STRING = "DELETE FROM solutions WHERE id =?";

    public Solution create(Solution solution) {
        try {
            final Connection connection = SqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STRING, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, solution.getCreated());
            preparedStatement.setString(2, solution.getUpdated());
            preparedStatement.setString(3, solution.getDescription());
            preparedStatement.setInt(4, solution.getExerciseId());
            preparedStatement.setInt(5, solution.getUserId());
            preparedStatement.executeUpdate();
            final ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                final int idOfInsertedUser = generatedKeys.getInt(1);
                solution.setId(idOfInsertedUser);
            }
            return solution;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    List<Solution> findAll(){
        List<Solution> solutions = new ArrayList<>();

        final Connection connection;
        try {
            connection = SqlConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, created, updated, description, exercise_id, user_id FROM solutions");
            return ResulTSetToUserList(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }



    }

    Solution read(int solutionId) {
        try {

            final Connection connection = SqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STRING);
            ResultSet resultSet = preparedStatement.executeQuery();
            Solution solution = new Solution();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String created = resultSet.getString("created");
                String updated = resultSet.getString("updated");
                String description = resultSet.getString("description");
                int exerciseId = resultSet.getInt("exercise_id");
                int userId = resultSet.getInt("user_id");
                if (id == solutionId) {
                    solution.setId(id);
                    solution.setCreated(created);
                    solution.setDescription(description);
                    solution.setExerciseId(exerciseId);
                    solution.setUpdated(updated);
                    solution.setUserId(userId);
                    return solution;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    void update(Solution solution){
        final Connection connection;
        try {
            connection = SqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STRING);
            preparedStatement.setString(1,solution.getCreated());
            preparedStatement.setString(2,solution.getUpdated());
            preparedStatement.setString(3,solution.getDescription());
            preparedStatement.setInt(4,solution.getExerciseId());
            preparedStatement.setInt(5,solution.getUserId());
            preparedStatement.setInt(6,solution.getId());
            int numberOfUpdatedItems = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    int  delete(Solution solution){
        final Connection connection;
        try {
            connection = SqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STRING);
            preparedStatement.setInt(1,solution.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }



    private List<Solution> ResulTSetToUserList(ResultSet resultSet) {
        List<Solution> solutions  = new ArrayList<>();
        while (true){
            try {
                if (!resultSet.next()) break;
                final int id = resultSet.getInt("id");
                final String created = resultSet.getString("created");
                final String updated = resultSet.getString("updated");
                final String description = resultSet.getString("description");
                final int exerciseId = Integer.parseInt(resultSet.getString("exercise_id"));
                final int userId = Integer.parseInt(resultSet.getString("user_id"));
                Solution solution = new Solution(id, created, updated, description, exerciseId, userId);
                solutions.add(solution);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }

        }
        return solutions;
    }
    List<Solution> findAllByUserId(int userId) {
        final Connection connection;
        List<User> users = new ArrayList<>();
        try {
            connection = SqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, created, updated, description, exercise_id, user_id FROM solutions WHERE user_id = ?");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return ResulTSetToUserList(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }
    List<Solution> findAllByExerciseId(int exerciseId) {
        final Connection connection;
        List<User> users = new ArrayList<>();
        try {
            connection = SqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, created, updated, description, exercise_id, user_id FROM solutions WHERE exercise_id = ?");
            preparedStatement.setInt(1, exerciseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return ResulTSetToUserList(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }






}
