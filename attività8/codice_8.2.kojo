// Sulle orme di Tolkien 3.8.2
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

import scala.util.Random

class Lingua {
val vocali = List ("a","a","a","e","e","e","i","o","o","o","u")
val consonanti = List("b","c","d","f","g","g","che","chi","l","l","l","m","m","n","n","n","p","p","qu","r","r","r","s","s","s","t","t","t","v","v","z")
val tipi_sillabe = List("v","cv","cv","cv","vc","vc","vc","cvc","cvc","ccv")

def periodo (lunghezza : Int) : String = {
    lunghezza match {
    case 0 => ""
    case _ => {
              val numero_sillabe = Random.nextInt(5) 
              parola(numero_sillabe) + " " + periodo(lunghezza -1)
              }
    }
} 

def parola (lunghezza: Int) : String = {
  lunghezza match {
    case 0 => vocale
    case _ => sillaba + parola(lunghezza -1)
  }
}

def sillaba: String = {
  val tipo_sillaba =  Random.shuffle(tipi_sillabe).head
  tipo_sillaba match {
    case "v" => vocale
    case "cv" =>  consonante + vocale
    case "vc" =>  vocale + consonante
    case "cvc" => consonante + vocale + consonante
    case "ccv" => consonante + consonante + vocale
    }
}

def consonante: String = {
  Random.shuffle(consonanti).head
}
def vocale: String = {
  Random.shuffle(vocali).head
}
}

val automa = new Lingua
val frase  = automa.periodo(5).capitalize +", "+automa.periodo(3) +", " +automa.periodo (5) +"."
println(frase)

