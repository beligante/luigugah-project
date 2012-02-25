package Inversor_De_Links_Apresentacao;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

import Inversor_De_Links_Inteligencia.ExportarTXT;
import Inversor_De_Links_Inteligencia.ImportarTXT;

public class JTelaPrincipal extends JFrame implements KeyListener {
	private static final long serialVersionUID = 5676007763062499414L;
	
	protected JTextArea campoSai,campoSai2, campo1,campo2;
	private JMenuBar barraMenu;  
	private JMenu menuArquivo, menuFuncao;  
	private JMenuItem menuSair, inversorDeLinks, decodificador;  
	private JTabbedPane abas;
	private JPanel painelPrincipal;

	public JTelaPrincipal() {} 

	public void montaTelaPrincipal() {
	
		this.montaJanela2();
		this.inicializaCampos();
		this.montaPainelPrincipal();
		this.setJMenuBar(this.criaBarraMenu());
		this.montaAbas();
		mostraJanela();
	}

	protected void montaTela() {}
	
	private void montaPainelPrincipal() {
		painelPrincipal = new JPanel(new GridLayout());
		painelPrincipal.setLayout(new BorderLayout());
		
		this.add(this.painelPrincipal);
	}
	
	private void montaJanela2() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	
	protected void montaJanela() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridBagLayout());  
	}

	private JMenuBar criaBarraMenu(){
		
		barraMenu = new JMenuBar();  
        barraMenu.add(criaMenuArquivo());  
        barraMenu.add(criaMenuFuncao());
        
      return barraMenu;
        
	}
	
	private void montaAbas() {
		abas = new JTabbedPane();
		abas.addTab("Inversor de Links", null);
		abas.addTab("Decodificador Hexadecimal", null);

		abas.setTabComponentAt(0, new ButtonTabComponent(abas));
		abas.setTabComponentAt(1, new ButtonTabComponent(abas));
		
		abas.setComponentAt(0, new JInversorApp().getContentPane());
		abas.setComponentAt(1, new JDecodificadorApp().getContentPane());
		
		this.painelPrincipal.add(abas, 0);
	}
	
	protected JMenu criaMenuArquivo(){
		menuArquivo = new JMenu();  
        menuArquivo.setText("Arquivo");  
        menuArquivo.add(criaFuncaoImportaTxt_MenuArquivo());
        menuArquivo.add(criaFuncaoAbrirNotepad_MenuArquivo());
        menuArquivo.add(criaFuncaoSalvarNotepad_MenuArquivo());
        menuArquivo.add(criaFuncaoSair_MenuArquivo()); 
        
        return menuArquivo;
	}
	
	private JMenu criaMenuFuncao(){
		menuFuncao = new JMenu();
		menuFuncao.setText("Funções");
		menuFuncao.add(criaFuncaoAbrirInversorDeLinks());
		menuFuncao.add(criaFuncaoAbrirDecodificador());
		
		return menuFuncao;
	}

	protected JMenuItem criaFuncaoSair_MenuArquivo(){
		
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
	
	protected JMenuItem criaFuncaoImportaTxt_MenuArquivo(){
		
		JMenuItem menuImportar = new JMenuItem();  
		menuImportar.setText("Importar txt");  
		menuImportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(abas.getTabCount() == 0){JOptionPane.showMessageDialog(null, "Você precisa ter abas ativas para poder importar Arquivos");}
				else
				{
					ImportarTXT importador = new ImportarTXT();				
					JTextArea campo = retornaCampo1DaAbaSelecionada();
					campo.setText(importador.importaTxt());
				}
			}
		});
        
        return menuImportar;
	}
	
	protected JMenuItem criaFuncaoAbrirNotepad_MenuArquivo(){
		
		JMenuItem menuExportar = new JMenuItem();  
		menuExportar.setText("Abrir no Bloco de Notas");  
		menuExportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ExportarTXT exportaTXT = new ExportarTXT();
				try 
				{
					if(abas.getTabCount() == 0){JOptionPane.showMessageDialog(null, "Você precisa ter abas ativas para poder abrir no bloco de Notas");}
					else
					{
						JTextArea texto = retornaCampoSaiDaAbaSelecionada();
						exportaTXT.salvarTemporario(texto.getText());
						Runtime.getRuntime().exec("notepad " + exportaTXT.getNomeDoArquivo());
					}
				
				} catch (IOException e1) 
					{
						e1.printStackTrace();
					}
			}
		});
        
        return menuExportar;
	}
	
	protected JMenuItem criaFuncaoSalvarNotepad_MenuArquivo(){
		
		JMenuItem menuExportar = new JMenuItem();  
		menuExportar.setText("Salvar txt");  
		menuExportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(abas.getTabCount() == 0){JOptionPane.showMessageDialog(null, "Você precisa ter abas ativas para poder Salvar Arquivos");}
				else
				{
					ExportarTXT exporta = new ExportarTXT();
					JTextArea texto = retornaCampoSaiDaAbaSelecionada();
		
					if(exporta.salvarTXT(texto.getText(), JTelaPrincipal.this)){				
						JOptionPane.showMessageDialog(null, "O Arquivo foi salvo com sucesso!", "Aviso", 1);
					}
					else{
						JOptionPane.showMessageDialog(null, "Ocorreu um ERRO ao salval o arquivo. Tente novamente", "Aviso", 0);
					}
				}
			}
		});
        
        return menuExportar;
	}

	protected void montaBotaoFuncao(){}

	protected JButton montaBotaoLimpaCampos(){
		
		JButton botaoLimpaCampos = new JButton("Limpar");	
		this.addKeyListener(this);
		
		return botaoLimpaCampos;
	}

	protected void mostraJanela(){
		
		this.setSize(500, 500);
	}
	
	private JMenuItem criaFuncaoAbrirInversorDeLinks(){
		inversorDeLinks = new JMenuItem();
		inversorDeLinks.setText("Inversor");
		
		inversorDeLinks.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int numeroDeAbas = abas.getTabCount();
				
				abas.addTab("Inversor de Links", null);
				abas.setTabComponentAt(numeroDeAbas , new ButtonTabComponent(abas));
				abas.setComponentAt(numeroDeAbas, new JInversorApp().getContentPane());
			}
		});
		return inversorDeLinks;
	}
	
	private JMenuItem criaFuncaoAbrirDecodificador(){
		decodificador = new JMenuItem();
		decodificador.setText("Decodificador");
		
		decodificador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int numeroDeAbas = abas.getTabCount();
				
				abas.addTab("Decodificador Hexadecimal", null);
				abas.setTabComponentAt(numeroDeAbas , new ButtonTabComponent(abas));
				abas.setComponentAt(numeroDeAbas, new JDecodificadorApp().getContentPane());
				
			}
		});
		return decodificador;
	}
	
	private JTextArea retornaCampoSaiDaAbaSelecionada(){
		
		Component component = abas.getComponentAt(retornaAbaSelecionada());
		
		JPanel painel = (JPanel)component.getComponentAt(component.getX(), component.getY());
		
		Component[] companentsDoPainel = painel.getComponents();
		
		for(int i = 0 ; i < companentsDoPainel.length; i++)
		{
			if(companentsDoPainel[i].getClass() == JScrollPane.class)
			{	
				JScrollPane scroll = (JScrollPane)companentsDoPainel[i];
				Component[] componentsDoScroll = scroll.getComponents();
					
				for(int v = 0 ; v < componentsDoScroll.length; v++)
				{
					if(componentsDoScroll[v].getClass() == JViewport.class)
					{
						JViewport view = (JViewport)componentsDoScroll[v];
						Component[] componentsView = view.getComponents();
						return (JTextArea) componentsView[componentsView.length - 1];
					}
				}	
			}	
		}
		return null;
	}
	
