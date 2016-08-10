package com.web.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.web.dummyDB.EmpDB;
import com.web.form.EmpolyeeForm;

public class EmpService {

	private EmpDB empDB;
	public Map<Integer,EmpolyeeForm> getEmpList(){
		Map<Integer,EmpolyeeForm> empMap=empDB.getEmployeeList();
		
		
		return empMap;
		
		
	}
	
	public Map<Integer,EmpolyeeForm> editEmpList(List<EmpolyeeForm> empList){
		Map<Integer,EmpolyeeForm> empMap=empDB.editEmpList(empList);;
		return empMap;
		
		
	}
	public Map<Integer,EmpolyeeForm> deleteEmpList(List<String> empDeleteList){
		Map<Integer,EmpolyeeForm> empMap=empDB.deleteEmpList(empDeleteList);
		return empMap;
		
		
	}
	public Map<Integer,EmpolyeeForm> sortEmpList(){
		Map<Integer,EmpolyeeForm> empMap=new HashMap<Integer, EmpolyeeForm>();
		return empMap;
		
		
	}

	public EmpDB getEmpDB() {
		return empDB;
	}

	public void setEmpDB(EmpDB empDB) {
		this.empDB = empDB;
	}
	
}
