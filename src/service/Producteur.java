package service;
<<<<<<< HEAD
import java.net.InetAddress;
=======

>>>>>>> 4c8f5337cbc3599116823b5d9f7d607e3bb10b80

public class Producteur {
	
	public static boolean autorisation=false;
	String id;
	String mess;
	static reseau.Producteur p;
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
	public void produire(String mess) {
		
		while(autorisation == false){
			System.out.println("pas de Place ");
		}
		if(autorisation == true){
			System.out.println("dans produire");
			p.envoyerA(mess);
			autorisation = false;
			p.demander=false;
			
		}
	}
    public void demande(String dest) {
    	p.envoyerA(req);
    	
    }

<<<<<<< HEAD
	public void surReceptionDe(InetAddress dest, String mess){
		if(mess == "ACK"){
=======
	public static void surReceptionDe(String mess){
		System.out.println("dans sureceptionDe ");
		System.out.println(mess);
		if(mess.equals(ack)){
>>>>>>> 4c8f5337cbc3599116823b5d9f7d607e3bb10b80
			autorisation = true;
		}else if(mess.equals(refu)){
				System.out.println("Pas de Place dans le tampon");
			}
			
		}
	}

    
   

