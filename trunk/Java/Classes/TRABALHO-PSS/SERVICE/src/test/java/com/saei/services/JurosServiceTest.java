package com.saei.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.saei.domain.commons.JurosParcelamento;
import com.saei.services.exceptions.AmbiguousConfigurationException;
import com.saei.services.exceptions.InvalidConfigurationException;
import com.saei.services.exceptions.NoConfigurationException;

public class JurosServiceTest{
	
	@Test(expected = NoConfigurationException.class)
	public void testeInicializacaoConfiguracaoNula() throws Exception{
		try{
			new JurosService(null);
		}catch(Exception e){
			Assert.assertTrue(e instanceof NoConfigurationException);
			Assert.assertEquals("Erro ao instanciar a classe. É necessário pelo menos uma configuração", e.getMessage());
			throw e;
		}
	}
	
	@Test(expected = NoConfigurationException.class)
	public void testeInicializacaoConfiguracaoVazia() throws Exception{
		List<JurosParcelamento> lista = new ArrayList<JurosParcelamento>();
		
		try{
			new JurosService(lista);
		}catch(Exception e){
			Assert.assertTrue(e instanceof NoConfigurationException);
			Assert.assertEquals("Erro ao instanciar a classe. É necessário pelo menos uma configuração", e.getMessage());
			throw e;
		}
	}
	
	@Test(expected = InvalidConfigurationException.class)
	public void testeValorTotalConfiguracaoInvalida() throws Exception {
		List<JurosParcelamento> lista = new ArrayList<JurosParcelamento>();
		JurosParcelamento j = new JurosParcelamento();
		j.setPorcentagemjuros(BigDecimal.ZERO);
		j.setQuantidadeparcelas(1);
		j.setValorTotal(null);
		
		lista.add(j);
		
		try{
			new JurosService(lista);
		}catch(Exception e){
			Assert.assertTrue(e instanceof InvalidConfigurationException);
			Assert.assertEquals("O Valor total da configuração não pode ser nulo ou menor que zero", e.getMessage());
			throw e;
		}
	}
	
	@Test(expected = InvalidConfigurationException.class)
	public void testeQuantidadeParcelasConfiguracaoInvalida() throws Exception {
		List<JurosParcelamento> lista = new ArrayList<JurosParcelamento>();
		JurosParcelamento j = new JurosParcelamento();
		j.setPorcentagemjuros(BigDecimal.ZERO);
		j.setQuantidadeparcelas(-1);
		j.setValorTotal(BigDecimal.ZERO);
		
		lista.add(j);
		
		try{
			new JurosService(lista);
		}catch(Exception e){
			Assert.assertTrue(e instanceof InvalidConfigurationException);
			Assert.assertEquals("A quantidade de parcelas não pode ser menor que 1", e.getMessage());
			throw e;
		}
	}
	
	@Test(expected = InvalidConfigurationException.class)
	public void testePorcentagemJurosConfiguracaoInvalida() throws Exception {
		List<JurosParcelamento> lista = new ArrayList<JurosParcelamento>();
		JurosParcelamento j = new JurosParcelamento();
		j.setPorcentagemjuros(null);
		j.setQuantidadeparcelas(1);
		j.setValorTotal(BigDecimal.ZERO);
		
		lista.add(j);
		
		try{
			new JurosService(lista);
		}catch(Exception e){
			Assert.assertTrue(e instanceof InvalidConfigurationException);
			Assert.assertEquals("O valor de porcentagem da configuração não pode ser nulo ou menor que zero", e.getMessage());
			throw e;
		}
	}

