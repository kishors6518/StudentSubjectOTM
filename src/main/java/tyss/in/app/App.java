package tyss.in.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import tyss.in.entity.Student;
import tyss.in.entity.Subjects;

public class App {
	static Scanner sc=new Scanner(System.in);
	static App a=new App();

	EntityManagerFactory factory;
	EntityManager manager;
	EntityTransaction transaction;
	
	
	public void addStudent() {
		factory=Persistence.createEntityManagerFactory("kishor");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		
		transaction.begin();
		List<Subjects> sub=new ArrayList<Subjects>();
		sub.add(new Subjects("Java", "Tejus Sir"));
		sub.add(new Subjects("Manual","Kruthal Mam"));
		sub.add(new Subjects("J2EE", "Varun Sir"));
		sub.add(new Subjects("SQL", "Ravi Sir"));
		
		Student student1=new Student("Kishor", 8329774543l, "shembekishor@gmail.com", sub);
		
		List<Subjects> sub2=new ArrayList<Subjects>();
		sub2.add(new Subjects("Java", "Tejus Sir"));
		sub2.add(new Subjects("SQL", "Ravi Sir"));
		sub2.add(new Subjects("AWS", "Deshmukh Sir"));
		sub2.add(new Subjects("Python","Jadhav Sir"));
		
		Student student2=new Student("Shivam", 7894561232l, "shivam@gmail.com", sub2);
		
		manager.persist(student1);
		manager.persist(student2);
		transaction.commit();
	}
	
	public void updateStudent()
	{
		factory=Persistence.createEntityManagerFactory("kishor");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		
		System.out.println("Enter ID of doing update operation of Student");
		int id=sc.nextInt();
		Student s=a.findStudent(id);
		if(s!=null)
		{
			transaction.begin();
			List<Subjects> l=new ArrayList<Subjects>();
			l.add(new Subjects("Mathematics", "Surwanshi Sir"));
			l.add(new Subjects("Chemistry","Patil Mam"));
			l.add(new Subjects("Physics", "Wani Sir"));
			Student stud=new Student("Vijay", 7894561234l, "vijay@gmail.com", l);
			manager.merge(stud);
			transaction.commit();
		}
		else
		{
			System.out.println("Student not found with"+id+" ID");
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Enter option for doing operations");
		System.out.println("A. Add Students \nB. Update Student \nC. Find Student \nD. Delete Student");
		char c=sc.next().charAt(0);
		switch (c) {
		case 'A':
			a.addStudent();
			break;

		case 'B':
			a.updateStudent();
			break;
			
		case 'C':
			System.out.println("Enter ID for find Student");
			int id=sc.nextInt();
			Student s=a.findStudent(id);
			if(s!=null)
			{
				System.out.println(s);
			}
			else
			{
				System.out.println("Student not found with "+id+" ID");
			}
			break;
			
		case 'D':
			a.deleteStudent();
			break;
			
		}
	}

	public void deleteStudent() {
		factory=Persistence.createEntityManagerFactory("kishor");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		System.out.println("Enter ID for Delete Student");
		int id=sc.nextInt();
		Student s=a.findStudent(id);
		if(s!=null)
		{
			transaction.begin();
			manager.remove(s);
		}
		else
		{
			System.out.println("Student not found with "+id+" ID");
		}
		
	}

	public Student findStudent(int id) {
		factory=Persistence.createEntityManagerFactory("kishor");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();

		return manager.find(Student.class,id);	
		
	}
	
	
}
