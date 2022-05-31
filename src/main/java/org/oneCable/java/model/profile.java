package org.oneCable.java.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private Long Id;
	private String Name;
	private String Cnic;
	private String Cell;
	private String Email;
	private String Designation;
	private Timestamp Created;
	private Timestamp Modified;
	private boolean Deleted;
	
}
