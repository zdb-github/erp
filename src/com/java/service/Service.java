package com.java.service;

import java.util.List;

public interface Service<T,ID> {
	
	public boolean add(T e);
	public void delete(ID id);
	public void update(T e);
	
	public List<T> getAll(ID con);
	public T getById(ID id);
}