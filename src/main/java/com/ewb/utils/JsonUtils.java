package com.ewb.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonUtils {

	public static final ObjectMapper mapper = new ObjectMapper();

	public static JsonNode getValueFromJSON(String inputJSON, String expectedValue)
			throws JsonProcessingException, IOException {

		if (StringUtils.isBlank(inputJSON)) {
			return null;
		}

		JsonNode node = mapper.readTree(inputJSON);

		JsonNode value = node.get(expectedValue);
		return value;
	}

	/**
	 * converts json string into map object
	 * 
	 * @param inputJSON
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static Map<String, Object> jsonToMap(String inputJSON)
			throws JsonParseException, JsonMappingException, IOException {
		TypeReference<Map<String, Object>> mapType = new TypeReference<Map<String, Object>>() {
		};
		return mapper.readValue(inputJSON, mapType);
	}

	public static Map<String, Object> convertObjectToMap(Object obj) {
		TypeReference<Map<String, Object>> mapType = new TypeReference<Map<String, Object>>() {
		};
		return mapper.convertValue(obj, mapType);
	}

	public static JSONObject getJsonObjectFromJsonArray(String input_array, int i) throws JSONException {

		JSONArray jsonarray = new JSONArray(input_array.replace('=', ':'));
		JSONObject obj = jsonarray.getJSONObject(i);
		return obj;
	}

	public static JSONObject getJsonObjectFromNestedJsonArray(String input_array, int i, String target_nested_json_key)
			throws JSONException {
		JSONObject obj = new JSONObject(input_array);
		JSONArray jsonarray = new JSONArray(obj.get("" + target_nested_json_key + "").toString());
		obj = jsonarray.getJSONObject(i);
		return obj;
	}

	public static ArrayList<String> getArrayListFromList(List<Object> list) {
		ArrayList<String> orderNumbers = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			orderNumbers.add(i, list.get(i).toString());
		}
		return orderNumbers;
	}
}
