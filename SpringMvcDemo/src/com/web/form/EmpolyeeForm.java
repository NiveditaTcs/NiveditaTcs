package com.web.form;

public class EmpolyeeForm {

	private String name;
	private String designation;
	private String department;
	private Integer empId;
	private String editEmp;
	private String deleteEmp;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEditEmp() {
		return editEmp;
	}
	public void setEditEmp(String editEmp) {
		this.editEmp = editEmp;
	}
	public String getDeleteEmp() {
		return deleteEmp;
	}
	public void setDeleteEmp(String deleteEmp) {
		this.deleteEmp = deleteEmp;
	}
	
}
