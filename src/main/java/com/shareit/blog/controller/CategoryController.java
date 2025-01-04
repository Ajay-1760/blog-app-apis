package com.shareit.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shareit.blog.payloads.ApiResponse;
import com.shareit.blog.payloads.CategoryDto;
import com.shareit.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService catService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto cat){
		
		CategoryDto addedCat= catService.createCategory(cat);
		
		return new ResponseEntity<CategoryDto>(addedCat, HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updatedCategory(@Valid @RequestBody CategoryDto cat, @PathVariable Integer catId){
		
		CategoryDto updatedCat = catService.updateCategory(cat, catId);
		
		return ResponseEntity.ok(updatedCat);
	}
	
	
	//delete
	@DeleteMapping("/{catId}")
	public ResponseEntity<?> deleteCateggory(@PathVariable Integer catId){
		catService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully", true), HttpStatus.OK);
	}
	
	//get
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
		
		CategoryDto cat= catService.getCategory(catId);
		
		return new ResponseEntity<CategoryDto>(cat, HttpStatus.OK);
	}
	
	
	//getAll
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto> > getCategories(){
		List<CategoryDto> categories=catService.getCategories();
		
		return new ResponseEntity<List<CategoryDto> >(categories, HttpStatus.OK);
	}
}
