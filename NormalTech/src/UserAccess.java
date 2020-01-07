import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UserAccess {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver;
		
		
		System.setProperty("webdriver.chrome.driver","C:\\selenium 64 bit\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("http://45.112.2.195:83/");
		
	    driver.findElement(By.name("email")).sendKeys("kiran.bhalerao@trigensoft.com");
		driver.findElement(By.name("password")).sendKeys("Tech@123#");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div/div/div[4]/center/button")).click();
		
		driver.get("http://45.112.2.195:83/client/user_and_groups/"); 
		
        Thread.sleep(4000);

		driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div/div[1]/div[2]/span/button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"lead_header\"]/div/div/div/div[2]/div/div/input")).sendKeys("TestGroup");
		driver.findElement(By.xpath("//*[@id=\"add_group\"]")).click();
		
		driver.findElement(By.xpath("/html/body/div[5]/div/div[4]/div/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"12\"]/div/label")).click();
		driver.findElement(By.xpath("//*[@id=\"76\"]/div/label")).click();
		driver.findElement(By.xpath("//*[@id=\"grp_access_form\"]/div[2]/button[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[5]/div/div[4]/div/button")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div/div[1]/div[2]/span/button[3]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"id_user_name\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"id_user_name\"]")).sendKeys("test1");
		driver.findElement(By.xpath("//*[@id=\"id_email\"]")).sendKeys("TEST@MAIL.COM");
		driver.findElement(By.xpath("//*[@id=\"id_password1\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"id_password1\"]")).sendKeys("Tech@123#");
		driver.findElement(By.xpath("//*[@id=\"id_password2\"]")).sendKeys("Tech@123#");
		
		Select s = new Select(driver.findElement(By.xpath("//*[@id=\"add_user\"]/div[1]/div[5]/div/select")));
		s.selectByVisibleText("TestGroup");
		
		driver.findElement(By.xpath("//*[@id=\"add_user\"]/div[2]/button[1]")).click();
		
}
}