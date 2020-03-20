// Sulle orme di Tolkien 3.8.0
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

import scala.util.Random

class Lingua {
val vocali = List ("a","e","i","o","ya","ua")
val consonanti = List("k","l","ng","mb","p","t", "'","-")

def periodo :String = {
  parola + " " + parola + " "+ parola
}
def parola: String = {
  sillaba + sillaba
}

def sillaba: String = {
  consonante + consonante + vocale
}

def consonante: String = {
  Random.shuffle(consonanti).head
}
def vocale: String = {
  Random.shuffle(vocali).head
}
}

val automa = new Lingua
print(automa.periodo)

