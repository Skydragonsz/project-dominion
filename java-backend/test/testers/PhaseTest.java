/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testers;

import dominion.Card;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import dominion.GameEngine;
import dominion.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author Quinten
 */


//PhaseTest needs rework, most tests don't/won't work.
//EDIT: is phase needed?
public class PhaseTest {
    Player p1 = new Player();
    Player p2 = new Player();
    GameEngine ge = new GameEngine();
    
    List<Integer> testArrayDeck = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 4, 4, 4));
    List<String> testEffectedArrayDeck = new ArrayList<>(Arrays.asList("Copper","Copper","Copper","Copper","Copper","Copper","Copper","Estate","Estate","Estate", "Witch"));
    List<Integer> testArrayEffectedHand = new ArrayList<>(Arrays.asList(1, 1));
    List<Integer> testArrayEffectDeckOtherPlayer = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 7));
  
    
    public PhaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    @Test
    /*Q -> SPECIAL ACTION NEEDS REWORKING*/
    public void AddOneWitch(){
    ge.reset();
    //+Visual feedback
    ge.initAmountPlayers(3);
    ge.initPlayer(1, "WitchPlayer");
    ge.initPlayer(2, "WitchTester");
    ge.initPlayer(3, "RandomPlayer");
    
    for(int i = 0;i < ge.getPlayerList().size()-1 ;i++){
            System.out.println(ge.getOtherPlayersList(ge.getPlayer(1)).get(i).getName());
    }
    System.out.println("Begin deck Player 1: " + ge.getPlayer(1).getDeck().getCardsName());
    
    Card witch = new Card("Witch", "Attack", "description", 3, 5, 0, 1, 2, 0, false);
    
    ge.getPlayer(1).getDeck().add(witch); //TEMP TEST
    
    System.out.println("Begin deck Player 1: " + ge.getPlayer(1).getDeck().getCardsName());
    System.out.println("Begin hand Player 1: " + ge.getPlayer(1).getHand().getCardsName());
    System.out.println("Begin deck Player 2: " + ge.getPlayer(2).getDeck().getCardsName());
    System.out.println("Begin hand Player 2: " + ge.getPlayer(2).getHand().getCardsName());
    System.out.println("^BEGIN STATE^");
    
    ge.getPlayer(1).getDeck().addFrom(witch, ge.getPlayer(1).getDeck());
    //Pl.placeCard(col.getCard(31), ge.getPlayer(1));
       
    System.out.println("Effected (Witch) deck Player 1 (-2 cards): " + ge.getPlayer(1).getDeck().getCardsName());
    System.out.println("Effected hand Player 1 (+2 cards): " + ge.getPlayer(1).getHand().getCardsName());
    System.out.println("Effected deck Player 2 (+1 curse): " + ge.getPlayer(2).getDeck().getCardsName());
    System.out.println("Effected hand Player 2: " + ge.getPlayer(2).getHand().getCardsName());
    System.out.println("^WITCH EFFECT STATE^");
    //System.out.println("Card Type: " + col.getCard(31).getCardType());
    //TODO: Kijk voor een manier om alle assertEquals weer te geven op de test results.
    assertEquals(ge.getPlayer(1).getDeck().getCardsName(),testEffectedArrayDeck);
    //assertEquals(p1.getCards(),testArrayEffectedHand);
    //assertEquals(p2.getDeck(),testArrayEffectDeckOtherPlayer);
    }
//    
//    @Test
//    public void AddOneWitchWhenOtherPlayerHasAReactionCard(){
//    ge.reset();
//    ge.initAmountPlayers(2);
//    ge.getPlayer(2).add(10);
//    ge.getPlayer(1).add(31);
//    Pl.placeCard(col.getCard(31), ge.getPlayer(1));
//    System.out.println("Effected (Witch) deck Player 1 (-2 cards): " + ge.getPlayer(1).getDeck());
//    System.out.println("Effected hand Player 1 (+2 cards): " + ge.getPlayer(1).getHand());
//    System.out.println("Effected deck Player 2 (geen curse): " + ge.getPlayer(2).getDeck());
//    System.out.println("Effected hand Player 2(1 moat): " + ge.getPlayer(2).getHand());
//    System.out.println("^WITCH EFFECT STATE^");
//    assertEquals(ge.getPlayer(2).getDeck(),testArrayDeck);
//    }
//    
//    
//    @Test
//    public void testAddToPlayingField(){
//        ge.reset();
//        p1.add(copper);
//        p1.addCard(3);
//        p1.addCard(4);
//        p1.addCard(3);
//        System.out.println("Hand unaffected"+p1.getHand());
//        ArrayList resultArray = new ArrayList();
//        resultArray.add(p1.getHand().get(3));
//        
//        p1.addCardToPlayingField(3);
//        System.out.println("Card in hand" + p1.getHand());
//        System.out.println("Playingfield"+p1.getPlayingField());
//
//        assertEquals(p1.getPlayingField(),resultArray);
//    }
//    
//    @Test
//    public void testAddOneWitchWithAndWithoutMoat(){
//    ge.reset();
//    //+Visual feedback
//    ge.initAmountPlayers(3);
//    ge.initPlayer(1, "WitchPlayer");
//    ge.initPlayer(2, "WithoutMoat");
//    ge.initPlayer(3, "WithMoat");
//    
//    for(int i = 0;i < ge.getPlayerList().size()-1 ;i++){
//            System.out.println(ge.getOtherPlayersList(ge.getPlayer(1)).get(i).getName());
//    }
//    System.out.println("Begin deck Player 1: " + ge.getPlayer(1).getDeck());
//    
//    ge.getPlayer(1).addCard(31);
//    ge.getPlayer(3).addCard(10);
//    
//    System.out.println("Begin deck Player 1: " + ge.getPlayer(1).getDeck());
//    System.out.println("Begin hand Player 1: " + ge.getPlayer(1).getHand());
//    System.out.println("Begin deck Player 2: " + ge.getPlayer(2).getDeck());
//    System.out.println("Begin hand Player 2: " + ge.getPlayer(2).getHand());
//    System.out.println("Begin deck Player 3: " + ge.getPlayer(3).getDeck());
//    System.out.println("Begin hand Player 3: " + ge.getPlayer(3).getHand());
//    System.out.println("^BEGIN STATE^");
//    
//    Pl.placeCard(col.getCard(31), ge.getPlayer(1));
//       
//    System.out.println("Effected (Witch) deck Player 1 (-2 cards): " + ge.getPlayer(1).getDeck());
//    System.out.println("Effected hand Player 1 (+2 cards): " + ge.getPlayer(1).getHand());
//    System.out.println("Effected deck Player 2 (+1 curse): " + ge.getPlayer(2).getDeck());
//    System.out.println("Effected hand Player 2: " + ge.getPlayer(2).getHand());
//    System.out.println("Effected deck Player 3 (Geen Curse in deck): " + ge.getPlayer(3).getDeck());
//    System.out.println("Effected hand Player 3: " + ge.getPlayer(3).getHand());
//    System.out.println("^WITCH EFFECT STATE^");
//    System.out.println("Card Type: " + col.getCard(31).getCardType());
//    }
}