// Coniugo, coniugas, coniugat 3.9.0
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

import scala.collection.mutable.ArrayBuffer

def pres_ind (radice : String) : Map[Int,List[String]] = {
  1 -> List(radice,"i","v","o"),
  2 -> List(radice,"i","v","i"),
  3 -> List(radice,"i","v","e"),
  4 -> List(radice,"i","v","iamo"),
  5 -> List(radice,"i","v","ite"),
  6 -> List(radice,"i","v","ono")
)
}


def coniuga(schema : Map[Int,List[String]], persona : Int) : String = {
 schema(persona).fold ("")((finale,elemento) => finale + elemento)
}


println(coniuga(pres_ind("trim"),5))

