package org.example;

import models.Avai_books;
import models.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static final String LIBRARY_TABLE = "Library";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String url = "jdbc:sqlite:mydb.db";
        System.out.println("Enter Name, Address and Phone Number");
        String Name= sc.next();
        String Address=sc.next();
        String pnum=sc.next();
        Avai_books a1=new Avai_books();
        a1.viewBooks();
        System.out.println("Enter Corresponding Number for ordering book");
        int num= sc.nextInt();
        Order b1=null;
        switch (num){
            case 1:
                b1= new Order("The Great Gatsby",1);
                break;
            case 2:
                b1= new Order("The Picture of Dorian Gray",1);
                break;
            case 3:
                b1= new Order("Wuthering Heights" ,1);
                break;
            case 4:
                b1= new Order("Great Expectations" ,1);
                break;
            case 5:
                b1= new Order("The Kite Runner" ,1);
                break;
            default:
                System.out.println("invalid");
                break;

        }
        String createStatementSql = "CREATE TABLE IF NOT EXISTS " + LIBRARY_TABLE + "(" +
                "id INTEGER PRIMARY KEY , " +
                "Name TEXT, " +
                "Address TEXT, " +
                "PhoneNum TEXT, " +
                "Bookname TEXT," +
                "Quantity INTEGER) " ;
        System.out.println(createStatementSql);
        try {
            Connection connection = DriverManager.getConnection(url);
            System.out.println("Connected");


            Statement statement = connection.createStatement();

            statement.execute(createStatementSql);



            String insertRecordSQL = "INSERT INTO " + LIBRARY_TABLE + " (Name, Address, PhoneNum, Bookname, Quantity) " +
                    "VALUES (?, ?, ?, ?, ?)";



            PreparedStatement preparedStatement = connection.prepareStatement(insertRecordSQL);

            preparedStatement.setString(1, Name);
            preparedStatement.setString(2, Address);
            preparedStatement.setString(3,pnum);
            preparedStatement.setString(4,b1.getBookname());
            preparedStatement.setInt(5, b1.getQuantity());
            // Execute the prepared statement
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        b1.vieworder();


    }
}