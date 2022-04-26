package jp.co.internous.bloom.model.form;

import java.io.Serializable;

public class SearchForm implements Serializable {

	private static final long serialVersionUID = 6437524697801251489L;

	private int categoryId;
	private String searchWords;
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setSearchWords(String searchWords) {
		this.searchWords = searchWords;
	}
	
	public String getSearhWords() {
		return searchWords;
	}
}
