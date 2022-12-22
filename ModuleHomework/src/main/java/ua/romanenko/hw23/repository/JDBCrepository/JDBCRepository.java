package ua.romanenko.hw23.repository.JDBCrepository;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public abstract class JDBCRepository<T, Y> {

    private static final Properties properties = loadProperties();

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(properties.getProperty("url"), properties);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = JDBCRepository.class.getResourceAsStream("/jdbc.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return properties;
    }

    public abstract boolean add(T object) throws SQLException;

    public abstract T getById(Y id) throws SQLException;

    public abstract void deleteById(Y id) throws SQLException;
}
