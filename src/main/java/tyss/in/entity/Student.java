package tyss.in.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SID")
	private int studentId;
	private String name;
	private long phone;
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Subjects> subjects;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", subjects=" + subjects + "]";
	}

	public Student(String name, long phone, String email, List<Subjects> subjects) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.subjects = subjects;
	}
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
