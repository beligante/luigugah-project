package com.saei.manager;

import java.util.Date;
import java.util.List;

import com.saei.domain.commons.Negocio;
import com.saei.services.NegocioService;

public class NegocioEng {

		private static NegocioService NEGOCIO_SERVICE;
		
		static {
			NEGOCIO_SERVICE = new NegocioService();
		}
		
		public Negocio registerNegocio(Negocio negocio){
			NEGOCIO_SERVICE.salvarNegocio(negocio);
			return negocio;
		}
		
		public List<Negocio> getAllNegocios(){
			return NEGOCIO_SERVICE.searchNegocio(null);
		}
		
		public void deleteNegocioByNegocio(Negocio negocio){
			if(negocio != null){
				deleteNegocioById(negocio.getId());
			}
		}
		
		public void deleteNegocioById(int id){
			Negocio negocio = new Negocio();
			negocio.setId(id);
			NEGOCIO_SERVICE.removeNegocio(negocio);
		}
		
		public Negocio getNegocioById(int id){
			return NEGOCIO_SERVICE.searchNegocioById(id);
		}
		
		public List<Negocio> searchNegocioByNegocio(Negocio negocio){
			return NEGOCIO_SERVICE.searchNegocio(negocio);
		}
		
		public void updateNegocioByNegocio(Negocio negocio){
			NEGOCIO_SERVICE.updateNegocio(negocio);
		}		
}
