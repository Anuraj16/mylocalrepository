package com.ecommerce.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.ecommerce.entity.Products;
import com.ecommerce.model.ProductInfo;

public class AmazonUtils {

	public static String endpointUrl="https://s3.ap-south-1.amazonaws.com";
	static AWSCredentials credentials = new BasicAWSCredentials(
			  "AKIAVJGH6YWGDPV5TUN2", 
			  "fvOvEWIIxRQKOjnLVsyBgnSn8iomJ/PVU1kIHJ7w"
			);
	static AmazonS3 s3client = AmazonS3ClientBuilder.
			standard().
			withCredentials(new AWSStaticCredentialsProvider(credentials)).
			withRegion(Regions.AP_SOUTH_1).
			/*enablePathStyleAccess().*/
			disableChunkedEncoding().
			build();
	
	public static File convertMultiPartToFile(CommonsMultipartFile file){
    	File convFile=null;
    	try {
    		convFile = new File(file.getOriginalFilename());
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
            
		} catch (IOException e) {
			// TODO: handle exception
		}
    	return convFile;
    }
    
    public static String generateFileName(CommonsMultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }
    
    public static String getImageForProduct(Products products) {
	//	File folder = new File(destFilePath);
		//File[] listOfFiles = folder.listFiles();
	//	return listOfFiles[0].getName();
    	String fileUrl = null;
		try {
			
				String filenames=products.getFileNames();
				if(filenames != null){
					String fileName=filenames.split(",")[0];
					if(fileName !=null && fileName.length()>0){
						System.out.println("filename not blank "+fileName.length());
						if(products.getDestFilePath() != null && products.getDestFilePath() != ""){
							fileUrl=products.getDestFilePath()+"/"+fileName;
						}else{
							fileUrl=endpointUrl+"/"+getBucketName()+"/"+fileName;
						}
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("fileurl returned "+fileUrl);
		return fileUrl;
	}
    
    public static List<String> getImageListForProduct(ProductInfo products) {
    	//	File folder = new File(destFilePath);
    		//File[] listOfFiles = folder.listFiles();
    	//	return listOfFiles[0].getName();
        	String fileUrl = null;
        	List<String> fileUrlList= new ArrayList<String>(); 
    		try {
    			
    				String filenames=products.getFileNames();
    				String[] fileNameArray=filenames.split(",");
    				
    				for (String fileName : fileNameArray) {
    					if(products.getDestFilePath() != null && products.getDestFilePath() != "")
        				{
        				fileUrl=products.getDestFilePath()+"/"+fileName;
        				}else{
        				fileUrl=endpointUrl+"/"+getBucketName()+"/"+fileName;
        				}
    					fileUrlList.add(fileUrl);
					}
    				
    				
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return fileUrlList;
    	}
    public static String getBucketName(){
    	String bucketName="zariya-product-bucket";
		
		if(!s3client.doesBucketExistV2(bucketName)) {
		    System.out.println("bucket doesn't exist");
		    bucketName=bucketName+"-images";
		    System.out.println("creating new bucket");
		    s3client.createBucket(bucketName);
		}
		return bucketName;
    }
    
    public static AmazonS3 gets3Client(){
    	
    	return s3client;
    }
}
