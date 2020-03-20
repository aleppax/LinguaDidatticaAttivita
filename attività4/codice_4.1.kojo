// Cento mila miliardi di problemi 3.4.1
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

import scala.util.Random // serve ad avere a disposizione le funzioni che generano numeri a caso


class Problema {
  
def pesca (db:Map[String,Array[String]],tipo: String) : String = {
  val l = db(tipo).length
  val r = Random.nextInt(l)
  return  db(tipo)(r)
}
val etichette = Map(
  "personaggi"	->Array(" elefanti "," coccodrilli "," youtubers "),
  "azione"		->Array(" mangiare "," dipingere "," salutare "),
  "oggetti"		->Array(" gelati"," unghie"," fan")
  ) 
val personaggi = pesca(etichette,"personaggi")
val azione = pesca(etichette,"azione")
val oggetti = pesca(etichette,"oggetti")
val X = 1 + Random.nextInt(10)
val Y = 1 + Random.nextInt(X)
val Z = 1 + Random.nextInt(10)


val  struttura = Map (
  1->Array("Due ",personaggi," iniziano insieme a ",azione,oggetti),
  2->Array("Il primo giorno uno dei due ",personaggi," ne riesce a ",azione,X, ", l'altro ",X,"/",Y),
  3->Array("E così di seguito."),
  4->Array("Dopo ",Z," giorni, quanti ",oggetti," possono ",azione," in tutto?")
  )
  
def fai_un_problema() {
 val s = Seq(1,2,3,4)
 s.foreach{ q => 
      struttura(q).foreach { elemento =>
         print(elemento)
     }
     println("")
    }
}

def risolvi(): Int = {
  return Z * (X+X/Y)
}
   
} // fine classe Problema


// main

 val problema = new Problema
 problema.fai_un_problema()
 print("(psss... la soluzione è "+problema.risolvi+")")

