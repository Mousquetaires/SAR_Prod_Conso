package service;
import reseau.*;


public class Producteur {
	
	public static boolean autorisation=false;
	String id;
	String mess;
	reseau.Producteur p;
	static String ack="ACK";
	static String refu="REFUS";
		
	/*A definir le requete*/
	String req = "REQ";
	
	public Producteur(reseau.Producteur p){
		this.p = p;
	}
	public static boolean getAuto(){
		return autorisation;
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

	public static void surReceptionDe(String mess){
		System.out.println("dans sureceptionDe ");
		if(mess.equals(ack)){
			autorisation = true;
		}else{
			if(mess.equals(refu)){
				System.out.println("Rien a faire");
			}
			
		}
	}

    
   

}