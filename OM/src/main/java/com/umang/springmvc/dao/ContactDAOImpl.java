package com.umang.springmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;


import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.umang.springmvc.entities.AppItemList;
import com.umang.springmvc.entities.AppUser;
import com.umang.springmvc.entities.Contact;
import com.umang.springmvc.entities.Item;
import com.umang.springmvc.entities.ItemType;
import com.umang.springmvc.model.AddCart;

public class ContactDAOImpl implements ContactDAO {
	 
    private JdbcTemplate jdbcTemplate;
 
    public ContactDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
 
    @Override
    public void saveOrUpdate(Contact contact) {
        // implementation details goes here...
    }
 
    @Override
    public int delete(int userId) {
    	StringBuilder sb = new StringBuilder(" delete from appUser where user_id = ? ");
		return jdbcTemplate.update(sb.toString(),userId);
 
    }
 
    @Override
    public List<Contact> list() {
    	String sql = "SELECT id,name,price,quantity,description FROM product";
        List<Contact> listContact = jdbcTemplate.query(sql, new RowMapper<Contact>() {
     
            public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
                Contact aContact = new Contact();
     
                aContact.setId(rs.getInt("id"));
                aContact.setName(rs.getString("name"));
                aContact.setEmail(rs.getString("price"));
                aContact.setAddress(rs.getString("quantity"));
                aContact.setTelephone(rs.getString("description"));
     
                return aContact;
            }
     
        });
     
