package br.com.model.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name="equipamento", schema="sgc")
public class Equipamento {
	
	private Integer id;
	private String service_tag;
	private String modelo;
	private String tipo;
	private List<Chamado> chamados;
	private Fabricante fabricante;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idEquipamento")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Equipamento() {
		super();
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idfabricante")
	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	@Column(name="service_tag")
	public String getService_tag() {
		return service_tag;
	}

	public void setService_tag(String service_tag) {
		this.service_tag = service_tag;
	}
	@Column(name="modelo")
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Column(name="tipo")
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="equipamento")
	@Fetch(value=FetchMode.SELECT)	
	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
}
