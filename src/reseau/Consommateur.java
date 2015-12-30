package reseau;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class Consommateur {

	int id;
    Socket socket;
    InetAddress dest;
    int portdest=4020 ;//port d'écoute du destinataire ou du serveur

    BufferedReader in;
    PrintStream out;
    
    
    public Consommateur(){
    	    	
    }

    public void reception(){
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
	    	System.out.println("fin de connexion avec le serveur");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	}
    }

       
    public void envoyerA(String dest,String message) {
    	String mess;
    	try {
    		System.out.println("dans envoyer a");
    		this.dest=InetAddress.getByName(dest);
			socket= new Socket(this.dest,portdest);
			if(socket.isConnected())
				System.out.println("Connexion établit avec l'hote :"+dest);
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out= new PrintStream(socket.getOutputStream());
			out.println("consommateur");
			mess=in.readLine();
			System.out.println(mess);
			out.println(message);
			reception();
						
		} catch (IOException e) {
			System.out.println("Adresse inconnue");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
   

}
