package com.dcs.balaji.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.dcs.access.model.UserDto;
import com.dcs.balaji.constant.DCSBalajiConstant;
import com.dcs.balaji.dao.ConsigneeDao;
import com.dcs.balaji.dao.CustomerDao;
import com.dcs.balaji.dao.CustomerSettingDao;
import com.dcs.balaji.dao.ItemsDao;
import com.dcs.balaji.dao.OrdersDao;
import com.dcs.balaji.dao.SalesOrderDao;
import com.dcs.balaji.dao.StockDao;
import com.dcs.balaji.enm.CancelledBy;
import com.dcs.balaji.enm.OrderStatus;
import com.dcs.balaji.entity.Consignee;
import com.dcs.balaji.entity.Customer;
import com.dcs.balaji.entity.CustomerSetting;
import com.dcs.balaji.entity.Items;
import com.dcs.balaji.entity.Orders;
import com.dcs.balaji.entity.SalesOrder;
import com.dcs.balaji.entity.Stock;
import com.dcs.balaji.model.CancelOrder;
import com.dcs.balaji.model.OrdersDto;
import com.dcs.balaji.model.PurchaseOrder;
import com.dcs.balaji.model.SalesOrderDto;
import com.dcs.balaji.service.OrdersService;
import com.dcs.balaji.service.StockService;
import com.dcs.common.enm.RoundType;
import com.dcs.common.util.CommonUtils;
import com.dcs.common.util.CustomMapper;
import com.dcs.datasource.constant.CommonDBConstant;
import com.dcs.datasource.enm.SortOrder;
import com.dcs.datasource.service.impl.AbstractGenericServiceImpl;
import com.dcs.logging.annotation.LogAfter;
import com.dcs.logging.annotation.LogBefore;
import com.dcs.logging.annotation.LogExceptionaly;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
@Service("OrdersService")
@Transactional
public class OrdersServiceImpl extends AbstractGenericServiceImpl<OrdersDao, Orders> implements OrdersService {

	@Autowired
	private OrdersDao dao;

	@Autowired
	@Qualifier("entity-to-model")
	private CustomMapper<Orders, OrdersDto> entityToModel;

	@Autowired
	@Qualifier("model-to-entity")
	private CustomMapper<OrdersDto, Orders> modelToEntity;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private ItemsDao itemsDao;

	@Autowired
	private SalesOrderDao salesOrderDao;

	@Autowired
	private OrdersDao ordersDao;

	@Autowired
	private StockDao stockDao;

	@Autowired
	private StockService stockService;

	@Autowired
	private CustomerSettingDao custSettingDao;

	@Autowired
	private ConsigneeDao consigneeDao;

	private UserDto userDto;

	/**
	 * 
	 * @param userDto
	 * @return {@link OrdersService}
	 */
	@Override
	public OrdersService setCurrentUser(UserDto userDto) {
		this.userDto = userDto;
		return this;
	}

	@Override
	protected OrdersDao getDAO() {
		return this.dao;
	}

	@Override
	protected void setDAO(OrdersDao dao) {
		this.dao = dao;

	}

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public Integer saveOrders(OrdersDto DTO) throws HibernateException {
		return save(modelToEntity.map(DTO));
	}

