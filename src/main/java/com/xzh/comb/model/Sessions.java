package com.xzh.comb.model;

import java.util.Date;

public class Sessions {
    private String id;

    private Date starttime;

    private Date endtime;

    private Integer sensor;

    private String ip;

    private String termsize;

    private Clients client;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getSensor() {
        return sensor;
    }

    public void setSensor(Integer sensor) {
        this.sensor = sensor;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getTermsize() {
        return termsize;
    }

    public void setTermsize(String termsize) {
        this.termsize = termsize == null ? null : termsize.trim();
    }

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

    
}