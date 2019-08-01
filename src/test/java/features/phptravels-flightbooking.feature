Feature: phpTravels flight booking

  Scenario Outline: user can search for flight and fill in booking forms

    Given an open browser with https://www.phptravels.net/
    When user inputs flight details <departureAirport>, <arrivalAirport>, <departureDate>, <arrivalDate>, <numberOfPassengers>
    And clicks button for flights searching
    Then opens page with search results for <departureAirport>, <arrivalAirport>, <departureDate>, <arrivalDate>, <numberOfPassengers>
    And user clicks button for flight booking
    Then opens form for flight confirmation
    And user inputs traveller info <title>, <name>, <surname>, <email>, <phone>, <birthday>, <idCardNumber>, <idCardExpirationDate>, <nationality>
    And user inputs payment information <cardType>, <cardNumber>, <cardExpirationMonth>, <cardExpirationYear>, <cvvNumber>
    And user checks flight details
    Then flights details are visible
    And user can make screenshoots
    And close phpTravels page

    Examples:
      |departureAirport |arrivalAirport |departureDate |arrivalDate |numberOfPassengers |title |name   |surname |email                        |phone        |birthday   |idCardNumber |idCardExpirationDate |nationality   |cardType |cardNumber          |cardExpirationMonth |cardExpirationYear |cvvNumber |
      |WAW              |JFK            |2019-10-10    |2019-10-30  |1                  |Ms.   |Muriel |Jewell  |MurielRJewell@jourrapide.com |917-220-8857 |1970-11-21 |579388816    |2025-02-16           |UNITED STATES |Visa     |4539 3078 9852 0425 |12                  |2022               |046       |
