package com.avenueCode.dao;

import com.avenueCode.entity.Picture;

public interface IPictureDAO {
    List<Picture> getAllPictures();
    Picture getPictureById(int PictureId);
    void addPicture(Picture picture);
    void updatePicture(Picture picture);
    void deletePicture(int pictureId);
	boolean pictureExists(String title, String category);

}
