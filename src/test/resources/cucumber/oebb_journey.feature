Feature: Book a journey

  Scenario Outline: I want to book a journey
    Given I am using chrome
    And I am on the OEBB Ticketshop homepage
    When I search for a journey from <departureStation> to <arrivalStation>
    And I click on the find connections button
    Then I receive a result list

    Examples:
      | departureStation | arrivalStation |
      | Wien Hbf (U)     | Salzburg Hbf   |
      | Wien Hbf (U)     | Graz Hbf   |


