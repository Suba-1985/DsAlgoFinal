@StackTest
Feature: Test Stack Page

    Scenario Outline: The user is able to navigate to all options in stack page
    Given The user is on the "Stack" page after logged in
    When The user clicks "<options>" button in stack page
    Then The user in  "<options>" page 
  Examples:
  		|	options	|
			|	Operations in Stack	|  
 			|	Implementation |
 			|	Applications |	
 		 		
 	 Scenario Outline: The user is able to navigate to all options in stack page
    Given The user is on the "Stack" page after logged in
    When The user clicks "<options>" button in stack page
    And The user clicks tryEditor with a Run button to test on stack page
    Then The user in "tryEditor" page
  Examples:
  		|	options	|
			|	Operations in Stack	|  
 			|	Implementation |
 			|	Applications |			
 		
 			
 	Scenario Outline: The user is able stack run code in tryEditor 
    Given The user is in a "<options>" stack page having an tryEditor with a Run button to test
    When The user enter valid python code in stack tryEditor from sheet "<Sheetname>" and <RowNumber>
		And The user clicks on stack run button
		Then The user should be presented with Run result of stack
		 Examples: 
   		| options | Sheetname  | RowNumber |
      | Operations in Stack |pythoncode|  0 |
    	| Implementation |pythoncode|0|
 			|	Implementation |pythoncode|0|	
	
 	Scenario Outline: The user is able run code in tryEditor 
    Given The user is in a "<options>" stack page having an tryEditor with a Run button to test
    When The user enter python code with invalid syntax in stack tryEditor from sheet "<Sheetname>" and <RowNumber>
		And The user clicks on stack run button
		Then The user should be presented with error message in stack page
		 Examples: 
   		| options | Sheetname  | RowNumber |
      | Operations in Stack |pythoncode|  1 |
    	| Implementation |pythoncode|1|
 			|	Implementation |pythoncode|1|	
 		@Tag	
 	 Scenario: The user is able to navigate to Practice page
  	Given The user is on the Operations in Stack after logged in
 		When The user clicks stack Practice Questions link
 		Then The user should be redirected to "practice" page in stack