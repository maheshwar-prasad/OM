package com.dcs.balaji.service.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.dcs.access.model.UserDto;
import com.dcs.balaji.dao.ConsigneeDao;
import com.dcs.balaji.dao.CustomerDao;
import com.dcs.balaji.dao.CustomerSettingDao;
import com.dcs.balaji.dao.OtpListDao;
import com.dcs.balaji.enm.ImageType;
import com.dcs.balaji.entity.Consignee;
import com.dcs.balaji.entity.Customer;
import com.dcs.balaji.entity.CustomerSetting;
import com.dcs.balaji.entity.OtpList;
import com.dcs.balaji.model.ConsigneeDto;
import com.dcs.balaji.model.CustomerDto;
import com.dcs.balaji.model.OtpDto;
import com.dcs.balaji.model.VerifyOtpDto;
import com.dcs.balaji.service.CustomerService;
import com.dcs.balaji.service.ImageService;
import com.dcs.common.constant.CommonConstant;
import com.dcs.common.file.response.CommonFileUploadResponse;
import com.dcs.common.util.CommonUtils;
import com.dcs.common.util.CustomMapper;
import com.dcs.datasource.constant.CommonDBConstant;
import com.dcs.datasource.enm.SortOrder;
import com.dcs.datasource.model.Condition;
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
@Service("CustomerService")
@Transactional
public class CustomerServiceImpl extends AbstractGenericServiceImpl<CustomerDao, Customer> implements CustomerService {

	@Autowired
	private CustomerDao dao;

	@Autowired
	private CustomerSettingDao custSettingDao;

	@Autowired
	private ConsigneeDao consigneeDao;

	@Autowired
	@Qualifier("entity-to-model")
	private CustomMapper<Customer, CustomerDto> entityToModel;

	@Autowired
	@Qualifier("model-to-entity")
	private CustomMapper<CustomerDto, Customer> modelToEntity;

	@Autowired
	private ImageService imageService;

	@Autowired
	private OtpListDao otpDao;

	@Override
	protected CustomerDao getDAO() {
		return this.dao;
	}

