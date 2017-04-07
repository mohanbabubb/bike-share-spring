package com.bikeShare.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="shares_and_bookings")
public class SharesBooks implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer bike_id;
	
	@Column(name="share_date", nullable=false)
	private Date share_date;
	
	@NotEmpty
	@Column(name="notes", nullable=false)
	private String notes;
	
	@NotEmpty
	@Column(name="bookingstatus", nullable=false)
	private String bookingstatus;
	
	private Integer booked_by;
	
	@Column(name="booked_date", nullable=false)
	private Date booked_date;
	
	@NotEmpty
	@Column(name="creditstatus", nullable=false)
	private String creditstatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBike_id() {
		return bike_id;
	}

	public void setBike_id(Integer bike_id) {
		this.bike_id = bike_id;
	}

	public Date getShare_date() {
		return share_date;
	}

	public void setShare_date(Date share_date) {
		this.share_date = share_date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getBookingstatus() {
		return bookingstatus;
	}

	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}

	public Integer getBooked_by() {
		return booked_by;
	}

	public void setBooked_by(Integer booked_by) {
		this.booked_by = booked_by;
	}

	public Date getBooked_date() {
		return booked_date;
	}

	public void setBooked_date(Date booked_date) {
		this.booked_date = booked_date;
	}

	public String getCreditstatus() {
		return creditstatus;
	}

	public void setCreditstatus(String creditstatus) {
		this.creditstatus = creditstatus;
	}
	
	
	
}
