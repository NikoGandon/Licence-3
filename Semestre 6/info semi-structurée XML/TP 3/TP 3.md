1. 
   
```xml
let $movie := doc("books.xml")//FILM[TITRE = "Vertigo"]
return
    <ACTEURS>
    {
        for $actor in $movie/ACTEURS/ACTEUR
        return
            <ACTEUR>
                <NOM>{ $actor/NOM/text() }</NOM>
                <PRENOM>{ $actor/PRENOM/text() }</PRENOM>
            </ACTEUR>
    }
    </ACTEURS>
```

2. 
   
```xml
let $titles := distinct-values(doc("films.xml")//film/title) 
return
  <TITRES>
    {
		for $title in sort($titles)
         return <TITRE>{$title}</TITRE>
	}     
</TITRES>
```

3. 
   
```xml
doc("films.xml")//FILM[TITRE = "Reservoir Dogs"]/ACTEURS/ACTEUR[NOM = "Keitel"]/ROLE/text()
```

4. 

```xml
let $movie := doc("films.xml")//FILM[TITRE = "Eyes Wide Shut"] return     <METTEUR_EN_SCENE>         
	<NOM>{ $movie/METTEUR_EN_SCENE/NOM/text() } </NOM>
	<PRENOM>{ $movie/METTEUR_EN_SCENE/PRENOM/text() }</PRENOM>     </METTEUR_EN_SCENE>
```
