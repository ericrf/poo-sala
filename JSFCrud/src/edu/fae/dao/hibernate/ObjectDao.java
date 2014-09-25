package edu.fae.dao.hibernate;

import java.util.List;

public interface ObjectDao<E> {
	public List<E> findAll();
	public void save(E object);
	public E findById(int id);
	public void remove(E object);
}
