package Annotations;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Create_campagin {
	WebDriver driver;
	
	@AfterTest
	public void campaign() throws InterruptedException {
		
		
		
        driver.findElement(By.xpath("//*[@id=\"campaign\"]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"CompleteCampaign\"]/a")).click();
   
       // driver.findElement(By.xpath("//*[@id=\"PendingCampaign\"]/a")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"centertext\"]/div/a/button/i")).click();
     
        driver.findElement(By.xpath("//*[@class=\"content-group\"]/div[1]/div[1]/div/div/div/input")).sendKeys("assigned camp");
        driver.findElement(By.xpath("//textarea[@id='id_description']")).sendKeys("test");
        driver.findElement(By.xpath("//*[@name=\"io_number\"]")).sendKeys("25abc");
        
        Select s = new Select(driver.findElement(By.id("id_type")));
        s.selectByValue("2");
        
        driver.findElement(By.className("multiselect-selected-text")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/form/fieldset/div[1]/div[5]/div/div/div/div/div/div/ul/li[2]/a/label")).click();
        driver.findElement(By.className("multiselect-selected-text")).click();
        
        driver.findElement(By.name("cpl_name")).sendKeys("50");
        driver.findElement(By.name("target_q_name")).sendKeys("100");
        WebElement wsss = driver.findElement(By.xpath("//*[@id=\"id_start_date\"]"));
        
		JavascriptExecutor jseee = (JavascriptExecutor) driver;
		jseee.executeScript("arguments[0].setAttribute('value','2019-11-19')", wsss);

		Thread.sleep(4000);
		WebElement wssss = driver.findElement(By.xpath("//*[@id=\"id_end_date\"]"));
		JavascriptExecutor jseeee = (JavascriptExecutor) driver;
		jseeee.executeScript("arguments[0].setAttribute('value','2019-11-25')", wssss);

     
        driver.findElement(By.xpath("//*[@id=\"container_vendor_type\"]/div/div[1]/div/label")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/form/fieldset/div[1]/div[11]/div/div/div[1]/button")).click();
        
    
        
       
        
	}

}
