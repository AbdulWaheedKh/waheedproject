package org.oneCable.java.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.oneCable.java.model.account;
import org.oneCable.java.model.menuitem;
import org.oneCable.java.utils.AppUtility;

public class accountProfileDTO implements BaseDTO<accountProfileDTO, account> {

	// account
	private String Username;
	private String Password;
	private Timestamp Created;
	private Timestamp Modified;
	private boolean Enable;
	
	// profile
	private String Name;
	private String Cnic;
	private String Cell;

	// role
	private Long Id;
	private String roleName;

	// operator
	private String OperatorName;
	private String OperatorCode;
	private String OfficeAddress;

	// List of menuitems
	List<menuitem> menuItems = new ArrayList<menuitem>();

	
	
	@Override
	public account convertToEntity() {
		account entity = new account();
		entity.setEnable(this.isEnable());
		entity.setCreated(this.getCreated());
		entity.setModified(this.getModified());
		entity.setUsername(this.getUsername());
		
	//	entity.setProfile(AppUtility.isEmpty(this.getName()));
		
		return entity;
	}

	@Override
	public void convertToDTO(account entity, boolean partialFill) {
	//	this.setId(entity.getId());

		this.setName(entity.getProfile().getName());
		this.setUsername(entity.getUsername());
		
	}

	@Override
	public accountProfileDTO convertToNewDTO(account e, boolean partialFill) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCnic() {
		return Cnic;
	}

	public void setCnic(String cnic) {
		Cnic = cnic;
	}

	public String getCell() {
		return Cell;
	}

	public void setCell(String cell) {
		Cell = cell;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getOperatorName() {
		return OperatorName;
	}

	public void setOperatorName(String operatorName) {
		OperatorName = operatorName;
	}

	public String getOperatorCode() {
		return OperatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		OperatorCode = operatorCode;
	}

	public String getOfficeAddress() {
		return OfficeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		OfficeAddress = officeAddress;
	}

	public List<menuitem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<menuitem> menuItems) {
		this.menuItems = menuItems;
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
	
	public boolean isEnable() {
		return Enable;
	}

	public void setEnable(boolean enable) {
		Enable = enable;
	}

	@Override
	public String toString() {
		return "accountProfileDTO [Username=" + Username + ", Password=" + Password + ", Name=" + Name + ", Cnic="
				+ Cnic + ", Cell=" + Cell + ", Id=" + Id + ", roleName=" + roleName + ", OperatorName=" + OperatorName
				+ ", OperatorCode=" + OperatorCode + ", OfficeAddress=" + OfficeAddress + ", menuItems=" + menuItems
				+ "]";
	}

}
