package com.dcs.balaji.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;

import com.dcs.access.model.UserDto;
import com.dcs.balaji.constant.DCSBalajiConstant;
import com.dcs.balaji.dao.OrdersDao;
import com.dcs.balaji.enm.OrderStatus;
import com.dcs.balaji.entity.Orders;
import com.dcs.balaji.model.CancelOrder;
import com.dcs.balaji.model.OrdersDto;
import com.dcs.balaji.model.PurchaseOrder;
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
public interface OrdersService extends GenericService<OrdersDao, Orders> {

	String[] CUST_REF = { "customer", DCSBalajiConstant.Word.ID };

	String[] CONS_REF = { "consignee", DCSBalajiConstant.Word.ID };

	String[] SALES_REF = { "salesOrder", DCSBalajiConstant.Word.ID };

	String[] STOCK_REF = { "items", DCSBalajiConstant.Word.ID };

	int min = 11111;

	int max = 99999;

	/**
	 * 
	 * @param userDto
	 * @return {@link OrdersService}
	 */
	OrdersService setCurrentUser(UserDto userDto);

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer saveOrders(OrdersDto DTO) throws HibernateException;

	/**
	 * 
	 * @param DTOS
	 * @return {@link Set}
	 * @throws HibernateException
	 */
	Set<Integer> saveOrders(List<OrdersDto> DTOS) throws HibernateException;

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer updateOrders(OrdersDto DTO) throws HibernateException;

	/**
	 * 
	 * @param DTOS
	 * @return {@link Long}
	 * @throws HibernateException
	 */
	Long updateOrders(List<OrdersDto> DTOS) throws HibernateException;

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
	 * @return {@link List} {@link OrdersDto}
	 * @throws HibernateException
	 */
	List<OrdersDto> search(String TEXT, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param INSTANCE
	 * @return {@link List} {@link OrdersDto}
	 * @throws HibernateException
	 */
	List<OrdersDto> findOrders(Orders INSTANCE) throws HibernateException;

	/**
	 * 
	 * @param PAGE
	 * @param SIZE
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link OrdersDto}
	 * @throws HibernateException
	 */
	List<OrdersDto> findOrders(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
			throws HibernateException;

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link OrdersDto}
	 * @throws HibernateException
	 */
	List<OrdersDto> findOrders(String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param PAGE
	 * @param SIZE
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param IN_SET
	 * @param COLUMN
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link OrdersDto}
	 * @throws HibernateException
	 */
	List<OrdersDto> findOrders(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET,
			String COLUMN, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param IN_SET
	 * @param COLUMN
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link OrdersDto}
	 * @throws HibernateException
	 */
	List<OrdersDto> findOrders(String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET, String COLUMN,
			boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link OrdersDto}
	 * @throws HibernateException
	 */
	List<OrdersDto> loadOrders(Set<Integer> IDS) throws HibernateException;

	/**
	 * 
	 * @param ID
	 * @return {@link OrdersDto}
	 * @throws HibernateException
	 */
	OrdersDto loadOrders(Integer ID) throws HibernateException;

	SalesOrderDto pushOrder(String customer_email, String customer_mob, List<PurchaseOrder> order)
			throws HibernateException;

	SalesOrderDto updateOrder(String order_no, String customer_email, String customer_mob, List<PurchaseOrder> order)
			throws HibernateException;

	SalesOrderDto cancelOrder(String customer_email, String customer_mob, CancelOrder cancelOrder)
			throws HibernateException;

	List<SalesOrderDto> getOrders(String customer_email, String customer_mob) throws HibernateException;
	
	List<SalesOrderDto> getOrders(String customer_email, String customer_mob, Date from, Date to) throws HibernateException;

	SalesOrderDto updateOrderBySaller(String order_no, List<PurchaseOrder> order) throws HibernateException;

	SalesOrderDto cancelOrderBySaller(CancelOrder cancelOrder) throws HibernateException;

	List<SalesOrderDto> getSallerOrders(OrderStatus ORDER_STATUS) throws HibernateException;

	default String getOrderNumber() {
		Calendar cal = Calendar.getInstance();
		return "" + cal.get(Calendar.YEAR) + cal.get(Calendar.MONTH) + cal.get(Calendar.DATE)
				+ CommonUtils.getRandom(min, max);
	}
}
