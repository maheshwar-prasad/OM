package com.umang.springmvc.common;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;

public class HttpGatewayRequestInfo {
	private String requestUri;
	private String charset;
	private String mediaType;
	private String requestBody;
	private String methodType;
	private List<NameValuePair> queryStringParameters;
	private String queryString;
	private Map<String, String> headers = new HashMap<>();

	public HttpGatewayRequestInfo() {
	}

	public List<NameValuePair> getQueryStringParameters() {
		return queryStringParameters;
	}

	public void setQueryStringParameters(List<NameValuePair> queryStringParameters) {
		this.queryStringParameters = queryStringParameters;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getMethodType() {
		return methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

}
