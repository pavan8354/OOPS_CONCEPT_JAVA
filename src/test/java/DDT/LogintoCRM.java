package DDT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogintoCRM {
	
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
		
		driver.quit();
	}
	
	@AfterMethod	
	public void teardown() {		
		driver.quit();	
	}
	@DataProvider(name="TestData")	
	public Object[][] passdata(){
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "admin";
		data[0][1] = "passw0rd";
		
		data[1][0] = "admin1";
		data[1][1] = "passowrd1";
		
		data[2][0] = "batchautomation";
		data[2][1] = "Test@12345";
		
		return data;
				
	}

}
