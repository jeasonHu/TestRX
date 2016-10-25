package com.hc.RXjava.Object;

import java.io.Serializable;

public class ResultAd implements Serializable {
	private String result;
	private String cityID;
	private String actionType;//1:广告  2:活动
	private String timeNow;
	private String adSeq;
	
	private String myType;//区分  0、广告        1、 背景
	
	public String getAdSeq() {
		return adSeq;
	}

	public void setAdSeq(String adSeq) {
		this.adSeq = adSeq;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCityID() {
		return cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}


	public String getTimeNow() {
		return timeNow;
	}

	public void setTimeNow(String timeNow) {
		this.timeNow = timeNow;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getMyType() {
		return myType;
	}

	public void setMyType(String myType) {
		this.myType = myType;
	}

	@Override
	public String toString() {
		//return super.toString();
		return "FilmInfo [cityID=" + cityID + ",actionType=" + actionType + ", adSeq=" + adSeq + ", myType=" + myType + "]";
	}
}
