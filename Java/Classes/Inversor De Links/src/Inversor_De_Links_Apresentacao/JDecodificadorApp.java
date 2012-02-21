package Inversor_De_Links_Apresentacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Inversor_De_Links_Inteligencia.DecodificadorHexadecimal;
import Inversor_De_Links_Inteligencia.ExportarTXT;
import Inversor_De_Links_Inteligencia.ImportarTXT;

class JDecodificadorApp extends JFrame implements KeyListener  {  
    
	public JInversorApp apresentacao;
		
	public JInversorApp getApresentacao() {
		return apresentacao;
	}

	public void setApresentacao(JInversorApp apresentacao) {
		this.apresentacao = apresentacao;
	}

	private static final long serialVersionUID = 2L;  
	       
	private JTextArea campoSai,campo1;  
	private JMenuBar barraMenu;  
	private JMenu menuArquivo;  
	private JMenuItem menuSair;  
	
	public JDecodificadorApp(JInversorApp inversor){
		   
		  this.apresentacao = inversor;
		  this.apresentacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.montaTela();
		  
	}
	   
	public JDecodificadorApp() { 
		
		this.addKeyListener(this);
		this.montaTela(); 		 
	} 

	public void montaTela() {
	
		montaJanela();
		this.setJMenuBar(this.criaBarraMenu());
		criaCampos();
		montaBotaoDecodifica();
		montaBotaoLimpaCampos();
		mostraJanela();
	
	}

