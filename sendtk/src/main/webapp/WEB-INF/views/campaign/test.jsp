<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/assets/global/css/multiple-select.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>
 <div class="form-group">
        <label>Month</label>
        <select id="ms" multiple="multiple">
            <optgroup label="Group 1">
            	<option value="1">Option 1</option>
	        </optgroup>
	        <optgroup label="Group 3">
            	<option value="9">Option 9</option>
        	</optgroup>
        </select>
    </div>
    
   <div>
   	salam
   </div>
</body>
<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery/jquery-1.11.1.min.js"> </script>
<script src="${pageContext.request.contextPath}/assets/global/js/jquery.multiple.select.js">		</script> <!--  Multiselect with checkboxe -->
<script>
    $(function() {
        $('#ms').change(function() {
            console.log($(this).val());
        }).multipleSelect({
            width: '100%'
        });
    });
</script>
</html>