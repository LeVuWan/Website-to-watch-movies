package com.poly.dto;

public class VideoLikedInfo {
	private Integer id;
	private String title;
	private String href;
	private Integer totalLike;
	
	public VideoLikedInfo() {
	}

	public VideoLikedInfo(Integer id, String title, String href, Integer totalLike) {
		this.id = id;
		this.title = title;
		this.href = href;
		this.totalLike = totalLike;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Integer getTotalLike() {
		return totalLike;
	}

	public void setTotalLike(Integer totalLike) {
		this.totalLike = totalLike;
	}

}
