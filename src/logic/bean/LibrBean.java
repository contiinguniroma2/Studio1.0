package logic.bean;

public class LibrBean extends UserBean {

	private String address;
	private String city;
	private int capacity;
	private int postiOccupati;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getPostiOccupati() {
		return postiOccupati;
	}

	public void setPostiOccupati(int postiOcc) {
		this.postiOccupati = postiOcc;
	}

	public void fillLibrBean(String address, String city, int capacity, int postiOccupati) {
		this.address = address;
		this.city = city;
		this.capacity = capacity;
		this.postiOccupati = postiOccupati;
	}

}
