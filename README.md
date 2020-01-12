# Employee-Management-System-
Employee management REST API (Back-End)

EMS project that i built is done using java with Spring Boot framework 
SET UP
----------
=> You to have an IDE running java program 
=>import the project as Maven Project 
=>You need to download dependencies 
=>you need post man to test the API
RUNNING
-------
=>you will to set-up your own database configuration to be able to connect with the database 
  Or you can use h2Databse(In-memroy database to test to functionalities)
then run the project 

It perform various functionalities as given in the challenge all using Rest API:
 *Saving Employee
 *updating Employee
 *deleting Employee
 *List all Employee saved
 *Search Employee By Name,Id,Phone number,Position
 *Suspend Or Activate the Employee
 
 The Routes are build in the right format as given in the challenge,
   1) For Listing all Employee
   ---------------------
     => http://localhost:8080/employees with a (REQUEST:GET) : It will return all Employess saved
      
    2)Saving employee
    ---------------
      => http://localhost:8080/employees with a (REQUEST:POST): having the Body of Employee pojo
        Response :the return will be the object created.
        
     3) Deleting Employee
      -------------------
         => http://localhost:8080/employees/ID(an National Id for employee) with a (REQUEST:DELETE)
               ex:http://localhost:8080/employees/1198908003967089
           Respnse: the confirmation message.
      4)Updating Employee
      ---------------------
           =>http://localhost:8080/employees/1198908003967089 with a (REQUEST:PUT): having the Body of Employee pojo
               N.B: Remember to include the id for the employee to make the system know the correct one 
           Response: the Editted object will be sent back 
           
     5)Activate Employee
     ------------
     =>http://localhost:8080/employees/1198908003967089/activate with a (REQUEST:PUT): 
     Response: the Editted object will be sent back with an active status
     
     6)Suspend Employee
     -------------------
      => http://localhost:8080/employees/1198908003967089/suspend with a (REQUEST:PUT): 
     Response: the Editted object will be sent back with an inactive status
     
     7)Search employee
     -----------------
        *By Name :http://localhost:8080/employees/search/name/Eric(Employee Name to search)
        Response: the object will be sent back corresponding Name
        
        *By Position: http://localhost:8080/employees/search/position/developer(Employee Position to search)
            Response: the list of object will be sent back corresponding the position given
            
         *By Phone Number: http://localhost:8080/employees/search/phone/+250781348909(Employee Phone to search)
        Response: the object will be sent back corresponding Phone Number 
        
         *By Email ::http://localhost:8080/employees/search/email/ishimwenelson45@gmail.com(Employee Email to search)
        Response: the object will be sent back corresponding Email.
        
      Validation
       ----------
       I have applied validation on data specified in the challenge which includes: 
       1. email and National id must not be blank.
       2. National ID must be 16 digits and is Unique
       3. Email has to be valid with either gmail.com or yahoo.com 
       4. Phone number has to be valid and rwandan(it means has to start with +250 and be 9 number after)  and must be unique
       5. Employees below 18years old are not allowed 
       6. only active and inactive status allowed 
      
      
        
