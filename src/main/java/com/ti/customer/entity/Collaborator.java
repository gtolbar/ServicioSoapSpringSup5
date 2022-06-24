package com.ti.customer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="collaborator",schema = "developer")
public class Collaborator implements Serializable {
	
	@Id
	@Column(name="collab_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long collabid;
	
	@Column(name="collab_name")
	private String collabname;
	
	@Column(name="collab_alias")
	private String collabalias;
	
	@Column(name="collab_password")
	private String collabpassword;
	
	@Column(name="collab_dni")
	private String collabdni;
	
	@Column(name="collab_email")
	private String collabemail;
	
	@Column(name="collab_image")
	private byte[] collabimage;

	public Long getCollabid() {
		return collabid;
	}

	public void setCollabid(Long collabid) {
		this.collabid = collabid;
	}

	public String getCollabname() {
		return collabname;
	}

	public void setCollabname(String collabname) {
		this.collabname = collabname;
	}

	public String getCollabalias() {
		return collabalias;
	}

	public void setCollabalias(String collabalias) {
		this.collabalias = collabalias;
	}

	public String getCollabpassword() {
		return collabpassword;
	}

	public void setCollabpassword(String collabpassword) {
		this.collabpassword = collabpassword;
	}

	public String getCollabdni() {
		return collabdni;
	}

	public void setCollabdni(String collabdni) {
		this.collabdni = collabdni;
	}

	public String getCollabemail() {
		return collabemail;
	}

	public void setCollabemail(String collabemail) {
		this.collabemail = collabemail;
	}

	public byte[] getCollabimage() {
		return collabimage;
	}

	public void setCollabimage(byte[] collabimage) {
		this.collabimage = collabimage;
	}
	
	

}
