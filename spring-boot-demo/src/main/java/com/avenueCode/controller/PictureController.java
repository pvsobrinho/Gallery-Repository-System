package com.avenueCode.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.avenueCode.entity.Picture;
import com.avenueCode.service.IPictureService;

@Controller
@RequestMapping("user")
public class PictureController {
	
	@Autowired
	private IPictureService pictureService;

	@PostMapping("picture")

	public ResponseEntity<Void> addPicture(@RequestBody Picture picture, UriComponentsBuilder builder) {
        boolean flag = pictureService.addPicture(picture);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/picture/{id}").buildAndExpand(picture.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("picture")
	public ResponseEntity<Picture> updatePicture(@RequestBody Picture picture) {
		pictureService.updatePicture(picture);
		return new ResponseEntity<Picture>(picture, HttpStatus.OK);
	}
	
	@DeleteMapping("picture/{id}")
	public ResponseEntity<Void> deletePicture(@PathVariable("id") Integer id) {
		pictureService.deletePicture(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
    
}