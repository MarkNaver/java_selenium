package JschConnection;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 * @Author: tcwaily@me.com
 * @Description:
 * @Date: Created in 下午2:41 2019/1/21
 * @Modified By:
 */
public class JschMySQL {
    private static int lport = 32088;//本地端口
    private static String rhost = "10.241.12.6";//远程MySQL服务器
    private static int rport = 32088;//远程MySQL服务端口


    private static void go() {
        String host = "139.159.3.2"; //虚拟机ip
        String user = "root";//虚拟机用户名
        String password = "test123T";//虚拟机密码
        int port = 22; //ssh端口
        try {
            JSch jSch = new JSch();
            Session session = jSch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            System.out.println(session.getServerVersion());
            System.out.println("-----连接虚拟机成功------");
            session.setPortForwardingL(lport, rhost, rport);
            sql();
            session.disconnect();
            System.out.println("-------断开连接-------");
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void sql() throws SQLException {

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //创建连接
        Connection connection1 = null;
        try {
            connection1 = DriverManager.getConnection("jdbc:mysql://localhost:32088/test?characterEncoding=utf8", "admin", "j0Rf1JrEqRf2lWsX");
            String str = "str123";
            String insertSql = "INSERT INTO " +
                    "`test`.`user`(`name`, `email`, `password`,`city`,`age`,`create_time`,`gender`) " +
                    "VALUES " +
                    "(?,?,?,?,?,?,?);";
            int count = 11555;
            PreparedStatement sql1 = connection1.prepareStatement(insertSql);

            System.out.println("开始插入数据");
            for (int i = 1; i < count; i++) {
                java.util.Date date = new java.util.Date();
                Timestamp str11 = new Timestamp(date.getTime());
                sql1.setString(1, JschRedis.getRandomString(10));
                sql1.setString(2, JschRedis.getRandomEmail());
                sql1.setString(3, JschRedis.getRandomString(12));
                sql1.setString(4, JschRedis.getRandomCity());
                sql1.setInt(5, JschRedis.getRandomAge());
                sql1.setTimestamp(6, str11);
                sql1.setString(7, JschRedis.getRandomGender());
//                System.out.println(JschRedis.getRandomGender());
                sql1.executeUpdate();
                System.out.println("插入第" + i + "条数据成功");
            }
//            String sql = "SELECT * FROM `user` WHERE  NAME  LIKE 't%';";
//            rs = st.executeQuery(sql);
//            while (rs.next()) {
//                System.out.println(222);
//                System.out.println(rs.getString(4));
//                System.out.println(1111);
//            }
            sql1.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sqlexception");
        } finally {
            assert false;
            connection1.close();

        }
    }

    public static void main(String[] args) {
        go();
//        sql();

    }
}
