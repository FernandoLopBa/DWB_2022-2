package com.flb.practica01;

public class Customer{

    private int customer_id;

    private String name;

    private String surname;
    
    private String rfc;

    private String mail;

    private Region region;

    public Customer(int customer_id, String name, String surname, String rfc,
	    String mail, Region region){
	this.customer_id = customer_id;
	this.name = name;
	this.surname = surname;
	this.rfc = rfc;
	this.mail = mail;
	this.region = region;
    }

    public int getId(){
	return customer_id;
    }

    public String getName(){
	return name;
    }

    public String getSurname(){
	return surname;
    }

    public String getRfc(){
	return rfc;
    }

    public String getMail(){
	return mail;
    }

    public Region getRegion(){
	return region;
    }

    public void setId(int customer_id){
	this.customer_id = customer_id;
    }

    public void setName(String name){
	this.name = name;
    }

    public void setSurname(String surname){
	this.surname = surname;
    }

    public void setRfc(String rfc){
	this.rfc = rfc;
    }

    public void setMail(String mail){
	this.mail = mail;
    }

    public void setRegion(Region region){
	this.region = region;
    }

    @Override
    public String toString(){
	return String.format("Customer_id: %d\nName       : %s\nSurname    : %s\nRFC        : %s\nMail       : %s\nRegion     : %s",customer_id, name, surname, rfc, mail, region.toString());
    }


    public String insert(){
	return String.format("%d, %s, %s, %s, %s, %d", customer_id, name, surname, rfc, mail, region.getId());
    }
}
