package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject {

	@FindBy(name="email")
	public static WebElement email;
	
	@FindBy(name="password")
	public static WebElement userPassword;
	
	@FindBy(className="btn btn-default btn-lg btn-block effect ladda-button waves-effect")
	public static WebElement login;
}
