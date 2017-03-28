package service;

import java.io.Serializable;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import dao.AcessorioDAO;
import modelo.Acessorio;
import util.jpa.Transactional;

public class CadastroAcessorioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AcessorioDAO acessorioDAO;
	
	@Transactional
	public void salvar(Acessorio acessorio) throws NegocioException {
		
		if (StringUtils.isBlank(acessorio.getDescricao())) {
			throw new NegocioException("A descrição do acessório é obrigatório");
		}
		
		this.acessorioDAO.salvar(acessorio);
	}

}
