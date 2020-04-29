package com.dcs.balaji.service;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;

import com.dcs.balaji.dao.OfferDao;
import com.dcs.balaji.entity.Offer;
import com.dcs.balaji.model.CustomerOffer;
import com.dcs.balaji.model.ItemsDto;
import com.dcs.balaji.model.OfferDto;
import com.dcs.datasource.enm.SortOrder;
import com.dcs.datasource.service.GenericService;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
public interface OfferService extends GenericService<OfferDao, Offer> {

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer saveOffer(OfferDto DTO) throws HibernateException;

	/**
	 * 
	 * @param DTOS
	 * @return {@link Set}
	 * @throws HibernateException
	 */
	Set<Integer> saveOffer(List<OfferDto> DTOS) throws HibernateException;

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer updateOffer(OfferDto DTO) throws HibernateException;

	/**
	 * 
	 * @param DTOS
	 * @return {@link Long}
	 * @throws HibernateException
	 */
	Long updateOffer(List<OfferDto> DTOS) throws HibernateException;

	/**
	 * 
	 * @param IDS
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer delete(Set<Integer> IDS) throws HibernateException;

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link ItemsDto}
	 * @throws HibernateException
	 */
	List<OfferDto> deactivate(Set<Integer> IDS) throws HibernateException;

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link ItemsDto}
	 * @throws HibernateException
	 */
	List<OfferDto> activate(Set<Integer> IDS) throws HibernateException;

	/**
	 * 
	 * @param TEXT
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link OfferDto}
	 * @throws HibernateException
	 */
	List<OfferDto> search(String TEXT, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param INSTANCE
	 * @return {@link List} {@link OfferDto}
	 * @throws HibernateException
	 */
	List<OfferDto> findOffer(Offer INSTANCE) throws HibernateException;

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
	List<OfferDto> findOffer(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
			throws HibernateException;

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link OfferDto}
	 * @throws HibernateException
	 */
	List<OfferDto> findOffer(String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE) throws HibernateException;

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
	List<OfferDto> findOffer(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET,
			String COLUMN, boolean ONLY_ACTIVE) throws HibernateException;

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
	List<OfferDto> findOffer(String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET, String COLUMN,
			boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link OfferDto}
	 * @throws HibernateException
	 */
	List<OfferDto> loadOffer(Set<Integer> IDS) throws HibernateException;

	/**
	 * 
	 * @param ID
	 * @return {@link OfferDto}
	 * @throws HibernateException
	 */
	OfferDto loadOffer(Integer ID) throws HibernateException;

	List<CustomerOffer> getOffers(String mob, String email) throws RuntimeException;

}
