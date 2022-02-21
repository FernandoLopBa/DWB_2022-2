package com.flb.practica01;

import java.sql.*;
import java.util.Scanner;

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
		    Region region = con.getRegion(region_id);
		    if(region == null){
			System.out.println("La región no existe, se va a añadir");
			System.out.printf("Inserte el nombre de la región:");
			String region_name = sc.next();
			region = new Region(region_id, region_name);
		    }
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
    }
}
