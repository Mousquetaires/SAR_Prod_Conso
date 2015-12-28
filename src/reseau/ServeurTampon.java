package reseau;

import service.*;

import java.io.*;
import java.net.*;

public class ServeurTampon {
    static ServerSocket socketServeur;
    static Socket socketService;
    BufferedReader in = null;
    PrintWriter out = null;
    static int port = 4020;
    String msg; //pour lire un message sur le flux
    Tampon tampon;
    String conso;
    String prod;
    
    
    public static void main(String[] args){
    	try{
			socketServeur = new ServerSocket(port);			
        	System.out.println("Le serveur est pret a l'écoute !");
        	
        	while (true) {
				socketService = socketServeur.accept();			
    			System.out.println("La connexion est accpetée");
    			
    		}
        }catch(IOException e){
        	e.getMessage();    	
        }
        finally{
        	try{
        		socketServeur.close();
        	}catch(IOException e){
        		e.getMessage();
        	}
        }
    }
    
    
    public void envoyerA(String dest, String msg){
    	this.out.println(msg);
    }
   
    public void receptionP() {
    	while(true){
    		try {
				msg = this.in.readLine();
			} catch (IOException e) {
				e.getMessage();
			}
    		tampon.surReceptionDeP(prod, msg);
    	}
    }
    public void receptionC() {
    	while(true){
    		try {
				msg = this.in.readLine();
			} catch (IOException e) {
				e.getMessage();
			}
    		tampon.surReceptionDeC(conso, msg);
    	}
    }

}