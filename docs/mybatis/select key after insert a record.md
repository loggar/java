## select key after insert a record

``` xml
// ibatis-3-mapper
<insert id="insertBoard" parameterType="com.loggar.domain.board.BoardDomain">
	INSERT INTO HS_TB_CM_BOARD (
		BRD_TITLE
	) VALUES (
		#{brdTitle}
	)
	<selectKey keyProperty="brdIdx" resultType="int" order="AFTER" >
		SELECT MAX(BRD_IDX) AS BRD_IDX FROM HS_TB_CM_BOARD
	</selectKey>
</insert>
```

``` java
// data access object
@Override
public int get(Map<String, Object> map) {
	int n = sqlSession.insert("board.insertBoard", map);
	int brdIdx = Integer.parseInt(map.get("brdIdx").toString());
	return brdIdx;
}
```
