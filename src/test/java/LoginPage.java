import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	/*инициализируем драйвер*/
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	/*локаторs*/
	@FindBy(xpath = "//*[contains(@name,'SWEUserName')]")
	private WebElement loginField;
	
	@FindBy(xpath = "//*[contains(@name,'SWEPassword')]")
	private WebElement passwField;
	
	@FindBy(xpath = "//*[contains(@id,'s_swepi_22')]")
	private WebElement btnEnter;
	
	@FindBy(xpath = "//*[contains(@id,'tb_14')]")
	private WebElement btnSiteMap;
	
	@FindBy(xpath = "//a[@class='ui-tabs-anchor'][contains(.,'Потенциальные сделки')]")
	private WebElement btnPS;
	@FindBy(xpath = "//a[@class='siebui-ctrl-drilldown'][contains(.,'Мои потенциальные сделки')]")
	private WebElement btnMyPS;
	
	/*локаторs-значения*/
	public void inputLogin(String login) {loginField.sendKeys(login);}
	public void inputPassw(String passw) {passwField.sendKeys(passw);}
	
	public void clickBtnEnter() {btnEnter.click();}
	public void clickBtnSiteMap() {btnSiteMap.click();}
	public void clickBtnPS() {btnPS.click();}
	public void clickBtnMyPS() {btnMyPS.click();}
	
	
	
	

}