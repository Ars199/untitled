import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
	public static LoginPage loginPage;
	public static WebDriver driver;

	@BeforeClass
	public static void setup() {

		System.setProperty("webdriver.chrome.driver", "D:\\atst\\resources\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		loginPage = new LoginPage(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://172.30.71.134/siebel/app/fins/rus");
	}

	@Test
	public void loginTest() {
		loginPage.inputLogin(ConfProperties.getProperty("login"));
		loginPage.inputPassw(ConfProperties.getProperty("passw"));
		loginPage.clickBtnEnter();
	}

	@Test
	public void siteMapTest() {
		loginPage.clickBtnSiteMap();
	}

	@AfterClass
	public static void tearDown() {
		driver.close();
	}
}