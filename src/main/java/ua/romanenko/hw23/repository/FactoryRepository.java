package ua.romanenko.hw23.repository;

import ua.romanenko.hw23.entity.Factory;

import java.sql.*;

public class FactoryRepository extends JDBCRepository<Factory, Long> {

    private final String createFactorySQL = "INSERT INTO factory (factory_id,name,country) VALUES (?,?,?)";

    private final String selectFactoryById = "SELECT * FROM factory WHERE factory_id = ?";

    private final String deleteFactoryById = "DELETE FROM factory WHERE factory_id = ?";

    private final String createTableFactory = "CREATE TABLE Factory(" +
            "factory_id BIGINT NOT NULL PRIMARY KEY ," +
            "name VARCHAR(15) NOT NULL," +
            "country VARCHAR(15) NOT NULL" +
            ");";

    public void createTableFactory() {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(createTableFactory);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean add(Factory factory) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(createFactorySQL)) {
            statement.setLong(1, factory.getId());
            statement.setString(2, factory.getName());
            statement.setString(3, factory.getCountry());
            return statement.execute();
        }
    }

    @Override
    public Factory getById(Long id) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(selectFactoryById)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return factoryFromResultSet(resultSet);
                }
                return null;
            }
        }
    }

    private Factory factoryFromResultSet(ResultSet resultSet) throws SQLException {
        Factory factory = new Factory();
        factory.setId(resultSet.getLong("factory_id"));
        factory.setName(resultSet.getString(2));
        factory.setCountry(resultSet.getString(3));
        return factory;
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(deleteFactoryById)) {
            statement.setLong(1, id);
            statement.execute();
        }
    }
}
