package fsd.spring.showroom.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="products")
@Table(name="products")
public class ProductEntity {
	@Id
	@Column(name="productId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	@ManyToOne(targetEntity=BrandEntity.class)
	@JoinColumn(name="brandId")
	private BrandEntity brandEntity;
	@Column(name="productName")
	private String productName;
	@Column(name="productCategory")
	 private String productCategory;
	@Column(name="productCost")
	private String productCost;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public BrandEntity getBrandEntity() {
		return brandEntity;
	}
	public void setBrandEntity(BrandEntity brandEntity) {
		this.brandEntity = brandEntity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductCost() {
		return productCost;
	}
	public void setProductCost(String productCost) {
		this.productCost = productCost;
	}
	public ProductEntity() {

	}
	public ProductEntity(int productId, BrandEntity brandEntity, String productName, String productCategory, String productCost) {
		super();
		this.productId = productId;
		this.brandEntity = brandEntity;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productCost = productCost;
	}

}
