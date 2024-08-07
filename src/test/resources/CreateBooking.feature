Feature: User can create hotel reservation

  Scenario: User can create a hotel reservation and delete it
    Given User creates a new reservation
    And User gives necessary information for reservation
    When User creates the reservation
    Then Reservation is created successfully
    And The user cancelled the reservation