import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class UneFenetre extends JFrame implements ActionListener
{
    UnMobile sonMobile;UnMobile sonMobile2;
    private final int LARG=400, HAUT=250;
    Thread laTache; Thread laTache2;
    JButton button; JButton button2;
    
    public UneFenetre()
    {
    	this.setLayout(new GridLayout(2,2));
    	
    	//1er mobile
    	sonMobile = new UnMobile(LARG,HAUT);
    	this.add(sonMobile);setVisible(true);
    	laTache = new Thread(sonMobile);
    	laTache.start();
    	this.setSize(650,400);
    	button = new JButton("Arrêt ou Redémarrer");
    	button.addActionListener(this);
    	this.add(button);
    	
    	//2ème mobile
    	sonMobile2 = new UnMobile(LARG,HAUT);
    	this.add(sonMobile2);
    	laTache2 = new Thread(sonMobile2);
    	laTache2.start();
    	button2 = new JButton("Arrêt ou Redémarrer");
    	button2.addActionListener(this);
    	this.add(button2);
    	
    }

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource()==button){
			if(sonMobile.getActivity()==true){
				laTache.suspend();
				sonMobile.setActivity(false);
			}
			else{
				laTache.resume();
				sonMobile.setActivity(true);

			}
		}
		
		if (e.getSource()==button2){
			if(sonMobile2.getActivity()==true){
				laTache2.suspend();
				sonMobile2.setActivity(false);
			}
			else{
				laTache2.resume();
				sonMobile2.setActivity(true);

			}
		}
		
	}
}
