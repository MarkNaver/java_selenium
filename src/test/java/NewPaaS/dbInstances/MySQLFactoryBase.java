package NewPaaS.dbInstances;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @Author: tcwaily@me.com
 * @Description:
 * @Date: Created in 下午2:34 2019/1/23
 * @Modified By:
 */
public class MySQLFactoryBase {
    @FindBy(linkText = "创建数据库服务")
    private WebElement createDBInstances;
}
