package com.dcs.balaji.controller;

import java.util.Arrays;
import java.util.HashSet;
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
import com.dcs.balaji.model.SallingItems;
import com.dcs.balaji.model.StockDto;
import com.dcs.balaji.service.StockService;
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
		+ DCSBalajiConstant.Symbol.SLASH + DCSBalajiConstant.RequestPath.STOCK)
@Api(value = "Stock Master Controller")
@EnableSwagger
public class StockController {

	@Autowired
	private StockService service;

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
	public CommonResponseDto<StockDto> save(@Valid @RequestBody StockDto dto, HttpServletRequest request)
			throws RuntimeException {
		CommonResponseDto<StockDto> response = new CommonResponseDto<>();
		response.setData(service.loadStock(service.saveStock(dto)));
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
	public CommonResponsesDto<StockDto> saveAll(@Valid @RequestBody List<StockDto> dto, HttpServletRequest request)
			throws RuntimeException {
		CommonResponsesDto<StockDto> response = new CommonResponsesDto<>();
		response.setData(service.loadStock(service.saveStock(dto)));
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
	public CommonResponseDto<StockDto> update(@Valid @RequestBody StockDto dto, HttpServletRequest request)
			throws RuntimeException {
		CommonResponseDto<StockDto> response = new CommonResponseDto<>();
		response.setData(service.loadStock(service.updateStock(dto)));
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
	public CommonResponsesDto<StockDto> updateAll(@Valid @RequestBody List<StockDto> dto, HttpServletRequest request)
			throws RuntimeException {
		CommonResponsesDto<StockDto> response = new CommonResponsesDto<>();
		service.updateStock(dto);
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
	public CommonResponseDto<StockDto> find(
			@RequestHeader(value = HeaderConstant.ONLY_ACTIVE, required = false, defaultValue = "false") boolean ONLY_ACTIVE,
			@PathVariable(APIConstant.PathVariable.ID) Integer ID, HttpServletRequest request) throws RuntimeException {
		CommonResponseDto<StockDto> response = new CommonResponseDto<>();
		response.setData(service.loadStock(ID));
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
	public CommonResponsesDto<StockDto> find(
			@RequestHeader(value = HeaderConstant.ONLY_ACTIVE, required = false, defaultValue = "false") boolean ONLY_ACTIVE,
			@PathVariable(value = APIConstant.PathVariable.PAGE, required = false) Integer PAGE,
			@PathVariable(value = APIConstant.PathVariable.SIZE, required = false) Integer SIZE,
			@PathVariable(value = APIConstant.PathVariable.SORT_BY, required = false) String SORT_BY,
			@PathVariable(value = APIConstant.PathVariable.SORT_ORDER, required = false) SortOrder SORT_ORDER,
			HttpServletRequest request) throws RuntimeException {
		CommonResponsesDto<StockDto> response = new CommonResponsesDto<>();
		response.setData(service.findStock(PAGE, SIZE, SORT_BY, SORT_ORDER, ONLY_ACTIVE));
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
	public CommonResponsesDto<StockDto> find(
			@RequestHeader(value = HeaderConstant.ONLY_ACTIVE, required = false, defaultValue = "false") boolean ONLY_ACTIVE,
			@PathVariable(value = APIConstant.PathVariable.SORT_BY, required = false) String SORT_BY,
			@PathVariable(value = APIConstant.PathVariable.SORT_ORDER, required = false) SortOrder SORT_ORDER,
			HttpServletRequest request) throws RuntimeException {
		CommonResponsesDto<StockDto> response = new CommonResponsesDto<>();
		response.setData(service.findStock(SORT_BY, SORT_ORDER, ONLY_ACTIVE));
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
	public CommonResponsesDto<StockDto> findIncluding(
			@RequestHeader(value = HeaderConstant.ONLY_ACTIVE, required = false, defaultValue = "false") boolean ONLY_ACTIVE,
			@PathVariable(value = APIConstant.PathVariable.PAGE, required = false) Integer PAGE,
			@PathVariable(value = APIConstant.PathVariable.SIZE, required = false) Integer SIZE,
			@PathVariable(value = APIConstant.PathVariable.SORT_BY, required = false) String SORT_BY,
			@PathVariable(value = APIConstant.PathVariable.SORT_ORDER, required = false) SortOrder SORT_ORDER,
			HttpServletRequest request) throws RuntimeException {
		CommonResponsesDto<StockDto> response = new CommonResponsesDto<>();
		response.setData(service.findStock(PAGE, SIZE, SORT_BY, SORT_ORDER, ONLY_ACTIVE));
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
	public CommonResponsesDto<StockDto> findSorted(
			@RequestHeader(value = HeaderConstant.ONLY_ACTIVE, required = false, defaultValue = "false") boolean ONLY_ACTIVE,
			@PathVariable(value = APIConstant.PathVariable.SORT_BY, required = false) String SORT_BY,
			@PathVariable(value = APIConstant.PathVariable.SORT_ORDER, required = false) SortOrder SORT_ORDER,
			HttpServletRequest request) throws RuntimeException {
		CommonResponsesDto<StockDto> response = new CommonResponsesDto<>();
		response.setData(service.findStock(SORT_BY, SORT_ORDER, ONLY_ACTIVE));
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
	@GetMapping(value = DCSBalajiConstant.APIPath.GET_ITEMS, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CommonResponseDto<Map<String, List<SallingItems>>> getItems(HttpServletRequest request)
			throws RuntimeException {
		CommonResponseDto<Map<String, List<SallingItems>>> response = new CommonResponseDto<>();
		response.setData(service.getItems(null));
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
	@GetMapping(value = DCSBalajiConstant.APIPath.GET_ITEMS_BY_CAT, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CommonResponseDto<Map<String, List<SallingItems>>> getItems(
			@PathVariable(DCSBalajiConstant.Word.CAT_ID) Integer cat_id, HttpServletRequest request)
			throws RuntimeException {
		CommonResponseDto<Map<String, List<SallingItems>>> response = new CommonResponseDto<>();
		response.setData(service.getItems(cat_id));
		return response;
	}

}
