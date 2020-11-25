package tw.group4._35_.cms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Sponsership")
@Component
public class Sponsership {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="schoolName")
	private String schoolName;
	@Column(name="city")
	private String city;
	@Column(name="district")
	private String district;
	@Column(name="address")
	private String address;
	@Column(name="schoolType")
	private String schoolType;
	@Column(name="childAmount")
	private Double childAmount;
	@Column(name="activityTime")
	private Double activityTime;
	@Column(name="activityType")
	private String activityType;
	@Column(name="fee")
	private Double fee;
	@Column(name="announcementDate")
	private LocalDate announcementDate;
	@Column(name="contactInfo")
	private String contactInfo;
	
	public Sponsership() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSchoolType() {
		return schoolType;
	}
	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}
	public Double getChildAmount() {
		return childAmount;
	}
	public void setChildAmount(Double childAmount) {
		this.childAmount = childAmount;
	}
	public Double getActivityTime() {
		return activityTime;
	}
	public void setActivityTime(Double activityTime) {
		this.activityTime = activityTime;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public LocalDate getAnnouncementDate() {
		return announcementDate;
	}
	public void setAnnouncementDate(LocalDate announcementDate) {
		this.announcementDate = announcementDate;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	
}
