// Braille, ASCII e co. 3.6.1
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

class Braille {

var codiceBraille = Map (
  'A' -> Array(Array(1,0),Array(0,0),Array(0,0)),
  'B' -> Array(Array(1,0),Array(1,0),Array(0,0)),
  'C' -> Array(Array(1,1),Array(0,0),Array(0,0)) // completare con le altre lettere
  )
    
  def disegnaParola(parola : String)  {
     parola.foreach { lettera =>
     codiceBraille(lettera).foreach { coppia =>
          disegnaCoppia(coppia)
     }
     sposta(300,"destra")
     sposta(300,"alto")
   }
  
  }
  def punto(p : Int) {
   p match {
           case 0 => setFillColor(white)
           case 1 => setFillColor(black)
         }
         penDown
         repeat(360){ 
           forward(0.1)
           right(1)
         }
         penUp
  }

  def sposta(quanto: Int, verso: String){
  verso match {
    case "destra" =>  {
      right(90)
      forward(quanto)
      left(90)    
    }
    case "sotto"  =>  {
      left(90)
      forward(quanto)
      left(90)    
      forward(quanto)
      right(180)
    }
    case "alto" =>  {
      forward(quanto)
    }
  }
  
  }
  def disegnaCoppia (coppia : Array[Int]) {
      var p1 = coppia(0)
      punto(p1)
      sposta(100,"destra")  
      var p2 = coppia(1)
      punto(p2)
      sposta(100,"sotto")  
  }
}

clear
setAnimationDelay(10)
setPenColor(black)
var b = new Braille
b.disegnaParola("ABC")


