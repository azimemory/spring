package com.kh.toy.common.util.paging;

public class Paging {
	
	//입력받을 값
	private String type; //페이징 처리할 항목
	private int cuurentPage; //현재 페이지
	private int total; //전체 게시물 수
	private int cntPerPage; // 페이지당 게시물 수
	private int blockCnt; //하단에 표시될 페이지블록 개수
	private String sort; //정렬 기준 컬럼
	private String direction; //정렬 방향
	
	//계산할 값
	private int blockStart; //시작 블록
	private int blockEnd; //마지막 블록
	private int lastPage; //마지막 페이지
	private int prev; //이전 버튼
	private int next; //다음 버튼
	
	//쿼리 between문에서 사용할 rownum 범위
	private int queryStart;
	private int queryEnd;
	
	private Paging(PagingBuilder builder) {
		this.type = builder.type;
		this.cuurentPage = builder.cuurentPage;
		this.total = builder.total;
		this.cntPerPage = builder.cntPerPage;
		this.blockCnt = builder.blockCnt;
		this.sort = builder.sort;
		this.direction = builder.direction;
		
		calBlockStartAndEnd();
		calQueryStartAndEnd();
		calPrevAndNext();
	}
	
	public static PagingBuilder builder() {
		return new PagingBuilder();
	}
	
	private void calLastPage() {
		lastPage = (total-1)/cntPerPage + 1 ;
	}
	
	private void calBlockStartAndEnd() {
		calLastPage(); //마지막 페이지 계산
		
		blockStart = ((cuurentPage - 1)/ blockCnt) * blockCnt + 1;
		blockEnd = blockStart + blockCnt - 1;
		
		blockStart = blockStart < 1? 1:blockStart;
		blockEnd = blockEnd > lastPage? lastPage:blockEnd;
	}
	
	private void calQueryStartAndEnd() {
		queryEnd = cuurentPage * cntPerPage;
		queryStart = queryEnd - cntPerPage + 1;
	}
	
	private void calPrevAndNext() {
		prev = cuurentPage == 1? 1 : cuurentPage -1;
		next = cuurentPage == lastPage?  lastPage : cuurentPage + 1;
	}
	
	public static class PagingBuilder{
		//입력받을 값
		private String type; //페이징 처리할 항목
		private int cuurentPage; //현재 페이지
		private int total; //전체 게시물 수
		private int cntPerPage; // 페이지당 게시물 수
		private int blockCnt; //하단에 표시될 페이지블록 개수
		private String sort;
		private String direction;
		
		public PagingBuilder type(String val) {
			this.type = val;
			return this;
		}
		
		public PagingBuilder sort(String val) {
			this.sort = val;
			return this;
		}
		
		public PagingBuilder direction(String val) {
			this.direction = val;
			return this;
		}
		
		public PagingBuilder cuurentPage(int val) {
			this.cuurentPage = val;
			return this;
		}
		
		public PagingBuilder total(int val) {
			this.total = val;
			return this;
		}
		
		public PagingBuilder cntPerPage(int val) {
			this.cntPerPage = val;
			return this;
		}
		
		public PagingBuilder blockCnt(int val) {
			this.blockCnt = val;
			return this;
		}
		
		public Paging build() {
			return new Paging(this);
		}
	}
	
	
	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param cuurentPage the cuurentPage to set
	 */
	public void setCuurentPage(int cuurentPage) {
		this.cuurentPage = cuurentPage;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @param cntPerPage the cntPerPage to set
	 */
	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	/**
	 * @param blockCnt the blockCnt to set
	 */
	public void setBlockCnt(int blockCnt) {
		this.blockCnt = blockCnt;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the cuurentPage
	 */
	public int getCuurentPage() {
		return cuurentPage;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @return the cntPerPage
	 */
	public int getCntPerPage() {
		return cntPerPage;
	}
	/**
	 * @return the blockCnt
	 */
	public int getBlockCnt() {
		return blockCnt;
	}
	/**
	 * @return the blockStart
	 */
	public int getBlockStart() {
		return blockStart;
	}
	/**
	 * @return the blockEnd
	 */
	public int getBlockEnd() {
		return blockEnd;
	}
	/**
	 * @return the lastPage
	 */
	public int getLastPage() {
		return lastPage;
	}
	/**
	 * @return the prev
	 */
	public int getPrev() {
		return prev;
	}
	/**
	 * @return the next
	 */
	public int getNext() {
		return next;
	}
	/**
	 * @return the queryStart
	 */
	public int getQueryStart() {
		return queryStart;
	}
	/**
	 * @return the queryEnd
	 */
	public int getQueryEnd() {
		return queryEnd;
	}
	
	@Override
	public String toString() {
		return "Paging [type=" + type + ", cuurentPage=" + cuurentPage + ", total=" + total + ", cntPerPage="
				+ cntPerPage + ", blockCnt=" + blockCnt + ", sort=" + sort + ", direction=" + direction
				+ ", blockStart=" + blockStart + ", blockEnd=" + blockEnd + ", lastPage=" + lastPage + ", prev=" + prev
				+ ", next=" + next + ", queryStart=" + queryStart + ", queryEnd=" + queryEnd + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
