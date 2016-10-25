package com.hc.RXjava.Object;

import java.io.Serializable;

public class FilmInfo implements Serializable {

	private static final long serialVersionUID = -43616787418051361L;

	private String filmID;
	private String filmName;
	private String firstPlayTime;
	private String cinemaCount;
	private String grade;
	private String watchFilm;
	private String posterAddress;
	private String type; // 1 正在上映 2，即将上映，3预售
	private String nation;
	private String category;
	private String shortIntro;
	private String buyCount;
	private String nearShowCount;
	private String minposterAddress;
	private String sceneCount;// 场次数量
	private String topFlag; // “抢鲜看”置顶标识 1 置顶 0
	private String displayIndex;// 排序位置
	private String displayFlag; // 特惠标识 1-特惠 2-推荐 3-抢鲜看 4-显示优惠标签优惠

	public String getFilmID() {
		return filmID;
	}

	public void setFilmID(String filmID) {
		this.filmID = filmID;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getFirstPlayTime() {
		return firstPlayTime;
	}

	public void setFirstPlayTime(String firstPlayTime) {
		this.firstPlayTime = firstPlayTime;
	}

	public String getCinemaCount() {
		return cinemaCount;
	}

	public void setCinemaCount(String cinemaCount) {
		this.cinemaCount = cinemaCount;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getWatchFilm() {
		return watchFilm;
	}

	public void setWatchFilm(String watchFilm) {
		this.watchFilm = watchFilm;
	}

	public String getPosterAddress() {
		return posterAddress;
	}

	public void setPosterAddress(String posterAddress) {
		this.posterAddress = posterAddress;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getShortIntro() {
		return shortIntro;
	}

	public void setShortIntro(String shortIntro) {
		this.shortIntro = shortIntro;
	}

	public String getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(String buyCount) {
		this.buyCount = buyCount;
	}

	public String getNearShowCount() {
		return nearShowCount;
	}

	public void setNearShowCount(String nearShowCount) {
		this.nearShowCount = nearShowCount;
	}

	public String getMinposterAddress() {
		return minposterAddress;
	}

	public void setMinposterAddress(String minposterAddress) {
		this.minposterAddress = minposterAddress;
	}

	public String getSceneCount() {
		return sceneCount;
	}

	public void setSceneCount(String sceneCount) {
		this.sceneCount = sceneCount;
	}

	public String getTopFlag() {
		return topFlag;
	}

	public void setTopFlag(String topFlag) {
		this.topFlag = topFlag;
	}

	public String getDisplayIndex() {
		return displayIndex;
	}

	public void setDisplayIndex(String displayIndex) {
		this.displayIndex = displayIndex;
	}

	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

	@Override
	public String toString() {
		return "FilmInfo [filmID=" + filmID + ",filmName=" + filmName + ", firstPlayTime=" + firstPlayTime + ", cinemaCount=" + cinemaCount
				+ ", grade=" + grade + ", watchFilm=" + watchFilm + ", buyCount=" + buyCount + ", buyCount=" + buyCount
				+ ", minposterAddress=" + minposterAddress + "]";
	}

}
