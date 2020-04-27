package com.umang.springmvc.dao;

import java.util.List;

import com.umang.springmvc.entities.AppItemList;
import com.umang.springmvc.entities.AppUser;
import com.umang.springmvc.entities.Contact;
import com.umang.springmvc.entities.Item;
import com.umang.springmvc.entities.ItemType;

public interface ContactDAO {
    
    public void saveOrUpdate(Contact contact);
     
    public int delete(int contactId);
     
    public Contact get(int contactId);
     
    public List<Contact> list();
    
    public List<AppUser> userList();
    
    public int insertUserData(AppUser user);
    
    public AppUser getUser(String username, String otp);
    
    public AppUser getUserById(int userId, String otp);
    
    public int insertType(String name,String status);
    
    public List<ItemType> ItemTypeList();
    
    public long saveItem(Item item);
    
    public List<Item> itemList();
    
    public int deleteItem(int itemId);
    public List<AppItemList> appitemList( String category, int categoryId);
    
    public Item getItemById(int itemId, String itemName);
    
    public ItemType ItemTypeById(long itemTypeId, String typeName);
}
