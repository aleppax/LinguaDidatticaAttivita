// Arte e parole 3.5.2
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

class DisegnaTesto {
  val altezza = 50
  val larghezza = 25
  val consonantiLabialiList = List("b", "f", "m","p","v")
  val consonantiDentaliList = List("d", "l","n","r","s","t","z")
  val consonantiPalataliList = List("c", "g")
  val consonantiAltreList = List( "h",  "q")
  val vocaliAperteList = List("a", "e","è","ò")
  val vocaliChiuseList = List("é","i","o","u","ù")
  

  val colore = Map(
    "vocaliAperte" -> Color(0, 182, 225),
    "vocaliChiuse" -> Color(102, 23, 234),
    "consonantiLabiali" -> Color(255, 67, 80),
    "consonantiDentali" -> Color(0, 171, 53),
    "consonantiPalatali" -> Color(255, 255, 0),
    "consonantiAltre" -> Color(153, 153, 153)
  )
  val forma = Map(
    "vocaliAperte" -> "quadrato",
    "vocaliChiuse" -> "quadrato",
    "consonantiLabiali" -> "rettangolo",
    "consonantiDentali"  -> "rettangolo",
    "consonantiPalatali" -> "rettangolo",
    "consonantiAltre"  -> "rettangolo"
  
  )

  def quadrato(altezza: Int, larghezza: Int, colore: Color, lettera: Char, t: Turtle) {
    t.setPenColor(colore)
    t.setFillColor(colore)
    repeat(4) {
      t.forward(altezza);
      t.right(90);
    }
    t.write(lettera)
  }

  def rettangolo(altezza: Int, larghezza: Int, colore: Color, lettera: Char, t: Turtle) {
    t.setPenColor(colore)
    t.setFillColor(colore)
    repeat(2) {
      t.forward(altezza);
      t.right(90);
      t.forward(larghezza);
      t.right(90);
    }
    t.write(lettera)
  }

  def sposta(larghezza: Int, t: Turtle) {
    t.penUp
    t.right(90)
    t.forward(larghezza)
    t.left(90)
    t.penDown
  }

   def aCapo(altezza: Int, t: Turtle) {
    val ps = t.position
    val x = -800
    val y = ps.y - 80
    t.setPosition(x, y)
    t.penDown
    
  }

  def disegnaTesto(testo: String, t: Turtle) {
    testo.toString.split("[,;. ]+") foreach { parola =>
      disegnaParola(parola, t)
      if (t.position.x>500) aCapo(100,t)
      sposta(larghezza, t)
    }
  }

  def disegnaParola(p: String, t: Turtle) {
    p foreach { l => disegnaLettera(l, t) }
  }

  def coloreLettera(l: Char): Color = {
    l match {
      case v if appartiene(vocaliAperteList, v)  => colore("vocaliAperte")
      case v if appartiene(vocaliChiuseList, v)  => colore("vocaliChiuse")
      case c if appartiene(consonantiLabialiList, c) => colore("consonantiLabiali")
      case c if appartiene(consonantiDentaliList, c) => colore("consonantiDentali")
      case c if appartiene(consonantiPalataliList, c) => colore("consonantiPalatali")
      case c if appartiene(consonantiAltreList, c) => colore("consonantiAltre")
      case _                                  => Color(0, 0, 0)
    }

  }

  def formaLettera(l: Char): String = {
    l match {
      case v if appartiene(vocaliAperteList, v)  => forma("vocaliAperte")
      case v if appartiene(vocaliChiuseList, v)  => forma("vocaliChiuse")
      case c if appartiene(consonantiLabialiList, c) => forma("consonantiLabiali")
      case c if appartiene(consonantiDentaliList, c) => forma("consonantiDentali")
      case c if appartiene(consonantiPalataliList, c) => forma("consonantiPalatali")
      case c if appartiene(consonantiAltreList, c) => forma("consonantiAltre")
      case _                                  => "spazio"
    }

  }

  def disegnaLettera(l: Char, t: Turtle) {
    val c: Color = coloreLettera(l)
    val f = formaLettera(l)
    figura(f, c, l, t)
    sposta(larghezza, t)
  }

  def figura(f: String, c: Color, l: Char, t: Turtle) {
    f match {
      case "rettangolo" => rettangolo(altezza, larghezza, c, l, t)
      case "quadrato"   => quadrato(altezza / 2, altezza / 2, c, l, t)
      case _            => //rettangolo(altezza,larghezza,Color(0,0,0),l,t)
    }

  }
  def appartiene(categoria: List[String], lettera: Char): Boolean = {
    categoria match {
      case List() => false
      case prima :: resto if prima == lettera.toString.toLowerCase => true
      case _ :: resto => appartiene(resto, lettera)
    }
  }
} // fine classe

val d = new DisegnaTesto
val source = scala.io.Source.fromFile("/home/stefano/Dropbox/coding/testo.txt")
val lines = try source.mkString finally source.close()


cleari()
val t = newTurtle
t.setAnimationDelay(10)
t.setPosition(-800,150)

d.disegnaTesto(lines, t)

