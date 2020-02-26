@Home
Feature:  Verfy Home Page 
 
 Background: User is Logged In
 Given I navigate to the login page
 When I submit with valid username as "Luke" and password as "Skywalker"
 Then I should be logged in successfully and username should be displayed as "Luke"
    

Scenario Outline: User is able to Create new Employee in Home screen
 
Given user is already on Home page with create button name as "<button>"
When user click on Create button and enter first name as "<empfirstname>" and last name as "<emplastname>" and start date as "<startdate>" and Email as "<email>" 
Then Added Employee "<employeename>"  is displayed on Home screen


Examples:
    | button  | empfirstname | empfirstname | emplastname   | startdate   | email  |
    | Create | aayra tiwa    | aayra        | tiwa       | 2020-02-02     |art@gmail.com |


Scenario Outline: User is able to Create new Employee for deletion in Home screen

Given user is already on Home page with create button name as "<button>"
When user click on Create button and enter first name as "<empfirstname>" and last name as "<emplastname>" and start date as "<startdate>" and Email as "<email>" 
Then Added Employee "<employeename>"  is displayed on Home screen

Examples:
    | button | employeename | empfirstname | emplastname   | startdate   | email  |
    | Create | abcd tiwa    | abcd            | tiwa       | 2020-02-02  |art@gmail.com |



Scenario Outline: User is able to delete Employee from Home screen

Given user is already on Home page  and Employee "<employeename>" is present
When user select Employee name "<employeename>" and Delete the Employee 
Then Employee "<employeename>" is deleted from Home screen bu user "<username>"


Examples:
    | employeename |  username |
    | abcd tiwa    |   Luke |



