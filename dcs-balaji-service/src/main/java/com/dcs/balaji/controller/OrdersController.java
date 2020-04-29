package com.dcs.balaji.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.balaji.constant.DCSBalajiConstant;
import com.dcs.balaji.enm.CancelledBy;
import com.dcs.balaji.enm.OrderStatus;
import com.dcs.balaji.model.CancelOrder;
import com.dcs.balaji.model.OrdersDto;
import com.dcs.balaji.model.PurchaseOrder;
import com.dcs.balaji.model.SalesOrderDto;
import com.dcs.balaji.service.OrdersService;
import com.dcs.common.annotation.EnableSwagger;
import com.dcs.common.constant.APIConstant;
import com.dcs.common.constant.HeaderConstant;
import com.dcs.common.model.CommonResponseDto;
import com.dcs.common.model.CommonResponsesDto;
import com.dcs.datasource.enm.SortOrder;
import com.dcs.logging.annotation.LogAfter;
import com.dcs.logging.annotation.LogBefore;
import com.dcs.logging.annotation.LogExceptionaly;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping(value = DCSBalajiConstant.Symbol.SLASH + DCSBalajiConstant.APIConstant.PATH_PATTERN
		+ DCSBalajiConstant.Symbol.SLASH + DCSBalajiConstant.RequestPath.ORDER)
@Api(value = "Orders Master Controller")
@EnableSwagger
public class OrdersController {

	@Autowired
	private OrdersService service;

	/**
	 * 
	 * @param dto
	 * @param request
	 * @return {@link CommonResponseDto<T>}
	 * @throws RuntimeException
	 */

