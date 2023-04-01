package loginTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ApachePoiLibrary {
	
	static List<String>user=new ArrayList<String>();
	static List<String>pass=new ArrayList<String>();
	
	public void executeTest() throws InterruptedException {
		for(int i=0;i<user.size();i++) {
			loginPage(user.get(i),pass.get(i));
		}
	}
	
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
		public void readExcel() throws IOException {
			FileInputStream excel=new FileInputStream("J:\\eclipseworkspace\\additionalResources\\testCase1.xlsx");
			 Workbook workbook=new XSSFWorkbook(excel);
				Sheet sheet=workbook.getSheetAt(0);
				Iterator<Row>rows=sheet.iterator();
				while(rows.hasNext()) {
					Row rowValue=rows.next();
					Iterator<Cell>columns=rowValue.iterator();
					int i=2;
					while(columns.hasNext()) {
						if(i%2==0) {
							user.add(columns.next().getStringCellValue());
						}else {
							pass.add(columns.next().getStringCellValue());
						}
						i++;
					}
				}
			}
			
			

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ApachePoiLibrary poiLibrary=new ApachePoiLibrary();
		poiLibrary.readExcel();
		poiLibrary.executeTest();
		

	}

}
