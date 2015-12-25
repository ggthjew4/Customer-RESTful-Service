package com.rga.demo.common.intf;

import java.util.List;

public interface IUserDao<T> {

	public T findByUsername(final String username);

	public T findById(final Integer id);

	public List<T> findAll();

}
