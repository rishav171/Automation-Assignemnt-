package businessLogic;



import util.Configuration;
import util.Keywords;
import static stepDefinations.SetUp.user;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;
import stepDefinations.SetUp;
import stepDefinations.SetUp.*;
import static stepDefinations.SetUp.driver;
import static stepDefinations.SetUp.bunessLogic;
import static stepDefinations.SetUp.user;

import static stepDefinations.SetUp.pgeElemLndnBook;


public class BusinessLogic {
	Configuration config=new Configuration();
	public static Keywords user=new Keywords(driver);
	
	 
	//public BusinessLogic businesslogic=new BusinessLogic();
	
	
	
	public void openTheWebSite() throws Exception
	{
		//System.out.println("The current url is "+driver.getCurrentUrl());
		String loginUrl=config.configdata.getProperty("londonTheatreUrl");
		System.out.println("I am printing the url"+loginUrl);
		driver.get(loginUrl);
		user.waitForAjaxCallToFinish();
	}
	
	public void verifyTheWebSiteOpened() throws InterruptedException
	{
		
		user.click(pgeElemLndnBook.londonTheatreLogo);
		user.waitForAjaxCallToFinish();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The Current URL is "+currentUrl);
		Assert.assertEquals(config.configdata.getProperty("londonTheatreUrl"), currentUrl);
	}
	
	public void searchForTheTicket(String programmeName) throws InterruptedException
	{
		
//		pgeElemLndnBook.searchForm.click();
		pgeElemLndnBook.searchForm.sendKeys(programmeName);
		Thread.sleep(5000);
		pgeElemLndnBook.matchingShow.click();
				
	}
	
	public void verifyAvailabilityOfTicket(String programmeName)
	{
		//Assert.assertEquals(programmeName, pgeElemLndnBook.showName);
	}
	
	public void bookTheTicket() throws InterruptedException
	{
		
//		String bookNowBtnUrl = pgeElemLndnBook.bookNowBtn.getAttribute("href");
//		System.out.println("The href is given by "+bookNowBtnUrl);
		Thread.sleep(2000);
		pgeElemLndnBook.bookNowBtn.click();

		ArrayList<String> numOfTabs = new ArrayList<String> (driver.getWindowHandles());
		Assert.assertEquals(2, numOfTabs.size());
		driver.switchTo().window(numOfTabs.get(1));
		String newTabUrl = driver.getCurrentUrl();
//		if(!newTabUrl.contains(bookNowBtnUrl))
//		{
//			Assert.fail("The Url's are not matching");
//		}
		
		
		
	}
	
	public void selectTheDate() throws InterruptedException
	{
		List<WebElement> numOfDaysShowAvailable = driver.findElements(By.xpath(pgeElemLndnBook.selectDate));
		numOfDaysShowAvailable.get(0).click();;
		Thread.sleep(4000);
	}
	
	public void selectTheSeat() throws InterruptedException
	{
//		Assert.assertEquals(true, pgeElemLndnBook.numOfPartiations.isDisplayed());
//		Thread.sleep(3000);
		List<WebElement> totalNumOfVacantSeats = driver.findElements(By.xpath("//*[name()='svg' and namespace-uri()='http://www.w3.org/2000/svg']//*[local-name()='g']//*[name()='circle' and @fill='#d6557a'][1]"));
		System.out.println("The Number of Vacant seats are "+totalNumOfVacantSeats.size());
//			
//			if(totalNumOfVacantSeats.size()>0)
//					System.out.println("The Seats are Still Available for the show");
//			
//			Assert.assertEquals(0, numOfSelectedSeats());
//			
//			totalNumOfVacantSeats.get(0).click();
//		Thread.sleep(2000);
//		driver.findElement(By.id("SE-STALLS-J-20")).click();
		
	
		
		WebElement svgObject = driver.findElement(By.xpath("//*[name()='svg' and namespace-uri()='http://www.w3.org/2000/svg']//*[local-name()='g']//*[name()='circle' and @fill='#d6557a']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", svgObject);
		
		
//		Actions builder = new Actions(driver);
//		builder.click(svgObject).build().perform();
		
			
			Assert.assertEquals(true, pgeElemLndnBook.checkOutNextBtn.isEnabled());
			Assert.assertEquals(1, numOfSelectedSeats());
			
			
	}
	
	public int numOfSelectedSeats()
	{
		List<WebElement> numOfSeatsSelected = driver.findElements(By.xpath(pgeElemLndnBook.seatBookableSelected));
		return numOfSeatsSelected.size();
	}
	
	public void completeTheBooking() throws InterruptedException
	{
		user.click(pgeElemLndnBook.checkOutNextBtn);
		user.waitForAjaxCallToFinish();
		enterTheCustomerDetails();
		
	}
	
	public void enterTheCustomerDetails() throws InterruptedException
	{
		user.clickAndEnter(pgeElemLndnBook.custFirstName, "John");
		user.clickAndEnter(pgeElemLndnBook.custLastName, "Abharam");
		user.clickAndEnter(pgeElemLndnBook.custEmailId, "john.abharam@gmail.com");
		user.clickAndEnter(pgeElemLndnBook.custConfirmEmailId, "john.abharam@gmail.com");
		user.clickAndEnter(pgeElemLndnBook.custPhoneNum, "+41908172663");
	}

}
