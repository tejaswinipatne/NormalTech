package RemianingScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.GetElementAttribute;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Send_RFQ_quatations2 {

	WebDriver driver;

	String campaign_id = null;
	 public static String vendor_id = null;
	@Test
	public void client() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium 64 bit\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("http://45.112.2.195:83/");
		driver.findElement(By.name("email")).sendKeys("demo@client7.com");



		driver.findElement(By.name("password")).sendKeys("Tech@123#");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div/div/div[4]/center/button")).click();

		driver.get("http://45.112.2.195:83/client/rfq-campaign/");
		Thread.sleep(3000);

		for (int i = 0; i <= 10; i++) {
			List<WebElement> clients = driver
					.findElements(By.xpath("//*[@id=\"RFQ_campaign_table\"]/tbody/tr['+i+']/td[1]/i[2]"));
			campaign_id = clients.get(i).getAttribute("data-id");

			if (campaign_id.equals("46")) {
				driver.findElement(By.xpath("//i[@data-id='" + campaign_id + "']")).click();

				for (int j = 1; j <= 5; j++) {
					List<WebElement> w = driver.findElements(
							By.xpath("//*[@id=\"vendor_table_" + campaign_id + "\"]/tbody/tr['+j+']/td[1]/input"));
					 vendor_id = w.get(j).getAttribute("data-vendor_id");
					if (vendor_id.equals("166")) {
						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@data-vendor_id='" + vendor_id + "']")).click();

						Thread.sleep(3000);
						WebElement ww = driver.findElement(By.xpath("//*[@id=\"RFQ_campaign_table\"]/tbody/tr[4]/td[1]/div[3]/div[3]/div[3]/div[2]/button"));
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].click();", ww);
//						driver.findElement(By.xpath(
//								"//*[@id=\"RFQ_campaign_table\"]/tbody/tr[2]/td[1]/div[3]/div[3]/div[3]/div[2]/button"))
//								.click();

					}
				}
			}

			System.out.println(vendor_id);
		}
	}
	
	
	
	
	@AfterTest
	public void vendor() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium 64 bit\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("http://45.112.2.195:83/");
		driver.findElement(By.name("email")).sendKeys("demo@vendor7.com");
		driver.findElement(By.name("password")).sendKeys("Tech@123#");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div/div/div[4]/center/button")).click();

		driver.get("http://45.112.2.195:83/vendor/vendor-rfq-campaign/");
		
		for(int k=0;k<=10;k++) {
		List<WebElement> vendor = driver.findElements(By.xpath("//*[@id=\"vendor_pending_campaign_table\"]/tbody/tr['+k+']/td[1]/i"));
		String ven= vendor.get(k).getAttribute("data-camp_id");
		if(ven.equals("42")) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//i[@data-camp_id='"+ven+"']")).click();
			
			WebElement w =driver.findElement(By.xpath("//*[@id=\"vendor_pending_campaign_table\"]/tbody/tr[1]/"
					+ "td[1]/div/div[3]/div[2]/div[2]/div[2]/table/tbody/tr/td[4]/div/button[1]"));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", w);
			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@id=\"vendor_table_173\"]/tbody/tr/td[2]/input")).sendKeys("25");
			driver.findElement(By.xpath("//*[@id=\"vendor_table_173\"]/tbody/tr/td[3]/input")).sendKeys("100");
			driver.findElement(By.xpath("//*[@id=\"vendor_pending_campaign_table\"]/tbody/tr[1]/"
					+ "td[1]/div/div[3]/div[2]/div[2]/div[2]/table/tbody/tr/td[4]/div/button[3]")).click();
			
			driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/input")).sendKeys("demo");
			driver.findElement(By.xpath("/html/body/div[5]/div/div[4]/div[2]/button")).click();
			
			
			

		}
		}
	}

	
	
	
	
}
