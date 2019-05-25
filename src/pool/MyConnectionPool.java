package pool;

import jdbc.utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MyConnectionPool implements DataSource {

    private List<Connection> connectionList = new ArrayList<>(20);

    /**
     * 连接池初始化
     */
    public MyConnectionPool(){
        for (int i = 0 ; i < 5 ; i ++){
            connectionList.add(JDBCUtils.getConnection());
        }
    }

    /**
     * 连接归还
     * @param conn
     */
    public void returnConn(Connection conn){
        connectionList.add(conn);
    }
    @Override
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        if(connectionList.size() == 0){
            for (int i = 0 ; i < 5 ; i ++){
                connectionList.add(JDBCUtils.getConnection());
            }
        }
        conn = connectionList.remove(0);
        return conn;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
