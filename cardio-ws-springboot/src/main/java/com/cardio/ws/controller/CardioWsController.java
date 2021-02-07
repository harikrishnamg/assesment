package com.cardio.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardio.ws.model.Category;
import com.cardio.ws.model.CategoryModel;
import com.cardio.ws.model.Challange;
import com.cardio.ws.model.ChallangeModel;
import com.cardio.ws.model.ChallangeResults;
import com.cardio.ws.service.CategoryService;
import com.cardio.ws.service.ChallangeService;

@RestController
@RequestMapping(path="/cardiows")
public class CardioWsController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ChallangeService challangeService;
	
	@RequestMapping(path="/findByName/{category}",method = RequestMethod.GET)
	public ResponseEntity<Category> findChallengeByCategory(@PathVariable("category") String category){
		
	Category catModel =	categoryService.findByName(category);
	
		return new ResponseEntity<Category>(catModel, HttpStatus.OK);
	}

	@RequestMapping(path="/findByTitle/{chtitle}",method = RequestMethod.GET)
	public ResponseEntity<Challange> findChallengeByTitle(@PathVariable("chtitle") String chtitle){
		Challange cModel =	challangeService.findByTitle(chtitle);
		//ChallangeModel chModel = getChllangeResults(chtitle);
		return new ResponseEntity<Challange>(cModel, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/challangeResult", method = RequestMethod.POST,produces = "application/json")
	 public ResponseEntity<ChallangeResults> createEmployee(@RequestBody ChallangeResults chResult) {
	  HttpHeaders headers = new HttpHeaders();
	 if (chResult == null) {
	   return new ResponseEntity<ChallangeResults>(HttpStatus.BAD_REQUEST);
	  }
	  challangeService.insertChallangeData(chResult);
	  headers.add("Challange Created  - ", String.valueOf(chResult.getRecID()));
	  return new ResponseEntity<ChallangeResults>(chResult, headers, HttpStatus.CREATED);
	 }
	
	@RequestMapping(value = "/challangeResult/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<ChallangeResults> updateChallangeResult(@PathVariable("id") Long chalID, @RequestBody ChallangeResults chalResult) {
	  HttpHeaders headers = new HttpHeaders();
	  ChallangeResults isExist = challangeService.getChallangeResult(chalID);
	  if (isExist == null) {   
	   return new ResponseEntity<ChallangeResults>(HttpStatus.NOT_FOUND);
	  } else if (chalResult == null) {
	   return new ResponseEntity<ChallangeResults>(HttpStatus.BAD_REQUEST);
	  }
	  challangeService.updateResults(chalResult);
	  headers.add("Challange Result Updated  - ", String.valueOf(chalID));
	  return new ResponseEntity<ChallangeResults>(chalResult, headers, HttpStatus.OK);
	 }
	
	@RequestMapping(value = "/deleteResult/{id}", method = RequestMethod.DELETE)
	 public ResponseEntity<ChallangeResults> deleteChallangeResult(@PathVariable("id") Long chalID) {
		HttpHeaders headers = new HttpHeaders();
		ChallangeResults result = challangeService.getChallangeResult(chalID);
		  if (result == null) {   
		   return new ResponseEntity<ChallangeResults>(HttpStatus.NOT_FOUND);
		  }
		  challangeService.deleteResult(chalID);
		  headers.add("Employee Deleted - ", String.valueOf(chalID));
		  return new ResponseEntity<ChallangeResults>(result, headers, HttpStatus.NO_CONTENT);
	 }
	
	
}
