// Arte e parole 3.5.1
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

class DisegnaTesto {
val altezza = 50
val larghezza = 25
val consonantiList = List ("b","c","d","f","g","h","l","m","n","p","q","r","s","t","v","z")
val vocaliList = List("a","e","i","o","u")

val colore = Map (
  "vocali" ->  Color(0, 95, 177),
  "consonanti" -> Color(153, 153, 255)
 )
val forma = Map (
  "vocali" ->  "quadrato",
  "consonanti" -> "rettangolo"
 )

def quadrato (altezza: Int, larghezza: Int, colore : Color, lettera: Char, t: Turtle) {
 t.setPenColor(colore)
 t.setFillColor(colore)
 repeat (4){
   t.forward(altezza); 
   t.right(90);
 }
  t.write(lettera)
}
  
def rettangolo(altezza: Int, larghezza: Int, colore : Color, lettera: Char, t: Turtle) {
 t.setPenColor(colore)
 t.setFillColor(colore)
 repeat (2){
   t.forward(altezza); 
   t.right(90);
   t.forward(larghezza);
   t.right(90);
 }
  t.write(lettera)
 }

def sposta(larghezza: Int, t: Turtle){
  t.penUp
  t.right(90)
  t.forward(larghezza)
  t.left(90)
  t.penDown
}

def disegnaTesto(testo : String, t: Turtle) {
  testo.toString.split("[,;. ]+") foreach { parola =>
    disegnaParola(parola,t)
    sposta(larghezza,t)
  }
}

def disegnaParola (p : String, t: Turtle)  {
  p foreach { l => disegnaLettera(l,t)}
}

def coloreLettera (l : Char) : Color = {
  l match {
    case v if appartiene(vocaliList,v)     =>   colore("vocali")
    case c if appartiene(consonantiList,c) =>   colore("consonanti")
    case _ => Color(0,0,0)
  }
      
}

def formaLettera (l : Char) : String = {
  l match {
    case v if appartiene(vocaliList,v)     =>   forma("vocali")
    case c if appartiene(consonantiList,c) =>   forma("consonanti")
    case _ => "spazio"
  }
      
}

def disegnaLettera (l: Char, t : Turtle){
  val c : Color = coloreLettera(l)
  val f  = formaLettera(l)
  figura(f,c,l,t)
  sposta(larghezza,t)
}

def figura (f: String, c : Color, l: Char,t :Turtle) {
  f match {
    case "rettangolo" => rettangolo(altezza,larghezza,c,l,t)
    case "quadrato"   => quadrato(altezza/2,altezza/2,c,l,t)
    case _            => //rettangolo(altezza,larghezza,Color(0,0,0),l,t)
  }
  
}
def appartiene (categoria: List[String], lettera : Char) : Boolean = {
    categoria match {
     case List() => false
     case prima::resto if prima == lettera.toString.toLowerCase => true
     case _::resto =>  appartiene(resto,lettera)
   }
}
} // fine classe

val d = new DisegnaTesto

val lines = "Nel mezzo del cammin di nostra vita"

cleari()
val t = newTurtle
t.setAnimationDelay(100)
d.disegnaTesto(lines,t)
