import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class External_Internal_vendor {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium 64 bit\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("http://45.112.2.195:83");

        driver.findElement(By.name("email")).sendKeys("demo@client7.com");
        driver.findElement(By.xpath("//*[@id=\"id_password\"]")).sendKeys("Tech@123#");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div/div/div[4]/center/button")).click();
 
		driver.findElement(By.xpath("//*[@id=\"explore-vendors\"]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"VendorList\"]/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div/div/div[1]/div[1]/h1/button[2]")).click();
		
		driver.findElement(By.name("user_name")).sendKeys("TestExternal");
		driver.findElement(By.name("email")).sendKeys("TESTEXTERNAL@MAIL1.COM");
		driver.findElement(By.name("password1")).sendKeys("Tech@123#");
		driver.findElement(By.name("password2")).sendKeys("Tech@123#");

		Select s= new Select(driver.findElement(By.xpath("//*[@id=\"vendor_type\"]")));
		s.selectByVisibleText("Internal Vendor");
		
		driver.findElement(By.xpath("//*[@id=\"addvendor\"]/div/button[1]")).click();
	}

}
