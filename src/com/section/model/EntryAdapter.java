package com.section.model;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.section.imageloading.ImageLoader;
import com.section.list.R;

public class EntryAdapter extends ArrayAdapter<Item> {

	private Context context;
	private ArrayList<Item> items;
	private LayoutInflater vi;

	public EntryAdapter(Context context,ArrayList<Item> items) {
		super(context,0, items);
		this.context = context;
		this.items = items;
		vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		final Item i = items.get(position);
		if (i != null) {
			if(i.isSection()){
				SectionItem si = (SectionItem)i;
				v = vi.inflate(R.layout.list_item_section, null);

				v.setOnClickListener(null);
				v.setOnLongClickListener(null);
				v.setLongClickable(false);
				
				final TextView sectionView = (TextView) v.findViewById(R.id.list_item_section_text);
				sectionView.setText(si.getTitle() +" :P");
			}else if(i.isWether()){
				Wether ei = (Wether)i;
				v = vi.inflate(R.layout.list_item_entry, null);
				 ImageView title = (ImageView)v.findViewById(R.id.list_item_entry_title);
				 int loader = R.drawable.loader;
					ImageLoader imgLoader = new ImageLoader(context);
					imgLoader.DisplayImage(ei.title, loader, title);
				
			}
			else if(i.isTitle())
			{
				Title ei = (Title)i;
				v = vi.inflate(R.layout.list_item_contacts, null);
				final TextView name = (TextView)v.findViewById(R.id.list_item_name);
			//	final TextView contactNo = (TextView)v.findViewById(R.id.list_item_entry_contact);
				
				if (name != null) 
					name.setText(ei.name);
			}
			else
			{
				CheckBoxes ei = (CheckBoxes)i;
				v = vi.inflate(R.layout.list_item_checkboxes, null);
				CheckBox name = (CheckBox)v.findViewById(R.id.list_item_check);
			//	final TextView contactNo = (TextView)v.findViewById(R.id.list_item_entry_contact);
				
				
					name.setText(ei.check.toString());
				
			}
		}
		return v;
	}

}
