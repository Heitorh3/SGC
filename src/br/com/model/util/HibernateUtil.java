package br.com.model.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	public static final String HIBERNATE_SESSION = "hibernate_session";
	
	static
	{
		sessionFactory = new AnnotationConfiguration().configure("br/com/model/util/hibernate.cfg.xml").buildSessionFactory();
	}
		
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void closeConnetion(){
		sessionFactory.close();
		}
}
