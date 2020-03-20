// E perché non un automa 3.1.0.a
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

// dizionario:
val dizionario = Map (
  "gnomo"->"uno",
  "serpente"->"un",
  "squalo"->"uno",
  "albero"->"un"
) 


val risultato = dizionario.get("gnomo") 

risultato match {
	  case Some(articolo) => print(articolo + " gnomo")
	  case None   => print("Boh!")
} 
