package NewPaaS;

import com.common.BrowserEngine;
import com.common.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

/**
 * @Author: tcwaily@me.com
 * @Description:
 * @Date: Created in 上午10:41 2018/9/30
 * @Modified By:
 */
public class PaaSBaseFactoryBase extends Config {
    private WebDriver driver ;

    private BrowserEngine browserEngine = new BrowserEngine();

    private static final Logger log = LogManager.getLogger(PaaSBaseFactoryBase.class.getName());


    @FindBy(id = "txtUserName")
    private WebElement txtUserName;


    @FindBy(id = "txtUserPwd")
    private WebElement txtUserPwd;

    @FindBy(id = "id_captcha_0")
    private WebElement imgCodeValueId;

    @FindBy(id = "txtVilCode")
    private WebElement txtVilCode;

    @FindBy(id = "btnLogin")
    private WebElement btnLogin;


    /**
     * 登录用例，可通用
     * @param userName
     * @param userPwd
     * @throws InterruptedException
     * @throws IOException
     */
    void setLogin(String userName, String userPwd) throws InterruptedException, IOException {
        txtUserName.sendKeys(userName);

        txtUserPwd.sendKeys(userPwd);
        txtVilCode.sendKeys(Config.getImgCode(imgCodeValueId.getAttribute("value")));
        btnLogin.click();
        sleep();
    }

    @FindBy(linkText = "数据库服务")
    private WebElement DBServer;

    void setDBServer() throws InterruptedException {
        DBServer.click();
        sleep();
    }
    @FindBy(linkText = "负载均衡服务")
    private WebElement loadBalance;

    void setLoadBalance() throws InterruptedException {
        loadBalance.click();
        sleep();
    }

    @FindBy(id = "frame_content")
    private WebElement frame_content;

    public void setFrame_content() {
        frame_content.isEnabled();
    }


    @FindBy(linkText = "创建数据库服务")
    private WebElement createDBInstances;

    public void setCreateDBInstances() throws InterruptedException {
        createDBInstances.click();
        sleep();
    }

    @FindBy(linkText = "创建负载均衡服务")
    private WebElement createLoadBalances;

    void setCreateLoadBalances() throws InterruptedException {
        sleep();
        createLoadBalances.click();
        sleep();
        log.info("点击创建负载均衡服务");
    }

    @FindBy(xpath = "//div[@class='header_container_v2']")
    private WebElement backListBtn;

    public void setBackListBtn() {
        backListBtn.click();
        log.info("点击返回列表按钮");
    }



    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='连接器'])[1]/following::a[1]")
