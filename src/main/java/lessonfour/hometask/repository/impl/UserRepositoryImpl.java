package lessonfour.hometask.repository.impl;

import lessonfour.hometask.exception.DatabaseException;
import lessonfour.hometask.model.User;
import lessonfour.hometask.repository.UserRepository;
import lessonfour.hometask.util.ConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private static final int MIN_AFFECTED_ROWS_COUNT = 1;
    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String PASS = "password";

    @Override
    public User save(User user) {
        String sqlRequest = "INSERT INTO users (email, phone, password) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, user.getEmail()); // Добавил @Getter
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getPass());

            int affectedRows = preparedStatement.executeUpdate();
            checkAffectedRowsNumber(affectedRows);
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                user.setId(id); // Добавил @Setter
            }
        } catch (SQLException e) {
            throw new DatabaseException("Can't create instance of user:"
                + user.toString()
                + " and add it to DB", e
            );
        }
        return user;
    }

    private void checkAffectedRowsNumber(int number) {
        if (number < MIN_AFFECTED_ROWS_COUNT) {
            throw new DatabaseException("Excepted to save at least 1 row. " + "But changed 0 rows.");
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        String sqlRequest = "SELECT * FROM users WHERE id = ?";

        try (PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(sqlRequest)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(parseUser(resultSet));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Can't find user by id. ID=" + id, e);
        }

        return Optional.empty();
    }

    private User parseUser(ResultSet requestResult) {
        try {
            Long id = requestResult.getObject(ID, Long.class);
            String email = requestResult.getString(EMAIL);
            String phone = requestResult.getString(PHONE);
            String pass = requestResult.getString(PASS);
            return new User(id, email, phone, pass);
        } catch (SQLException e) {
            throw new DatabaseException("Can't parse user " + "data from resultSet", e);
        }
    }
}
