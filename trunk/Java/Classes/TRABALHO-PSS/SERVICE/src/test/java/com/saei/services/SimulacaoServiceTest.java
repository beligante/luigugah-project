package com.saei.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.saei.domain.Simulacao;

public class SimulacaoServiceTest {

	@Test(expected = IllegalArgumentException.class)
	public void testeEntradaValorOriginalNaoPodeSerNulla(){
		SimulacaoService.generateSimulation(null, new BigDecimal(2.1), new BigDecimal(2.3), 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testeEntradaValorEntradaNaoPodeSerNulla(){
		SimulacaoService.generateSimulation(new BigDecimal(2.1), new BigDecimal(2.1), null, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testeEntradaQuantidadeParcelasNaoPodeSerMenorOuIgualQueZero(){
		SimulacaoService.generateSimulation(new BigDecimal(1.1), new BigDecimal(1.2), new BigDecimal(1.3), 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testeEntradaValorEntradaNaoPodeSerMaiorQueValorOriginal(){
		SimulacaoService.generateSimulation(new BigDecimal(1.1), new BigDecimal(1.0), new BigDecimal(1.2), 2);
	}
	
	@Test
	public void testeRetornoCorreto(){
		
		Simulacao s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(1.2), new BigDecimal(100999), 30);
		Assert.assertEquals(new BigDecimal(1.20).setScale(2, BigDecimal.ROUND_HALF_UP), s.getJuros());
		
		//valor parcelas
		s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(1.2), new BigDecimal(100999), 30);
		Assert.assertEquals(new BigDecimal(30326.30).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorParcelas());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(1.2), new BigDecimal(100999), 44);
		Assert.assertEquals(new BigDecimal(20677.02).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorParcelas());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(500777), new BigDecimal(1.2), new BigDecimal(100999), 30);
		Assert.assertEquals(new BigDecimal(13485.85).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorParcelas());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(500777), new BigDecimal(1.2), new BigDecimal(100999), 44);
		Assert.assertEquals(new BigDecimal(9194.90).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorParcelas());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(1.2), new BigDecimal(77013), 30);
		Assert.assertEquals(new BigDecimal(31135.43).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorParcelas());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(1.2), new BigDecimal(77013), 44);
		Assert.assertEquals(new BigDecimal(21228.70).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorParcelas());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(500777), new BigDecimal(1.2), new BigDecimal(77013), 30);
		Assert.assertEquals(new BigDecimal(14294.99).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorParcelas());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(500777), new BigDecimal(1.2), new BigDecimal(77013), 44);
		Assert.assertEquals(new BigDecimal(9746.58).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorParcelas());

		s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(0.4), new BigDecimal(100999), 30);
		Assert.assertEquals(new BigDecimal(30086.57).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorParcelas());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(0.4), new BigDecimal(100999), 44);
		Assert.assertEquals(new BigDecimal(20513.57).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorParcelas());

		s = SimulacaoService.generateSimulation(new BigDecimal(500777), new BigDecimal(0.4), new BigDecimal(100999), 30);
		Assert.assertEquals(new BigDecimal(13379.24).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorParcelas());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(500777), new BigDecimal(0.4), new BigDecimal(100999), 44);
		Assert.assertEquals(new BigDecimal(9122.21).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorParcelas());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(0.4), new BigDecimal(77013), 30);
		Assert.assertEquals(new BigDecimal(30889.30).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorParcelas());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(0.4), new BigDecimal(77013), 44);
		Assert.assertEquals(new BigDecimal(21060.89).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorParcelas());

		s = SimulacaoService.generateSimulation(new BigDecimal(500777), new BigDecimal(0.4), new BigDecimal(77013), 30);
		Assert.assertEquals(new BigDecimal(14181.97).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorParcelas());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(500777), new BigDecimal(0.4), new BigDecimal(77013), 44);
		Assert.assertEquals(new BigDecimal(9669.53).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorParcelas());
		
		//valor total
		s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(1.2), new BigDecimal(100999), 30);
		Assert.assertEquals(new BigDecimal(1010788.00).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorFinal());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(1.2), new BigDecimal(100999), 44);
		Assert.assertEquals(new BigDecimal(1010787.88).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorFinal());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(500777), new BigDecimal(1.2), new BigDecimal(100999), 30);
		Assert.assertEquals(new BigDecimal(505574.50).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorFinal());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(500777), new BigDecimal(1.2), new BigDecimal(100999), 44);
		Assert.assertEquals(new BigDecimal(505574.60).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorFinal());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(1.2), new BigDecimal(77013), 30);
		Assert.assertEquals(new BigDecimal(1011075.90).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorFinal());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(1.2), new BigDecimal(77013), 44);
		Assert.assertEquals(new BigDecimal(1011075.80).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorFinal());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(500777), new BigDecimal(1.2), new BigDecimal(77013), 30);
		Assert.assertEquals(new BigDecimal(505862.70).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorFinal());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(500777), new BigDecimal(1.2), new BigDecimal(77013), 44);
		Assert.assertEquals(new BigDecimal(505862.52).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorFinal());

		s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(0.4), new BigDecimal(100999), 30);
		Assert.assertEquals(new BigDecimal(1003596.10).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorFinal());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(0.4), new BigDecimal(100999), 44);
		Assert.assertEquals(new BigDecimal(1003596.08).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorFinal());

		s = SimulacaoService.generateSimulation(new BigDecimal(500777), new BigDecimal(0.4), new BigDecimal(100999), 30);
		Assert.assertEquals(new BigDecimal(502376.20).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorFinal());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(500777), new BigDecimal(0.4), new BigDecimal(100999), 44);
		Assert.assertEquals(new BigDecimal(502376.24).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorFinal());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(0.4), new BigDecimal(77013), 30);
		Assert.assertEquals(new BigDecimal(1003692.00).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorFinal());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(1000000), new BigDecimal(0.4), new BigDecimal(77013), 44);
		Assert.assertEquals(new BigDecimal(1003692.16).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorFinal());

		s = SimulacaoService.generateSimulation(new BigDecimal(500777), new BigDecimal(0.4), new BigDecimal(77013), 30);
		Assert.assertEquals(new BigDecimal(502472.10).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorFinal());
		
		s = SimulacaoService.generateSimulation(new BigDecimal(500777), new BigDecimal(0.4), new BigDecimal(77013), 44);
		Assert.assertEquals(new BigDecimal(502472.32).setScale(2, BigDecimal.ROUND_HALF_UP), s.getValorFinal());
	}
	
}
