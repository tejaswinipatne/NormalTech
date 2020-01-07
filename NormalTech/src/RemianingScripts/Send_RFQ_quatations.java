package RemianingScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Send_RFQ_quatations {

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	ExtentHtmlReporter htmlreporter;

	String campaign_id = null;
	public static String vendor_id = null;

	@Test(dataProvider = "wordpress")
	public void client(String[] cols) throws InterruptedException {
		try {
			String f1 = "C:\\ExtentReports\\ABM_supp\\Send_RFQ_quotations.html";

			report = new ExtentReports(f1);
	
		System.setProperty("webdriver.chrome.driver", "C:\\selenium 64 bit\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		test = report.startTest("Exception");
		driver.get("http://18.222.10.190/");
		System.out.println(cols[4]);
		driver.findElement(By.name("email")).sendKeys(cols[4]);
		driver.findElement(By.name("password")).sendKeys(cols[5]);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div/div/div[4]/center/button")).click();

		driver.get("http://18.222.10.190/vendor/vendor-rfq-campaign/");

		Thread.sleep(3000);
		for (int k = 0; k <= 10; k++) {
			List<WebElement> vendor = driver
					.findElements(By.xpath("//*[@id=\"vendor_pending_campaign_table\"]/tbody/tr['+k+']/td[1]/i"));
			String ven = vendor.get(k).getAttribute("data-camp_id");
			if (ven.equals(cols[6])) {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//i[@data-camp_id='" + ven + "']")).click();

				WebElement w = driver.findElement(By.xpath("//*[@id=\"vendor_pending_campaign_table\"]/tbody/tr[1]/"
						+ "td[1]/div/div[3]/div[2]/div[2]/div[2]/table/tbody/tr/td[4]/div/button[1]"));

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", w);
				Thread.sleep(3000);

				driver.findElement(By.xpath("//*[@id=\"vendor_table_173\"]/tbody/tr/td[2]/input")).sendKeys(cols[7]);
				driver.findElement(By.xpath("//*[@id=\"vendor_table_173\"]/tbody/tr/td[3]/input")).sendKeys(cols[8]);
				driver.findElement(By.xpath("//*[@id=\"vendor_pending_campaign_table\"]/tbody/tr[1]/"
						+ "td[1]/div/div[3]/div[2]/div[2]/div[2]/table/tbody/tr/td[4]/div/button[3]")).click();

				driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/input")).sendKeys(cols[9]);
				driver.findElement(By.xpath("/html/body/div[5]/div/div[4]/div[2]/button")).click();

			}
		}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e);
			System.out.println(e);
		}

		finally {

			report.endTest(test);
			report.flush();
		}
	}

	@DataProvider(name = "wordpress")
	public Object[][] passdata() {
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\Trigen\\Downloads\\send_RFQ_quotes.xlsx");
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

 class testing extends Send_RFQ_quatations {
	
	public void row_data() {
		
	}
}