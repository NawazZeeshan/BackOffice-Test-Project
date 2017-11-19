package com.bo.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.bo.qa.util.TestUtil;
import com.bo.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase(){
		try{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("/Users/parthibanvm/Documents/workspace/BackOfficeTest"
					+"/src/main/java/com/bo/qa/config/config.properties");
			prop.load(fis);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browsername =prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","/Users/parthibanvm/Documents/workspace/BackOfficeTest/src/main/resources/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "/Users/parthibanvm/Documents/workspace/BackOfficeTest/src/main/resources/geckodriver");
				driver = new FirefoxDriver();
			}
			
		e_driver =new EventFiringWebDriver(driver);
		//now create an object of eventListnerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver =e_driver;
		
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		}
	}


