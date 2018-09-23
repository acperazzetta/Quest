package com.quest.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "record")
public class Record {

	@Id
	@Column(name = "pps_number", unique=true)
  private String ppsNumber;

  @NotNull
	@Column(name = "name")
	private String name;

	@Column(name = "dob")
	private String dob;

	@Column(name = "mobile_number")
  private String mobileNumber;
	
	@Column(name = "date_created")
	private Date created;

  public Record() {

  }

	public Record(String name, String ppsNumber, String dob, String mobileNumber, Date created) {
		super();
		this.name = name;
		this.ppsNumber = ppsNumber;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
		this.created = created;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPpsNumber() {
		return ppsNumber;
	}

	public void setPpsNumber(String ppsNumber) {
		this.ppsNumber = ppsNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Record record = (Record) o;
      return Objects.equals(name, record.getName()) &&
      			 Objects.equals(ppsNumber, record.getPpsNumber()) &&
          	 Objects.equals(dob, record.getDob()) &&
             Objects.equals(mobileNumber, record.getMobileNumber());
  }

  @Override
  public int hashCode() {
      return Objects.hash(name, ppsNumber, dob, mobileNumber, created);
  }	
}