package com.bikeShare.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="bikes")
public class Bikes implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name="modelname", unique=true, nullable=false)
	private String modelname;
	
	@NotEmpty
	@Column(name="type", nullable=false)
	private String type;
		
	@NotEmpty
	@Column(name="comments", nullable=false)
	private String comments;

	@NotEmpty
	@Column(name="conditionstatus", nullable=false)
	private String conditionstatus;

	@NotEmpty
	@Column(name="sharestatus", nullable=false)
	private String sharestatus;

	private Integer owner_id;
	
	@NotEmpty
	@Column(name="deletion_status", nullable=false)
	private String deletion_status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getConditionstatus() {
		return conditionstatus;
	}

	public void setConditionstatus(String conditionstatus) {
		this.conditionstatus = conditionstatus;
	}

	public String getSharestatus() {
		return sharestatus;
	}

	public void setSharestatus(String sharestatus) {
		this.sharestatus = sharestatus;
	}

	public Integer getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}

	public String getDeletion_status() {
		return deletion_status;
	}

	public void setDeletion_status(String deletion_status) {
		this.deletion_status = deletion_status;
	}

	
}
