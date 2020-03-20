/*
Nota: per eseguire il codice occorre prima salvarlo come file di testo (ad esempio come limericks.pl), poi lanciare l'interprete Prolog (es. swipl o gprolog), infine caricare il sorgente scrivendo: consult(limericks). Anche questa versione è basata sul testo a buchi. Per mostrare le caratteristiche del Prolog, qui ci  si limita a generare TUTTE le possibili varianti del limerick. Se si propone il goal "limerick" ne scrive una; per vedere le altre, premere TAB. Si potrebbe modificare in modo da pescare casualmente tra gli elementi.
*/
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

/* Vocabolario */
personaggio(signore).
personaggio(elefante).
personaggio(chirurgo).
aggettivo("molto piccolo").
provenienza(como).
provenienza(alghero).
provenienza(milano).
tempo('una volta').
tempo('un giorno').
tempo('tutti i mesi').
desiderio('salì').
desiderio('si addormentò').
desiderio('giocava a tressette').
luogo('in cima al duomo').
luogo('sotto un pero').
luogo('sul divano').
evento('ma quando fu sulla cima').
evento('ma passate tre ore').
evento('ma mangiando le carte').
risultato('era alto come prima').
risultato('gli venne il mal di cuore').
risultato('rimase in disparte').
commento('micropiccolo').
commento('assonnato').
commento('affamato').


/* Grammatica */
verso1(Verso):-
	personaggio(Personaggio),
	aggettivo(Aggettivo),
	provenienza(Provenienza),
	atomic_list_concat(["Un",Personaggio, Aggettivo, "di",Provenienza]," ",Verso).
verso2(Verso):-
	tempo(Tempo),
	desiderio(Desiderio),
	luogo(Luogo),
	atomic_list_concat([Tempo, Desiderio, Luogo]," ",Verso).
verso3(Verso):-
	evento(Evento),
	atomic_list_concat([Evento],Verso).
verso4(Verso):-
	risultato(Risultato),
	atomic_list_concat([Risultato],Verso).
verso5(Verso):-
	personaggio(Personaggio),
	commento(Commento),
	provenienza(Provenienza),
	atomic_list_concat(["quel",Commento, Personaggio, "di",Provenienza]," ",Verso).

limerick:-
	verso1(Verso1),
	verso2(Verso2),
	verso3(Verso3),
	verso4(Verso4),
	verso5(Verso5),
	ListaVersi = [Verso1, Verso2,Verso3,Verso4,Verso5],
	atomic_list_concat(ListaVersi, "\n",Frase),
	write(Frase).



