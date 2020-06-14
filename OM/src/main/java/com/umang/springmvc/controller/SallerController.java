package com.umang.springmvc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.client.SallerProfileClient;
import com.umang.springmvc.client.SortOrder;
import com.umang.springmvc.entities.AppUser;
import com.umang.springmvc.model.SallerProfileDto;
import com.umang.springmvc.model.SallerProfileResponse;
import com.umang.springmvc.model.SallerProfileResponses;

/**
 * 
 * @author deepak
 *
 */

@Controller
public class SallerController {

	private SallerProfileClient client = new SallerProfileClient();

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile(HttpServletRequest request, Model model)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		SallerProfileResponses responses = client.findAllSorted("first_name", SortOrder.ASC,
				(user == null ? null : user.getRouting()));
		List<SallerProfileDto> dtos = responses.getData();
		if (user.getUserType().equals("Client"))
			return new ModelAndView("clientprofile", "profile", dtos.size() > 0 ? dtos.get(0) : new SallerProfileDto());
		else
			return new ModelAndView("customerprofile", "profile",
					dtos.size() > 0 ? dtos.get(0) : new SallerProfileDto());
	}

	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public ModelAndView updateProfile(HttpServletRequest request, Model model, @RequestParam("saller-id") Integer id,
			@RequestParam("first-name") String firstName, @RequestParam("last-name") String lastName,
			@RequestParam("gst-no") String gstNo, @RequestParam("company-name") String companyName,
			@RequestParam("user-name") String userName, @RequestParam("password") String password,
			@RequestParam("address1") String address1, @RequestParam("address2") String address2,
			@RequestParam("city") String city, @RequestParam("state-name") String stateName,
			@RequestParam("state-gst-code") String stateGstCode, @RequestParam("pincode") String pincode,
			@RequestParam("cc-no") String ccNo, @RequestParam("email") String email,
			@RequestParam(value = "terms", required = false) MultipartFile file)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		File terms = null;
		SallerProfileResponse res = client.findById(id, (user == null ? null : user.getRouting()));
		FileOutputStream fileOutputStream = null;
		String path = request.getServletContext().getResource("static").getFile();
		ModelAndView andView = null;
		if (user.getUserType().equals("Client"))
			andView = new ModelAndView("redirect:clientdashboard");
		else
			andView = new ModelAndView("redirect:customerdashboard");
		try {
			SallerProfileDto dto = res.getData();
			dto.setAddress1(maskStringToNull(address1));
			dto.setAddress2(maskStringToNull(address2));
			dto.setCcNo(maskStringToNull(ccNo));
			dto.setCity(maskStringToNull(city));
			dto.setCompanyName(maskStringToNull(companyName));
			dto.setEmail(maskStringToNull(email));
			dto.setFirstName(maskStringToNull(firstName));
			dto.setGstNo(maskStringToNull(gstNo));
			dto.setLastName(maskStringToNull(lastName));
			dto.setPassword(maskStringToNull(password));
			dto.setPincode(maskStringToNull(pincode));
			dto.setStateGstCode(maskStringToNull(stateGstCode));
			dto.setStateName(maskStringToNull(stateName));
			client.update(dto, (user == null ? null : user.getRouting()));
			if (file != null && file.getSize() > 0) {
				terms = new File(path + "/img/item/" + file.getOriginalFilename());
				fileOutputStream = new FileOutputStream(terms);
				fileOutputStream.write(file.getBytes());
				fileOutputStream.flush();
				client.postTerms(id, terms, (user == null ? null : user.getRouting()));
				terms.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return andView;
	}

	/**
	 * @param String value
	 * @since 11 March 2019
	 *        <h1>This method masks an empty or null string into null</h1>
	 **/
	public static String maskStringToNull(String value) {
		if (value == null || value.trim().length() == 0)
			return null;
		else
			return value.trim();
	}
}
