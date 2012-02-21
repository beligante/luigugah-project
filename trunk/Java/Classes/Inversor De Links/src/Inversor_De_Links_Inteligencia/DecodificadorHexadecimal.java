package Inversor_De_Links_Inteligencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class DecodificadorHexadecimal {
	
	ArrayList<String> paresDeString;
	Properties dicionarioDeCaracteres;
	String valorNaoDecimal;
	
	public String getValorNaoDecimal() {
		return valorNaoDecimal;
	}

	public DecodificadorHexadecimal(){this.inicializaDicionarioDeObjetos();};
	
	public String decodifica(String aHexadecimalValue)
	{
		String resultadoString = new String();
		
		this.validador(aHexadecimalValue);
		
		this.separaAStringEmPares(aHexadecimalValue);
		
		Iterator<String> iterator = paresDeString.iterator();
		
		while (iterator.hasNext())
		{
			
			String stringDaVez = iterator.next();
			
			if (dicionarioDeCaracteres.getProperty(stringDaVez) == null){
				
				valorNaoDecimal = stringDaVez;
				throw new IllegalArgumentException("O valor decimal " + stringDaVez + " não representa um caractere!");}
			
			resultadoString = resultadoString + ((dicionarioDeCaracteres.getProperty(stringDaVez)));
			
		}
		
		return resultadoString;	
	}

	private void separaAStringEmPares(String aString) {

		String filter = aString.replaceAll("\\n", "0d"); 
		String result = filter.replaceAll(" ", "7f");
		
		paresDeString = new ArrayList<String>();
		
		for(int i = 0; i < result.length();)
		{
			paresDeString.add(result.substring(i, i+2));
			
			i = i+2;
		}
		
	}

	private boolean validador(String aString)
	{
		String filter = aString.replaceAll("\\n", "0d"); 
		String result = filter.replaceAll(" ", "7f"); 
		
		
		try{			
			int valorStringPassada = Integer.parseInt(result);
			if(valorStringPassada < 10) 
				{throw new IllegalArgumentException("A string passada não corresponde a um valor(es) hexadecimal");}
		} 
		
		catch (NumberFormatException exeption) {
			if(result.length()%2 != 0)
				{throw new IllegalArgumentException("A string passada não corresponde a um valor(es) hexadecimal");}
		}
		
		return true;
	}

	private void inicializaDicionarioDeObjetos()
	{
		dicionarioDeCaracteres = new Properties();
		
		dicionarioDeCaracteres.setProperty("61", "a");
		dicionarioDeCaracteres.setProperty("62", "b");
		dicionarioDeCaracteres.setProperty("63", "c");
		dicionarioDeCaracteres.setProperty("64", "d");
		dicionarioDeCaracteres.setProperty("65", "e");
		dicionarioDeCaracteres.setProperty("66", "f");
		dicionarioDeCaracteres.setProperty("67", "g");
		dicionarioDeCaracteres.setProperty("68", "h");
		dicionarioDeCaracteres.setProperty("69", "i");
		dicionarioDeCaracteres.setProperty("6a", "j");
		dicionarioDeCaracteres.setProperty("6b", "k");
		dicionarioDeCaracteres.setProperty("6c", "l");
		dicionarioDeCaracteres.setProperty("6d", "m");
		dicionarioDeCaracteres.setProperty("6e", "n");
		dicionarioDeCaracteres.setProperty("6f", "o");
		dicionarioDeCaracteres.setProperty("70", "p");
		dicionarioDeCaracteres.setProperty("71", "q");
		dicionarioDeCaracteres.setProperty("72", "r");
		dicionarioDeCaracteres.setProperty("73", "s");
		dicionarioDeCaracteres.setProperty("74", "t");
		dicionarioDeCaracteres.setProperty("75", "u");
		dicionarioDeCaracteres.setProperty("76", "v");
		dicionarioDeCaracteres.setProperty("77", "w");
		dicionarioDeCaracteres.setProperty("78", "x");
		dicionarioDeCaracteres.setProperty("79", "y");
		dicionarioDeCaracteres.setProperty("7a", "z");
		dicionarioDeCaracteres.setProperty("30", "0");
		dicionarioDeCaracteres.setProperty("31", "1");
		dicionarioDeCaracteres.setProperty("32", "2");
		dicionarioDeCaracteres.setProperty("33", "3");
		dicionarioDeCaracteres.setProperty("34", "4");
		dicionarioDeCaracteres.setProperty("35", "5");
		dicionarioDeCaracteres.setProperty("36", "6");
		dicionarioDeCaracteres.setProperty("37", "7");
		dicionarioDeCaracteres.setProperty("38", "8");
		dicionarioDeCaracteres.setProperty("39", "9");
		dicionarioDeCaracteres.setProperty("7e", "~");
		dicionarioDeCaracteres.setProperty("21", "!");
		dicionarioDeCaracteres.setProperty("40", "@");
		dicionarioDeCaracteres.setProperty("23", "#");
		dicionarioDeCaracteres.setProperty("24", "$");
		dicionarioDeCaracteres.setProperty("25", "%");
		dicionarioDeCaracteres.setProperty("5e", "^");
		dicionarioDeCaracteres.setProperty("26", "&");
		dicionarioDeCaracteres.setProperty("2a", "*");
		dicionarioDeCaracteres.setProperty("28", "(");
		dicionarioDeCaracteres.setProperty("29", ")");
		dicionarioDeCaracteres.setProperty("5f", "_");
		dicionarioDeCaracteres.setProperty("2b", "+");
		dicionarioDeCaracteres.setProperty("7c", "|");
		dicionarioDeCaracteres.setProperty("3d", "=");
		dicionarioDeCaracteres.setProperty("2d", "-");
		dicionarioDeCaracteres.setProperty("5c", "\\");
		dicionarioDeCaracteres.setProperty("2c", ",");
		dicionarioDeCaracteres.setProperty("2e", ".");
		dicionarioDeCaracteres.setProperty("2f", "/");
		dicionarioDeCaracteres.setProperty("3b", ";");
		dicionarioDeCaracteres.setProperty("27", "'");
		dicionarioDeCaracteres.setProperty("5b", "[");
		dicionarioDeCaracteres.setProperty("5d", "]");
		dicionarioDeCaracteres.setProperty("7b", "{");
		dicionarioDeCaracteres.setProperty("7d", "}");
		dicionarioDeCaracteres.setProperty("3a", ":");
		dicionarioDeCaracteres.setProperty("22", "\"");
		dicionarioDeCaracteres.setProperty("3c", "<");
		dicionarioDeCaracteres.setProperty("3e", ">");
		dicionarioDeCaracteres.setProperty("3f", "?");
		dicionarioDeCaracteres.setProperty("7f", " ");
		dicionarioDeCaracteres.setProperty("0d", "\n");
		dicionarioDeCaracteres.setProperty("20", "\r");
	}

}
