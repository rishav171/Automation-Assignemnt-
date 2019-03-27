package stepDefinations;

import static stepDefinations.SetUp.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LondonTheatre {
	

	

	@Given("^I open the chrome browser$")
	public void i_open_the_chrome_browser() throws Throwable {
		 bunessLogic.openTheWebSite();
	}
	
	@Given("^I will navigate to London theatre booking website$")
	public void i_will_navigate_to_London_theatre_booking_website() throws Throwable {
	   
	}

	
	
	@When("^I search for the ticket available for <\"([^\"]*)\">$")
	public void i_search_for_the_ticket_available_for(String programmeName) throws Throwable {
		bunessLogic.verifyTheWebSiteOpened();
		bunessLogic .searchForTheTicket(programmeName);
	}

		
//	@Then("^I will verify whether availability of \"([^\"]*)\"$")
//	public void i_will_verify_whether_availability_of(String programmeName) throws Throwable {
//		bunessLogic.verifyAvailabilityOfTicket(programmeName);
//	}
	
	
	
	@Then("^I will verify whether availability of <\"([^\"]*)\">$")
	public void i_will_verify_whether_availability_of(String programmeName) throws Throwable {
		bunessLogic.verifyAvailabilityOfTicket(programmeName);
	}
	
	@Given("^I click on the Book Now Button$")
	public void i_click_on_the_Book_Now_Button() throws Throwable {
		bunessLogic.bookTheTicket();
	}

	@Given("^pick a date$")
	public void pick_a_date() throws Throwable {
		bunessLogic.selectTheDate();
	}

	@When("^I select the available seat for the programme$")
	public void i_select_the_available_seat_for_the_programme() throws Throwable {
		bunessLogic.selectTheSeat();
	}

	@Then("^I will complete my booking$")
	public void i_will_complete_my_booking() throws Throwable {
		bunessLogic.completeTheBooking();
	}


}
