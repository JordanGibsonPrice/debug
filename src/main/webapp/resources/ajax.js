window.onload = function(){
	
}
//create function to handle the XMLHttpRequest
//create a callback function for each AJAX task, The function call should contain the URL and what function to call when the response is ready.

function checkPassword() {
	  if (document.getElementById('pwd').value ==
	    document.getElementById('pwd-repeat').value) {
	    document.getElementById('message').style.color = 'green';
	    document.getElementById('message').innerHTML = 'matching';
	  } else {
	    document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'not matching';
	  }
	}


function SignUp(parameter){
	var xhr = new XMLHTTPRequest();
	var response = "";
	xhr.open('POST', 'EmployeesTable');
	xhr.onload = function() {
		if(this.readystate == 4){
			if (xhr.status === 200) {
				var response = alert(xhr.responseText);
			}
			else {
				alert('Request failed.  Returned status of ' + xhr.status);
				}
		}
	}
	xhr.open('POST', 'SignUpServlet');
	xhr.send(parameter);
}

SignUp("username:"+username+"&password:"+password+"&email:"+email+"&fname:"+fname+"&lname:"+lname);

function Register(){
	var forms = document.getElementsByName("registration");
	var param = "";
	for(let form of forms){
		param += form.name+":"+form.value+"&";
	}
	SignUp(param);
}


function SignIn(parameter){
	var xhr = new XMLHTTPRequest();
	var response = "";
	xhr.open();
	xhr.onload = function() {
		if(this.readystate == 4){
			if (xhr.status === 200) {
				var response = alert(xhr.responseText);
			}
			else {
				alert('Request failed.  Returned status of ' + xhr.status);
				}
		}
	}
	xhr.open('POST', 'ExistenceServlet'); //DO THIS
	xhr.send(parameter);
}

SignIn("username:"+username+"&password:"+password)