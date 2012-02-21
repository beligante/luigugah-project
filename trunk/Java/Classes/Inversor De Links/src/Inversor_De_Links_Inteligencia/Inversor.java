package Inversor_De_Links_Inteligencia;

public class Inversor {

	public String invert(String string)
	{
		String stringFinal = new String();
		
		for(int charDaVez = (string.length()) - 1; charDaVez >= 0; charDaVez--)
		{
			stringFinal += string.charAt(charDaVez);
		}
		
		return stringFinal;
	}
	
}
