package Redis;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import redis.clients.jedis.Jedis;

import java.util.Properties;

public class JschRedis {
    private static String getRandomString(int length) {
        //随机字符串的随机字符库
        String KeyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        int len = KeyString.length();
        for (int i = 0; i < length; i++) {
            sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws JSchException {


        String host = "139.159.3.154"; //虚拟机ip
        String user = "root";//虚拟机用户名
        String password = "test123T";//虚拟机密码
        int port = 22; //ssh端口

        //redis服务器地址及端口
        String tunnelRemoteHost = "10.240.18.7";
        int tunnelRemotePort = 35618;

        JSch jSch = new JSch();
        Session session = jSch.getSession(user, host, port);
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.setTimeout(30000);
        session.connect(); //连接


        port = session.setPortForwardingL(0, tunnelRemoteHost, tunnelRemotePort);
        Jedis jedis = new Jedis("127.0.0.1", port);
        jedis.auth("OIHsi2hmunOCWQSz");
        int count = 100;
        for (int i = 0; i < count; i++) {
            //随机字符串写入key和value
            jedis.set(getRandomString(10), getRandomString(11));
        }
        session.disconnect();
    }


}
