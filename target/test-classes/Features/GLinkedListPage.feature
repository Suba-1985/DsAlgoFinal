
@LinkedListPage
Feature: user validates the Linked List Page
  
 

  @pageverification
  Scenario: User selects the Linked List item and verifies the Page Title 
    Given user is on Home Page
    And user clicks the Linked List getstart link 
    Then user is on the Linked List Page 
    And user checks for the title "Linked List" in the Linked List page  
    
    
  @validpythoncode
  Scenario Outline: User checks each of the topics in Linked List with valid python code
    Given user clicks the Linked List getstart link  
    When The user select all option "<option>" and Verifies the tryeditor Page with the valid python code for each option  "<sheetName>" and <Rownumber>     
    Then user should be presented with the run result
    Examples:
      | option                           | sheetName                | Rownumber|
      | Introduction                     | pythoncode           |   0      |      
      | Creating Linked LIst             | pythoncode            |   0      | 
      | Types of Linked list             | pythoncode            |   0      |
      | Implement Linked List in Python  | pythoncode            |   0      |

  @invalidpythoncode
  Scenario Outline: User checks each of the topics in Linked List with invalid python code
    Given user clicks the Linked List getstart link 
    When The user select all option "<option>" and Verifies the tryeditor Page with the Invalid python code for each option  "<sheetName>" and <Rownumber>     
    Then user should get the "<erroroutput>"   
    
    Examples:
      |  option                            | sheetName               | Rownumber|erroroutput                        |
      |  Introduction                     | pythoncode           |   1      |NameError: name 'prin' is not defined on line 1   |  
      |  Creating Linked LIst             | pythoncode            |   1      |NameError: name 'prin' is not defined on line 1  |
      |  Types of Linked list             | pythoncode            |   1      |NameError: name 'prin' is not defined on line 1    |
      |  Implement Linked List in Python  | pythoncode            |   1      |NameError: name 'prin' is not defined on line 1    |
     
    @practice
    Scenario Outline: The user is able to navigate to Practice page
  	Given user clicks the Linked List getstart link 
  	Then The user select all option "<option>" 
  	And The User is on the "<option>" page
 		When The user clicks Practice Questions "Practice Questions" link
 		Then The user should be redirected to "practice" page and verifies the Url "https://dsportalapp.herokuapp.com/linked-list/practice"
 		 
    Examples:
    |    option                         |
    |  Introduction                     |
    |  Creating Linked LIst             | 
    |  Types of Linked list             |  
                 