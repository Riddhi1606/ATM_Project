ATM Machine Java Project

Overview:
This project is a simple console-based ATM system developed using Java and MySQL. It allows users to perform basic banking operations through a terminal interface.

Features:
- Secure login using PIN
- Check account balance
- Deposit money
- Withdraw money
- Data stored and updated in MySQL database

Technologies Used:
- Java
- JDBC (Java Database Connectivity)
- MySQL (XAMPP)
- Eclipse IDE

Project Structure:
ATMProject/
 ├── src/
 ├── bin/
 ├── atm_db.sql
 ├── README.txt

Database Setup:
1. Start XAMPP and run MySQL
2. Open phpMyAdmin (http://localhost/phpmyadmin)
3. Create database named atm_db
4. Run the SQL queries provided in atm_db.sql file

How to Run the Project:
1. Open the project in Eclipse
2. Add MySQL Connector JAR file to build path
3. Run ATMProject.java
4. Enter PIN to access ATM system

Sample User Data:
- Riddhi | PIN: 1234 | Balance: 5000
- Aman   | PIN: 1111 | Balance: 3000

Future Enhancements:
- Add multiple user registration
- Add transaction history
- Improve security features

