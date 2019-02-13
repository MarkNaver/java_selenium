package mysql;
import JschConnection.JschRedis;
import org.w3c.dom.Element;

import java.util.Random;
import java.util.concurrent.TimeUnit;
/**
 * @Author: tcwaily@me.com
 * @Description:
 * @Date: Created in 下午5:21 2018/12/12
 * @Modified By:
 */
public class mysql_systems {

    //    long startTime;
//    private static long endTime;
    long duration;
    double seconds;


    public static void main(String[] args) throws InterruptedException {
//        long startTime = System.nanoTime();
//        System.out.println(startTime);
//        Thread.sleep(5866);
//        long endTime = System.nanoTime();
//        System.out.println(endTime);
//        long duration = endTime - startTime;
//        double seconds = (double)duration / 1000000000.0;
//        System.out.println(seconds + "秒");
        String[] b = {"男", "女", "保密"};
        Random random = new Random();
        int num = random.nextInt(3);
        System.out.println(b[num]);


        int un = 18 + (int)(Math.random()*43);
//        System.out.println(un);
//        System.out.println(JschRedis.);
    }

    private static void getD(Element element) {
        String string = element.getAttribute("value");
        System.out.println(string);
    }


}
