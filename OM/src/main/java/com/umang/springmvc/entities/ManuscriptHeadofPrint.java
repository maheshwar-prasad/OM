package com.umang.springmvc.entities;

import java.io.Serializable;
import java.util.List;

public class ManuscriptHeadofPrint implements Serializable {

	private String articleType;
	private List<ManuscriptDetail> manuscripts;
	private String issueCreated;

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public List<ManuscriptDetail> getManuscripts() {
		return manuscripts;
	}

	public void setManuscripts(List<ManuscriptDetail> manuscripts) {
		this.manuscripts = manuscripts;
	}

	public String getIssueCreated() {
		return issueCreated;
	}

	public void setIssueCreated(String issueCreated) {
		this.issueCreated = issueCreated;
	}
}
