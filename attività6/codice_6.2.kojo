// Braille, ASCII e co. 3.6.2
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

class Braille {

var codiceBraille = Map (
  'a' -> Array(Array(1,0),Array(0,0),Array(0,0)),
  '1' -> Array(Array(1,0),Array(0,0),Array(0,0)),
  'b' -> Array(Array(1,0),Array(1,0),Array(0,0)),
  '2' -> Array(Array(1,0),Array(1,0),Array(0,0)),
  'c' -> Array(Array(1,1),Array(0,0),Array(0,0)),
  '3' -> Array(Array(1,1),Array(0,0),Array(0,0)),
  'd' -> Array(Array(1,1),Array(0,1),Array(0,0)),
  '4' -> Array(Array(1,1),Array(0,1),Array(0,0)),
  'e' -> Array(Array(1,0),Array(0,1),Array(0,0)),
  '5' -> Array(Array(1,0),Array(0,1),Array(0,0)),
  'f' -> Array(Array(1,1),Array(1,0),Array(0,0)),
  '6' -> Array(Array(1,1),Array(1,0),Array(0,0)),
  'g' -> Array(Array(1,1),Array(1,1),Array(0,0)),
  '7' -> Array(Array(1,1),Array(1,1),Array(0,0)),
  'h' -> Array(Array(1,0),Array(1,1),Array(0,0)),
  '8' -> Array(Array(1,0),Array(1,1),Array(0,0)),
  'i' -> Array(Array(0,1),Array(1,0),Array(0,0)),
  '9' -> Array(Array(0,1),Array(1,0),Array(0,0)),
  'j' -> Array(Array(0,1),Array(1,1),Array(0,0)),
  '0' -> Array(Array(0,1),Array(1,1),Array(0,0)) // da completare con le altre lettere
  )
  var codicePrefissi = Map (
  'm' -> Array(
    Array(0,1),
    Array(0,0),
    Array(0,1)
    ),
  'n' -> Array(
    Array(0,1),
    Array(0,1),
    Array(1,1)
    )
)


def disegnaParola(parola : String)  {
     parola.foreach { lettera =>
     lettera match {
       case y if (numero(lettera))   => disegnaCodice('n',lettera)
       case x if (maiuscola(lettera))=> disegnaCodice('m',lettera.toLower)
       case _                        => disegnaCodice('l',lettera.toLower)
     }
   }
}
    
 
  def disegnaCodice(tipo: Char, lettera : Char) {
  tipo match {
  case 'l' => {
    codiceBraille(lettera).foreach { coppia =>
              disegnaCoppia(coppia)
         }
  }
  case 'm' => {
    codicePrefissi('m').foreach { coppia =>
              disegnaCoppia(coppia)
         }
    sposta(300,"destra")
    sposta(300,"alto")     
    codiceBraille(lettera).foreach { coppia =>
              disegnaCoppia(coppia)
         }     
  }
  case 'n' => {
    codicePrefissi('n').foreach { coppia =>
              disegnaCoppia(coppia)
         }
    sposta(300,"destra")
    sposta(300,"alto")
    codiceBraille(lettera).foreach { coppia =>
              disegnaCoppia(coppia)
         }     
  }
  }
  sposta(300,"destra")
  sposta(300,"alto")
}

  def numero(cifra : Char): Boolean = {
    var numeri = List('0','1','2','3','4','5','6','7','8','9')
    numeri.contains(cifra)
    }

  def maiuscola(lettera : Char): Boolean = {
    lettera.toUpper == lettera
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
  def disegnaCoppia (a : Array[Int]) {
	for (i <- 0 to 1) {
		punto(a(i))  
		i match {
			case 0 => sposta(100,"destra")  
			case 1 => sposta(100,"sotto")  
		}    
	}
  }
}

clear
setAnimationDelay(10)
setPenColor(black)
var b = new Braille
b.disegnaParola("a3C")

