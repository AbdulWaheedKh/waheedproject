package org.oneCable.java.restController;

import java.util.List;

import org.oneCable.java.businessLayer.managers;
import org.oneCable.java.model.area;
import org.oneCable.java.model.menuitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/menu")
public class menuitemController {
	@Autowired
	managers managerObj;
	
	
	@GetMapping("/getAllmenu")
	public List<menuitem> getAllMenu() throws Exception {

		List<menuitem> menuitems = null;
		menuitems = managerObj.getAllmenus();

		return menuitems;

	}
}