	@LogBefore
	@LogAfter
	@LogExceptionaly
	@PostMapping(value = APIConstant.APIPath.SAVE, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public CommonResponseDto<OrdersDto> save(@Valid @RequestBody OrdersDto dto, HttpServletRequest request)
			throws RuntimeException {
		CommonResponseDto<OrdersDto> response = new CommonResponseDto<>();
		response.setData(service.loadOrders(service.saveOrders(dto)));
		return response;
	}

	/**
	 * 
	 * @param dto
	 * @param request
	 * @return {@link CommonResponsesDto<T>}
	 * @throws RuntimeException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@PostMapping(value = APIConstant.APIPath.SAVE_ALL, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public CommonResponsesDto<OrdersDto> saveAll(@Valid @RequestBody List<OrdersDto> dto, HttpServletRequest request)
			throws RuntimeException {
		CommonResponsesDto<OrdersDto> response = new CommonResponsesDto<>();
		response.setData(service.loadOrders(service.saveOrders(dto)));
		return response;
	}

	/**
	 * 
	 * @param dto
	 * @param request
	 * @return {@link CommonResponseDto<T>}
	 * @throws RuntimeException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@PutMapping(value = APIConstant.APIPath.UPDATE, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public CommonResponseDto<OrdersDto> update(@Valid @RequestBody OrdersDto dto, HttpServletRequest request)
			throws RuntimeException {
		CommonResponseDto<OrdersDto> response = new CommonResponseDto<>();
		response.setData(service.loadOrders(service.updateOrders(dto)));
		return response;
	}

	/**
	 * 
	 * @param dto
	 * @param request
	 * @return
	 * @throws RuntimeException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@PutMapping(value = APIConstant.APIPath.UPDATE_ALL, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public CommonResponsesDto<OrdersDto> updateAll(@Valid @RequestBody List<OrdersDto> dto, HttpServletRequest request)
			throws RuntimeException {
		CommonResponsesDto<OrdersDto> response = new CommonResponsesDto<>();
		service.updateOrders(dto);
		response.setData(dto);
		return response;
	}

	/**
	 * 
	 * @param ID
	 * @param request
	 * @return
	 * @throws RuntimeException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@DeleteMapping(value = APIConstant.APIPath.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CommonResponseDto<Integer> delete(@PathVariable(APIConstant.PathVariable.ID) Integer ID,
			HttpServletRequest request) throws RuntimeException {
		CommonResponseDto<Integer> response = new CommonResponseDto<>();
		response.setData(service.delete(new HashSet<>(Arrays.asList(ID))));
		return response;
	}

	/**
	 * 
	 * @param IDS
	 * @param request
	 * @return
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@DeleteMapping(value = APIConstant.APIPath.DELETE_MULTIPLE, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CommonResponseDto<Integer> deleteAll(@PathVariable(APIConstant.PathVariable.IDS) Set<Integer> IDS,
			HttpServletRequest request) {
		CommonResponseDto<Integer> response = new CommonResponseDto<>();
		response.setData(service.delete(IDS));
		return response;
	}

	/**
	 * 
	 * @param ONLY_ACTIVE
	 * @param TEXT
	 * @param request
	 * @return
	 * @throws RuntimeException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@GetMapping(value = APIConstant.APIPath.SEARCH, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CommonResponsesDto<OrdersDto> search(
			@RequestHeader(value = HeaderConstant.ONLY_ACTIVE, required = false, defaultValue = "false") boolean ONLY_ACTIVE,
			@PathVariable(APIConstant.PathVariable.TEXT) String TEXT, HttpServletRequest request)
			throws RuntimeException {
		CommonResponsesDto<OrdersDto> response = new CommonResponsesDto<>();
		response.setData(service.search(TEXT, ONLY_ACTIVE));
		return response;
	}

	/**
	 * 
	 * @param ONLY_ACTIVE
	 * @param ID
	 * @param request
	 * @return
	 * @throws RuntimeException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@GetMapping(value = APIConstant.APIPath.FIND, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CommonResponseDto<OrdersDto> find(
			@RequestHeader(value = HeaderConstant.ONLY_ACTIVE, required = false, defaultValue = "false") boolean ONLY_ACTIVE,
			@PathVariable(APIConstant.PathVariable.ID) Integer ID, HttpServletRequest request) throws RuntimeException {
		CommonResponseDto<OrdersDto> response = new CommonResponseDto<>();
		response.setData(service.loadOrders(ID));
		return response;
	}

	/**
	 * 
	 * @param ONLY_ACTIVE
	 * @param PAGE
	 * @param SIZE
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param request
	 * @return
	 * @throws RuntimeException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@GetMapping(value = APIConstant.APIPath.FIND_ALL_WITH_PAGE, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CommonResponsesDto<OrdersDto> find(
			@RequestHeader(value = HeaderConstant.ONLY_ACTIVE, required = false, defaultValue = "false") boolean ONLY_ACTIVE,
			@PathVariable(value = APIConstant.PathVariable.PAGE, required = false) Integer PAGE,
			@PathVariable(value = APIConstant.PathVariable.SIZE, required = false) Integer SIZE,
			@PathVariable(value = APIConstant.PathVariable.SORT_BY, required = false) String SORT_BY,
			@PathVariable(value = APIConstant.PathVariable.SORT_ORDER, required = false) SortOrder SORT_ORDER,
			HttpServletRequest request) throws RuntimeException {
		CommonResponsesDto<OrdersDto> response = new CommonResponsesDto<>();
		response.setData(service.findOrders(PAGE, SIZE, SORT_BY, SORT_ORDER, ONLY_ACTIVE));
		return response;
	}

	/**
	 * 
	 * @param ONLY_ACTIVE
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param request
	 * @return
	 * @throws RuntimeException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@GetMapping(value = APIConstant.APIPath.FIND_ALL_SORTED, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CommonResponsesDto<OrdersDto> find(
			@RequestHeader(value = HeaderConstant.ONLY_ACTIVE, required = false, defaultValue = "false") boolean ONLY_ACTIVE,
			@PathVariable(value = APIConstant.PathVariable.SORT_BY, required = false) String SORT_BY,
			@PathVariable(value = APIConstant.PathVariable.SORT_ORDER, required = false) SortOrder SORT_ORDER,
			HttpServletRequest request) throws RuntimeException {
		CommonResponsesDto<OrdersDto> response = new CommonResponsesDto<>();
		response.setData(service.findOrders(SORT_BY, SORT_ORDER, ONLY_ACTIVE));
		return response;
	}

	/**
	 * 
	 * @param ONLY_ACTIVE
	 * @param PAGE
	 * @param SIZE
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param request
	 * @return
	 * @throws RuntimeException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@GetMapping(value = APIConstant.APIPath.FIND_ALL_WITH_PAGE_AND_INCLUSION, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public CommonResponsesDto<OrdersDto> findIncluding(
			@RequestHeader(value = HeaderConstant.ONLY_ACTIVE, required = false, defaultValue = "false") boolean ONLY_ACTIVE,
			@PathVariable(value = APIConstant.PathVariable.PAGE, required = false) Integer PAGE,
			@PathVariable(value = APIConstant.PathVariable.SIZE, required = false) Integer SIZE,
			@PathVariable(value = APIConstant.PathVariable.SORT_BY, required = false) String SORT_BY,
			@PathVariable(value = APIConstant.PathVariable.SORT_ORDER, required = false) SortOrder SORT_ORDER,
			HttpServletRequest request) throws RuntimeException {
		CommonResponsesDto<OrdersDto> response = new CommonResponsesDto<>();
		response.setData(service.findOrders(PAGE, SIZE, SORT_BY, SORT_ORDER, ONLY_ACTIVE));
		return response;
	}

	/**
	 * 
	 * @param ONLY_ACTIVE
	 * @param SORT_BY
	 * @param SORT_ORDER
	 * @param request
	 * @return
	 * @throws RuntimeException
	 */
	@LogBefore
	@LogAfter
	@LogExceptionaly
	@GetMapping(value = APIConstant.APIPath.FIND_ALL_SORTED_AND_INCLUSION, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public CommonResponsesDto<OrdersDto> findSorted(
			@RequestHeader(value = HeaderConstant.ONLY_ACTIVE, required = false, defaultValue = "false") boolean ONLY_ACTIVE,
			@PathVariable(value = APIConstant.PathVariable.SORT_BY, required = false) String SORT_BY,
			@PathVariable(value = APIConstant.PathVariable.SORT_ORDER, required = false) SortOrder SORT_ORDER,
			HttpServletRequest request) throws RuntimeException {
		CommonResponsesDto<OrdersDto> response = new CommonResponsesDto<>();
		response.setData(service.findOrders(SORT_BY, SORT_ORDER, ONLY_ACTIVE));
		return response;
	}

	@LogBefore
	@LogAfter
	@LogExceptionaly
	@PostMapping(value = DCSBalajiConstant.APIPath.PUSH_ORDER, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public CommonResponseDto<SalesOrderDto> pushOrder(@RequestHeader(DCSBalajiConstant.Header.CUST_EMAIL) String EMAIL,
			@RequestHeader(DCSBalajiConstant.Header.CUST_MOB) String MOB, @RequestBody List<PurchaseOrder> order,
			HttpServletRequest request) throws Exception {
		CommonResponseDto<SalesOrderDto> dto = new CommonResponseDto<>();
		dto.setData(service.pushOrder(EMAIL, MOB, order));
		return dto;
	}

	@LogBefore
	@LogAfter
	@LogExceptionaly
	@PutMapping(value = DCSBalajiConstant.APIPath.UPDATE_ORDER, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public CommonResponseDto<SalesOrderDto> updateOrder(
			@RequestHeader(DCSBalajiConstant.Header.CUST_EMAIL) String EMAIL,
			@RequestHeader(DCSBalajiConstant.Header.CUST_MOB) String MOB,
			@RequestHeader(DCSBalajiConstant.Header.ORDER_NO) String ORDER_NO, @RequestBody List<PurchaseOrder> order,
			HttpServletRequest request) throws Exception {
		CommonResponseDto<SalesOrderDto> dto = new CommonResponseDto<>();
		dto.setData(service.updateOrder(ORDER_NO, EMAIL, MOB, order));
		return dto;
	}

	@LogBefore
	@LogAfter
	@LogExceptionaly
	@PostMapping(value = DCSBalajiConstant.APIPath.CANCEL_ORDER, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public CommonResponseDto<SalesOrderDto> cancelOrder(
			@RequestHeader(DCSBalajiConstant.Header.CUST_EMAIL) String EMAIL,
			@RequestHeader(DCSBalajiConstant.Header.CUST_MOB) String MOB, @RequestBody CancelOrder ORDER,
			HttpServletRequest request) throws Exception {
		CommonResponseDto<SalesOrderDto> dto = new CommonResponseDto<>();
		dto.setData(service.cancelOrder(EMAIL, MOB, ORDER));
		return dto;
	}

	@LogBefore
	@LogAfter
	@LogExceptionaly
	@GetMapping(value = DCSBalajiConstant.APIPath.GET_ORDER, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CommonResponsesDto<SalesOrderDto> getOrder(@RequestHeader(DCSBalajiConstant.Header.CUST_EMAIL) String EMAIL,
			@RequestHeader(DCSBalajiConstant.Header.CUST_MOB) String MOB, HttpServletRequest request) throws Exception {
		CommonResponsesDto<SalesOrderDto> dto = new CommonResponsesDto<>();
		dto.setData(service.getOrders(EMAIL, MOB));
		return dto;
	}

	@LogBefore
	@LogAfter
	@LogExceptionaly
	@GetMapping(value = DCSBalajiConstant.APIPath.ORDER_STATUS, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CommonResponseDto<Map<OrderStatus, String>> getOrderStatus(HttpServletRequest request) throws Exception {
		CommonResponseDto<Map<OrderStatus, String>> dto = new CommonResponseDto<>();
		Map<OrderStatus, String> map = new LinkedHashMap<>();
		map.put(OrderStatus.A, OrderStatus.A.type());
		map.put(OrderStatus.D, OrderStatus.D.type());
		map.put(OrderStatus.P, OrderStatus.P.type());
		map.put(OrderStatus.R, OrderStatus.R.type());
		dto.setData(map);
		return dto;
	}

	@LogBefore
	@LogAfter
	@LogExceptionaly
	@GetMapping(value = DCSBalajiConstant.APIPath.GET_CANCELATIONS, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CommonResponseDto<Map<CancelledBy, String>> getOrderCancelation(HttpServletRequest request)
			throws Exception {
		CommonResponseDto<Map<CancelledBy, String>> dto = new CommonResponseDto<>();
		Map<CancelledBy, String> map = new LinkedHashMap<>();
		map.put(CancelledBy.C, CancelledBy.C.type());
		map.put(CancelledBy.S, CancelledBy.S.type());
		dto.setData(map);
		return dto;
	}

	@LogBefore
	@LogAfter
	@LogExceptionaly
	@PutMapping(value = DCSBalajiConstant.APIPath.SALLER_UPDATE_ORDER, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public CommonResponseDto<SalesOrderDto> updateOrderBySaller(
			@RequestHeader(DCSBalajiConstant.Header.ORDER_NO) String ORDER_NO, @RequestBody List<PurchaseOrder> order,
			HttpServletRequest request) throws Exception {
		CommonResponseDto<SalesOrderDto> dto = new CommonResponseDto<>();
		dto.setData(service.updateOrderBySaller(ORDER_NO, order));
		return dto;
	}

	@LogBefore
	@LogAfter
	@LogExceptionaly
	@PostMapping(value = DCSBalajiConstant.APIPath.SALLER_CANCEL_ORDER, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public CommonResponseDto<SalesOrderDto> cancelOrderBySaller(@RequestBody CancelOrder ORDER,
			HttpServletRequest request) throws Exception {
		CommonResponseDto<SalesOrderDto> dto = new CommonResponseDto<>();
		dto.setData(service.cancelOrderBySaller(ORDER));
		return dto;
	}

	@LogBefore
	@LogAfter
	@LogExceptionaly
	@GetMapping(value = DCSBalajiConstant.APIPath.SALLER_GET_ORDER, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CommonResponsesDto<SalesOrderDto> getSallerOrder(
			@RequestHeader(value = DCSBalajiConstant.Header.ORDER_STATUS, required = false) OrderStatus ORDER_STATUS,
			HttpServletRequest request) throws Exception {
		CommonResponsesDto<SalesOrderDto> dto = new CommonResponsesDto<>();
		dto.setData(service.getSallerOrders(ORDER_STATUS));
		return dto;
	}

}
