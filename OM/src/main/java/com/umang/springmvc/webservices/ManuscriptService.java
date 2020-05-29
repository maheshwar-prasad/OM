package com.umang.springmvc.webservices;

import java.util.List;

import com.umang.springmvc.client.SortOrder;
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
import com.umang.springmvc.model.SalesOrderResponses;

public interface ManuscriptService {
	public ManuscriptDetail getManuscriptDetail(String manuscriptNumber, String jCode);

	public ManuscriptDetail getManuscriptTotalCountDetail(String jCode);

	public List<ManuscriptHeadofPrint> getManuscriptDetailList(String jCode, int startIndex, int endIndex,
			String status);

	public int getManuscriptDetailCount(String jCode, int startIndex, int endIndex, String status);

	public int getyetToBeAssignedCount(String jCode, int startCount, int paginationListCount, String status);

	public ItemsResponses getItemDetailList(String itemName, SortOrder sortingOrder, Integer routing);

	public List<CommonResponseItemDto> getStockDetailList(String jCode, int startIndex, int endIndex, String status,
			Integer routing);

	public List<CommonResponseItemDto> getOrderDetailList(String jCode, int startIndex, int endIndex, String status,
			Integer routing);

	public DeleteResponse deleteItem(int itemId, Integer routing);

	public SalesOrderResponses findAllSorted(String itemName, SortOrder sortingOrder, Integer routing);

	public ItemsResponse getSaveItem(ItemsDto itemBody, Integer routing);

	public DeleteResponse deleteOrder(int orderId, Integer routing);

	public SalesOrderResponse cancelOrder(CancelOrder orderNo, Integer routing);

	public CustomerResponse getSaveCustomer(CustomerDto customerBody, Integer routing);

	public CustomerResponses getCustomerDetails(String sort_by, SortOrder sortOrder, Integer routing);

	public DeleteResponse deleteCust(int custId, Integer routing);

	public ItemsResponse getItemByItemId(Integer itemId, SortOrder sortingOrder, Integer routing);

}
