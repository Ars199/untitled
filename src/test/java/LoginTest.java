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

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get(ConfProperties.getProperty("chromedriver"));
		try {
			driver.get("https://172.30.71.134/siebel/app/fins/rus");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Server is down");
			driver.close();
		}
	}

	@Test
	public void loginTest() {
		loginPage.inputLogin(ConfProperties.getProperty("login"));
		loginPage.inputPassw(ConfProperties.getProperty("passw"));
		loginPage.clickBtnEnter();
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}