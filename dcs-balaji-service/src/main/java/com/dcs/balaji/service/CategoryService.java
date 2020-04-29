package com.dcs.balaji.service;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;

import com.dcs.access.model.UserDto;
import com.dcs.balaji.dao.CategoryDao;
import com.dcs.balaji.entity.Category;
import com.dcs.balaji.model.CategoryDto;
import com.dcs.datasource.enm.SortOrder;
import com.dcs.datasource.service.GenericService;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
public interface CategoryService extends GenericService<CategoryDao, Category> {

	/**
	 * 
	 * @param userDto
	 * @return {@link CategoryService}
	 */
	CategoryService setCurrentUser(UserDto userDto);

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer saveCategory(CategoryDto DTO) throws HibernateException;

	/**
	 * 
	 * @param DTOS
	 * @return {@link Set}
	 * @throws HibernateException
	 */
	Set<Integer> saveCategory(List<CategoryDto> DTOS) throws HibernateException;

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer updateCategory(CategoryDto DTO) throws HibernateException;

	/**
	 * 
	 * @param DTOS
	 * @return {@link Long}
	 * @throws HibernateException
	 */
	Long updateCategory(List<CategoryDto> DTOS) throws HibernateException;

	/**
	 * 
	 * @param IDS
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer delete(Set<Integer> IDS) throws HibernateException;

	/**
	 * 
	 * @param TEXT
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link CategoryDto}
	 * @throws HibernateException
	 */
	List<CategoryDto> search(String TEXT, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param INSTANCE
	 * @return {@link List} {@link CategoryDto}
	 * @throws HibernateException
	 */
	List<CategoryDto> findCategory(Category INSTANCE) throws HibernateException;

	/**
	 * 
	 * @param PAGE
	 * @param SIZE
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link CategoryDto}
	 * @throws HibernateException
	 */
	List<CategoryDto> findCategory(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
			throws HibernateException;

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link CategoryDto}
	 * @throws HibernateException
	 */
	List<CategoryDto> findCategory(String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param PAGE
	 * @param SIZE
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param IN_SET
	 * @param COLUMN
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link CategoryDto}
	 * @throws HibernateException
	 */
	List<CategoryDto> findCategory(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET,
			String COLUMN, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param IN_SET
	 * @param COLUMN
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link CategoryDto}
	 * @throws HibernateException
	 */
	List<CategoryDto> findCategory(String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET, String COLUMN,
			boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link CategoryDto}
	 * @throws HibernateException
	 */
	List<CategoryDto> loadCategory(Set<Integer> IDS) throws HibernateException;

	/**
	 * 
	 * @param ID
	 * @return {@link CategoryDto}
	 * @throws HibernateException
	 */
	CategoryDto loadCategory(Integer ID) throws HibernateException;

}
