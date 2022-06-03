package org.oneCable.java.restController;

import java.util.List;

import javax.validation.Valid;

import org.oneCable.java.businessLayer.managers;
import org.oneCable.java.exceptions.UserNotFoundException;
import org.oneCable.java.model.area;
import org.oneCable.java.utils.AppUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/areaResource")
@SuppressWarnings("unchecked")
public class areaController {

	@Autowired
	managers managerObj;

	/**
	 * @return getAll
	 * @throws Exception
	 */
	@GetMapping("/getAllAreas")
	public List<area> getAllareas() throws Exception {

		List<area> areas = null;
		areas = managerObj.getAllAreas();

		return areas;
 
	}

	/**
	 * @param create nArea
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/createNewArea")
	public area createStudent(@RequestBody area student) throws Exception {
		Boolean isBadRequest = false;
		String message = "";
        System.out.println(" Area to string >>" +student.toString());
		if (!AppUtility.isEmpty(student.getId())) {
			message = "Id must be null";
			isBadRequest = true;
		} else {
			try {
				student.setCreated(AppUtility.getCurrentTimeStamp());
				student.setModified(AppUtility.getCurrentTimeStamp());
				student = managerObj.saveSingleStudent(student);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}

		return student;

	}

	@PutMapping("/editArea")
	public area editAreaById(@RequestBody area nArea) throws Exception {

		Boolean isBadRequest = false;
		String message = "";

		if (AppUtility.isEmpty(nArea.getId())) {
			message = "Id must not be null";
			isBadRequest = true;
		}
		nArea.setCreated(AppUtility.getCurrentTimeStamp());
		nArea.setModified(AppUtility.getCurrentTimeStamp());
		nArea = managerObj.saveSingleStudent(nArea);

		return nArea;

	}

	@GetMapping("/getAreaById/{id}")
	public area getstudentById(@PathVariable Long id) throws Exception {

		area nArea = null;
		nArea = managerObj.getAreaById(id);
		if (nArea == null)
			throw new UserNotFoundException("Id > " + id);

		System.out.println("Area ID >> " + nArea.getId());

		return nArea;

	}
	
	@DeleteMapping("/{id}")
	public Integer deleteAcademicYear(@PathVariable Long id) throws Exception
		//	throws CustomException, DataValidationException, PTPConstraintVoilationException
	{
		if (AppUtility.isEmpty(id)) {
			String message = "Id must not be null!";
			throw new Exception(message);
		}
		Integer count = null;
		try {
			count = managerObj.markAcademicYearAsDeletedById(id);
		} catch (Exception e) {
			throw new Exception(e);
		}

		return count;
	}
	
//	@DeleteMapping("/{id}")
//	public void DelEmpById(@PathVariable Long id) throws Exception {
//	
//		Employee employee = null;
////		try {
//		managerObj.deleteById(id);
//
//	}

	
}
