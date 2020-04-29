package com.dcs.balaji.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.dcs.balaji.constant.DCSBalajiConstant;
import com.dcs.balaji.dao.SalesOrderDao;
import com.dcs.balaji.enm.OrderStatus;
import com.dcs.balaji.entity.SalesOrder;
import com.dcs.balaji.model.SalesOrderDto;
import com.dcs.datasource.dao.impl.AbstractGenericDAOImpl;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
@Repository("SalesOrderDao")
public class SalesOrderDaoImpl extends AbstractGenericDAOImpl<SalesOrder> implements SalesOrderDao {

	@Override
	protected Class<SalesOrder> getTemplateClass() {
		return SalesOrder.class;
	}

	@Override
	public List<SalesOrder> getOpenOrder(Integer customer_id) throws HibernateException {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<SalesOrder> criteriaQuery = builder.createQuery(getTemplateClass());
		Root<SalesOrder> root = criteriaQuery.from(getTemplateClass());
		criteriaQuery.select(root)
				.where(builder.and(builder.equal(root.get("customer").get(DCSBalajiConstant.Word.ID), customer_id),
						builder.notEqual(root.get("orderStatus"), OrderStatus.R),
						builder.notEqual(root.get("orderStatus"), OrderStatus.D)));

		return session.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public List<SalesOrder> getOrders(Integer cust_id, boolean is_retailer, Date from, Date to)
			throws HibernateException {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<SalesOrder> criteriaQuery = builder.createQuery(getTemplateClass());
		Root<SalesOrder> root = criteriaQuery.from(getTemplateClass());
		if (is_retailer)
			criteriaQuery.select(root)
					.where(builder.and(builder.equal(root.get("customer").get(DCSBalajiConstant.Word.ID), cust_id),
							builder.greaterThanOrEqualTo(root.get("orderDate"), from),
							builder.lessThanOrEqualTo(root.get("orderDate"), to)));
		else
			criteriaQuery.select(root)
					.where(builder.and(builder.equal(root.get("consignee").get(DCSBalajiConstant.Word.ID), cust_id),
							builder.greaterThanOrEqualTo(root.get("orderDate"), from),
							builder.lessThanOrEqualTo(root.get("orderDate"), to)));

		return session.createQuery(criteriaQuery).getResultList();
	}

}
