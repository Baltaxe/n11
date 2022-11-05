Feature: N11 Favourite Product Scenario

  Scenario: N11 Favourite Product Scenario

    When user enters the page url
    And user verifies the main page
    And user login the credentials
    And user should see the dashboard
    And user search for the item
    And user verifies the results title for Iphone
    And user adds the third product on the second page to the favourites
    And user launches Hesabım>Favorilerim>Listelerim page
    And user verifies the Favorilerim page is launched
    And user deletes the last added product
    Then user logs out