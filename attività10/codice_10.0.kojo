// Musica a programma 3.10.0
// Copyright Stefano Penge 2017
// Released under GPL v.3.0

val pattern_melodia1 = "C D E C "
val pattern_melodia2 = "E F G R "
val pattern_melodia3 = "Gi Ai Gi Fi E C "
val pattern_melodia4 = "C G4 C R "
val pausa = "R "

val voce1 = pattern_melodia1*2 + pattern_melodia2*2 + pattern_melodia3*2 + pattern_melodia4*2 
val voce2 = pausa*8 + voce1
val voce3 = pausa*16 + voce1
val voce4 = pausa*24 + voce1

val spartito = MusicScore(
      Melody("FRENCH_HORN", voce1),
      Melody("CELLO", voce2),
      Melody("OBOE",  voce3), 
      Melody("VIOLIN", voce4)
)
playMusic(spartito)
