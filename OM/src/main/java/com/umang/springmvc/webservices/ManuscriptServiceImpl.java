package com.umang.springmvc.webservices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.umang.springmvc.client.CustomerClient;
import com.umang.springmvc.client.ItemsClient;
import com.umang.springmvc.client.OrdersClient;
import com.umang.springmvc.client.SortOrder;
import com.umang.springmvc.common.CommonResponseDto;
import com.umang.springmvc.common.CommonResponseItemDto;
import com.umang.springmvc.common.CommonResponsesDto12;
import com.umang.springmvc.common.Constants;
import com.umang.springmvc.common.HttpCommunicationException;
import com.umang.springmvc.common.HttpGatewayRequestInfo;
import com.umang.springmvc.common.JsonTransformer;
import com.umang.springmvc.common.JsonTransformerException;
import com.umang.springmvc.entities.ManuscriptDetail;
import com.umang.springmvc.entities.ManuscriptHeadofPrint;
import com.umang.springmvc.model.CancelOrder;
import com.umang.springmvc.model.CustomerDto;
import com.umang.springmvc.model.CustomerResponse;
import com.umang.springmvc.model.CustomerResponses;
import com.umang.springmvc.model.DeleteResponse;
import com.umang.springmvc.model.ItemsDto;
import com.umang.springmvc.model.ItemsResponse;
import com.umang.springmvc.model.ItemsResponses;
import com.umang.springmvc.model.OrdersResponses;
import com.umang.springmvc.model.SalesOrderResponse;
import com.umang.springmvc.seller.entities.SallerProfileDto;
import com.umang.springmvc.services.HttpGateway;

@Service("manuscriptService")
public class ManuscriptServiceImpl implements ManuscriptService {
	private static final Logger log = LogManager.getLogger(ManuscriptServiceImpl.class);

	@Autowired
	private HttpGateway httpGatewayImpl;

	private String manauscriptAPIUrl="http://manuscriptservice.jaypeejournals.com/manuscript-service/rest/manuscript/manuscriptDetail/";


	private String manuscriptAPIToken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VybmFtZSI6InByb3RvbkBzdGFnaW5nIiwiUGFzc3dvcmQiOiJwcm90b25AMTgxIn0.J9N6LZKyu2CP_MHjt7CP0VUlVnOnKlG6_iYF0gTshR8";


	private String manuscriptTotalCountUrl="http://manuscriptservice.jaypeejournals.com/manuscript-service/rest/totalcount/";
	
	private String API="http://localhost:8119/swagger-ui.html" ;
	
	private String itemListAPIUrl="http://localhost:8119/sales/item/find-all-sorted/0/ASC";
	
	private String stockListAPIUrl="http://localhost:8119/sales/item/find-all-sorted/0/ASC";

	private String orderListAPIUrl="http://localhost:8119/sales/item/find-all-sorted/0/ASC";
	
	private String editOrderAPIUrl="http://localhost:8119/sales/item/find-all-sorted/0/ASC";
	
	private String editStockAPIUrl="http://localhost:8119/sales/item/find-all-sorted/0/ASC";
	
	private String deleteOrderAPIUrl="http://localhost:8119/sales/item/find-all-sorted/0/ASC";

	private String deleteStockAPIUrl="http://localhost:8119/sales/item/find-all-sorted/0/ASC";

	private String userListAPIUrl="http://localhost:8119/sales/item/find-all-sorted/0/ASC";
 
	private String editUserAPIUrl="http://localhost:8119/sales/item/find-all-sorted/0/ASC";
	
	private String deleteUserAPIUrl="http://localhost:8119/sales/item/find-all-sorted/0/ASC";

