package com.rga.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rga.demo.common.intf.IUserDao;
import com.rga.demo.common.model.RGACustomer;

@Repository
public class RGACustomerDao implements IUserDao<RGACustomer> {

    @PersistenceContext
    private EntityManager em;
    
	public RGACustomer findByUsername(String username) {
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<RGACustomer> cq = cb.createQuery(RGACustomer.class);
		final Root<RGACustomer> customer = cq.from(RGACustomer.class);
		return em.createQuery(cq.select(customer)
				 .where(
				 cb.equal(customer.get("username"), username))).getSingleResult();
	}

	public RGACustomer findById(Integer id) {
		return em.find(RGACustomer.class, id);
	}

	public List<RGACustomer> findAll() {
		return em.createQuery("SELECT p FROM RGACustomer p",RGACustomer.class).getResultList();
	}
    
}
