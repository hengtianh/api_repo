package org.easy.develop.service.impl;

import java.io.File;
import java.io.IOException;

import org.easy.develop.service.FileService;
import org.easy.develop.web.exception.FileUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadFile(MultipartFile multipartFile, String filename) throws FileUploadException {
		// TODO Auto-generated method stub
		String originalFilename = multipartFile.getOriginalFilename();
		String suffix = originalFilename.substring(originalFilename.lastIndexOf('.'));
		String newFilename = filename + suffix;
		String uploadPath = "d:/upload/";
		File dest = new File(uploadPath + newFilename);
		try {
			multipartFile.transferTo(dest);
			return uploadPath + newFilename;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new FileUploadException("failed to upload file: '" + originalFilename + "'");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new FileUploadException("failed to upload file: '" + originalFilename + "'");
		}
	}

}
