package tyss.in.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Subjects {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SubID")
	private int subjectID;
	private String subName;
	private String subTeacher;
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getSubTeacher() {
		return subTeacher;
	}
	public void setSubTeacher(String subTeacher) {
		this.subTeacher = subTeacher;
	}
	
	
	@Override
	public String toString() {
		return "Subjects [subjectID=" + subjectID + ", subName=" + subName + ", subTeacher=" + subTeacher + "]";
	}
	public Subjects(String subName, String subTeacher) {
		super();
		this.subName = subName;
		this.subTeacher = subTeacher;
	}
	
	public Subjects() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
