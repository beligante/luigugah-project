package Inversor_De_Links_Inteligencia;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.swing.JFrame;

public class ExportarTXT {
	
	String nomeDoArquivo;
	
	public String getNomeDoArquivo(){ return nomeDoArquivo;}

	public void salvarTemporario(String conteudo) throws IOException{  
		String resultado = conteudo.replaceAll("\\n", System.getProperty("line.separator"));
		File arquivo = File.createTempFile("teste", ".txt", new File(System.getProperty("user.dir")));
		nomeDoArquivo = arquivo.getAbsolutePath();
		
		arquivo.deleteOnExit();
		
	    FileWriter out = new FileWriter(arquivo);
        out.write(resultado);
        out.flush();
        out.close();
	          
	    
	}

	public void salvarTXT(String conteudo, JFrame frame) {
	
		String resultado = conteudo.replaceAll("\\n", System.getProperty("line.separator"));
		
		FileDialog escolherArquivo = new FileDialog(frame, "C:", FileDialog.SAVE);
		
		escolherArquivo.setFilenameFilter(this.filtro());
		
		escolherArquivo.setFile("Untitled");
		escolherArquivo.setVisible(true);
	    
	    File selFile = new File(escolherArquivo.getDirectory(),escolherArquivo.getFile()+ ".txt");	    
	    FileWriter arquivo;
		
	    try {
			
			arquivo = new FileWriter(selFile.getAbsoluteFile());
			arquivo.write(resultado);
			arquivo.flush();
	    	arquivo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}   

	}
	
	private FilenameFilter filtro(){
		
		FilenameFilter filtro = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				
				String resultado = name.toLowerCase();
				return resultado.endsWith(".txt");
			}
		
		};
	
		return filtro;
	}
}