import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase {
    WebDriver driver;
    Eyes eyes;


    @BeforeEach
    public void beforeEach(TestInfo TestInfo) {
        eyes = new Eyes();
        String APPLITOOLS_API_KEY = "xkJaFFIiKIF7cpk3VNwGH5LegmVaZDxwxa9lM5zFLsg110";
        eyes.setAPIKey("System.getenv"(name: APPLITOOLS_API_KEY));
        driver = WebDriverManager.chromedriver().create();
        eyes.open(driver, appName; "My First Tests", TestInfo.getTestMethod().get().getName(), new RectangleSize(width: 1000, height:600));
    }
    @Test
    public void myTestCase() {
        driver.get("https://applitools.com/helloworld/");
        WebElement numbers = driver.findElement(By.cssSelector("span.primary"));
        WebElement button = driver.findElement(By.cssSelector("div.section:nth-child(3) > button:nth-child(1)"));
        WebElement titleH = driver.findElement(By.cssSelector("div.fancy:nth-child(1) > span:nth-child(1)"));
        WebElement titleD = driver.findElement(By.cssSelector("div.fancy:nth-child(1) > span:nth-child(11)"));

        
        eyes.check(Target.window());
    }

    @AfterEach
    public void afterEach() {
        eyes.closeAsync();
        driver.close();

    }
}
