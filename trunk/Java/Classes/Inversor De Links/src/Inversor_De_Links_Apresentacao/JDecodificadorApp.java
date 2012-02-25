package Inversor_De_Links_Apresentacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import Inversor_De_Links_Inteligencia.DecodificadorHexadecimal;

class JDecodificadorApp extends JTelaPrincipal  {  
    
	private static final long serialVersionUID = -4193423691075032937L;



	public JDecodificadorApp() { 
		   
		 this.montaTela();
	}
	   

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
		
		JButton botaoDecodifica = new JButton("Decodificador");
		botaoDecodifica.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				String texto = JDecodificadorApp.this.campo1.getText();  
				Font f = JDecodificadorApp.this.campoSai.getFont(); 
			
				DecodificadorHexadecimal decodificador = new DecodificadorHexadecimal();
			           
				try {
					JDecodificadorApp.this.campoSai.setText(decodificador.decodifica(texto));    
					JDecodificadorApp.this.campoSai.setFont(f.deriveFont(Font.BOLD));  
					JDecodificadorApp.this.campoSai.setForeground(Color.BLACK); 
				} catch (Exception exeption) {
			
						JOptionPane.showMessageDialog(null, "O valor: " + decodificador.getValorNaoDecimal() + "; \n" + 
								"Do texto hexadecimal: " + texto + "; \n" +
								" não é um valor Hexadecimal reconhecido!");
				}		
			}
		});	
	
		this.add(botaoDecodifica);
	}	
	
	@Override
	protected final void criaCampos(){
		   
		this.add("Entre com o codigo a Decodificar", this.campo1);
		this.add2("Codigo decodificado", new JScrollPane(campoSai));
		 
	}	

	protected void implementaBotaoLimpaCampos(){
		
		JButton botao = super.montaBotaoLimpaCampos();
			
		botao.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JDecodificadorApp.this.campo1.setText(""); 
				JDecodificadorApp.this.campoSai.setText("");				
			}
		});	
	
		this.add(botao);
	}

	public String getCampoSaiTexto(){
		
		return campoSai.getText();
	}
}	