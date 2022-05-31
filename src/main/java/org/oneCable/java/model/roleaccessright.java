package org.oneCable.java.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class roleaccessright {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private boolean ReadPriv;
	private boolean WritePriv;
	private boolean DeletePriv;

	private Timestamp Created;
	private Timestamp Modified;

	private Long OperatorId;

	private Long RoleId;

	// bi-directional many-to-one association to MenuItem
	@ManyToOne
	@JoinColumn(name = "MenuItemId")
	private menuitem menuItem;
	
	
	

	public roleaccessright() {
		super();
	}

	public roleaccessright(Long id, boolean readPriv, boolean writePriv, boolean deletePriv, Timestamp created,
			Timestamp modified, Long operatorId, Long roleId, menuitem menuItem) {
		super();
		Id = id;
		ReadPriv = readPriv;
		WritePriv = writePriv;
		DeletePriv = deletePriv;
		Created = created;
		Modified = modified;
		OperatorId = operatorId;
		RoleId = roleId;
		this.menuItem = menuItem;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public boolean isReadPriv() {
		return ReadPriv;
	}

	public void setReadPriv(boolean readPriv) {
		ReadPriv = readPriv;
	}

	public boolean isWritePriv() {
		return WritePriv;
	}

	public void setWritePriv(boolean writePriv) {
		WritePriv = writePriv;
	}

	public boolean isDeletePriv() {
		return DeletePriv;
	}

	public void setDeletePriv(boolean deletePriv) {
		DeletePriv = deletePriv;
	}

	public Timestamp getCreated() {
		return Created;
	}

	public void setCreated(Timestamp created) {
		Created = created;
	}

	public Timestamp getModified() {
		return Modified;
	}

	public void setModified(Timestamp modified) {
		Modified = modified;
	}

	public Long getOperatorId() {
		return OperatorId;
	}

	public void setOperatorId(Long operatorId) {
		OperatorId = operatorId;
	}

	public Long getRoleId() {
		return RoleId;
	}

	public void setRoleId(Long roleId) {
		RoleId = roleId;
	}

	public menuitem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(menuitem menuItem) {
		this.menuItem = menuItem;
	}

	@Override
	public String toString() {
		return "roleaccessright [Id=" + Id + ", ReadPriv=" + ReadPriv + ", WritePriv=" + WritePriv + ", DeletePriv="
				+ DeletePriv + ", Created=" + Created + ", Modified=" + Modified + ", OperatorId=" + OperatorId
				+ ", RoleId=" + RoleId + ", menuItem=" + menuItem + "]";
	}
	
}
