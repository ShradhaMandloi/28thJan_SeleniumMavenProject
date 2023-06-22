package LoginModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBPwdPage4 {
	@FindBy(xpath ="//input[@name='password']") private WebElement pwd;
	@FindBy(xpath ="//span[text()='Sign in']") private WebElement signIn;
	
	public PBPwdPage4(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	public void inpPBPwdPage1(String password) {
		
		pwd.sendKeys(password);
	}
	public void clickOnSign() {
		
		signIn.click();
	}
}
