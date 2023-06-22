package LibraryFiles;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass_ToOpenBrowser {
	public WebDriver d;
	public void initializeBrowser() throws IOException {
	
		d= new ChromeDriver();
		d.manage().window().maximize();
		d.get(UtilityClass.getPropertyFileData("URL"));
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
}
