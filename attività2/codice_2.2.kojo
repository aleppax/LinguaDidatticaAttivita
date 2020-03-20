// Limericks digitali 3.2.2
// Copyright Stefano Penge 2017
// Released under GPL v.3.0
 
import scala.util.Random

class Metro {
  
def pesca (db:Map[String,Array[String]],tipo: String) : String = {
  val l = db(tipo).length
  val r = Random.nextInt(l)
  return  db(tipo)(r)
}
} // fine Metro

class Limerick extends Metro  {

val db = Map(
  "personaggio"->Array(" signore "," chirurgo "," elefante "),
  "aggettivo"->Array(" molto piccolo "," attivissimo "," a pallini "),
  "provenienza"->Array(" Como"," Alghero"," Milano"),
  "tempo"->Array("una volta ","un giono ","tutti i mesi "),
  "desiderio"->Array(" salì "," si addormentò "," giocava a tressette "),
  "luogo"->Array(" in cima al Duomo"," sotto un pero"," sul divano"),
  "evento"->Array("ma quando fu sulla cima","ma passate tre ore","ma mangiando le carte"),
  "risultato"->Array("era alto come prima","gli venne il mal di cuore","rimase in disparte"),
  "commento"->Array(" micropiccolo "," assonnato "," affamato ")
  )
val  struttura = Map (
  1->Array("Un",pesca(db,"personaggio"), pesca(db,"aggettivo"),"di",pesca(db,"provenienza")),
  2->Array(pesca(db,"tempo"), pesca(db,"desiderio"), pesca(db,"luogo")),
  3->Array(pesca(db,"evento")),
  4->Array(pesca(db,"risultato")),
  5->Array ("Quel",pesca(db,"commento"), pesca(db,"personaggio"),"di",pesca(db,"provenienza"))
  )
  
def fai_un_limerick {
 val s = Seq(1,2,3,4,5)
 s.foreach{ q => 
      struttura(q).foreach { elemento =>
         print(elemento)
     }
     println("")
    }
 }
   
}

} // fine Limerick


// main

 val limerick = new Limerick
 limerick.fai_un_limerick
