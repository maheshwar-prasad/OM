package com.dcs.balaji.dao.impl;

import org.springframework.stereotype.Repository;

import com.dcs.balaji.dao.StockDao;
import com.dcs.balaji.entity.Stock;
import com.dcs.datasource.dao.impl.AbstractGenericDAOImpl;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
@Repository("StockDao")
public class StockDaoImpl extends AbstractGenericDAOImpl<Stock> implements StockDao {

	@Override
	protected Class<Stock> getTemplateClass() {
		return Stock.class;
	}

}
