## foreach

### foreach 1

``` xml
// ibatis-3-mapper
<insert id="createAttendanceList" parameterType="map">
	INSERT INTO HS_TB_CLS_ATTENDANCE (STD_IDX, STD_ID, CLS_IDX, ATTEND_DATE, ATTEND_YN, CLS_SEQ, REMARK, INS_UID, UPD_UID, INS_DATE, UPD_DATE, DEL_FLAG) VALUES 
	<foreach item="item" index="i" collection="studentList" separator=",">
		(${item.STD_IDX}, (SELECT STD_ID FROM HS_TB_STUDENT_INFO WHERE STD_IDX = ${item.STD_IDX} AND IFNULL(DEL_FLAG,'N') = 'N'), ${clsIdx}, #{attendDate}, 'A', ${clsSeq}, '', #{insUid}, #{updUid}, NOW(3), NOW(3), 'N')
	</foreach>
</insert>
```

```

``` java
// data access object
@Override
public int createAttendanceList(List<Map<String, Object>> studentList, Map<String, Object> paramMap) {
	Map<String, Object> map = new HashMap<>();
	map.putAll(paramMap);
	map.put("studentList", studentList);
	return sqlSession.insert("scope.foreachExample1", map);
}
```

### foreach 2

``` xml
WHERE SBJ_IDX IN
<foreach item="item" index="index" collection="insertRplList" open="(" separator="," close=")">
	${item}
</foreach>
```

``` java
List<Integer> insertRplList = new ArrayList<>();
insertRplList.add(1);
insertRplList.add(2);

m.put("insertRplList", insertRplList);
return sqlSession.insert("scope.foreachExample2", m);

```