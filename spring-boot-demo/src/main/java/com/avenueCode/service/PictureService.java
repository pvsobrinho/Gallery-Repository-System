package com.avenueCode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avenueCode.dao.IPictureDAO;
import com.avenueCode.entity.Picture;
@Service
public class PictureService implements IPictureService {
	
	@Autowired
	private IPictureDAO pictureDAO;
	
	@Override
	public Picture getPictureById(int pictureId) {
		Picture obj = pictureDAO.getPictureById(pictureId);
		return obj;
	}	
	
	@Override
	public List<Picture> getAllPictures(){
		return pictureDAO.getAllPictures();
	}	
	
	@Override
	public synchronized boolean addPicture(Picture picture){
		   if (pictureDAO.pictureExists(picture.getId())) {
			   return false;
		   } else {
			   pictureDAO.addPicture(picture);
			   return true;
		   }
	}
	@Override
	public void updatePicture(Picture picture) {
		pictureDAO.updatePicture(picture);
	}
	@Override
	public void deletePicture(int pictureId) {
		pictureDAO.deletePicture(pictureId);
	}
}