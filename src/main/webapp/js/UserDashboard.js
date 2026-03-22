
const user=document.getElementById("userlogo");
const userDetails=document.getElementById("pop");

userDetails.style.display="none"
let x=0;
user.addEventListener("click",()=>{
x++;
    if(x%2===0){

        userDetails.style.display="none"
    }
else{
userDetails.style.display="flex"
}

})


let name = localStorage.getItem("username");

let email = localStorage.getItem("email");

let mobile= localStorage.getItem("mobile");

let insertname=document.getElementById("uname").innerText=name;
let insertmobile=document.getElementById("umobile").innerText=mobile;
let insertemail=document.getElementById("uemail").innerText=email;




//fetch data from products 
fetch("/Ecommerce/shoeproduct", {
    method: "POST"
})
.then(response => {
    if (!response.ok) {
        throw new Error("HTTP error " + response.status);
    }
    return response.json();
})
.then(data => {
    console.log(data);
	
	
	let cartitem=document.getElementById("cartItem");
	data.forEach((e)=>{
		
		
		
		let cart=document.createElement("div");
		cart.className="mycart"
		let cartimage=document.createElement("img");
		
		
		
		cartimage.className="cartimage";
		cartimage.src = `${e.imageUrl}`; 
		
		let pprice=document.createElement("p");
		
		pprice.innerText= "Price : "+ e.price;
		
		let pname=document.createElement("p");

		pname.innerText=e.name;
		let pdesc=document.createElement("p");

			pdesc.innerText=e.description;
		
	let cartcount=document.createElement("button");
	cartcount.innerText="add"
		cartcount.className="addtocard";
		
		// cart to product
		cart.addEventListener("click", (event) => {

		    // Check if button was clicked
		    if (event.target.classList.contains("addtocard")) {

		        console.log("Product added:", e.product_id);
		        return;  // stop here, do not redirect
		    }

		    // Otherwise open product page
		    localStorage.setItem("selectedProduct", JSON.stringify(e));
		    window.location.href = "Product.html";

		});
		cart.append(cartimage);
		cart.append(pdesc);
		cart.append(pname);
		cart.append(pprice);
		cart.append(cartcount);
		cartitem.append(cart)
		
		 
		
		
	})
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
})
.catch(error => console.error(error));

