package com.freecrm.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static WebDriver driver;
	public Properties prop;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	public WebDriver init_driver(Properties prop) {
		String browserName =prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			//			if(isHeadless) {
			//				ChromeOptions co = new ChromeOptions();
			//				co.addArguments("--headless");
			//				driver = new ChromeDriver(co);
			//			} else {
			//	driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			//			co.addArguments("--incognito");
		}
		//		else if(browserName.equalsIgnoreCase("safari")) {
		//			WebDriverManager.getInstance(SafariDriver.class).setup();
		//			tlDriver.set(new SafariDriver());
		//			/*driver = new SafariDriver();*/
		//		} 
		else {
			System.out.println(browserName + " browser name does not match, please pass the correct browser");
		}
		/*driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;*/
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}

	public Properties init_prop() throws Exception   {
		prop = new Properties();
		//	String env = null;
		String path = ".\\src\\main\\java\\com\\freecrm\\config\\config.properties"; 
		FileInputStream fis;
		//		try {
		//			env = System.getProperty("env");
		//			if(env==null) {
		//				path = ".\\src\\main\\java\\com\\hubspotapp\\config\\config.properties";
		//			} else {
		//				switch (env) {
		//				case "qa":
		//					path = "\\src\\main\\java\\com\\hubspotapp\\config\\config.qa.properties";
		//					break;
		//				default:
		//					System.out.println("Envernoment not passed");
		//					break;
		//				}
		//			}

		fis = new FileInputStream(path);
		prop.load(fis);
		//			} catch (FileNotFoundException e1) {
		//				// TODO Auto-generated catch block
		//				e1.printStackTrace();
		//			} catch (IOException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			} 
		return prop;

	}


	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshot/"+ System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}


}
