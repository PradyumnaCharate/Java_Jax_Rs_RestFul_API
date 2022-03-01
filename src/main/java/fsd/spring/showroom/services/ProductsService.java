package fsd.spring.showroom.services;

import java.util.List;

import fsd.spring.showroom.hibernate.DAO.ProductsDAO;
import fsd.spring.showroom.hibernate.entities.ProductEntity;

public class ProductsService {
	ProductsDAO dao=new ProductsDAO();

	public List<ProductEntity> getProductsByBrand(int brandId) {
		List<ProductEntity> productList=dao.getProductsByBrand(brandId);
		return productList;
	}

	public List<ProductEntity> getProductsByBrandAndCategory(int brandId, String category) {
		List<ProductEntity> productList=dao.getProductsByBrandAndCategory(brandId,category);
		return productList;
	}

}
