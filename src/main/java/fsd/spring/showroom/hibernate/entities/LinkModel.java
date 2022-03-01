package fsd.spring.showroom.hibernate.entities;

public class LinkModel {
	private String link,rel;
	public LinkModel() {

}
	public LinkModel(String link, String rel) {
		super();
		this.link = link;
		this.rel = rel;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
}
	
	
