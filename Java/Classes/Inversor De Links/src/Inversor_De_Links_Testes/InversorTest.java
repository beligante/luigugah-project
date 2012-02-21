package Inversor_De_Links_Testes;

import static org.junit.Assert.*;

import org.junit.Test;

import Inversor_De_Links_Inteligencia.Inversor;

public class InversorTest {

	@Test
	public void testVerificaSeStringEPassadaEInvertida(){
		
		Inversor inversor = new Inversor();
		
		assertEquals(inversor.invert("moc.daolpuagem.w1ww"), "ww1w.megaupload.com");

	}
	
}