	ItemsClient client = new ItemsClient();
	OrdersClient  orderClient= new OrdersClient();
	CustomerClient customerClient= new CustomerClient();
	@Override
	public ManuscriptDetail getManuscriptDetail(String manuscriptNumber, String jCode) {
		log.info("In function getManuscriptDetail");
		ManuscriptDetail manuscriptDetail = null;
		try {
			//create request
			HttpGatewayRequestInfo requestInfo = new HttpGatewayRequestInfo();
			String manuscriptAPIUrl = manauscriptAPIUrl + jCode + "/" + manuscriptNumber;
			requestInfo.setRequestUri(manuscriptAPIUrl);
			requestInfo.setCharset(Constants.DEFAULT_CHARSET);
			requestInfo.setMethodType(Constants.GET);
			requestInfo.getHeaders().put("MPS-API-TOKEN", manuscriptAPIToken);
			requestInfo.getHeaders().put(HttpHeaders.CONTENT_TYPE, Constants.REQ_TYPE_JASON);

			//call web services and get the result string}
			String jsonResultString = httpGatewayImpl.callGETService(requestInfo);

			if (StringUtils.isNotBlank(jsonResultString) && jsonResultString.startsWith("[")) {
				jsonResultString = jsonResultString.substring(1, jsonResultString.length() - 1);
			}
			log.info("in getManuscriptDetail jsonResultString:" + jsonResultString);

			JsonTransformer jsonTransformer = new JsonTransformer();
			if (StringUtils.isNotEmpty(jsonResultString) && !"UnSuccessful".equals(jsonResultString)) {
				manuscriptDetail = jsonTransformer.fromJson(jsonResultString, ManuscriptDetail.class);
			}
		} catch (JSONException | HttpCommunicationException | JsonTransformerException je) {
			log.error("Exception caught in getManuscriptDetail() : " + je);
		}

		return manuscriptDetail;
	}

	

	@Override
	public List<ManuscriptHeadofPrint> getManuscriptDetailList(String jCode, int startIndex, int endIndex, String status) {
		log.info("In function getManuscriptDetail");
		List<ManuscriptHeadofPrint> manuscriptDetails = new ArrayList<ManuscriptHeadofPrint>();
		ManuscriptHeadofPrint mdhp = null;
		try {
			//create request
			HttpGatewayRequestInfo requestInfo = new HttpGatewayRequestInfo();
			String manuscriptAPIUrl = null;
			
			if(status!=null && status.contains(Constants.REF_IP_STATUS_PENDING)) {
				if(StringUtils.isNotBlank(status) && status.contains("false")) {
					manuscriptAPIUrl = manauscriptAPIUrl + "pending/"+ jCode + "/" + startIndex + "/" + endIndex;
				}
				else {
					manuscriptAPIUrl = manauscriptAPIUrl + "pending/" + jCode + "/" + startIndex + "/" + endIndex;
				}
			}
			else {
				manuscriptAPIUrl = getmanuscriptAPIUrl(requestInfo, jCode, startIndex, endIndex, status);
			}
			
			requestInfo.setRequestUri(manuscriptAPIUrl);
			requestInfo.setCharset(Constants.DEFAULT_CHARSET);
			requestInfo.setMethodType(Constants.GET);
			requestInfo.getHeaders().put(HttpHeaders.CONTENT_TYPE, Constants.REQ_TYPE_JASON);
			String jsonResultString = httpGatewayImpl.callGETService(requestInfo);
			if(StringUtils.isNotBlank(jsonResultString) && jsonResultString.equals("220")) {
				return manuscriptDetails;
			}
			log.info("in getManuscriptDetail jsonResultString:" + jsonResultString);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
			if (StringUtils.isNotEmpty(jsonResultString) && !"UnSuccessful".equals(jsonResultString)) {
				try {
					TypeReference<List<ManuscriptHeadofPrint>> mapType = new TypeReference<List<ManuscriptHeadofPrint>>() {
					};

					manuscriptDetails = objectMapper.readValue(jsonResultString, mapType);
				} catch (Exception e) {
					log.error("Exception caught in getManuscriptDetail() and Convert to Array Liat manuscriptDetailList : " + e.getMessage());
				}
			}

		} catch (JSONException | HttpCommunicationException je) {
			log.error("Exception caught in getManuscriptDetail() : " + je);
		}
		if (CollectionUtils.isEmpty(manuscriptDetails)) {
			log.error("getManuscriptDetail() Is empty : ");
			return null;
		}

		return manuscriptDetails;

	}


