package org.oneCable.java.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class menuitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String key;
	
	private String iconName;

	private String title;

	private String url;

	private String navType;
	
	private int menuType;
	
	private Integer seqNo;
	
	private boolean isQuick;

	private Timestamp created;
	private Timestamp modified;

	public menuitem() {		}
	
}