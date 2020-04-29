package com.dcs.balaji.dao.impl;

import org.springframework.stereotype.Repository;

import com.dcs.balaji.dao.ItemsDao;
import com.dcs.balaji.entity.Items;
import com.dcs.datasource.dao.impl.AbstractGenericDAOImpl;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
@Repository("ItemsDao")
public class ItemsDaoImpl extends AbstractGenericDAOImpl<Items> implements ItemsDao {

	@Override
	protected Class<Items> getTemplateClass() {
		return Items.class;
	}

}
