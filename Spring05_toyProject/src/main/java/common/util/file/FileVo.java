package common.util.file;

public class FileVo {

	int fIdx;
	int typeIdx;
	String type;
	String originFileName;
	String renameFileName;
	String savePath;
	String isDel;
	
	public int getfIdx() {
		return fIdx;
	}
	
	public void setfIdx(int fIdx) {
		this.fIdx = fIdx;
	}
	
	public void setfIdx(String fIdx) {
		this.fIdx = Integer.parseInt(fIdx);
	}
	
	public int getTypeIdx() {
		return typeIdx;
	}
	
	public void setTypeIdx(int typeIdx) {
		this.typeIdx = typeIdx;
	}
	
	public String getOriginFileName() {
		return originFileName;
	}
	
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	
	public String getRenameFileName() {
		return renameFileName;
	}
	
	public void setRenameFileName(String renameFileName) {
		this.renameFileName = renameFileName;
	}
	
	public String getSavePath() {
		return savePath;
	}
	
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsDel() {
		return isDel;
	}
	
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

}
