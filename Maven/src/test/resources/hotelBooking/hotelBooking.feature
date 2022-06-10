#Author: likhitha.chowdary.mandava@pwc.com


Feature: hotelBooking

Background: User has already logged in with valid crendentials and he is navigated to hotel booking page

Scenario: Check the title
Given User is on hotelbooking page
Then Validate page title

Scenario: Successful hotel booking with all valid data
Given User is on hotelbooking page
When User enter all valid data and clicks on ConfirmBooking button
And User clicks the ConfirmBooking button
Then Booking Successful page is displayed

Scenario: Failure in hotel booking due to leaving firstName blank
Given User is on hotelbooking page
When User leaves the firstName blank
And User clicks the ConfirmBooking button
Then Display suitable alert msg

Scenario: Failure in hotel booking due to leaving lastName blank
Given User is on hotelbooking page
When User enters firstName and leaves the lastName blank
And User clicks the ConfirmBooking button
Then Display suitable alert msg


Scenario: Failure in hotel booking due to entering invalid mail id
Given User is on hotelbooking page
When User enters all valid data
But User enters incorrect email id
And User clicks the ConfirmBooking button
Then Display suitable alert msg

Scenario: Failure in hotel booking due to incorrect mobileNo format
Given User is on hotelbooking page
When User enters all valid data
But User enters incorrect format of mobile no
|"0788967894"|
|"97786"|
|"985632547896"|
|""|
And User clicks the ConfirmBooking button
Then Display suitable alert msg

Scenario: Failure in hotel booking on not selecting the city
Given User is on hotelbooking page
When User enters all valid data
But User does not select city
And User clicks the ConfirmBooking button
Then Display suitable alert msg


Scenario: Failure in hotel booking on not selecting the state
Given User is on hotelbooking page
When User enters all valid data
But User does not select state
And User clicks the ConfirmBooking button
Then Display suitable alert msg

Scenario Outline: Validate the count of rooms allocated
Given User is on hotelbooking page
When User selects count of persons <personcount>
Then allocate suitable number of rooms as per number of persons <personcount>
Examples:
| personcount |
| 2 |
| 3 |
| 4 |


Scenario: Failure in hotel booking due to leaving year blank
Given User is on hotelbooking page
When User enters valid data for previous fields and leaves the year blank
And User clicks the ConfirmBooking button
Then Display suitable alert msg
