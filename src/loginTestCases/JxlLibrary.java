package loginTestCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class JxlLibrary {
	
	String [][]data=null;
	
	@DataProvider(name="login")
	public String[][] loginDataProvider() throws BiffException, IOException {
		data=readExcel();
		return data;
	}
	
	@Test(dataProvider = "login")
	public void loginPage(String uName,String pasword) throws InterruptedException {
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

	
	public String[][] readExcel() throws BiffException, IOException {
		FileInputStream excel=new FileInputStream("J:\\eclipseworkspace\\additionalResources\\testCase.xls");
		Workbook workBook=Workbook.getWorkbook(excel);
		Sheet sheet=workBook.getSheet("Sheet1");
		int rows=sheet.getRows();
		int columns=sheet.getColumns();
		String [][]tempData=new String[rows][columns];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				tempData[i][j]=sheet.getCell(j,i).getContents();
			}
		}
		return tempData;
		
	}
}
