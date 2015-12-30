package service;
import java.net.InetAddress;

public class Producteur {
	
	static boolean autorisation;
	String id;
	String mess;
	reseau.Producteur p;
	
	/*A definir le requete*/
	String req = "REQ";
	
	public Producteur(reseau.Producteur p){
		this.p = p;
	}
	public void produire(String dest, String mess) {
		
		while(autorisation == false){
			System.out.println("pas de message");
		}
		if(autorisation == true){
			
			p.envoyerA(dest, mess);
			autorisation = false;
			
		}
	}
    public void demande(String dest) {
    	p.envoyerA(dest, req);
    }

	public void surReceptionDe(InetAddress dest, String mess){
		if(mess == "ACK"){
			autorisation = true;
		}else{
			if(mess == "REFUS"){
				System.out.println("Rien a faire");
			}
		}
	}

    
   

}