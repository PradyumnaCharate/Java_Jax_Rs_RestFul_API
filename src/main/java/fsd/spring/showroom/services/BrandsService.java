package fsd.spring.showroom.services;

import java.util.List;

import fsd.spring.showroom.hibernate.DAO.BrandsDAO;
import fsd.spring.showroom.hibernate.entities.BrandEntity;

public class BrandsService {
	BrandsDAO DAO=new BrandsDAO();  

	public List<BrandEntity> getBrands() {
		List<BrandEntity> list= DAO.getBrands();
		return list;
	}
	
	public void deleteBrand(int brandId) {
		DAO.deleteBrand(brandId);
		
	}

	

	public void updateBrand(BrandEntity brand) {
		DAO.updateBrand(brand);
		
		
	}

	public void addBrand(BrandEntity brand) {
		DAO.addBrand(brand);
		
	}

	public BrandEntity getBrandById(int brandId) {
		BrandEntity brand = DAO.getBrandById(brandId); 
		return brand;
	}

}
