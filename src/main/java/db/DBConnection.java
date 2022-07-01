package db;

import java.util.List;
import java.util.Set;

import entity.Item;

public interface DBConnection {

	//close connection
	public void close();
	
	//insert fav items
	public void setFavoriteItems(String userId, List<String> itemIds);
	
	//delete fav item
	public void unsetFavoriteItems(String userId, List<String> itemIds);
	
	//get fav item
	public Set<String> getFavoriteItemIds(String userId);
	public Set<Item> getFavoriteItems(String userId);
	
	//get categories based on item id
	public Set<String> getCategories(String itemId);
	
	//search item near a location and a term
	public List<Item> searchItems(double lat, double lon, String term);
	
	//save item to db
	public void saveItem(Item item);
	
	//get full name of user
	public String getFullName(String userId);
	
	//verify credential is correct
	public boolean verifyLogin(String userId, String password);
	
	//singup
	public boolean registerUser(String userId, String password, String firstname, String lastname);
	
	
}
