package com.poly.entity;



import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "History")
public class History {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "userId", referencedColumnName = "id")
	@JsonIgnoreProperties(value = { "applications", "hiberbateLazyInitializer" })
	private User userId;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "videoId", referencedColumnName = "id")
	@JsonIgnoreProperties(value = { "applications", "hiberbateLazyInitializer" })
	private Video videoId;
	@Column(name = "viewDate")
	@CreationTimestamp
	private Timestamp viewDate;
	@Column(name = "isLiked")
	private Boolean isLiked;
	@Column(name = "likedDate")
	@CreationTimestamp
	private Timestamp likedDate;

	public History() {
		// TODO Auto-generated constructor stub
	}

	public History(Integer id, User userId, Video videoId, Timestamp viewDate, Boolean isLiked, Timestamp likedDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.videoId = videoId;
		this.viewDate = viewDate;
		this.isLiked = isLiked;
		this.likedDate = likedDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Video getVideoId() {
		return videoId;
	}

	public void setVideoId(Video videoId) {
		this.videoId = videoId;
	}

	public Timestamp getViewDate() {
		return viewDate;
	}

	public void setViewDate(Timestamp viewDate) {
		this.viewDate = viewDate;
	}

	public Boolean getIsLiked() {
		return isLiked;
	}

	public void setIsLiked(Boolean isLiked) {
		this.isLiked = isLiked;
	}

	public Timestamp getLikedDate() {
		return likedDate;
	}

	public void setLikedDate(Timestamp likedDate) {
		this.likedDate = likedDate;
	}

}
