package com.saei.manager;

import org.apache.log4j.Logger;
import org.apache.torque.Torque;

import com.saei.services.ProdutoService;

public class AplicationEng {
	
	private static final Logger LOG = Logger.getLogger(AplicationEng.class);
	private static ProdutoEng PRODUTO_ENG;
	private static UsuarioEng USER_ENG;
	private static NegocioEng NEGOCIO_ENG;
	private static InteresseVendaEng INTERESSEVENDA_ENG;
	
	private AplicationEng() {
	}
	
	public static AplicationEng initialize(){
		
		try{
			Torque.init("torque.properties");
			PRODUTO_ENG = 		new ProdutoEng();
			USER_ENG = 			new UsuarioEng();
			NEGOCIO_ENG = 		new NegocioEng();
			INTERESSEVENDA_ENG = new InteresseVendaEng();
			return new AplicationEng();
		}catch(Exception e){
			LOG.error("Ocorreu um erro ao inicializar a aplicação", e);
		}
		return null;
	}
	
	public ProdutoEng getProdutoEng() {
		return PRODUTO_ENG;
	}
	
	public UsuarioEng getUsuarioEng(){
		return USER_ENG;
	}
	
	public NegocioEng getNegocioEng(){
		return NEGOCIO_ENG;
	}
	
	public InteresseVendaEng getInteresseVendaEng(){
		return INTERESSEVENDA_ENG;
	}
}
