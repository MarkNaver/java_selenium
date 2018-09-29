package Tools;

import java.io.File;

public class DriverPath {
    /**
     * 返回driver路径
     * @return
     */
    public static String getPath() {
        File file = new File(System.getProperty("user.dir") +
                File.separator + "src" +
                File.separator + "main" +
                File.separator + "java" +
                File.separator + "Tools");
        System.out.println(file);
        return String.valueOf(file);
    }

    /*
                String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir + "/logs/ExtenResult.html", true);

     */
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") +
                File.separator + "src" +
                File.separator + "main" +
                File.separator + "java" +
                File.separator + "Tools");
        System.out.println(file);
    }

}
