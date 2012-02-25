package Inversor_De_Links_Apresentacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import Inversor_De_Links_Inteligencia.Inversor;

class JInversorApp extends JTelaPrincipal{
	
	private static final long serialVersionUID = 1L;



	public JInversorApp() { montaTela(); }
	   

	protected void montaTela() {
	
		super.montaJanela();
		this.inicializaCampos();
		this.criaCampos();
		this.montaBotaoFuncao();
		this.implementaBotaoLimpaCampos();
		super.mostraJanela();
	
	}


	@Override
	protected final void montaBotaoFuncao(){
		
		JButton botaoDecodifica = new JButton("Inverter");
		botaoDecodifica.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				String texto = campo1.getText();  
				Font f = campoSai.getFont(); 
			
				Inversor inversor = new Inversor();
			           
				campoSai.setText(inversor.invert(texto));    
				campoSai.setFont(f.deriveFont(Font.BOLD));  
				campoSai.setForeground(Color.BLACK);
			}
		});
	
		this.add(botaoDecodifica);
	}	
	
	@Override
	protected final void criaCampos(){
	    
	    this.add("Entre com o Texto a ser invertido", this.campo1);
	    this.add2("Texto Invertido", new JScrollPane(this.campoSai));
	 
	}

	protected void implementaBotaoLimpaCampos(){
		
		JButton botao = super.montaBotaoLimpaCampos();
			
		botao.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				campo1.setText(""); 
				campoSai.setText("");				
			}
		});	
	
		this.add(botao);
	}
}	