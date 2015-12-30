package reseau;

import java.io.*;
import java.net.Socket;

import service.Tampon;

public class ThreadTampon extends Thread{
	Socket socket = null;
	BufferedReader in = null;
	PrintWriter out = null;
	String msg; //pour lire un message sur le flux
	Tampon tampon;
	String conso;
	String prod;

	public ThreadTampon(Socket s){
		socket = s;
		start();
	}
	
	public void run(){
		try{
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new PrintWriter(socket.getOutputStream(),true);
			
			 if(type() == "producteur"){
				 out.println("type producteur reçu !");
				 this.receptionP();
			 }else{
				 out.println("type consommateur reçu !");
				 this.receptionC();
			 }			
		}catch(IOException e){
			e.getMessage();
		}
	}
	
	public String type(){
		String p = "producteur";	
		String str = "";
		try {
			str = in.readLine();
		} catch (IOException e) {
			e.getMessage();
		}		
		if(str == p)
			return "producteur";
		else
			return "consommateur";
	}	
	
	public void envoyerA(String dest, String msg){
    	out.println(msg);
    }
   
    public void receptionP() {
    	while(true){
    		try {
				msg = in.readLine();
			} catch (IOException e) {
				e.getMessage();
			}
    		tampon.surReceptionDeP(prod, msg);
    	}
    }
    public void receptionC() {
    	while(true){
    		try {
				msg = in.readLine();
			} catch (IOException e) {
				e.getMessage();
			}
    		tampon.surReceptionDeC(conso, msg);
    	}
    }
}
