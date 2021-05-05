import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	public static LoginPage loginPage;
	public static WebDriver driver;

	@BeforeTest
	public static void setup() {

		System.setProperty("webdriver.chrome.driver", "D:\\atst\\resources\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		loginPage = new LoginPage(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://172.30.71.134/siebel/app/fins/rus");
		
		
	}

	@Test
	public void loginTest() {
		
		loginPage.inputLogin(ConfProperties.getProperty("login"));
		loginPage.inputPassw(ConfProperties.getProperty("passw"));
		loginPage.clickBtnEnter();
		
	}

	/*@Test
	public void t4530Test() {
		//loginPage.clickBtnSiteMap();
		loginPage.clickBtnPS();
		loginPage.clickBtnMyPS();
		

	}*/

	@AfterTest
	public static void tearDown() {
		loginPage.driver.close();
	}
}