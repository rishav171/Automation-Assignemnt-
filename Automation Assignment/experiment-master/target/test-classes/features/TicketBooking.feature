Feature: Book the ticket for "The Simon and Garfunkel Story" using London Theatre Booking website

@TicketBooking
Scenario:Book the ticket for The Simon and Garfunkel Story using London Theatre Booking website
Given I open the chrome browser
And I will navigate to London theatre booking website
When I search for the ticket available for <"The Simon and Garfunkel Story">
Then I will verify whether availability of <"The Simon and Garfunkel Story">

Given I click on the Book Now Button
And pick a date
When I select the available seat for the programme
Then I will complete my booking

