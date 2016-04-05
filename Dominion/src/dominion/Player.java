package dominion;
import java.util.*;
import dominion.*;

public class Player extends GameEngine {
    //TODO: clean code
    //Bekijk voor niet active variablen
    private final Cards.Collection collection = new Cards.Collection();
    private GameEngine ge;
    private ArrayList deckArray;
    private ArrayList handArray;
    private ArrayList discardArray;
    private ArrayList playingFieldArray;
    private String name;
    private int victoryPoints;
    private boolean HasReaction;
        
    public Player()
    {        
        init();
    }
    
    public Player(String name)
    {        
        this.name = name;
        init();
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void init()
    {
        //Starter deck -- TEST
        deckArray = new ArrayList();
        handArray = new ArrayList();
        playingFieldArray = new ArrayList();
        discardArray = new ArrayList();
        
        //Add begin deck.
        //Always the same.
        //TODO: clean code -> maybe loop
        deckArray.add(1);
        deckArray.add(1);
        deckArray.add(1);
        deckArray.add(1);
        deckArray.add(1);
        deckArray.add(1);
        deckArray.add(1);
        deckArray.add(4);
        deckArray.add(4);
        deckArray.add(4);
        shuffleDeck();
        setNthAmountOfCards(5);
    }
    
    //TODO: Kan via ingebouwde functie!
    //Gelijk welk deck (van grootte) schudden.
    public void shuffleDeck(){
        Random rng = new Random();
        for (int i = deckArray.size() -1; i>0; i--)
        {
            int index = rng.nextInt(i +1);
            
            Object swap = deckArray.get(index);
            deckArray.set(index,deckArray.get(i));
            deckArray.set(i, swap);                   
        }   
        
    }
    //Geeft het hele deck terug als een ArrayList 
    public ArrayList<Integer> getDeck(){
        return deckArray;
    }
    
    //Geeft de bovenste hoeveelheid gekozen kaarten van het deck naar de speler zijn hand.
    public void setNthAmountOfCards(int amount)
    {
        
        for(int i = 0;i <amount ;i++){
            isDeckEmpty();
            handArray.add(deckArray.get(0));
            deckArray.remove(0);
        }
    }
    
    //Geeft het hele hand terug als een ArrayList.
    public ArrayList<Integer> getCardsInHand(){
        return handArray;
    }
       
    //Voegt hoeveelheid aantal kaart(en) toe aan het deck.
    public void addCardToDeck(int CardID)
    {
        deckArray.add(CardID);
    }
    
    public void addCardToHand(int CardID)
    {
       handArray.add(CardID);
    }
    
    //Vraag een kaart van je deck via naam !Niet meer nodig!
    //TODO: bekijk deze code eens.
    public Object getCard(String name)
    {
        return deckArray.get(deckArray.indexOf(name));
    }
    
    public ArrayList<Integer> getPlayingField(){
        return playingFieldArray;
    }
    
    //Voegt kaart toe aan playingField
    public void addToPlayingFieldIndex(int Index)
    {
        playingFieldArray.add(handArray.get(Index));
        handArray.remove(Index);
        
    }
    
    public void addToPlayingField(int CardID)
    {
        playingFieldArray.add(CardID);
        handArray.remove(handArray.indexOf(CardID));
        
    }
    
    public void addToPlayingField(int CardID, int index)
    {
        playingFieldArray.add(CardID);
        handArray.remove(index);
        
    }
    
    //Verwijderd kaart van de speler zijn deck.
    //TODO -- Fix
    public void removeNthCardFromDeck(int index){
        deckArray.remove(index);
    }
    
    
    //Bekijkt heel de speler zijn hand voor een rection card.
    public Boolean checkForReactionCard(){
        //vlug declareren
        //TODO: clean code
        int CardID;
        HasReaction = false;
        System.out.println("-- VOOR DE LOOP -- ");
        System.out.println(handArray.size());
        System.out.println(handArray.size() - 1);
        for (int i = 0; i < handArray.size(); i++ ){
            System.out.println("-- IN DE LOOP -- ");
            //TODO: check voor betere manier
            CardID = Integer.parseInt(handArray.get(i).toString());
            System.out.println(CardID);
            if ("REACTION".equals(collection.getCard(CardID).getCardType())){
                System.out.println("-- IN DE IF -- ");
                System.out.println(collection.getCard(CardID).getCardType());
                
                HasReaction = true;  
            }
        }
        System.out.println("-- NA DE LOOP DE LOOP -- ");
        return HasReaction;
    }
    

    //TODO -- Rewrite function discard to deck
    public void discardDeckToPile(){
        discardArray.addAll(deckArray);
        deckArray.clear();
    }
    
    public void isDeckEmpty(){
        boolean value = deckArray.isEmpty();
        if(value){
            deckArray.addAll(discardArray);
            discardArray.clear();
            shuffleDeck();
        }
    }
    
    public ArrayList<Integer> getDiscardPile(){
        return discardArray;
    }
    
    
    
    
    //TODO -- Fix this shit 
    // Player can't acces otherplayerslist <-- need a fix
    
    
    
}
    

