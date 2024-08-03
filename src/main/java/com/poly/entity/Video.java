package com.poly.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Videos")
public class Video {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "title")
	private String title;
	@Column(name = "href")
	private String href;
	@Column(name = "poster")
	private String poster;
	@Column(name = "views")
	private Integer views;
	@Column(name = "shares")
	private Integer share;
	@Column(name = "description")
	private String description;
	@Column(name = "isActive")
	private Boolean isActive;

	public Video() {
		// TODO Auto-generated constructor stub
	}

	public Video(Integer id, String title, String href, String poster, Integer views, Integer share, String description,
			Boolean isActive) {
		super();
		this.id = id;
		this.title = title;
		this.href = href;
		this.poster = poster;
		this.views = views;
		this.share = share;
		this.description = description;
		this.isActive = isActive;
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

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getShare() {
		return share;
	}

	public void setShare(Integer share) {
		this.share = share;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
