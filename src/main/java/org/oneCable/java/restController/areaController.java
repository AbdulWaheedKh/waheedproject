package org.oneCable.java.restController;

import java.util.List;

import javax.validation.Valid;

import org.oneCable.java.businessLayer.managers;
import org.oneCable.java.exceptions.UserNotFoundException;
import org.oneCable.java.model.area;
import org.oneCable.java.utils.AppUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
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
		areas = managerObj.getAllStudent();

		return areas;

	}

	/**
	 * @param create nArea
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/createNewArea")
	public area createStudent(@Valid @RequestBody area student) throws Exception {
		Boolean isBadRequest = false;
		String message = "";

		if (!AppUtility.isEmpty(student.getId())) {
			message = "Id must be null";
			isBadRequest = true;
		} else {
			try {

				student = managerObj.saveSingleStudent(student);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}

		return student;

	}

	@PutMapping("/editArea/{id}")
	public area editAreaById(@PathVariable Long id, @RequestBody area nArea) throws Exception {

		Boolean isBadRequest = false;
		String message = "";

		if (AppUtility.isEmpty(nArea.getId())) {
			message = "Id must not be null";
			isBadRequest = true;
		}
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

	
}
