package br.com.model.view;

import java.io.Serializable;

import javax.faces.context.FacesContext;

public class SkinBean implements Serializable {


	private static final long serialVersionUID = 1L;
	private String skin = "DEFAULT";;
	

	public SkinBean() {
		super();
		String param = getSkinParam();   
        if (param!=null) {   
            setSkin(param);   
        }   
	}

	public String getSkin() {   		
        return skin;   
    }   

	public void setSkin(String skin) {
		this.skin = skin;
	}
	
	private String getSkinParam(){   
        FacesContext fc = FacesContext.getCurrentInstance();   
        String param = (String) fc.getExternalContext().getRequestParameterMap().get("s");   
        if (param!=null && param.trim().length()>0) {   
            return param;   
        } else {   
            return null;   
        }   
    }   

}
