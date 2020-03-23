import java.awt.*;
import javax.swing.*;

class UnMobile extends JPanel implements Runnable
{
    int saLargeur, saHauteur, sonDebDessin;
    final int sonPas = 10, sonTemps=50, sonCote=40;
    boolean activity;
    
    UnMobile(int telleLargeur, int telleHauteur)
    {
	super();
	saLargeur = telleLargeur;
	saHauteur = telleHauteur;
	setSize(telleLargeur, telleHauteur);
    }

    public void run()
    {
		activity= true;
    for (sonDebDessin=0; sonDebDessin < 300; sonDebDessin+= sonPas)
	    {
		repaint();
		try{Thread.sleep(sonTemps);}
		catch (InterruptedException telleExcp)
		    {telleExcp.printStackTrace();}
	    }
    for (sonDebDessin=300; sonDebDessin > 0; sonDebDessin-= sonPas)
    {
    	repaint();
    	try{Thread.sleep(sonTemps);}
    	catch (InterruptedException telleExcp)
    		{telleExcp.printStackTrace();}
    	}
	}
    
    

    
    public boolean getActivity(){
    	return activity;
    }
    
    public void setActivity(boolean bool){
    	activity = bool;
    }
    
    public void paintComponent(Graphics telCG)
    {
	super.paintComponent(telCG);
	telCG.fillRect(sonDebDessin, saHauteur/2, sonCote, sonCote);
    }
}