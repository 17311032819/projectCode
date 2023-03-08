package com.Bean;

public class Tb_stuinfo {
	private String stu_id;
	private String stu_name;
	private String stu_sex;
	private String stu_classid;
	private String stu_classname;
	private String stu_phone;
	private String stu_password;
	private String stu_QQ;

	public Tb_stuinfo(String classid,String classname) {
		this.stu_classid = classid;
		this.stu_classname = classname;
	}
	public Tb_stuinfo(){

	}
	public String getstu_id(){
		return stu_id;
	}
	public void setstu_id(String stu_id){
		this.stu_id=stu_id;
	}
	public String getstu_name(){
		return stu_name;
	}
	public void setstu_name(String stu_name){
		this.stu_name=stu_name;
	}
	public String getstu_sex(){
		return stu_sex;
	}
	public void setstu_sex(String stu_sex){
		this.stu_sex=stu_sex;
	}

	public String getstu_classid(){
		return stu_classid;
	}
	public void setstu_classid(String stu_classid){
		this.stu_classid=stu_classid;
	}
	public String getstu_classname(){
		return stu_classname;
	}
	public void setstu_classname(String stu_classname){
		this.stu_classname=stu_classname;
	}

	public String getstu_phone(){
		return stu_phone;
	}
	public void setstu_phone(String stu_phone){
		this.stu_phone=stu_phone;
	}

	public String getstu_QQ(){
		return stu_QQ;
	}
	public void setstu_QQ(String stu_QQ){
		this.stu_QQ=stu_QQ;
	}


	public String getstu_password(){
		return stu_password;
	}
	public void setstu_password(String stu_password){
		this.stu_password=stu_password;
	}



}
