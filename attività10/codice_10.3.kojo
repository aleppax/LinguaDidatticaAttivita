// Musica a programma 3.10.3
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
sequenza.foreach { s => // s può essere C oppure C5 oppure Ci5
  var simbolo = s.toString
  var c : Int = simbolo.length
  var mod = "" // mod può essere majo min
  var nota = simbolo(0)
  if (c > 1 ) mod = simbolo.substring(1,2) else mod = ""
  nuovaSequenza +=  trasponi (nota.toString, quanto, verso) + mod + " "
} 
return nuovaSequenza
}

def trasponi (nota : String, quanto : Int, verso : String) : String = {
  verso match {
    case "+" => trasponiSu(nota, quanto)
    case _ => trasponiGiu(nota, quanto)
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


def accompagnamento (spostamenti : List[Int], modi : List[String], tonalita_iniziale : String, misure : Int) : String = {
var n = 0
val pattern =  spostamenti.map(q => trasponi(tonalita_iniziale, q,"+"))
var accompagnamento = ""
var listaModi = modi
pattern foreach { accordo =>
  var modo :: altriModi = listaModi
  listaModi = altriModi
  for (q <- 1 to misure){
    accompagnamento += accordo + modo + " "
  } 
} 
return accompagnamento  
}


def melodia (pattern : String, spostamenti : List[Int], modi : List[String], tonalita_iniziale : String) : String = {
  var mymelodia = ""
  var nuova_tonalita = ""
  var n = 0
  spostamenti foreach { q =>
    nuova_tonalita = trasponi(tonalita_iniziale, q,"+") + item(n,modi).toString.substring(0,3) 
    mymelodia+=   sposta(pattern,q,"+")
    n += 1
  }
  
  return  mymelodia
}


def item (n : Int, lista : List[Any]) : Any = {
  n match {
    case 0 => lista.head
    case _ => item((n-1),lista.tail)  
  }
 }

def muoviTarta (t: Turtle, programma : String, quanto: Int) = runInBackground {
val sequenza = programma.split(" ")
sequenza.foreach { s => // s può essere C oppure C5 oppure Ci5
  var simbolo = s.toString
  var nota = simbolo(0)
  nota match {
   case ' ' => t.forward(0)
   case 'A' => softRight(t,120); t.forward(quanto);  
   case 'B' => softLeft(t,45); t.back(quanto)
   case 'C' => softLeft(t,90); t.forward(quanto)
   case 'D' => softLeft(t,120); t.back(quanto)
   case 'E' => softRight(t,90); t.forward(quanto)
   case 'F' => softRight(t,120); t.back(quanto)    
   case 'G' => softRight(t,90); t.forward(quanto)    
   case 'R' => t.home()
 }
  t.write(nota)
} 
}

}

val a = new Automusic

val spostamenti = List (5,3,0,4)
val tonalita_iniziale = "C"
val modi = List("min","maj^^","maj^^","maj")

val pattern_melodia1 = "C5q G5h F5i E5i D5i C5h " 
val pattern_melodia2 = "G4 C5 Ei Ei Ch R"  
val pattern_melodia3 = "E E G F E C "  
val pattern_melodia4 = "C C Gi C C Gi "

val voce1 = a.melodia(pattern_melodia1,spostamenti,modi,tonalita_iniziale)
val voce2 = a.melodia(pattern_melodia2,spostamenti,modi,tonalita_iniziale)
val voce3 = a.melodia(pattern_melodia3,spostamenti,modi,tonalita_iniziale)
val voce4 = a.melodia(pattern_melodia4,spostamenti,modi,tonalita_iniziale)
val accompagnamento = a.accompagnamento(spostamenti,modi,tonalita_iniziale,misure)

val misure = 6

val spartito = MusicScore( 
      Melody("Choir_Aahs", 	voce1),
      Melody("Flute", 		voce2),
      Melody("Pizzicato_strings",voce3), 
      Melody("Cello", 		voce4),
      Melody("String_Ensemble_1",accompagnamento)
)

playMusic(spartito)

// sezione movimento tartarughe (invisibili)
cleari()
val t1 = newTurtle(-150,300)
val t2 = newTurtle(-300, -150)
val t3 = newTurtle(0, 0)
val t4 = newTurtle(300, 150)

val ritardo = 285
val tlist = List(t1,t2,t3,t4)
  tlist foreach { t =>
    t.setAnimationDelay(ritardo)
    t.setPenColor(Color(Random.nextInt(100),Random.nextInt(200),Random.nextInt(200)))
    t.invisible()  
 }

def softRight(t: Turtle, angolo : Int) {
  repeat (angolo){
    t.forward (1)
    t.right(1)
  }
}

def softLeft (t: Turtle, angolo : Int) {
  repeat (angolo){
    t.forward (1)
    t.left(1)
  }
}
val movimento = 50

a.muoviTarta(t1, voce1 ,movimento)
a.muoviTarta(t2, voce2, movimento)
a.muoviTarta(t3, voce3, movimento)
a.muoviTarta(t4, voce4, movimento)

