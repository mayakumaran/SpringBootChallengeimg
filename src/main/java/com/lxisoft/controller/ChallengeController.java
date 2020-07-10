package com.lxisoft.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.applicants.Applicants;
import com.lxisoft.applicants.*;

import com.lxisoft.repo.ChallengeRepo;

@RestController
public class ChallengeController {
	
	@Autowired
	ChallengeRepo repo;

	@RequestMapping("/home")
	public ModelAndView register() {

		return new ModelAndView("Home");
	}

	@RequestMapping(value = "/save",method=RequestMethod.POST, consumes = "multipart/form-data")
	public ModelAndView test(ModelMap map, String username, String password, String ph, String address,MultipartFile file1,MultipartFile file2) {
		Applicants appli = new Applicants();
		appli.setUsername(username);
		appli.setPassword(password);
		appli.setPh(ph);
		appli.setAddress(address);
	
		try {
			appli.setImage(file1.getBytes());
			appli.setPdf(file2.getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		}
		//appli.getImage().toString();
		repo.save(appli);
		map.put("applicant", appli);
		return new ModelAndView("loginview");
	}

	@RequestMapping(value = "/personaldata/{username}")
	public ModelAndView login(ModelMap map, @PathVariable("username") String username) {
		Applicants appli = repo.findOne(username);	
		map.put("applicant", appli);
		return new ModelAndView("loginview");
	
	}

	@RequestMapping(value = "/img/{username}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage(@PathVariable("username") String username) {
		Applicants applicant = repo.findOne(username);
		return applicant.getImage();
	}
	
	@RequestMapping(value = "/pdf/{username}", produces = MediaType.APPLICATION_PDF_VALUE)
	public byte[] getPdf(@PathVariable("username") String username) {
		Applicants applicant = repo.findOne(username);
		return applicant.getPdf();
	}

	@RequestMapping("/show/{pageno}")
	public ModelAndView showUser(ModelMap map,@PathVariable("pageno") int pageno) {
		
		PageRequest request=new PageRequest(pageno-1,2);
		
		List list = repo.findAll(request).getContent();
	
		map.put("user",list);
		return new ModelAndView("alreadyreg");
	}

	@RequestMapping(value="/validateLogin",method=RequestMethod.POST)
	public ModelAndView validateUser(ModelMap map, String username, String password) {
		ModelAndView view = null;
		Applicants appli=null;
		
		try{
		 appli = repo.findOne(username);
		 
		 if (password.equals(appli.getPassword())) {
				map.put("applicant", appli);
				view = new ModelAndView("loginview");
			} else {
				map.put("message","Invalid password");
				view = new ModelAndView("warningPage");
			}
		}catch(NullPointerException np){
			map.put("message","Invalid username");
			view=new ModelAndView("warningPage");
		}
		
		return view;
	}
	
	@RequestMapping(value="/update/{username}" )
	public ModelAndView update(@PathVariable("username") String username,ModelMap map) {
	Applicants appli = repo.findOne(username);
		map.put("user", appli);
		return new ModelAndView("edit");
	}
	@RequestMapping("/delete/{username}")
	public ModelAndView deleteUser(@PathVariable("username") String username,ModelMap map){
		repo.delete(username);
		map.put("message","DELETED USER");
		return new ModelAndView("warningPage");
	}
	
	@RequestMapping(value="/qrReader" ,method=RequestMethod.POST, consumes = "multipart/form-data")
	public Patient getUser(MultipartFile file) throws JAXBException, IllegalStateException, IOException {
	
		/*File filexml =new File(file.getOriginalFilename());
		filexml.createNewFile();
				file.transferTo(filexml);*/
		 File convFile = new File(file.getOriginalFilename());
		    convFile.createNewFile(); 
		    FileOutputStream fos = new FileOutputStream(convFile); 
		    fos.write(file.getBytes());
		   
		JAXBContext jaxbContext = JAXBContext.newInstance(Patient.class);
		
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		Patient patient = (Patient) jaxbUnmarshaller.unmarshal(convFile);
		 fos.close(); 
		return patient;

	}

	
}
