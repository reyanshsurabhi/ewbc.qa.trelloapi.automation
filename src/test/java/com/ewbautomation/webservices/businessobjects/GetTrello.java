package com.ewbautomation.webservices.businessobjects;

public class GetTrello {
	
	private String id;
	private String name;
	private String desc;
	private boolean closed;
	private String url;
	private boolean descData;
	private String idOrganization;
	private boolean pinned;
	private String shortUrl;
	private Prefers prefs;
	private LabelNames labelNames;
	private Limits limits;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIdOrganizarion() {
		return idOrganization;
	}

	public void setIdOrganization(String idOrganization) {
		this.idOrganization = idOrganization;
	}

	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public boolean getDescData() {
		return descData;
	}

	public void setDescData(boolean descData) {
		this.descData = descData;
	}

	public boolean getClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getPinned() {
		return pinned;
	}

	public void setPinned(boolean pinned) {
		this.pinned = pinned;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public Prefers getPrefs() {
		return prefs;
	}

	public void setPrefs(Prefers prefs) {
		this.prefs = prefs;
	}

	public LabelNames getLabelNames() {
		return labelNames;
	}

	public void setLabelNames(LabelNames labelNames) {
		this.labelNames = labelNames;
	}

	public Limits getLimits() {
		return limits;
	}

	public void setLimits(Limits limits) {
		this.limits = limits;
	}

}
