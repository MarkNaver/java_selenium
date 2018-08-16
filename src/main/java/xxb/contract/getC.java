package xxb.contract;

import java.util.Map;

public class getC {
    public static void lsls(String 发生了) {
        System.out.println(发生了);
    }


    public static void main(String[] args) {
        lsls("fdsfs");
//        System.out.println(getChineseName());
        Map map = RandomDataCenter.getAddress();
        System.out.println(map.get("name"));
        System.out.println(map.get("email"));
        System.out.println(map.get("email"));
        System.out.println(map.get("email"));
        System.out.println(map.get("name"));
        System.out.println(RandomDataCenter.getAddress().get("email"));
        System.out.println(RandomDataCenter.getAddress().get("tel"));
        String string = RandomDataCenter.getAddress().get("tel");
        System.out.println(string);

    }
}
