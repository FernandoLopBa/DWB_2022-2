package com.flb.practica01;

import java.sql.*;
import java.util.Scanner;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class Practica01{

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	JDBCPostgreSQLConnection con = new JDBCPostgreSQLConnection();
	int opcion;
	do{
	    System.out.println("¿Qué desea hacer?\n"+
		    "1) Consultar todos los customer registrados\n" +
		    "2) Registrar customer\n" +
		    "3) Eliminar customer\n" +
		    "0) Terminar\n");
	    opcion = sc.nextInt();
	    switch(opcion){
		case 1:
		    con.getCustomers();
		    break;
		case 2:
		    System.out.printf("Inserte el customer_id:");
		    int customer_id = sc.nextInt();
		    System.out.printf("Inserte el name:");
		    String name = sc.next();
		    System.out.printf("Inserte surname:");
		    String surname = sc.next();
		    System.out.printf("Inserte rfc:");
		    String rfc = sc.next();
		    System.out.printf("Inserte mail:");
		    String mail = sc.next();
		    System.out.printf("Inserte region_id:");
		    int region_id = sc.nextInt();
		    Region region = getRegion(region_id);
		    Customer customer = new Customer(customer_id, name, surname, rfc, mail, region);
		    con.createCustomer(customer);
		    break;
		case 3:
		    System.out.printf("Inserte el customer_id del customer a eliminar:");
		    int customer_id2 = sc.nextInt();
		    con.deleteCustomer(customer_id2);
		    break;
		case 0:
		    break;
		default:
		    System.out.println("Seleccione una opción válida");
	    }
	}while(opcion != 0);
	/*
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/customer_region",
            "cus_reg", "cus_reg");
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "CREATE TABLE COMPANY " +
            "(ID INT PRIMARY KEY     NOT NULL," +
            " NAME           TEXT    NOT NULL, " +
            " AGE            INT     NOT NULL, " +
            " ADDRESS        CHAR(50), " +
            " SALARY         REAL)";
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
      */
	/*
	JDBCPostgreSQLConnection app = new JDBCPostgreSQLConnection();
	app.connect();
	*/
    }

    public static Region getRegion(int region_id){
	return null;
    }
}
