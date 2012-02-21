package Inversor_De_Links_Apresentacao;

import javax.swing.JFrame;

public class DecodificadorApp {

	public static void main(String[] args) {
		
		JDecodificadorApp function = new JDecodificadorApp();
		function.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		function.apresentacao = new JInversorApp(function);
		function.apresentacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		function.setVisible(true);		
	}
}