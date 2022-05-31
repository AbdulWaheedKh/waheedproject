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
public class account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String Username;

	private String Password;

	private Timestamp Created;

	private Timestamp Modified;


	private boolean Enable;

	@ManyToOne
	@JoinColumn(name = "RoleId")
	private role role;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ProfileId")
	private profile profile;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OperatorId")
	private operator operator;

}
