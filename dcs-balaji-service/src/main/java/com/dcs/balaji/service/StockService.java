package com.dcs.balaji.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;

import com.dcs.access.model.UserDto;
import com.dcs.balaji.dao.StockDao;
import com.dcs.balaji.entity.Stock;
import com.dcs.balaji.model.SallingItems;
import com.dcs.balaji.model.StockDto;
import com.dcs.datasource.enm.SortOrder;
import com.dcs.datasource.service.GenericService;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
public interface StockService extends GenericService<StockDao, Stock> {

	/**
	 * 
	 * @param userDto
	 * @return {@link StockService}
	 */
	StockService setCurrentUser(UserDto userDto);

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer saveStock(StockDto DTO) throws HibernateException;

	/**
	 * 
	 * @param DTOS
	 * @return {@link Set}
	 * @throws HibernateException
	 */
	Set<Integer> saveStock(List<StockDto> DTOS) throws HibernateException;

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer updateStock(StockDto DTO) throws HibernateException;

	/**
	 * 
	 * @param DTOS
	 * @return {@link Long}
	 * @throws HibernateException
	 */
	Long updateStock(List<StockDto> DTOS) throws HibernateException;

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
	 * @return {@link List} {@link StockDto}
	 * @throws HibernateException
	 */
	List<StockDto> search(String TEXT, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param INSTANCE
	 * @return {@link List} {@link StockDto}
	 * @throws HibernateException
	 */
	List<StockDto> findStock(Stock INSTANCE) throws HibernateException;

	/**
	 * 
	 * @param PAGE
	 * @param SIZE
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link StockDto}
	 * @throws HibernateException
	 */
	List<StockDto> findStock(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
			throws HibernateException;

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link StockDto}
	 * @throws HibernateException
	 */
	List<StockDto> findStock(String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param PAGE
	 * @param SIZE
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param IN_SET
	 * @param COLUMN
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link StockDto}
	 * @throws HibernateException
	 */
	List<StockDto> findStock(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET,
			String COLUMN, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param IN_SET
	 * @param COLUMN
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link StockDto}
	 * @throws HibernateException
	 */
	List<StockDto> findStock(String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET, String COLUMN,
			boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link StockDto}
	 * @throws HibernateException
	 */
	List<StockDto> loadStock(Set<Integer> IDS) throws HibernateException;

	/**
	 * 
	 * @param ID
	 * @return {@link StockDto}
	 * @throws HibernateException
	 */
	StockDto loadStock(Integer ID) throws HibernateException;

	Map<String, List<SallingItems>> getItems(Integer cat_id) throws HibernateException;

}