	public int getManuscriptDetailCount(String jCode, int startIndex, int endIndex, String status) {
		log.info("In function getManuscriptDetailCount");
		int totalCount = 0;
		try {
			//create request
			HttpGatewayRequestInfo requestInfo = new HttpGatewayRequestInfo();
			//SCHOLARSTOR-1114
			String manuscriptCountAPIUrl = null;
			if(status!=null && status.contains(Constants.REF_IP_STATUS_PENDING)) {
				if(StringUtils.isNotBlank(status) && status.contains("false")) {
					manuscriptCountAPIUrl = manauscriptAPIUrl + "pending/"+ jCode;
				}
				else {
					manuscriptCountAPIUrl = manauscriptAPIUrl + "onlineFirst/pending/" + jCode;
				}
			}
			else {
				
					manuscriptCountAPIUrl = getmanuscriptCountAPIUrl(requestInfo, jCode, status);
			}
		
			requestInfo.setRequestUri(manuscriptCountAPIUrl);
			requestInfo.setCharset(Constants.DEFAULT_CHARSET);
			requestInfo.setMethodType(Constants.GET);
			requestInfo.getHeaders().put(HttpHeaders.CONTENT_TYPE, Constants.REQ_TYPE_JASON);

			String jsonResultString = httpGatewayImpl.callGETService(requestInfo);
			log.info("in getManuscriptDetail jsonResultString:" + jsonResultString);
			JSONObject ob = new JSONObject(jsonResultString);
			totalCount = ob.getInt("totalCount");

		} catch (JSONException | HttpCommunicationException je) {
			log.error("Exception caught in getManuscriptDetail() : " + je);
		}
		return totalCount;
	}
	
	private String getmanuscriptAPIUrl(HttpGatewayRequestInfo requestInfo, String jCode, int startIndex, int endIndex, String status) throws HttpCommunicationException {
		String manuscriptAPIUrl = null;
		int totalCount = 0;
		manuscriptAPIUrl = manauscriptAPIUrl + jCode ;
		
		requestInfo.setRequestUri(manuscriptAPIUrl);
		requestInfo.setCharset(Constants.DEFAULT_CHARSET);
		requestInfo.setMethodType(Constants.GET);
		requestInfo.getHeaders().put(HttpHeaders.CONTENT_TYPE, Constants.REQ_TYPE_JASON);
		String jsonResultString = httpGatewayImpl.callGETService(requestInfo);
		
		log.info("Journal article counts excluding pending articles :" + jsonResultString);
		JSONObject ob = new JSONObject(jsonResultString);
		totalCount = ob.getInt("totalCount");
		
		if(totalCount > 0) {
			if(StringUtils.isNotBlank(status) && status.equals("false")) {
				manuscriptAPIUrl = manauscriptAPIUrl + jCode + "/" + startIndex + "/" + endIndex;
			}
			else {
				manuscriptAPIUrl = manauscriptAPIUrl + "onlineFirst/" + jCode + "/" + startIndex + "/" + endIndex;
			}
		}else {
			if(StringUtils.isNotBlank(status) && status.equals("false")) {
				manuscriptAPIUrl = manauscriptAPIUrl + "pending/"+ jCode + "/" + startIndex + "/" + endIndex;
			}
			else {
				manuscriptAPIUrl = manauscriptAPIUrl + "onlineFirst/pending/" + jCode + "/" + startIndex + "/" + endIndex;
			}
		}
		
		return manuscriptAPIUrl;
	}
	
	private String getmanuscriptCountAPIUrl(HttpGatewayRequestInfo requestInfo, String jCode, String status) throws HttpCommunicationException {
		String manuscriptAPIUrl = null;
		int totalCount = 0;
		manuscriptAPIUrl = manauscriptAPIUrl + jCode ;
		
		requestInfo.setRequestUri(manuscriptAPIUrl);
		requestInfo.setCharset(Constants.DEFAULT_CHARSET);
		requestInfo.setMethodType(Constants.GET);
		requestInfo.getHeaders().put(HttpHeaders.CONTENT_TYPE, Constants.REQ_TYPE_JASON);
		String jsonResultString = httpGatewayImpl.callGETService(requestInfo);
		
		log.info("Journal article counts excluding pending articles :" + jsonResultString);
		JSONObject ob = new JSONObject(jsonResultString);
		totalCount = ob.getInt("totalCount");
		
		if(totalCount > 0) {
			if(StringUtils.isNotBlank(status) && status.equals("false")) {
				manuscriptAPIUrl = manauscriptAPIUrl + jCode;
			}
			else {
				manuscriptAPIUrl = manauscriptAPIUrl + "onlineFirst/" + jCode;
			}
		}else {
			if(StringUtils.isNotBlank(status) && status.equals("false")) {
				manuscriptAPIUrl = manauscriptAPIUrl + "pending/"+ jCode;
			}
			else {
				manuscriptAPIUrl = manauscriptAPIUrl + "onlineFirst/pending/" + jCode;
			}
		}
		
		return manuscriptAPIUrl;
	}

