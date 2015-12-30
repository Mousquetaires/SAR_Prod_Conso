package application;

import java.util.Scanner;

import service.Tampon;

public class Producteur {
	

	service.Producteur pro;
	service.Tampon t;
	Scanner scan = new Scanner(System.in);
	String tamp;
	
	public String saisirMessage(String mess){
		mess = scan.nextLine();
		return mess;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		

	}

}
