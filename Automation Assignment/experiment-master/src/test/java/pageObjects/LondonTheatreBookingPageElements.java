package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LondonTheatreBookingPageElements {
	
	@FindBy(xpath="//div[@class='logo']//a")
	public WebElement londonTheatreLogo;

	@FindBy(xpath="//form[@id='search-form']//input")
	public WebElement searchForm;
	
	@FindBy(xpath="//div[@class='go-icon']//i")
	public WebElement matchingShow;
	
	@FindBy(xpath="//div[@class='show-info']//h1")
	public WebElement showName;
	
	@FindBy(xpath="//div[@class='show-info']//a//div")
	public WebElement bookNowBtn;
	
//	@FindBy(xpath="//div[@class='month-list']//div[@class='date-big-wrapper   ']")
	public String selectDate="//div[@class='month-list']//div[@class='date-big-wrapper   ']";
	
	
	
	
	
	
	@FindBy(xpath="(//*[@id='rotatedSvg']//*[@class='svg-wrapper-foreground']/*)")
	public WebElement numOfPartiations;
	
	@FindBy(xpath="(//*[@id='rotatedSvg']//*[@class='svg-wrapper-foreground']/*)/*")

	public String numOfVacantSeats="//*[@id='rotatedSvg']//*[@id='coverSvg']//*[@class='svg-wrapper-foreground']//*[@display='Stalls']//*[@bookable='true']";
	
	//((//*[@id='rotatedSvg']//*[@class='svg-wrapper-foreground']/*)/*/*/*[@bookable='true'])

	
	public String numOfVacantSeat="//*[name()='svg']//*[name()='circle' and @bookable='true']";
	
	
	
	
	
	
	
	
	
	public String seatBookableSelected="(//*[@id='rotatedSvg']//*[@class='svg-wrapper-foreground']/*)/*/*/*[@bookable='true'][@class='seat bookable selected']";
	
	@FindBy(xpath="//div[@class='next-button selectable']//span")
	public WebElement checkOutNextBtn;
	
	
	@FindBy(xpath="//input[@name='First Name']")
	public WebElement custFirstName;
	
	@FindBy(xpath="//input[@name='Last Name']")
	public WebElement custLastName;
	
	@FindBy(xpath="//input[@name='Email']")
	public WebElement custEmailId;
	
	@FindBy(xpath="//input[@name='Confirm Email']")
	public WebElement custConfirmEmailId;
	
	@FindBy(xpath="//input[@name='Phone']")
	public WebElement custPhoneNum;
	
	
	
}
