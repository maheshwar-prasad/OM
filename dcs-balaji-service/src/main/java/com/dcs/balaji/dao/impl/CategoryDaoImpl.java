package com.dcs.balaji.dao.impl;

import org.springframework.stereotype.Repository;

import com.dcs.balaji.dao.CategoryDao;
import com.dcs.balaji.entity.Category;
import com.dcs.datasource.dao.impl.AbstractGenericDAOImpl;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
@Repository("CategoryDao")
public class CategoryDaoImpl extends AbstractGenericDAOImpl<Category> implements CategoryDao {

	@Override
	protected Class<Category> getTemplateClass() {
		return Category.class;
	}

}
