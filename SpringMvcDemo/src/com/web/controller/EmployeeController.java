package com.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.form.EmpolyeeForm;
import com.web.services.EmpService;

@Controller
public class EmployeeController {

	private EmpService empService ;

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView empoyee(ModelMap model) {

		Map<Integer, EmpolyeeForm> empMap = empService.getEmpList();
		List<EmpolyeeForm> empList = empMapToList(empMap);

		model.addAttribute("empList", empList);
		return new ModelAndView("employeeDetails", "command",
				new EmpolyeeForm());
	}

	@RequestMapping(value = "/editEmp", method = RequestMethod.POST)
	public ModelAndView editEmployee(
			@ModelAttribute("empFormList") EmpolyeeForm empFormList,
			ModelMap model) {
		System.out.println("In edit function");
		System.out.println(empFormList);
		System.out.println(empFormList.getEmpId());
		System.out.println(empFormList.getName());
		System.out.println(empFormList.getDepartment());
		System.out.println(empFormList.getDesignation());
		System.out.println(empFormList.getEditEmp());
		List<EmpolyeeForm> empList = getEmpListForEdit(empFormList);
		Map<Integer, EmpolyeeForm> empMap = empService.editEmpList(empList);
		// List<EmpolyeeForm> empMapToList(empMap) = empMapToList(empMap);

		model.addAttribute("empList", empMapToList(empMap));

		return new ModelAndView("editedEmp", "command", new EmpolyeeForm());
	}

	@RequestMapping(value = "/getEmpForDetete", method = RequestMethod.GET)
	public ModelAndView getEmpForDetete(ModelMap model) {

		Map<Integer, EmpolyeeForm> empMap = empService.getEmpList();
		List<EmpolyeeForm> empList = empMapToList(empMap);

		model.addAttribute("empList", empList);
		return new ModelAndView("empDeletePage", "command", new EmpolyeeForm());
	}

	@RequestMapping(value = "/deleteEmp", method = RequestMethod.POST)
	public ModelAndView deleteEmployee(
			@ModelAttribute("empFormList") EmpolyeeForm empFormList,
			ModelMap model) {
		System.out.println("In delete function");
		System.out.println(empFormList.getDeleteEmp());
		String empDelete[] = empFormList.getDeleteEmp().split(",");
		List<String> emplist = Arrays.asList(empDelete);
		Map<Integer, EmpolyeeForm> empMap = empService.deleteEmpList(emplist);

		model.addAttribute("empList", empMapToList(empMap));

		return new ModelAndView("deleteEmp", "command", new EmpolyeeForm());
	}

	@RequestMapping(value = "/getEmployeeDetails", method = RequestMethod.GET)
	public ModelAndView getEmployeeDetails(ModelMap model) {

		Map<Integer, EmpolyeeForm> empMap = empService.getEmpList();
		List<EmpolyeeForm> empList = empMapToList(empMap);

		model.addAttribute("empList", empList);
		return new ModelAndView("employeeDetailsPage", "command",
				new EmpolyeeForm());
	}

	@RequestMapping(value = "/sortEmp", method = RequestMethod.GET)
	public ModelAndView sortEmpDetails(ModelMap model) {

		Map<Integer, EmpolyeeForm> empMap = sortEmp(empService.getEmpList());
		
		
		List<EmpolyeeForm> empList = empMapToList(empMap);

		model.addAttribute("empList", empList);
		return new ModelAndView("employeeDetailsPage", "command",
				new EmpolyeeForm());
	}

	public List<EmpolyeeForm> empMapToList(Map<Integer, EmpolyeeForm> treeMap) {

		List<EmpolyeeForm> empolyeeFormList = new ArrayList<EmpolyeeForm>();

		Set keys = treeMap.keySet();
		for (Iterator i = keys.iterator(); i.hasNext();) {
			Integer key = (Integer) i.next();
			EmpolyeeForm value = (EmpolyeeForm) treeMap.get(key);
			empolyeeFormList.add(value);
			System.out.println("Emp Id:" + value.getEmpId() + " | "
					+ "First Name:" + value.getName() + " | " + "Department:"
					+ value.getDepartment() + " | " + "Designation:"
					+ value.getDesignation());
		}
		return empolyeeFormList;
	}

	public List<EmpolyeeForm> getEmpListForEdit(EmpolyeeForm empForm) {

		List<EmpolyeeForm> empList = new ArrayList<EmpolyeeForm>();

		String[] dept = empForm.getDepartment().split(",");
		String[] desig = empForm.getDesignation().split(",");
		String[] name = empForm.getName().split(",");
		String[] empIdList = empForm.getEditEmp().toString().split(",");
		EmpolyeeForm emp;
		for (int i = 0; i < Arrays.asList(empIdList).size(); i++) {
			emp = new EmpolyeeForm();
			emp.setEmpId(Integer.valueOf(empIdList[i]));
			emp.setName(name[i]);
			emp.setDepartment(dept[i]);
			emp.setDesignation(desig[i]);
			empList.add(emp);
		}
		return empList;

	}

	public Map<Integer, EmpolyeeForm> sortEmp(Map<Integer, EmpolyeeForm> emplist) {
		Map<Integer, EmpolyeeForm> treeMap = new TreeMap(emplist);

		return treeMap;
	}

	public EmpService getEmpService() {
		return empService;
	}
@Autowired
@Qualifier("empService")
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
}
