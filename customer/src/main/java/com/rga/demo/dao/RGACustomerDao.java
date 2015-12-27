package com.rga.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rga.demo.common.intf.ICustomerDao;
import com.rga.demo.common.model.RGACustomer;

@Repository
@Transactional
public class RGACustomerDao implements ICustomerDao<RGACustomer> {

    @PersistenceContext
    private EntityManager em;
    
	public RGACustomer findByCustomerName(String username) {
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
	
	public RGACustomer create(final String customerName,final String password,final String email){
		final RGACustomer customer = new RGACustomer(customerName, password,email);
		em.persist(customer);
		return customer;
	}
	
	public RGACustomer update(final RGACustomer customer){
		final RGACustomer previousCustomer = findByCustomerName(customer.getUsername());
		previousCustomer.setUsername(customer.getUsername());
		previousCustomer.setPassword(customer.getPassword());
		previousCustomer.setEmail(customer.getEmail());
		return em.merge(previousCustomer);
	}

	public void delete(Integer id) {
		em.remove(findById(id));
	}
    
}
