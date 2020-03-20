// Carte, forbici e sassi 3.7.0
// Copyright Stefano Penge 2017
// Released under GPL v.3.0


import scala.util.Random 

// le mosse possibili sono 3
val lista_mosse = Seq("Carta","Sasso","Forbici")

// la regola del gioco: carta vince su sasso, forbice su carta, sasso su forbice
val regola = Map (
  "Carta" -> "Sasso",
  "Forbici" -> "Carta",
  "Sasso" -> "Forbici"
  )

val manches  = Seq(1,2,3,4)

object Giudice {


def giudica(g1 : String, m1: String, g2 : String, m2: String) : String = {
   valuta(m1,m2)) match {
    case 1 =>  "Vince " + g1
    case 2 =>  "Vince " + g2
    case 0 => "Parità"
   }
}


def valuta(mossa1: String, mossa2: String): Int = {
  // restituisce uno di questi tre valori: 0 se sono pari, 1 se vince il primo e 2 se vince il secondo
  if (mossa1 == mossa2) 0 else 
  if (vince(mossa1,mossa2)) 1 else 2
}

def vince(mossa1 : String, mossa2 : String) : Boolean = {
// restuisce TRUE se mossa1 è vincente su mossa2
  regola(mossa1) == mossa2
}

def manche() : String = {
  val m1 = Uno.fai_mossa
  println(Uno.nome+" gioca "+m1)
  val m2 = Due.fai_mossa
  println(Due.nome+" gioca "+m2)
  giudica(Uno.nome,m1,Due.nome,m2)
}

def partita()  {
  manches.foreach (m  => 
    {
      println("Partita n."+m)
      println(manche())
      println("______")
    }
    )
}

} 

class Giocatore {
  var nome = ""
  def scegli_mossa_a_caso (): String = {
    lista_mosse(Random.nextInt(lista_mosse.length))
  }

  def fai_mossa(): String = {
   val m =  scegli_mossa_a_caso ()
   println(nome+" gioca "+m)
   return m
  }
}





val Minosse = Giudice
val Alan = new Giocatore
val Hal = new Giocatore
Hal.nome = "Hal"
Alan.nome = "Alan"
Minosse.partita