	private void montaJanela() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridBagLayout());  
	}

	private JMenuBar criaBarraMenu(){
		
		barraMenu = new JMenuBar();  
        barraMenu.add(criaMenuArquivo());  
        barraMenu.add(criaMenuFunction());
        
      return barraMenu;
        
	}
	
	private JMenu criaMenuArquivo(){
		menuArquivo = new JMenu();  
        menuArquivo.setText("Arquivo");  
        menuArquivo.add(criaFuncaoImportaTxt_MenuArquivo());
        menuArquivo.add(criaFuncaoAbrirNotepad_MenuArquivo());
        menuArquivo.add(criaFuncaoSalvarNotepad_MenuArquivo());
        menuArquivo.add(criaFuncaoSair_MenuArquivo()); 
        
        return menuArquivo;
	}
	
	private JMenu criaMenuFunction(){
		
		JMenu menuFunction = new JMenu();
		menuFunction.setText("Function");
		menuFunction.add(criaFuncaoGoToInversorLinks_MenuFunction());
	
		return menuFunction;
	}
	
	private JMenuItem criaFuncaoGoToInversorLinks_MenuFunction(){
		
		JMenuItem menuGotoInversorDeLinks = new JMenuItem();
		menuGotoInversorDeLinks.setText("Inverter Links");
		menuGotoInversorDeLinks.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDecodificadorApp.this.setVisible(false);
				apresentacao.setVisible(true);					
			}
		});
	
		return menuGotoInversorDeLinks;
	}
	
	private JMenuItem criaFuncaoSair_MenuArquivo(){
		
		menuSair = new JMenuItem();  
        menuSair.setText("Sair");  
        menuSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);					
			}
		});
        
        return menuSair;
	}
	
	private JMenuItem criaFuncaoImportaTxt_MenuArquivo(){
		
		JMenuItem menuImportar = new JMenuItem();  
		menuImportar.setText("Importar txt");  
		menuImportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ImportarTXT importador = new ImportarTXT();
				campo1.setText(importador.importaTxt());
			}
		});
        
        return menuImportar;
	}
	
	private JMenuItem criaFuncaoAbrirNotepad_MenuArquivo(){
		
		JMenuItem menuExportar = new JMenuItem();  
		menuExportar.setText("Abrir no Bloco de Notas");  
		menuExportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ExportarTXT exportaTXT = new ExportarTXT();
				try {
					exportaTXT.salvarTemporario(campoSai.getText());
					
					Runtime.getRuntime().exec("notepad " + exportaTXT.getNomeDoArquivo());  
				
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
        
        return menuExportar;
	}
	
	private JMenuItem criaFuncaoSalvarNotepad_MenuArquivo(){
		
		JMenuItem menuExportar = new JMenuItem();  
		menuExportar.setText("Salvar txt");  
		menuExportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ExportarTXT exporta = new ExportarTXT();
				exporta.salvarTXT(campoSai.getText(), JDecodificadorApp.this);
				JOptionPane.showMessageDialog(null, "O Arquivo foi salvo com sucesso!", "Aviso", 1);
			}
		});
        
        return menuExportar;
	}

	private void montaBotaoDecodifica(){
		
		JButton botaoDecodifica = new JButton("Decodificador");
		botaoDecodifica.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				String texto = campo1.getText();  
				Font f = campoSai.getFont(); 
			
				DecodificadorHexadecimal decodificador = new DecodificadorHexadecimal();
			           
				try {
					campoSai.setText(decodificador.decodifica(texto));    
					campoSai.setFont(f.deriveFont(Font.BOLD));  
					campoSai.setForeground(Color.BLACK); } catch (Exception exeption) {
			
						JOptionPane.showMessageDialog(null, "O valor: " + decodificador.getValorNaoDecimal() + "; \n" + 
								"Do texto hexadecimal: " + texto + "; \n" +
								" não é um valor Hexadecimal reconhecido!");
				}		
			}
		});
	
		this.add(botaoDecodifica);
	}

	private void montaBotaoLimpaCampos(){
		
		JButton botaoLimpaCampos = new JButton("Limpar");
		
		botaoLimpaCampos.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				campo1.setText("");  
				campoSai.setText("");  
			}
		});
	
		this.addKeyListener(this);
		this.add(botaoLimpaCampos);
	}

	private void mostraJanela(){
		
		this.setSize(500, 500);
	}
	
	private void criaCampos(){
	  
	    campo1 = new JTextArea();  
	    campoSai = new JTextArea();  
	    campoSai.setEditable(false);
	    campoSai.setLineWrap(true);
	    
	    campo1.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE )  
			        System.exit(0);  
			}
			
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE )  
			        System.exit(0);
			}
			
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE )  
			        System.exit(0);
			}
		});
	    
	    this.add("Entre com o codigo a Decodificar", campo1);
	    this.add2("Codigo decodificado", new JScrollPane(campoSai));
	 
	}

	public void add(String label, JComponent componente ) {  
        GridBagConstraints cons = new GridBagConstraints();  
        cons.fill = GridBagConstraints.NONE;  
        cons.anchor = GridBagConstraints.NORTHWEST;  
        cons.insets = new Insets(4,4,4,4);  
  
        cons.weightx = 0;  
        cons.gridwidth = 1;  
        this.getContentPane().add(new JLabel(label), cons);  
          
        cons.fill = GridBagConstraints.BOTH;  
        cons.weightx = 1;  
        cons.gridwidth = GridBagConstraints.REMAINDER;  
        this.getContentPane().add(componente, cons);  
	}

	public void add(JButton botao){
		 GridBagConstraints cons = new GridBagConstraints();  
	        cons.fill = GridBagConstraints.NONE;  
	        cons.anchor = GridBagConstraints.NORTHWEST;  
	        cons.insets = new Insets(4,4,4,4);  
	  
	        cons.weightx = 0;  
	        cons.gridwidth = 1;  
	        this.getContentPane().add(botao, cons);
		
	}

	public void add2(String label, JScrollPane componente ) {  
	        GridBagConstraints cons = new GridBagConstraints();  
	        cons.fill = GridBagConstraints.NONE;  
	        cons.anchor = GridBagConstraints.NORTHWEST;  
	        cons.insets = new Insets(4,4,4,4);  
	        cons.weighty = 1;  
	        cons.gridheight = GridBagConstraints.RELATIVE;  
	          
	        cons.weightx = 0;  
	        cons.gridwidth = 1;  
	        this.getContentPane().add(new JLabel(label), cons);  
	          
	        cons.fill = GridBagConstraints.BOTH;  
	        cons.weightx = 1;  
	        cons.gridwidth = GridBagConstraints.REMAINDER;  
	        this.getContentPane().add(componente, cons);  
    }     

	public void keyTyped(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE )  
	        System.exit(0);  
	}
	
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE )  
	        System.exit(0);
	}
	
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE )  
	        System.exit(0);
	}

}	