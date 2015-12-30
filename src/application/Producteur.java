package application;
import service.*;

import java.util.Scanner;

import service.Tampon;

public class Producteur {
	

	static service.Producteur pro;
	service.Tampon t;
	static Scanner scan = new Scanner(System.in);
	String tamp;
	
	public static String saisirMessage(){
		String mess = scan.nextLine();
		mess.intern();
		return mess;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		reseau.Producteur proR=new reseau.Producteur();
		pro= new service.Producteur(proR);
		
		while(true){
			System.out.println("Bienvenue dans le Producteur/n Veuillez entrer l'adresse du tampon ");
			String temp=saisirMessage();
			pro.demande(temp);
			//System.out.println("Entre dans saisir message");
			//System.out.println("Je suis dans autorisation");
			System.out.println("Veuillez entrer votre message a envoyer au Tampon");
			String tem2=saisirMessage();
			pro.produire(temp, tem2);
				
			
			
			
			
			
		}
		
		

	}

}
