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
public class employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ProfileId")
	private profile profile;
	//private Long ProfileId;
	
	// bi-directional many-to-one association to Student
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OperatorId")
	private operator operator;

	//	private Long OperatorId;
	// bi-directional many-to-one association to Student
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AccountId")
	private account account;
	//private Long AccountId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PakageId")
	private pakage pakage;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RoleId")
	private role role;

	private boolean IsActive;

	private Timestamp Created;

	private Timestamp Modified;

	private boolean Deleted;

}
