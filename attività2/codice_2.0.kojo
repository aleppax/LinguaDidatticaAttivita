// Limericks digitali 3.2.0
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

import scala.util.Random // serve ad avere a disposizione le funzioni che generano numeri a caso

class Limerick {
// ogni riga è composta da più versi
val prima_riga = List ("Un signore molto piccolo di Como","Un chirurgo daltonico di Alghero","Un elefante a pallini di Milano")
var seconda_riga = List ("una volta salì in cima al Duomo","un giorno si addormentò sotto un pero","voleva giocare a tressette sul divano")
var terza_riga = List ("ma quando fu sulla cima","passarono tre ore","ma perdeva le carte")
var quarta_riga = List ("era alto come prima","e gli venne il mal di cuore","e restava in disparte")
var quinta_riga = List ("Quel signore micro piccolo di Como","Quell'assonnato chirurgo di Alghero","Quell'irascibile elefante di Milano")

// la lista db (che sta per "database", cioè archivio) li contiene tutti
var db = List( prima_riga, seconda_riga, terza_riga, quarta_riga, quinta_riga)

def fai_un_limerick {
  for (
    riga <- db
  )  println(pesca(riga))
}
def pesca (riga: List [String]): String = {
// mescola una riga e prende il primo verso
  return Random.shuffle(riga).head
}
} 

// main
 val limerick = new Limerick
 limerick.fai_un_limerick

