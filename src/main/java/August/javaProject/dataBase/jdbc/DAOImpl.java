package August.javaProject.dataBase.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import August.javaProject.dataBase.DBException;
import org.springframework.beans.factory.annotation.Value;


public class DAOImpl {

        @Value( "${jdbc.url}" )
        protected String jdbcUrl;

        @Value( "${driverClass}" )
        protected String driverClass;

        @Value( "${database.user.name}" )
        protected String userName;

        @Value( "${database.user.password}" )
        protected String password;

        protected Connection getConnection() throws DBException {
            try{
                return DriverManager.getConnection(jdbcUrl, userName, password);
            } catch (SQLException e) {
                System.out.println("Exception while getting connection to database");
                e.printStackTrace();
                throw new DBException(e);
            }
        }

        protected void closeConnection(Connection connection) throws DBException {
            try {
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception while closing connection to database");
                e.printStackTrace();
                throw new DBException(e);
            }
        }

    }


