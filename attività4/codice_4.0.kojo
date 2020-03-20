// Cento mila miliardi di problemi 3.4.0
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

class Problema {
  

val personaggi 	= " giornalai"
val azione 		= " vendere "
val oggetti		= " giornali "

val X = 10
val Y = 2
val Z = 7


val  struttura = Map (
  1->Array("Due ",personaggi," iniziano insieme a ",azione,oggetti),
  2->Array("Il primo giorno uno dei due ",personaggi," ne riesce a ",azione,X, ", l'altro ",X,"/",Y),
  3->Array("E così di seguito."),
  4->Array("Dopo ",Z," giorni, quanti ",oggetti," possono ",azione," in tutto?")
  )
  
def fai_un_problema() {
 val s = Seq(1,2,3,4)
 s.foreach{ riga => 
      struttura(riga).foreach { elemento =>
         print(elemento)
     }
     println("")
    }
}

}

// main

 val problema = new Problema
 problema.fai_un_problema

