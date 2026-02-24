
const getProductByIdButton = document.getElementById("ApiButtonIdSearch");
const getProductByIdName = document.getElementById("ApiButtonNameSearch");
const getProductList = document.getElementById("ApiButtonList");
const formProductAdd = document.getElementById("ApiFormAdd");
const deleteProductByName = document.getElementById("ApiButtonDelete");
const logOutButton = document.getElementById("logOut");

const botonBusquedaId = document.getElementById("buttonIdSearch");
const boxBusquedaId = document.getElementById("boxIdSearch");
const botonBusquedaNombre = document.getElementById("buttonNameSearch");
const boxBusquedaNombre = document.getElementById("boxNameSearch");


const allBoxes = document.querySelectorAll(".SelectBox");

function hideAllBoxes() {
    allBoxes.forEach(box => {
        box.classList.add("hidden");
    });
} 

document.querySelectorAll("[data-target]").forEach(button => {
    button.addEventListener("click", () => {
        hideAllBoxes();
        const target = button.dataset.target;
        document.getElementById(target)
            .classList.remove("hidden");
    });
});


async function fetchOut(){
    await fetch("/logout",{
        method:"POST"
    })    
	window.location.href = "/login.html";  //Forzamos la salida del index
}

async function fetchId(){
    const displayId = document.getElementById("idSearchOutput")
    try{
        const productId = document.getElementById("productId").value;
        if(!productId) throw new Error("Faltan datos");
        console.log(productId)
        const ApiResponse = await fetch(`http://localhost:8080/api/idSearch/${productId}`,{
        method: 'GET'})
        if(!ApiResponse.ok){ 
            throw new Error("No se pudo conseguir el recurso");
        }

        const data = await ApiResponse.json();
        displayId.innerText = JSON.stringify(data, null, 2).replace(/[{}"]/g, "");

    }catch(error){
        console.log(error);
        displayId.innerText = error;

    }
}


async function fetchName(){
    const displayId = document.getElementById("nameSearchOutput")
    try{
        const productName = document.getElementById("productName").value;
        if(!productName) throw new Error("Faltan datos");
        const ApiResponse = await fetch(`http://localhost:8080/api/nameSearch/${productName}`,{
        method: 'GET',
            headers:{'Content-Type':'application/json',
            }
        })
        if(!ApiResponse.ok){ 
            throw new Error("No se pudo conseguir el recurso");
        }

        const data = await ApiResponse.json();
        displayId.innerText = JSON.stringify(data, null, 2).replace(/[{}"]/g, "");

    }catch(error){
        console.log(error);
        displayId.innerText = error;

    }
}



async function fetchList(){
    const displayId = document.getElementById("listOutput")
    try{
        const ApiResponse = await fetch(`http://localhost:8080/api/listProducts`,{
        method: 'GET',
            headers:{'Content-Type':'application/json',
            }
        })
        if(!ApiResponse.ok){ 
            throw new Error("No se pudo conseguir el recurso");
        }

        //indicar lista vacia sea el caso
        const data = await ApiResponse.json();
        displayId.innerText = JSON.stringify(data, null, 2).replace(/[{}"]/g, "");

    }catch(error){
        console.log(error);
        displayId.innerText = error;

    }
}



async function fetchAdd(){
    const displayId = document.getElementById("addOutput")
    const formData = new FormData(formProductAdd);
    const postData = Object.fromEntries(formData)
    try{
        console.log(JSON.stringify(postData))
        const ApiResponse = await fetch(`http://localhost:8080/api/crear`,{
        method: 'POST',
            headers:{'Content-Type':'application/json',
            },
            body: JSON.stringify(postData)
        })
        if(!ApiResponse.ok  ){ 
            const errorData = await ApiResponse.text();
            throw new Error(`Error ${ApiResponse.status}`);
        }

        const data = await ApiResponse.json();
        displayId.innerText = `Producto añadido: 
            ${JSON.stringify(data, null, 2).replace(/[{}"]/g, "")}`;

    }catch(error){
        console.log(error);
        displayId.innerText = error;
    }
}


async function fetchDelete(){
    const productName = document.getElementById("productNameD").value;
    const displayId = document.getElementById("deleteOutput");
    try{
        if(!productName) throw new Error("Falta ingresar datos");
        const ApiResponse = await fetch(`http://localhost:8080/api/eliminar/${productName}`,{
            method: "DELETE"
        })
        if(!ApiResponse.ok){
            throw new Error(`Error ${ApiResponse.status}`);
        }
        displayId.innerText = "Producto eliminado"
    }
    catch(error){
        console.log(error);
        displayId.innerText = error;
    }
}


logOutButton.addEventListener("click",fetchOut)

getProductByIdButton.addEventListener("click",fetchId)

getProductByIdName.addEventListener("click",fetchName)

getProductList.addEventListener("click",fetchList)

formProductAdd.addEventListener('submit',event =>{
    event.preventDefault();
    fetchAdd()
})

deleteProductByName.addEventListener("click", fetchDelete);