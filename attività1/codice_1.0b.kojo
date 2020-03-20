// E perché non un automa 3.1.0.b
// Copyright Stefano Penge 2017
// Released under GPL v.3.0


case class Coppia (nome : String, articolo : String) 


val dizionario = List(
  Coppia("gnomo", "uno"),
  Coppia("serpente", "un"),
  Coppia("squalo", "uno"),
  Coppia("albero", "un")
)


val risultato = ( 
	for {
	 	i <-  dizionario
		if (i.nome == "gnomo")
	}
	yield i.articolo + " " + i.nome
)
print( risultato match {
  case trovato :List[String] => risultato.head 
  case _ => "non ho trovato nulla"
})
