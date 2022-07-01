package rpc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import com.mongodb.AggregationOptions.Builder;

import entity.Item;
import entity.Item.ItemBuilder;

public class RpcHelperTest {
	@Test
	public void testGetJSONArray() throws JSONException {
		Set<String> category = new HashSet<String>();
		category.add("category one");
		
		ItemBuilder build1 = new ItemBuilder();
		build1.setItemId("one");
		build1.setDistance(10);
		build1.setCategories(category);
		Item one = build1.build();
		ItemBuilder build2 = new ItemBuilder();
		build1.setItemId("two");
		build1.setDistance(20);
		build1.setCategories(category);
		Item two = build2.build();
		
		List<Item> listItem = new ArrayList<Item>();
		listItem.add(one);
		listItem.add(two);
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(one.toJSONObject());
		jsonArray.put(two.toJSONObject());
		JSONAssert.assertEquals(jsonArray, RpcHelper.getJSONArray(listItem), true);
	}
}