//    @FindBy(xpath = "(//a[contains(text(),'开通服务')])[3]")
    private WebElement subscribeConnectServiceBtn;

    void setSubscribeConnectServiceBtn() {
        subscribeConnectServiceBtn.click();
        log.info("点击创建连接器");
    }

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='私网'])[1]/following::span[1]")
    private WebElement privateNetwork1;

    void setPrivateNetwork1() {
        privateNetwork1.click();
        log.info("选择了第一个私网");
    }

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='私网'])[1]/following::span[4]")
    private WebElement privateNetwork2;

    void setPrivateNetwork2() {
        privateNetwork2.click();
        log.info("选择了第二个私网");
    }

    @FindBy(css = "input.new_server_input_name")
    private WebElement instanceName;

    void setInstanceName() {
        instanceName.click();
        instanceName.clear();
//        sleep();
        instanceName.sendKeys("LC-"+randomStr().get(1));
    }

    @FindBy(xpath = "//a[contains(text(),'创建')]")
    private WebElement createBtn;

    void setCreateBtn() {
        createBtn.click();
    }


    @FindBy(css = "div.creating")
    private WebElement serverCreatingStatus;

    /**
     * @return
     */
    public String setCreatingStatus() {
        return serverCreatingStatus.getText();
    }

    @FindBy(css = "div.deleting")
    private WebElement serverDelStatus;

    public String setDelStatus() {
        return serverDelStatus.getText();
    }



    //数据库服务
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='MySQL'])[1]/following::a[1]")
    private WebElement subscribeMySQLServiceBtn;

    public void setSubscribeMySQLServiceBtn() throws InterruptedException {
        subscribeMySQLServiceBtn.click();
        Thread.sleep(3000);
        log.info("点击创建MySQL服务");
    }

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='PhpMyAdmin'])[1]/following::a[1]")
    private WebElement subscribePhpMyAdminServiceBtn;

    public void setSubscribePhpMyAdminServiceBtn() {
        subscribePhpMyAdminServiceBtn.click();
        log.info("点击创建phpMyAdmin服务");
    }

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Redis'])[1]/following::a[1]")
    private WebElement subscribeRedisServiceBtn;

    public void setSubscribeRedisServiceBtn() {
        subscribeRedisServiceBtn.click();
        log.info("点击创建Redis服务");
    }


    //列表页面
    /**
     * 列表第一个元素
     */
    @FindBy(xpath = "//div[@id='InPaaS']/div/div[7]/div/div/div/div/div/p")//第一个名称
    private WebElement name_one;
    @FindBy(xpath = "//div[@id='InPaaS']/div/div[7]/div/div/div[5]/div/div/p")//运行状态
    private WebElement serverStatus_one;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='区域：'])[1]/following::i[1]")//区域
    private WebElement region_one;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='所属数据中心：'])[2]/following::i[1]")//所属VDC
    private WebElement OwnVdc_one;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='类型：'])[1]/following::i[1]")//类型
    private WebElement serverType_one;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='网络模式：'])[1]/following::i[1]")//网络模式
    private WebElement networkMode_one;
    @FindBy(xpath = "//div[@id='InPaaS']/div/div[7]/div/div/div/div[2]/ul/li[7]/i")//服务IP
    private WebElement serverIP_one;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='创建时间：'])[1]/following::i[1]")//创建时间
    private WebElement createTime_one;
    @FindBy(xpath = "//div[@id='InPaaS']/div/div[7]/div/div/div/div[4]/ul/li/a/span[2]")//左下角第一个btn
    private WebElement leftOneBtn_one;
    @FindBy(xpath = "/div[@id='InPaaS']/div/div[7]/div/div/div/div[4]/ul/li[2]/a/span[2]")//左下角第二个配置
    private WebElement leftTwoBtn_one;
    @FindBy(xpath = "//div[@id='InPaaS']/div/div[7]/div/div/div/div[4]/ul/li[3]/a/span[2]")//更多按钮
    private WebElement moreBtnBase_one;

    WebElement perform_more() {
        return this.browserEngine.findMyElement(moreBtnBase_one);//return元素
    }

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='更多'])[1]/following::span[2]")//更多按钮1
    private WebElement moreBtn1;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='更多'])[1]/following::span[4]")//更多按钮2
    private WebElement moreBtn2;

    String getBtnOneText() {
        return name_one.getText();
    }

