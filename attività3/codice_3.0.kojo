// Leggibile da un computer 3.3.0
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

var testo = "Chiamatemi Ismaele. Qualche anno fa - non importa ch'io vi dica quanti - avendo poco o punto denaro in tasca e niente che particolarmente m'interessasse a terra, pensai di mettermi a navigare per un po', e di vedere così la parte acquea del mondo. Faccio in questo modo, io, per cacciar la malinconia e regolare la circolazione. Ogniqualvolta mi accorgo di mettere il muso; ogniqualvolta giunge sull'anima mia un umido e piovoso novembre; ogniqualvolta mi sorprendo fermo, senza volerlo, dinanzi alle agenzie di pompe funebri o pronto a far da coda a ogni funerale che incontro; e specialmente ogniqualvolta l'umor nero mi invade a tal punto che soltanto un saldo principio morale può trattenermi dall'andare per le vie col deliberato e metodico proposito di togliere il cappello di testa alla gente - allora reputo sia giunto per me il momento di prendere al più presto il mare."
//dividi il testo in parole, usando come separatore  lo spazio  " "
var parole = testo.split("\\s+") // divide quando trova uno spazio
// calcola la lunghezza del testo  in parole (nP)
var nP = parole.length
 // somma la lunghezza di tutte le parole (LP)
var LP = parole.toList.foldLeft(0)((totale, parola) => parola.length + totale)
// dividi il testo in frasi, usando come separatore il punto "."
var frasi = testo.split("\\.") // divide quando trova un punto
// calcola la lunghezza del testo in frasi (nF)
var nF = frasi.length
// calcola l'indice applicando la formula 
var GULPEASE = 89 - (10 *LP / nP ) + (300*nF/nP)
println(GULPEASE)
