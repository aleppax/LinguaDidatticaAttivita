// Musica a programma 3.10.1
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

class Automusic {

val trasposizioni = Map (
    "A" -> List("G","B"),
    "B" -> List("A","C"),        
    "C" -> List("B","D"),        
    "D" -> List("C","E"),        
    "E" -> List("D","F"),        
    "F" -> List("E","G"),        
    "G" -> List("F","A"),
    "R" -> List("R","R")                    
)



def sposta (seq: String, quanto : Int, verso : String): String = {
var nuovaSequenza = ""
val sequenza = seq.split(" ")
sequenza.foreach { s => 
  var simbolo = s.toString
  var c : Int = simbolo.length
  var mod : Char  = ' '
  var nota = simbolo(0)
  if (c > 1 ) mod = simbolo(1)
  
  nuovaSequenza +=  trasponi (nota.toString, quanto, verso) + mod + " "
} 
return nuovaSequenza

}

def trasponi (nota : String, quanto : Int, verso : String) : String = {
  verso match {
    case "+" => trasponiSu(nota, quanto)
    case _   => trasponiGiu(nota, quanto)
  } 
}
  
def trasponiSu (nota : String, quanto : Int) : String = {
  quanto match {
    case 0 => nota
    case _ => trasponiSu(trasposizioni(nota).last,quanto-1) 
  }
}

def trasponiGiu (nota : String, quanto : Int) : String = {
  quanto match {
    case 0 => nota
    case _ => trasponiGiu(trasposizioni(nota).head,quanto-1)
  }
}


def melodia (pattern : String, spostamenti : List[Int], modi : List[String], tonalita_iniziale : String) : String = {
//spostamenti.map( q => sposta(pattern,q,"+"))
  var mymelodia = ""
  spostamenti foreach { q =>
    mymelodia+=  sposta(pattern,q,"+")
  }
  val nuova_tonalita = cambia_tonalita(tonalita_iniziale, modi, spostamenti)
  return nuova_tonalita + mymelodia
}

def cambia_tonalita (tonalita : String, modi : List[String], spostamenti : List[Int]) : String = {
  "K" + trasponi(tonalita.head.toString, spostamenti.head,"+") + modi.head.toString + " "
 }

}

val a = new Automusic

val pattern_melodia1 = "C D E C "
val pattern_melodia2 = "E F G R "
val pattern_melodia3 = "Gi Ai Gi Fi E C "
val pattern_melodia4 = "C G4 C R "
val pausa = "R "

val tonalita_iniziale = "C"
val spostamenti = List(2) // corrisponde al Re
val modi = List("min")

val base = pattern_melodia1*2 + pattern_melodia2*2 + pattern_melodia3*2 + pattern_melodia4*2 
val voce1 = a.melodia(base,spostamenti,modi,tonalita_iniziale)
val voce2 = pausa*8 + voce1
val voce3 = pausa*16 + voce1
val voce4 = pausa*24 + voce1

val spartito = MusicScore(
      Melody("FRENCH_HORN",voce1 ),
      Melody("CELLO", 	voce2),
      Melody("OBOE", 	voce3), 
      Melody("VIOLIN", 	voce4) 
     
)

playMusic(spartito)

