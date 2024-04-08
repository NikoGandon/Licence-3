# Exercice 1

1. //actor
2. count(//actor)
3. //comment()
4. //*
5. //@*
6. //actor/@*
7. (//comment())[2]
8. (//actor/*)[1]
9. //actor/*[last()]
10. //actor[firstname="Clint"]
11. //actor/site[@url]
12. //actor/biography

# Exercice 2

1. //CD/performance/composition 
2. //composition[count(ancestor::performance/soloist)=1]
3. //performance[orchestra and not(soloist)]
4. //CDlist/CD[publisher="Deutsche Grammophon"]/performance[orchestra="London Symphony Orchestra"]/soloist
5. //CD[performance/orchestra = "London Symphony Orchestra"]

# Exrecice 3

1. sum(//rcp:ingredient[contains(@name, "egg")]/@amount)
2. //rcp:ingredient[contains(@name, "olive oil")]
3. //rcp:recipe/rcp:title/text()
4. //rcp:recipe[rcp:nutrition/@calories < 500]/rcp:title/text()
5. //rcp:recipe[rcp:title="Zuppa Inglese"]/rcp:ingredient[@name = "sugar"]/@amount
6. //rcp:recipe[rcp:title="Zuppa Inglese"]/rcp:preparation/rcp:step[position() <= 2]/text()
7. //rcp:recipe[count(rcp:preparation/rcp:step) < 5]/rcp:title/text()
8. Est-ce possible ? On a besoin de ``//rcp:recipe[rcp:title = 'Zuppa Inglese']/rcp:ingredient/@name``,
9.
10. //rcp:recipe[not(rcp:ingredient[contains(@name, "butter")])]/rcp:title/text()
