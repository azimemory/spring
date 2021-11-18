package com.kh.spring.common.util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.common.code.Config;
import com.kh.spring.common.code.ErrorCode;
import com.kh.spring.common.exception.HandlableException;

public class FileUtil {
	
	public FileDTO fileUpload(MultipartFile mf) {
		
		FileDTO file = createFileDTO(mf);
		
		try {
			mf.transferTo(new File(getSavePath() + file.getRenameFileName()));
		} catch (IllegalStateException | IOException e) {
			throw new HandlableException(ErrorCode.FAILED_FILE_UPLOAD_ERROR,e);
		}
		
		return file;
	}
	
	private String getSubPath() {
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int date = today.get(Calendar.DATE);
		return year + "/" + month + "/" + date + "/";
	}
	
	private String getSavePath() {
		//2. 저장경로를 웹어플리케이션 외부로 지정
		//		 저장경로를  외부경로 + /연/월/일 형태로 작성
		String subPath = getSubPath();
		String savePath = Config.UPLOAD_PATH.DESC + subPath;
		
		File dir = new File(savePath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		return savePath;
	}
	
	private FileDTO createFileDTO(MultipartFile mf) {
		FileDTO fileDTO = new FileDTO();
		String originFileName = mf.getOriginalFilename();
		String renameFileName = UUID.randomUUID().toString();
		
		if(originFileName.contains(".")) {
			renameFileName = renameFileName += originFileName.substring(originFileName.lastIndexOf("."));
		}
		
		String savePath = getSubPath();
		
		fileDTO.setOriginFileName(originFileName);
		fileDTO.setRenameFileName(renameFileName);
		fileDTO.setSavePath(savePath);
		return fileDTO;
	}

}
