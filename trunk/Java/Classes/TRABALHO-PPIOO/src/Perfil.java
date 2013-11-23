import java.util.ArrayList;
import java.util.List;


public enum Perfil {
	ADMIN, LOCADOR, ATENDENTE;
	
	private List<Regras> regras;

	Perfil(){
		regras = new ArrayList<Regras>();
	}
	
	public List<Regras> getRegras() {
		return regras;
	}

	public void setRegra(Regras regra) {
		
		this.regras.add(regra);
	}
	
	
}
