package com.atguigu.bean;
/*
声明员工类Employee，
- 包含属性：姓名、性别、年龄、工资、电话、邮箱，属性私有化
- 提供get/set方法
- 提供String getInfo()方法
 */
public class Employee {
    private String name;
    private char gender;
    private int age;
    private double salary;
    private String tel;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfo(){
        return "\t" + name + "\t " + gender + "\t" + "\t" + age + "\t" + "\t" + salary + "\t" + tel + "\t" + "\t" + email;
    }

}
