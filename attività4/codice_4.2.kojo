// Cento mila miliardi di problemi 3.4.2
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

import scala.util.Random // serve ad avere a disposizione le funzioni che generano numeri a caso

class Problema {
// le funzioni generali buone per qualsiasi tipo di problema
val etichette = Map(
  "personaggi"->Array(" elefanti "," coccodrilli "," youtubers "),
  "azione"    ->Array(" mangiare "," dipingere "," salutare "),
  "oggetti"   ->Array(" gelati"," unghie"," fan")
  )

val lista_operazioni = List("somma","differenza","prodotto","quoziente")

val nomi_operazioni = Map(
  "somma"          ->List("addizione","più"),
  "differenza"     ->List("sottrazione","meno"),
  "prodotto"       ->List("moltiplicazione","per"),
  "quoziente"      ->List("divisione","diviso")
  )
       
def esegui(operazione : String, x : Float, y : Float) : Float = {
  operazione match {
    case "addizione" 		=> x + y
    case "sottrazione" 	=> x - y
    case "moltiplicazione"  	=> x * y
    case "divisione" 		=> x / y
  }
}
 
def pesca (db:Map[String,Array[String]],tipo: String) : String = {
  val lunghezza = db(tipo).length
  val numero_a_caso = Random.nextInt(lunghezza)
  return  db(tipo)(numero_a_caso)

}

def pesca_operazione(lista_operazioni: List[String]) : String = lista_operazioni(Random.nextInt(lista_operazioni.length))
  
def traduci_operazione(tipo: String, operazione: String, nomi_operazioni:Map[String,List[String]]) : String =  {
  tipo match {
 	case "etichetta"=> nomi_operazioni(operazione).last
  	case _ 	=> nomi_operazioni(operazione).head
  }
}

} // fine Classe Problema 

class Problema_moltiplica extends Problema {
// questa classe contiene le proprietà e i metodi specifici per questo tipo di problema

val personaggi = pesca(etichette,"personaggi")
val azione = pesca(etichette,"azione")
val oggetti = pesca(etichette,"oggetti")

val X : Int = 1 + Random.nextInt(10) // deve essere positivo
val Y : Int = 1 + Random.nextInt(X-1) // deve essere più piccolo di X e maggiore di zero
val Z : Int= 1 + Random.nextInt(10) // deve essere positivo

val variabili = List(X,Y,Z)

val operazione1 = pesca_operazione(lista_operazioni)
val etichetta_operazione1 = traduci_operazione("etichetta",operazione1,nomi_operazioni)
val funzione_operazione1 =  traduci_operazione("nome",operazione1,nomi_operazioni)

val operazione2 = pesca_operazione(lista_operazioni)
val etichetta_operazione2 = traduci_operazione("etichetta",operazione2,nomi_operazioni)
val funzione_operazione2 =  traduci_operazione("nome",operazione2,nomi_operazioni)

val  struttura = Map (
  1->Array("Due ",personaggi," iniziano insieme a ",azione,oggetti),
  2->Array("Il primo giorno uno dei due ",personaggi," ne riesce a ",azione,X, ", l'altro ",X," ",etichetta_operazione1," ",Y),
  3->Array("E così di seguito."),
  4->Array("Dopo ",Z," giorni, qual è il risultato della ", funzione_operazione2, " tra gli oggetti che è riuscito a ",azione,"il primo e gli oggetti che è riuscito a ",azione," il secondo ?")
  )

def fai_un_problema() = {
 println("==================")
 val s = Seq(1,2,3,4) 
 s.foreach{ q => 
      struttura(q).foreach { elemento =>
         print(elemento.toString)
     }
     println("")
    }
 }

def risolvi(): Float = {
esegui("moltiplicazione",Z,esegui(funzione_operazione2,X,esegui(funzione_operazione1,X,Y)))
}
 
} // fine Classe Problema_moltiplica


// main
val problema = new Problema_moltiplica
problema.fai_un_problema()
print("(psss... la soluzione è " + problema.risolvi + ")")
