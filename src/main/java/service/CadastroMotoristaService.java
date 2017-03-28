package service;

import java.io.Serializable;

import javax.inject.Inject;

import dao.MotoristaDAO;
import modelo.Motorista;
import util.jpa.Transactional;

public class CadastroMotoristaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MotoristaDAO motoristaDAO;
	
	@Transactional
	public void salvar(Motorista motorista) throws NegocioException {
		this.motoristaDAO.salvar(motorista);
	}

}
