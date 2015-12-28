package service;

import reseau.ThreadTampon;

public class Tampon {   
    public String id;
    public String [] tabMess;  
    public int nbMess;
    public int outC;   
    public int inP;
    ThreadTampon serv;
    String req = "REQ";
    String ack = "ACK";
    String refus = "REFUS";
    
    
    public boolean autorisation(String producteur) {    	
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
    	if(nbMess>0){
    		msg = tabMess[outC];
    		outC = (outC+1)%tabMess.length;
    		nbMess--;
    		serv.envoyerA(consommateur, msg);
    	}else{
    		serv.envoyerA(consommateur, refus);
    	}
    }

}
