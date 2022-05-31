package org.oneCable.java.restController;

import java.util.List;

import org.oneCable.java.businessLayer.dashboardManager;
import org.oneCable.java.businessLayer.managers;
import org.oneCable.java.dto.DashBoardItemsDTO;
import org.oneCable.java.dto.accountProfileDTO;
import org.oneCable.java.model.account;
import org.oneCable.java.model.roleaccessright;
import org.oneCable.java.utils.AppUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/accounts")
public class accountController {

	@Autowired
	managers managerObj;

	@Autowired
	dashboardManager dashboardManagerObj;

	@PostMapping("/authenticate")
	public account authenticateUser(@RequestBody account acct) throws Exception {
		{
			boolean isBadRequest = false;
			String message = "";
			account accountObj = null;
//		AccountProfileDTO dto = null;
//		Institute inst = new Institute();

			System.out.println(acct.getUsername());
			System.out.println(acct.getPassword());
			if (AppUtility.isEmpty(acct.getUsername()) && AppUtility.isEmpty(acct.getPassword())) {
				message = "UserName and password  can not be null";
				isBadRequest = true;
			} else { // if valid then save..
				try {

					accountObj = managerObj.getUserDetails(acct.getUsername(), acct.getPassword());
					System.out.println("Account Obj + " + accountObj.toString());
//				if(acct.getUsername().equals(accountObj.getUsername()) && acct.getPassword().equals(accountObj.getPassword())) {
//					System.out.println("authenticated");
//				}else {
//					System.out.println("Un - authenticated");
//				}

//				
//				if (act.isPresent()) {
//					if (act.get().isEnabled()) {
//						dto = umManager.authenticateUser(instituteCode,act.get(), acct.getPassword());
//						if (AppUtility.isEmpty(dto.getAccount())) {
//							isBadRequest = true;
//							message = "Incorrect Password !";
//						} else {
//							final UserDetails userDetails = jwtUserDetailsService
//									.loadUserByUsername(acct.getUserName());
//
//							final String token = jwtTokenUtil.generateToken(userDetails);
//
//							dto.setToken(token);
//						}
//					} else {
//						isBadRequest = true;
//						message = "Your account is diabled, for enable contact to administrator";
//					}
//				} else {// user not found..
//					isBadRequest = true;
//					message = "Invalid credentials!";
//				}
				} catch (Exception e) {
					throw new Exception(e);
				}
//		}
//		if (isBadRequest) {
//			logger.debug(message);
//			throw new DataValidationException(message);
//		} else {
//			return dto;
//		}

			}
			return accountObj;
		}

	}

	@GetMapping({ "/{operatorId}/roles/{roleId}/roleAccessRights" })
	public List<roleaccessright> getRoleAccessRightsByRoleId(@PathVariable Long operatorId, @PathVariable Long roleId)
			throws Exception {
		List<roleaccessright> list = null;
		try {
			list = managerObj.getRoleAccessRightsByOperatorIdAndRoleId(operatorId, roleId);
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	@PostMapping("/authenticateDTO")
	public accountProfileDTO authenticateUserDTO(@RequestBody account acct) throws Exception {
		{
			boolean isBadRequest = false;
			String message = "";
			account accountObj = null;

//		AccountProfileDTO dto = null;
//		Institute inst = new Institute();
			accountProfileDTO dto = null;
			if (AppUtility.isEmpty(acct.getUsername()) && AppUtility.isEmpty(acct.getPassword())) {
				message = "UserName and password  can not be null";
				isBadRequest = true;
			} else {
				try {
					accountObj = managerObj.getUserDetails(acct.getUsername(), acct.getPassword());
					System.out.println("Account Obj + " + accountObj.toString());
				} catch (Exception e) {
					throw new Exception(e);
				}

			}

			return dto;
		}
	}

	@GetMapping("/{id}/dashboard-items")
	public DashBoardItemsDTO getDashBoardItemsByAcctId(@PathVariable(required = true) long id) throws Exception {

		DashBoardItemsDTO dto = new DashBoardItemsDTO();
		try {

			dto = dashboardManagerObj.getDashBoardItemsByAcctId(id);
		} catch (Exception e) {
			throw  e;
		}
		return dto;
	}

}
