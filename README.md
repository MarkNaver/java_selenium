# java + selenium3 框架实践

## 工具及资源信息
* IDE: [Intellij IDEA](https://www.jetbrains.com/idea/) -> 2018.1

* 语言： [java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) -> JDK 1.8

* UI框架 [selenium](https://www.seleniumhq.org/download/) -> 3.13.0

* 测试框架 [testNG](https://www.yiibai.com/testng/) -> 6.14.3

* 操作系统： Mac、Windows

* 首版发布时间：2018 7.30

* 浏览器:Chrome、Firefox、IE

如有问题，请联系 : `tcwaily@me.com`


## 构想及步骤
#### 一、配置管理
* 使用testNg管理所有配置文件，如浏览器配置、账号，例如能根据使用者系统信息调用相应的浏览器
* 使用testNg调用多浏览器、多线程并行运行测试用例  -->> 100%
* 使用testNg和selenium grid搭建分布式测试平台

#### 二、WebDriver方法重写
* findelement()         -->>100%
* click()               -->>100%
* sendyes()             -->>100%
* 隐式等待、显式等待        -->>100%
* Log4j2 日志系统         -->>80%

#### 三、对象仓库
* 查找页面元素并组成页面对象仓库   -->>50%
* 在对象仓库中写入该对象可能使用的方法，比如click，sendkyes等方法 -->>50%
* 可以使用Execl管理页面元素，并使用Java读取Execl文件中的页面元素来组成对象仓库

#### 四、测试用例集
* 调用页面对象仓库组成所需功能的测试用例
* 在用例中使用testNg注解功能读取xml配置文件
* 使用testNg的xml文件管理所有测试用例集

#### 五、测试报告
* 定义测试报告内容
* 根据所测环境自动发送测试报告给相应测试人员、开发人员、项目经理等

#### 六、使用jenkins实现自动调用testNg
* 使用docker+jenkins实现手动或自动构建并自动化测试以及发送测试报告

## 总结：任重而道远！
