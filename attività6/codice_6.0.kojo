// Braille, ASCII e co. 3.6.0
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

val codiceASCII = Map (
  'A' -> 65,
  'B' -> 66,
  'E' -> 69,
  'N' -> 78,
  'S' -> 83,
  'T' -> 84,
  'Z' -> 90
  )

val parola = "BENE"

def codifica (parola: String) : Seq[Int]  = {
 for (lettera <- parola
  if (codiceASCII.contains(lettera)))
   yield (codiceASCII(lettera))
}


 
def deCodifica (codici: Seq[Int]) {
 codici foreach { codice =>
  codiceASCII foreach {
    case (lettera, numero) => if (numero == codice) print(lettera)
  }
}
}
  
deCodifica(codifica("ABBASTANZA BENE"))
 
