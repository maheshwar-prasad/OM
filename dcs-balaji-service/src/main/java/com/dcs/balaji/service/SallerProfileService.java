package com.dcs.balaji.service;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;

import com.dcs.access.model.UserDto;
import com.dcs.balaji.dao.SallerProfileDao;
import com.dcs.balaji.entity.SallerProfile;
import com.dcs.balaji.model.SallerProfileDto;
import com.dcs.datasource.enm.SortOrder;
import com.dcs.datasource.service.GenericService;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
public interface SallerProfileService extends GenericService<SallerProfileDao, SallerProfile> {

	String PASSWORD = "Sales@123";

	int min = 111111;

	int max = 999999;

	/**
	 * 
	 * @param userDto
	 * @return {@link SallerProfileService}
	 */
	SallerProfileService setCurrentUser(UserDto userDto);

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer saveSallerProfile(SallerProfileDto DTO) throws HibernateException;

	/**
	 * 
	 * @param DTOS
	 * @return {@link Set}
	 * @throws HibernateException
	 */
	Set<Integer> saveSallerProfile(List<SallerProfileDto> DTOS) throws HibernateException;

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer updateSallerProfile(SallerProfileDto DTO) throws HibernateException;

	/**
	 * 
	 * @param DTOS
	 * @return {@link Long}
	 * @throws HibernateException
	 */
	Long updateSallerProfile(List<SallerProfileDto> DTOS) throws HibernateException;

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
	 * @return {@link List} {@link SallerProfileDto}
	 * @throws HibernateException
	 */
	List<SallerProfileDto> search(String TEXT, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param INSTANCE
	 * @return {@link List} {@link SallerProfileDto}
	 * @throws HibernateException
	 */
	List<SallerProfileDto> findSallerProfile(SallerProfile INSTANCE) throws HibernateException;

	/**
	 * 
	 * @param PAGE
	 * @param SIZE
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link SallerProfileDto}
	 * @throws HibernateException
	 */
	List<SallerProfileDto> findSallerProfile(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER,
			boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link SallerProfileDto}
	 * @throws HibernateException
	 */
	List<SallerProfileDto> findSallerProfile(String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
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
	 * @return {@link List} {@link SallerProfileDto}
	 * @throws HibernateException
	 */
	List<SallerProfileDto> findSallerProfile(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER,
			Set<CharSequence> IN_SET, String COLUMN, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param IN_SET
	 * @param COLUMN
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link SallerProfileDto}
	 * @throws HibernateException
	 */
	List<SallerProfileDto> findSallerProfile(String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET,
			String COLUMN, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link SallerProfileDto}
	 * @throws HibernateException
	 */
	List<SallerProfileDto> loadSallerProfile(Set<Integer> IDS) throws HibernateException;

	/**
	 * 
	 * @param ID
	 * @return {@link SallerProfileDto}
	 * @throws HibernateException
	 */
	SallerProfileDto loadSallerProfile(Integer ID) throws HibernateException;
}
