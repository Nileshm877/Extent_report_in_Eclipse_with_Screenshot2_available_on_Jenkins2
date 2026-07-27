Feature: test11
Scenario: dropdown1
Given open url "https://demoqa.com/select-menu"
Then verify below values are present in dropdown1
|values|
|Dr.|
|Mr.|


Scenario: dropdown11
Given open url "https://demoqa.com/select-menu"
Then verify below values are present in dropdown2
|Dr.|
|Mr.|


Scenario: dropdown12
Given open url "https://demoqa.com/select-menu"
Then verify below values are present in dropdown2
|Dr.|
|Mr.|

@Reg
Scenario:
Senario: Select dropdown 
Given open url "https://www.amazon.in/"
Then  click on value "Beauty" 
