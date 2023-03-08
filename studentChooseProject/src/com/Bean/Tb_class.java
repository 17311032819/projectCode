package com.Bean;
import java.io.Serializable;

public class Tb_class implements Serializable {
	private String classid;
	private String classname;
	private String classteacher;
	private String teacherphone;
	private String majorid;
	private String majorName;
	
	public Tb_class(String classid,String classname) {
		this.classid = classid;
		this.classname = classname;
	}
	public Tb_class(){
		
	}
	
	@Override
	public String toString() {
		return this.classname;
	}
	
	public String getclassid() {
		return classid;
	}
	public void setclassid(String classid) {
		this.classid = classid;
	}
	public String getclassname() {
		return classname;
	}
	public void setclassname(String classname) {
		this.classname = classname;
	}
	public String getclassteacher(){
		return classteacher;
	}
	
	public void setclassteacher(String classteacher){
		this.classteacher=classteacher;
	}
	
	public String getteacherphone(){
		return teacherphone;
	}
	
	public void setteacherphone(String teacherphone){
		this.teacherphone=teacherphone;
	}
	
	public String getmajorid(){
		return majorid;
	}
	public void setmajorid(String majorid){
		this.majorid = majorid;
	}
	
	public String getmajorName(){
		return majorName;
	}
	public void setmajorName(String majorName){
		this.majorName = majorName;
	}

}
