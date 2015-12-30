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
    public boolean autorisation = false;
    
    Socket socket;
    InetAddress dest;
    int portdest=4202 ;//port d'écoute du destinataire ou du serveur
    BufferedReader in;
    PrintStream out;
    

    public void produire() {
    	
    }

    public void demande(boolean autorisation) {
    	if(autorisation = true){
    		produire();
    	}
    }

    public void envoyerA(String dest,String message) {
    	try {
    		this.dest=InetAddress.getByName(dest);
			socket= new Socket(this.dest,portdest);
			if(socket.isConnected())
				System.out.println("Connexion établit avec l'hote :"+dest);
				in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out= new PrintStream(socket.getOutputStream());
				out.println("producteur");
				String p= in.readLine();
				System.out.println(p);
				out.println(message);
				receptionR();
						
		} catch (IOException e) {
			System.out.println("Adresse inconnue");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void receptionR() {
    	try {
			String rep=in.readLine();
			//String hote=(String)socket.getRemoteSocketAddress();
			service.Consommateur.surReceptionDe(rep);//reste comment faire l'adresse de l'emetteur afaire
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally{
    	try {
			in.close();
			out.close();
	    	socket.close();
	    	System.out.println("Déconnexion");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	}
    }
   

}
