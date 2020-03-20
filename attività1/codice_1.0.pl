/* Nota: per eseguire il codice occorre prima salvarlo come file di testo (ad esempio come articoli.pl), poi lanciare l'interprete Prolog (es. swipl o gprolog), infine caricare il sorgente (scrivendo: consult(articoli).) A questo punto Prolog è pronto per rispondere a domande del tipo:
- metti_articolo(gnomo,Articolo).
ovvero: dimmi l'articolo giusto da mettere davanti a "gnomo", oppure:
- metti_articolo(zuzzurellone,un).
Ovvero: controlla se è giusto mettere "un" davanti a "zuzzurellone". 
Può essere interessante attivare il tracing (scrivendo: trace.) per vedere come l'interprete Prolog cerca di trovare la risposta.
*/

// E perché non un automa 3.1.2
// Copyright Stefano Penge 2017
// Released under GPL v.3.0
articolo_indeterminativo(base,un).
articolo_indeterminativo(eccezione,uno).
vocali(vocali_normali,[a,e,i,o,u]).
vocali(semivocali,[i]).
consonanti(consonanti_normali,[b,c,d,f,g,h,l,m,n,p,q,r,s,t,v]).
consonanti(consonanti_strane,[z,x]).
consonanti(coppie,[gn,pn,ps,sb,sc,sf,sg,sl,sm,sn,sp,sq,st,sv]).


inizia_per_vocale_strana(Parola) :-
/* inizia con una i seguita da altra vocale? */
	atom_chars(Parola,Lista_caratteri),
	[Iniziale,Seconda|_] = Lista_caratteri,
	vocali(semivocali,Lista_semivocali),
	member(Iniziale,Lista_semivocali),
	vocali(vocali_normali,Lista_vocali),
	member(Seconda,Lista_vocali).
	
inizia_per_vocale_normale(Parola) :-
/* inizia con una vocale seguita da consonante? */	
	atom_chars(Parola,Lista_caratteri),
	[Iniziale,Seconda|_] = Lista_caratteri,
	vocali(vocali_normali,Lista_vocali),
	member(Iniziale,Lista_vocali),
	consonanti(consonanti_normali,Lista_consonanti),
	member(Seconda,Lista_consonanti).
		
inizia_per_consonante_strana(Parola) :-
/* inizia con una z o x ? */
	atom_chars(Parola,Lista_caratteri),
	[Iniziale|_] = Lista_caratteri,
	consonanti(consonanti_strane,Lista_consonanti),
	member(Iniziale,Lista_consonanti).

inizia_per_consonante_strana(Parola) :-
/* inizia con esse impura, gn etc ? */
	atom_chars(Parola,Lista_caratteri),
	[Iniziale,Seconda|_] = Lista_caratteri,
	atom_chars(Coppia,[Iniziale,Seconda]),
	consonanti(coppie,Lista_coppie),
	member(Coppia,Lista_coppie).


inizia_per_consonante_normale(Parola) :-
/* inizia con consonante seguita da vocale ? */	
	atom_chars(Parola,Lista_caratteri),
	[Iniziale|Seconda] = Lista_caratteri,
	consonanti(consonanti_normali,Lista_consonanti),
	member(Iniziale,Lista_consonanti),
	vocali(vocali_normali,Lista_vocali),
	member(Seconda,Lista_vocali).
	
articolo(Parola,Articolo):-
	inizia_per_vocale_strana(Parola),
	articolo_indeterminativo(eccezione,Articolo).

articolo(Parola,Articolo):-
	inizia_per_vocale_normale(Parola),
	articolo_indeterminativo(base,Articolo).

articolo(Parola,Articolo):-
	inizia_per_consonante_strana(Parola),
	articolo_indeterminativo(eccezione,Articolo).

articolo(Parola,Articolo):-
	inizia_per_consonante_normale(Parola),
	articolo_indeterminativo(base,Articolo).

metti_articolo(Parola,Articolo) :-
	articolo(Parola,Articolo),
	write(Articolo),
	write(' '),
	write(Parola),
	nl.


