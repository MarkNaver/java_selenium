package JschConnection;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

import java.util.Properties;
import java.util.Random;

public class JschRedis {
    static String getRandomString(int length) {
        //随机字符串的随机字符库
        String KeyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        int len = KeyString.length();
        for (int i = 0; i < length; i++) {
            sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
        }
        return sb.toString();
    }

    static String getRandomGender() {
        //随机生成性别
        String[] gender = {"男", "女", "保密"};
        Random random = new Random();
        int num = random.nextInt(3);
        return gender[num];
    }

    static int getRandomAge() {
        //生成 “min <= 随机数 <= max ” 的随机数
        //int num = min + (int)(Math.random() * (max-min+1));
        return  18 + (int)(Math.random()*43);
    }

    static String getRandomCity() {
        String[] city = {"武汉", "宜昌", "北京", "上海", "天津", "杭州", "南京", "青岛", "成都", "重庆", "哈尔滨", "东京都"};
        Random random = new Random();
        int num = random.nextInt(12);
        return city[num];
    }

    static String getRandomEmail() {
        String[] Email = {"qq.com","126.com","163.com","live.com","me.com","gmail.com"};
        Random random = new Random();
        int num = random.nextInt(6);
        return getRandomString(10) + "@" + Email[num];
    }

    public static void main(String[] args) throws JSchException {


        String host = "139.159.3.2"; //虚拟机ip
        String user = "root";//虚拟机用户名
        String password = "test123T";//虚拟机密码
        int port = 22; //ssh端口

        //redis服务器地址及端口
        String tunnelRemoteHost = "10.241.12.6";
        int tunnelRemotePort = 35731;

        JSch jSch = new JSch();
        Session session = jSch.getSession(user, host, port);
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.setTimeout(30000);
        session.connect(); //连接

        System.out.println(session.getServerVersion());

        int port1 = session.setPortForwardingL(0, tunnelRemoteHost, tunnelRemotePort);
        Jedis jedis = new Jedis("127.0.0.1", port1);
        jedis.auth("woaini123789TCW");//没有密码为空
        int count = 1233333333;
//        try {
//
//            for (int i = 0; i < count; i++) {
//                //随机字符串写入key和value
//                jedis.set(getRandomString(10), getRandomString(11));
//            }
//        } catch (Exception e) {
//            jedis.set(getRandomString(10), getRandomString(11));
//            System.out.println(e);
//        }
        for (int i = 0; i < count; i++) {
            try {
                jedis.set("tcw" + getRandomString(10), getRandomString(11));

                System.out.println(111);
            } catch (JedisDataException f) {
                System.out.println("error");
                continue;
                //                jedis.get(getRandomString(10));
                //                continue;
            }
        }

//        for (int i = 0; i < count; i++) {
//            jedis.sadd("ly",getRandomString(10),getRandomString(10),getRandomString(10));
//            System.out.println(222);
//        }

//        for (int i = 0; i < count; i++) {
//            jedis.hset("myhash", getRandomString(5), getRandomString(10));
//        }
//        jedis.lpush("one", "a");
//        jedis.lpush("one", "b");
//        jedis.lpush("1", "c");
//        jedis.lpush("1", "d");
//        System.out.println(jedis.ping());
////        System.out.println(jedis.keys("*"));
//        List<String> list = jedis.lrange("one", 0, 3);
//        for (String aList : list) {
//            System.out.println(aList);
//        }
//        jedis.set("tcw", "ly1");
//        System.out.println(jedis.get("tcw"));
        session.disconnect();
    }




}
