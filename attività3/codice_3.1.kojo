// Leggibile da un computer 3.3.1
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

var frasi = testo.split("[\\.;]") // divide quando trova un punto o un punto e virgola
var nF = frasi.size
var LP : Int = 0
var nP : Int = 0
var frasePulita = ""
var espressioneRegolare = "[-']".r
var parole = Array("")
var n = 0
frasi.foreach (frase => {
   n += 1
   frasePulita = espressioneRegolare replaceAllIn(frase," ")
   println(n,frasePulita)
   LP += frase.length
   parole = frasePulita.split("\\s")
   nP += parole.length
})

// calcola l'indice applicando la formula 
var GULPEASE = 89 - (10 *LP / nP ) + (300*nF/nP)
println("Lunghezza in parole",nP)
println("Lunghezza in lettere",LP)
println("Numero di frasi",nF)
println("GULPEASE",GULPEASE)
GULPEASE match {
  case a if a<=50 => println("Scarsa")
  case a if a<70 => println("Media")
  case _         => println("Buona")
}
