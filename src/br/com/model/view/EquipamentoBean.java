package br.com.model.view;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.model.bean.Equipamento;
import br.com.model.dao.HibernateDAO;
import br.com.model.dao.InterfaceDAO;
import br.com.model.util.HibernateUtil;


public class EquipamentoBean {

	private Equipamento equipamento;
	Session session =  HibernateUtil.getSessionFactory().openSession();
	List<Equipamento> equipamentos = new ArrayList<Equipamento>();
	
	
	public EquipamentoBean() {
		super();
		this.equipamento = new Equipamento();
	}
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public String salvar(){
		return null;
	}
	public List<Equipamento> getEquipamentos() {
	  	return listarEquipamento();
	}
	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}
	public List<Equipamento> listarEquipamento(){
		
		InterfaceDAO<Equipamento> equipamentoDAO = new HibernateDAO<Equipamento>(Equipamento.class,session); 	
		
		this.equipamentos = equipamentoDAO.getBeans();
		
		return equipamentos;
	}
}
