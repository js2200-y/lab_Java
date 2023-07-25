package edu.java.gugudan.controller;

import java.io.Serializable;

public class Gugudan implements Serializable {
 
		public interface Entity {
			String TBL_NAME = "GUGUDAN";
			String COL_CID = "CID";
			String COL_OKCOUNT = "OKCOUNT";
			String COL_FAILCOUNT = "FAILCOUNT";
		}
		
		
		private Integer cid;
		private String okcount;
		private String failcount;
		
		
		public Gugudan() { }
		
		public Gugudan(Integer cid, String okcount, String failcount) {
			this.cid = cid;
			this.okcount = okcount;
			this.failcount = failcount;
		}

		public Integer getCid() {
			return cid;
		}

		public void setCid(Integer cid) {
			this.cid = cid;
		}

		public String getOkcount() {
			return okcount;
		}

		public void setOkcount(String okcount) {
			this.okcount = okcount;
		}

		public String getFailcount() {
			return failcount;
		}

		public void setFailcount(String failcount) {
			this.failcount = failcount;
		}

		@Override
		public String toString() {
			return "Gugudan [cid=" + cid + ", okcount=" + okcount + ", failcount=" + failcount + "]";
		}
		
		
		
}
