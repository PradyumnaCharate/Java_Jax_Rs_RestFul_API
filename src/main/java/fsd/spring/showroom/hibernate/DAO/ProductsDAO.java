package fsd.spring.showroom.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fsd.spring.showroom.hibernate.entities.BrandEntity;
import fsd.spring.showroom.hibernate.entities.ProductEntity;

public class ProductsDAO {
	SessionFactory factory=new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(ProductEntity.class)
			.addAnnotatedClass(BrandEntity.class)
			.buildSessionFactory();

	public List<ProductEntity> getProductsByBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<ProductEntity> list = session.createQuery("from products where brandId = '"+brandId+"'").getResultList();
		return list;
	}

	public List<ProductEntity> getProductsByBrandAndCategory(int brandId, String category) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		String HQL="from products where brandId = '"+brandId+"' and productCategory = '"+category+"'";
		List<ProductEntity> list = session.createQuery(HQL).getResultList();
		
		return list;
	
	}


}
