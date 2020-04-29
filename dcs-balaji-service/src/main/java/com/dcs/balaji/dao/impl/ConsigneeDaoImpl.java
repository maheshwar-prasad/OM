package com.dcs.balaji.dao.impl;

import org.springframework.stereotype.Repository;

import com.dcs.balaji.dao.ConsigneeDao;
import com.dcs.balaji.entity.Consignee;
import com.dcs.datasource.dao.impl.AbstractGenericDAOImpl;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
@Repository("ConsigneeDao")
public class ConsigneeDaoImpl extends AbstractGenericDAOImpl<Consignee> implements ConsigneeDao {

	@Override
	protected Class<Consignee> getTemplateClass() {
		return Consignee.class;
	}

}
