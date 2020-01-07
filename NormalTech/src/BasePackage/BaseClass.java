package BasePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		
		Reporter.log("**********session stated*********",true);
		System.setProperty("webdriver.chrome.driver","C:\\selenium 64 bit\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	    driver.get("http://192.168.20.103:8002/");
	    Reporter.log("**********application stated********",true);
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
