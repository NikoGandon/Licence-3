function changerCouleurBackground() {
    let couleurRandom = Math.floor(Math.random() * 16777215).toString(16);
    document.body.style.backgroundColor = "#" + couleurRandom;
    console.log(couleurRandom);
}

function ajoutPrix(product){
    //Ajout 1.3x au prix venant d'un bouton
    console.log("Ajout 1.3x au prix venant d'un bouton");
    product.prix += 1;
    console.log(product.prix);

}

function hideTableau(){
    //Cache le tableau
    const bouton = document.getElementById("boutonDisplay");
    if (document.getElementById("produit").style.display == "none"){
        document.getElementById("produit").style.display = "block";
        bouton.textContent = "Cacher le tableau";
    }
    else{
        document.getElementById("produit").style.display = "none";
        bouton.textContent = "Afficher le tableau";
    }
}

let allProducts;

function getProduit(){
    return fetch("produit.json").then(response => response.json()).then(data => {
        allProducts = data;
        console.log(allProducts);
        return allProducts;
    });
}

function creerTableauProduit(prod)
{
    if (prod == null)
        throw "Produit null";

    const table = document.getElementById("produit");
    const tbody = table.querySelector("tbody");

    prod.produit.forEach((product) => {
        const row = document.createElement("tr");
        const nameCell = document.createElement("td");
        const priceCell = document.createElement("td");
        const increaseButtonCell = document.createElement("td");
        const decreaseButtonCell = document.createElement("td");

        nameCell.textContent = product.nom;
        priceCell.textContent = product.prix;

        const increaseButton = document.createElement("button");
        increaseButton.textContent = "Augmenter";
        increaseButton.addEventListener("click", () => {
            product.prix += 1;
            priceCell.textContent = product.prix;
        });

        const decreaseButton = document.createElement("button");
        decreaseButton.textContent = "Réduire";
        decreaseButton.addEventListener("click", () => {
            product.prix -= 1;
            priceCell.textContent = product.prix;        
        });

        increaseButtonCell.appendChild(increaseButton);
        decreaseButtonCell.appendChild(decreaseButton);

        row.appendChild(nameCell);
        row.appendChild(priceCell);
        row.appendChild(increaseButtonCell);
        row.appendChild(decreaseButtonCell);

        tbody.appendChild(row);
    });
}

$(document).ready(function(){
    $("#cacher").click(function(){
        $("#produit").toggle();
    });
}
);