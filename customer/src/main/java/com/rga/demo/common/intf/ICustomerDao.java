package com.rga.demo.common.intf;

import java.util.List;

public interface ICustomerDao<T> {

	public T findByCustomerName(final String customerName);

	public T findById(final Integer id);

	public List<T> findAll();
	
	public T create(final String customerName,final String password,final String email);
	
	public T update(final T customer);
	
	public void delete(final Integer id);

}
