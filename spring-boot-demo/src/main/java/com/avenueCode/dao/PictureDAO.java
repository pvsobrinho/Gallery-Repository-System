package com.avenueCode.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avenueCode.entity.Picture;
import com.avenueCode.entity.Picture;
@Transactional
@Repository
public class PictureDAO implements IPictureDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Autowired
	private IPictureDAO pictureDAO;
	
	
	@Override
	public Picture getPictureById(int pictureId) {
		return entityManager.find(Picture.class, pictureId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Picture> getAllPictures() {
		String hql = "FROM Picture as atcl ORDER BY atcl.picture_id";
		return (List<Picture>) entityManager.createQuery(hql).getResultList();
	}	
	
	@Override
	public void addPicture(Picture picture) {
		entityManager.persist(picture);
	}
	
	@Override
	public void updatePicture(Picture picture) {
		Picture prodt = getPictureById(picture.getId());
		
		prodt.setId(picture.getId()); 
		
		entityManager.flush();
	}
	
	
	
	@Override
	public void deletePicture(int pictureId) {
		entityManager.remove(getPictureById(pictureId));
	}
	@Override
	public boolean pictureExists(String title, String category) {
		String hql = "FROM Picture as atcl WHERE atcl.id = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title)
		              .setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
	}
}