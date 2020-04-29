package com.dcs.balaji.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcs.access.model.UserDto;
import com.dcs.balaji.dao.StockDao;
import com.dcs.balaji.entity.Items;
import com.dcs.balaji.entity.Stock;
import com.dcs.balaji.model.Offers;
import com.dcs.balaji.model.SallingItems;
import com.dcs.balaji.model.StockDto;
import com.dcs.balaji.service.StockService;
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
@Service("StockService")
@Transactional
public class StockServiceImpl extends AbstractGenericServiceImpl<StockDao, Stock> implements StockService {

	@Autowired
	private StockDao dao;

	@Autowired
	@Qualifier("entity-to-model")
	private CustomMapper<Stock, StockDto> entityToModel;

	@Autowired
	@Qualifier("model-to-entity")
	private CustomMapper<StockDto, Stock> modelToEntity;

	private UserDto userDto;

	/**
	 * 
	 * @param userDto
	 * @return {@link StockService}
	 */
	@Override
	public StockService setCurrentUser(UserDto userDto) {
		this.userDto = userDto;
		return this;
	}

	@Override
	protected StockDao getDAO() {
		return this.dao;
	}

	@Override
	protected void setDAO(StockDao dao) {
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
	public Integer saveStock(StockDto DTO) throws HibernateException {
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
	public Set<Integer> saveStock(List<StockDto> DTOS) throws HibernateException {
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
	public Integer updateStock(StockDto DTO) throws HibernateException {
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
	public Long updateStock(List<StockDto> DTOS) throws HibernateException {
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
	 * @return {@link List} {@link StockDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<StockDto> search(String TEXT, boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(comGenSearchService.getSearchedList(Stock.class, TEXT, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param INSTANCE
	 * @return {@link List} {@link StockDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<StockDto> findStock(Stock INSTANCE) throws HibernateException {
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
	 * @return {@link List} {@link StockDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<StockDto> findStock(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
			throws HibernateException {
		return entityToModel.map(find(PAGE, SIZE, SORT_BY, SORT_ORDER, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link StockDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<StockDto> findStock(String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
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
	 * @return {@link List} {@link StockDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<StockDto> findStock(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET,
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
	 * @return {@link List} {@link StockDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<StockDto> findStock(String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET, String COLUMN,
			boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(find(SORT_BY, SORT_ORDER, IN_SET, COLUMN, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link StockDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<StockDto> loadStock(Set<Integer> IDS) throws HibernateException {
		return entityToModel.map(load(IDS, CommonDBConstant.ID));
	}

	/**
	 * 
	 * @param ID
	 * @return {@link StockDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public StockDto loadStock(Integer ID) throws HibernateException {
		return entityToModel.map(load(ID));
	}

	@Override
	public Map<String, List<SallingItems>> getItems(Integer cat_id) throws HibernateException {
		Date currentDate = new Date();
		List<Stock> stocks = find(null, null, false);
		if (cat_id != null)
			stocks = stocks.parallelStream().filter(S -> S.getItems().getCategory().getId().equals(cat_id))
					.collect(Collectors.toList());
		List<SallingItems> salling_list = getSallingItems(currentDate, stocks);
		Map<String, List<SallingItems>> map = new LinkedHashMap<>();
		for (SallingItems items : salling_list) {
			String item_name = items.getItemName();
			if (map.containsKey(item_name)) {
				List<SallingItems> list = map.get(item_name);
				list.add(items);
				map.put(item_name, list);
			} else {
				List<SallingItems> list = new ArrayList<>();
				list.add(items);
				map.put(item_name, list);
			}

		}

		return map;
	}

	private List<SallingItems> getSallingItems(Date currentDate, List<Stock> stocks) {
		return stocks.parallelStream().filter(STCK -> STCK.getItems().isActive()).map(STCK -> {
			Items items = STCK.getItems();
			SallingItems items2 = new SallingItems();
			items2.setInStock(false);
			if (STCK.getQty() > 0) {
				if (items.getOfferUnits() != null && items.getOfferUnits() > 0) {
					if (CommonUtils.compareDates(currentDate, items.getOfferEffectedBy()) >= 0
							&& CommonUtils.compareDates(currentDate, items.getOfferTill()) <= 0) {
						Offers offer = new Offers();
						offer.setOnPurchaseOf(items.getOfferUnits());
						Integer amountOff = null;
						Integer freeItems = null;
						String scheme = null;
						switch (items.getOfferType()) {
						case POF:
							scheme = items.getFree() + " Off On Purchase Of " + items.getOfferUnits();
							amountOff = items.getFree();
							break;

						case FU:
							scheme = items.getFree() + " Items Free On Purchase Of " + items.getOfferUnits();
							freeItems = items.getFree();
							break;
						}
						offer.setAmountOff(amountOff);
						offer.setFreeItems(freeItems);
						items2.setOffers(offer);
						items2.setScheme(scheme);
					}
				}
				items2.setInStock(true);
			}
			items2.setItemsId(items.getId());
			items2.setItemCode(items.getItemCode());
			items2.setItemName(items.getItemName());
			items2.setStock(STCK.getQty());
			items2.setPack(items.getPack());
			items2.setMrp(items.getMrp());
			items2.setSellingPrice(items.getUnitPrice());
			items2.setDescription(items.getDescription());
			items2.setDisplayOrder(items.getDisplayOrder());
			items2.setItemImage(items.getItemImage());

			return items2;
		}).collect(Collectors.toList());
	}

}
