import org.junit.Test;
import org.mdurmus.kafka.MysqlConnector;
import org.mdurmus.kafka.ServerLog;

public class MysqlConnectorTest {

    @Test
    public void table() {
    }

    @Test
    public void insertTest() {
        ServerLog log = new ServerLog("date", "time", "info", "bayburt", "dayının yeri ");
        MysqlConnector connector = MysqlConnector.getConnector();
        connector.createTable();
        connector.insertLog(log);
    }
}