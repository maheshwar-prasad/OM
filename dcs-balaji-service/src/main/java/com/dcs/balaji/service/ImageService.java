package com.dcs.balaji.service;

import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.dcs.balaji.enm.ImageType;
import com.dcs.common.file.response.CommonFileUploadResponse;

public interface ImageService {

	String IMAGE_FOLDER = "/IMAGES";

	/**
	 * 
	 * @param imageType
	 * @param FILE
	 * @return
	 * @throws Exception
	 */
	CommonFileUploadResponse uploadImage(ImageType imageType, MultipartFile FILE) throws Exception;

	/**
	 * 
	 * @param fileKey
	 * @return
	 * @throws Exception
	 */
	InputStream loadImage(String fileKey) throws Exception;
}
