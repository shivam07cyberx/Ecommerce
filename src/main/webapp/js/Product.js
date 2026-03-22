/**
 * 
 */// Get stored product
let productData = localStorage.getItem("selectedProduct");

// Convert string → object
let product = JSON.parse(productData);

// Check if product exists
if (product) {

    document.getElementById("pimg").src = product.imageUrl;
    document.getElementById("pname").innerText = "Product Name: "+product.name;
    document.getElementById("pprice").innerText = "Price: " + product.price;
    document.getElementById("pdesc").innerText = product.description;
	


} else {

    console.log("No product found");
}

console.log(product);