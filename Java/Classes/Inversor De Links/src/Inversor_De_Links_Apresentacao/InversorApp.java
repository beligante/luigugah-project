package Inversor_De_Links_Apresentacao;

public class InversorApp {

	public static void main(String[] args) {  
		JTelaPrincipal frame = new JTelaPrincipal();
		frame.montaTelaPrincipal(); 		 
		frame.addKeyListener(frame);
		frame.setVisible(true);
	}  	
}