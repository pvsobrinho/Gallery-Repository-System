package com.avenueCode.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.avenueCode.entity.Product;
import com.avenueCode.entity.Picture;


public class RestClientUtil {


   public void getProductByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/product/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Product> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Product.class, 1);
        Product product = responseEntity.getBody();
        System.out.println("Id:"+product.getId()+", Description:"+product.getDescription()
                 +", Name:"+product.getName());      
    }
	
 public void getPictureByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/picture/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Picture> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Picture.class, 1);
        Picture picture = responseEntity.getBody();
        System.out.println("Id:"+picture.getId());      
    }
    
 public void addProductDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/product";
	    Product objProduct = new Product();
	    objProduct.setName("Spring REST Security using Hibernate");
	    objProduct.setDescription("Spring");
        HttpEntity<Product> requestEntity = new HttpEntity<Product>(objProduct, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
	
	
public void addPictureDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/picture";
	    Product objPicture = new Picture();
	    objPicture.setId(1);
        HttpEntity<Picture> requestEntity = new HttpEntity<Picture>(objPicture, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    
 public void getAllProductsDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/products";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Product[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Product[].class);
        Product[] products = responseEntity.getBody();
        for(Product product : products) {
        	 System.out.println("Id:"+product.getProductId()+", Description:"+product.getDescription()
             +", Name:"+product.getName());      
        }
    }
	
 public void getAllPictureDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/pictures";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Picture[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Picture[].class);
        Picture[] pictures = responseEntity.getBody();
        for(Picture picture : pictures) {
        	 System.out.println("Id:"+picture.getId());      
        }
    }
 public void updateProductDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/product";
	    Product objProduct = new Product();
	    
	    objProduct.setId(1);
	    objProduct.setName("Product Name");
	    objProduct.setDescription("Porduct Description");
	    	
        HttpEntity<Product> requestEntity = new HttpEntity<Product>(objProduct, headers);
        restTemplate.put(url, requestEntity);
    } 
 public void updatePictureDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/picture";
	    Picture objPicture = new Product();
	    
	    objPicture.setId(1);

        HttpEntity<Picture> requestEntity = new HttpEntity<Picture>(objPicture, headers);
        restTemplate.put(url, requestEntity);
    }
 public void deleteProductDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/product/{id}";
        HttpEntity<Product> requestEntity = new HttpEntity<Product>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
 public void deletePictureDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/picture/{id}";
        HttpEntity<Picture> requestEntity = new HttpEntity<Picture>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
 public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        // util.getProductByIdDemo();
		// util.getPictureByIdDemo();
    	util.getAllProductsDemo();
		// util.getAllPictureDemo();
    	// util.addProductDemo();
		// util.addPictureDemo();
    	// util.updateProductDemo();
		// util.updatePictureDemo();
    	// util.deleteProductDemo();
		// util.deletePictureDemo();
    }    
}