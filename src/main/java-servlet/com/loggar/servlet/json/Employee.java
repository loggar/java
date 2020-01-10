package com.loggar.servlet.json;

public class Employee {
    private int id;
    private String name;
    private String department;
    private long salary;

    public Employee(int id, String name, String department, long salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employee [id=")
                .append(id)
                .append(", name=")
                .append(name)
                .append(", department=")
                .append(department)
                .append(", salary=")
                .append(salary)
                .append("]");
        return builder.toString();
    }

}
