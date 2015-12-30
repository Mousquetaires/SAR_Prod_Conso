package reseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class Producteur {
   
	public String id;
    public String mess;
     
    Socket socket;
    InetAddress dest;
    int portdest=4020 ;//port d'écoute du destinataire ou du serveur
    BufferedReader in;
    PrintStream out;
    boolean demander=false;
 

    
 
    public void envoyerA(String dest,String message) {
    	try {
    		if(demander==false){
	    		this.dest=InetAddress.getByName(dest);
	    		//System.out.println("apreé envoyer-a");
				socket= new Socket(this.dest,portdest);
				if(socket.isConnected())
					System.out.println("Connexion établit avec l'hote :"+dest);
				in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out= new PrintStream(socket.getOutputStream());
    		}
			
				out.println("producteur");
				String p= in.readLine();
				System.out.println(p);
				
			
				Thread.currentThread().sleep(2000);
				out.println(message);
				receptionR();
				
								
			} catch (IOException | InterruptedException e) {
			System.out.println("Adresse inconnue");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void receptionR() {
    	try {
    		//System.out.println("reception r");
 		
			String rep=in.readLine();
			//System.out.println("recuperation r");
			service.Producteur.surReceptionDe(rep);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally{
    	
    	}
    }
   

}
