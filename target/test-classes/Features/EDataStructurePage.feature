@DataStructureTest
Feature: Test DataStructure  page

Scenario Outline: The user is able to navigate to all options in datastructure page
    Given The user is on the "DataStructure" page
    When The user clicks "<options>" button of Datastructure page
    Then The user in  "<options>" of Datastructure page
  Examples:
			|	options	|
			|	Time Complexity	|  
	
	Scenario Outline: The user is able run code in tryEditor 
    Given The user is in a "<options>" page having an tryEditor with a Run button to test for DS
    When The user enter valid python DS code in tryEditor from sheet "<Sheetname>" and <RowNumber>
		And The user clicks on run button for DS
		Then The user should be presented with Run result for DS
		Examples:
			|	options					| Sheetname  | RowNumber |
			|	Time Complexity	|  pythoncode		|  0          |
		
		@Tag			
	Scenario Outline: The user is able run code in tryEditor 
    Given The user is in a "<options>" page having an tryEditor with a Run button to test for DS
    When The user enter python DS code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber>
		And The user clicks on run button for DS
		Then The user should be presented with error message for DS
		 Examples: 
   		|	options					| Sheetname  | RowNumber |
			|	Time Complexity	|  pythoncode		|  1        |