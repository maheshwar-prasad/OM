package com.dcs.balaji.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;

import com.dcs.balaji.entity.SalesOrder;
import com.dcs.datasource.dao.GenericDAO;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
public interface SalesOrderDao extends GenericDAO<SalesOrder> {

	List<SalesOrder> getOpenOrder(Integer customer_id) throws HibernateException;

	List<SalesOrder> getOrders(Integer cust_id, boolean is_retailer, Date from, Date to) throws HibernateException;

}
