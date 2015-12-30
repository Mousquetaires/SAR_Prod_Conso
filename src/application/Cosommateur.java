package application;
import service.*;
import java.util.Scanner;
import reseau.*;

public class Cosommateur {

	public static void main(String[] args) {
		reseau.Consommateur consRe=new reseau.Consommateur();
		service.Consommateur consS=new service.Consommateur(consRe);
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.println("Bienvenue dans le service du consommateur/n Veillez entrer l'adresse IP du tampon pour consommer un message s'il y'en a ");
			String temp=sc.nextLine();
			
			consS.demande(temp);
						
			
			
		}
		// TODO Auto-generated method stub

	}

}
