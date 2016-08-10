package com.web.dummyDB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.web.form.EmpolyeeForm;

public class EmpDB {

	private Map<Integer, EmpolyeeForm> empMap = new HashMap<Integer, EmpolyeeForm>();

	public Map<Integer, EmpolyeeForm> getEmployeeList() {

		EmpolyeeForm emp1 = new EmpolyeeForm();
		emp1.setEmpId(1000);
		emp1.setName("A");
		emp1.setDepartment("IT");
		emp1.setDesignation("System Engineer");
		empMap.put(emp1.getEmpId(), emp1);
		EmpolyeeForm emp2 = new EmpolyeeForm();
		emp2.setEmpId(1001);
		emp2.setName("B");
		emp2.setDepartment("IT");
		emp2.setDesignation("ITA");
		empMap.put(emp2.getEmpId(), emp2);
		EmpolyeeForm emp3 = new EmpolyeeForm();
		emp3.setEmpId(1002);
		emp3.setName("C");
		emp3.setDepartment("IT");
		emp3.setDesignation("ASE");
		empMap.put(emp3.getEmpId(), emp3);
		EmpolyeeForm emp4 = new EmpolyeeForm();
		emp4.setEmpId(1003);
		emp4.setName("D");
		emp4.setDepartment("IT");
		emp4.setDesignation("Trainee");
		empMap.put(emp4.getEmpId(), emp4);
		return empMap;
	}

	public Map<Integer, EmpolyeeForm> addEmp(EmpolyeeForm emp) {

		empMap.put(emp.getEmpId(), emp);
		return empMap;
	}

	public Map<Integer, EmpolyeeForm> editEmpList(List<EmpolyeeForm> empList) {

		for (EmpolyeeForm emp : empList) {
			empMap.put(emp.getEmpId(), emp);
		}

		return empMap;
	}

	public Map<Integer, EmpolyeeForm> deleteEmpList(List<String> empList) {

		for (String emp : empList) {
			if (empMap.containsKey(Integer.valueOf(emp)))
				;
			empMap.remove(Integer.valueOf(emp));
		}

		return empMap;
	}

}
