@CityBikesLocation
Feature: As a biker I would like to know the exact location of city bikes around the world.

  @Regression
  Scenario Outline: User is able to identify the country for a city and return the coordinates for the city.
    Given a user searches for bikes on the CityBikes network
    When the user enters a particular city
    Then the status code is 200
    And City: "<city>" has latitude: <latitude_value>, longitude: <longitude_value> and country: "<country>"

    Examples: 
      | city            | country | latitude_value | longitude_value |
      | Frankfurt       | DE      |        50.1072 |         8.66375 |
      | Aranda de Duero | ES      |      41.667601 |       -3.689526 |
