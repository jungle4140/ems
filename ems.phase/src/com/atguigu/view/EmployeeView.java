package com.atguigu.view;

import com.atguigu.bean.Employee;
import com.atguigu.service.EmployeeService;
import com.atguigu.utils.EMSUtility;

//呈现输入输出
//主菜单和分菜单
public class EmployeeView {
    private EMSUtility es = new EMSUtility();
    private EmployeeService service = new EmployeeService();

    public void mainMenu(){
        while (true){
        System.out.println("---------------员工信息管理---------------");
        System.out.println("\t\t\t\t1 添加员工");
        System.out.println("\t\t\t\t2 修改员工");
        System.out.println("\t\t\t\t3 删除员工");
        System.out.println("\t\t\t\t4 员工列表");
        System.out.println("\t\t\t\t5 退    出");
        System.out.print("\t\t\t请选择(1-5):");

        char select = es.readMenuSelection();
        switch (select) {
            case '1':
                addMenu();
                break;
            case '2':
                listMenu();
                updateMenu();
                listMenu();
                break;
            case '3':
                listMenu();
                deleteMenu();
                listMenu();
                break;
            case '4':
                listMenu();
                break;
            case '5':
                System.out.println("确认是否退出(Y/N):");
                char confirm = es.readConfirmSelection();
                if (confirm == 'Y') {
                    return;
                }

            }
        }
    }

    private void listMenu() {
        System.out.println("---------------员工列表----------------");
        Employee[] allEmployee = service.getAllEmployee();

        if (allEmployee.length == 0){
            System.out.println("暂时还没有员工");
        }else {
            System.out.println("编号\t姓名\t性别\t年龄\t工资\t电话\t\t\t邮箱");

            for (int i = 0; i < allEmployee.length; i++) {
                System.out.println((i+1) + "\t" + allEmployee[i].getInfo());
            }
        }

        System.out.println("--------------员工列表完成--------------");
    }

    private void deleteMenu() {
        System.out.println("---------------删除员工---------------");
        System.out.print("请选择待删除员工编号(-1退出):");
        int id = es.readInt();
        if (id == -1){
            return;
        }
        System.out.println("确认是否删除(Y/N):");
        char confirm = es.readConfirmSelection();
        if (confirm == 'Y'){
            boolean result = service.removeEmployeeId(id);
            System.out.println(result ? "删除成功" : "删除失败");
        }

        System.out.println("---------------删除完成---------------");
    }

    private void updateMenu() {
        System.out.println("---------------------修改员工---------------------");
        System.out.println("请选择待修改员工编号(-1退出):");
        int id = es.readInt();
        if (id == -1){
            return;
        }

        Employee employee = service.getEmployeeById(id);
        if (employee == null){
            return;
        }

        System.out.print("姓名("+ employee.getName() +"):");
        employee.setName(es.readString(20,employee.getName()));

        System.out.print("性别("+ employee.getGender() +"):");
        employee.setGender(es.readChar(employee.getGender()));

        System.out.print("年龄("+ employee.getAge() +"):");
        employee.setAge(es.readInt(employee.getAge()));

        System.out.print("工资("+ employee.getSalary() +"):");
        employee.setSalary(es.readDouble(employee.getSalary()));

        System.out.print("电话("+ employee.getTel() +"):");
        employee.setTel(es.readString(11,employee.getTel()));

        System.out.print("邮箱("+ employee.getEmail() +"):");
        employee.setEmail(es.readString(32,employee.getEmail()));

        System.out.println("---------------------修改完成---------------------");


    }

    private void addMenu() {
        System.out.println("---------------添加员工---------------");
        Employee employee = new Employee();

        System.out.print("姓名:");
        employee.setName(es.readString(20));

        System.out.print("性别:");
        employee.setGender(es.readChar());

        System.out.print("年龄:");
        employee.setAge(es.readInt());

        System.out.print("工资:");
        employee.setSalary(es.readDouble());

        System.out.print("电话:");
        employee.setTel(es.readString(11));

        System.out.print("邮箱:");
        employee.setEmail(es.readString(32));

        // System.out.println(employee.getInfo());
        //EmployeeService service = new EmployeeService();

        boolean result = service.addEmployee(employee);
        System.out.println(result ? "添加成功" : "添加失败");

        System.out.println("---------------添加完成---------------");

    }
}
