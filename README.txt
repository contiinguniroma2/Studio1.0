Per il corretto funzionamento dell'applicazione e' necessario modificare
username e password nella classe src/logic/dao/Db.java con quelli del proprio
mysql server e aggiungere i jar dei mysql connectors opportuni per la propria versione
di java (nella cartella drivers sono comunque presenti quelli utilizzati dal nostro gruppo).
Il database è esportato con l'estensione .mwb di mysql workbench.

Funzioni implementate:
-registrazione di studente e biblioteca
-login
-modifica informazioni dell'account dello studente
-ricerca biblioteca per citta' e apertura della sua pagina informativa
-prenotazione del posto da parte dello studente presso una biblioteca(Uno studente può essere prenotato solo in una biblioteca alla volta)
-pagina principale del bibliotecario con funzioni di cancellazione e conferma prenotazioni ed aggiornamento della situazione dei posti occupati/liberi
-modifica orari di apertura biblioteca
-lo stato di ban e notifica dello studente che causano una limitazione parziale o totale delle sue possibilita' all'interno dell'applicazione.
Per essere provata pero' richiede che i campi ban o reportCounter siano modificati manualmente all'interno del database in quanto non e' stata sviluppata
la funzionalita' che permette al bibliotecario di effettuare quest'operazione, in particolare il ban è un attributo di tipo 0/1
mentre nello stato di "notifica" si entra solo se il proprio reportCounter ha valore >2)

Nota:
Le funzionalita' non implementate sono comunque simulate.
