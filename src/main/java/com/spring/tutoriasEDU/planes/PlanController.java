package com.spring.tutoriasEDU.planes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tutoriasEDU.Curso.CursoDao;
import com.spring.tutoriasEDU.actividades.ActividadDao;
import com.spring.tutoriasEDU.enmarca.Enmarca;
import com.spring.tutoriasEDU.enmarca.EnmarcaDao;
import com.spring.tutoriasEDU.tutores.Tutor;
import com.spring.tutoriasEDU.tutores.TutorDAO;






@Controller
public class PlanController {	
	
	
	@Autowired
	PlanDao planDao;
	
	@Autowired
	CursoDao cursoDao;
	
	@Autowired
	TutorDAO tutorDao;
	
	@Autowired
	ActividadDao actividadDao;
	
	@Autowired
	EnmarcaDao enmarcaDao;
	
	@GetMapping("/plan")
	public ModelAndView tutorias() {

		ModelAndView model = new ModelAndView();
		model.setViewName("planes");
		
		List<Plan> planes = (List<Plan>) planDao.findAll();
		model.addObject("planes", planes);
		
		return model;
	}
	

	
	
	
	@GetMapping("/plan/{id}")
	public ModelAndView tutoria(@PathVariable long id) {
		
		Plan plan = planDao.findById(id).get();
		
		ModelAndView model = new ModelAndView();
		model.setViewName("plan");
		model.addObject("plan", plan);
		
		return model;
	}	
	
	
	
	
	
	@GetMapping("/plan/add")
	public ModelAndView addPlan() {
				
		ModelAndView model = new ModelAndView();
		Plan plan = new Plan();
		model.addObject("plan", plan);
		model.addObject("cursos", cursoDao.findAll());
		model.addObject("tutores", tutorDao.getTutoresNoEnlazados());
		model.addObject("actividad",actividadDao.findAll());
		
		model.setViewName("formPlan");
		
		return model;
	}	

	

	
	@GetMapping("/plan/edit/{id}")
	public ModelAndView editPlan(@PathVariable long id) {
				
		ModelAndView model = new ModelAndView();
		
		Optional<Plan> planazo = planDao.findById(id);
		
		if(planazo.isPresent()) {
			Plan plan = planazo.get();
			model.addObject("plan", plan);
			model.addObject("cursos", cursoDao.findAll());
			model.addObject("tutores", tutorDao.getTutoresNoEnlazados());
			model.addObject("actividad",actividadDao.findAll());
			model.setViewName("formPlan");
			planDao.save(plan);
		}
		else model.setViewName("redirect:/plan");	
		
		return model;
	}	
	
	
	
	
	
	@GetMapping("/plan/del/{id}")
	public ModelAndView delPlan(@PathVariable long id) {
				
		planDao.deleteById(id);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/plan");
		
		return model;
	}	
	
	
	
	
	
	@GetMapping("/plan/tutor/del/{idPlan}")
	public ModelAndView eliminarTutoriaTutor(@PathVariable long idPlan) {
		
		Optional<Plan> plan = planDao.findById(idPlan);
		if(plan.isPresent()) {
			
			Plan planazo = plan.get();
			Tutor tutor = planazo.getTutor();
			planazo.setTutor(null);
			tutor.setPlan(null);
			planDao.save(planazo);
		}
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/plan");		
		
		return model;
	}
	
	
	
	
	
	
	
	@PostMapping("/plan/save")
	public ModelAndView formTutoria(@ModelAttribute Plan plan) {
	
		Tutor tutor = plan.getTutor();
		tutor.setPlan(plan);
		
		Plan planGuardado = planDao.save(plan);
		
		for (Enmarca enmarca : plan.getEnmarcar()) {
	        enmarca.setPlan(planGuardado);
	        enmarcaDao.save(enmarca);
	    }
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/plan");	
		
		return model;
	}	
	
}
