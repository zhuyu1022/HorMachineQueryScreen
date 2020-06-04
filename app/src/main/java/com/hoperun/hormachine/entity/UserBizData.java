package com.hoperun.hormachine.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserBizData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String Code = "";

	private String Message = "";

	private UserEntity Result;

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public UserEntity getResult() {
		return Result;
	}

	public void setResult(UserEntity result) {
		Result = result;
	}

	public class UserEntity {

		private String XTYHID = "";
		private String YHBH = "";
		private String YHM = "";
		private String YHKL = "";
		private String YHZT = "";
		private String XM = "";
		private String BMXXID = "";
		private String BMMC = "";
		private String JGXXID = "";
		private String JGMC = "";
		private String RYXXID = "";
		private String JGBH = "";
		private String SJJG = "";
		private String BMBH = "";
		private String SJBM = "";

		private String RYBH = "";
		private String RYJB = "";
		private String ZTXXID = "";
		private String YHLB = "";
		private String BMJC = "";
		private String QXMC = "";

		public String getQXMC() {
			return QXMC;
		}

		public void setQXMC(String QXMC) {
			this.QXMC = QXMC;
		}

		public String getXTYHID() {
			return XTYHID;
		}

		public void setXTYHID(String xTYHID) {
			XTYHID = xTYHID;
		}

		public String getYHBH() {
			return YHBH;
		}

		public void setYHBH(String yHBH) {
			YHBH = yHBH;
		}

		public String getYHM() {
			return YHM;
		}

		public void setYHM(String yHM) {
			YHM = yHM;
		}

		public String getYHKL() {
			return YHKL;
		}

		public void setYHKL(String yHKL) {
			YHKL = yHKL;
		}

		public String getYHZT() {
			return YHZT;
		}

		public void setYHZT(String yHZT) {
			YHZT = yHZT;
		}

		public String getXM() {
			return XM;
		}

		public void setXM(String xM) {
			XM = xM;
		}

		public String getBMXXID() {
			return BMXXID;
		}

		public void setBMXXID(String bMXXID) {
			BMXXID = bMXXID;
		}

		public String getBMMC() {
			return BMMC;
		}

		public void setBMMC(String bMMC) {
			BMMC = bMMC;
		}

		public String getJGXXID() {
			return JGXXID;
		}

		public void setJGXXID(String jGXXID) {
			JGXXID = jGXXID;
		}

		public String getJGMC() {
			return JGMC;
		}

		public void setJGMC(String jGMC) {
			JGMC = jGMC;
		}

		public String getRYXXID() {
			return RYXXID;
		}

		public void setRYXXID(String rYXXID) {
			RYXXID = rYXXID;
		}

		public String getJGBH() {
			return JGBH;
		}

		public void setJGBH(String jGBH) {
			JGBH = jGBH;
		}

		public String getSJJG() {
			return SJJG;
		}

		public void setSJJG(String sJJG) {
			SJJG = sJJG;
		}

		public String getBMBH() {
			return BMBH;
		}

		public void setBMBH(String bMBH) {
			BMBH = bMBH;
		}

		public String getSJBM() {
			return SJBM;
		}

		public void setSJBM(String sJBM) {
			SJBM = sJBM;
		}

		public String getRYBH() {
			return RYBH;
		}

		public void setRYBH(String rYBH) {
			RYBH = rYBH;
		}

		public String getRYJB() {
			return RYJB;
		}

		public void setRYJB(String rYJB) {
			RYJB = rYJB;
		}

		public String getZTXXID() {
			return ZTXXID;
		}

		public void setZTXXID(String zTXXID) {
			ZTXXID = zTXXID;
		}

		public String getYHLB() {
			return YHLB;
		}

		public void setYHLB(String yHLB) {
			YHLB = yHLB;
		}

		public String getBMJC() {
			return BMJC;
		}

		public void setBMJC(String bMJC) {
			BMJC = bMJC;
		}

	}
	//
	// "XTYHID":"25e4eb759f8145ebb19453604cc9d189",
	// "YHBH":"0324",
	// "YHM":"dn",
	// "YHKL":"e99a18c428cb38d5f260853678922e03",
	// "YHZT":"启用",
	// "XM":"邓宁",
	// "BMXXID":"13010101",
	// "BMMC":"织造部",
	// "JGXXID":"130102",
	// "JGMC":"织造越南分部",
	// "RYXXID":"25e4eb759f8145ebb19453604cc9d189",
	// "JGBH":"130102",
	// "SJJG":null,
	// "BMBH":"13010101",
	// "SJBM":null,
	// "RYBH":"411300106",
	// "RYJB":null,
	// "ZTXXID":"0",
	// "YHLB":"普通用户",
	// "BMJC":"织造部"
}
