
// Coniugo, coniugas, coniugat 3.9.2
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

def pres_ind_tutte ( radice : String, coniugazione:  Int) :  Map[Int, Map[Int,List[String]]] = {
 Map (
  1-> Map (
    1 -> List(radice,"","","o"),
    2 -> List(radice,"i","","s"),
    3 -> List(radice,"i","","t"),
    4 -> List(radice,"i","","mus"),
    5 -> List(radice,"i","","tis"),
    6 -> List(radice,"u","","nt")
  ),
  2 -> Map (
    1 -> List(radice,"","","o"),
    2 -> List(radice,"e","","s"),
    3 -> List(radice,"e","","t"),
    4 -> List(radice,"e","","mus"),
    5 -> List(radice,"e","","tis"),
    6 -> List(radice,"u","","nt")
  ),
  3 -> Map (
    1 -> List(radice,"","","o"),
    2 -> List(radice,"i","","s"),
    3 -> List(radice,"i","","t"),
    4 -> List(radice,"i","","mus"),
    5 -> List(radice,"i","","tis"),
    6 -> List(radice,"u","","nt")
  )
 )
}

def cercaParadigma(radice : String) : Int = {
  paradigmi.getOrElse(radice,1)
}


def coniuga_multi(radice : String){
val paradigma : Int = cercaParadigma(radice)
pres_ind_tutte (radice, paradigma) foreach {
  case (k,v) => {
          v foreach {
            case (i,l) => { 
              if (k==paradigma) 
                println(l.foldLeft("")((risultato,parziale) => risultato+parziale))}
            }
  }
}
}


coniuga_multi("ban")
