package DDT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CRMLoginExcel {
	
	WebDriver driver;
	
	@Test(dataProvider="TestData")
	
	public void logintoCRM(String UserName, String Password) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\JAVALEARN\\filewriting\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		driver.get("https://classic.freecrm.com/index.html");	
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(UserName);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);	
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(3000);
		String maintitle = driver.getTitle();
		System.out.println(maintitle);	
		Assert.assertTrue(driver.getTitle().contains("CRMPRO - CRM software for  relationship management, sales, and support."));		
		System.out.println("page can be able to verify successfully");
		
		
	}
	
	@AfterMethod	
	public void teardown() {		
		driver.quit();
		driver.close();
	}
	@DataProvider(name="TestData")	
	public Object[][] passdata(){
		
		ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\Dell\\eclipse-workspace\\DrivenFrameWork\\TestData\\inputData.xlsx");
	
		int rows = excel.getrowcount(0);	
		Object[][] data = new Object[rows][2];	
		for(int i=0;i<rows;i++) {
		
			data[i][0] = excel.getData(0, i, 0);
			data[i][1] = excel.getData(0, i, 1);
			
		}
		
		return data;
				
	}

}
