import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClientOnb {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;

			System.setProperty("webdriver.chrome.driver","C:\\selenium 64 bit\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
			driver.get("http://192.168.20.103:8002/");
			
			driver.findElement(By.name("email")).sendKeys("test@client1.com");
			driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("Tech@123#");
			driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();

			driver.get("http://192.168.20.103:8002/client/client-Bording/");
			driver.findElement(By.name("user_name")).clear();
			driver.findElement(By.name("user_name")).sendKeys("ClientTest");
			driver.findElement(By.name("contact")).clear();
			driver.findElement(By.name("contact")).sendKeys("8541");
			driver.findElement(By.name("website")).clear();
			driver.findElement(By.name("website")).sendKeys("www.client.com");
			driver.findElement(By.id("alternate_number")).clear();
			driver.findElement(By.id("alternate_number")).sendKeys("1212");
			driver.findElement(By.name("address_line1")).clear();
			driver.findElement(By.name("address_line1")).sendKeys("US");
			driver.findElement(By.name("address_line2")).clear();
			driver.findElement(By.name("address_line2")).sendKeys("US");
			
			
			driver.findElement(By.xpath("//*[@id=\"select2-country-container\"]")).click();
	    	WebElement w = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
	    	w.sendKeys("China");
	    	w.sendKeys(Keys.ENTER);
			
		   driver.findElement(By.xpath("//*[@id=\"select2-state-container\"]")).click();
			WebElement w1= driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
			w1.sendKeys("Anhui");
			w1.sendKeys(Keys.ENTER);

	                          
			driver.findElement(By.xpath("//*[@id=\"select2-cities-container\"]")).click();
			WebElement w2= driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
			w2.sendKeys("Bengbu");
			w2.sendKeys(Keys.ENTER);

			driver.findElement(By.xpath("//*[@id=\"zip_code\"]")).clear();
		    driver.findElement(By.xpath("//*[@id=\"zip_code\"]")).sendKeys("12412");
			
			
			driver.findElement(By.xpath("//*[@id=\"onboradingform\"]/div[3]/ul/li[2]/a")).click();
			Thread.sleep(4000);
			driver.findElement(By.name("primary_name")).clear();							
			driver.findElement(By.name("primary_name")).sendKeys("demo");
			driver.findElement(By.name("primary_directdial")).clear();
			driver.findElement(By.name("primary_directdial")).sendKeys("1213212");
			driver.findElement(By.name("primary_designation")).clear();
			driver.findElement(By.name("primary_designation")).sendKeys("HR");
			driver.findElement(By.name("primary_email")).clear();
			driver.findElement(By.name("primary_email")).sendKeys("demo@mail.com");
			driver.findElement(By.name("secondary_name")).clear();
			driver.findElement(By.name("secondary_name")).sendKeys("test");
			driver.findElement(By.name("secondary_directdial")).clear();
			driver.findElement(By.name("secondary_directdial")).sendKeys("1324");
			driver.findElement(By.name("secondary_designation")).clear();
			driver.findElement(By.name("secondary_designation")).sendKeys("CTO");
			driver.findElement(By.name("secondary_email")).clear();
			driver.findElement(By.name("secondary_email")).sendKeys("test@mail.com");
			
			driver.findElement(By.xpath("//*[@id=\"onboradingform\"]/div[3]/ul/li[2]/a")).click();

			
			driver.findElement(By.xpath("//*[@id=\"onboradingform\"]/div[3]/ul/li[2]/a")).click();
			
			Thread.sleep(4000);
		    driver.findElement(By.xpath("//*[@id=\"onboradingform\"]/div[3]/ul/li[3]/a")).click();       
			

	}

}
