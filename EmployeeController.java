package com.example.hw14.Controller;

import com.example.hw14.ApiRespons.ApiRespons;
import com.example.hw14.model.Employee;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    ArrayList<Employee> employees = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @PostMapping("/add")
    public ResponseEntity addEmployees(@RequestBody @Valid Employee employee, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.add(employee);
        return ResponseEntity.status(200).body(new ApiRespons("employee add"));
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateEmployees(@PathVariable int index, @RequestBody @Valid Employee employee, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.set(index, employee);
        return ResponseEntity.status(200).body(new ApiRespons("Employees update"));

    }

    @DeleteMapping("/delete/{index}")
    public ApiRespons deleteEmployees(@PathVariable int index) {
        employees.remove(index);
        return new ApiRespons("delete Employees");
    }

    @PutMapping("/EmployeesApply/{index}")
    public ResponseEntity EmployeesApply(@PathVariable int index) {

        for (Employee employee : employees) {
            if (employees.get(index).getOnLeave()==true) {
                    return ResponseEntity.status(400).body("The employee is currently on leave");
                }
                if (employee.getAnnualLeave() == 0) {
                    return ResponseEntity.status(400).body("The employee does not have a leave");
                }
                employee.setOnLeave(true);
                employee.setAnnualLeave(employee.getAnnualLeave() - 1);
                return ResponseEntity.status(200).body(new ApiRespons("The employee is on leave"));
            }
        return ResponseEntity.status(400).body("try again");

        }
    }




