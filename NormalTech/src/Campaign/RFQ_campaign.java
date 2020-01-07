package Campaign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class RFQ_campaign {

	public static void main(String[] args) throws InterruptedException {
	

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\selenium 64 bit\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("http://192.168.20.103:8002/");

        
        driver.findElement(By.name("email")).sendKeys("suryakant.phalle@trigensoft.com");
        driver.findElement(By.xpath("//*[@id=\"id_password\"]")).sendKeys("Tech@123#");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div/div/div[4]/center/button")).click();
 
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"#\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"CampaignList\"]/a")).click();
        
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"centertext\"]/div/a[2]/button/i")).click();


        driver.findElement(By.xpath("//*[@class=\"content-group\"]/div[1]/div[1]/div/div/div/input")).sendKeys("RFQ camp");
        driver.findElement(By.xpath("//textarea[@id='id_description']")).sendKeys("test");
        driver.findElement(By.xpath("//*[@name=\"io_number\"]")).sendKeys("25abc");
        
      
        driver.findElement(By.className("multiselect-selected-text")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/form/fieldset/div[1]/div[4]/div/div/div/div/div/div/ul/li[2]/a/label")).click();
        driver.findElement(By.className("multiselect-selected-text")).click();
        
        
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/form/fieldset/div[1]/div[5]/div/div/div/div/div/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/form/fieldset/div[1]/div[5]/div/div/div/div/div/div/ul/li[2]/a/label")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/form/fieldset/div[1]/div[5]/div/div/div/div/div/div/button")).click();
        
        
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/form/fieldset/div[1]/div[6]/div/div/div/div/div[1]/div/button/span")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/form/fieldset/div[1]/div[6]/div/div/div/div/div[1]/div/ul/li[2]/a/label")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/form/fieldset/div[1]/div[6]/div/div/div/div/div[1]/div/button/span")).click();
      
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/form/fieldset/div[1]/div[6]/div/div/div/div/div[2]/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/form/fieldset/div[1]/div[6]/div/div/div/div/div[2]/div/ul/li[2]/a/label")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/form/fieldset/div[1]/div[6]/div/div/div/div/div[2]/div/button")).click();
        driver.findElement(By.xpath("//*[@name='job_title_function']")).sendKeys("HR, Tester");
        
       JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        
        
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/form/fieldset/div[1]/div[8]/div/div/div[1]/input[2]")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/form/fieldset/div[1]/div[8]/div/div/div[2]/div[1]/div/label/span")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/form/fieldset/div[1]/div[8]/div/div/div[2]/div[2]/button[2]")).click();
        driver.findElement(By.xpath("//*[@name='custom_question']")).clear();
        driver.findElement(By.xpath("//*[@name='custom_question']")).sendKeys("5");
        driver.findElement(By.name("target_q_name")).clear();
        driver.findElement(By.name("target_q_name")).sendKeys("150");
        
        WebElement wsss = driver.findElement(By.xpath("//*[@id=\"id_start_date\"]"));
		JavascriptExecutor jseee = (JavascriptExecutor) driver;
		jseee.executeScript("arguments[0].setAttribute('value','2019-12-19')", wsss);

		Thread.sleep(3000);
		WebElement wssss = driver.findElement(By.xpath("//*[@id=\"id_end_date\"]"));
		JavascriptExecutor jseeee = (JavascriptExecutor) driver;
		jseeee.executeScript("arguments[0].setAttribute('value','2019-12-25')", wssss);
		

		WebElement wsssss = driver.findElement(By.xpath("//*[@id=\"id_rfq_timer\"]"));
		JavascriptExecutor jseeeee = (JavascriptExecutor) driver;
		jseeeee.executeScript("arguments[0].setAttribute('value','20/12/2019 12:00')", wsssss);
     
        driver.findElement(By.xpath("//*[@id=\"rfq_campaign_form\"]/fieldset/div[1]/div[18]/div/div/div[1]/button")).click();
        
	}

}