	@Override
	protected void setDAO(CustomerDao dao) {
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
	public Integer saveCustomer(CustomerDto DTO) throws HibernateException {
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
	public Set<Integer> saveCustomer(List<CustomerDto> DTOS) throws HibernateException {
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
	public Integer updateCustomer(CustomerDto DTO) throws HibernateException {
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
	public Long updateCustomer(List<CustomerDto> DTOS) throws HibernateException {
		return batchUpdate(modelToEntity.map(DTOS), 10);
	}

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<CustomerDto> deactivate(Set<Integer> IDS) throws HibernateException {
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
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<CustomerDto> activate(Set<Integer> IDS) throws HibernateException {
		active(IDS, null);
		return entityToModel.map(load(IDS, CommonDBConstant.ID));
	}

	/**
	 * 
	 * @param TEXT
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<CustomerDto> search(String TEXT, boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(comGenSearchService.getSearchedList(Customer.class, TEXT, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param INSTANCE
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<CustomerDto> findCustomer(Customer INSTANCE) throws HibernateException {
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
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<CustomerDto> findCustomer(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
			throws HibernateException {
		return entityToModel.map(find(PAGE, SIZE, SORT_BY, SORT_ORDER, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param ONLY_ACTIVE
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<CustomerDto> findCustomer(String SORT_BY, SortOrder SORT_ORDER, boolean ONLY_ACTIVE)
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
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<CustomerDto> findCustomer(int PAGE, int SIZE, String SORT_BY, SortOrder SORT_ORDER,
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
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<CustomerDto> findCustomer(String SORT_BY, SortOrder SORT_ORDER, Set<CharSequence> IN_SET, String COLUMN,
			boolean ONLY_ACTIVE) throws HibernateException {
		return entityToModel.map(find(SORT_BY, SORT_ORDER, IN_SET, COLUMN, ONLY_ACTIVE));
	}

	/**
	 * 
	 * @param IDS
	 * @return {@link List} {@link CustomerDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public List<CustomerDto> loadCustomer(Set<Integer> IDS) throws HibernateException {
		return entityToModel.map(load(IDS, CommonDBConstant.ID));
	}

	/**
	 * 
	 * @param ID
	 * @return {@link CustomerDto}
	 * @throws HibernateException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@Override
	public CustomerDto loadCustomer(Integer ID) throws HibernateException {
		return entityToModel.map(load(ID));
	}

	@Override
	public CustomerService setCurrentUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonFileUploadResponse uploadShopImage(MultipartFile stream, Integer customer_id) throws Exception {
		CommonFileUploadResponse response = imageService.uploadImage(ImageType.SI, stream);
		Customer cust = load(customer_id);
		cust.setShopImage(response.getFileKey());
		merge(cust);
		return response;
	}

	@Override
	public CommonFileUploadResponse uploadPersonImage(MultipartFile stream, Integer customer_id) throws Exception {
		CommonFileUploadResponse response = imageService.uploadImage(ImageType.CI, stream);
		Customer cust = load(customer_id);
		cust.setPersonImage(response.getFileKey());
		merge(cust);
		return response;
	}

	@Override
	public InputStream loadImage(String fileKey) throws Exception {
		return imageService.loadImage(fileKey);
	}

	@Override
	public OtpDto getOtp(String mob) throws RuntimeException {
		if (!CommonUtils.match(mob, CommonConstant.RegexPatternConstant.MOBILE_PATTERN))
			throw new RuntimeException("Invalid Mobile Number!");
		int otp = CommonUtils.getRandom(min, max);
		OtpList list = new OtpList();
		list.setExpiried(false);
		list.setMob(mob);
		list.setUpdatedOn(new Date());
		list.setOtp(otp);
		otpDao.save(list);
		OtpDto dto = new OtpDto();
		dto.setOtp(otp);
		return dto;
	}

	@Override
	public VerifyOtpDto verifyOtp(final Integer OTP, final String MOB) throws RuntimeException {
		OtpList list = otpDao.load(null, null, new Condition("otp", OTP, false));
		List<CustomerSetting> customerSettings = custSettingDao.find(true);
		VerifyOtpDto dto = new VerifyOtpDto();
		if (list == null)
			throw new RuntimeException("Invalid Otp!");
		if (list.isExpiried()) {
			otpDao.delete(list);
			throw new RuntimeException("Otp has expired!");
		}
		if (!list.getMob().equals(MOB))
			throw new RuntimeException("Invalid Otp!");
		if (CommonUtils.getMinutesDifference(list.getUpdatedOn(), new Date()) > 10) {
			list.setExpiried(true);
			otpDao.merge(list);
			throw new RuntimeException("Otp has expired!");
		}
		dto.setResult(true);
		if (customerSettings.size() > 0)
			dto.setRegRequired(customerSettings.get(0).isRegRequired());

		ConsigneeDto consigneeDto = getConsignee(MOB);
		CustomerDto customerDto = getCustomer(MOB);
		if (dto.isRegRequired())
			dto.setAlreadyRegistered(customerDto != null);
		else
			dto.setAlreadyRegistered(consigneeDto != null);

		return dto;

	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public ConsigneeDto saveConsignee(ConsigneeDto dto) throws RuntimeException {
		return consigneeDao.load(consigneeDao.save(dto.entity())).model();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public ConsigneeDto updateConsignee(ConsigneeDto dto) throws RuntimeException {
		return consigneeDao.update(dto.entity()).model();
	}

	@Override
	public ConsigneeDto getConsignee(String MOB) throws RuntimeException {
		List<Consignee> consignees = consigneeDao.load("mob", MOB);
		return consignees.size() > 0 ? consignees.get(0).model() : null;
	}

	@Override
	public CommonFileUploadResponse uploadConsigneeImage(MultipartFile stream, Integer consignee_id) throws Exception {
		CommonFileUploadResponse response = imageService.uploadImage(ImageType.CSI, stream);
		Consignee cons = consigneeDao.load(consignee_id);
		cons.setConsigneeImage(response.getFileKey());
		consigneeDao.merge(cons);
		return response;
	}

	@Override
	public CustomerDto getCustomer(String MOB) throws RuntimeException {
		List<Customer> customer = load("mob", MOB);
		return customer.size() > 0 ? customer.get(0).model() : null;
	}

}
