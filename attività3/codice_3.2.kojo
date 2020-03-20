// Leggibile da un computer 3.3.2
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

class Strumenti {

def conta_frasi (testo: String) : Int = {
  trova_frasi(testo).length
}
def trova_frasi (testo: String) : Array[String] = {
  testo.split("\\.") // divide quando trova un punto
}
def conta_parole(frase: String) : Int = {
 misura_lunghezza_frase(trova_parole(frase))
}

def trova_parole(frase: String) : Array[String] = {
  frase.split("\\s+") // divide quando trova uno spazio; vanno aggiunti altri segni
}

def misura_lunghezza_parola(parola: String) : Int = {
  parola.length
}
def misura_lunghezza_frase(frase: Array[String]) : Int = {
  frase.length
}
def trova_lunghezza_media_parole(frase: Array[String]) : Int = {
  // lunghezza media delle parole (in lettere)
  val lunghezza =  misura_lunghezza_frase(frase)
  var totale = 0
  frase.foreach { parola =>
    totale +=  misura_lunghezza_parola(parola)
  } 
  return totale/lunghezza
 }
 
def trova_lunghezza_media_frasi(testo:  Array[String]) : Int = {
  //  lunghezza media delle frasi di un testo (in parole)
  val lunghezza =  misura_lunghezza_frase(testo)
  var totale = 0
  testo.foreach { frase =>
    totale += conta_parole(frase)
  } 
  return totale/lunghezza 
}

def conta_parole_lunghe(frase: Array[String], media: Int) : Int = {
  var lunghe = 0
  frase.foreach { parola =>
    if (parola.length > media) lunghe += 1
  }
  return lunghe 
}
def conta_frasi_lunghe(testo: String, media: Int) : Int = {
val frasi = trova_frasi(testo)
var lunghe = 0
var n = 1
  frasi.foreach { frase =>
    print(s"$n $frase")
    if (frase.length > media) { 
      lunghe += 1
      println("*")
    }
    n += 1
  }
  return lunghe
}

def elenca_parole_lunghe(testo: Array[String], media: Int) : String = {
  var lista_lunghe = ""
  testo.foreach { parola =>
    if (parola.length > media) lista_lunghe += parola + "; "
  }
  return lista_lunghe
}
}

class Analizzatore extends Strumenti {

def analizza(testo : String) {
  val lunghezza_testo = conta_frasi(testo)
  val lunghezza_media_frasi = trova_lunghezza_media_frasi(trova_frasi(testo))
  val lunghezza_media_parole = trova_lunghezza_media_parole(trova_parole(testo))
  val numero_frasi_lunghe = conta_frasi_lunghe(testo,lunghezza_media_frasi)
  val numero_parole_lunghe = conta_parole_lunghe(trova_parole(testo),lunghezza_media_parole)
  val parole_lunghe = elenca_parole_lunghe(trova_parole(testo),lunghezza_media_parole)
  println(s"Frasi: $lunghezza_testo")
  println(s"Lunghezza media frasi: $lunghezza_media_frasi parole.")
  println(s"Frasi lunghe (>$lunghezza_media_frasi): $numero_frasi_lunghe")
  println(s"Lunghezza media parole: $lunghezza_media_parole lettere")
  println(s"Parole lunghe (>$lunghezza_media_parole): $numero_parole_lunghe")
  println(s"Parole lunghe: $parole_lunghe")
}
}

val a = new Analizzatore
a.analizza(testo)

