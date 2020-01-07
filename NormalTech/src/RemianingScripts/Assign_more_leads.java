package RemianingScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assign_more_leads {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\selenium 64 bit\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		driver.get("http://45.112.2.195:83/");
		driver.findElement(By.name("email")).sendKeys("demo@client7.com");
		driver.findElement(By.name("password")).sendKeys("Tech@123#");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div/div/div[4]/center/button")).click();
		driver.get("http://45.112.2.195:83/client/live-campaign/");

		for (int i = 0; i <= 10; i++) {
			List<WebElement> camp_id = driver
					.findElements(By.xpath("//*[@id=\"campaign_notebook_table\"]/tbody/tr['+i+']/td[2]"));
			String id = camp_id.get(i).getAttribute("camp_id");

			if (id.equals("84")) {

				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@href=\"/client/campaigndesc/" + id + "\"]")).click();

				for (int k = 0; k <= 5; k++) {
					List<WebElement> ven1 = driver.findElements(
							By.xpath("//*[@id=\"client_vendor_campaign_datatable\"]/tbody/tr['+k+']/td[1]/a"));
					String ven_names = ven1.get(k).getText();
					System.out.println(ven_names);
					
					if (ven_names.contains("VendorExteranl")) {
						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@id=\"client_vendor_campaign_datatable\"]/tbody/tr[' + k + ']/td[7]/ul/li")).click();

						for (int j = 0; j <= 6; j++) {
							List<WebElement> l = driver.findElements(By.xpath("//*[@id=\"client_vendor_campaign_datatable\"]/tbody/tr['+k+']/td[7]/ul/li/ul/li['+j+']/a"));
							String list = l.get(j).getText();
							

							String demo = "Pull Out Leads";

							if (demo.equals(list)) {

								switch (list) {
								case "Pause":
									Thread.sleep(3000);
									driver.findElement(By.partialLinkText(demo)).click();
									driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/input"))
											.sendKeys("Paused demo");
									Thread.sleep(3000);

									driver.findElement(By.xpath("/html/body/div[5]/div/div[4]/div[2]/button")).click();
									break;

								case "Pull Out Leads":
									Thread.sleep(3000);
									driver.findElement(By.partialLinkText(demo)).click();
									driver.findElement(By.xpath("//*[@id=\"lead\"]")).sendKeys("100");
									Thread.sleep(3000);
									driver.findElement(By.xpath("//*[@id=\"save_leads_action\"]")).click();

								case "Cancel Assigned Leads":
									Thread.sleep(3000);
									driver.findElement(By.partialLinkText(demo)).click();
									driver.findElement(By.xpath("/html/body/div[5]/div/div[4]/div[2]/button")).click();

								case "Assign More Leads":
									Thread.sleep(3000);
									driver.findElement(By.partialLinkText(demo)).click();

									driver.findElement(By.xpath("//*[@id=\"cpl_val\"]")).sendKeys("25");
									driver.findElement(By.xpath("//*[@id=\"lead\"]")).sendKeys("500");
									driver.findElement(By.xpath("//*[@id=\"save_leads_action\"]")).click();

								}

							}

						}
					}
				
			}

		}

		}
	}
}


