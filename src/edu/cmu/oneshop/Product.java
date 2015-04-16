package edu.cmu.oneshop;

import java.util.List;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Product {
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	@Persistent
    private String name;
	
	@Persistent
    @Extension(vendorName="datanucleus", key="gae.unindexed", value="true")
    private String imageType;
	
	@Persistent
    private String image;
	
	@Persistent
    private String description;
	
	@Persistent
    private int minor;
	
	@Persistent
    private int major;
	
	@Persistent
    private double price;
	
	public Long getId(){
		return key.getId();
	}
	
	public String getName(){
		return name;
		
	}
	
	public String getImageType(){
		return imageType;
	}
	
	public String getImage(){
		
		
		return image;
	}
	
	public String getDescription(){
		return description;
	}
	
	public int getMinor(){
		return minor;
		
	}
	
	public int getMajor(){
		
		return major;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(Double price){
		this.price = price;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setImageType(String imageType){
		
		this.imageType = imageType;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setImage(String url){
		this.image = url;
	}
	
	public void setMajor(int major){
		this.major = major;
		
	}
	
	public void setMinor(int minor){
		this.minor = minor;
	}
	
	
}
