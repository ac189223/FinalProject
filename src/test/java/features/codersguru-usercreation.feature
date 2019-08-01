Feature: codersGuru user creation

  Scenario Outline: user can fill in form and register a new private user

    Given open browser with page https://tester.codersguru.pl/
    When user clicks button for account creation for <email>
    Then opens form for registration
    And user chooses private user registration
    And user inputs user details <email>, <name>, <lastName>, <password>, <passwordConfirmation>, <city>, <postalCode>, <streetName>, <streetNumber>
    And data is valid
    And user accepts regulations
    And user clicks button for registration
    Then opens page with confirmation
    And close codersGuru page

    Examples:
      |email                         |name      |lastName  |password  |passwordConfirmation |city         |postalCode  |streetName        |streetNumber |
#DONE      |jbutt@gmail.com               |James     |Butt      |jambut123 |jambut123            |New Orleans  |70-116      |Blue Gum St       |6649 N       |
#DONE      |josephine_darakjy@darakjy.org |Josephine |Darakjy   |josdar123 |josdar123            |Brighton     |48-116      |Blue Ridge Blvd   |4 B          |
#DONE      |art@venere.org                |Art       |Venere    |artven123 |artven123            |Bridgeport   |80-914      |Cerritos Ave      |8 W          |
      |lpaprocki@hotmail.com         |Lenna     |Paprocki  |lenpap123 |lenpap123            |Anchorage    |99-501      |Main St           |639          |
#      |donette.foller@cox.net        |Donette   |Foller    |donfol123 |donfol123            |Hamilton     |45-011      |Center St         |34           |
#      |simona@morasca.com            |Simona    |Morasca   |simmor123 |simmor123            |Ashland      |44-805      |Mcauley Dr        |3            |
#      |mitsue_tollner@yahoo.com      |Mitsue    |Tollner   |mittol123 |mittol123            |Chicago      |60-632      |Eads St           |7            |
#      |leota@hotmail.com             |Leota     |Dilliard  |leodil123 |leodil123            |San Jose     |95-111      |Jackson Blvd      |7 W          |
#      |sage_wieser@cox.net           |Sage      |Wieser    |sagwie123 |sagwie123            |Sioux Falls  |57-105      |Boston Ave        |5            |
