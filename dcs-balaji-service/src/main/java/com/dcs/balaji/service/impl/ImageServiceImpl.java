package com.dcs.balaji.service.impl;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dcs.balaji.enm.ImageType;
import com.dcs.balaji.service.ImageService;
import com.dcs.common.file.response.CommonFileUploadResponse;
import com.dcs.common.file.service.CommonFileStorageService;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private CommonFileStorageService fileStorageService;

	@Override
	public CommonFileUploadResponse uploadImage(ImageType imageType, MultipartFile FILE) throws Exception {
		return fileStorageService.storeFile(FILE.getOriginalFilename(), FILE.getInputStream(), IMAGE_FOLDER);
	}

	@Override
	public InputStream loadImage(String fileKey) throws Exception {
		return fileStorageService.getFile(fileKey).getInputStream();
	}

}
