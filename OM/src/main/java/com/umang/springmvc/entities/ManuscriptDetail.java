package com.umang.springmvc.entities;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ManuscriptDetail implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3219179371556595346L;
	private String manuscript_id;
	private String manuscript_title;
	private String author;
	private String manuscript_status;
	private String manuscript_statusDescription;
	private String manuscript_createdDate;
	private String manuscript_submitedDate;
	private String articleSubmitted;
	private String totalCount;
	private String issueName;
	private String articleType;			
	private String finalFilePath;
	private Integer issueMonth;
	private int issueYear;

	public String getManuscript_id() {
		return manuscript_id;
	}

	public void setManuscript_id(String manuscript_id) {
		this.manuscript_id = manuscript_id;
	}

	public String getManuscript_title() {
		return manuscript_title;
	}

	public void setManuscript_title(String manuscript_title) {
		this.manuscript_title = manuscript_title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getManuscript_status() {
		return manuscript_status;
	}

	public void setManuscript_status(String manuscript_status) {
		this.manuscript_status = manuscript_status;
	}

	public String getManuscript_statusDescription() {
		return manuscript_statusDescription;
	}

	public void setManuscript_statusDescription(String manuscript_statusDescription) {
		this.manuscript_statusDescription = manuscript_statusDescription;
	}

	public String getManuscript_createdDate() {
		return manuscript_createdDate;
	}

	public void setManuscript_createdDate(String manuscript_createdDate) {
		this.manuscript_createdDate = manuscript_createdDate;
	}

	public String getManuscript_submitedDate() {
		return manuscript_submitedDate;
	}

	public void setManuscript_submitedDate(String manuscript_submitedDate) {
		this.manuscript_submitedDate = manuscript_submitedDate;
	}

	public String getArticleSubmitted() {
		return articleSubmitted;
	}

	public void setArticleSubmitted(String articleSubmitted) {
		this.articleSubmitted = articleSubmitted;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public String getFinalFilePath() {
		return finalFilePath;
	}

	public void setFinalFilePath(String finalFilePath) {
		this.finalFilePath = finalFilePath;
	}

	
	public int getIssueYear() {
		return issueYear;
	}

	public void setIssueYear(int issueYear) {
		this.issueYear = issueYear;
	}

	public Integer getIssueMonth() {
		return issueMonth;
	}

	public void setIssueMonth(Integer issueMonth) {
		this.issueMonth = issueMonth;
	}

}
