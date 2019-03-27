package stepDefinations;



import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import util.Configuration;
import util.Keywords;

import businessLogic.BusinessLogic;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pageObjects.LondonTheatreBookingPageElements;





public class SetUp {
public static WebDriver driver;
public static BusinessLogic bunessLogic=new BusinessLogic();
public static SetUp setUp;
public static Keywords user;
public static LondonTheatreBookingPageElements pgeElemLndnBook=new LondonTheatreBookingPageElements();
Configuration config=new Configuration();






@Before
public void setUpBrowser() throws Exception {
	
	System.out.println("I am inside setup browser");
	System.setProperty("webdriver.chrome.driver", "/Users/bharadwajsm/TR/Workspace/ticketbooking/chromedriver");
	ChromeOptions options = new ChromeOptions();
	
	options.addArguments("test-type");
	options.addArguments("chrome.switches","--disable-extensions");
	options.addArguments("--disable-extensions");
	options.addArguments("--enable-popup-blocking");
	options.addArguments("start-fullscreen");
	options.addArguments("disable-infobars");
	
    
	ChromeDriverService service = new ChromeDriverService.Builder().usingAnyFreePort().build();
             
	
	
	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);  
	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	
	
	
	

		 driver = new ChromeDriver(service,options);
	
	
	
		 
		 driver.manage().deleteAllCookies();
		 driver.manage().window().fullscreen();
		 //driver.manage().window().maximize();
		  
		 //driver.get(config.configdata.getProperty("londonTheatreUrl")); 
		
		PageFactory.initElements(driver,pgeElemLndnBook);
		
		
	 }
	 
	 



@After
public void tearDown(Scenario scenario) throws Exception {
	
	System.out.println("inside after");
	
	
		driver.quit();
	 
}
}