	/**
	 * 
	 * @param DTOS
	 * @return {@link Set}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public Set<Integer> saveOrders(List<OrdersDto> DTOS) throws HibernateException {
		return batchCreate(modelToEntity.map(DTOS), 10);
	}

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public Integer updateOrders(OrdersDto DTO) throws HibernateException {
		return update(modelToEntity.map(DTO)).getId();
	}

	/**
	 * 
	 * @param DTOS
	 * @return {@link Long}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public Long updateOrders(List<OrdersDto> DTOS) throws HibernateException {
		return batchUpdate(modelToEntity.map(DTOS), 10);
	}

	/**
	 * 
	 * @param IDS
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public Integer delete(Set<Integer> IDS) throws HibernateException {
		return delete(IDS, CommonDBConstant.ID);
	}

	/**
	 * 
	 * @param TEXT
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link OrdersDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<OrdersDto> search(String TEXT, boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(comGenSearchService.getSearchedList(Orders.class, TEXT, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param INSTANCE
	 * @return {@link List} {@link OrdersDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<OrdersDto> findOrders(Orders INSTANCE) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

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
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<OrdersDto> findOrders(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
			throws HibernateException {
		return entityToModel.map(find(PAGE, SIZE, SORT_BY, SORT_ORDER, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link OrdersDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<OrdersDto> findOrders(String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
			throws HibernateException {
		return entityToModel.map(find(SORT_BY, SORT_ORDER, ONLY_ACTIVE));
	}

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
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<OrdersDto> findOrders(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER,
			Set<CharSequence> IN_SET, String COLUMN, boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(find(SORT_BY, SORT_ORDER, IN_SET, COLUMN, ONLY_ACTIVE));
	}

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
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<OrdersDto> findOrders(String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET, String COLUMN,
			boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(find(SORT_BY, SORT_ORDER, IN_SET, COLUMN, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link OrdersDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<OrdersDto> loadOrders(Set<Integer> IDS) throws HibernateException {
		return entityToModel.map(load(IDS, CommonDBConstant.ID));
	}

	/**
	 * 
	 * @param ID
	 * @return {@link OrdersDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public OrdersDto loadOrders(Integer ID) throws HibernateException {
		return entityToModel.map(load(ID));
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public SalesOrderDto pushOrder(String customer_email, String customer_mob, List<PurchaseOrder> order)
			throws HibernateException {
		List<Items> items = itemsDao.load(order.parallelStream().map(O -> O.getItemId()).collect(Collectors.toSet()),
				DCSBalajiConstant.Word.ID);
		if (items.size() == 0)
			throw new HibernateException("Invalid Items");

		Map<Integer, Integer> orderMap = order.parallelStream()
				.collect(Collectors.toMap(O -> O.getItemId(), O -> O.getQty()));

		Date currentDate = new Date();

		List<Orders> orderList = prepareOrder(items, orderMap, currentDate);

		Map<Integer, Integer> stocks = orderList.parallelStream()
				.collect(Collectors.toMap(O -> O.getItems().getId(), O -> O.getQty()));

		Double totalAmount = orderList.parallelStream().map(O -> O.getAmount()).reduce(0.0, Double::sum);
		SalesOrder salesOrder = new SalesOrder();
		if (isRetailer())
			salesOrder.setCustomer(new Customer(getCustRef(customer_email, customer_mob)));
		else
			salesOrder.setConsignee(new Consignee(getConsRef(customer_email, customer_mob)));
		salesOrder.setOrderDate(currentDate);
		salesOrder.setOrderStatus(OrderStatus.P);
		salesOrder.setTotalAmount(totalAmount);
		salesOrder.setOrderNumber(getOrderNumber());
		salesOrder.setOrders(new HashSet<>(orderList));
		Integer id = salesOrderDao.save(salesOrder);
		stocks.forEach((K, V) -> subQty(K, V));
		return salesOrderDao.load(id).model();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public List<Orders> prepareOrder(List<Items> items, Map<Integer, Integer> orderMap, Date currentDate) {
		List<Orders> orderList = items.parallelStream().filter(ITM -> checkQty(ITM.getId(), orderMap.get(ITM.getId())))
				.map(ITM -> {
					Integer qty = orderMap.get(ITM.getId());
					Double amount = ITM.getUnitPrice() * qty;
					if (ITM.getOfferUnits() != null && ITM.getOfferUnits() > 0) {
						if (CommonUtils.compareDates(currentDate, ITM.getOfferEffectedBy()) >= 0
								&& CommonUtils.compareDates(currentDate, ITM.getOfferTill()) <= 0) {
							if (qty >= ITM.getOfferUnits()) {
								double offer_count = qty / ITM.getOfferUnits();
								int off = CommonUtils.round(offer_count, RoundType.FLOOR);
								switch (ITM.getOfferType()) {
								case POF:
									amount = amount - (ITM.getFree() * off);
									break;

								case FU:
									qty = qty + (ITM.getFree() * off);
									break;
								}
							}
						}
					}

					Orders orders = new Orders();
					orders.setItems(ITM);
					orders.setOrderDate(currentDate);
					orders.setOrderStatus(OrderStatus.P);
					orders.setQty(qty);
					orders.setAmount(amount);
					return orders;
				}).collect(Collectors.toList());
		return orderList;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean checkQty(Integer items_id, Integer qty) {
		List<Stock> stocks = stockService.load(items_id, STOCK_REF);
		if (stocks.size() == 0)
			throw new HibernateException("Invalid Items");
		Stock stock = stocks.get(0);
		if (qty <= stock.getQty())
			return true;
		else
			return true;

	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean addQty(Integer items_id, Integer qty) {
		List<Stock> stocks = stockService.load(items_id, STOCK_REF);
		if (stocks.size() == 0)
			throw new HibernateException("Invalid Items");
		Stock stock = stocks.get(0);
		if (qty <= stock.getQty()) {
			stock.setQty(stock.getQty() + qty);
			stockService.merge(stock);
			return true;
		} else
			return true;

	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean subQty(Integer items_id, Integer qty) {
		List<Stock> stocks = stockService.load(items_id, STOCK_REF);
		if (stocks.size() == 0)
			throw new HibernateException("Invalid Items");
		Stock stock = stocks.get(0);
		if (qty <= stock.getQty()) {
			stock.setQty(stock.getQty() - qty);
			stockService.merge(stock);
			return true;
		} else
			return true;

	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public SalesOrderDto updateOrder(String order_no, String customer_email, String customer_mob,
			List<PurchaseOrder> order) throws HibernateException {
		List<SalesOrder> list = salesOrderDao.load("orderNumber", order_no);
		if (list.size() == 0)
			throw new HibernateException("Invalid Order Number");

		SalesOrder sales_order = list.get(0);

		List<Items> items = itemsDao.load(order.parallelStream().map(O -> O.getItemId()).collect(Collectors.toSet()),
				DCSBalajiConstant.Word.ID);
		if (items.size() == 0)
			throw new HibernateException("Invalid Items");

		Map<Integer, Integer> orderMap = order.parallelStream()
				.collect(Collectors.toMap(O -> O.getItemId(), O -> O.getQty()));

		Date currentDate = new Date();

		List<Orders> orderList = prepareOrder(items, orderMap, currentDate);
		Map<Integer, Integer> stocks = orderList.parallelStream()
				.collect(Collectors.toMap(O -> O.getItems().getId(), O -> O.getQty()));
		ordersDao.delete(new HashSet<>(Arrays.asList(sales_order.getId())), "salesOrder");
		Double totalAmount = orderList.parallelStream().map(O -> O.getAmount()).reduce(0.0, Double::sum);
		sales_order.setTotalAmount(totalAmount);
		sales_order.setOrders(new HashSet<>(orderList));
		salesOrderDao.merge(sales_order);
		stocks.forEach((K, V) -> addQty(K, V));
		stocks.forEach((K, V) -> subQty(K, V));
		return sales_order.model();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public SalesOrderDto cancelOrder(String customer_email, String customer_mob, CancelOrder cancelOrder)
			throws HibernateException {
		List<SalesOrder> list = salesOrderDao.load("orderNumber", cancelOrder.getOrderNo());
		if (list.size() == 0)
			throw new HibernateException("Invalid Order Number");

		SalesOrder order = list.get(0);
		order.setCancelledBy(CancelledBy.C);
		order.setOrderStatus(OrderStatus.R);
		order.setRejectedOn(new Date());
		order.setRemark(cancelOrder.getRemarks());
		Map<Integer, Integer> stocks = order.getOrders().parallelStream()
				.collect(Collectors.toMap(O -> O.getItems().getId(), O -> O.getQty()));
		salesOrderDao.merge(order);
		stocks.forEach((K, V) -> addQty(K, V));
		ordersDao.delete(new HashSet<>(Arrays.asList(order.getId())), "salesOrder");
		return order.model();
	}

	@Override
	public List<SalesOrderDto> getOrders(String customer_email, String customer_mob) throws HibernateException {
		if (isRetailer())
			return salesOrderDao.load(getCustRef(customer_email, customer_mob), CUST_REF).parallelStream()
					.map(O -> O.model()).collect(Collectors.toList());
		else
			return salesOrderDao.load(getConsRef(customer_email, customer_mob), CONS_REF).parallelStream()
					.map(O -> O.model()).collect(Collectors.toList());
	}

	@Override
	public SalesOrderDto updateOrderBySaller(String order_no, List<PurchaseOrder> order) throws HibernateException {
		List<SalesOrder> list = salesOrderDao.load("orderNumber", order_no);
		if (list.size() == 0)
			throw new HibernateException("Invalid Order Number");

		SalesOrder sales_order = list.get(0);

		List<Items> items = itemsDao.load(order.parallelStream().map(O -> O.getItemId()).collect(Collectors.toSet()),
				DCSBalajiConstant.Word.ID);
		if (items.size() == 0)
			throw new HibernateException("Invalid Items");

		Map<Integer, Integer> orderMap = order.parallelStream()
				.collect(Collectors.toMap(O -> O.getItemId(), O -> O.getQty()));

		Date currentDate = new Date();

		List<Orders> orderList = prepareOrder(items, orderMap, currentDate);
		Map<Integer, Integer> stocks = orderList.parallelStream()
				.collect(Collectors.toMap(O -> O.getItems().getId(), O -> O.getQty()));
		Double totalAmount = orderList.parallelStream().map(O -> O.getAmount()).reduce(0.0, Double::sum);
		sales_order.setTotalAmount(totalAmount);
		sales_order.setOrders(new HashSet<>(orderList));
		ordersDao.delete(new HashSet<>(Arrays.asList(sales_order.getId())), "salesOrder");
		salesOrderDao.merge(sales_order);
		stocks.forEach((K, V) -> addQty(K, V));
		stocks.forEach((K, V) -> subQty(K, V));
		return sales_order.model();
	}

	@Override
	public SalesOrderDto cancelOrderBySaller(CancelOrder cancelOrder) throws HibernateException {
		List<SalesOrder> list = salesOrderDao.load("orderNumber", cancelOrder.getOrderNo());
		if (list.size() == 0)
			throw new HibernateException("Invalid Order Number");

		SalesOrder order = list.get(0);
		order.setCancelledBy(CancelledBy.S);
		order.setRejectedOn(new Date());
		order.setRemark(cancelOrder.getRemarks());
		Map<Integer, Integer> stocks = order.getOrders().parallelStream()
				.collect(Collectors.toMap(O -> O.getItems().getId(), O -> O.getQty()));
		salesOrderDao.merge(order);
		stocks.forEach((K, V) -> addQty(K, V));
		return order.model();
	}

	@Override
	public List<SalesOrderDto> getSallerOrders(OrderStatus ORDER_STATUS) throws HibernateException {
		List<SalesOrder> entities = salesOrderDao.find(false);
		if (ORDER_STATUS != null)
			return entities.parallelStream().filter(SR -> SR.getOrderStatus().equals(ORDER_STATUS))
					.map(SR -> SR.model()).collect(Collectors.toList());
		else
			return entities.parallelStream().map(SR -> SR.model()).collect(Collectors.toList());
	}

	public boolean isRetailer() {
		List<CustomerSetting> customerSettings = custSettingDao.find(true);
		if (customerSettings.size() > 0)
			if (customerSettings.get(0).isRegRequired())
				return true;
			else
				return false;
		else
			return false;
	}

	public Integer getCustRef(String email, String mob) {
		List<Customer> customer = customerDao.load("email", email);
		if (customer.size() == 0)
			customer = customerDao.load("mob", mob);
		if (customer.size() == 0)
			throw new HibernateException("Invalid Customer");

		return customer.get(0).getId();
	}

	public Integer getConsRef(String email, String mob) {
		List<Consignee> customer = consigneeDao.load("email", email);
		if (customer.size() == 0)
			customer = consigneeDao.load("mob", mob);
		if (customer.size() == 0)
			throw new HibernateException("Invalid Customer");

		return customer.get(0).getId();
	}

	@Override
	public List<SalesOrderDto> getOrders(String customer_email, String customer_mob, Date from, Date to)
			throws HibernateException {
		List<SalesOrder> list = null;
		if (isRetailer())
			list = salesOrderDao.getOrders(getCustRef(customer_email, customer_mob), true, from, to);
		else
			list = salesOrderDao.getOrders(getConsRef(customer_email, customer_mob), true, from, to);
		return list.parallelStream().map(D -> D.model()).collect(Collectors.toList());
	}

}
