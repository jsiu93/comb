package com.xzh.comb.model;

import java.util.Date;

public class Downloads {
    private Integer id;

    private String session;
    
    private String ip;

    private Date timestamp;

    private String shasum;

    private String url;

    private String outfile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session == null ? null : session.trim();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getShasum() {
        return shasum;
    }

    public void setShasum(String shasum) {
        this.shasum = shasum == null ? null : shasum.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getOutfile() {
        return outfile;
    }

    public void setOutfile(String outfile) {
        this.outfile = outfile == null ? null : outfile.trim();
    }

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}