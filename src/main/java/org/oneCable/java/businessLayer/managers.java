package org.oneCable.java.businessLayer;

import java.util.List;

import org.oneCable.java.model.account;
import org.oneCable.java.model.area;
import org.oneCable.java.model.menuitem;
import org.oneCable.java.model.pakage;
import org.oneCable.java.model.role;
import org.oneCable.java.model.roleaccessright;
import org.oneCable.java.repository.accountRepository;
import org.oneCable.java.repository.areaRepository;
import org.oneCable.java.repository.employeeRepository;
import org.oneCable.java.repository.menuitemRepository;
import org.oneCable.java.repository.operatorRepository;
import org.oneCable.java.repository.pakageRepository;
import org.oneCable.java.repository.profileRepository;
import org.oneCable.java.repository.roleAccessRightRepository;
import org.oneCable.java.repository.roleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class managers {
	
	@Autowired
	roleAccessRightRepository roleAccessRightRepositoryObj;
	
	@Autowired
	accountRepository accountRepositoryObj;
	
	@Autowired
	employeeRepository employeeRepositoryObj;
	
	@Autowired
	menuitemRepository menuitemRepositoryObj;
	
	@Autowired
	operatorRepository operatorRepositoryObj;
	
	@Autowired
	profileRepository profileRepositoryObj;
	
	@Autowired
	roleRepository roleRepositoryObj;
	
	@Autowired
	pakageRepository pakageRepositoryObj;
	
	@Autowired
	areaRepository areaRepositoryObj;
	
	
	

	/*  *******************************************************************
	 *		acct Contoller Methods 										   *				   
	 *  																   *
	 *  ********************************************************************/

	
	public List<roleaccessright> getRoleAccessRightsByOperatorIdAndRoleId(Long operatorId, Long roleId) {
		
		return roleAccessRightRepositoryObj.getRoleAccessRightsByOperatorIdANDRoleId(operatorId, roleId);
	}
	
	
	/*  *******************************************************************
	 *		acct Contoller Methods 										   *				   
	 *  																   *
	 *  ********************************************************************/

	public account getUserDetails(String Username , String Password) {
		return accountRepositoryObj.findAccountByUserNameAndPw(Username, Password);
	}
	
	/*  *******************************************************************
	 *		menu Contoller Methods 										   *				   
	 *  																   *
	 *  ********************************************************************/

	public List<menuitem> getAllmenus() {
		return menuitemRepositoryObj.getAllmenus();
	}

//	public role saveSingleRole(role saveRole) {
//
//		return roleRepositoryObj.save(saveRole);
//	}
//
//	public role getRoleById(Long id) {
//
//		return roleRepositoryObj.getRoleById(id);
//	}
	
	
	
	/*  *******************************************************************
	 *		Role Contoller Methods 										   *				   
	 *  																   *
	 *  ********************************************************************/

	public List<role> getAllRoles() {
		return roleRepositoryObj.getAllRoles();
	}

	public role saveSingleRole(role saveRole) {

		return roleRepositoryObj.save(saveRole);
	}

	public role getRoleById(Long id) {

		return roleRepositoryObj.getRoleById(id);
	}

	
	
	
	
	/*  *******************************************************************
	 *		Area Contoller Methods 										   *				   
	 *  																   *
	 *  ********************************************************************/

	public List<area> getAllStudent() {
		return areaRepositoryObj.getAllAreas();
	}

	public area saveSingleStudent(area savearea) {

		return areaRepositoryObj.save(savearea);
	}

	public area getAreaById(Long id) {

		return areaRepositoryObj.getareaById(id);
	}

	
	/*  *******************************************************************
	 *		pakage Contoller Methods 									   *				   
	 *  																   *
	 *  ********************************************************************/

	public List<pakage> getAllpakages() {
		return pakageRepositoryObj.getAllpakages();
	}

	public pakage saveSinglePakage(pakage savearea) {

		return pakageRepositoryObj.save(savearea);
	}

	public pakage getPakageById(Long id) {

		return pakageRepositoryObj.getpakageById(id);
	}



	

	/*  *******************************************************************
	 *		Std Contoller Methods 										   *				   
	 *  																   *
	 *  ********************************************************************/
	
	

 
	/**
	 * @param emp
	 * @return
	 */
//	public List<Employee> saveMultipleEmploye(List<Employee> emp) {
//
//		for (Employee employee : emp) {
//			if (AppUtility.isEmpty(employee.getId())) {
//				employeeRepositoryObj.save(employee);
//			}
//		}
//		return emp;
//	}
//


}
