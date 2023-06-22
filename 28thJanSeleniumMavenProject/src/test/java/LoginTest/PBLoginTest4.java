package LoginTest;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import LibraryFiles.BaseClass_ToOpenBrowser;
import LibraryFiles.UtilityClass;
import LoginModule.PBHomePage4;
import LoginModule.PBLoginPage4;
import LoginModule.PBMobNumPage4;
import LoginModule.PBMyAccPage4;
import LoginModule.PBProfilePage4;
import LoginModule.PBPwdPage4;

public class PBLoginTest4 extends BaseClass_ToOpenBrowser{

	int a;
	PBLoginPage4 login;
	PBMobNumPage4 mobNum;
	PBPwdPage4 pwd;
	PBHomePage4 home;
	PBMyAccPage4 myAcc;
	PBProfilePage4 myprofile;
	// WebDriver d;
	Sheet sh;
	int TCID;
	
	
	@BeforeClass
	public void OpenBrowser() throws EncryptedDocumentException, IOException {
		
		
//		FileInputStream file= new FileInputStream("C:\\Users\\DC\\Desktop\\exceldata\\DDF data.xlsx");
//		Sheet sh= WorkbookFactory.create(file).getSheet("DDF");
		
//		d= new ChromeDriver();
//		d.manage().window().maximize();
//		d.get("https://www.policybazaar.com/");
//		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
		
		initializeBrowser();
		
		 login=new PBLoginPage4(d);
		 mobNum=new PBMobNumPage4(d);
		 pwd= new PBPwdPage4(d);
		 home= new PBHomePage4(d);
		 myAcc=new PBMyAccPage4(d);
		 myprofile=new PBProfilePage4(d);
		 a=10;                      //locally initailize
		
	}
	@BeforeMethod
	public void LoginApp() throws InterruptedException, EncryptedDocumentException, IOException {
	
		System.out.println(a);
		login.clickOnPBLoginPageSignIn();
		mobNum.inpPBMobNumPage1(UtilityClass.getPropertyFileData("Username"));
		mobNum.clickOnSignInPwd();
		pwd.inpPBPwdPage1(UtilityClass.getPropertyFileData("Password"));
		pwd.clickOnSign();
		Thread.sleep(2000);
		
		
	}
	@Test
	public void VerifyFullName() throws InterruptedException, EncryptedDocumentException, IOException {
		
		TCID=101;
		home.openDDoptionOfMyAccount();
		Thread.sleep(2000);
		myAcc.clickPBMyAccPageMyProfile();
		myprofile.switchToChildWindow();
		//profile.verifyPBProfilePageFullName(sh.getRow(0).getCell(2).getStringCellValue());
		
		String actresult=myprofile.getPBProfilePagefullName();
		String expresult=UtilityClass.getTestData(0, 2);
	
		Assert.assertEquals(actresult, expresult,"Failed: both results are different");
		
		
	}
	
	@AfterMethod
	public void LogoutApp(ITestResult s1) throws IOException {
	
		if(s1.getStatus()==ITestResult.FAILURE) {          //note- need to change name in file then only TC will fail and SS can take
			UtilityClass.captureSS(d, TCID);
		}
		
		myprofile.switchToChildWindow1();
		myAcc.clickPBMyAccPageSignOut();
	
	}
	@AfterClass
	public void CloseBrowser() throws InterruptedException {
	
		Thread.sleep(2000);
		d.quit();
	
	}
	
}
