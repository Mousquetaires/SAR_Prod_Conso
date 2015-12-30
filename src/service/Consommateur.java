package service;


public class Consommateur {
    public String id;
    public String mess;
    reseau.Consommateur cons;
    String req="REQ";
    
    

    public Consommateur(reseau.Consommateur consoR) {
    	this.cons=consoR;
    }

    public void demande(String dest ) {
    	cons.envoyerA(dest, req);
    	
    }

    public static void surReceptionDe(String message) {
    	if(message!="REFUS"){
    		System.out.println(message);
    	}else{
    		System.out.println("Pas de message");
    	}
    		
    }

}
