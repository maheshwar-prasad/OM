package com.umang.springmvc.services;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.umang.springmvc.common.HttpCommunicationException;
import com.umang.springmvc.common.HttpGatewayRequestInfo;

public interface HttpGateway {
	
	String callGETService(HttpGatewayRequestInfo requestInfo) throws HttpCommunicationException;

	String callPOSTService(HttpGatewayRequestInfo requestInfo) throws HttpCommunicationException;

	String callJsonPOSTService(HttpGatewayRequestInfo requestInfo) throws HttpCommunicationException;

	String callJsonPUTService(HttpGatewayRequestInfo requestInfo) throws HttpCommunicationException;
}
