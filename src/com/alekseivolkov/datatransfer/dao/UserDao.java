package com.alekseivolkov.datatransfer.dao;

import com.alekseivolkov.datatransfer.entity.Genders;
import com.alekseivolkov.datatransfer.entity.Roles;
import com.alekseivolkov.datatransfer.entity.Users;
import com.alekseivolkov.datatransfer.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UserDao implements Dao<Integer, Users> {

    private static final UserDao INSTANCE = new UserDao();

    private static final String SAVE_SQL = """
            INSERT INTO users (name, birthday, email, password, role, gender) 
            VALUES (?, ?, ?, ?, ?, ?) 
            """;

    private static final String GET_BY_EMAIL_AND_PASSWORD = """
            SELECT id, name, birthday, email, password, role, gender
            FROM users
            WHERE email = ? AND password = ?
            """;

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public Optional<Users> findByAll(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Users entity) {
    }

    @Override
    @SneakyThrows
    public Users save(Users entity) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection
                     .prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getName());
            preparedStatement.setObject(2, entity.getBirthday());
            preparedStatement.setObject(3, entity.getEmail());
            preparedStatement.setObject(4, entity.getPassword());
            preparedStatement.setObject(5, entity.getRole().name());
            preparedStatement.setObject(6, entity.getGender().name());

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Integer.class));

            return entity;
        }
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }

    @SneakyThrows
    public Optional<Users> findByEmailAndPassword(String email, String password) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(GET_BY_EMAIL_AND_PASSWORD)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            var resultSet = preparedStatement.executeQuery();
            Users user = null;
            if (resultSet.next()) {
                user = buildEntity(resultSet);
            }
            return Optional.ofNullable(user);
        }
    }

    private static Users buildEntity(ResultSet resultSet) throws SQLException {
        return Users.builder()
                .id(resultSet.getObject("id", Integer.class))
                .name(resultSet.getObject("name", String.class))
                .birthday(resultSet.getObject("birthday", Date.class).toLocalDate())
                .email(resultSet.getObject("email", String.class))
                .password(resultSet.getObject("password", String.class))
                .role(Roles.valueOf(resultSet.getObject("role", String.class)))
                .gender(Genders.valueOf(resultSet.getObject("gender", String.class)))
                .build();
    }
}
