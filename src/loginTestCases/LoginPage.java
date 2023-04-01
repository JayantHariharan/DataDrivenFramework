package loginTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPage {
	
	String[][]loginData= {
			{"Admin","admin1"},
			  {"Admin","dummy"}, {"Admin1","admin"}, {"Admin","admin123"}
			 
	};
	
	@DataProvider(name="loginCreditenials")
	public String[][] loginDataProvider() {
		return loginData;
	}

	@Test(dataProvider = "loginCreditenials")
	public void login(String uName,String pasword) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","J:\\eclipseworkspace\\additionalResources\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(2000);
		WebElement userName=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		userName.sendKeys(uName);
		
		WebElement password=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		password.sendKeys(pasword);
		
		WebElement loginButton=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		loginButton.click();
		Thread.sleep(2000);
		driver.quit();
		
	}
}
