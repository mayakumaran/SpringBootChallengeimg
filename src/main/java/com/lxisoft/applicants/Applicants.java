package com.lxisoft.applicants;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Applicants {
	@Id
	private String username;
	private	String password;
	private String ph;
	private String address;
	
	@Lob
	private byte[] image;
	@Lob
	private byte[] pdf;
	
	public byte[] getPdf() {
		return pdf;
	}
	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public boolean equals(Object obj) {

		boolean equa = false;

		if (obj instanceof Applicants) {
			Applicants applicant = (Applicants) obj;
			if (this.username.equals(applicant.username)) {
				if (this.password == applicant.password) {
						equa = true;
				}
			} else {
				equa = false;
			}
		}
		return equa;

	}

	
}
