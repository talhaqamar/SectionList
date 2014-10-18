package com.section.json;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONObject;

public class UserFunctions {

	private JSONParser jsonParser;

	private static String jsonURL = "http://androidftp.hostei.com/talha.php";

	// constructor
	public UserFunctions() {
		jsonParser = new JSONParser();
	}

	public JSONObject selectalldepartments() {
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject json = jsonParser.getJSONFromUrl(jsonURL, params);
		return json;
	}
}