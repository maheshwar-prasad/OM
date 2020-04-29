package com.dcs.balaji.dao.impl;

import org.springframework.stereotype.Repository;

import com.dcs.balaji.dao.OrdersDao;
import com.dcs.balaji.entity.Orders;
import com.dcs.datasource.dao.impl.AbstractGenericDAOImpl;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
@Repository("OrdersDao")
public class OrdersDaoImpl extends AbstractGenericDAOImpl<Orders> implements OrdersDao {

	@Override
	protected Class<Orders> getTemplateClass() {
		return Orders.class;
	}

}
