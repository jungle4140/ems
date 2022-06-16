package com.atguigu.service;

import com.atguigu.bean.Employee;

//对应业务层，负责员工对象的存储、管理(增、删、改、查)
public class EmployeeService {
    private Employee[] all = new Employee[5];

    public int total;
    public boolean addEmployee(Employee employee){
        if (total >= 5){
            System.out.println("人员已招满，下次再来");
            return false;
        }

        all[total++] = employee;
        return true;
    }

    public Employee[] getAllEmployee(){
        Employee[] result = new Employee[total];

        for (int i = 0; i < total; i++){
           result[i] = all[i];
       }
        return result;
    }

    public boolean removeEmployeeId(int id){
       if (id <= 0 || id > total){
           System.out.println(id + "对应的员工不存在");
           return false;
       }
        int index = id -1;
        for (int i = index; i < total; i++){
            all[i] = all[i+1];
        }
        all[--total] = null;
        return true;
    }

    public Employee getEmployeeById(int id){
        if (id <= 0 || id > total){
            System.out.println(id + "对应的员工不存在");
            return null;
        }
        return all[id-1];
    }
}
