package com.saei.services;

import java.util.List;

import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.saei.domain.commons.BaseJurosParcelamentoPeer;
import com.saei.domain.commons.JurosParcelamento;

public class JurosParcelamentoService {
	
	public static List<JurosParcelamento> getAllJurosParcelamento(){
		try {
			return BaseJurosParcelamentoPeer.doSelect(new Criteria());
		} catch (TorqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
