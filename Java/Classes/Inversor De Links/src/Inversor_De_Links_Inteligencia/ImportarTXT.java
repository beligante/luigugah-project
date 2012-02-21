package Inversor_De_Links_Inteligencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImportarTXT {
	
	private FileReader reader;
	
	private void escolher(){
		
		try {
			JFileChooser fileChooser = new JFileChooser("C:");
			
			fileChooser.setFileFilter(new FileNameExtensionFilter("Apenas .txt", "txt"));
			
			int retorno = fileChooser.showOpenDialog(null);
			
			
				if (retorno == JFileChooser.APPROVE_OPTION) {
					
					reader = new FileReader(fileChooser.getSelectedFile());	
				
				}
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
		}
	}

	public String importaTxt(){
		
		this.escolher();
		String linha, string = "";
		
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		try {
			while ( ( linha = bufferedReader.readLine() ) != null) {
					
				string = string + linha + "\n";
			
			}
			reader.close();
			bufferedReader.close();

			return string;
		} catch (IOException e) {
			
			e.printStackTrace();	
		}
		
	return null;
	}

	public static void main(String arg[]){
		
		new ImportarTXT().escolher();
	}
}
