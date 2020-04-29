package com.dcs.balaji.service;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.springframework.web.multipart.MultipartFile;

import com.dcs.access.model.UserDto;
import com.dcs.balaji.dao.CustomerDao;
import com.dcs.balaji.entity.Customer;
import com.dcs.balaji.model.ConsigneeDto;
import com.dcs.balaji.model.CustomerDto;
import com.dcs.balaji.model.OtpDto;
import com.dcs.balaji.model.VerifyOtpDto;
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
public interface CustomerService extends GenericService<CustomerDao, Customer> {

	int min = 111111;

	int max = 999999;

	/**
	 * 
	 * @param userDto
	 * @return {@link CustomerService}
	 */
	CustomerService setCurrentUser(UserDto userDto);

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer saveCustomer(CustomerDto DTO) throws HibernateException;

	/**
	 * 
	 * @param DTOS
	 * @return {@link Set}
	 * @throws HibernateException
	 */
	Set<Integer> saveCustomer(List<CustomerDto> DTOS) throws HibernateException;

	/**
	 * 
	 * @param DTO
	 * @return {@link Integer}
	 * @throws HibernateException
	 */
	Integer updateCustomer(CustomerDto DTO) throws HibernateException;

	/**
	 * 
	 * @param DTOS
	 * @return {@link Long}
	 * @throws HibernateException
	 */
	Long updateCustomer(List<CustomerDto> DTOS) throws HibernateException;

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	List<CustomerDto> deactivate(Set<Integer> IDS) throws HibernateException;

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
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	List<CustomerDto> activate(Set<Integer> IDS) throws HibernateException;

	/**
	 * 
	 * @param TEXT
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	List<CustomerDto> search(String TEXT, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param INSTANCE
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	List<CustomerDto> findCustomer(Customer INSTANCE) throws HibernateException;

	/**
	 * 
	 * @param PAGE
	 * @param SIZE
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	List<CustomerDto> findCustomer(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
			throws HibernateException;

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	List<CustomerDto> findCustomer(String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param PAGE
	 * @param SIZE
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param IN_SET
	 * @param COLUMN
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	List<CustomerDto> findCustomer(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET,
			String COLUMN, boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param IN_SET
	 * @param COLUMN
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	List<CustomerDto> findCustomer(String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET, String COLUMN,
			boolean ONLY_ACTIVE) throws HibernateException;

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	List<CustomerDto> loadCustomer(Set<Integer> IDS) throws HibernateException;

	/**
	 * 
	 * @param ID
	 * @return {@link CustomerDto}
	 * @throws HibernateException
	 */
	CustomerDto loadCustomer(Integer ID) throws HibernateException;

	/**
	 * 
	 * @param imageType
	 * @param stream
	 * @return
	 * @throws Exception
	 */
	CommonFileUploadResponse uploadShopImage(MultipartFile stream, Integer customer_id) throws Exception;

	/**
	 * 
	 * @param imageType
	 * @param stream
	 * @return
	 * @throws Exception
	 */
	CommonFileUploadResponse uploadPersonImage(MultipartFile stream, Integer customer_id) throws Exception;

	/**
	 * 
	 * @param fileKey
	 * @return
	 * @throws Exception
	 */
	InputStream loadImage(String fileKey) throws Exception;

	/**
	 * 
	 * @param mob
	 * @return
	 * @throws RuntimeException
	 */
	OtpDto getOtp(String mob) throws RuntimeException;

	VerifyOtpDto verifyOtp(Integer OTP, String MOB) throws RuntimeException;

	/**
	 * 
	 * @param dto
	 * @return
	 * @throws RuntimeException
	 */
	ConsigneeDto saveConsignee(ConsigneeDto dto) throws RuntimeException;

	/**
	 * 
	 * @param dto
	 * @return
	 * @throws RuntimeException
	 */
	ConsigneeDto updateConsignee(ConsigneeDto dto) throws RuntimeException;

	/**
	 * 
	 * @param MOB
	 * @return
	 * @throws RuntimeException
	 */
	ConsigneeDto getConsignee(String MOB) throws RuntimeException;

	/**
	 * 
	 * @param MOB
	 * @return
	 * @throws RuntimeException
	 */
	CustomerDto getCustomer(String MOB) throws RuntimeException;

	/**
	 * 
	 * @param imageType
	 * @param stream
	 * @return
	 * @throws Exception
	 */
	CommonFileUploadResponse uploadConsigneeImage(MultipartFile stream, Integer consignee_id) throws Exception;

}
