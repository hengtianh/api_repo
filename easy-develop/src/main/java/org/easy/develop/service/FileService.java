package org.easy.develop.service;

import org.easy.develop.web.exception.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	/**
	 * 文件上传接口，按指定文件名保存文件
	 * @param multipartFile
	 * @param filename
	 * @throws FileUploadException
	 */
	String uploadFile(MultipartFile multipartFile, String filename) throws FileUploadException;
}
