package DAO;

public class Information {
	private int id;
	private String description;
	private String brand;
	private String type;
	

	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Information(int id, String brand, String description,String type) {
		super();
		this.id = id;
		this.description = description;
		this.brand = brand;

		this.type = type;
	}
	
	
	

}