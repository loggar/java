## CALL PROCEDURE

> MYBATIS STORED PROCEDURE SAMPLE

```
<?xml version = "1.0" encoding = "UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
	
<mapper namespace = "Student">	
		
   <resultMap id = "result" type = "Student">
      <result property = "id" column = "ID"/>
      <result property = "name" column = "NAME"/>
      <result property = "branch" column = "BRANCH"/>
      <result property = "percentage" column = "PERCENTAGE"/>
      <result property = "phone" column = "PHONE"/>
      <result property = "email" column = "EMAIL"/>
   </resultMap>   
   
   <select id = "callById" resultMap = "result" parameterType = "Student" statementType = "CALLABLE">
      {call read_record_byid(#{id, jdbcType = INTEGER, mode = IN})}
   </select>   
    	
</mapper>
```
