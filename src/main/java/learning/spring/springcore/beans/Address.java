package learning.spring.springcore.beans;

public class Address {

	String area;
	String pincode;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [area=" + area + ", pincode=" + pincode + "]";
	}

}