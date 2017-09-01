### Studente proponente

s205334 Simone Santia

### Titolo della proposta

Orario scolastico settimanale

### Descrizione del problema proposto

Nella realizzazione di un orario scolastico settimanale devono essere tenuti in considerazione una serie di vincoli che rendono il problema non facilmente risolvibile. Alcuni di questi vicoli sono per esempio: disponibilità dei professori, durata delle lezioni, monte ore settimanali, disponibilità dei laboratori e di altri locali necessarie per alcune materie, numero ore delle varie materie ecc... 

### Descrizione della rilevanza gestionale del problema

La definizione dell'orario scolastico all'interno di una scuola è fondamentale per il corretto svolgimento del lavoro dei professori e per consentire un regolare percorso formativo agli studenti. Generare un orario che si incastri perfettamente tenendo conto delle varie esigenze di professori e studenti non è cosa semplice e tanto meno sempre possibile. L'obbiettivo è generare un orario che rispetti i vincoli di orario e di ore necessarie per materia e che possa al meglio possibile soddisfare le esigenze degli studenti/professori.

### Descrizione dei data-set per la valutazione	

Per la creazione dell'orario scolastico è necessario un data-set con 4 entità: Indirizzo scolastico, Classi, Laboratori, Materie e Professori. 

L'indirizzo scolastico ha un suo codice identificativo, denominazione, monte ore settimanali e lista delle materie per ogni anno (1 - 5).
La classe è caratterizzata dalla sezione/anno, numero di studenti, tipo di indirizzo scolastico.
Il Laboratorio ha un suo codice identificativo, capienza e tipo di laboratorio.
La Materia è caratterizzata da un codice identificativo, nome, numero di ore da effettuare settimanalmente, numero di ore da effettuare in laboratorio, tipo di laboratorio.
Il professore è caratterizzato da un codice matricola, nome cognome, lista delle materie in cui è abilitato all'insegnamento, numero di ore settimanali contrattuali, preferenza del giorno libero (in ordine di preferenza sui 5/6 giorni di lezioni).

Ad ogni materia, di un tipo di indirizzo per una certa classe, è associato un solo professore. Ogni professore può essere titolare di un numero di materie finché il numero totale di ore di insegnamento non supera quelle definite dal contratto.

Il date-set descritto non è disponibile online ma sarà realizzato prendendo spunto dal sitoweb della mia passata scuola di ragioneria.


### Descrizione preliminare degli algoritmi coinvolti	

I principali problemi riguarderanno soprattutto la complessità dell'algoritmo. L'uso della ricorsione per generare l'orario per tutte le classi potrebbe richiedere molto tempo considerando i vari vicoli e la dimensione del dataset. Quindi primo obbiettivo sarà ridurre i tempi e il carico di elaborazione effettuando pre-controlli sui vincoli all'interno del dataset (per esempio sulla corretta associazione ore materie - disponibilità professore) in modo anche di evitare che il problema già in principio sia irrisolvibile.

Un altro problema sarà testare quale "percorso" è più efficiente, ovvero generare l'orario classe per classe, da professore a professore o mettendo in relazione queste due entità (tipo modello sudoku).

### Descrizione preliminare delle funzionalità previste per l’applicazione software	

L'utente finale tramite questa applicazione potrà modificare manualmente il data-set, inserendo nuovi professori, materie, percorsi di studio e classi. Potrà definire la settimana, l'orario giornaliero, il numero di ore consecutive massime per materia. Potrà associare per ogni classe la materia e il professore.  
Infine generato l'orario potrà visualizzarlo per ogni professore, classe o laboratorio.
