/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards;

/**
 *
 * @author Quinten
 */
public class Collection {
    //Treasure
    private Copper copper = new Copper();
    private Silver silver = new Silver();
    private Gold gold = new Gold();
    //Victory
    private Estate estate = new Estate();
    private Duchy duchy = new Duchy();
    private Province province = new Province();
    private Curse curse = new Curse();
    //Kingdom Cards
    private Cellar cellar = new Cellar();
    private Chapel chapel = new Chapel();
    private Moat moat = new Moat();
    private Chancellor chancellor = new Chancellor();
    private Village village = new Village();
    private Woodcutter woodcutter = new Woodcutter();
    private Workshop workshop = new Workshop();
    private Bureaucrat bureaucrat = new Bureaucrat();
    private Feast feast = new Feast();
    private Gardens gardens = new Gardens();
    private Militia militia = new Militia();
    private Moneylender moneylender = new Moneylender();
    private Remodel remodel = new Remodel();
    private Smithy smithy = new Smithy();
    private Spy spy = new Spy();
    private Thief thief = new Thief();
    private ThroneRoom throneroom = new ThroneRoom();
    private CouncilRoom councilroom = new CouncilRoom();
    private Festival festival = new Festival();
    private Laboratory laboratory = new Laboratory();
    private Library library = new Library();
    private Market market = new Market();
    private Mine mine = new Mine();
    private Witch witch = new Witch();
    private Adventurer adventurer = new Adventurer();

    
    
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
                     return null;
    }
    }
}
