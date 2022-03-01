package fsd.spring.showroom.hibernate.DAO;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import fsd.spring.showroom.hibernate.entities.BrandEntity;

public class BrandsDAO {
	SessionFactory factory=new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(BrandEntity.class)
			.buildSessionFactory();

	public List<BrandEntity> getBrands() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<BrandEntity> list = session.createQuery("from brands").getResultList();
		return list;
	}

	public void addBrand(BrandEntity brand) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		session.save(brand);
		session.getTransaction().commit();
		
	}

	public void updateBrand(BrandEntity brand) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		BrandEntity oldbrand=session.get(BrandEntity.class,brand.getBrandID());
		oldbrand.setBrandName(brand.getBrandName());
		session.getTransaction().commit();
		
		
	}
	public void deleteBrand(int brandId) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		BrandEntity brand=session.get(BrandEntity.class,brandId);
		session.delete(brand);
		session.getTransaction().commit();
		
		
		
	}

	public BrandEntity getBrandById(int brandId) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		return session.get(BrandEntity.class,brandId);
	}

	

}
