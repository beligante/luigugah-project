package Inversor_De_Links_Testes;

import static org.junit.Assert.*;

import org.junit.Test;

import Inversor_De_Links_Inteligencia.DecodificadorHexadecimal;

public class DecodificadorTest {

	@Test
	public void testVerificaSeStringEConvertida() {
		
		DecodificadorHexadecimal decodificador = new DecodificadorHexadecimal();
		
		assertEquals(decodificador.decodifica("61"),"a");
		
	}

}
