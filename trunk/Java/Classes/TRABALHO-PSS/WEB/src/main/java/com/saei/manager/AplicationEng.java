package com.saei.manager;

import org.apache.log4j.Logger;
import org.apache.torque.Torque;

import com.saei.services.ProdutoService;

public class AplicationEng {
	
	private static final Logger LOG = Logger.getLogger(AplicationEng.class);
	private static ProdutoEng PRODUTO_ENG;
	
	private AplicationEng() {
	}
	
	public static AplicationEng initialize(){
		
		try{
			Torque.init("torque.properties");
			PRODUTO_ENG = new ProdutoEng();
			return new AplicationEng();
		}catch(Exception e){
			LOG.error("Ocorreu um erro ao inicializar a aplicação", e);
		}
		return null;
	}
	
	public ProdutoEng getProdutoEng() {
		return PRODUTO_ENG;
	}
}
