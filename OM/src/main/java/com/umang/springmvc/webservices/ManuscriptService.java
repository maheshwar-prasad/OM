package com.umang.springmvc.webservices;

import java.util.List;

import com.umang.springmvc.client.SortOrder;
import com.umang.springmvc.common.CommonResponseDto;
import com.umang.springmvc.common.CommonResponseItemDto;
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

public interface ManuscriptService {
	public ManuscriptDetail getManuscriptDetail(String manuscriptNumber, String jCode);

	public ManuscriptDetail getManuscriptTotalCountDetail(String jCode);

	public List<ManuscriptHeadofPrint> getManuscriptDetailList(String jCode, int startIndex, int endIndex, String status);

	public int getManuscriptDetailCount(String jCode, int startIndex, int endIndex, String status);

	public int getyetToBeAssignedCount(String jCode, int startCount, int paginationListCount, String status);
	
	public ItemsResponses getItemDetailList(String itemName,SortOrder sortingOrder);
	
	public List<CommonResponseItemDto> getStockDetailList(String jCode, int startIndex, int endIndex, String status);
	
	public List<CommonResponseItemDto> getOrderDetailList(String jCode, int startIndex, int endIndex, String status);

	public DeleteResponse deleteItem(int itemId);
	
	public OrdersResponses findAllSorted(String itemName,SortOrder sortingOrder);
	
	public ItemsResponse getSaveItem(ItemsDto itemBody);
	
	public DeleteResponse deleteOrder(int orderId);
	
	public SalesOrderResponse cancelOrder(CancelOrder orderNo);
	
	public CustomerResponse getSaveCustomer(CustomerDto customerBody);
	
	public CustomerResponses getCustomerDetails(String sort_by, SortOrder sortOrder) ;
	
	public DeleteResponse deleteCust(int custId);
	
	public ItemsResponse getItemByItemId(String itemId,SortOrder sortingOrder);
	
}