	@Override
	public int getyetToBeAssignedCount(String jCode, int startCount, int paginationListCount, String status) {
		log.info("In function getManuscriptDetailCount");
		int totalCount = 0;
		try {
			//create request
			HttpGatewayRequestInfo requestInfo = new HttpGatewayRequestInfo();
			//SCHOLARSTOR-1114
			String manuscriptCountAPIUrl = null;
				if(StringUtils.isNotBlank(status) && status.contains("false")) {
					manuscriptCountAPIUrl = manauscriptAPIUrl + jCode;
				}
				else {
					manuscriptCountAPIUrl = manauscriptAPIUrl + "onlineFirst/" + jCode;
				}
		
			requestInfo.setRequestUri(manuscriptCountAPIUrl);
			requestInfo.setCharset(Constants.DEFAULT_CHARSET);
			requestInfo.setMethodType(Constants.GET);
			requestInfo.getHeaders().put(HttpHeaders.CONTENT_TYPE, Constants.REQ_TYPE_JASON);

			String jsonResultString = httpGatewayImpl.callGETService(requestInfo);
			log.info("in getManuscriptDetail jsonResultString:" + jsonResultString);
			JSONObject ob = new JSONObject(jsonResultString);
			totalCount = ob.getInt("totalCount");

		} catch (JSONException | HttpCommunicationException je) {
			log.error("Exception caught in getManuscriptDetail() : " + je);
		}
		return totalCount;
	}



	@Override
	public ManuscriptDetail getManuscriptTotalCountDetail(String jCode) {
		log.info("In function getManuscriptTotalCountDetail");
		ManuscriptDetail manuscriptDetail = null;
		try {
			//create request
			HttpGatewayRequestInfo requestInfo = new HttpGatewayRequestInfo();
			String manuscriptAPIUrl = manuscriptTotalCountUrl + (StringUtils.isNotEmpty(jCode) ? "journalCode/" + jCode : "manuscript");
			requestInfo.setRequestUri(manuscriptAPIUrl);
			requestInfo.setCharset(Constants.DEFAULT_CHARSET);
			requestInfo.setMethodType(Constants.GET);
			requestInfo.getHeaders().put("MPS-API-TOKEN", manuscriptAPIToken);
			requestInfo.getHeaders().put(HttpHeaders.CONTENT_TYPE, Constants.REQ_TYPE_JASON);

			//call web services and get the result string}
			String jsonResultString = httpGatewayImpl.callGETService(requestInfo);

			if (StringUtils.isNotBlank(jsonResultString) && jsonResultString.startsWith("[")) {
				jsonResultString = jsonResultString.substring(1, jsonResultString.length() - 1);
			}
			log.info("in getManuscriptTotalCountDetail jsonResultString:" + jsonResultString);

			JsonTransformer jsonTransformer = new JsonTransformer();
			if (StringUtils.isNotEmpty(jsonResultString) && !"UnSuccessful".equalsIgnoreCase(jsonResultString)) {
				manuscriptDetail = jsonTransformer.fromJson(jsonResultString, ManuscriptDetail.class);
			}
		} catch (JSONException | HttpCommunicationException | JsonTransformerException je) {
			log.error("Exception caught in getManuscriptTotalCountDetail() : " + je);
		}

		return manuscriptDetail;
	}
	
