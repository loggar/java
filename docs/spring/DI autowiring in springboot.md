# Autowiring in Spring

## Autowiring `no`:

```xml
<bean id="department" class="guru.springframework.autowiringdemo.Department">
  <property name="deptName" value="Information Technology" />
</bean>
<bean id="employee" class="guru.springframework.autowiringdemo.Employee"></bean>
```

## Autowiring `byName`:

```xml
<bean id="department" class="guru.springframework.autowiringdemo.Department">
<property name="deptName" value="Information Technology" />
</bean>
<bean id="employee" class="guru.springframework.autowiringdemo.Employee" autowire="byName"></bean>
```

Spring boots:

```java
@SpringBootApplication
public class AutowiringdemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AutowiringdemoApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee emp = context.getBean("employee", Employee.class);
		emp.setEid(101);
		emp.setEname("Spring Framework Guru");
		emp.showEployeeDetails();
	}
}
```

## Autowiring `byType`:

```xml
<bean id="department" class="guru.springframework.autowiringdemo.Department">
<property name="deptName" value="Information Technology" />
</bean>
<bean id="employee" class="guru.springframework.autowiringdemo.Employee" autowire="byType"></bean>
```

## Autowiring `constructor`

```xml
<bean id="department" class="guru.springframework.autowiringdemo.Department">
<property name="deptName" value="Information Technology" />
</bean>
<bean id="employee" class="guru.springframework.autowiringdemo.Employee" autowire="constructor"></bean>
```

## Autowiring `autodetect`

```xml
<bean id="department" class="guru.springframework.autowiringdemo.Department">
<property name="deptName" value="Information Technology" />
</bean>
<bean id="employee" class="guru.springframework.autowiringdemo.Employee" autowire="autodetect"></bean>
```

## `@Autowired` Annotation

```java

@Configuration
@ComponentScan("guru.springframework.autowiringdemo")
public class AppConfig {}
```


Alternative:

```xml
<context:annotation-config />
```

## `@Autowired` on Properties

```java

import org.springframework.stereotype.Component;

@Component
public class Department {
	private String deptName;
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
```

```java
import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
    private int eid;
    private String ename;
    
    @Autowired private Department department;
    
    public int getEid() {
        return eid;
    }
    public void setEid(int eid) {
        this.eid = eid;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public void showEployeeDetails(){
        System.out.println("Employee Id : " + eid);
        System.out.println("Employee Name : " + ename);
        department.setDeptName("Information Technology");
        System.out.println("Department : " + department.getDeptName());
    }
}
```

## `@Autowired` on Setters

```java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    private int eid;
    private String ename;
    private Department department;
    
    public int getEid() {
        return eid;
    }
    public void setEid(int eid) {
        this.eid = eid;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public Department getDepartment() {
        return department;
    }
    
    @Autowired public void setDepartment(Department department) {
        this.department = department;
    }
    
    public void showEployeeDetails(){
        System.out.println("Employee Id : " + eid);
        System.out.println("Employee Name : " + ename);
        department.setDeptName("Information Technology");
        System.out.println("Department : " + department.getDeptName());
    }
}
```

## `@Autowired` on Constructors

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Employee {
    private int eid;
    private String ename;
    private Department department;
    
    @Autowired public EmployeeBean(DepartmentBean deptBean) {
        System.out.println("*** Autowiring by using @Autowire annotation on constructor ***");
        this.deptBean = deptBean;
    }
    
    public int getEid() {
        return eid;
    }
    public void setEid(int eid) {
        this.eid = eid;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public void showEployeeDetails(){
        System.out.println("Employee Id : " + eid);
        System.out.println("Employee Name : " + ename);
        department.setDeptName("Information Technology");
        System.out.println("Department : " + department.getDeptName());
    }
}
```

## Test

```java
@SpringBootApplication
public class AutowiringdemoApplication {
  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(AutowiringdemoApplication.class, args);
    Employee emp = context.getBean(Employee.class);
    emp.setEid(104);
    emp.setEname("Spring Framework Guru");
    emp.showEployeeDetails();
  }
}
```
