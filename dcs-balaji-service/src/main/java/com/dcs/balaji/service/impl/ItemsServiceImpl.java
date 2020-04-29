package com.dcs.balaji.service.impl;

import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.dcs.access.model.UserDto;
import com.dcs.balaji.dao.ItemsDao;
import com.dcs.balaji.enm.ImageType;
import com.dcs.balaji.entity.Items;
import com.dcs.balaji.model.ItemsDto;
import com.dcs.balaji.service.ImageService;
import com.dcs.balaji.service.ItemsService;
import com.dcs.common.file.response.CommonFileUploadResponse;
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
@Service("ItemsService")
@Transactional
public class ItemsServiceImpl extends AbstractGenericServiceImpl<ItemsDao, Items> implements ItemsService {

	@Autowired
	private ItemsDao dao;

	@Autowired
	@Qualifier("entity-to-model")
	private CustomMapper<Items, ItemsDto> entityToModel;

	@Autowired
	@Qualifier("model-to-entity")
	private CustomMapper<ItemsDto, Items> modelToEntity;

	@Autowired
	private ImageService imageService;

	private UserDto userDto;

	/**
	 * 
	 * @param userDto
	 * @return {@link ItemsService}
	 */
	@Override
	public ItemsService setCurrentUser(UserDto userDto) {
		this.userDto = userDto;
		return this;
	}

	@Override
	protected ItemsDao getDAO() {
		return this.dao;
	}

	@Override
	protected void setDAO(ItemsDao dao) {
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
	public Integer saveItems(ItemsDto DTO) throws HibernateException {
		return save(modelToEntity.map(DTO)
				.withItemCode(CommonUtils.getPrefixChar(DTO.getItemName()) + CommonUtils.getRandom(min, max)));
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
	public Set<Integer> saveItems(List<ItemsDto> DTOS) throws HibernateException {
		return batchCreate(modelToEntity.map(DTOS).parallelStream()
				.map(D -> D.withItemCode(CommonUtils.getPrefixChar(D.getItemName()) + CommonUtils.getRandom(min, max)))
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
	public Integer updateItems(ItemsDto DTO) throws HibernateException {
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
	public Long updateItems(List<ItemsDto> DTOS) throws HibernateException {
		return batchUpdate(modelToEntity.map(DTOS), 10);
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
	public List<ItemsDto> deactivate(Set<Integer> IDS) throws HibernateException {
		deactive(IDS, null);
		return entityToModel.map(load(IDS, CommonDBConstant.ID));
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
	public List<ItemsDto> activate(Set<Integer> IDS) throws HibernateException {
		active(IDS, null);
		return entityToModel.map(load(IDS, CommonDBConstant.ID));
	}

	/**
	 * 
	 * @param TEXT
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link ItemsDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<ItemsDto> search(String TEXT, boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(comGenSearchService.getSearchedList(Items.class, TEXT, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param INSTANCE
	 * @return {@link List} {@link ItemsDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<ItemsDto> findItems(Items INSTANCE) throws HibernateException {
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
	 * @return {@link List} {@link ItemsDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<ItemsDto> findItems(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
			throws HibernateException {
		return entityToModel.map(find(PAGE, SIZE, SORT_BY, SORT_ORDER, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link ItemsDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<ItemsDto> findItems(String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
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
	 * @return {@link List} {@link ItemsDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<ItemsDto> findItems(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET,
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
	 * @return {@link List} {@link ItemsDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<ItemsDto> findItems(String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET, String COLUMN,
			boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(find(SORT_BY, SORT_ORDER, IN_SET, COLUMN, ONLY_ACTIVE));
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
	public List<ItemsDto> loadItems(Set<Integer> IDS) throws HibernateException {
		return entityToModel.map(load(IDS, CommonDBConstant.ID));
	}

	/**
	 * 
	 * @param ID
	 * @return {@link ItemsDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public ItemsDto loadItems(Integer ID) throws HibernateException {
		return entityToModel.map(load(ID));
	}

	@Override
	public CommonFileUploadResponse uploadImage(MultipartFile stream, Integer item_id) throws Exception {
		CommonFileUploadResponse response = imageService.uploadImage(ImageType.II, stream);
		Items items = load(item_id);
		items.setItemImage(response.getFileKey());
		merge(items);
		return response;
	}

	@Override
	public InputStream loadImage(String fileKey) throws Exception {
		return imageService.loadImage(fileKey);
	}

	@Override
	public List<ItemsDto> loadItemsByCat(Integer cat_id, boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(load(cat_id, CAT_REF, ONLY_ACTIVE));
	}

}