	private String getSellerProfileAPIUrl(HttpGatewayRequestInfo requestInfo, String requestUrl, int startIndex, int endIndex, String status,SallerProfileDto dto) throws HttpCommunicationException {
		String urlAPI = null;
		int totalCount = 0;
		try {
		ObjectMapper mapper = new ObjectMapper();
	      //Converting the Object to JSONString
	    String jsonString = mapper.writeValueAsString(dto);
	    System.out.println("jsonString-->"+jsonString);
		urlAPI = API + requestUrl ;
		
		requestInfo.setRequestUri(urlAPI);
		requestInfo.setCharset(Constants.DEFAULT_CHARSET);
		requestInfo.setMethodType(Constants.GET);
		requestInfo.getHeaders().put(HttpHeaders.CONTENT_TYPE, Constants.REQ_TYPE_JASON);
		requestInfo.setRequestBody(jsonString);
		String jsonResultString = httpGatewayImpl.callGETService(requestInfo);
		
		log.info("Journal article counts excluding pending articles :" + jsonResultString);
		JSONObject ob = new JSONObject(jsonResultString);
		}catch (Exception e) {
			e.printStackTrace();
		}

		return urlAPI;
	}
	
	@Override
	public ItemsResponses getItemDetailList(String itemName,SortOrder sortingOrder) {
		log.info("In function getManuscriptDetail");
		ItemsResponses itemDetails= null;
		try {
			itemDetails = client.findAllSorted(itemName, sortingOrder);
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return itemDetails;

	}
	@Override
	public ItemsResponse getSaveItem(ItemsDto itemBody) {
		log.info("In function getManuscriptDetail");
		ItemsResponse itemDetails= null;
		try {
			itemDetails = client.save(itemBody);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return itemDetails;

	}
	@Override
	public List<CommonResponseItemDto> getStockDetailList(String jCode, int startIndex, int endIndex, String status) {
		log.info("In function getManuscriptDetail");
		List<CommonResponseItemDto> itemDetails = new ArrayList<CommonResponseItemDto>();
		CommonResponseDto mdhp = null;
		try {
			//create request
			HttpGatewayRequestInfo requestInfo = new HttpGatewayRequestInfo();
			String stockAPIUrl = null;
			
			stockAPIUrl=stockListAPIUrl;
			requestInfo.setRequestUri(stockAPIUrl);
			requestInfo.setCharset(Constants.DEFAULT_CHARSET);
			requestInfo.setMethodType(Constants.GET);
			requestInfo.getHeaders().put(HttpHeaders.CONTENT_TYPE, Constants.REQ_TYPE_JASON);
			requestInfo.getHeaders().put("AUTH-TOKEN", "Maheshwar");
			String jsonResultString = httpGatewayImpl.callGETService(requestInfo);
			if(StringUtils.isNotBlank(jsonResultString) && jsonResultString.equals("220")) {
				return itemDetails;
			}
			log.info("in getManuscriptDetail jsonResultString:" + jsonResultString);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
			if (StringUtils.isNotEmpty(jsonResultString) && !"UnSuccessful".equals(jsonResultString)) {
				try {
					//Collection<CommonResponsesDto12> readValues = new ObjectMapper().readValue(jsonResultString, new TypeReference<Collection<CommonResponsesDto12>>() { });
					TypeReference<List<CommonResponseDto>> mapType = new TypeReference<List<CommonResponseDto>>() {
					};
					//CommonResponseItemDto commonResponseDto = objectMapper.readValue(jsonResultString.getBytes(), CommonResponseItemDto.class);
					itemDetails = objectMapper.readValue(jsonResultString.getBytes(), mapType);
				} catch (Exception e) {
					log.error("Exception caught in getManuscriptDetail() and Convert to Array Liat manuscriptDetailList : " + e.getMessage());
				}
			}

		} catch (JSONException | HttpCommunicationException je) {
			log.error("Exception caught in getManuscriptDetail() : " + je);
		}
		if (CollectionUtils.isEmpty(itemDetails)) {
			log.error("getManuscriptDetail() Is empty : ");
			return null;
		}

		return itemDetails;

	}
	
	@Override
	public List<CommonResponseItemDto> getOrderDetailList(String jCode, int startIndex, int endIndex, String status) {
		log.info("In function getManuscriptDetail");
		List<CommonResponseItemDto> itemDetails = new ArrayList<CommonResponseItemDto>();
		CommonResponseDto mdhp = null;
		try {
			//create request
			HttpGatewayRequestInfo requestInfo = new HttpGatewayRequestInfo();
			String orderAPIUrl = null;
			
			orderAPIUrl=orderListAPIUrl;
			requestInfo.setRequestUri(orderAPIUrl);
			requestInfo.setCharset(Constants.DEFAULT_CHARSET);
			requestInfo.setMethodType(Constants.GET);
			requestInfo.getHeaders().put(HttpHeaders.CONTENT_TYPE, Constants.REQ_TYPE_JASON);
			requestInfo.getHeaders().put("AUTH-TOKEN", "Maheshwar");
			String jsonResultString = httpGatewayImpl.callGETService(requestInfo);
			if(StringUtils.isNotBlank(jsonResultString) && jsonResultString.equals("220")) {
				return itemDetails;
			}
			log.info("in getManuscriptDetail jsonResultString:" + jsonResultString);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
			if (StringUtils.isNotEmpty(jsonResultString) && !"UnSuccessful".equals(jsonResultString)) {
				try {
					//Collection<CommonResponsesDto12> readValues = new ObjectMapper().readValue(jsonResultString, new TypeReference<Collection<CommonResponsesDto12>>() { });
					TypeReference<List<CommonResponseDto>> mapType = new TypeReference<List<CommonResponseDto>>() {
					};
					//CommonResponseItemDto commonResponseDto = objectMapper.readValue(jsonResultString.getBytes(), CommonResponseItemDto.class);
					itemDetails = objectMapper.readValue(jsonResultString.getBytes(), mapType);
				} catch (Exception e) {
					log.error("Exception caught in getManuscriptDetail() and Convert to Array Liat manuscriptDetailList : " + e.getMessage());
				}
			}

		} catch (JSONException | HttpCommunicationException je) {
			log.error("Exception caught in getManuscriptDetail() : " + je);
		}
		if (CollectionUtils.isEmpty(itemDetails)) {
			log.error("getManuscriptDetail() Is empty : ");
			return null;
		}

		return itemDetails;

	}
	
	@Override
	public DeleteResponse deleteItem(int itemId) {
		DeleteResponse response = null;
		try {
		 response= client.delete(itemId);
		}catch (Exception e) {
			response.setStatusCode("Fail");
		}
		
		return response;
		
	}
	@Override
	public DeleteResponse deleteCust(int custId) {
		DeleteResponse response = null;
		try {
		 response= customerClient.delete(custId);
		}catch (Exception e) {
			response.setStatusCode("Fail");
		}
		
		return response;
		
	}
	@Override
	public OrdersResponses findAllSorted(String itemName,SortOrder sortingOrder) {
		log.info("In function getManuscriptDetail");
/*		List<CommonResponseItemDto> itemDetails = new ArrayList<CommonResponseItemDto>();*/
		CommonResponseDto mdhp = null;
		OrdersResponses orderResponse= null;
		try {
			orderResponse = orderClient.findAllSorted(itemName, sortingOrder);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderResponse;
	}
	
	@Override
	public DeleteResponse deleteOrder(int orderId) {
		DeleteResponse response = null;
		try {
		 response= orderClient.delete(orderId);
		}catch (Exception e) {
			response.setStatusCode("Fail");
		}
		
		return response;
		
	}
	@Override
	public SalesOrderResponse cancelOrder(CancelOrder orderNo) {
		SalesOrderResponse response = null;
		try {
		 response= orderClient.cancelOrder(orderNo);
		}catch (Exception e) {
			response.setStatusCode("Fail");
		}
		
		return response;
		
	}
	
	@Override
	public CustomerResponse getSaveCustomer(CustomerDto customerBody) {
		log.info("In function getManuscriptDetail");
		CustomerResponse customerDetails= null;
		try {
			customerDetails = customerClient.save(customerBody);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return customerDetails;

	}
	@Override
	public CustomerResponses getCustomerDetails(String sort_by, SortOrder sortOrder) {
		log.info("In function getManuscriptDetail");
		CustomerResponses customerDetails= null;
		try {
			customerDetails = customerClient.findAllSortedByValue(sort_by,sortOrder);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return customerDetails;

	}
	
	@Override
	public ItemsResponse getItemByItemId(String itemId,SortOrder sortingOrder) {
		log.info("In function getManuscriptDetail");
		ItemsResponse itemDetails= null;
		try {
			itemDetails = client.findById(Integer.parseInt(itemId));
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return itemDetails;

	}
}
