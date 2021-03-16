package common.util.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import common.code.Code;
import common.code.ErrorCode;
import common.exception.CustomException;

public class FileUtil {

	public List<FileVo> fileUpload(List<MultipartFile> files) {
		
		//파일과 관련된 정보를 가지고 반환될 list	
		List<FileVo> fileData = new ArrayList<FileVo>();
		
		for(MultipartFile mf : files) {
			//서버에 저장할 경로
			String savePath = getSavePath();
			//사용자가 올린 파일 이름
			String originFileName = mf.getOriginalFilename();
			//서버에 저장될 파일 이름
			String renameFileName = getRenameFileName(originFileName);
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("originFileName", originFileName);
			map.put("renameFileName", renameFileName);
			map.put("savePath",savePath);
			
			FileVo fileVo = new FileVo();
			fileVo.setOriginFileName(originFileName);
			fileVo.setRenameFileName(renameFileName);
			fileVo.setSavePath(savePath);
			
			//tb_file에 저장할 데이터를 list에 추가
			fileData.add(fileVo);
			saveFile(mf,fileVo);
		}
	
		return fileData;	
	}
	
	public String getSavePath() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int mon = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return year + "/" + mon + "/" + day + "/";
	}
	
	public String getRenameFileName(String originFileName) {
		 UUID renameFileID = UUID.randomUUID(); 
	     return renameFileID.toString() + originFileName.substring(originFileName.lastIndexOf("."));
	}

	public void saveFile(MultipartFile mf, FileVo fileVo)  {
		//사용자가 등록한 파일을 옮겨담을 파일 객체 생성
		//savePath : 저장할 경로 + 변경된 파일명
		File path = new File(fileVo.getFullPath());
		if(!path.exists()) {
			path.mkdirs();
		}
		
		File tempFile 
			= new File(fileVo.getFullPath()+fileVo.getRenameFileName());
		try {
			mf.transferTo(tempFile);
		} catch (IllegalStateException | IOException e) {
			throw new CustomException(ErrorCode.IF01);
		}
	}
	
	
	public void deleteFile(String path) {
		//지정된 경로의 파일 객체를 생성
		File file = new File(Code.UPLOAD.desc + path);
		//delete() 메서드로 파일을 삭제
		file.delete();
	}

}
