package com.akhilesh.techademy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id", nullable = false)
	int course_id;

	public String getC_resource() {
		return c_resource;
	}

	public void setC_resource(String c_resource) {
		this.c_resource = c_resource;
	}

	String c_name, c_desc;
	double c_fees;
	String c_resource;

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_desc() {
		return c_desc;
	}

	public void setC_desc(String c_desc) {
		this.c_desc = c_desc;
	}

	public double getC_fees() {
		return c_fees;
	}

	public void setC_fees(double fees) {
		this.c_fees = fees;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", c_name=" + c_name + ", c_desc=" + c_desc + ", fees=" + c_fees
				+ "]";
	}

}
