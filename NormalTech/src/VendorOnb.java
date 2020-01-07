import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VendorOnb {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;

				
			System.setProperty("webdriver.chrome.driver", "C:\\selenium 64 bit\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.get("http://192.168.20.103:8002/");

			    driver.findElement(By.name("email")).sendKeys("test@vendor1.com");
				driver.findElement(By.name("password")).sendKeys("Tech@123#");
				driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div/div/div[4]/center/button")).click();

				driver.get("http://192.168.20.103:8002/vendor/vendor-Bording/");
			// company info
		    driver.findElement(By.name("user_name")).clear();
			driver.findElement(By.name("user_name")).sendKeys("TestVendor");
			driver.findElement(By.name("contact")).clear();
			driver.findElement(By.name("contact")).sendKeys("35232");
			driver.findElement(By.name("website")).clear();
			driver.findElement(By.name("website")).sendKeys("www.test.com");
			driver.findElement(By.name("address_line1")).clear();
			driver.findElement(By.name("address_line1")).sendKeys("US");
			driver.findElement(By.name("address_line2")).clear();
			driver.findElement(By.name("address_line2")).sendKeys("US");
			driver.findElement(By.name("zip_code")).clear();
			driver.findElement(By.name("zip_code")).sendKeys("3323232");

			driver.findElement(By.xpath("//*[@id=\"country_error\"]/span[2]/span[1]/span")).click();
			WebElement w1 = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
			w1.sendKeys("China");
			w1.sendKeys(Keys.ENTER);

			driver.findElement(By.xpath("//*[@id=\"select2-state-container\"]")).click();
			WebElement w2 = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
			w2.sendKeys("Anhui");
			w2.sendKeys(Keys.ENTER);

			driver.findElement(By.xpath("//*[@id=\"city_error\"]/span/span[1]/span")).click();
			WebElement w3 = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
			w3.sendKeys("Bengbu");
			w3.sendKeys(Keys.ENTER);

			 JavascriptExecutor js = (JavascriptExecutor) driver;   
			 js.executeScript("window.scrollBy(0,1000)");
			 
			WebElement w =driver.findElement(By.xpath("//*[@id=\"vendor_error\"]/div/span/span[1]/span"));
			w.sendKeys("Email");
			Thread.sleep(3000);
			w.sendKeys(Keys.ENTER);
				
		
	    	WebElement w5 = driver.findElement(By.xpath("//*[@id=\"speciality_error\"]/div/span/span[1]/span/ul/li/input"));
			w5.sendKeys("Webinar");
			w5.sendKeys(Keys.ENTER);
			
			WebElement w6= driver.findElement(By.xpath("//*[@id=\"industry_error\"]/div/span/span[1]/span/ul/li/input"));
			w6.sendKeys("marketing");
			w6.sendKeys(Keys.ENTER);
			
			
	        driver.findElement(By.xpath("//*[@id=\"onboradingform\"]/div[3]/ul/li[2]/a")).click();
			
			// business card info
	        Thread.sleep(4000);
	        driver.findElement(By.name("primary_name")).clear();
			driver.findElement(By.name("primary_name")).sendKeys("Test");
			 driver.findElement(By.name("primary_directdial")).clear();
			driver.findElement(By.name("primary_directdial")).sendKeys("2121");
			 driver.findElement(By.name("primary_designation")).clear();
			driver.findElement(By.name("primary_designation")).sendKeys("HR");
			 driver.findElement(By.name("primary_email")).clear();
	      	driver.findElement(By.name("primary_email")).sendKeys("test@mail.com");

	      	 driver.findElement(By.name("secondary_name")).clear();
			driver.findElement(By.name("secondary_name")).sendKeys("demo");
			 driver.findElement(By.name("secondary_directdial")).clear();
			driver.findElement(By.name("secondary_directdial")).sendKeys("5213");
			 driver.findElement(By.name("secondary_designation")).clear();
			driver.findElement(By.name("secondary_designation")).sendKeys("2323");
			 driver.findElement(By.name("secondary_email")).clear();
			driver.findElement(By.name("secondary_email")).sendKeys("demo@mail.com");

			driver.findElement(By.xpath("//*[@id=\"onboradingform\"]/div[3]/ul/li[2]/a")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id=\"onboradingform-p-2\"]/div/div[2]/div[7]/div[1]/div[1]/label/span")).click();
			driver.findElement(By.xpath("//*[@id=\"onboradingform-p-2\"]/div/div[2]/div[7]/div[4]/div[1]/label/span")).click();
			driver.findElement(By.xpath("//*[@id=\"onboradingform-p-2\"]/div/div[2]/div[10]/div[3]/label/span")).click();
			driver.findElement(By.xpath("//*[@id=\"onboradingform-p-2\"]/div/div[2]/div[11]/div[1]/label/span")).click();
			
			driver.findElement(By.xpath("//*[@id=\"onboradingform-p-2\"]/div/div[3]/div[7]/div[3]/div[1]/label/span")).click();
			driver.findElement(By.xpath("//*[@id=\"onboradingform-p-2\"]/div/div[3]/div[8]/div[1]/div[1]/label/span")).click();
			driver.findElement(By.xpath("//*[@id=\"onboradingform\"]/div[3]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"onboradingform\"]/div[3]/ul/li[2]/a")).click();
			
	         //submit
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"onboradingform\"]/div[3]/ul/li[3]/a")).click();


	}

}
