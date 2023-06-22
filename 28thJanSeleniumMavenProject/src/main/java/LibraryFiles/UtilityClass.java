package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {
	
	//@Authorname=shradha mandloi
	//this method is used to get data form excel sheet 
	//need to pass two inputs
	public static String getTestData(int rowindex, int colindex) throws EncryptedDocumentException, IOException {
		
		FileInputStream file= new FileInputStream("C:\\Users\\DC\\eclipse-workspace\\28thJanSeleniumMavenProject\\TestData\\DDF data.xlsx");
		Sheet sh= WorkbookFactory.create(file).getSheet("DDF");
		
		String value=sh.getRow(rowindex).getCell(colindex).getStringCellValue();
		return value;
	}
	
	public static void captureSS(WebDriver d, int TCID) throws IOException {
		
	File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
	File dest=new File("C:\\Users\\DC\\eclipse-workspace\\28thJanSeleniumMavenProject\\FailedTCScreenshot\\TestcaseID"+TCID+".jpg");
	FileHandler.copy(src, dest);
	
	
	}
	public static String getPropertyFileData(String key) throws IOException {
		FileInputStream file=new FileInputStream("C:\\Users\\DC\\eclipse-workspace\\28thJanSeleniumMavenProject\\MavenPropertyFile.properties");
		Properties p= new Properties();
		p.load(file);
		String value=p.getProperty(key);
		return value;
		
	}
	
}
