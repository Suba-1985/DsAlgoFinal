@ArrayTest
Feature: Test Array page

  Scenario Outline: The user is able to navigate to all options in array page
    Given The user is on the "Array" after logged in
    When The user clicks "<options>" button
    Then The user in  "<options>" page
  Examples:
			|	options	|
			|	Arrays in Python	|  
 			|Arrays Using List |
 			|Basic Operations in Lists |	
 	
 	
 	Scenario Outline: The user is able to navigate to all options in array page
    Given The user is on the "Array" after logged in
    When The user clicks "<options>" button
    And The user clicks tryEditor with a Run button to test on Arraypage
    Then The user in "tryEditor" page
  Examples:
 			|	options	|
			|	Arrays in Python	|  
 			|Arrays Using List |
 			|Basic Operations in Lists |	
 	
 	
 		Scenario Outline: The user is able run code in tryEditor 
    Given The user is in a "<options>" page having an tryEditor with a Run button to test
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
		And The user clicks on run button
		Then The user should be presented with Run result
		 Examples: 
   		| options | Sheetname  | RowNumber |
      | Arrays in Python |pythoncode|  0 |
    	|Arrays Using List |pythoncode|0|
 			|Basic Operations in Lists |pythoncode|0|	
 	

 		Scenario Outline: The user is able run code in tryEditor 
    Given The user is in a "<options>" page having an tryEditor with a Run button to test
    When The user enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber>
		And The user clicks on run button
		Then The user should be presented with error message
		 Examples: 
   		| options | Sheetname  | RowNumber |
      | Arrays in Python |pythoncode|  1 |
    	|Arrays Using List |pythoncode|1|
 			|Basic Operations in Lists |pythoncode|1|	
 		
  @Tag
  Scenario: The user is able to navigate to Practice page
  	Given The user is on the Arrays in Python after logged in
 		When The user clicks Practice Questions link
 		Then The user should be redirected to "practice" page
 		
 	
 Scenario Outline:The user is able to navigate to all practice questions
 		Given The user is on the Arrays in Python after logged in
 		When The user clicks Practice Questions link
 		Then The user should be redirected to "practice" page
		And The user should redirect to "<options>" practice question page
		Examples: 
   		|						 options 											| 			Sheetname  		|			 RowNumber		|
      | Search the array 												|	pythoncode		|				  0 				|
    	| Max Consecutive Ones 										|	pythoncode		|					0					|
 			|	Find Numbers with Even Number of Digits	|	pythoncode		|					0					|	

		
 		
 		Scenario Outline: The user is able to run code in Practice session of Array in python
 		Given The user is in a "<options>"  practice page having an tryEditor with a Run button to test
 		When  The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber> in the practice tryeditor area   
 		And The user clicks on run button
 		Then The user should be presented with Run result
 		 Examples: 
   		|						 options 											| 			Sheetname  		|			 RowNumber		|
      | Search the array 												|	pythoncode		|				  0 				|
    	| Max Consecutive Ones 										|	pythoncode		|					0					|
 			|	Find Numbers with Even Number of Digits	|	pythoncode		|					0					|	
 	
 
 
 Scenario Outline: The user is able to run code in tryEditor for Practice session of Array in python
 		Given The user is in a "<options>"  practice page having an tryEditor with a Run button to test
 		When  The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber> in the practice tryeditor area   
 		And The user clicks on run button
 		And The user clicks on submit
		Then The user should be presented with Run result
		 Examples: 
   		|						 options 											| 			Sheetname  		|			 RowNumber		|
      | Search the array 												|	pythoncode		|				  0 				|
    	| Max Consecutive Ones 										|	pythoncode		|					0					|
 			|	Find Numbers with Even Number of Digits	|	pythoncode		|					0					|	
 
 Scenario Outline: The user is able to run invald code in tryEditor for Practice session of Array in python
 		Given The user is in a "<options>"  practice page having an tryEditor with a Run button to test
 		When  The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber> in the practice tryeditor area   
 		And The user clicks on run button
 		Then The user should be presented with error message
		 Examples: 
   		|						 options 											| 			Sheetname  		|			 RowNumber		|
      | Search the array 												|	pythoncode		|				  1 				|
    	| Max Consecutive Ones 										|	pythoncode		|					1					|
 			|	Find Numbers with Even Number of Digits	|	pythoncode		|			    1					|	
 
  