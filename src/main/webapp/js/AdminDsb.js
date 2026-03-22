
const add=document.getElementById("addproduct");
const showuser=document.getElementById("showuserbtn");
const form=document.getElementById("form");
const showuserdata=document.getElementById("showuser");
showuserdata.style.display="none";


showuser.addEventListener("click",()=>{

    if(showuserdata.style.display === "none"){
        showuserdata.style.display = "flex";
         form.style.display = "none";
    } else {
        showuserdata.style.display = "none";
    }

});

add.addEventListener("click",()=>{

    if(form.style.display === "none"){
        form.style.display = "flex";
        showuserdata.style.display === "none"
    } else {
        form.style.display = "none";
    }

});

















const pName = document.getElementById("p_name");
const pPrice = document.getElementById("p_price");
const pUrl = document.getElementById("p_url");
const pDesc = document.getElementById("p_desc");
const pBrand = document.getElementById("p_brand");
const pCat = document.getElementById("p_cat");
const s = document.getElementById("subit");
const quant = document.getElementById("quantity");
s.addEventListener("click", () => {

    const productData = {
        name: pName.value,
        price: parseInt(pPrice.value),
        imageUrl: pUrl.value,
        description: pDesc.value,
        brand: pBrand.value,
        category: pCat.value,
		quantity:parseInt(quant.value)
    };

    fetch("/Ecommerce/AddProduct", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(productData)
    })
    .then(res => res.json())
    .then(data => {
        if(data === true){
            alert("Product Added Successfully");
        } else {
            alert("Failed to Add Product");
        }
    })
    .catch(err => console.log(err));

});