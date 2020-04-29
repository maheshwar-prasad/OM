package com.dcs.balaji.dao.impl;

import org.springframework.stereotype.Repository;

import com.dcs.balaji.dao.CustomerSettingDao;
import com.dcs.balaji.entity.CustomerSetting;
import com.dcs.datasource.dao.impl.AbstractGenericDAOImpl;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
@Repository("CustomerSettingDao")
public class CustomerSettingDaoImpl extends AbstractGenericDAOImpl<CustomerSetting> implements CustomerSettingDao {

	@Override
	protected Class<CustomerSetting> getTemplateClass() {
		return CustomerSetting.class;
	}

}
