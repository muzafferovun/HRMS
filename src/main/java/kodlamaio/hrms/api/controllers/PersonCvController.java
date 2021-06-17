package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.PersonCvService;

import kodlamaio.hrms.core.results.AllDataResult;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorDataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.entities.dtos.CvDto;
import kodlamaio.hrms.entities.dtos.PersonCvAddDto;
import kodlamaio.hrms.entities.dtos.PersonCvEducationAddDto;
import kodlamaio.hrms.entities.dtos.PersonCvEducationGetDto;
import kodlamaio.hrms.entities.dtos.PersonCvExperiencesAddDto;
import kodlamaio.hrms.entities.dtos.PersonCvExperiencesGetDto;
import kodlamaio.hrms.entities.dtos.PersonCvGetDto;
import kodlamaio.hrms.entities.dtos.PersonCvProfessionAddDto;
import kodlamaio.hrms.entities.dtos.PersonCvProfessionGetDto;

@RestController
@RequestMapping("/api/personCv")

public class PersonCvController {
	private PersonCvService personCvService;
	@Autowired
	public PersonCvController(PersonCvService personCvService) {
		this.personCvService=personCvService;
	}
	@GetMapping("/getAllCv")
	public DataResult<List<PersonCvGetDto>> getAll(){
		return this.personCvService.getAll();
	}
	@PostMapping("/addCv")
	public List<Result> add(@RequestBody PersonCvAddDto personCvAddDto) {
		return this.personCvService.addCv(personCvAddDto);
	}
	@GetMapping("/getCvProfessions")
	public DataResult<List<PersonCvProfessionGetDto>> getCvProfessions(@RequestParam int personCvId){
		return this.personCvService.getCvProfessions(personCvId);
	}
	@PostMapping("/addCvProfession")
	public List<Result> add(@RequestBody PersonCvProfessionAddDto personCvProfessionAddDto) {
		return this.personCvService.addCvProfession(personCvProfessionAddDto);
	}
	
	@PostMapping("/addCvExperiences")
	public List<Result> add(@RequestBody PersonCvExperiencesAddDto personCvExperiencesAddDto) {
		return this.personCvService.addCvExperiences(personCvExperiencesAddDto);
	}
	@GetMapping("/getCvExperiences")
	public DataResult<List<PersonCvExperiencesGetDto>> getCvExperiences(@RequestParam int personCvId){
		return this.personCvService.getCvExperiences(personCvId);
	}
	@GetMapping("/getCvEducation")
	public DataResult<List<PersonCvEducationGetDto>> getCvEducation(@RequestParam int educationCvId){
		return this.personCvService.getCvEducation(educationCvId);
	}
	@PostMapping("/addCvEducation")
	public List<Result> add(@RequestBody PersonCvEducationAddDto personCvEducationAddDto) {
		return this.personCvService.addCvEducation(personCvEducationAddDto);
	}
	@GetMapping("/getCv")
	public DataResult<CvDto> getCv(@RequestParam int personId,int cvId){
		return this.personCvService.getCv(personId,cvId);
	}

}
