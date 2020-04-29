package com.dcs.balaji.service;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.springframework.web.multipart.MultipartFile;

import com.dcs.access.model.UserDto;
import com.dcs.balaji.dao.ItemsDao;
import com.dcs.balaji.entity.Items;
import com.dcs.balaji.model.ItemsDto;
import com.dcs.common.file.response.CommonFileUploadResponse;
import com.dcs.datasource.enm.SortOrder;
import com.dcs.datasource.service.GenericService;

/**
 * 
 * @author deepakdubey
 * @since 20 January 2020
 * @version 1.0
 *
 */
public interface ItemsService extends GenericService<ItemsDao, Items> {

	int min = 11111;

	int max = 99999;

	String[] CAT_REF = { "category", "id" };

	/**
	 * 
	 * @param userDto
	 * @return {@link ItemsService}
	 */
	ItemsService setCurrentUser(UserDto userDto);

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer saveItems(ItemsDto DTO) throws HibernateException;

	/**
	 * 
	 * @param DTOS
	 * @return {@link Set}
	 * @throws HibernateException
	 */
	Set<Integer> saveItems(List<ItemsDto> DTOS) throws HibernateException;

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer updateItems(ItemsDto DTO) throws HibernateException;

	/**
	 * 
	 * @param DTOS
	 * @return {@link Long}
	 * @throws HibernateException
	 */
	Long updateItems(List<ItemsDto> DTOS) throws HibernateException;

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link ItemsDto}
	 * @throws HibernateException
	 */
	List<ItemsDto> deactivate(Set<Integer> IDS) throws HibernateException;

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
	List<ItemsDto> activate(Set<Integer> IDS) throws HibernateException;

	/**
	 * 
	 * @param TEXT
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link ItemsDto}
	 * @throws HibernateException
	 */
	List<ItemsDto> search(String TEXT, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param INSTANCE
	 * @return {@link List} {@link ItemsDto}
	 * @throws HibernateException
	 */
	List<ItemsDto> findItems(Items INSTANCE) throws HibernateException;

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
	List<ItemsDto> findItems(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
			throws HibernateException;

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link ItemsDto}
	 * @throws HibernateException
	 */
	List<ItemsDto> findItems(String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE) throws HibernateException;

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
	List<ItemsDto> findItems(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET,
			String COLUMN, boolean ONLY_ACTIVE) throws HibernateException;

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
	List<ItemsDto> findItems(String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET, String COLUMN,
			boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link ItemsDto}
	 * @throws HibernateException
	 */
	List<ItemsDto> loadItems(Set<Integer> IDS) throws HibernateException;

	/**
	 * 
	 * @param cat_id
	 * @return {@link List} {@link ItemsDto}
	 * @throws HibernateException
	 */
	List<ItemsDto> loadItemsByCat(Integer cat_id, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param ID
	 * @return {@link ItemsDto}
	 * @throws HibernateException
	 */
	ItemsDto loadItems(Integer ID) throws HibernateException;

	/**
	 * 
	 * @param stream
	 * @param item_id
	 * @return
	 * @throws Exception
	 */
	CommonFileUploadResponse uploadImage(MultipartFile stream, Integer item_id) throws Exception;

	/**
	 * 
	 * @param fileKey
	 * @return
	 * @throws Exception
	 */
	InputStream loadImage(String fileKey) throws Exception;
}
