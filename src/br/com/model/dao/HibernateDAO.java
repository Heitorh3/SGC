package br.com.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

public class HibernateDAO <T> implements InterfaceDAO<T> {

	private Class<T> classe;
	private Session session;
	
	public HibernateDAO(Class<T> classe, Session session) {
		super();
		this.classe = classe;
		this.session = session;
	}
	
	public void atualizar(T bean) {
		session.update(bean);
	}

	public void excluir(T bean) {
		session.delete(bean);
		
	}

	public T getBean(Serializable codigo) {
		T bean = (T)session.get(classe, codigo);
		return bean;
	}

	public List<T> getBeans() {
		List<T> beans = (List<T>)session.createCriteria(classe).list();
		return beans;
	}

	public List<T> getBeansByExample(T bean) {
		Example example = Example.create(bean);
		example.enableLike(MatchMode.ANYWHERE);
		example.ignoreCase();
		return session.createCriteria(classe).add(example).list();
	}

	public void salvar(T bean) {
		session.save(bean);
		
	}
}