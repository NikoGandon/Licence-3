function changerCouleurBackground() {
    let couleurRandom = Math.floor(Math.random() * 16777215).toString(16);
    document.body.style.backgroundColor = "#" + couleurRandom;
    console.log(couleurRandom);
}

function ajoutPrix(){
    //Ajout 1.3x au prix venant d'un bouton
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
    //Recupere le tableau créé dans le html
    let tableau = document.getElementById("produit").getElementsByTagName("tbody")[0];
    allProducts.produit.forEach(element => {
        const a = document.createElement("tr");
        a.innerHTML += "<td>" + element.nom + "</td><td>" + element.prix + "</td><td><button onclick='ajoutPrix()'>Augmenter</button></td><td><button>Diminuer</button></td>";
        tableau.appendChild(a);
    });
}