	@Test(expected = AmbiguousConfigurationException.class)
	public void testeInicializacaoConfiguracaoAmbigua() throws Exception {
		List<JurosParcelamento> lista = new ArrayList<JurosParcelamento>();
		JurosParcelamento j = new JurosParcelamento();
		j.setPorcentagemjuros(BigDecimal.ZERO);
		j.setQuantidadeparcelas(1);
		j.setValorTotal(BigDecimal.ZERO);
		
		lista.add(j);
		lista.add(j);
		
		try{
			new JurosService(lista);
		}catch(Exception e){
			Assert.assertTrue(e instanceof AmbiguousConfigurationException);
			Assert.assertEquals("Não podem existir configurações ambiguas na lista de configurações", e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testeInicializacaoCorreta() throws NoConfigurationException, InvalidConfigurationException, AmbiguousConfigurationException {
		List<JurosParcelamento> lista = new ArrayList<JurosParcelamento>();
		JurosParcelamento j = new JurosParcelamento();
		j.setPorcentagemjuros(BigDecimal.ZERO);
		j.setQuantidadeparcelas(1);
		j.setValorTotal(BigDecimal.ZERO);
		

		lista.add(j);
		
		j = new JurosParcelamento();
		j.setPorcentagemjuros(BigDecimal.ONE);
		j.setQuantidadeparcelas(1);
		j.setValorTotal(BigDecimal.ONE);

		lista.add(j);
	
		JurosService js =  new JurosService(lista);
		
		Assert.assertNotNull(js);
		Assert.assertEquals(js.getSafeConfiguracoes().size(), 2);
	}
	
	@Test
	public void testeRetornoZeroPorcentagemJurosParaParametrosInvalidos() throws Exception{
		List<JurosParcelamento> lista = new ArrayList<JurosParcelamento>();
		JurosParcelamento j = new JurosParcelamento();
		j.setPorcentagemjuros(BigDecimal.ZERO);
		j.setQuantidadeparcelas(1);
		j.setValorTotal(BigDecimal.ZERO);
		
		lista.add(j);
		
		try{
			new JurosService(lista);
		}catch(Exception e){
			Assert.assertTrue(e instanceof InvalidConfigurationException);
			Assert.assertEquals("O valor de porcentagem da configuração não pode ser nulo ou menor que zero", e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testeRetornoCorretoParaConfiguracoes() throws Exception{
		List<JurosParcelamento> lista = new ArrayList<JurosParcelamento>();
		JurosParcelamento j = new JurosParcelamento();
		j.setPorcentagemjuros(BigDecimal.ZERO);
		j.setQuantidadeparcelas(1);
		j.setValorTotal(new BigDecimal(100));
		
		lista.add(j);
		
		j = new JurosParcelamento();
		j.setPorcentagemjuros(BigDecimal.ONE);
		j.setQuantidadeparcelas(1);
		j.setValorTotal(new BigDecimal(101));
		
		lista.add(j);
		
		j = new JurosParcelamento();
		j.setPorcentagemjuros(new BigDecimal(1.3));
		j.setQuantidadeparcelas(1);
		j.setValorTotal(new BigDecimal(200));
		
		lista.add(j);
		
		j = new JurosParcelamento();
		j.setPorcentagemjuros(new BigDecimal(2.1));
		j.setQuantidadeparcelas(1);
		j.setValorTotal(new BigDecimal(800));
		
		lista.add(j);
		
		j = new JurosParcelamento();
		j.setPorcentagemjuros(new BigDecimal(3.2));
		j.setQuantidadeparcelas(4);
		j.setValorTotal(new BigDecimal(4000));
		
		lista.add(j);
		
		
		JurosService js = new JurosService(lista);
		
		Assert.assertEquals(BigDecimal.ZERO, js.getPorcentagemJurosByValorAndQuantidadeParcelas(new BigDecimal(99), 3));
		Assert.assertEquals(BigDecimal.ZERO, js.getPorcentagemJurosByValorAndQuantidadeParcelas(new BigDecimal(100), 1));
		
		Assert.assertEquals(BigDecimal.ONE, js.getPorcentagemJurosByValorAndQuantidadeParcelas(new BigDecimal(101), 3));
		Assert.assertEquals(BigDecimal.ONE, js.getPorcentagemJurosByValorAndQuantidadeParcelas(new BigDecimal(104), 1));
		
		Assert.assertEquals(new BigDecimal(1.3), js.getPorcentagemJurosByValorAndQuantidadeParcelas(new BigDecimal(302), 2));
		Assert.assertEquals(new BigDecimal(1.3), js.getPorcentagemJurosByValorAndQuantidadeParcelas(new BigDecimal(201), 1));
		
		Assert.assertEquals(new BigDecimal(2.1), js.getPorcentagemJurosByValorAndQuantidadeParcelas(new BigDecimal(900), 3));
		Assert.assertEquals(new BigDecimal(2.1), js.getPorcentagemJurosByValorAndQuantidadeParcelas(new BigDecimal(901), 3));

		Assert.assertEquals(new BigDecimal(2.1), js.getPorcentagemJurosByValorAndQuantidadeParcelas(new BigDecimal(1002), 3));
		Assert.assertEquals(new BigDecimal(2.1), js.getPorcentagemJurosByValorAndQuantidadeParcelas(new BigDecimal(1002), 2));
		
		Assert.assertEquals(new BigDecimal(3.2), js.getPorcentagemJurosByValorAndQuantidadeParcelas(new BigDecimal(4500), 4));
		Assert.assertEquals(new BigDecimal(3.2), js.getPorcentagemJurosByValorAndQuantidadeParcelas(new BigDecimal(5000), 8));
		
	}
}
