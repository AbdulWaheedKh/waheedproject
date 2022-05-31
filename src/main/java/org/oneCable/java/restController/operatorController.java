package org.oneCable.java.restController;

import org.oneCable.java.businessLayer.managers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class operatorController {
	@Autowired
	managers managerObj;
}
