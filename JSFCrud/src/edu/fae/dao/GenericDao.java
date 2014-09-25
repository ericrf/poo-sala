package edu.fae.dao;

import java.util.List;


public interface GenericDao <T,ID>{
	public void save(T t);
	public void remove(T t);
	public T findOneById(ID id);
	public List<T> findAll();
}
