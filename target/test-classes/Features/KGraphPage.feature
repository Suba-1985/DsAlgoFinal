
@LinkedListPage
Feature: user validates the Linked List Page
  
  
  @pageverification
  Scenario: User selects the Graph item and verifies the Page Title 
    Given user is on Home Page
    And user clicks the Graph getstart link 
    Then user is on the Graph Page 
    Then user checks for the title "Graph" in the Graph page  
    
    @validpythoncode
  Scenario Outline: User checks each of the topics in Graph with valid python code
    Given user clicks the Graph getstart link 
    When The user select all option "<option>" from the graph page and Verifies the tryeditor Page with the valid python code for each option  "<sheetName>" and <Rownumber>     
    Then user should be presented with the run result in the screen "<outputresult>"
    Examples:
      | option                           | sheetName                | Rownumber|outputresult|
      | Graph                            | pythoncode           |   0      | Hello  |
      | Graph Representations            | pythoncode            |   0      | Hello  |
    
    @invalidpythoncode
  Scenario Outline: User checks each of the topics in Graph with invalid python code
    Given user clicks the Graph getstart link 
    When The user select all option "<option>" and Verifies the tryeditor Page with the Invalid python code for each option  "<sheetName>" and <Rownumber>  in the graph page   
    Then user should get the "<erroroutput>" on the screen 
    
    Examples:
      |  option                            | sheetName                | Rownumber|erroroutput                       |
      |  Graph                             | pythoncode           |   1      |NameError: name 'prin' is not defined on line 1   |  
      |  Graph Representations             | pythoncode            |   1      |NameError: name 'prin' is not defined on line 1  |
     
 