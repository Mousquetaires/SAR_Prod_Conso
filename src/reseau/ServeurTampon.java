package reseau;

import java.io.*;
import java.net.*;

public class ServeurTampon {
    static ServerSocket socketServeur;
    static Socket socketService;
    static int port = 4020;
    
    
    public static void main(String[] args){
    	try{
			socketServeur = new ServerSocket(port);			
        	System.out.println("Le serveur est pret a l'écoute !");
        	
        	while (true) {
				socketService = socketServeur.accept();			
    			System.out.println("La connexion est accpetée");
    			ThreadTampon threadTampon = new ThreadTampon(socketService);
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
    
    
    

}