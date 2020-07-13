
	 function validCheck(){
			
		   	var isValid = validator.form();
		   	if(!isValid) validator.focusInvalid();
			return isValid;
		}
	 
	 validator = $("form[role='form']").validate({
			rules:{
				"witer":{ required:true },
				"title":{ required:true },
			},
			messages:{
				"writer":{ required:"작성자를 입력해 주십시오 !" },
				"title":{ required:"제목을 입력해 주십시오 !" },
			},
			focusInvalid:true
		});
	 
	 
	 
	 
