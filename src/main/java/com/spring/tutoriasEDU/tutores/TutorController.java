package com.spring.tutoriasEDU.tutores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.tutoriasEDU.planes.PlanDao;

@Controller
public class TutorController {

	
	@Autowired
	TutorDAO tutorDAO;
	
	@Autowired
	PlanDao tutoriaDAO;
	

}
