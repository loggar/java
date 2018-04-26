<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
</head>
<body>
	<div class="container">
		<p>
			<input id="btnClear" type="button" value="do" /> <input id="inputTargetMap" name="inputTargetMap" size="50" maxlength="50" />
		</p>
	</div>
	<script type="text/javascript">
		(function($) {
			$('#btnClear').click(function(e) {
				$.ajax({
					type : 'GET',
					url : "${pageContext.request.contextPath }/sample.get",
					dataType : 'text',
					data : {
						"parameter_1" : "some_value"
					},
				}).done(function(data) {
					console.log(data);
					$("#inputTargetMap").val(data);
				}).fail(function(data, textStatus, jqXHR) {
					console.log("error");
				});
			});
		})(jQuery);
	</script>
</body>
</body>
</html>