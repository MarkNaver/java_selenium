package Tools;

import java.io.File;

public class DriverPath {
    /**
     * 返回driver路径
     *
     * @return
     */
    public static String getPath() {
        File file = new File(System.getProperty("user.dir") +
                File.separator + "src" +
                File.separator + "main" +
                File.separator + "java" +
                File.separator + "Tools");
        return String.valueOf(file);
    }
}
