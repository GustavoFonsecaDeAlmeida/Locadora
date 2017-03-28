package service;

import java.io.Serializable;

import javax.inject.Inject;

import dao.FuncionarioDAO;
import modelo.Funcionario;
import util.jpa.Transactional;

public class CadastroFuncionarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FuncionarioDAO funcionarioDAO;
	
	@Transactional
	public void salvar(Funcionario funcionario) throws NegocioException {
		
		if (funcionario.getNome() == null || funcionario.getNome().trim().equals("")) {
			throw new NegocioException("O nome do funcionário é obrigatório");
		}
		
		this.funcionarioDAO.salvar(funcionario);
	}

}
