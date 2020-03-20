// E perché non un automa 3.1.1
// Copyright Stefano Penge 2017
// Released under GPL v.3.0


val artInDetList = List("un","uno")
val consonantiNormaliList = List ("b","c","d","f","g","h","l","m","n","p","q","r","s","t","v")
val consonantiStraneList = List ("z","gn","pn","ps","sb","sc","sf","sg","sl","sm","sn","sp","sq","st","sv")
val vocNormaliList = List("a","e","i","o","u")
val vocStraneList = List("ia","ie","io","iu")


def iniziaPerVocale (nome: String) : Boolean = {
    !vocNormaliList.filter(
      nome.startsWith(_)
    ).isEmpty
}

def iniziaPerVocaleStrana (nome: String) : Boolean = {
    !vocStraneList.filter(
      nome.startsWith(_)
    ).isEmpty
}

def iniziaPerConsonanteStrana (nome: String) : Boolean = {
    !consonantiStraneList.filter(
      nome.startsWith(_)
    ).isEmpty
}

def iniziaPerConsonanteNormale (nome: String) : Boolean = {
    !consonantiNormaliList.filter(
      nome.startsWith(_)
    ).isEmpty
}



def trovaArticolo (nome: String) : Any = {
  // trova l'articolo indeterminativo giusto

  val articoli =  artInDetList
   
  if (iniziaPerVocaleStrana(nome)) 		articoli.last
  if (iniziaPerVocale(nome))    		articoli.head
  if (iniziaPerConsonanteStrana(nome)) 	articoli.last
  if (iniziaPerConsonanteNormale(nome)) 	articoli.head  

} // end trovaArticolo


val nome = "squalo" 
println(trovaArticolo(nome) + " " + nome)
