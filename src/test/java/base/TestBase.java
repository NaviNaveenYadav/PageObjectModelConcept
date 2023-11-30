package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {

	private static TestBase testBase;
	private static WebDriver driver;
	public static Properties prop;
	
	private TestBase() {
		String strBrowser = "Chrome";
		
		if(strBrowser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			System.out.println("Init driver ...." + driver);
		}
		else if(strBrowser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			System.out.println("Init driver..." + driver);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		System.out.println("Driver obj...." + driver);
		
	}
	
	public static void initDriver() {
		if(testBase == null) {
			testBase = new TestBase();
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void openUrl(String url) {
		driver.get(url);
	}
	
	public static void tearDown() {
		if(driver != null) {
			driver.close();
//			driver.quit();
		}
		
		testBase = null;
	}
	
	
}
