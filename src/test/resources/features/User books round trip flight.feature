Feature: User books round trip flight
  This test will book round trip flight ticket in Yatra website

  Scenario: User should be able to book a flight with the journey details
    Given the user is in homepage
    And user clicks on round trip radio button
    And user selects the source as "Mumbai"
    And user selects the destination as "Bangalore"
    And user selects the departure date
    And user selects the return date
    And user searches for the flight
    And user selects the flight
    And user selects the basic fare
    And user enters the personal details
      | Salutation | First Name | Last Name | Date of Birth | Email         | Phone      |
      | Ms.        | Test       | Name      | 10081989      | abc@gmail.com | 9123456789 |
    When user goes for the payment
    Then the title of the page should be "Payment Method"