/**
 * 
 */


function signup(){

let uernamename=uname.value;
let umobile=mobile.value;

let uemail=email.value;
let upassword=pass.value;
let unewpassword=newpass.value


if(uernamename.length==0 || umobile.length==0||uemail.length==0||upassword==0){
	alert("any of field may empty fill it")
	return;
}





let body={

"name":uname.value,
"mobile":mobile.value,

"email":email.value,
"password":pass.value

}


fetch("/Ecommerce/Signup", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(body)
    })
    .then(res => res.json())
	.then(data => {
	    if (data === 1) {
			alert("Regestration Completed")
	        window.location.href = "Login.html";
	    } else {
	        alert("Invalid username or password");
			console.log("failedddd")
	    }
	});

	



}

