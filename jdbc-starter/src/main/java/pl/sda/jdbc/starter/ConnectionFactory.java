package pl.sda.jdbc.starter;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static Logger logger = LoggerFactory.getLogger(ConnectionFactory.class);
    private MysqlDataSource dataSource;


    private Properties getDataBaseProperties(String filename) {
        Properties properties = new Properties();
        try {
            /**
             * Pobieramy zawartość pliku za pomocą classloadera, plik musi znajdować się w katalogu ustawionym w CLASSPATH
             */
            InputStream propertiesStream = ConnectionFactory.class.getResourceAsStream(filename);
            if (propertiesStream == null) {
                throw new IllegalArgumentException("Can't find file: " + filename);
            }
            /**
             * Pobieramy dane z pliku i umieszczamy w obiekcie klasy Properties
             */
            properties.load(propertiesStream);
        } catch (IOException e) {
            logger.error("Error during fetching properties for database", e);
            return null;
        }

        return properties;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();

    }

    public ConnectionFactory() {
        this("/database.properties");

    }


    public ConnectionFactory(String filename) {
        Properties dataBaseProperties = getDataBaseProperties(filename);


        try {
            dataSource = new MysqlDataSource();
            dataSource.setServerName(dataBaseProperties.getProperty("pl.sda.jdbc.db.server"));
            dataSource.setDatabaseName(dataBaseProperties.getProperty("pl.sda.jdbc.db.name"));
            dataSource.setUser(dataBaseProperties.getProperty("pl.sda.jdbc.db.user"));
            dataSource.setPassword(dataBaseProperties.getProperty("pl.sda.jdbc.db.password"));
            dataSource.setPort(Integer.parseInt(dataBaseProperties.getProperty("pl.sda.jdbc.db.port")));
            dataSource.setServerTimezone("Europe/Warsaw");
            dataSource.setUseSSL(false);
            dataSource.setCharacterEncoding("UTF-8");
        } catch (SQLException e) {
            logger.error("Error during creating MysqlDataSource", e);

        }

    }


    public static void main(String[] args) {
        ConnectionFactory cf = new ConnectionFactory();
    }
}