package com.umang.springmvc.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.umang.springmvc.common.AESCryptUtils;
import com.umang.springmvc.common.ItemsDto;
import com.umang.springmvc.dao.ContactDAO;
import com.umang.springmvc.entities.AppItemList;
import com.umang.springmvc.entities.AppUser;
import com.umang.springmvc.entities.Item;
import com.umang.springmvc.entities.ItemJsonRespone;
import com.umang.springmvc.entities.ItemListWithCategory;
import com.umang.springmvc.entities.ItemType;
import com.umang.springmvc.entities.JData;
import com.umang.springmvc.entities.ManuscriptDetail;
import com.umang.springmvc.entities.ManuscriptHeadofPrint;
import com.umang.springmvc.entities.Order;
import com.umang.springmvc.webservices.EmpRestURIConstants;
import com.umang.springmvc.webservices.Employee;
import com.umang.springmvc.webservices.ManuscriptService;
import com.umang.springmvc.webservices.ManuscriptServiceImpl;



@Controller
@RequestMapping("/")
@SessionAttributes("appUser")
public class AppController {

	 @Autowired
	 ManuscriptService manuscriptService; 
	 @Autowired
	 ContactDAO contactDao;
	 AESCryptUtils encription = new AESCryptUtils();
	 private static final Logger logger = LogManager.getLogger(ManuscriptServiceImpl.class);
		Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
		
	@ModelAttribute("appUser")
	public AppUser setUpUserForm() {
	return new AppUser();
	}	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public ModelAndView homePage(ModelMap model) {
		List<ManuscriptHeadofPrint> manuDetailsforheadOfprintList = null;
		 //List<Contact> listContact = contactDAO.list();
		 //System.out.println("List Size : "+listContact.size());
		/* ManuscriptDetail manuscriptDetail = manuscriptService.getManuscriptTotalCountDetail(null);
			//request.setAttribute("totalManuscriptCount", manuscriptDetail != null ? manuscriptDetail.getTotalCount() : 0);
		 System.out.println("Count : "+manuscriptDetail.getTotalCount());
		 manuDetailsforheadOfprintList = manuscriptService.getManuscriptDetailList("WJOLS", 1, 10, "Pending"); */
		return new ModelAndView("home", "contactForm", "");
		//return "home";
	}
	@RequestMapping(value = { "/admin"}, method = RequestMethod.GET)
	public String lockScreen(ModelMap model) {
		System.out.println("Dashboard********************8");
		return "admin";
	}
	@RequestMapping(value = { "/detail"}, method = RequestMethod.GET)
	public String detail(ModelMap model) {
		System.out.println("detail********************8");
		return "detail";
	}
	@RequestMapping(value = { "/checkout"}, method = RequestMethod.GET)
	public String checkout(ModelMap model) {
		System.out.println("checkout********************8");
		return "checkout";
	}
	@RequestMapping(value = { "/shopping-cart"}, method = RequestMethod.GET)
	public String shoppingCart(ModelMap model) {
		System.out.println("shoppingCart********************8");
		return "shoppingcart";
	}
	@RequestMapping(value = { "/signIn"}, method = RequestMethod.GET)
	public String signIn(ModelMap model) {
		System.out.println("signIn********************8");
		return "signIn";
	}
	@RequestMapping(value = { "/contact"}, method = RequestMethod.GET)
	public String contact(ModelMap model) {
		System.out.println("conatctUs********************8");
		return "contact";
	}
	@RequestMapping(value = { "/dashboard"}, method = RequestMethod.GET)
	public String dashboard(ModelMap model) {
		System.out.println("Dashboard********************8");
		return "dashboard";
	}
	@RequestMapping(value = { "/products"}, method = RequestMethod.GET)
	public String productsPage(ModelMap model) {
		return "products";
	}

	@RequestMapping(value = { "/contactus"}, method = RequestMethod.GET)
	public String contactUsPage(ModelMap model) {
		return "contactus";
	}
	
	@RequestMapping(value = { "/items"}, method = RequestMethod.GET)
	public ModelAndView itemBook(ModelMap model) {
		System.out.println("Items *********************");
		 List<Item> itemList= contactDao.itemList();
		 return new ModelAndView("items", "itemList", itemList);
	}
	
