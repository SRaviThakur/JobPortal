package com.galaxe.rst;

import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	EmployeeService empService;
	private final String UPLOAD_DIRECTORY = "C:/Users/rsthakur/Spring";
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/register")
	public String register(Model model) {
		model.addAttribute("emp", new Employee());
		return "register";
	}

	@RequestMapping(value = "/registered", method = RequestMethod.POST)
	public ModelAndView registered(@Valid @ModelAttribute("emp") Employee emp, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("register");
		}

		empService.save(emp);
		return new ModelAndView("registered", "emp", emp);

	}

	@RequestMapping(value = "/login")
	public String login(Model model) {
		model.addAttribute("emp", new Employee());
		return "login";
	}

	@RequestMapping(value = "/loginEmployee", method = RequestMethod.POST)
	public ModelAndView login_(@RequestParam("id") int id, @RequestParam("password") String password,
			@ModelAttribute("emp") Employee emp, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		if ("false".equals(session.getAttribute("valid"))) {
			session.setAttribute("valid", "true");
			password = "";
			return new ModelAndView("login");
		} else if (empService.authenticate(id, password)) {
			session.setAttribute("id", id);
			session.setAttribute("emp", empService.getDetails(id));
			return new ModelAndView("redirect:Details");

		}
		mav.setViewName("login");
		mav.addObject("errorMsg", "User Name or Password is incorrect");
		return mav;
	}

	@RequestMapping(value = "/Details", method = RequestMethod.GET)
	public ModelAndView showDetails(HttpSession session) {
		session.setAttribute("valid", "true");
		Employee emp_ = (Employee) session.getAttribute("emp");
		if (emp_ == null)
			return new ModelAndView("login");
		session.setAttribute("emp", emp_);
		String skills = emp_.getSkill();
		System.out.println(skills);

		String skillArray[] = (skills.trim()).split("\\s");
		List<String> skillset = new ArrayList<String>();
		for (int i = 0; i < skillArray.length; i++) {
			skillset.add(skillArray[i]);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getDetails");
		mav.addObject("emp", emp_);
		return mav;
	}

	@RequestMapping(value = "/getDetails", method = RequestMethod.GET)
	public String showInfo(@ModelAttribute("emp") Employee emp, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("valid") == null)
			return "login";
		return "getDetails";
	}

	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public ModelAndView showInfo(HttpSession session) {

		if ("false".equals(session.getAttribute("valid")))
			return new ModelAndView("login");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getDetails");
		Employee emp = (Employee) session.getAttribute("emp");
		String skills = emp.getSkill();
		System.out.println(skills);

		String skillArray[] = (skills.trim()).split("\\s");
		List<String> skillset = new ArrayList<String>();
		for (int i = 0; i < skillArray.length; i++) {
			skillset.add(skillArray[i]);
		}
		mav.addObject("skill", skillset);

		return mav;
	}

	@RequestMapping(value = "/logout")
	public String invalidate(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		session = request.getSession();
		session.setAttribute("valid", "false");

		//
		if (model.containsAttribute("getDetails"))
			model.asMap().remove("getDetails");
		return "login";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(HttpSession session) {
		if ("false".equals(session.getAttribute("valid"))) {
			session.setAttribute("valid", "true");
			return new ModelAndView("login");
		}
		Employee emp_ = (Employee) session.getAttribute("emp");
		return new ModelAndView("updateDetails", "emp", emp_);

	}

	@RequestMapping(value = "/updateData", method = RequestMethod.POST)
	public ModelAndView update1(@Valid @ModelAttribute("emp") Employee emp, BindingResult result, HttpSession session) {
		if ("false".equals(session.getAttribute("valid"))) {
			return new ModelAndView("login");
		}
		if (result.hasErrors()) {
			return new ModelAndView("updateDetails", "emp", emp);
		}
		Employee emp1 = (Employee) session.getAttribute("emp");
		ModelAndView mav = new ModelAndView();
		session.setAttribute("emp", emp1);
		String skills = emp1.getSkill();

		String skillArray[] = skills.trim().split("\\s");
		List<String> skillset = new ArrayList<String>();
		for (int i = 0; i < skillArray.length; i++) {
			skillset.add(skillArray[i]);
		}
		emp1.setSkill(emp.getSkill());
		emp1.setAge(emp.getAge());
		emp1.setEmail(emp.getEmail());
		emp1.setFirstName(emp.getFirstName());
		emp1.setLastName(emp.getLastName());
		emp1.setMobileNumber(emp.getMobileNumber());
		emp1.setPassword(emp.getPassword());
		empService.update(emp1);

		return new ModelAndView("getDetails", "msga", "Details successfully updated");
	}

	@RequestMapping(value = "/upload")
	public String upload(Model model) {
		return "upload";
	}

	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public ModelAndView upload(HttpServletRequest request, HttpSession session) {

		if ("false".equals(session.getAttribute("valid"))) {
			session.setAttribute("valid", "true");
			return new ModelAndView("login");
		}
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		int count = 0;
		ModelAndView mav = new ModelAndView();
		mav.setViewName("uploaded");
		// process only if its multipart content

		if (isMultipart) {
			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				// Parse the request
				List<FileItem> multiparts = upload.parseRequest(request);
				String fileName = "";

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String name = new File(item.getName()).getName();
						fileName = FilenameUtils.getExtension(item.getName());
						if (fileName.equals("xls") || fileName.equals("xlsx") || fileName.equals("pdf")
								|| fileName.equals("docx")) {
							item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
							count++;
						} else {
							count = -1;
							break;

						}
					}
				}

				if (count > 0) {
					mav.addObject("message", "Your resume has been uploaded!");

				} else {
					mav.addObject("message",
							"This Servlet only handles file which are ecxel files or pdf or word files");

				}
			} catch (Exception e) {

				mav.addObject("message", "Resume Upload Failed due to " + e);
			}
		} else {
			mav.addObject("message", "This Servlet only handles file upload request");
		}
		return mav;
	}

}
