package com.practica03.category.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica03.category.api.entity.Category;

@RestController
@RequestMapping("/category")
public class CtrlCategory {

	@GetMapping
	public ResponseEntity<List<Category>> getCategories(){
		Category cat1 = new Category(1, "Electrónica", 1);
		Category cat2 = new Category(2,"Línea Blanca", 1);
		
		List cats = new ArrayList();
		cats.add(cat1);
		cats.add(cat2);
		
		return new ResponseEntity<>(cats, HttpStatus.OK);
	}

	@GetMapping("/{category_id}")
	public ResponseEntity<Category> getRegion(@PathVariable int category_id){
		Category cat = new Category(1, "Electrónica", 1);
		
		return new ResponseEntity<>(cat, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> createRegion(@Valid @RequestBody Category category, BindingResult bindingResult){
		String message = "category created";
		if(bindingResult.hasErrors()) {
			message = bindingResult.getAllErrors().get(0).getDefaultMessage();
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@PutMapping("/{category_id}")
	public ResponseEntity<String> updateRegion(@PathVariable int category_id, 
			@Valid @RequestBody Category category, BindingResult bindingResult){
		String message = "category updated";
		if(bindingResult.hasErrors()) {
			message = bindingResult.getAllErrors().get(0).getDefaultMessage();
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@DeleteMapping("/{category_id}")
	public ResponseEntity<String> deleteRegion(@PathVariable int category_id){
		String message  = "category removed";
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
