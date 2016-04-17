

**Feedback: Dominion**
=================

Classes we will use
-----------------------
[✓✓] = Mentioned & implemented
[ - - ] = Mentioned & implemented (in another way)
[✗✗] = Mentioned & not implemented

[✓] = Implemented
[ - ] = Implemented (in another way)
[✗] = Not implemented

----------


***Classes that utilize information***

- [✓✓] GameEngine
	- This class will initiate the back-end, it will also *speak* to all other classes.
- [✗] DataConnection
	 - This class will function as the connection to the database.
- [✓✓] Testers
	 - This class will test all classes.


----------


***Classes that hold information***

 - [ - - ] Player
	 - This class will hold the information about a player.
 - [ - - ] Card
	 - This call will contain all cards which will be hardcoded. It will utilize extends to differentiate its function.
 - [✗✗] (DB | Alternative) Card
	 - This class will will hold information about a card. Values will be imported from a database.
 - [ ✓ ] Kingdom cards
	 - This call will contain all Kingdom cards ***set*** which will be hardcoded.
 - [✗] (DB | Alternative) Kingdom cards
	 - This class will will hold information about all Kingdom cards ***set*** . Sets will be imported from a database.
 - [ ✓ ]  Turn
	 - This class will hold the information involving how many TurnSegments there are.
 - [ ✓ ]  TurnSegment
	 - This class will hold the information involving what a player had that turnSegment.

----------


***Classes that utilize and hold information***

 - [✗✗] Deck
	 - This class will hold the information of cards (ex. hand, deck, discardpile,...). This will also include methods to change said deck (ex. remove, add, shuffle). This can also be used for specific kingdom cards and their amount (?).

***

Full text
---------

    Een paar zaken die jullie op weg kunnen helpen met jullie Dominion grappling.
    Dit zijn maar tips op basis van mijn ervaring van het programmeren van de java domein klasses (domein = hier Dominion). Ze zijn niet bedoeld als dwingend, nog als how to. Het is best mogelijk dat je op ander manieren en met ene andere architectuur controle hebt over wat je doet. Doe in dat geval gewoon rustig verder. Hier gaan we:
    - Ik heb uiteindelijk 1 klasse kaart met daarin alle gennerieke eigenschappen van een kaart.
    - Het moeilijkste zijn de acties. Er bestaan mooie design patterns om met zoiets om te gaan.
      Maar het is perfect normaal op dit moment in jullie opleiding dat jullie gana vvoor een swiitch om de acties te onderscheiden. Je zult mogelijks wel zien dat die switch zichzelf repliceert. In het vak design patterns pakken we zoiets aan. Wie goed op snelheid is en een uitdaging wil kan al eeens gaan grasduinen in het boek Head First Design Patterns en met name daarin State Pattern en Strategy Pattern. Maar ik schat dat het voor de meesten onder jullie een brug te ver is op dat moment. Daarom: 1 kaart klasse en een switch voor het onderscheiden van de acties is perfect normaal. Doe maar.
    - Het bleek in de evolutie van mijn versie al snel nuttig om zoiets als een Deck  te hebben.
     Daaruit volgde tijdens het refactoren al snel dat alle stapels op tafel als een Deck konden wordne aan zien. Maar ook de aflegstapel, trekstapel en zelfs de te spelen hand van een speler. Zo'n deck bij mij heeft dan methodes die de totale waarde berekenen in punten of de totale koopkracht in munten, enz ...
    Je kunt er ook handige functionaliteit in onderbrengen als shuffle, kaarten toevoegen, weghalen, enz ...
    Je kunt ook handige constructoren bedenken die je metene ene deck geven van 30 goud kaarten. Bovendien kun je die deck dan implementeren als 1 goud kaart en een teller. Iederene die ene goudkaart vraagt krrijgt dan altijd een refernetie naar diezelfde kaart. Er is dus in het spel maar 1 goud kaaart, maar wel tot dertig verwijzingen er naar. Die optimalisatie hoeft niet. Maar het illustreert mee het nut van zo'n klasse Deck.
    - Ik zie verschillende groepen die een klasse speler hebben. Op zich is daar niets mis mee als container voor alle toestand rond een speler. Het loopt vaak wel verkeerd wanneer in je software vanuit die speler redeneert (hem centraal stelt). In mijn oplossing is de game klasse centraal en is de speler klasse een passieve container. Het is dus nooit de speler die actie onderneemt. Dat kan we lzo worden, maar dan ben je bezig met het concept van ene ai speler. De enige actie(s) die zo'n speler obbjject onderneemt zijn passieve delegering van boodschappen van de UI. Kortom oplettne dat je een spelerklasse (als je die hebt) niet centraal stelt voor de verwerking van het spelen. De speler kent eigenlijk gene spelregels (tenzij het een ai speler moet worden).

***