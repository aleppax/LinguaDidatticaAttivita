// E perché non un automa 3.1.2
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

class Articoli  {
val artInDetList = List("un","uno")
val artDetList = List ("il","lo")
val artSconList = List ()
val consonantiNormaliList = List ("b","c","d","f","g","h","l","m","n","p","q","r","s","t","v")
val consonantiStraneList = List ("z","gn","pn","ps","sb","sc","sf","sg","sl","sm","sn","sp","sq","st","sv")
val vocNormaliList = List("a","e","i","o","u")
val vocStraneList = List("ia","ie","io","iu")


def iniziaPer (iniziali: List[String], nome : String) : Boolean = {
    iniziali.filter(nome.startsWith(_)) match {
     case Nil => false;
     case _ => true
   }
}


def trovaTipoArticolo (articolo: String) : List[String] = {
    // trova il tipo e restituisce la lista di articoli adeguata 
    
   if (artInDetList.contains(articolo)) 
     return artInDetList
   
   if (artDetList.contains(articolo)) 
     return artDetList
   
   return artSconList
   
}

def trovaArticolo (nome: String) : Any = {
  // trova l'articolo giusto
  
  val articoli =  trovaTipoArticolo(articolo)
  if (articoli.isEmpty)
    return "Boh"
    
  if ((iniziaPer(vocStraneList, nome)) || (iniziaPer(consonantiStraneList, nome)))
    return articoli.last
    
  if ((iniziaPer(vocNormaliList, nome)) || (iniziaPer(consonantiNormaliList, nome)))
    return articoli.head
   
}


} // end class Articoli


// main
val automa_articoli = new Articoli
val articolo = "il"
val nome = "gnomo"
println(automa_articoli.trovaArticolo(nome) + " " + nome)

