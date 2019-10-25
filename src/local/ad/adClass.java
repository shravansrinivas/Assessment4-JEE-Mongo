package local.ad;

public class adClass {
	private String category,adName,email,city,adDesc;
	private long contactNumber;
	private int adID,zip;
	public adClass(String adName,String category,String adDesc,long contactNumber,String email,String city, int zip ) {
		
		this.adName=adName;
		this.category=category;
		this.contactNumber=contactNumber;
		this.email=email;
		this.city=city;
		this.zip=zip;
		
		this.adDesc=adDesc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAdName() {
		return adName;
	}
	public void setAdName(String adName) {
		this.adName = adName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAdDesc() {
		return adDesc;
	}
	public void setAdDesc(String adDesc) {
		this.adDesc = adDesc;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public int getAdID() {
		return adID;
	}
	public void setAdID(int adID) {
		this.adID = adID;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}

}
