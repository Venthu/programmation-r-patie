import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class UneFenetre extends JFrame 
{
UnMobile sonMobile;
UnMobile sonMobile2;
UnMobile sonMobile3;
UnMobile sonMobile4;


private final int LARG=1130, HAUT=250;
Thread laTache;
Thread laTache2;
Thread laTache3;
Thread laTache4;



public UneFenetre()
	{
	///ajouter sonMobile a la fenetre
	///creer une thread laThread avec sonMobile
	///afficher la fenetre
	///lancer laThread
	
	this.setLayout(new GridLayout(4,4));
	sonMobile = new UnMobile(LARG,HAUT);
	this.add(sonMobile);setVisible(true);
	laTache = new Thread(sonMobile);
	laTache.start();
	
	//2ème mobile
	sonMobile2 = new UnMobile(LARG,HAUT);
	this.add(sonMobile2);
	laTache2 = new Thread(sonMobile2);
	laTache2.start();

	//3ème mobile
	sonMobile3 = new UnMobile(LARG,HAUT);
	this.add(sonMobile3);
	laTache3 = new Thread(sonMobile3);
	laTache3.start();
	
	//4ème mobile
	sonMobile4 = new UnMobile(LARG,HAUT);
	this.add(sonMobile4);
	laTache4 = new Thread(sonMobile4);
	laTache4.start();

	
	this.setSize(800,800);
	}
}