	@RequestMapping(value = { "/create"}, method = RequestMethod.GET)
	public ModelAndView createProduct(ModelMap model) {
		System.out.println("create *********************");
		List<ItemType> types = contactDao.ItemTypeList();
		//model.addAttribute("types",types);
		//return "create";
		return new ModelAndView("create", "types", types);
	}
	@RequestMapping(value = EmpRestURIConstants.EDIT_ITEM, method = RequestMethod.GET)
	public ModelAndView editUser(ModelMap model,@PathVariable("itemid") int itemid) {
	 logger.info(" editUser *********************");
		Item item= new Item();
		ItemType type = new ItemType();
		try {
			item= contactDao.getItemById(itemid, "");
			type= contactDao.ItemTypeById(Long.parseLong(item.getType()) , "");
			item.setType(type.getItemTypeName());
		}catch (Exception e) {
			e.printStackTrace();
		}
		//return "createUser";
		return new ModelAndView("editItems", "item", item);
	}
	@RequestMapping(value = { "/createUser"}, method = RequestMethod.GET)
	public String createUser(ModelMap model) {
		System.out.println("createUser *********************");
		return "createUser";
	}
	@RequestMapping(value ="/itemType", method = RequestMethod.GET)
	public String itemType(ModelMap model) {
		System.out.println("itemType *********************");
		//ItemType userType= new ItemType();
		try {
			//user= contactDao.getUserById(id, "");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "itemType";
		//return new ModelAndView("itemType", "user", "");
	}
	
	@RequestMapping(value = EmpRestURIConstants.ITEM_TYPE, method = RequestMethod.GET)
	public @ResponseBody ItemType saveType(ModelMap model,@PathVariable("name") String name,@PathVariable("status") String status) {
		System.out.println("editUser *********************");
		ItemType type= new ItemType();
		try {
			int i= contactDao.insertType(name, status);
			if(i>0) {
				type.setStatus("Success");
			}else {
				type.setStatus("Fail");
			}
		}catch (Exception e) {
			type.setStatus("Fail");
			return type;
			//e.printStackTrace();
		}
		//return "createUser";
		return type;
	}
		
	
	@RequestMapping(value = { "/itemTypeList"}, method = RequestMethod.GET)
	public ModelAndView itemTypeList(ModelMap model) {
		System.out.println("activeUser *********************");
		List<ItemType> users = contactDao.ItemTypeList();
		/*
		if(null != users && users.size() > 0) {
			
			for (ItemType u : users) {
				System.out.printf("%s \t %s \n", u.getId(), u.getItemTypeName());
			}
		}
		
		*/
		
		return new ModelAndView("itemTypeList", "itemTypeList",users);
		//return "activeUser";
	}
	@RequestMapping(value = EmpRestURIConstants.DELETE_USR, method = RequestMethod.GET,produces="application/json")
	public @ResponseBody AppUser deleteUser(ModelMap model,@PathVariable("id") int id) {
		AppUser user = new AppUser();
		try {
			int i= contactDao.delete(id);
			if(i>0) {				
				user.setStatus("Success");
			}else {
				user.setStatus("Fail");
			}
		
		}catch (Exception e) {
			user.setStatus("Fail");
			return user;
		}
		return user;
	}
	/*@RequestMapping(value = EmpRestURIConstants.DELETE_ITEM, method = RequestMethod.GET,produces="application/json")
	public @ResponseBody Item deleteItem(ModelMap model,@PathVariable("id") int id) {
		Item item = new Item();
		try {
			int i= 1;//contactDao.deleteItem(id);
			if(i>0) {				
				item.setStatus("Success");
			}else {
				item.setStatus("Fail");
			}
		
		}catch (Exception e) {
			item.setStatus("Fail");
			return item;
		}
		return item;
	}*/
	@RequestMapping(value = { "/currentReq"}, method = RequestMethod.GET)
	public String currentReqList(ModelMap model) {
		System.out.println("currentReq *********************");
		return "currentReq";
	}
	@RequestMapping(value = { "/previousReq"}, method = RequestMethod.GET)
	public String previousReqList(ModelMap model) {
		System.out.println("previousReq *********************");
		return "previousReq";
	}
	@RequestMapping(value = { "/orderList"}, method = RequestMethod.GET)
	public String orderList(ModelMap model) {
		System.out.println("orderList *********************");
		return "orderList";
	}
	@RequestMapping(value = { "/invoiceList"}, method = RequestMethod.GET)
	public String invoiceList(ModelMap model) {
		System.out.println("invoiceList *********************");
		return "invoiceList";
	}
	@RequestMapping("/index")
	public String handle(ModelMap model,@RequestParam String password,@ModelAttribute("appUser") AppUser user,HttpSession session) {
		//AppUser user= new AppUser();
		try {
		user= contactDao.getUser(password,"");
		if(user == null) {
	        model.addAttribute("error", "Invalid mobile no. Please try again!");
	        return "redirect:/";
		}else {
			session.setAttribute("user", user);
			if(user.getUserType().equals("Admin")) {
				return "redirect:/dashboard";
			}else if(user.getUserType().equals("Customer")) {
				return "redirect:/customerdashboard";
			}else {
				return "redirect:/dashboard";
			}
		}
		}catch (Exception e) {
			model.addAttribute("error", "Invalid. Please try again!");
			return "redirect:/";
		}
   }
	
	@RequestMapping(value = EmpRestURIConstants.DUMMY_EMP, method = RequestMethod.GET,produces="application/json")
	public @ResponseBody Employee getDummyEmployee() {
		logger.info("Start getDummyEmployee");
		Employee emp = new Employee();
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setCreatedDate(new Date());
		empData.put(9999, emp);
		return emp;
	}
	@RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET,produces="application/json")
	public @ResponseBody AppUser getEmployee(@PathVariable("id") String empNo) {
		String otp = encription.generaeOTP();
		logger.info("Start getEmployee. ID="+empNo);
		AppUser user= new AppUser();
		try {
			user.setOTP(otp);
			user.setUsername(empNo);
			user.setStatus("1");
			user.setPassword(encription.encrypt(empNo));
			user.setUserType("App");
			int i= contactDao.insertUserData(user);
			System.out.println("Data Inserted SuccessFully :"+i);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	@RequestMapping(value = EmpRestURIConstants.GET_OTP, method = RequestMethod.GET,produces="application/json")
	public @ResponseBody AppUser getOTPValidation(@PathVariable("id") String OTP,@PathVariable("userid") String userId) {
		 List<Employee> employeeLst = new ArrayList<Employee>();
		String otp = encription.generaeOTP();
		logger.info("Start getEmployee. ID="+OTP);
		AppUser user= new AppUser();
		try {
			user= contactDao.getUser(userId,OTP);
			if(user.getOTP().equals(OTP)) {
				user.setStatus("Success");
			}else {
				user.setUsername(OTP);
				user.setStatus("Fail");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@RequestMapping(value = { "/create/item/save"}, method = RequestMethod.POST,produces="application/json")
	public @ResponseBody Item itemSave(ModelMap model,@RequestBody Item item,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("invoiceList *********************");
		//System.out.println(" "+filename);  
		
		Item iteamValue = new Item();
		try {
			 String rpath = request.getRealPath("/");
			    rpath = rpath + "/" + item.getImagepath(); // whatever path you used for storing the file
			    Path path = Paths.get(rpath);
		System.out.println("Item Name: "+item.getItemName());
		
		String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/views/appImage/");
        Path file = Paths.get(dataDirectory, item.getImagepath());
        /*if (!Files.exists(file)) 
        {
            response.setContentType("application/jpeg");
            response.addHeader("Content-Disposition", "attachment; filename="+"mp.jpeg");
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }*/
		long result= contactDao.saveItem(item);
		if(result>0) {
			iteamValue.setStatus("Success");	
		}else {
			iteamValue.setStatus("Fail");
		}
		
		}catch (Exception e) {
			e.printStackTrace();
			iteamValue.setStatus("Fail");
			return iteamValue;
			//e.printStackTrace();
		}
		return iteamValue;
	}
	/*@RequestMapping(value=EmpRestURIConstants.GET_ITEMLIST, method=RequestMethod.GET ,produces="application/json")
    @ResponseBody
    public List<AppItemList> appitemlist(@PathVariable("category") String category,ModelMap model) {
        List<AppItemList> itemList= contactDao.appitemList(category,0);
        
        System.out.println("Item Name :"+itemList.size());
        itemList.addAll(itemList);
        return itemList;
    }*/
	@RequestMapping(value = EmpRestURIConstants.GET_ITEMLIST,produces="application/json")
    public ResponseEntity<ItemListWithCategory> appitemlist (@PathVariable("category") String category)
    {
        	 List<AppItemList> itemList= contactDao.appitemList(category,0);
        	 ItemListWithCategory item = new ItemListWithCategory();
        	 if(itemList.size()>0) {
        	 
        	 item.setItemData(itemList);
        	 item.setStatus("Success");
           return new ResponseEntity<ItemListWithCategory>(item, HttpStatus.OK);
        	 }else {
        		 item.setStatus("404" +"Not Found"); 
        	 }
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
	@RequestMapping(value="/order", method=RequestMethod.POST,consumes="application/json",produces="application/json")
    @ResponseBody
    public List<String> saveOrder(@RequestBody Order order,ModelMap model) {
        List<String> response = new ArrayList<String>();
        String orderNo = RandomStringUtils.random(12,"123456789012abcdefghijklmnopqrstuvwxyz").toUpperCase();
        for (Item item: order.getOrderItemData()){
            //personService.save(person);
        	System.out.println("Item Name :"+item.getItemName()+" : Id :"+item.getId());
            /* response.add("Saved person: " + item.toString());*/
        }
        
       	System.out.println(orderNo);
       
        System.out.println("Item Name :"+order.getItemName());
        response.add("Refrence No.: " + orderNo);
        response.add("Status : "+"Success");
        return response;
    }
	@RequestMapping("/invalidate")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
	/*@ModelAttribute("countryList")
	   public Map<String, String> getCountryList() {
	      Map<String, String> countryList = new HashMap<String, String>();
	      countryList.put("US", "United States");
	      countryList.put("CH", "China");
	      countryList.put("SG", "Singapore");
	      countryList.put("MY", "Malaysia");
	      return countryList;
	   }*/
	/**
	 * API Realated Screen 
	 */
	@RequestMapping(value = { "/itemCreate"}, method = RequestMethod.GET)
	public ModelAndView itemCreate(ModelMap model,@ModelAttribute("item")ItemsDto item) {
		System.out.println("create *********************");
		List<ItemType> types = contactDao.ItemTypeList();
		//model.addAttribute("types",types);
		//return "create";
		return new ModelAndView("itemCreate", "types",types);
	}
}