@Login
Feature:  Login Functionality

Scenario Outline: Login Test with valid credentials

Given user is already on Login page
When user submit valid username as "<username>" and password as "<password>"
Then user logged in successfully and username should be displayed as "<username>" 
	
Examples:
    | username   | password |
    | Luke       | Skywalker |
    
    
        
Scenario Outline: Login Test with invalid credentials

Given user is already on Login page
When user enter invalid username as "<username>" and invalid password as "<password>"
Then user should not be logged in and invalid message shoud be displayed as "<invalidmessage>"

Examples:
    | username   | password | invalidmessage |
    | Arti       | Tiwa     |  Invalid username or password! |

	


