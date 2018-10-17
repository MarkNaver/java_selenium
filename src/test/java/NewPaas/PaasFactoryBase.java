package NewPaas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @Author: tcwaily@me.com
 * @Description:
 * @Date: Created in 上午10:41 2018/9/30
 * @Modified By:
 */
public class PaasFactoryBase {

    private static final Logger log = LogManager.getLogger(PaasFactoryBase.class.getName());
    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'创建标准IT部件')]")
    private WebElement createPartsBtn;

    @FindBy(xpath = "//div[@class='header_container_v2']")
    private WebElement backListBtn;

    @FindBy(xpath = "(//a[contains(text(),'开通服务')])[1]")
    private WebElement createConnectorBtn;

//    @FindBy(xpath = "//div[@class='main_v2 product_list_container']//div[2]//div[2]//div[2]//div[1]//div[1]//a[1]")
    @FindBy(xpath = "(//a[contains(text(),'开通服务')])[2]")
    private WebElement createSafeHouseBtn;

    @FindBy(xpath = "(//a[contains(text(),'开通服务')])[3]")
    private WebElement createLvsBtn;

    @FindBy(xpath = "xpath=(//a[contains(text(),'开通服务')])[4]")
    private WebElement createHaProxyBtn;

    @FindBy(xpath = "xpath=(//a[contains(text(),'开通服务')])[5]")
    private WebElement createRedisBtn;

    @FindBy(xpath = "xpath=(//a[contains(text(),'开通服务')])[6]")
    private WebElement createMySqlBtn;

    @FindBy(xpath = "xpath=(//a[contains(text(),'开通服务')])[7]")
    private WebElement createPhpMyAdminBtn;

    //连接器
    @FindBy(css = "div.show_select_v2")
    private WebElement connectorSelectVdcBtn;//选择虚拟数据中心

    @FindBy(xpath = "//li[contains(text(),'中国大陆-北京-可用区C')]")
    private WebElement selectVdcListBtn;//此处需要优化 可公用


    @FindBy(xpath = "//div[@class='new_create_net_ip']//label")
    private WebElement clickPrivateIp;//点击选择私网

    @FindBy(className = "new_server_input_name")
    private WebElement inputServerName;//实例名称，可选

    @FindBy(xpath = "//a[contains(text(),'创建')]")
    private WebElement createBtn;//创建按钮，可公用


    //LVC
    @FindBy(xpath = "//div[contains(text(),'中国大陆-北京-可用区A')]")
    private WebElement lvcSelectVdcBtn;//lvs选择虚拟数据中心

    @FindBy(xpath = "//div[contains(text(),'1核2G')]")
    private WebElement c1g2Btn;//选择规格

    @FindBy(xpath = "//div[contains(text(),'2核4G')]")
    private WebElement c2g4Btn;

    @FindBy(xpath = "//div[contains(text(),'4核8G')]")
    private WebElement c4g8Btn;

    @FindBy(xpath = "//div[contains(text(),'其他')]")
    private WebElement othersBtn;

    @FindBy(xpath = "//div[contains(text(),'内网')]")
    private WebElement intranetBtn;

    @FindBy(xpath = "//div[contains(text(),'外网')]")
    private WebElement externalNetworkBtn;

}
