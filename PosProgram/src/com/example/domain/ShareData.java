package com.example.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShareData {

	public static final Map<String, Object> MAP = new HashMap<>();

	public static final List<Object> LIST = new ArrayList<>();

	public static void saveAsMap(String key, Object object) {
		ShareData.MAP.put(key, object);
	}

	public static Object loadFromMap(String key) {
		return ShareData.MAP.get(key);
	}

}
