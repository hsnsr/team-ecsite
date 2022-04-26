package jp.co.internous.bloom.model.domain;

import java.sql.Timestamp;

public class MstCategory {

	private int id;
	private String categoryName;
	private String categoryDescription;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void getCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getCategoryDescription() {
		return categoryDescription;
	}
	
	public void getCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}
