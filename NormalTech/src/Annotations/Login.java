package Annotations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends UserAccess {
	WebDriver driver;
	
	@BeforeMethod
	public void close() {
	System.setProperty("webdriver.chrome.driver","C:\\selenium 64 bit\\chromedriver.exe");


	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	driver.get("http://45.112.2.195:83/");
	
    driver.findElement(By.name("email")).sendKeys("demo@client7.com");
	driver.findElement(By.name("password")).sendKeys("Tech@123#");
	driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div/div/div[4]/center/button")).click();
	
}
	
	@Test
	public void main() throws InterruptedException {
		UserAccess u = new UserAccess();
		u.open();
	}
	@AfterMethod
	public void close1() {
		//driver.quit();
	}

}
