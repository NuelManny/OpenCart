Feature: Validating Registration by Providing only Mandatory field
  @OpenCart
  Scenario:
    Given i am on the website "https://demo.opencart.com/"
    And i click on 'My Account' Drop Menu
    And i click on 'Register' option
    And i enter Account Details into mandatory field as "Samuel", "Charter", "chartersam@yahoo.com", and "Sammy34"
    And i accept privacy policy
    And i click on 'continue' button
    And i verify that account was created succesfully
    Then click on 'continue' button displayed in account success page.
