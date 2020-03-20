// Arte e parole 3.5.0
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

def disegnaTesto (t: Turtle, testo : String, quanto: Int) =  {
testo.foreach { s => 
  s match {
   case ' ' => t.setFillColor(Color(255, 255, 255))
   case 'A' => t.setFillColor(Color(0, 95, 177))
   case 'B' => t.setFillColor(Color(0, 153, 55))
   case 'C' => t.setFillColor(Color(211, 42, 59))
   case 'D' => t.setFillColor(Color(197, 118, 28))
   case 'E' => t.setFillColor(Color(0, 208, 232))
   case 'F' => t.setFillColor(Color(223, 123, 201))
   case 'G' => t.setFillColor(Color(195, 128, 0))   
   case 'H' => t.setFillColor(Color(0, 18, 22))
   case 'I' => t.setFillColor(Color(0, 246, 251))
   case 'L' => t.setFillColor(Color(46, 125, 0))
   case 'M' => t.setFillColor(Color(0, 85, 12))
   case 'N' => t.setFillColor(Color(0, 133, 13))
   case 'O' => t.setFillColor(Color(0, 17, 126))   
   case 'P' => t.setFillColor(Color(153, 153, 255))
   case 'Q' => t.setFillColor(Color(153, 153, 255))    
   case 'R' => t.setFillColor(Color(255, 255, 51))
   case 'S' => t.setFillColor(Color(255, 0, 255))
   case 'T' => t.setFillColor(Color(0, 102, 102))
   case 'U' => t.setFillColor(Color(0, 14, 67))    
   case 'V' => t.setFillColor(Color(102, 102, 0))     
   case 'Z' => t.setFillColor(Color(59, 0, 0))    
   case _ => t.setFillColor(Color(0,0,0))
   
 }
 rettangolo(quanto,s,t)
 t.right(90)
 t.forward(quanto/4)
 t.left(90)
} 
}

def rettangolo(quanto: Int, lettera: Char, t: Turtle) {
 repeat (2){
   t.forward(quanto); 
   t.right(90);
   t.forward(quanto/4);
   t.right(90);
 }
  t.write(lettera)
   
}

val t1 = newTurtle(0,0)
t1.setPenColor(Color(0, 0, 0))

val testo = "ERA UNA NOTTE BUIA E TEMPESTOSA"
disegnaTesto(t1,testo,50)

