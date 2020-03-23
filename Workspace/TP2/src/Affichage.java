import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

public class Affichage extends Thread{
	private String texte; 
	private static Exclusion sectionImpression = new Exclusion();
	private static SemaphoreBinaire semaphoreB = new SemaphoreBinaire(1);
	
	public Affichage (String txt){texte=txt;}
	
	public void run(){
		semaphoreB.syncWait();
		System.out.println("vous êtes dans la section critique");
		synchronized(sectionImpression){
			for (int i=0; i<texte.length(); i++){
				System.out.print(texte.charAt(i));
				try {sleep(100);} catch(InterruptedException e){};
			}
		}
		semaphoreB.syncSignal();
		System.out.println("\nvous êtes sorti dans la section critique\n");
	}
}
