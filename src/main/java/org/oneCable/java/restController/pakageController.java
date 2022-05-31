package org.oneCable.java.restController;

import java.util.List;

import javax.validation.Valid;

import org.oneCable.java.businessLayer.managers;
import org.oneCable.java.exceptions.UserNotFoundException;
import org.oneCable.java.model.pakage;
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
public class pakageController {

	@Autowired
	managers managerObj;

	/**
	 * @return getAll
	 * @throws Exception
	 */
	@GetMapping("/getAllPakages")
	public List<pakage> getAllareas() throws Exception {

		List<pakage> pkg = null;
		pkg = managerObj.getAllpakages();

		return pkg;

	}

	/**
	 * @param create nArea
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/createNewPakage")
	public pakage createStudent(@Valid @RequestBody pakage pkg) throws Exception {
		Boolean isBadRequest = false;
		String message = "";

		if (!AppUtility.isEmpty(pkg.getId())) {
			message = "Id must be null";
			isBadRequest = true;
		} else {
			try {

				pkg = managerObj.saveSinglePakage(pkg);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}

		return pkg;

	}

	@PutMapping("/editPakage/{id}")
	public pakage editAreaById(@PathVariable Long id, @RequestBody pakage pkg) throws Exception {

		Boolean isBadRequest = false;
		String message = "";

		if (AppUtility.isEmpty(pkg.getId())) {
			message = "Id must not be null";
			isBadRequest = true;
		}
		pkg = managerObj.saveSinglePakage(pkg);

		return pkg;

	}

	@GetMapping("/getPakageById/{id}")
	public pakage getstudentById(@PathVariable Long id) throws Exception {

		pakage pkg = null;
		pkg = managerObj.getPakageById(id);
		if (pkg == null)
			throw new UserNotFoundException("Id > " + id);

		System.out.println("Pakage ID >> " + pkg.getId());

		return pkg;

	}

}
