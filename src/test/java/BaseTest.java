import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {
    WebDriver driver;
    final static Logger logger = Logger.getLogger(TestAll.class);


    @BeforeAll
    public void setUp(){
        logger.info("Test Başlatıldı");
        System.setProperty("webdriver.chrome.driver","H:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
    }

    @AfterAll
    public void tearDown(){
        logger.info("Test Sonlandı");
    }
}
