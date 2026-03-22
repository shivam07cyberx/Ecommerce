const btn = document.getElementById("Login");

btn.addEventListener("click", function () {

    const username = document.getElementById("user_username").value;
    const password = document.getElementById("usesr_password").value;

    const data = {
        username: username,
        password: password
    };
	
	
	if(username.length<3 || password.length<8){
		alert("length of username and passowrd is short");
		return;
		
	}
	
	
	

    fetch("/Ecommerce/Loginvalidate", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        if(data!==null && data.status==="user"){
			localStorage.setItem("username", data.name);
			localStorage.setItem("mobile", data.mobile);
			localStorage.setItem("email", data.email);
			window.location.href="/Ecommerce/html/UserDashboard.html";
			
		}
		
		else if(data.status==="admin"){
			localStorage.setItem("username", data.name);
					localStorage.setItem("mobile", data.mobile);
					localStorage.setItem("email", data.email);
					window.location.href="/Ecommerce/html/AdminDsb.html";}
		else{
			alert("invalid credentials")
			console.log(data)
		}
		
		
    })
    .catch(error => console.log(error));

});