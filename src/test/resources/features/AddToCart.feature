Feature: Add To Cart Functionality for Flipkart Application

  Scenario Outline: Adding two most expensive products for a product category
    Given User  is on home page of application
    And User clicks on the "<productCategory>" product category
    And User selects "<subProductCategory>" for product category
    Then "<subProductCategory>" page should be displayed
    When user filters the category by "<filterCategory>"
    And user adds the top two products
    Then the total product count should be "<count>"
    Examples:
    |productCategory|subProductCategory|filterCategory      |count|
    |Electronics    |Laptop and Desktop|Price -- High to Low|2    |
