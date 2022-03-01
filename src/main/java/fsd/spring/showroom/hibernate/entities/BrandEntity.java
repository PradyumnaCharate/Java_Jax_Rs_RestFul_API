package fsd.spring.showroom.hibernate.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;



@Entity(name="brands")
@Table(name="brands")
public class BrandEntity {
	
	@Id
	//brandId is automatically generated if not sent with post so we must specify this otherwise returning value of
	//brand will have id as 0 although it is properly inserted in database with someid.
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="brandId")
	private int brandID;
	@Column(name="brandName")
	private String brandName;
	
	//Hateos principle link included
	@Transient
	private List<LinkModel> links;

	

	public List<LinkModel> getLinks() {
		return links;
	}

	public void setLinks(List<LinkModel> links) {
		this.links = links;
	}

	public int getBrandID() {
		return brandID;
	}

	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public BrandEntity(int brandID, String brandName) {
		this.brandID = brandID;
		this.brandName = brandName;
	}

	public BrandEntity() {
	}
	

}
