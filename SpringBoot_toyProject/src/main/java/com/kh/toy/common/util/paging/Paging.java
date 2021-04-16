package com.kh.toy.common.util.paging;

public class Paging {
	
		private String type;
		//현재 페이지
		private int currentPage;
		//전체 게시물 수
		private int total;
		//페이지당 게시물 수
		private int cntPerPage;
		
		//블록 안의 페이지넘버 수
		private int blockCnt;
		//블록 시작 번호
		private int blockStart;
		//블록 끝 번호
		private int blockEnd;
		//전체 페이지 수
		private int lastPage;
		
		//이전 버튼
		private int prev;
		//다음 버튼
		private int next;
		
		//sql에서 사용할 시작 값
		private int start;
		//sql에서 사용할 끝 값
		private int end;
		
		public static PagingBuilder builder() {
			return new PagingBuilder();
		}
		
		public static class PagingBuilder {
			private String type;
			private int total;
			private int currentPage;
			private int cntPerPage;
			private int blockCnt;
			
			public PagingBuilder type(String val) {
				this.type = val;
				return this;
			}
			
			public PagingBuilder total(int val) {
				this.total = val;
				return this;
			}
			
			public PagingBuilder currentPage(int val) {
				this.currentPage = val;
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

		private Paging(PagingBuilder builder) {
			this.type = builder.type;
			this.total = builder.total;
			this.currentPage = builder.currentPage;
			this.cntPerPage = builder.cntPerPage;
			this.blockCnt = builder.blockCnt;

			calAllPage();
			calBlock();
			calQueryNumber();
			calPrev();
			calNext();
		}
		
		//전체 페이지 숫자 구하기
		private void calAllPage() {
			//total/cntPerPage 한 후 올림처리 한 것과 같다.
			lastPage = (total-1)/cntPerPage + 1;
		}
		
		//블럭당 끝 페이지 넘버 구하기
		private void calBlock() {
			//현재 페이지 값보다 작은 5의 배수 중 가장 큰 값에 1을 더하면 시작블록 값 
			blockStart = ((currentPage-1)/blockCnt) * blockCnt + 1;
			//시작블록값에서 블록의 개수-1을 더해주면 첫 블록 값
			blockEnd = blockStart + (blockCnt-1);
			
			//만약 마지막 블록값이 마지막 페이지보다 크다면 예외처리
			if(lastPage < blockEnd) {
				blockEnd = lastPage;
			}
			
			//시작 블록값이 1보다 작으면 예외처리
			if(blockStart < 1) {
				blockStart = 1;
			}
		}
		
		//DB쿼리에서 사용할 끝값 구하기
		private void calQueryNumber() {
			end = currentPage * cntPerPage;
			start = end - cntPerPage + 1;
		}
		
		private void calPrev() {
			prev = currentPage == 1?1:currentPage-1;
		}
		
		private void calNext() {
			next = currentPage == lastPage?lastPage:currentPage+1;
		}

		public String getType() {
			return type;
		}

		public int getCurrentPage() {
			return currentPage;
		}

		public int getTotal() {
			return total;
		}

		public int getCntPerPage() {
			return cntPerPage;
		}

		public int getBlockCnt() {
			return blockCnt;
		}

		public int getBlockStart() {
			return blockStart;
		}

		public int getBlockEnd() {
			return blockEnd;
		}

		public int getLastPage() {
			return lastPage;
		}

		public int getPrev() {
			return prev;
		}

		public int getNext() {
			return next;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		@Override
		public String toString() {
			return "Paging [currentPage=" + currentPage + ", total=" + total + ", cntPerPage=" + cntPerPage + ", blockCnt="
					+ blockCnt + ", blockStart=" + blockStart + ", blockEnd=" + blockEnd + ", lastPage=" + lastPage
					+ ", start=" + start + ", end=" + end + "]";
		}

}
