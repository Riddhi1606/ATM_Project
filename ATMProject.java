package com.studyopedia;
import java.sql.*;
import java.util.Scanner;

public class ATMProject {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/atm_db";
        String user = "root";
        String password = ""; 

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.print("Enter your PIN: ");
            int pin = sc.nextInt();

            // Check user by PIN
            String query = "SELECT * FROM users WHERE pin=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, pin);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");

                System.out.println("Welcome " + name);

                int choice = 0;

                while (choice != 4) {

                    System.out.println("\n--- ATM MENU ---");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Exit");
                    System.out.print("Enter choice: ");

                    choice = sc.nextInt();

                    if (choice == 1) {
                        System.out.println("Your balance is: " + balance);
                    }

                    else if (choice == 2) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = sc.nextDouble();

                        balance = balance + amount;

                        String update = "UPDATE users SET balance=? WHERE id=?";
                        PreparedStatement pst2 = con.prepareStatement(update);
                        pst2.setDouble(1, balance);
                        pst2.setInt(2, id);
                        pst2.executeUpdate();

                        System.out.println("Amount deposited successfully!");
                    }

                    else if (choice == 3) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = sc.nextDouble();

                        if (amount <= balance) {
                            balance = balance - amount;

                            String update = "UPDATE users SET balance=? WHERE id=?";
                            PreparedStatement pst3 = con.prepareStatement(update);
                            pst3.setDouble(1, balance);
                            pst3.setInt(2, id);
                            pst3.executeUpdate();

                            System.out.println("Amount withdrawn successfully!");
                        } else {
                            System.out.println("Insufficient balance!");
                        }
                    }

                    else if (choice == 4) {
                        System.out.println("Thank you for using ATM!");
                    }

                    else {
                        System.out.println("Invalid choice!");
                    }
                }

            } else {
                System.out.println("Wrong PIN!");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}