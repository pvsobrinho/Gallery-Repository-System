package com.avenueCode.service;

import java.util.List;

import com.avenueCode.entity.Picture;


public interface IPictureService {
     List<Picture> getAllPictures();
     Picture getPictureById(int pictureId);
     boolean addPicture(Picture picture);
     void updatePicture(Picture picture);
     void deletePicture(int pictureId);
}