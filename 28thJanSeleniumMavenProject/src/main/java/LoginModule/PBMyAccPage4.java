package LoginModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBMyAccPage4 {

	@FindBy(xpath = "//span[text()=' My profile ']") private WebElement myProfile;
	@FindBy(xpath = "//span[text()='Sign out']") private WebElement signOut;
	
	public  PBMyAccPage4(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}
	
	public void clickPBMyAccPageMyProfile() 
	{
		myProfile.click();
	}
	
	public void clickPBMyAccPageSignOut() 
	{
		signOut.click();
	}
	
}
