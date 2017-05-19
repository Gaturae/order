package com.order.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="cg.yml")
public class YmlConfig {

	private Map<String, String> server = new HashMap<String, String>() ;
	private Map<String, String> http = new HashMap<String, String>() ;
	private Map<String, String> mvc = new HashMap<String, String>() ;
	private Map<String, String> datasource = new HashMap<String, String>() ;
	
	
	
	public Map<String, String> getServer() {
		return server;
	}
	public void setServer(Map<String, String> server) {
		this.server = server;
	}
	public Map<String, String> getHttp() {
		return http;
	}
	public void setHttp(Map<String, String> http) {
		this.http = http;
	}
	public Map<String, String> getMvc() {
		return mvc;
	}
	public void setMvc(Map<String, String> mvc) {
		this.mvc = mvc;
	}
	public Map<String, String> getDatasource() {
		return datasource;
	}
	public void setDatasource(Map<String, String> datasource) {
		this.datasource = datasource;
	}
}
