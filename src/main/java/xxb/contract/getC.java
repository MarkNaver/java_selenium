package xxb.contract;

import Tools.DriverPath;

import java.io.IOException;

public class getC {
    Class claz = this.getClass();
    String clazz = this.getClass().getName();
//
//    public static void lsls(String 发生了) {
//
//        System.out.println(发生了);
//    }
///Users/tcw/seleniumjava/src/main/java/xxb/contract

    public static void main(String[] args) throws IOException {
        System.out.println(DriverPath.getPath());
//        File[] list = DriverPath.getFiles(DriverPath.getPath(),"chrome");
//        System.out.println(list[1]);
//        System.out.println(System.getProperty("os.name"));
        String osname = System.getProperty("os.name");
        System.out.println(osname);
        if (osname.contains("Mac")) {
            System.out.println("是MAC");
        }
        if (osname.contains("Windows")) {
            System.out.println("是windows");
        }
    }
}
