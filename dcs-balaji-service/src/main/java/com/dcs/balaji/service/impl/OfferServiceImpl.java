package com.dcs.balaji.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcs.balaji.dao.OfferDao;
import com.dcs.balaji.entity.Offer;
import com.dcs.balaji.model.CustomerOffer;
import com.dcs.balaji.model.ItemsDto;
import com.dcs.balaji.model.OfferDto;
import com.dcs.balaji.model.SalesOrderDto;
import com.dcs.balaji.service.OfferService;
import com.dcs.balaji.service.OrdersService;
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
@Service("OfferService")
@Transactional
public class OfferServiceImpl extends AbstractGenericServiceImpl<OfferDao, Offer> implements OfferService {

	@Autowired
	private OfferDao dao;

	@Autowired
	@Qualifier("entity-to-model")
	private CustomMapper<Offer, OfferDto> entityToModel;

	@Autowired
	@Qualifier("model-to-entity")
	private CustomMapper<OfferDto, Offer> modelToEntity;

	@Autowired
	private OrdersService service;

	@Override
	protected OfferDao getDAO() {
		return this.dao;
	}

	@Override
	protected void setDAO(OfferDao dao) {
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
	public Integer saveOffer(OfferDto DTO) throws HibernateException {
		return save(modelToEntity.map(DTO).withDuration(getDuration(DTO.getDurationFrom(), DTO.getDurationTo())));
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
	public Set<Integer> saveOffer(List<OfferDto> DTOS) throws HibernateException {
		return batchCreate(modelToEntity.map(DTOS).parallelStream()
				.map(D -> D.withDuration(getDuration(D.getDurationFrom(), D.getDurationTo())))
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
	public Integer updateOffer(OfferDto DTO) throws HibernateException {
		return update(modelToEntity.map(DTO)).getItems().getId();
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
	public Long updateOffer(List<OfferDto> DTOS) throws HibernateException {
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
	 * @param IDS
	 * @return {@link List} {@link ItemsDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<OfferDto> deactivate(Set<Integer> IDS) throws HibernateException {
		deactive(IDS, null);
		return entityToModel.map(load(IDS, CommonDBConstant.ID));
	}

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link ItemsDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<OfferDto> activate(Set<Integer> IDS) throws HibernateException {
		active(IDS, null);
		return entityToModel.map(load(IDS, CommonDBConstant.ID));
	}

	/**
	 * 
	 * @param TEXT
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link OfferDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<OfferDto> search(String TEXT, boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(comGenSearchService.getSearchedList(Offer.class, TEXT, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param INSTANCE
	 * @return {@link List} {@link OfferDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<OfferDto> findOffer(Offer INSTANCE) throws HibernateException {
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
	 * @return {@link List} {@link OfferDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<OfferDto> findOffer(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
			throws HibernateException {
		return entityToModel.map(find(PAGE, SIZE, SORT_BY, SORT_ORDER, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link OfferDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<OfferDto> findOffer(String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
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
	 * @return {@link List} {@link OfferDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<OfferDto> findOffer(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET,
			String COLUMN, boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(find(SORT_BY, SORT_ORDER, IN_SET, COLUMN, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param IN_SET
	 * @param COLUMN
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link OfferDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<OfferDto> findOffer(String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET, String COLUMN,
			boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(find(SORT_BY, SORT_ORDER, IN_SET, COLUMN, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link OfferDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<OfferDto> loadOffer(Set<Integer> IDS) throws HibernateException {
		return entityToModel.map(load(IDS, CommonDBConstant.ID));
	}

	/**
	 * 
	 * @param ID
	 * @return {@link OfferDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public OfferDto loadOffer(Integer ID) throws HibernateException {
		return entityToModel.map(load(ID));
	}

	private String getDuration(Date from, Date to) {
		long days = CommonUtils.getDaysDifference(from, to);
		if (days > 30) {
			days = days / 30;
			return days + " Months";
		}
		return days + " Days";
	}

	@Override
	public List<CustomerOffer> getOffers(String mob, String email) throws RuntimeException {
		List<Offer> list = getDAO().find(true);
		List<CustomerOffer> customerOffers = new ArrayList<>();
		Date currentDate = new Date();
		Double next = 0.0;
		for (Offer offer : list) {
			if (CommonUtils.compareDates(currentDate, offer.getDurationFrom()) >= 0
					&& CommonUtils.compareDates(currentDate, offer.getDurationTo()) <= 0) {
				List<SalesOrderDto> dtos = service.getOrders(email, mob, offer.getDurationFrom(),
						offer.getDurationTo());
				List<SalesOrderDto> orders = dtos.stream().filter(O -> filterOrder(offer, O.getOrderDate()))
						.collect(Collectors.toList());
				Double totalAmount = orders.parallelStream().map(O -> O.getTotalAmount()).reduce(0.0, Double::sum);
				Double remain = offer.getPurchase() - (totalAmount + next);
				next = 0.0;
				if (remain > 0) {
					customerOffers.add(new CustomerOffer("You are just Rs. " + remain + " from gift article "
							+ offer.getGift() + " " + offer.getOfferName() + " "
							+ CommonUtils.getDaysDifference(currentDate, offer.getDurationTo()) + " days are left"));
				} else {
					customerOffers.add(
							new CustomerOffer("You own gift article " + offer.getGift() + " " + offer.getOfferName()));
				}
				next = remain;

			}

		}
		return customerOffers;
	}

	private boolean filterOrder(Offer offer, Date orderDate) {
		if (CommonUtils.compareDates(orderDate, offer.getDurationFrom()) >= 0
				&& CommonUtils.compareDates(orderDate, offer.getDurationTo()) <= 0)
			return true;
		else

			return false;
	}
}
