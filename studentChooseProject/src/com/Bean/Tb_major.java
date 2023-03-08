package com.Bean;

public class Tb_major {
	private String majorid;
	private String majorname;
	private String majormaster;
	private String majormasterphone;
	
	public Tb_major(String majorid,String majorname){
		this.majorid=majorid;
		this.majorname=majorname;
	}//目前用不上
	public Tb_major(){

	}
	@Override
	public String toString() {
		return this.majorname;
	}//用不上
	public String getmajorId(){
		return majorid;
	}
	public void setmajorId(String majorId){
		this.majorid=majorId;
	}
	public String getmajorName(){
		return majorname;
	}
	public void setmajorName(String majorName){
		this.majorname=majorName;
	}
	public String getmajorMaster(){
		return majormaster;
	}
	public void setmajorMaster(String majorMaster){
		this.majormaster=majorMaster;
	}
	public String getmajorMasterPhone(){
		return majormasterphone;
	}
	public void setmajorMasterPhone(String majorMasterPhone){
		this.majormasterphone=majorMasterPhone;
	}
}
