import java.awt.*;
import javax.swing.*;

class UnMobile extends JPanel implements Runnable
{
	int saLargeur, saHauteur, sonDebDessin;
    final int sonPas = 10, sonTemps=50, sonCote=40;
    static semaphore sem = new semaphore(2) {};
    
    UnMobile(int telleLargeur, int telleHauteur)
    {
	super();
	saLargeur = telleLargeur;
	saHauteur = telleHauteur;
	setSize(telleLargeur, telleHauteur);
    }

    public void run()
    {
	for (sonDebDessin=0; sonDebDessin+ sonPas < saLargeur-2*(saLargeur/3); sonDebDessin+= sonPas)
	    {
		repaint();
		try{Thread.sleep(sonTemps);}
		catch (InterruptedException telleExcp)
		    {telleExcp.printStackTrace();}
	    }
	
	
		sem.syncWait();
	for (sonDebDessin=saLargeur-2*(saLargeur/3); sonDebDessin + sonPas < saLargeur-(saLargeur/3); sonDebDessin+= sonPas)
	    {
		repaint();
		try{Thread.sleep(sonTemps);}
		catch (InterruptedException telleExcp)
		    {telleExcp.printStackTrace();}
	    }
		sem.syncWait();
    

	for (sonDebDessin=saLargeur-(saLargeur/3); sonDebDessin+ sonPas < saLargeur; sonDebDessin+= sonPas)
	    {
		repaint();
		try{Thread.sleep(sonTemps);}
		catch (InterruptedException telleExcp)
		    {telleExcp.printStackTrace();}
	    }
		sem.syncWait();
    }
   

    public void paintComponent(Graphics telCG)
    {
	super.paintComponent(telCG);
	telCG.fillRect(sonDebDessin, saHauteur/2, sonCote, sonCote);
    }
}	