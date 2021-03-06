package BasePackage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ABM_Supp3 {

	
	WebDriver driver;

	@Test
	public void open(String[] cols) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium 64 bit\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://45.112.2.195:83/");
		driver.findElement(By.name("email")).sendKeys(cols[0]);
		driver.findElement(By.name("password")).sendKeys(cols[1]);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div/div/div[4]/center/button")).click();

		driver.get("http://45.112.2.195:83/client/assigned-campaign/");

		for (int i = 0; i <= 10; i++) {
			List<WebElement> w = driver
					.findElements(By.xpath("//*[@id=\"campaign_notebook_table\"]/tbody/tr['+i+']/td[2]"));
			String camp_id = w.get(i).getAttribute("camp_id");

			if (camp_id.equals(cols[2])) {
				Thread.sleep(3000);

				driver.findElement(By.xpath("//input[@data-camp_id='" + camp_id + "']")).click();// chcekbox
				driver.findElement(By.xpath("//*[@id=\"centertext\"]/div/div[1]/button")).click();// action button

				for (int j = 0; j <= 4; j++) {
					List<WebElement> f = driver.findElements(By.xpath(
							"/html/body/div[4]/div/div[2]/div/div/div[2]/div/div[1]/div/div/div[1]/ul/li['+j+']/div/span"));
					String list = f.get(j).getText();

					String demo = cols[3];
					if (list.equals(demo)) {
						switch (list) {
						case "ABM File":

							Thread.sleep(3000);
							driver.findElement(By.xpath("//*[@id=\"open_abm_modal\"]/span")).click();
							Thread.sleep(5000);
							WebElement upload_abm = driver.findElement(By.xpath("//*[@id=\"upload_abm_form\"]/label"));
							upload_abm.click();

							uploadFile("C:\\Users\\Trigen\\Downloads\\abm_file.csv");
							Thread.sleep(4000);
							driver.findElement(By.xpath("//*[@id=\"submit_bulk_abm\"]")).click();
							driver.findElement(By.xpath("/html/body/div[10]/div/div[4]/div/button")).click();

							break;

						case "Suppression File":
							Thread.sleep(3000);
							driver.findElement(By.xpath("//*[@id=\"open_suppression_modal\"]/span")).click();
							Thread.sleep(5000);
							WebElement upload_sup = driver.findElement(By.xpath("//*[@id=\"upload_supr_form\"]/label"));
							upload_sup.click();

							uploadFile("C:\\Users\\Trigen\\Downloads\\abm_file.csv");
							Thread.sleep(4000);
							driver.findElement(By.xpath("//*[@id=\"submit_bulk_suppression\"]")).click();
							driver.findElement(By.xpath("/html/body/div[11]/div/div[4]/div/button")).click();

							break;

						case "Bulk clone campaign":
							Thread.sleep(3000);
							driver.findElement(By.xpath("//*[@id=\"bulk_clone_camp\"]/span")).click();
							driver.findElement(By.xpath("/html/body/div[10]/div/div[4]/div/button")).click();

							break;

						case "Bulk Go Live":

							Thread.sleep(3000);
							driver.findElement(By.xpath("//*[@id=\"bulk_go_live\"]/span")).click();
							driver.findElement(By.xpath("/html/body/div[10]/div/div[4]/div/button")).click();
							break;

						}
					}

				}
			}
		}
	}

	public static void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public void uploadFile(String fileLocation) throws InterruptedException {
		try {
			Thread.sleep(3000);
			setClipboardData(fileLocation);
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	@DataProvider(name = "wordpress")
	public Object[][] passdata() {
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\Trigen\\Downloads\\ABM_Supp.xlsx");
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
