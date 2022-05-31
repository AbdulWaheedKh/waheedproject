package org.oneCable.java.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class pakage {

	   @Id 
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private Long Id;
	   
	   private String Name;
	   
	   private String Description;
	   
	   private boolean IsActive;
	   
	   private Timestamp Created;

	   private Timestamp Modified;
	   
	   private boolean Deleted;
}
