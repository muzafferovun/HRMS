package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SectorPositionService;

import kodlamaio.hrms.core.results.AllDataResult;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorDataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;

import kodlamaio.hrms.entities.concretes.SectorPosition;


@RestController
@RequestMapping("/api/sectorPositions")
public class SectorPositionController {
	private SectorPositionService sectorPositionService;
	@Autowired
	public SectorPositionController(SectorPositionService sectorPositionService) {
		super();
		this.sectorPositionService=sectorPositionService;
	}
	@GetMapping("/getall")
	public DataResult<List<SectorPosition>> getAll(){
		return this.sectorPositionService.getAll();
	}
	@PostMapping("/add")
	public List<Result> add(@RequestBody SectorPosition sectorPosition) {
		return this.sectorPositionService.add(sectorPosition);
	}
	
}
