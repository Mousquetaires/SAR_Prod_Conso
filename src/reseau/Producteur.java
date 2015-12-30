package reseau;
import java.net.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Producteur {
   
	public String id;
    public String mess;
     
    Socket socket;
    InetAddress dest;
    int portdest=4020 ;//port d'écoute du destinataire ou du serveur
    BufferedReader in;
    PrintStream out;
<<<<<<< HEAD
    service.Producteur p;
    
   

    public void envoyerA(String dest,String message) {
=======
    public boolean demander=false;
    
    public Producteur(){
    	String desti="192.168.1.33";
    	try {
			dest= InetAddress.getByName(desti)	;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public void connexion(){
>>>>>>> 4c8f5337cbc3599116823b5d9f7d607e3bb10b80
    	try {
			socket= new Socket(this.dest,portdest);
			if(socket.isConnected())
				System.out.println("Connexion établit avec l'hote :"+dest);
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out= new PrintStream(socket.getOutputStream());
			out.println("producteur");
			String p= in.readLine();
			System.out.println(p);
		} catch (IOException e) {
			System.out.println("Adresse inconnue");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
    }
    
    public void envoyerA(String message) {
    	if(demander==false){
    		System.out.println("dans envoyer a de if");
    		connexion();
    		out.println(message);
    		receptionR();
    		
    	}else{
    		System.out.println("dans envoyer a de else");
    		connexion();
    		out.println(message);
    	}
    	
	
    }
    public void receptionR() {
    	try {
    		//System.out.println("reception r");
 		
			String rep=in.readLine();
<<<<<<< HEAD
			//String hote=(String)socket.getRemoteSocketAddress();
			p.surReceptionDe(dest, rep);;//reste comment faire l'adresse de l'emetteur afaire
=======
			System.out.println(rep);
			service.Producteur.surReceptionDe(rep);
			demander=true;
>>>>>>> 4c8f5337cbc3599116823b5d9f7d607e3bb10b80
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally{
    	
    	}
    }
   

}
