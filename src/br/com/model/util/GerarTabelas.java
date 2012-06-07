package br.com.model.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GerarTabelas {

	public static void main(String[] args) {
		AnnotationConfiguration cfg = new  AnnotationConfiguration();
		cfg.configure();
		
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
		
		System.out.println("Tabelas geradas com sucesso.");
	}

	
}
