/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.Functions;

import cards.MainSet.Adventurer;
import cards.MainSet.Bureaucrat;
import cards.MainSet.Cellar;
import cards.MainSet.Chancellor;
import cards.MainSet.Chapel;
import cards.MainSet.Copper;
import cards.MainSet.CouncilRoom;
import cards.MainSet.Curse;
import cards.MainSet.Duchy;
import cards.MainSet.Estate;
import cards.MainSet.Feast;
import cards.MainSet.Festival;
import cards.MainSet.Gardens;
import cards.MainSet.Gold;
import cards.MainSet.Laboratory;
import cards.MainSet.Library;
import cards.Maincards.MainCard;
import cards.MainSet.Market;
import cards.MainSet.Militia;
import cards.MainSet.Mine;
import cards.MainSet.Moat;
import cards.MainSet.Moneylender;
import cards.MainSet.Province;
import cards.MainSet.Remodel;
import cards.MainSet.Silver;
import cards.MainSet.Smithy;
import cards.MainSet.Spy;
import cards.MainSet.Thief;
import cards.MainSet.ThroneRoom;
import cards.MainSet.Village;
import cards.MainSet.Witch;
import cards.MainSet.Woodcutter;
import cards.MainSet.Workshop;

/**
 *
 * @author Quinten
 */
public class Collection {
    //Treasure
    private final Copper copper = new Copper();
    private final Silver silver = new Silver();
    private final Gold gold = new Gold();
    //Victory
    private final Estate estate = new Estate();
    private final Duchy duchy = new Duchy();
    private final Province province = new Province();
    private final Curse curse = new Curse();
    //Kingdom Cards
    private final Cellar cellar = new Cellar();
    private final Chapel chapel = new Chapel();
    private final Moat moat = new Moat();
    private final Chancellor chancellor = new Chancellor();
    private final Village village = new Village();
    private final Woodcutter woodcutter = new Woodcutter();
    private final Workshop workshop = new Workshop();
    private final Bureaucrat bureaucrat = new Bureaucrat();
    private final Feast feast = new Feast();
    private final Gardens gardens = new Gardens();
    private final Militia militia = new Militia();
    private final Moneylender moneylender = new Moneylender();
    private final Remodel remodel = new Remodel();
    private final Smithy smithy = new Smithy();
    private final Spy spy = new Spy();
    private final Thief thief = new Thief();
    private final ThroneRoom throneroom = new ThroneRoom();
    private final CouncilRoom councilroom = new CouncilRoom();
    private final Festival festival = new Festival();
    private final Laboratory laboratory = new Laboratory();
    private final Library library = new Library();
    private final Market market = new Market();
    private final Mine mine = new Mine();
    private final Witch witch = new Witch();
    private final Adventurer adventurer = new Adventurer();

    
    //change parameter to number
    public MainCard getCard(int name){
        switch(name){
            case 1: 
                    return copper;
            case 2: 
                    return silver;
            case 3: 
                    return gold;
            case 4: 
                    return estate;
            case 5: 
                    return duchy;
            case 6: 
                    return province;
            case 7: 
                    return curse;
            case 8:
                    return cellar;
            case 9:
                    return chapel;
            case 10:
                    return moat;
            case 11:
                    return chancellor;
            case 12:
                    return village;
            case 13:
                    return woodcutter;
            case 14:
                    return workshop;
            case 15:
                    return bureaucrat;
            case 16:
                    return feast;
            case 17:
                    return gardens;
            case 18:
                    return militia;
            case 19:
                    return moneylender;
            case 20:
                    return remodel;
            case 21:
                    return smithy;
            case 22:
                    return spy;
            case 23:
                    return thief;
            case 24:
                    return throneroom;
            case 25:
                    return councilroom;
            case 26:
                    return festival;
            case 27:
                    return laboratory;
            case 28:
                    return library;
            case 29:
                    return market;
            case 30:
                    return mine;
            case 31:
                    return witch;
            case 32:
                    return adventurer;
                    
            default:
                     return new MainCard();
        }
    }
}
