// E perché non un automa 3.1.3
// Copyright Massimo Ghisalberti 2017
// Released under GPL v.3.0


object Articoli {
  val Determinativo = "determinativo"
  val Indeterminativo = "indeterminativo"
  val Maschile = "maschile"
  val Femminile = "femminile"
  val Elisione = "elisione"
  val Boh = "Boh!"
}

class Articoli {

  import Articoli._

  val articoli = Map(
    Indeterminativo -> Map(
      Maschile -> List("un", "uno"),
      Femminile -> List("una"),
      Elisione -> List("un'")
    ),
    Determinativo -> Map(
      Maschile -> List("il", "lo"),
      Femminile -> List("la"),
      Elisione -> List("l'")
    )
  )
  val vocaliPerGenere = Map(
    Maschile -> List('i', 'o', 'u'),
    Femminile -> List('a', 'e')
  )

  val iniziali = List("x", "y", "z", "gn", "pn", "ps", "sb", "sc", "sf", "sg", "sl", "sm", "sn", "sp", "sq", "st", "sv")

  def vocali: List[Char] = vocaliPerGenere.foldLeft(List[Char]())((acc, l) => acc ++ l._2)

  def trovaArticolo(articolo: String): Option[(String, String, String)] = {
    val ret = for {
      tipo <- articoli.keys
      genere <- articoli(tipo).keys
      if articoli(tipo)(genere).contains(articolo)
    } yield (tipo, genere, articolo)
    if (ret.isEmpty) None else Some(ret.head)
  }

  def iniziaPerVocale(nome: String): Boolean = vocali.contains(nome.head)

  def iniziaPerCoppia(nome: String): Boolean = {
    val coppia = nome.slice(0, 2)
    iniziali.contains(coppia.head.toString) ||
    iniziali.contains(coppia) ||
    (vocali.contains(coppia.head.toString) && vocali.contains(coppia.last.toString)) ||
    (iniziali.contains(coppia.head.toString) && !vocali.contains(coppia.last.toString))
  }

  def genereMaschile(nome: String): Boolean = {
    val l = nome.toList
    l.last == 'o' || l.last == 'i' || l.last == 'e'
  }

  def generefemminile(nome: String): Boolean = {
    val l = nome.toList
    l.last == 'a' || l.last == 'e'
  }

  def genere(nome: String): String = if (genereMaschile(nome)) Maschile else Femminile

  def mettiArticolo(nome: String, tipo: String): String = {
    val gen = genere(nome)
    val articolo = tipo match {
      case Determinativo => {
        if (iniziaPerVocale(nome)) articoli(tipo)(gen).last
        else if (iniziaPerCoppia(nome)) articoli(tipo)(gen).last
        else if (!iniziaPerVocale(nome)) articoli(tipo)(gen).head
        else Boh
      }
      case Indeterminativo =>
        if (iniziaPerVocale(nome)) articoli(tipo)(gen).head
        else if (iniziaPerCoppia(nome)) articoli(tipo)(gen).last
        else if (!iniziaPerVocale(nome)) articoli(tipo)(gen).last
        else Boh
      case _ => Boh
    }
    s"${articolo} ${nome}"
  }
}

// main
val automa_articoli = new Articoli


List("gnoma", "squalo", "serpente", "albero", "ala", "pane", "albatro").foreach { nome =>
  println(automa_articoli.mettiArticolo(nome, Articoli.Indeterminativo))
}
List("gnoma", "squalo", "serpente", "albero", "ala", "pane", "albatro").foreach { nome =>
  println(automa_articoli.mettiArticolo(nome, Articoli.Determinativo))
}
