package superTechPOMTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class STTestBase {
	public static WebDriver driver=null;
	
	@BeforeSuite
	public void initiatialize() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\superTechPOMDrivers\\Chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("file:///C:/ITTraining/WebSite/SuperTech.html");
		//driver.get("https://www.capitalone.com/");//for brokenlink
		
	}
	
	//@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
		
}

