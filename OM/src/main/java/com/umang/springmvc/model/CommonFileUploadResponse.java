package com.umang.springmvc.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//import io.swagger.annotations.ApiModel;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "common_file_upload_response")
@JsonPropertyOrder
//@ApiModel(description = "A response class responde back to request")
public class CommonFileUploadResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7968264998170633404L;

	@JsonProperty("file_name")
	private String fileName;

	@JsonProperty("file_download_uri")
	private String fileDownloadUri;

	@JsonProperty("file_key")
	private String fileKey;

	public CommonFileUploadResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommonFileUploadResponse(String fileName, String fileDownloadUri, String fileKey) {
		super();
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileKey = fileKey;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileKey() {
		return fileKey;
	}

	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}

	@Override
	public String toString() {
		return "CommonFileUploadResponse [fileName=" + fileName + ", fileDownloadUri=" + fileDownloadUri + ", fileKey="
				+ fileKey + "]";
	}

}
