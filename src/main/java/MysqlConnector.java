import java.sql.*;

public class MysqlConnector {

    public static Connection con = null;
    public static MysqlConnector connector = new MysqlConnector();
    private final String user = "root";
    private final String password = "";
    private final String host = "localhost";
    private final String port = "3306";
    private final String databaseName = "log";
    private final String tableName = "data";
    private final String url = "jdbc:mysql://" + host + ":" + port + "/" + databaseName;


    private MysqlConnector() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conncetion başarılı");

        } catch (SQLException e) {
            System.out.println("Connection çalışmadı");
        }
    }

    public static MysqlConnector getConnector() {
        return connector;
    }

    public void createTable() {
        String table = "CREATE TABLE IF NOT EXISTS  " + tableName +
                " (CreatedTime VARCHAR(255), " +
                " LogLevel VARCHAR(255), " +
                " CityName  VARCHAR(255)," +
                " Detail  VARCHAR(255))";
        try {
            Statement statement = con.createStatement();
            statement.execute(table);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertLog(ServerLog log) {


        String sql = "insert into " + tableName +
                "(CreatedTime, LogLevel,CityName,Detail) values (?,?,?,?)";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, log.getTimestamp());
            statement.setString(2, log.getLogLevel());
            statement.setString(3, log.getCityName());
            statement.setString(4, log.getDetail());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
