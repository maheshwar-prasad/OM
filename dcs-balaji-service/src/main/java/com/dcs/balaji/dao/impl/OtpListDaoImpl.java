package com.dcs.balaji.dao.impl;

import org.springframework.stereotype.Repository;

import com.dcs.balaji.dao.OtpListDao;
import com.dcs.balaji.entity.OtpList;
import com.dcs.datasource.dao.impl.AbstractGenericDAOImpl;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
@Repository("OtpListDao")
public class OtpListDaoImpl extends AbstractGenericDAOImpl<OtpList> implements OtpListDao {

	@Override
	protected Class<OtpList> getTemplateClass() {
		return OtpList.class;
	}

}
