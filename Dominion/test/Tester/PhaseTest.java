/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import dominion.phase.ActionPhase;
import dominion.GameEngine;
import dominion.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Quinten
 */
public class PhaseTest {
    final cards.Functions.Collection col = new cards.Functions.Collection();
    ActionPhase Pl = new ActionPhase();
    Player p1 = new Player();
    Player p2 = new Player();
    GameEngine ge = new GameEngine();
    
    List<Integer> testArrayDeck = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 4, 4, 4));
    List<Integer> testEffectedArrayDeck = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 4, 4, 4));
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
    public void AddOneWitch(){
    ge.reset();
    //+Visual feedback
    ge.setAmountPlayers(3);
    ge.setName(1, "WitchPlayer");
    ge.setName(2, "WitchTester");
    ge.setName(3, "RandomPlayer");
    
    for(int i = 0;i < ge.getPlayerList().size()-1 ;i++){
            System.out.println(ge.getOtherPlayersList(ge.getPlayer(1)).get(i).getName());
    }
    System.out.println("Begin deck Player 1: " + ge.getPlayer(1).getDeck());
    
    ge.getPlayer(1).addCardToHand(31);
    
    System.out.println("Begin deck Player 1: " + ge.getPlayer(1).getDeck());
    System.out.println("Begin hand Player 1: " + ge.getPlayer(1).getCardsInHand());
    System.out.println("Begin deck Player 2: " + ge.getPlayer(2).getDeck());
    System.out.println("Begin hand Player 2: " + ge.getPlayer(2).getCardsInHand());
    System.out.println("^BEGIN STATE^");
    
    Pl.placeCard(col.getCard(31), ge.getPlayer(1));
       
    System.out.println("Effected (Witch) deck Player 1 (-2 cards): " + ge.getPlayer(1).getDeck());
    System.out.println("Effected hand Player 1 (+2 cards): " + ge.getPlayer(1).getCardsInHand());
    System.out.println("Effected deck Player 2 (+1 curse): " + ge.getPlayer(2).getDeck());
    System.out.println("Effected hand Player 2: " + ge.getPlayer(2).getCardsInHand());
    System.out.println("^WITCH EFFECT STATE^");
    System.out.println("Card Type: " + col.getCard(31).getCardType());
    //TODO: Kijk voor een manier om alle assertEquals weer te geven op de test results.
    assertEquals(ge.getPlayer(1).getDeck(),testEffectedArrayDeck);
    //assertEquals(p1.getCards(),testArrayEffectedHand);
    //assertEquals(p2.getDeck(),testArrayEffectDeckOtherPlayer);
    }
    
    @Test
    public void AddOneWitchWhenOtherPlayerHasAReactionCard(){
    ge.reset();
    ge.setAmountPlayers(2);
    ge.getPlayer(2).addCardToHand(10);
    ge.getPlayer(1).addCardToHand(31);
    Pl.placeCard(col.getCard(31), ge.getPlayer(1));
    System.out.println("Effected (Witch) deck Player 1 (-2 cards): " + ge.getPlayer(1).getDeck());
    System.out.println("Effected hand Player 1 (+2 cards): " + ge.getPlayer(1).getCardsInHand());
    System.out.println("Effected deck Player 2 (geen curse): " + ge.getPlayer(2).getDeck());
    System.out.println("Effected hand Player 2(1 moat): " + ge.getPlayer(2).getCardsInHand());
    System.out.println("^WITCH EFFECT STATE^");
    assertEquals(ge.getPlayer(2).getDeck(),testArrayDeck);
    }
    
    
    @Test
    public void testAddToPlayingField(){
        ge.reset();
        p1.addCardToHand(4);
        p1.addCardToHand(3);
        p1.addCardToHand(4);
        p1.addCardToHand(3);
        System.out.println("Hand unaffected"+p1.getCardsInHand());
        p1.addToPlayingField(3);
        System.out.println("Card in hand" + p1.getCardsInHand());
        System.out.println("Playingfield"+p1.getPlayingField());
    }
    
    @Test
    public void testAddOneWitchWithAndWithoutMoat(){
    ge.reset();
    //+Visual feedback
    ge.setAmountPlayers(3);
    ge.setName(1, "WitchPlayer");
    ge.setName(2, "WithoutMoat");
    ge.setName(3, "WithMoat");
    
    for(int i = 0;i < ge.getPlayerList().size()-1 ;i++){
            System.out.println(ge.getOtherPlayersList(ge.getPlayer(1)).get(i).getName());
    }
    System.out.println("Begin deck Player 1: " + ge.getPlayer(1).getDeck());
    
    ge.getPlayer(1).addCardToHand(31);
    ge.getPlayer(3).addCardToHand(10);
    
    System.out.println("Begin deck Player 1: " + ge.getPlayer(1).getDeck());
    System.out.println("Begin hand Player 1: " + ge.getPlayer(1).getCardsInHand());
    System.out.println("Begin deck Player 2: " + ge.getPlayer(2).getDeck());
    System.out.println("Begin hand Player 2: " + ge.getPlayer(2).getCardsInHand());
    System.out.println("Begin deck Player 3: " + ge.getPlayer(3).getDeck());
    System.out.println("Begin hand Player 3: " + ge.getPlayer(3).getCardsInHand());
    System.out.println("^BEGIN STATE^");
    
    Pl.placeCard(col.getCard(31), ge.getPlayer(1));
       
    System.out.println("Effected (Witch) deck Player 1 (-2 cards): " + ge.getPlayer(1).getDeck());
    System.out.println("Effected hand Player 1 (+2 cards): " + ge.getPlayer(1).getCardsInHand());
    System.out.println("Effected deck Player 2 (+1 curse): " + ge.getPlayer(2).getDeck());
    System.out.println("Effected hand Player 2: " + ge.getPlayer(2).getCardsInHand());
    System.out.println("Effected deck Player 3 (Geen Curse in deck): " + ge.getPlayer(3).getDeck());
    System.out.println("Effected hand Player 3: " + ge.getPlayer(3).getCardsInHand());
    System.out.println("^WITCH EFFECT STATE^");
    System.out.println("Card Type: " + col.getCard(31).getCardType());
    }
}