private JTextArea retornaCampo1DaAbaSelecionada(){
		
		Component component = abas.getComponentAt(retornaAbaSelecionada());
		
		JPanel painel = (JPanel)component.getComponentAt(component.getX(), component.getY());
		
		Component[] companentsDoPainel = painel.getComponents();
		
		for(int i = 0 ; i < companentsDoPainel.length; i++)
		{
			if(companentsDoPainel[i].getClass() == JTextArea.class)
			{	
				return (JTextArea) companentsDoPainel[i];
			}
		}
		return null;
	}
	
	protected void criaCampos(){}

	protected void add(String label, JComponent componente ) {  
        GridBagConstraints cons = new GridBagConstraints();  
        cons.fill = GridBagConstraints.BOTH;  
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

	protected void add(JButton botao){
		
		 GridBagConstraints cons = new GridBagConstraints();  
	        cons.fill = GridBagConstraints.NONE;  
	        cons.anchor = GridBagConstraints.NORTHWEST;  
	        cons.insets = new Insets(4,4,4,4);  
	  
	        botao.addKeyListener(this);
	        cons.weightx = 0;  
	        cons.gridwidth = 1;  
	        this.getContentPane().add(botao, cons);
		
	}

	protected void add2(String label, JScrollPane componente ) {  
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
	
	protected void inicializaCampos(){
		
		campo1 = new JTextArea();  
		campo2 = new JTextArea();
		campoSai = new JTextArea();  
	    campoSai.setEditable(false);
	    campoSai.setLineWrap(true);
	    campoSai2 = new JTextArea();  
	    campoSai2.setEditable(false);
	    campoSai2.setLineWrap(true);
	}

	protected int retornaAbaSelecionada(){
		
		JTabbedPane aba = (JTabbedPane) painelPrincipal.getComponent(0);
		return aba.getSelectedIndex();
	}
	
	protected void implementaBotaoLimpaCampos(){}
	
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
