package com.dcs.balaji.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcs.access.model.UserDto;
import com.dcs.balaji.dao.SalesOrderDao;
import com.dcs.balaji.entity.SalesOrder;
import com.dcs.balaji.model.SalesOrderDto;
import com.dcs.balaji.service.SalesOrderService;
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
@Service("SalesOrderService")
@Transactional
public class SalesOrderServiceImpl extends AbstractGenericServiceImpl<SalesOrderDao, SalesOrder>
		implements SalesOrderService {

	@Autowired
	private SalesOrderDao dao;

	@Autowired
	@Qualifier("entity-to-model")
	private CustomMapper<SalesOrder, SalesOrderDto> entityToModel;

	@Autowired
	@Qualifier("model-to-entity")
	private CustomMapper<SalesOrderDto, SalesOrder> modelToEntity;

	private UserDto userDto;

	/**
	 * 
	 * @param userDto
	 * @return {@link SalesOrderService}
	 */
	@Override
	public SalesOrderService setCurrentUser(UserDto userDto) {
		this.userDto = userDto;
		return this;
	}

	@Override
	protected SalesOrderDao getDAO() {
		return this.dao;
	}

	@Override
	protected void setDAO(SalesOrderDao dao) {
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
	public Integer saveSalesOrder(SalesOrderDto DTO) throws HibernateException {
		return save(modelToEntity.map(DTO).withOrderNumber(getOrderNumber()));
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
	public Set<Integer> saveSalesOrder(List<SalesOrderDto> DTOS) throws HibernateException {
		return batchCreate(modelToEntity.map(DTOS).parallelStream().map(D -> D.withOrderNumber(getOrderNumber()))
				.collect(Collectors.toList()), 10);
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
	public Integer updateSalesOrder(SalesOrderDto DTO) throws HibernateException {
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
	public Long updateSalesOrder(List<SalesOrderDto> DTOS) throws HibernateException {
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
	 * @return {@link List} {@link SalesOrderDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<SalesOrderDto> search(String TEXT, boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(comGenSearchService.getSearchedList(SalesOrder.class, TEXT, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param INSTANCE
	 * @return {@link List} {@link SalesOrderDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<SalesOrderDto> findSalesOrder(SalesOrder INSTANCE) throws HibernateException {
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
	 * @return {@link List} {@link SalesOrderDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<SalesOrderDto> findSalesOrder(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER,
			boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(find(PAGE, SIZE, SORT_BY, SORT_ORDER, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link SalesOrderDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<SalesOrderDto> findSalesOrder(String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
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
	 * @return {@link List} {@link SalesOrderDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<SalesOrderDto> findSalesOrder(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER,
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
	 * @return {@link List} {@link SalesOrderDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<SalesOrderDto> findSalesOrder(String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET,
			String COLUMN, boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(find(SORT_BY, SORT_ORDER, IN_SET, COLUMN, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link SalesOrderDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<SalesOrderDto> loadSalesOrder(Set<Integer> IDS) throws HibernateException {
		return entityToModel.map(load(IDS, CommonDBConstant.ID));
	}

	/**
	 * 
	 * @param ID
	 * @return {@link SalesOrderDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public SalesOrderDto loadSalesOrder(Integer ID) throws HibernateException {
		return entityToModel.map(load(ID));
	}

}
