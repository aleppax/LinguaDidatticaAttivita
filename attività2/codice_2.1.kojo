// Limericks digitali 3.2.1
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

import scala.util.Random


class Metro {
 
def trova_rima (rima: String, riga: Array[Map[String,String]]): Map[String,String] = {
val l = riga.length
var r = 0
var volte = 0
val basta = 20
while ((riga(r)("rima") != rima) && (volte<basta)){
  r = Random.nextInt(l) 
  volte = volte +1   
}
return riga(r)
}
def pesca (riga: Array[Map[String,String]]): Map[String,String] = {
val l = riga.length
val r = Random.nextInt(l)
return riga(r)
}

} // fine Metro

class Limerick extends Metro {

val db = Map(
  1->Array(
    Map(
    "rima"->"omo",
    "verso"->"Un signore molto piccolo di Como"),
    Map(
      "rima"->"ero",
      "verso"->"Un chirurgo daltonico di Alghero"),
    Map(
      "rima"->"ano",
      "verso"->"Un elefante a pallini di Milano")
    ),
  2->Array(
    Map("rima"->"omo","verso"->"una volta salì in cima al Duomo"),Map("rima"->"ero","verso"->"un giorno si addorment sotto un pero"),Map("rima"->"ano","verso"->"voleva giocare a tressette sul divano")
    ),
  3->Array(
    Map("rima"->"ima","verso"->"ma quando fu sulla cima"),Map("rima"->"ore","verso"->"passarono tre ore"),Map("rima"->"arte","verso"->"ma perdeva le carte")
    ),
  4->Array(
    Map("rima"->"ima","verso"->"era alto come prima"),Map("rima"->"ore","verso"->"e gli venne il mal di cuore"),Map("rima"->"arte","verso"->"e restava in disparte")
    ),
  5->Array(
    Map("rima"->"omo","verso"->"Quel signore micro piccolo di Como"),Map("rima"->"ero","verso"->"Quell'assonnato chirurgo di Alghero"),Map("rima"->"ano","verso"->"Quell'irascibile elefante di Milano")
    )
  )

def fai_un_limerick {
   
    val riga1 = pesca(db(1))
    println(riga1("verso"))
  
  // il secondo deve rimare col primo
    val riga2 = trova_rima(riga1("rima"),db(2))
    println(riga2("verso"))

    val riga3 = pesca(db(3))
    println(riga3("verso"))
  
  // il quarto deve rimare col terzo 
    val riga4 = trova_rima(riga3("rima"),db(4))
    println(riga4("verso"))
  
  // l'ultimo deve rimare col primo
    val riga5 = trova_rima(riga1("rima"),db(5))
    println(riga5("verso"))
}

} // fine Limerick


// main

 val limerick = new Limerick
 limerick.fai_un_limerick

