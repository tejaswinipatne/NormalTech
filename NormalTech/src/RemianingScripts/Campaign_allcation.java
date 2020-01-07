package RemianingScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Campaign_allcation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\selenium 64 bit\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		driver.get("http://18.222.10.190/");
		driver.findElement(By.name("email")).sendKeys("krb0036@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Tech@123#");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div/div/div[4]/center/button")).click();	
		driver.get("http://18.222.10.190/client/pending-campaign/");

		Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"campaign_notebook_table\"]/tbody/tr[1]/td[4]/ul/li[1]/a/i")).click();
		driver.findElement(By.xpath("//*[@id=\"lead170\"]")).sendKeys("12");
	
		
		WebElement w = driver.findElement(By.xpath("//*[@id=\"submit_all_data\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", w);
		
		Thread.sleep(3000);
    	driver.findElement(By.xpath("/html/body/div[5]/div/div[4]/div/button")).click();

	}

}
