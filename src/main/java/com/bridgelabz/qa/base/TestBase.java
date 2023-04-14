package com.bridgelabz.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.bridgelabz.qa.util.TestUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase<KeywordActions>  {
	
	 public static WebDriver driver;
	    public static Properties prop;
	    
	    XSSFRow row;
	    XSSFCell cell;
	    protected static String user;
	    protected static String pass;
	    public TestBase() {
	        try {
	            prop = new Properties();
	            FileInputStream ip = new FileInputStream("C:\\Users\\anura\\eclipse-workspace\\FaceBook_PageObjet_Automation_Tests\\src\\main\\java\\com\\bridgelabz\\qa\\config\\config.properties");
	            prop.load(ip);
	            File file = new File(System.getProperty("user.dir") + "\\Test Data\\" + "LoginPage" + ".xlsx");           
	            FileInputStream inputstream = new FileInputStream(file);
	            XSSFWorkbook wb = new XSSFWorkbook(inputstream);
	            XSSFSheet sheet = wb.getSheet("Sheet1");
	            XSSFRow row = sheet.getRow(1);
	            XSSFCell cell = row.getCell(0);
	            user = cell.getStringCellValue();
	            cell = row.getCell(1);
	            pass = cell.getStringCellValue();            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	      public static void initialization() {
	        String browserName = prop.getProperty("browser");
	        if(browserName.equals("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--remote-allow-origins=*");
	            driver = new ChromeDriver(options);
	        }else if(browserName.equals("msedge")) {
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	        }
//	        driver.get("https://www.facebook.com/");
	        driver.manage().window().maximize();
//	        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(TestUnit.IMPLICIT_WAIT,TimeUnit.SECONDS);
	        driver.get(prop.getProperty("url"));
	        
	    }

}
