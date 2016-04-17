/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import cards.MainSet.Copper;
import cards.MainSet.Province;
import cards.MainSet.Duchy;
import cards.Functions.KingdomCards;
import cards.Functions.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import cards.MainSet.Witch;
import dominion.Player;
import dominion.GameEngine;
import dominion.phase.ActionPhase;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class CardsTester {

    private Player p = new Player();
    private Player p2 = new Player();
    private Witch w = new Witch();
    private Witch w2;
    private Copper c = new Copper();
    private Province pro = new Province();
    private Duchy du = new Duchy();
    private Province province = new Province();
    private KingdomCards set = new KingdomCards();
    private Collection col = new Collection();
    private GameEngine ge = new GameEngine();
    private ActionPhase ap = new ActionPhase();

    public CardsTester() {
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
    public void testGetTypeWitch() {
        assertEquals(w.getCardType(), "ATTACK");

    }

    @Test
    public void testGetTypeCopper() {
        assertEquals(c.getCardType(), "TREASURE");

    }

    @Test
    public void testGetCostOfProvince() {
        assertEquals(pro.getCost(), 8);

    }

    @Test
    public void testVictoryPoints() {
        int VictoryPoints = 0;
        VictoryPoints += pro.getVictoryValue();
        VictoryPoints += du.getVictoryValue();
        VictoryPoints += pro.getVictoryValue();

        assertEquals(VictoryPoints, 15);

    }

    @Test
    public void testRandomSet() {
        set.generateRandomSet();
        //Class kingdomSet not finished yet.
        //assertTrue(set.getDeck() != testArrayDeck);
        fail(); 
    }

    @Test
    public void testGetNameForVillageCard() {
        String cardName = col.getCard(12).getName();
        System.out.println(cardName);
        assertEquals(cardName,"Village");
    }

    @Test
    public void testAdventurer() {
        System.out.println(p.getCardsInDeck());
        //Adventurer card will add two copper (ID = 1) into the hand of the player.
        //What the result should be.
        ArrayList resultHandArray =  new ArrayList(p.getCardsInHand());       
        resultHandArray.add(1);
        resultHandArray.add(1);

        //Real function
        col.getCard(32).playCard(p);

        System.out.println(p.getCardsInDeck());
        System.out.println(p.getCardsInHand());
        System.out.println(resultHandArray);
        
        assertEquals(p.getCardsInHand(),resultHandArray);
        
    }

    @Test
    //Test doesn't succeed(?). doesn't hava an assert_____();
    //Does the function work?
    public void testBureaucrat() {
        ge.reset();
        ge.initAmountPlayers(3);
        ge.setPlayerName(1, "Bob");
        ge.setPlayerName(2, "Ross");
        ge.setPlayerName(3, "Arthur");

        ge.getPlayer(1).addCardToHand(1);
        ge.getPlayer(1).addCardToHand(6);
        ge.getPlayer(1).addCardToHand(3);

        ge.getPlayer(2).addCardToHand(1);
        ge.getPlayer(2).addCardToHand(3);
        ge.getPlayer(2).addCardToHand(3);

        ge.getPlayer(3).addCardToHand(15);
        ge.getPlayer(3).addCardToHand(5);
        ge.getPlayer(3).addCardToHand(1);
        ge.getPlayer(3).addCardToHand(13);

        for (int i = 1; i <= ge.getPlayerList().size(); i++) {
            System.out.println(ge.getPlayer(i).getName() + " " + ge.getPlayer(i).getCardsInHand());
        }
        
        
        System.out.println(ge.getPlayer(3));
        System.out.println(col.getCard(15) );       
        ap.placeCard(col.getCard(15), ge.getPlayer(3));

        for (int i = 1; i <= ge.getPlayerList().size(); i++) {
            System.out.println("AFTER: " + ge.getPlayer(i).getName() + " " + ge.getPlayer(i).getCardsInHand());
        }
        //fail(); 
    }
}
