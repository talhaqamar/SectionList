package com.section.list;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


import com.section.json.UserFunctions;
import com.section.model.CheckBoxes;
import com.section.model.EntryAdapter;
import com.section.model.Item;
import com.section.model.SectionItem;
import com.section.model.Title;
import com.section.model.Wether;


public class MainActivity extends ListActivity {

	ArrayList<Item> items = new ArrayList<Item>();
	JSONArray products = null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 new LongOperation().execute();
		
		
		
		
	/************************/	
		
		
		
		
	}
	private class LongOperation extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... params) {
            
                try {
                	UserFunctions func = new UserFunctions();
            		JSONObject json = func.selectalldepartments();
            		// dep = dep.replace("\\/", "/");

            		// Check your log cat for JSON reponse
            		Log.d("All Products: ", json.toString());

            		try {
            			// Getting Array of Products
            			products = json.getJSONArray("user");

            			// looping through All Products
            			for (int i = 0; i < products.length(); i++) {
            				JSONObject c = products.getJSONObject(i);

            				// Storing each json item in variable
            				String id = c.getString("id");
            				String name = c.getString("name");
            				String city = c.getString("city");
            				String image = c.getString("image");
            				image = image.replace("\\/", "/");
            				String checkboxtext = c.getString("checkboxtext");
            				items.add(new Title(name));
            				items.add(new Title(city));
            				items.add(new Wether(image));
                  			items.add(new CheckBoxes(checkboxtext));
            				
            				
            				Log.d("id", id);
            				Log.d("name", name);
            				Log.d("city", city);
            				Log.d("image", image);
            				Log.d("checkboxtext", checkboxtext); // Log.d("id",id);

            				Thread.sleep(500);

            			}

            		} catch (Exception e) {
            		}
                	Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
        	EntryAdapter adapter = new EntryAdapter(MainActivity.this, items);

    		setListAdapter(adapter);   
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		if (!items.get(position).isSection()) {
			if (items.get(position).isWether()) {
				Wether item = (Wether) items.get(position);

				Toast.makeText(this, "You clicked " + item.title,
						Toast.LENGTH_SHORT).show();
			} else {
				Title item = (Title) items.get(position);

				Toast.makeText(this, "You clicked " + item.name,
						Toast.LENGTH_SHORT).show();
			}

		}

		super.onListItemClick(l, v, position, id);
	}
}