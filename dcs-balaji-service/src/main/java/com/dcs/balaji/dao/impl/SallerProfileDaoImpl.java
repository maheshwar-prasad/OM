package com.dcs.balaji.dao.impl;

import org.springframework.stereotype.Repository;

import com.dcs.balaji.dao.SallerProfileDao;
import com.dcs.balaji.entity.SallerProfile;
import com.dcs.datasource.dao.impl.AbstractGenericDAOImpl;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
@Repository("SallerProfileDao")
public class SallerProfileDaoImpl extends AbstractGenericDAOImpl<SallerProfile> implements SallerProfileDao {

	@Override
	protected Class<SallerProfile> getTemplateClass() {
		return SallerProfile.class;
	}

}
