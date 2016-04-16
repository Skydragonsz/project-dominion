/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion;
import cards1.Functions.Collection;

/**
 *
 * @author Arthur
 */
public class VictoryPoints extends GameEngine{
    private int gardenPoints;
    private Collection col = new Collection();
    
    
    
    
    public void victoryPointsCalc(GameEngine ge){
        for(int i = 1; i <= ge.getPlayerList().size(); i++){
            
            Player p = ge.getPlayer(i);
            p.discardDeckToPile();
            p.discardHandToPile();
            for(int j = 0; j < p.getDiscardPile().size(); j++){
                if("VICTORY".equals(col.getCard(p.getDiscardPile().get(j)).getCardType())){
                    p.addNthAmountOfPoints(col.getCard(p.getDiscardPile().get(j)).getVictoryValue());
                }
            }
            p.addNthAmountOfPoints(victoryGarden(p));
        }                
    }

    
    
    
    
    private int victoryGarden(Player player){
        for(int i = 0; i < player.getDiscardPile().size(); i++){
            if("Garden".equals(col.getCard(player.getDiscardPile().get(i)).getName())){
                gardenPoints++;
            }
        }
        if(gardenPoints != 0){
            gardenPoints = gardenPoints * (player.getDiscardPile().size() / 10);
        }
        return gardenPoints;
    }
    
    
    
}
