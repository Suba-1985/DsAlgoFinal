@logIn
Feature: Login Action
  
  @LogIn
  Scenario: User is on Home page and Clicks on Signins
   Given user is on Home Page
    When user clicks on SignIn button he is directed to login page
    Then user validates the login page
    
     
  Scenario: To verify SignIn with Empty fields
    Given User is on Login page
    When User clicks on login button with all empty field
    Then User verify the message at username as "Please fill out this field."
   
      
   Scenario Outline: To verify SignIn with invalid "<username>" and "<password> and gets the result "<result>"
    Given User is on Login page
    When User enters invalid username as "<username>" and password as "<password>" and gets the result "<result>"
    And User clicks login button
    Then User verify the message as "<result>"

    Examples: 
      | username | password     |result|
      | abcdefgh | zxyu1234     |Invalid Username and Password|
      | asdfger  |  @@@@        |Invalid Username and Password|
      |   ER@$   | sdkfsk12 |Invalid Username and Password|
  
  
  Scenario: To verify SignIn with username only
    Given User is on Login page
    When User clicks on login button with username as "numpy" only
    Then User verify the message at password as "Please fill out this field."
    
 
   Scenario: To verify SignIn with password only
    Given User is on Login page
    When User clicks on login button with password as "numpy" only
    Then User verify the message at user as "Please fill out this field."  
    
    
Scenario Outline: User  Login with  valid "<username>" and "<password>"
    Given User is on Login page
    When User enters valid username "<username>" and password "<password>"
    And User clicks on login button
    Then It should navigate to the home page with a message "You are logged in"

    Examples: 
      | username | password |
      | sdet    |  sdet1234 |