        return listContact;
    }
 
    @Override
    public Contact get(int contactId) {
		return null;
        // implementation details goes here...
    }
    
    @Override
    public AppUser getUser(String username, String otp) {
    	Object[] arr = new Object[0];
    	String sql  = null;
    	if(otp != null && !otp.equals("")) {
    	 sql = "SELECT user_id,username,userType,OTP,created_date,status,name from appuser where username = ?  AND  OTP= ? ";
    	arr =  new Object[] {username,otp};
    	}else{
    		 sql = "SELECT user_id,username,userType,OTP,created_date,status,name from appuser where username = ?";
        	arr =  new Object[] {username};
    	}
        List<AppUser> userlist = jdbcTemplate.query(sql, arr, new RowMapper<AppUser>() {
     
            public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            	AppUser user = new AppUser();
            		user.setUser_id(rs.getInt("user_id"));
            		user.setUsername(rs.getString("username"));
            		user.setUserType(rs.getString("userType"));
            		user.setOTP(rs.getString("OTP"));
            		if(rs.getString("status").equals("1")) {
            			user.setStatus("Success");
            		}else {
            			user.setStatus("Fail");
            		}
            		user.setName(rs.getString("name"));
            		user.setCreatedDate(rs.getDate("created_date"));
            		
                return user;
            }
     
        });
        if (!CollectionUtils.isEmpty(userlist)) {
			return userlist.get(0);
		}
		return null;

    }
    
    @Override
	public int insertUserData(AppUser user) {
		StringBuilder sb = new StringBuilder(" INSERT INTO `hms`.`appuser`(`username`,`password`,`userType`,`OTP`,`enabled`,`status`,`name`,`address1`,`companyname`)VALUES(?,?,?,?,?,?,?,?,?)");
		return jdbcTemplate.update(sb.toString(),user.getUsername(),user.getPassword(),user.getUserType(),user.getOTP(),"1",user.getStatus(),user.getName(),user.getAddress1(),user.getCompanyName());
	}
    
    @Override
    public List<AppUser> userList() {
    	String sql = "SELECT user_id,username,userType,OTP,created_date,status, enabled from appuser ";
        List<AppUser> listUser= jdbcTemplate.query(sql, new RowMapper<AppUser>() {
     
            public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            	AppUser user = new AppUser();
            	user.setUser_id(rs.getInt("user_id"));
        		user.setUsername(rs.getString("username"));
        		user.setUserType(rs.getString("userType"));
        		user.setOTP(rs.getString("OTP"));
        		if(rs.getString("status").equals("1")) {
        			user.setStatus("Success");
        		}else {
        			user.setStatus("Fail");
        		}
        		user.setCreatedDate(rs.getDate("created_date"));
                
     
                return user;
            }
     
        });
     
        return listUser;
    }
    @Override
    public AppUser getUserById(int userId, String otp) {
    	Object[] arr = new Object[0];
    	String sql  = null;
    	if(otp != null && !otp.equals("")) {
    	 sql = "SELECT user_id,username,userType,OTP,created_date,status, name,address1 from appuser where user_id = ?  AND  OTP= ? ";
    	arr =  new Object[] {userId,otp};
    	}else{
    		 sql = "SELECT user_id,username,userType,OTP,created_date,status, name,address1 from appuser where user_id = ?";
        	arr =  new Object[] {userId};
    	}
        List<AppUser> userlist = jdbcTemplate.query(sql, arr, new RowMapper<AppUser>() {
     
            public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            	AppUser user = new AppUser();
            		user.setUser_id(rs.getInt("user_id"));
            		user.setUsername(rs.getString("username"));
            		user.setUserType(rs.getString("userType"));
            		user.setOTP(rs.getString("OTP"));
            		if(rs.getString("status").equals("1")) {
            			user.setStatus("Success");
            		}else {
            			user.setStatus("Fail");
            		}
            		user.setCreatedDate(rs.getDate("created_date"));
            		user.setName(rs.getString("name"));
            		user.setAddress1(rs.getString("address1"));
            		
                return user;
            }
     
        });
        if (!CollectionUtils.isEmpty(userlist)) {
			return userlist.get(0);
		}
		return null;

    }
    public int insertType(String name,String status) {
    	StringBuilder sb = new StringBuilder(" INSERT INTO `hms`.`itemType`(`typeName`,`status`)VALUES(?,?)");
		return jdbcTemplate.update(sb.toString(),name,status);
    }
    @Override
    public List<ItemType> ItemTypeList() {
    	String sql = "select itemType_id, typeName,status  from itemtype ";
        List<ItemType> listUser= jdbcTemplate.query(sql, new RowMapper<ItemType>() {
     
            public ItemType mapRow(ResultSet rs, int rowNum) throws SQLException {
            	ItemType type = new ItemType();
            	type.setId(rs.getInt("itemType_id"));
            	type.setItemTypeName(rs.getString("typeName"));
            	type.setStatus(rs.getString("status"));
            	
            	return type;
            }
     
        });
     
        return listUser;
    }
    @Override
	public long saveItem(final Item item) {
  
		final String insertSql = "INSERT INTO `hms`.`item`(`itemName`,`quantity`,`availableQty`,`oldPrice`,`currentPrice`,`pack`,`status`,`type`) VALUES (?,?,?,?,?,?,?,?)";
		//		return getJDBC().update(insertSql, mcqExamResult.getUserId(), mcqExamResult.getSpeciality(), mcqExamResult.getTotalQuestions(), mcqExamResult.getUnattemptedQuestions(), mcqExamResult.getAttemptedQuestions(), mcqExamResult.getCorrectAnswers(), mcqExamResult.getIncorrectAnswers());

		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
				final PreparedStatement ps = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1,item.getItemName());
				ps.setString(2,item.getQuantity());
				ps.setString(3, item.getAvailableQty());
				ps.setString(4,item.getOldPrice() );
				ps.setString(5, item.getCurrentPrice());
				ps.setString(6, item.getPack());
				ps.setString(7, item.getStatus());
				ps.setString(8, item.getType());
				return ps;
			}
		};

		// The newly generated key will be saved in this object
		final KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(psc, holder);

		final long newNameId = holder.getKey().longValue();
		if(newNameId >0) {
			 String query = "INSERT INTO `hms`.`itemmaster`(`itemId`,`itemTypeId`,`status`)VALUES(?,?,?)";
					return jdbcTemplate.update(query, newNameId, item.getType(), "Active");

		}
		
		return newNameId;
	}
    public List<Item> itemList(){
    	String sql = "SELECT i.item_id,i.itemName,i.quantity,i.availableQty,i.oldPrice,i.currentprice,i.pack,i.type,i.status,it.typeName FROM hms.item i , itemmaster im, itemtype it where  im.itemId=i.item_id AND im.itemTypeId=it.itemType_id and i.status='Active'";
        List<Item> listitem= jdbcTemplate.query(sql, new RowMapper<Item>() {
     
            public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Item item = new Item();
            	  item.setId(rs.getLong("item_id"));
            	  item.setItemName(rs.getString("itemName"));
            	  item.setQuantity(rs.getString("quantity"));
            	  item.setAvailableQty(rs.getString("availableQty"));
            	  item.setOldPrice(rs.getString("oldPrice"));
            	  item.setCurrentPrice(rs.getString("currentprice"));
            	  item.setPack(rs.getString("pack"));
            	  item.setType(rs.getString("type"));
            	  item.setStatus(rs.getString("status"));
            	  item.setTypeName(rs.getString("typeName"));
            	return item;
            }
     
        });
     
        return listitem;
    }
    public List<AppItemList> appitemList( String category, int categoryId){
    	StringBuilder str= new StringBuilder();
    	Object[] arr = new Object[0];
    	str.append("SELECT i.item_id,i.itemName,i.quantity,i.availableQty,i.oldPrice,i.currentprice,i.pack,i.type,i.status,it.typeName as category ");
        str.append("FROM hms.item i , itemMaster im, itemType it where  im.itemId=i.item_id AND im.itemTypeId=it.itemType_id and i.status='Active'");
        if((category!= null && !category.equals("0")) ||  categoryId > 0) {
        	 str.append(" AND ( it.typeName =? OR it.itemType_id=?)");
        	 arr= new Object[] {category,category};
        }
        
        List<AppItemList> listitem = jdbcTemplate.query(str.toString(), arr, new RowMapper<AppItemList>() {
            
        	 public AppItemList mapRow(ResultSet rs, int rowNum) throws SQLException {
             	AppItemList item = new AppItemList();
             	  item.setId(rs.getLong("item_id"));
             	  item.setItemName(rs.getString("itemName"));
             	  item.setQuantity(rs.getString("quantity"));
             	  item.setAvailableQty(rs.getString("availableQty"));
             	  item.setOldPrice(rs.getString("oldPrice"));
             	  item.setCurrentPrice(rs.getString("currentprice"));
             	  item.setPack(rs.getString("pack"));
             	  item.setStatus(rs.getString("status"));
             	  item.setCategory(rs.getString("category"));
             	return item;
             }
     
        });
        return listitem;
    }
    public int deleteItem(int itemId) {
    	StringBuilder sb = new StringBuilder(" delete from item where item_id = ? ");
		return jdbcTemplate.update(sb.toString(),itemId);
    }
    @Override
    public Item getItemById(int itemId, String itemName) {
    	Object[] arr = new Object[0];
    	String sql  = null;
    	
    		 sql = "SELECT item_id, itemName,quantity,availableQty,oldPrice,currentPrice,pack,status,type,created_date,imagePath from  item where item_id =? ";
        	arr =  new Object[] {itemId};
        List<Item> itemlist = jdbcTemplate.query(sql, arr, new RowMapper<Item>() {
     
            public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Item item = new Item();
            		item.setId(rs.getLong("item_id"));
            		item.setItemName(rs.getString("itemName"));
            		item.setQuantity(rs.getString("quantity"));
            		item.setAvailableQty(rs.getString("availableQty"));
            		item.setOldPrice(rs.getString("oldPrice"));
            		item.setCurrentPrice(rs.getString("currentPrice"));
            		item.setPack(rs.getString("pack"));
            		item.setStatus(rs.getString("status"));
            		item.setCreated_date(rs.getString("created_date"));
            		item.setType(rs.getString("type"));
            		item.setImagepath(rs.getString("imagePath"));

                return item;
            }
     
        });
        if (!CollectionUtils.isEmpty(itemlist)) {
			return itemlist.get(0);
		}
		return null;

    }
    
    @Override
    public ItemType ItemTypeById(long id, String typeName) {
    	Object[] arr = new Object[0];
    	String sql = "select itemType_id, typeName,status  from itemtype where  itemType_id =?";
    	arr=  new Object[] {id};
    	List<ItemType> listtype= jdbcTemplate.query(sql,arr, new RowMapper<ItemType>() {
     
            public ItemType mapRow(ResultSet rs, int rowNum) throws SQLException {
            	ItemType type = new ItemType();
            	type.setId(rs.getInt("itemType_id"));
            	type.setItemTypeName(rs.getString("typeName"));
            	type.setStatus(rs.getString("status"));
            	
            	return type;
            }
     
        });
     
    	 if (!CollectionUtils.isEmpty(listtype)) {
 			return listtype.get(0);
 		}
 		return null;
    }
    
    @Override
	public int insertCartData(AddCart cart) {
		StringBuilder sb = new StringBuilder(" INSERT INTO `hms`.`addcart`(`ItemId`,`itemName`,`price`,`sessionCode`,`description`,`imagePath`,`userId`)VALUES(?,?,?,?,?,?,?)");
		return jdbcTemplate.update(sb.toString(),cart.getProductId(),cart.getItemName(),cart.getPrice(),cart.getSessionCode(),cart.getItemDesc(), cart.getImagePath(), cart.getUserId());
	}
    
    @Override
    public List<AddCart> fetchAllAddValue(String SessionCode, long userId , String isDelete, long itemId) {
    	Object[] arr = new Object[0];
    	String sql = "";
    	
    	if(isDelete.equals("Y")) {
    	StringBuilder sb = new StringBuilder(" delete from addcart where ItemId = ? ");
		jdbcTemplate.update(sb.toString(),itemId);
    	}
    	if(userId >0) {
    		sql = " SELECT  `ItemId`,`itemName`,`price`,`sessionCode`,`description`,`imagePath` FROM addcart where  userId =? ";
    		arr=  new Object[] {userId};
    	}else {
    		sql = " SELECT  `ItemId`,`itemName`,`price`,`sessionCode`,`description`,`imagePath` FROM addcart where  sessionCode =? ";
    		arr=  new Object[] {SessionCode};
    	}
    	
    	//arr=  new Object[] {SessionCode};
    	List<AddCart> listcart= jdbcTemplate.query(sql,arr, new RowMapper<AddCart>() {
            public AddCart mapRow(ResultSet rs, int rowNum) throws SQLException {
            	AddCart cart = new AddCart();
            	cart.setProductId(rs.getInt("ItemId"));
            	cart.setItemName(rs.getString("itemName"));
            	cart.setPrice(rs.getDouble("price"));
            	cart.setItemDesc(rs.getString("description"));
            	cart.setSessionCode(rs.getString("sessionCode"));
            	cart.setImagePath(rs.getString("imagePath"));
            	return cart;
            }
     
        });
    	
        return listcart;
    }
    // Web user Registration 
    public AppUser insertWebUser(AppUser user) {
    	final String insertSql = " INSERT INTO `hms`.`appuser`(`username`,`password`,`userType`,`enabled`,`status`,`name`,`email`,`phone`,`OTP`)VALUES(?,?,?,?,?,?,?,?,?)";
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
				final PreparedStatement ps = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1,user.getUsername());
				ps.setString(2,user.getPassword());
				ps.setString(3, user.getUserType());
				ps.setString(4,"1");
				ps.setString(5, user.getStatus());
				ps.setString(6, user.getName());
				ps.setString(7, user.getEmail());
				ps.setString(8, user.getPhone());
				ps.setString(9, user.getOTP());
				return ps;
			}
		};
		final KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(psc, holder);

		final long newuserId = holder.getKey().longValue();
		if(newuserId >0) {
			 String query = "SELECT user_id,username,userType,OTP,created_date,status,name, email, phone from appuser where user_id = ? ";
			
			 List<AppUser> userDetails= jdbcTemplate.query(query, new RowMapper<AppUser>() {
	            public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	AppUser user = new AppUser();
	            	user.setUser_id(rs.getInt("user_id"));
            		user.setUsername(rs.getString("username"));
            		user.setUserType(rs.getString("userType"));
            		user.setOTP(rs.getString("OTP"));
            		if(rs.getString("status").equals("1")) {
            			user.setStatus("Success");
            		}else {
            			user.setStatus("Fail");
            		}
            		user.setName(rs.getString("name"));
            		user.setEmail(rs.getString("email"));
            		user.setPhone(rs.getString("phone"));
            		user.setCreatedDate(rs.getDate("created_date"));
                return user;
	            }
	     
	        },newuserId);
	     
	    	 if (!CollectionUtils.isEmpty(userDetails)) {
	 			return userDetails.get(0);
	 		}
		}
		return null;
    }

    @Override
    public AppUser getUserLogin(String username, String password) {
    	Object[] arr = new Object[0];
    	String sql  = null;
    	
    	sql = "SELECT user_id,username,userType,OTP,created_date,status,name from appuser where email = ?  AND  password= ? ";
    	arr =  new Object[] {username,password};
    	
        List<AppUser> userlist = jdbcTemplate.query(sql, arr, new RowMapper<AppUser>() {
     
            public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            	AppUser user = new AppUser();
            		user.setUser_id(rs.getInt("user_id"));
            		user.setUsername(rs.getString("username"));
            		user.setUserType(rs.getString("userType"));
            		user.setOTP(rs.getString("OTP"));
            		if(rs.getString("status").equals("1")) {
            			user.setStatus("Success");
            		}else {
            			user.setStatus("Fail");
            		}
            		user.setName(rs.getString("name"));
            		user.setCreatedDate(rs.getDate("created_date"));
            		
                return user;
            }
     
        });
        if (!CollectionUtils.isEmpty(userlist)) {
			return userlist.get(0);
		}
		return null;

    }
    
}