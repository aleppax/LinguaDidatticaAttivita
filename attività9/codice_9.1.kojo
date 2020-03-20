// Coniugo, coniugas, coniugat 3.9.1
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

import scala.collection.mutable.ArrayBuffer

def pres_ind (radice : String) : Map[Int,List[String]] = {
Map (
  1 -> List(radice,"","","o"),
  2 -> List(radice,"i","","s"),
  3 -> List(radice,"i","","t"),
  4 -> List(radice,"i","","mus"),
  5 -> List(radice,"i","","tis"),
  6 -> List(radice,"u","","nt")
)
}


def  imp_ind (radice : String) : Map[Int,List[String]] = {
  Map (
  1 -> List(radice,"e","ba","m"),
  2 -> List(radice,"e","ba","s"),
  3 -> List(radice,"e","ba","t"),
  4 -> List(radice,"e","ba","mus"),
  5 -> List(radice,"e","ba","tis"),
  6 -> List(radice,"e","ba","nt")
)
}

def fut_ind (radice : String) : Map[Int,List[String]] = {
  Map (
  1 -> List(radice,"a","","m"),
  2 -> List(radice,"e","","s"),
  3 -> List(radice,"e","","t"),
  4 -> List(radice,"e","","mus"),
  5 -> List(radice,"e","","tis"),
  6 -> List(radice,"e","","nt")
)
}


def coniuga(schema : Map[Int,List[String]], persona : Int) : String = {
 schema(persona).fold ("")((finale,elemento) => finale + elemento)
}

def coniuga_tutto(schema : Map[Int,List[String]]) : String = {
 var tabella = ArrayBuffer[String]()
 for (persona <- 1 to 6){
    tabella += coniuga(schema,persona)
 }
 return tabella.mkString(",")
}



println(coniuga_tutto(pres_ind("lun")))

