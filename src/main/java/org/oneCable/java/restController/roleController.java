package org.oneCable.java.restController;

import java.util.List;

import javax.validation.Valid;

import org.oneCable.java.businessLayer.managers;
import org.oneCable.java.exceptions.UserNotFoundException;
import org.oneCable.java.model.role;
import org.oneCable.java.utils.AppUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/role")
@RestController
public class roleController {

	@Autowired
	managers managerObj;

	/**
	 * @return getAll
	 * @throws Exception
	 */
	
//	@PostMapping("/multipleNewEmp")
//	public List<Employee> createMultipleEmp(@RequestBody List<Employee> emp) throws Exception {
//		Boolean isBadRequest = false;
//		String message = "";
//
//		if (emp.size() < 0 ) {
//			message = "List Size is Zero";
//			isBadRequest = true;
//		}else {
//			try {
//			
//				emp = (List<Employee>) managerObj.saveMultipleEmploye(emp);
//			} catch (Exception e) {
//				throw new Exception(e.getMessage());
//			}
//		}
//		
//		return emp;
//
//	}
	
//	@DeleteMapping("/{id}")
//	public void DelEmpById(@PathVariable Long id) throws Exception {
//	
//		Employee employee = null;
////		try {
//		emprepo.deleteById(id);
//
//	}
	
	@GetMapping("/getAllRoles")
	public List<role> getAllareas() throws Exception {

		List<role> roles = null;
		roles = managerObj.getAllRoles();

		return roles;

	}

	/**
	 * @param create nArea
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/createNewRole")
	public role createStudent(@Valid @RequestBody role role) throws Exception {
		Boolean isBadRequest = false;
		String message = "";

		if (!AppUtility.isEmpty(role.getId())) {
			message = "Id must be null";
			isBadRequest = true;
		} else {
			try {

				role = managerObj.saveSingleRole(role);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}

		return role;

	}

	@PutMapping("/editRole/{id}")
	public role editAreaById(@PathVariable Long id, @RequestBody role nRole) throws Exception {

		Boolean isBadRequest = false;
		String message = "";

		if (AppUtility.isEmpty(nRole.getId())) {
			message = "Id must not be null";
			isBadRequest = true;
		}
		nRole = managerObj.saveSingleRole(nRole);

		return nRole;

	}

	@GetMapping("/getRoleById/{id}")
	public role getstudentById(@PathVariable Long id) throws Exception {

		role nRole = null;
		nRole = managerObj.getRoleById(id);
		if (nRole == null)
			throw new UserNotFoundException("Id > " + id);

		System.out.println("Area ID >> " + nRole.getId());

		return nRole;

	}
	
}
