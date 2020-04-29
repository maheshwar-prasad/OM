package com.dcs.balaji.service;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;

import com.dcs.access.model.UserDto;
import com.dcs.balaji.dao.SalesOrderDao;
import com.dcs.balaji.entity.SalesOrder;
import com.dcs.balaji.model.SalesOrderDto;
import com.dcs.common.util.CommonUtils;
import com.dcs.datasource.enm.SortOrder;
import com.dcs.datasource.service.GenericService;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
public interface SalesOrderService extends GenericService<SalesOrderDao, SalesOrder> {

	int min = 11111;

	int max = 99999;

	/**
	 * 
	 * @param userDto
	 * @return {@link SalesOrderService}
	 */
	SalesOrderService setCurrentUser(UserDto userDto);

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer saveSalesOrder(SalesOrderDto DTO) throws HibernateException;

	/**
	 * 
	 * @param DTOS
	 * @return {@link Set}
	 * @throws HibernateException
	 */
	Set<Integer> saveSalesOrder(List<SalesOrderDto> DTOS) throws HibernateException;

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer updateSalesOrder(SalesOrderDto DTO) throws HibernateException;

	/**
	 * 
	 * @param DTOS
	 * @return {@link Long}
	 * @throws HibernateException
	 */
	Long updateSalesOrder(List<SalesOrderDto> DTOS) throws HibernateException;

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
	 * @return {@link List} {@link SalesOrderDto}
	 * @throws HibernateException
	 */
	List<SalesOrderDto> search(String TEXT, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param INSTANCE
	 * @return {@link List} {@link SalesOrderDto}
	 * @throws HibernateException
	 */
	List<SalesOrderDto> findSalesOrder(SalesOrder INSTANCE) throws HibernateException;

	/**
	 * 
	 * @param PAGE
	 * @param SIZE
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link SalesOrderDto}
	 * @throws HibernateException
	 */
	List<SalesOrderDto> findSalesOrder(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
			throws HibernateException;

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link SalesOrderDto}
	 * @throws HibernateException
	 */
	List<SalesOrderDto> findSalesOrder(String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
			throws HibernateException;

	/**
	 * 
	 * @param PAGE
	 * @param SIZE
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param IN_SET
	 * @param COLUMN
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link SalesOrderDto}
	 * @throws HibernateException
	 */
	List<SalesOrderDto> findSalesOrder(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER,
			Set<CharSequence> IN_SET, String COLUMN, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param IN_SET
	 * @param COLUMN
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link SalesOrderDto}
	 * @throws HibernateException
	 */
	List<SalesOrderDto> findSalesOrder(String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET, String COLUMN,
			boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link SalesOrderDto}
	 * @throws HibernateException
	 */
	List<SalesOrderDto> loadSalesOrder(Set<Integer> IDS) throws HibernateException;

	/**
	 * 
	 * @param ID
	 * @return {@link SalesOrderDto}
	 * @throws HibernateException
	 */
	SalesOrderDto loadSalesOrder(Integer ID) throws HibernateException;

	default String getOrderNumber() {
		Calendar cal = Calendar.getInstance();
		return "" + cal.get(Calendar.YEAR) + cal.get(Calendar.MONTH) + cal.get(Calendar.DATE)
				+ CommonUtils.getRandom(min, max);
	}
}
