package org.oneCable.java.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class operator {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String OperatorName;
	private String OperatorCode;
	private String OfficeAddress;
	private String Email;

	private Timestamp Created;
	private Timestamp Modified;

	private boolean Deleted;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ProfileId")
	private profile profile;

}
