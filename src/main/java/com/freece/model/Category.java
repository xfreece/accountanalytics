package com.freece.model;

import java.io.Serializable;

public class Category implements Serializable {
	private String categoryName;
	
	   public Category(String name)
	   {
	        this.categoryName = name;
	   }
	   public void setCategoryName(String name) {
	        this.categoryName = name;
	    }
	    public String getName() {
	        return categoryName;
	    }
}
