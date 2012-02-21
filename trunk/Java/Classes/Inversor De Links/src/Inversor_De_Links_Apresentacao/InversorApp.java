package Inversor_De_Links_Apresentacao;

import javax.swing.JFrame;  

public class InversorApp {

	public static void main(String[] args) {  
		JInversorApp frame = new JInversorApp();  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    frame.apresentacao = new JDecodificadorApp(frame);
		frame.pack();
	    frame.setVisible(true);   
	}  
}