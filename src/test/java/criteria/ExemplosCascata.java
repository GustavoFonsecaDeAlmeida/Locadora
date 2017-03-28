package criteria;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import modelo.Acessorio;
import modelo.Aluguel;
import modelo.Carro;
import modelo.Categoria;
import modelo.ModeloCarro;

public class ExemplosCascata {

	private static EntityManagerFactory factory;
	
	private EntityManager manager;
	
	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
	}
	
	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
	}
	
	@After
	public void tearDown() {
		this.manager.close();
	}
	
	@Test
	public void exemploEntidadeTransiente() {
		Carro carro = new Carro();
		carro.setCor("Preto");
		carro.setPlaca("AAA-1111");
		
		ModeloCarro modelo = new ModeloCarro();
		modelo.setCategoria(Categoria.ESPORTIVO);
		modelo.setDescricao("Ferrari");
		carro.setModelo(modelo);
		
		this.manager.getTransaction().begin();
		this.manager.persist(carro);
		this.manager.getTransaction().commit();
	}
	
	@Test
	public void exclusaoEmCascata() {
		Carro carro = this.manager.find(Carro.class, 3L);
		
		this.manager.getTransaction().begin();
		this.manager.remove(carro);
		this.manager.getTransaction().commit();
	}
	
	@Test
	public void exclusaoDeObjetosOrfaos() {
		Carro carro = this.manager.find(Carro.class, 6L);
		
		this.manager.getTransaction().begin();
		carro.getAlugueis().remove(0);
		this.manager.getTransaction().commit();
	}
}


