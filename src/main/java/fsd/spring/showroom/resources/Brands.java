package fsd.spring.showroom.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import fsd.spring.showroom.hibernate.entities.BrandEntity;
import fsd.spring.showroom.hibernate.entities.LinkModel;
import fsd.spring.showroom.hibernate.entities.ProductEntity;
import fsd.spring.showroom.services.BrandsService;
import fsd.spring.showroom.services.ProductsService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriInfo;


@Path("/showroom/brands")
public class Brands {
	BrandsService service=new BrandsService();
	ProductsService productsService=new ProductsService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<BrandEntity> getBrands() {
		List<BrandEntity> list= service.getBrands(); 
		return list;
	}
	
	@GET
	@Path("/{brandId}")
	@Produces(MediaType.APPLICATION_JSON)	
	public BrandEntity getBrandById(@PathParam("brandId") int brandId,@Context UriInfo uri) {
		BrandEntity brand = service.getBrandById(brandId); 
		if (brand == null ) {
			throw new NotFoundException();
		}
		else {
			LinkModel self=new LinkModel(uri.getAbsolutePath().toString(),"self");
			LinkModel products=new LinkModel(uri.getBaseUriBuilder()
					.path(Brands.class)
					.path(Brands.class,"getProductsByBrandAndCategory")
					.resolveTemplate("brandId", brandId)
					.toString(),"products");
			List<LinkModel> links=new ArrayList<>();
			links.add(self);
			links.add(products);
			brand.setLinks(links);
			
		}
		
		
		return brand;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postBrand(BrandEntity brand,@Context UriInfo uriInfo) {
		
		service.addBrand(brand);
		URI location=uriInfo.getAbsolutePathBuilder().path(Integer.toString(brand.getBrandID())).build();
		//if there is some error we can create errorpayload object and pass it with response as entity
		//we are returning custom response code and in entity we can return either object or any string like "ok posted"
		//return Response.status(Status.CREATED).entity(brand).build();
		return Response.created(location).entity(brand).build();
		
	}
	
	@PUT
	@Path("/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void putBrand(@PathParam("brandId") int brandId,BrandEntity brand) {
		brand.setBrandID(brandId);
		service.updateBrand(brand);
		
	}
	
	@DELETE
	@Path("/{brandId}")
	public void deleteBrand(@PathParam("brandId") int brandId) {
		service.deleteBrand(brandId); 
	}
	
	@GET
	@Path("/{brandId}/products")
	@Produces(MediaType.APPLICATION_JSON)	
	public List<ProductEntity> getProducts(@PathParam("brandId") int brandId,
			@QueryParam("category") String category,@QueryParam("start") int start,
			@QueryParam("end") int end) {
		List<ProductEntity> list;
		if (category != null) {
			list = productsService.getProductsByBrandAndCategory(brandId,category);
		}
		else {
			list= productsService.getProductsByBrand(brandId); 	
		}
		if (end > 0){
			list = list.subList(start, end);
		}
		return list;
		
		
		
	}

}
