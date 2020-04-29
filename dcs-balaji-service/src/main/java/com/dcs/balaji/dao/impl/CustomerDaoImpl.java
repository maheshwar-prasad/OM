package com.dcs.balaji.dao.impl;

import org.springframework.stereotype.Repository;

import com.dcs.balaji.dao.CustomerDao;
import com.dcs.balaji.entity.Customer;
import com.dcs.datasource.dao.impl.AbstractGenericDAOImpl;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
@Repository("CustomerDao")
public class CustomerDaoImpl extends AbstractGenericDAOImpl<Customer> implements CustomerDao {

	@Override
	protected Class<Customer> getTemplateClass() {
		return Customer.class;
	}

}
