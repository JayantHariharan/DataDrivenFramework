package loginTestCases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObjectModel.LoginPageObject;
import pageObjectModel.ProfilePageObject;

public class PhpLoginPage {

	@Test
	public void phpTravels() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","J:\\eclipseworkspace\\additionalResources\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://phptravels.net/login");
		Thread.sleep(2000);
	
		PageFactory.initElements(driver, LoginPageObject.class);
		
		Thread.sleep(2000);
		
		LoginPageObject.email.sendKeys("user@phptravels.com");
		LoginPageObject.userPassword.sendKeys("demouser");
		LoginPageObject.login.click();
		
		Thread.sleep(3000);
		PageFactory.initElements(driver, ProfilePageObject.class);
		ProfilePageObject.profile.click();
		Thread.sleep(2000);
		ProfilePageObject.phoneNumber.sendKeys("1234567890");
		ProfilePageObject.firstName.sendKeys("Pro_Gamer25");
		ProfilePageObject.updateProfile.click();
		
	}
}
