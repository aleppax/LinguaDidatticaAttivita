// Carte, forbici e sassi 3.7.2
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

import scala.util.Random 
import collection.mutable.{ Stack, Queue } // serve ad avere il supporto per stack e code

val lista_mosse = Seq("C","S","F")

val manches_vincenti = Map (
  "C" -> "S",
  "F" -> "C",
  "S" -> "F"
  )

var Tabellone = scala.collection.mutable.Map(
  "Uno" -> 0,
  "Due" -> 0
  )

val manches  = 1 to 30

object Giudice {

def giudica(g1 : String, m1: String, g2 : String, m2 : String)  {
   val v = valuta(m1,m2) 
   v match {
    case 1 =>  {
      Tabellone ("Uno") +=1
      println("Vince " + g1)
      Due.ricorda(m1,m2,v.toString) 
      m1
    }
    case 2 => {
      Tabellone ("Due") +=1
      println("Vince " + g2)
      Due.ricorda(m1,m2,v.toString) 
      m2
    }
    case _ =>{
      println("Parità")
      "0"
    }
   }
   
  
   
}

def valuta(mossa1: String, mossa2: String): Int = {
  if (mossa1 == mossa2) 0 else 
  if (manches_vincenti(mossa1) == mossa2) 1 else 2
}


def manche  {
  val m1 = Uno.fai_mossa("")
  println(Uno.nome+" gioca "+m1)
  
  val m2 = Due.fai_mossa(m1)
  println(Due.nome+" gioca "+m2)
  
  giudica(Uno.nome,m1,Due.nome,m2)
  
}

def partita()  {
  manches.foreach (m  => 
    {
      println("Partita n."+m)
      manche
      println("______")
    }
    )
    println("Tabellone:")
    Tabellone.foreach ( p =>
      {
      p._1 match {
        case "Uno" => println(Uno.nome+": "+ p._2 + " (su " + manches.size + ")")
        case "Due" => println(Due.nome+": "+ p._2 + " (su " + manches.size + ")")
      }
      }
     )
}

} 

class Giocatore {
  var nome = ""
  def scegli_mossa_a_caso: String = {
    lista_mosse(Random.nextInt(lista_mosse.length))
  }
  
}

class GiocatoreCasuale extends Giocatore  {
  
  def fai_mossa(mossa1 : String): String = {
     val m =  scegli_mossa_a_caso 
     println(nome,m)
     return m
  }
}

class GiocatoreStrategico extends Giocatore 
{

  var memoria = Stack.empty[List[String]]
  
  def  fai_mossa(mossa : String): String = {
   val controMossa = cercaControMossa(mossa)
   if (controMossa.isEmpty) {
       println("Niente, gioco a caso") 
       scegli_mossa_a_caso
   } else {
     println("Trovato!")   
     return controMossa
   }
 
  }

  def ricorda (mossa1 : String, mossa2 : String, valutazione : String)   {
      memoria.push(List(mossa1,mossa2,valutazione))
   }

  def cercaEsempio (mossa : String, posizione: String, valutazione : String) : Stack[List[String]] = {
      posizione match {
       case "1" => memoria.filter { 
        manche => ((manche(0) == mossa) & (manche(2) == valutazione)) 
       }
       case "2" =>  memoria.filter { 
          manche => ((manche(1) == mossa) & (manche(2) == valutazione)) 
       }
     }
     
     
  }
  def cercaControMossa(mossa : String): String = {
      var posizione = "1"
      var valutazione = "2"
      println(s"Sto cercando $mossa in posizione $posizione con valutazione $valutazione ...")
      var esempio = cercaEsempio(mossa,posizione,valutazione)
      if (esempio.isEmpty){
        posizione = "2"
        valutazione = "1"
        println(s"Sto cercando $mossa in posizione $posizione con valutazione $valutazione ...")
        esempio = cercaEsempio(mossa,posizione,valutazione)
        if (esempio.isEmpty) {
          return ""
        } else {
          var uno = esempio.pop
          return uno(0)
          
        }  
      } else {
          var uno = esempio.pop
          return uno(1)
      }
   }
}

val Minosse =  Giudice
val Uno = new GiocatoreCasuale
val Due = new GiocatoreStrategico
Due.nome = "Hal"
Uno.nome = "Alan"
Minosse.partita

