package br.com.model.bean;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



@Entity
@Table(name="chamado", schema="sgc")
public class Chamado {

	
	private Integer id;
	private TipoManutencao categoria;
	private String nroChamado;
	private TipoStatus status;
	private Date data;
	private String descricao;
	private Equipamento equipamento;
	
	public Chamado() {
		super();	
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idChamado")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	@Column(name="categoria")
	@Enumerated(EnumType.STRING)
	public TipoManutencao getCategoria() {
		return categoria;
	}

	public void setCategoria(TipoManutencao categoria) {
		this.categoria = categoria;
	}
	@Column(name="nroChamado")
	public String getNroChamado() {
		return nroChamado;
	}

	public void setNroChamado(String nroChamado) {
		this.nroChamado = nroChamado;
	}
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	public TipoStatus getStatus() {
		return status;
	}

	public void setStatus(TipoStatus status) {
		this.status = status;
	}
	@Column(name="datadoChamado")
	@Temporal(TemporalType.DATE)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	@Column(name="descricao")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idEquipamento")
	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	@Transient
	public void setDesdeString(String desdeString) throws ParseException {
		if(desdeString != null && !desdeString.equals("")){
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
			this.setData(new Date(df.parse(desdeString).getTime()));
		   }
	 	}
	@Transient
	public String toUTF8(String isoString) {   
	    String utf8String = null;   
	    if (null != isoString && !isoString.equals(""))   
	    {   
	        try   
	        {   
	            byte[] stringBytesISO = isoString.getBytes("ISO-8859-1");   
	            utf8String = new String(stringBytesISO, "UTF-8");   
	        }   
	        catch(UnsupportedEncodingException e)   
	        {   
	            // Mostra exceção mas devolve a mesma String   
	            System.out.println("UnsupportedEncodingException: " + e.getMessage());   
	            utf8String = isoString;   
	        }   
	    }   
	    else   
	    {   
	        utf8String = isoString;   
	    }   
	    return utf8String;   
	}
	
}	