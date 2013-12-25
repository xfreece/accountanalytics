package com.freece.model;

/**
 * Created with IntelliJ IDEA.
 * User: stefan.hermelin
 * Date: 12/23/13
 * Time: 9:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Category {
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
