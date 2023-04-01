package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageObject {

	@FindBy(xpath="/html/body/div[4]/div/div[3]/ul/li[4]/a")
	public static WebElement profile;
	@FindBy(name="phone")
	public static WebElement phoneNumber;
	@FindBy(name="firstname")
	public static WebElement firstName;
	@FindBy(className="theme-btn waves-effect")
	public static WebElement updateProfile;
}