//    @FindBy

    /**
     * 列表第二个元素
     */
    @FindBy(xpath = "//div[@id='InPaaS']/div/div[7]/div/div/div[2]/div/div/p")//第二个名称
    private WebElement name_two;
    @FindBy(xpath = "//div[@id='InPaaS']/div/div[7]/div/div/div[2]/div/div/div")//运行状态
    private WebElement serverStatus_two;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='区域：'])[2]/following::i[1]")//区域
    private WebElement region_two;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='所属数据中心：'])[3]/following::i[1]")//所属vdc
    private WebElement OwnVdc_two;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='类型：'])[2]/following::i[1]")//类型
    private WebElement serverType_two;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='网络模式：'])[2]/following::i[1]")//网络模式
    private WebElement networkMode_two;
    @FindBy(xpath = "//div[@id='InPaaS']/div/div[7]/div/div/div[2]/div[2]/ul/li[7]/i")//服务IP
    private WebElement serverIP_two;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='创建时间：'])[2]/following::i[1]")//创建时间
    private WebElement createTime_two;
    @FindBy(xpath = "//div[@id='InPaaS']/div/div[7]/div/div/div[2]/div[4]/ul/li/a/span[2]")//后端服务器配置
    private WebElement serverConfiguration_two;
    @FindBy(xpath = "//div[@id='InPaaS']/div/div[7]/div/div/div[2]/div[4]/ul/li[2]/a/span[2]")//策略配置
    private WebElement policyConfiguration_two;
    @FindBy(xpath = "//div[@id='InPaaS']/div/div[7]/div/div/div[2]/div[4]/ul/li[3]/a/span[2]")//更多按钮
    private WebElement moreBtnBase_two;
    @FindBy(xpath = "//div[@id='InPaaS']/div/div[7]/div/div/div[2]/div[4]/ul/li[3]/div/a/span[2]")//下拉第一个按钮-监控信息
    private WebElement monitoringInfo_two;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='监控信息'])[2]/following::span[2]")//下拉第二个按钮终止实例
    private WebElement terminationInstance_two;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='提示'])[2]/following::span[2]")//删除弹窗确认按钮
    private WebElement confirmDeletion_two;
    @FindBy(xpath = "//div[@id='InPaaS']/div/div[6]/div/div/div[2]/div[2]/span[2]")//删除弹窗取消按钮
    private WebElement Undelete_two;
    String getBtnTwoText() {
        return name_two.getText();
    }

    /**
     * 列表第三个元素
     */
//    @FindBy(xpath = "//div[@id='InPaaS']/div/div[7]/div/div/div/div/div/p")//第三个名称
//
//
//
//    @FindBy(xpath = "//div[@id='InPaaS']/div/div[7]/div/div/div[4]/div/div/p")//第四个名称
//
//    @FindBy(xpath = "//div[@id='InPaaS']/div/div[7]/div/div/div[5]/div/div/p")//第五个名称
//



    //负载均衡服务
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='HaProxy'])[1]/following::a[1]")
    private WebElement subscribeHaProxyServerBtn;

    public void setSubscribeHaProxyServerBtn() {
        subscribeHaProxyServerBtn.click();
        log.info("点击创建HaProxy服务");
    }

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='loadbalances'])[1]/following::a[1]")
    private WebElement subscribeLVS;

    public void setSubscribeLVS() {
        subscribeLVS.click();
        log.info("创建LVS服务");
    }


    //连接器
    @FindBy(css = "div.show_select_v2")
    private WebElement connectorSelectVdcBtn;//选择虚拟数据中心

    void setConnectorSelectVdcBtn() throws InterruptedException {
        sleep();
        connectorSelectVdcBtn.click();
        sleep();
        log.info("选择虚拟数据中心");
    }

    @FindBy(xpath = "//li[1]")//北京A
    private WebElement selectVdcListBtnBeijingA;//此处需要优化 可公用

    public void setSelectVdcListBtnBeijingA() {
        selectVdcListBtnBeijingA.click();
        log.info("选择了北京A节点");
    }

    @FindBy(xpath = "//li[3]")//北京C
    private WebElement selectVdcListBtnBeijingC;//此处需要优化 可公用

    void setSelectVdcListBtnBeijingC() throws InterruptedException {
        selectVdcListBtnBeijingC.click();
        sleep();
        log.info("选择了北京C节点");
    }

    @FindBy(xpath = "//li[7]")//无锡
    private WebElement selectVdcListBtnWuXi;//此处需要优化 可公用

    public void setSelectVdcListBtnWuXi() {
        selectVdcListBtnWuXi.click();
        log.info("选择了无锡节点");
    }



    @FindBy(xpath = "//div[@class='new_create_net_ip']//label")
    private WebElement clickPrivateIp;//点击选择私网

    @FindBy(className = "new_server_input_name")
    private WebElement inputServerName;//实例名称，可选

//    @FindBy(xpath = "//a[contains(text(),'创建')]")
//    private WebElement createBtn;//创建按钮，可公用


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
