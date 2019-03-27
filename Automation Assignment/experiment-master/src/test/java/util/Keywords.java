package util;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static stepDefinations.SetUp.driver;
import static stepDefinations.SetUp.bunessLogic;
import static stepDefinations.SetUp.user;
import static stepDefinations.SetUp.user;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import stepDefinations.SetUp;
import stepDefinations.SetUp.*;




public class Keywords  {
	    WebDriver driver;



	    public Keywords(WebDriver driver) {
	        this.driver = driver;
	    }

	    

		public void open(String url) throws Exception
	    {
	    	driver.get(url);
	    }
	    
	    
	    public void clickAndEnter(WebElement element, String text) throws InterruptedException {
	        try{
	        	
	        	element.click();
	        }
	        catch(WebDriverException e)
	        {
	        	scrollElementIntoView(element);
	        	//waitTime(1);
	        	element.click();
	        }
	        element.clear();
	        element.sendKeys(text);

	    }

	       public void waitForAjaxCallToFinish() {
	        // System.out.println("Checking active ajax calls by calling jquery.active");
	        try {
	        	Thread.sleep(800);
	            if (driver instanceof JavascriptExecutor) {
	                JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
	                int i;
	                while(true){

	                	Thread.sleep(200);
	                Boolean ajaxIsComplete = (Boolean) (jsDriver).executeScript("return jQuery.active == 0");
	                    if (ajaxIsComplete)
	                        break;
	                }
	            	Thread.sleep(500);
	            }
	                //}
	            else {
	                System.out.println("Web driver: " + driver + " cannot execute javascript");
	            }
	        } catch (InterruptedException e) {
	            System.out.println(e);
	        }
	    }

	       
	    public void click(WebElement ele) throws InterruptedException
	    {
	    	//waitTime(2);
	    	try
	    	{
	    		
	    		ele.click();
	        }
	        catch(Exception e)
	        {
	        	scrollElementIntoView(ele);
	        //	waitTime(3);
	        	ele.click();
	        }
	    	
	    }
	    
	   

	    public void scrollElementIntoView(WebElement ele) throws InterruptedException
	    {
	    	JavascriptExecutor je = (JavascriptExecutor) driver;
	        je.executeScript("arguments[0].scrollIntoView(true);", ele);
	        ((JavascriptExecutor)driver).executeScript("window.scrollTo(" +ele.getLocation().x +","+ (ele.getLocation().y - 255 ) + ");");

	    		
	    }
	    
	    

	
}
