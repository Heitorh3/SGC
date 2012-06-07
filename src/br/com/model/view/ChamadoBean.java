package br.com.model.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.hibernate.Session;

import br.com.model.bean.Chamado;
import br.com.model.bean.Equipamento;
import br.com.model.bean.TipoManutencao;
import br.com.model.bean.TipoStatus;
import br.com.model.dao.HibernateDAO;
import br.com.model.dao.InterfaceDAO;
import br.com.model.util.HibernateUtil;


public class ChamadoBean {

	private Chamado chamado = new Chamado();
	private Equipamento equipamento = new Equipamento();
	Session session =  HibernateUtil.getSessionFactory().openSession();
	FacesContext context = null;
	private List<SelectItem> tipoManutencao;
	private List<SelectItem> tipoStatus;
	
	public ChamadoBean() {
		super();
		chamado.setEquipamento(new Equipamento());
	}

	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public List<SelectItem> getTipoManutencao() {
		return tipoManutencao;
	}

	public void setTipoManutencao(List<SelectItem> tipoManutencao) {
		this.tipoManutencao = tipoManutencao;
	}
	public List<SelectItem>getManutencao(){
		
		if(this.tipoManutencao == null){
			this.tipoManutencao = new ArrayList<SelectItem>();
		for(TipoManutencao tipo : TipoManutencao.values()){
			this.tipoManutencao.add(new SelectItem(tipo,tipo.toString()));
			}
		}
		return tipoManutencao;
	}

	public List<SelectItem> getTipoStatus() {
		
		if(this.tipoStatus == null){
			this.tipoStatus = new ArrayList<SelectItem>();
	    for(TipoStatus status : TipoStatus.values()){
	    	this.tipoStatus.add(new SelectItem(status, status.toString()));
	    }
		}
		return tipoStatus;
	}

	public void setTipoStatus(List<SelectItem> tipoStatus) {
		this.tipoStatus = tipoStatus;
	}

	public String salvar(){
	
		InterfaceDAO<Chamado> chamadoDAO = new HibernateDAO<Chamado>(Chamado.class,session);
		
		if(isValidation()){
			
			try {
				chamadoDAO.salvar(chamado);				
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, ""," Chamado Cadastrado com sucesso"));
			} catch (Exception e) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, " Problemas ao cadastrar o chamado ","( "+e.getMessage()+" )"));
			}
		}
		
		return "addChamado";
	}
	
	private boolean isValidation(){
		
		context = FacesContext.getCurrentInstance();
		
		if("".equals(this.getChamado().getNroChamado())&& getChamado().getNroChamado().length() == 0
				|| "".equals(this.getChamado().getNroChamado())&& getChamado().getNroChamado().length() == 0
				|| chamado.getEquipamento().getId().equals("")&& equipamento == null
				|| this.getChamado().getDescricao().equals("")){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "","Os campos com (*) s�o de preenchimento obrigat�rio"));
			return false;
		}else{
			return true;
		}
		
	}
}
