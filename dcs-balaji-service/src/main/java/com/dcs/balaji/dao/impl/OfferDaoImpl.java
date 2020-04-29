package com.dcs.balaji.dao.impl;

import org.springframework.stereotype.Repository;

import com.dcs.balaji.dao.OfferDao;
import com.dcs.balaji.entity.Offer;
import com.dcs.datasource.dao.impl.AbstractGenericDAOImpl;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
@Repository("OfferDao")
public class OfferDaoImpl extends AbstractGenericDAOImpl<Offer> implements OfferDao {

	@Override
	protected Class<Offer> getTemplateClass() {
		return Offer.class;
	}

}
