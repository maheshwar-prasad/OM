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
import com.dcs.balaji.dao.SallerProfileDao;
import com.dcs.balaji.entity.SallerProfile;
import com.dcs.balaji.model.SallerProfileDto;
import com.dcs.balaji.service.SallerProfileService;
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
@Service("SallerProfileService")
@Transactional
public class SallerProfileServiceImpl extends AbstractGenericServiceImpl<SallerProfileDao, SallerProfile>
		implements SallerProfileService {

	@Autowired
	private SallerProfileDao dao;

	@Autowired
	@Qualifier("entity-to-model")
	private CustomMapper<SallerProfile, SallerProfileDto> entityToModel;

	@Autowired
	@Qualifier("model-to-entity")
	private CustomMapper<SallerProfileDto, SallerProfile> modelToEntity;

	private UserDto userDto;

	/**
	 * 
	 * @param userDto
	 * @return {@link SallerProfileService}
	 */
	@Override
	public SallerProfileService setCurrentUser(UserDto userDto) {
		this.userDto = userDto;
		return this;
	}

	@Override
	protected SallerProfileDao getDAO() {
		return this.dao;
	}

	@Override
	protected void setDAO(SallerProfileDao dao) {
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
	public Integer saveSallerProfile(SallerProfileDto DTO) throws HibernateException {
		return save(modelToEntity.map(DTO).withUserName(CommonUtils.getRandom(min, max)).withPassword(PASSWORD));
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
	public Set<Integer> saveSallerProfile(List<SallerProfileDto> DTOS) throws HibernateException {
		return batchCreate(modelToEntity.map(DTOS).parallelStream()
				.map(D -> D.withUserName(CommonUtils.getRandom(min, max)).withPassword(PASSWORD))
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
	public Integer updateSallerProfile(SallerProfileDto DTO) throws HibernateException {
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
	public Long updateSallerProfile(List<SallerProfileDto> DTOS) throws HibernateException {
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
	 * @return {@link List} {@link SallerProfileDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<SallerProfileDto> search(String TEXT, boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(comGenSearchService.getSearchedList(SallerProfile.class, TEXT, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param INSTANCE
	 * @return {@link List} {@link SallerProfileDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<SallerProfileDto> findSallerProfile(SallerProfile INSTANCE) throws HibernateException {
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
	 * @return {@link List} {@link SallerProfileDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<SallerProfileDto> findSallerProfile(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER,
			boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(find(PAGE, SIZE, SORT_BY, SORT_ORDER, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link SallerProfileDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<SallerProfileDto> findSallerProfile(String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
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
	 * @return {@link List} {@link SallerProfileDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<SallerProfileDto> findSallerProfile(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER,
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
	 * @return {@link List} {@link SallerProfileDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<SallerProfileDto> findSallerProfile(String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET,
			String COLUMN, boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(find(SORT_BY, SORT_ORDER, IN_SET, COLUMN, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link SallerProfileDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<SallerProfileDto> loadSallerProfile(Set<Integer> IDS) throws HibernateException {
		return entityToModel.map(load(IDS, CommonDBConstant.ID));
	}

	/**
	 * 
	 * @param ID
	 * @return {@link SallerProfileDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public SallerProfileDto loadSallerProfile(Integer ID) throws HibernateException {
		return entityToModel.map(load(ID));
	}

}
