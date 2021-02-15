package DAO;

public class Information {
	private int id;
	private String driver;
	private String marque;
	private String type;
	

	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Information(int id, String marque, String driver,String type) {
		super();
		this.id = id;
		this.driver = driver;
		this.marque = marque;

		this.type = type;
	}
	
	
	

}