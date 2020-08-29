package com.vir.stud;

public class Student {
	private int id;
    private String name;
    private int[] marks = new int[100];
    private float average;
    private char grade;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getMarks() {
		return marks;
	}
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public Student(int id, String name, int[] marks, float average, char grade) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.average = average;
		this.grade = grade;
	}
    
	public void calculateAvg()
	{
		int sum = 0;
		for(int i = 0; i < marks.length;i++)
		{
			sum += marks[i];
		}
		average = sum/marks.length;
		System.out.printf("Average:%.2f" + average);
	}
	
	public void finalGrade()
	{
		if(average >= 80 && average <= 100)
		{
			grade = 'O';
		}
		else if(average >= 50)
		{
			grade = 'A';
		}
		else
		{
			for(int i = 0; i < marks.length; i++)
			{
				if(marks[i] < 50)
				{
					grade = 'F';
				}
			}
		}
		
		System.out.println("Grade:" + grade);

		
	}
    
    

}
