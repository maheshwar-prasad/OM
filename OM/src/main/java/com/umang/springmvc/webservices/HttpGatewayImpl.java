package com.umang.springmvc.webservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
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
import com.umang.springmvc.services.HttpGateway;

@Service("HttpGatewayImpl")
public class HttpGatewayImpl implements HttpGateway {
	private static final Logger log = LogManager.getLogger(HttpGatewayImpl.class);


	private int socketTimeout=7000;

	private int connectionTimeout=7000;

	@Override
	public String callGETService(HttpGatewayRequestInfo requestInfo) throws HttpCommunicationException {
		log.info("callGETService responseString API url :" + requestInfo.getRequestUri());
		CloseableHttpClient httpClient = getHttpClient();
		CloseableHttpResponse httpClientResponse = null;
		String responseString = null;

		try {

			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectionTimeout).build();
			HttpGet httpMethod = prepareHttpGetMethod(requestInfo);
			httpMethod.setConfig(requestConfig);
			//check if header is present, if yes then add
			if (requestInfo.getHeaders() != null && requestInfo.getHeaders().size() > 0) {
				for (String key : requestInfo.getHeaders().keySet()) {
					httpMethod.setHeader(key, requestInfo.getHeaders().get(key));
				}
			}
			httpClientResponse = httpClient.execute(httpMethod);
			log.info("callGETService FinalURL : " + httpMethod);
			//	log.info("callGETService httpClientResponse : " + httpClientResponse);
			if(httpClientResponse.getStatusLine().getStatusCode()==220) {
				responseString="220";
				return responseString;
			}
			if (isSuccessStatusCode(httpClientResponse.getStatusLine().getStatusCode())) {
				StringBuilder buffer = new StringBuilder();

				try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpClientResponse.getEntity().getContent(), Charset.forName(requestInfo.getCharset())))) {
					String dataLine = null;
					while ((dataLine = reader.readLine()) != null) {
						buffer.append(dataLine);
					}
					responseString = buffer.toString();
				}

			} else {
				responseString = "UnSuccessful";
				log.debug("Failed to receive expected response :" + httpClientResponse.getStatusLine() + ", Request Info :" + requestInfo + ", API Respose :" + httpClientResponse);
			}

			if (log.isInfoEnabled()) {
				log.info("Success : " + httpClientResponse.getStatusLine() + ", Request Info :" + requestInfo + ", API Respose :" + httpClientResponse);
			}
		} catch (IOException | URISyntaxException ioe) {
			throw new HttpCommunicationException("Unable to connect to " + requestInfo.getRequestUri() + " ", ioe);
		} finally {
			IOUtils.closeQuietly(httpClientResponse);
			IOUtils.closeQuietly(httpClient);
		}

		log.debug("callGETService responseString :" + responseString);
		return responseString;
	}

	@Override
	public String callPOSTService(HttpGatewayRequestInfo requestInfo) throws HttpCommunicationException {
		log.info("callPOSTService responseString API url :" + requestInfo.getRequestUri());
		CloseableHttpClient httpClient = getHttpClient();
		CloseableHttpResponse httpClientResponse = null;
		HttpPost httpMethod = null;
		String responseString = null;
		try {
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectionTimeout).build();
			httpMethod = prepareHttpPostMethod(requestInfo);
			httpMethod.setConfig(requestConfig);
			//	log.info(requestInfo.getQueryStringParameters().toString());

			if (requestInfo.getQueryStringParameters() != null && !requestInfo.getQueryStringParameters().isEmpty()) {
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(requestInfo.getQueryStringParameters(), Charset.forName(requestInfo.getCharset()));
				log.debug("Entity : " + entity);
				httpMethod.setEntity(entity);
			}
			//check if header is present, if yes then add
			if (requestInfo.getHeaders() != null && requestInfo.getHeaders().size() > 0) {
				for (String key : requestInfo.getHeaders().keySet()) {
					httpMethod.setHeader(key, requestInfo.getHeaders().get(key));
				}
			}
			httpClientResponse = httpClient.execute(httpMethod);

			if (isSuccessStatusCode(httpClientResponse.getStatusLine().getStatusCode())) {
				StringBuilder buffer = new StringBuilder();

				try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpClientResponse.getEntity().getContent(), Charset.forName(requestInfo.getCharset())))) {
					String dataLine = null;
					while ((dataLine = reader.readLine()) != null) {
						buffer.append(dataLine);
					}
					responseString = buffer.toString();
				}
			} else {
				responseString = "UnSuccessful";
				log.error("Failed to receive expected response :" + httpClientResponse.getStatusLine() + ", Request Info :" + requestInfo + ", API Respose :" + httpClientResponse);
			}

			log.debug("callURLPOSTService Response : " + responseString + ", Status Line : " + httpClientResponse.getStatusLine() + ", Request Info :" + requestInfo + ", API Respose :" + httpClientResponse);
		} catch (IOException ioe) {
			log.info("IOException in callPOSTService():" + ioe.getMessage());
			throw new HttpCommunicationException("Unable to connect to " + requestInfo.getRequestUri() + " ", ioe);
		} finally {
			IOUtils.closeQuietly(httpClientResponse);
			IOUtils.closeQuietly(httpClient);
		}

		log.debug("callPOSTService responseString :" + responseString);
		return responseString;
	}

	@Override
	public String callJsonPOSTService(HttpGatewayRequestInfo requestInfo) throws HttpCommunicationException {
		log.info("callJsonPOSTService responseString API url :" + requestInfo.getRequestUri());
		CloseableHttpClient httpClient = getHttpClient();
		CloseableHttpResponse httpClientResponse = null;
		HttpPost httpMethod = null;
		String responseString = null;
		try {
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectionTimeout).build();
			httpMethod = prepareHttpPostMethod(requestInfo);
			httpMethod.setConfig(requestConfig);

			if (StringUtils.isNotBlank(requestInfo.getRequestBody())) {
				StringEntity entity = new StringEntity(requestInfo.getRequestBody(), Charset.forName(requestInfo.getCharset()));
				log.debug("Entity : " + entity);
				entity.setContentType(requestInfo.getMediaType());
				httpMethod.setEntity(entity);
			}
			//check if header is present, if yes then add
			if (requestInfo.getHeaders() != null && requestInfo.getHeaders().size() > 0) {
				for (String key : requestInfo.getHeaders().keySet()) {
					httpMethod.setHeader(key, requestInfo.getHeaders().get(key));
				}
			}
			httpClientResponse = httpClient.execute(httpMethod);

			if (isSuccessStatusCode(httpClientResponse.getStatusLine().getStatusCode())) {
				StringBuilder buffer = new StringBuilder();

				try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpClientResponse.getEntity().getContent(), Charset.forName(requestInfo.getCharset())))) {
					String dataLine = null;
					while ((dataLine = reader.readLine()) != null) {
						buffer.append(dataLine);
					}
					responseString = buffer.toString();
				}

			} else {
				responseString = "UnSuccessful";
				log.error("Failed to receive expected response :" + httpClientResponse.getStatusLine() + ", Request Info :" + requestInfo + ", API Respose :" + httpClientResponse);
			}

			log.debug("callURLPOSTService Response : " + responseString + ", Status Line : " + httpClientResponse.getStatusLine() + ", Request Info :" + requestInfo + ", API Respose :" + httpClientResponse);
		} catch (IOException ioe) {
			throw new HttpCommunicationException("Unable to connect to " + requestInfo.getRequestUri() + " ", ioe);
		} finally {
			IOUtils.closeQuietly(httpClientResponse);
			IOUtils.closeQuietly(httpClient);
		}

		log.debug("callPOSTService responseString :" + responseString);
		return responseString;
	}

	@Override
	public String callJsonPUTService(HttpGatewayRequestInfo requestInfo) throws HttpCommunicationException {
		log.info("callJsonPUTService responseString API url :" + requestInfo.getRequestUri());
		CloseableHttpClient httpClient = getHttpClient();
		CloseableHttpResponse httpClientResponse = null;
		HttpPut httpMethod = null;
		String responseString = null;
		try {
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectionTimeout).build();
			httpMethod = prepareHttpPutMethod(requestInfo);
			httpMethod.setConfig(requestConfig);

			if (StringUtils.isNotBlank(requestInfo.getRequestBody())) {
				StringEntity entity = new StringEntity(requestInfo.getRequestBody(), Charset.forName(requestInfo.getCharset()));
				log.debug("Entity : " + entity);
				httpMethod.setEntity(entity);
			}
			//check if header is present, if yes then add
			if (requestInfo.getHeaders() != null && requestInfo.getHeaders().size() > 0) {
				for (String key : requestInfo.getHeaders().keySet()) {
					httpMethod.setHeader(key, requestInfo.getHeaders().get(key));
				}
			}
			httpClientResponse = httpClient.execute(httpMethod);

			if (isSuccessStatusCode(httpClientResponse.getStatusLine().getStatusCode())) {
				StringBuilder buffer = new StringBuilder();

				try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpClientResponse.getEntity().getContent(), Charset.forName(requestInfo.getCharset())))) {
					String dataLine = null;
					while ((dataLine = reader.readLine()) != null) {
						buffer.append(dataLine);
					}
					responseString = buffer.toString();
				}
			} else {
				responseString = "UnSuccessful";
				log.error("Failed to receive expected response :" + httpClientResponse.getStatusLine() + ", Request Info :" + requestInfo + ", API Respose :" + httpClientResponse);
			}

			log.debug("callURLPOSTService Response : " + responseString + ", Status Line : " + httpClientResponse.getStatusLine() + ", Request Info :" + requestInfo + ", API Respose :" + httpClientResponse);
		} catch (IOException ioe) {
			throw new HttpCommunicationException("Unable to connect to " + requestInfo.getRequestUri() + " ", ioe);
		} finally {
			IOUtils.closeQuietly(httpClientResponse);
			IOUtils.closeQuietly(httpClient);
		}

		log.debug("callPOSTService responseString :" + responseString);
		return responseString;
	}

	protected CloseableHttpClient getHttpClient() {
		return HttpClientBuilder.create().build();
	}

	private boolean isSuccessStatusCode(int statusCode) {
		return (statusCode >= HttpStatus.SC_OK && statusCode < HttpStatus.SC_MULTIPLE_CHOICES) ? true : false;
	}

	protected HttpGet prepareHttpGetMethod(HttpGatewayRequestInfo requestInfo) throws URISyntaxException {
		URI uri = new URIBuilder(requestInfo.getRequestUri()).setCharset(Charset.forName(requestInfo.getCharset())).build();
		if (requestInfo.getQueryStringParameters() != null && !requestInfo.getQueryStringParameters().isEmpty()) {
			uri = new URIBuilder(requestInfo.getRequestUri()).addParameters(requestInfo.getQueryStringParameters()).setCharset(Charset.forName(requestInfo.getCharset())).build();
		}

		return new HttpGet(uri);
	}

	protected HttpPost prepareHttpPostMethod(HttpGatewayRequestInfo requestInfo) {
		return new HttpPost(requestInfo.getRequestUri());
	}

	protected HttpPut prepareHttpPutMethod(HttpGatewayRequestInfo requestInfo) {
		return new HttpPut(requestInfo.getRequestUri());
	}

	protected HttpDelete prepareHttpDeleteMethod(HttpGatewayRequestInfo requestInfo) {
		return new HttpDelete(requestInfo.getRequestUri());
	}
}
