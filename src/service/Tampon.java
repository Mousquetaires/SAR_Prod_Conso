package service;

<<<<<<< HEAD
public class Tampon {
   String id;
   String tabMess;
   String nbMess;
   String outc;
   String inp;
   public void surReceptionDeP() {}
   public void surReceptionDeC() {}
   public void autorisation() {}
=======
import reseau.*;

public class Tampon {   
    public String id;
    public String [] tabMess;  
    public int nbMess;
    public int outC;   
    public int inP;
    ServeurTampon serv;
    String req;
    
    
    public boolean autorisation(String producteur) {
    	String ack = "Vous avez l'autorisation de produir un message";
    	String refus = "Vous ne pouvez pas produir un message pour le moment";
    	if(nbMess<tabMess.length){
    		serv.envoyerA(producteur, ack);
    		return true;
    	}else{
    		serv.envoyerA(producteur, refus);
    		return false;
    	}
    }
    
    public void surReceptionDeP(String producteur, String msg) {
    	if(msg != req){
    		tabMess[inP] = msg;
    		inP = (inP+1)%tabMess.length;
    		nbMess++;
    	}else{
    		this.autorisation(producteur);
    	}
    }

   
    public void surReceptionDeC(String consommateur, String msg) {
    	String refus = "Il n'y a pas de messages dans le tampon"; 
    	if(nbMess>0){
    		msg = tabMess[outC];
    		outC = (outC+1)%tabMess.length;
    		nbMess--;
    		serv.envoyerA(consommateur, msg);
    	}else{
    		serv.envoyerA(consommateur, refus);
    	}
    }
>>>>>>> 9a6a7ec6e985b3b635b9d0041c97893f151d0f7a

}
