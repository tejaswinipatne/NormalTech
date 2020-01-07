package RemianingScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Remaining_scripts_dynamic.ExcelDataConfig;

public class Normal_campaigntype {

	@Test (dataProvider = "wordpress")
	public void openBrowser(String[] cols) throws InterruptedException {
	
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium 64 bit\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://18.222.10.190/");

		driver.findElement(By.name("email")).sendKeys(cols[0]);
		driver.findElement(By.name("password")).sendKeys(cols[1]);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div/div/div[4]/center/button")).click();
		
		driver.findElement(By.xpath("//*[@id=\"campaign\"]/a/span")).click();
		
		for(int i =0; i<=6;i++) {
		List<WebElement> elements= driver.findElements(By.xpath("//*[@id=\"campaign\"]/ul/li['+i+']"));
		String e =elements.get(i).getAttribute("id");
		System.out.println(e);
		if(e.equals("AssignedCampaign")) {
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id=\""+e+"\"]/a")).click();
			
		}
		
		
		}
		
	}
	@DataProvider(name = "wordpress")
	public Object[][] passdata() {
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\Trigen\\Downloads\\notification.xlsx");
		int rowCount = config.getRowCount(0);

		int colCount = config.getColCount(0);

		Object[][] data = new Object[rowCount + 1][colCount + 1];

		for (int rows = 1; rows < rowCount; rows++) {

			for (int cols = 0; cols < colCount; cols++) {
				// System.out.println(colCount);

				data[rows][cols] = config.getData(0, rows, cols);

			}

		}

		return data;

	}
	

}
