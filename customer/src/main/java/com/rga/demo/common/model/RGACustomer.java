package com.rga.demo.common.model;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.beanutils.BeanUtils;

import com.rga.demo.vo.CreateCustomerRequestBody;

@Table(name = "RGA_CUSTOMERS")
@Entity
public class RGACustomer implements Serializable {

	private static final long serialVersionUID = 6848754731320916890L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	@Basic
	private Integer id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "EMAIL")
	private String email;

	public RGACustomer() {
		super();
	}

	public RGACustomer(final String username, final String password,final String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public RGACustomer(final CreateCustomerRequestBody body){
		try {
			BeanUtils.copyProperties(this, body);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
