package com.cerberus.server.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonDataBinderFactory {

	private final static ObjectMapper defaultMapper = new ObjectMapper();

	public static <T> ObjectReader getReader(Class<T> type) {
		return defaultMapper.reader(type);
	}

	public static <T> ObjectWriter getWriter(Class<T> type) {
		return defaultMapper.writerWithType(type);
	}

}
