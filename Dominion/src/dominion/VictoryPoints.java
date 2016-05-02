package dominion;

/**
 *
 * @author Arthur
 */
public class VictoryPoints {

    private int gardenPoints;

    public void victoryPointsCalc(GameEngine ge) {
    	ge.initConnection();
        for (int i = 1; i <= ge.getPlayerList().size(); i++) {

            Player p = ge.getPlayer(i);
            p.getDiscardPile().addAmountOfCardsFrom(p.getDeck().getAmount(), p.getDeck());
            p.getDiscardPile().addAmountOfCardsFrom(p.getHand().getAmount(), p.getHand());
            for (int j = 0; j < p.getDiscardPile().getAmount(); j++) {
                if ("Victory".equals( p.getDiscardPile().getPile().get(j).getType())) {
                    p.setVictoryPoints(((Card) p.getDiscardPile().getPile().get(j)).getValue());
                }
            }
            p.setVictoryPoints(victoryGarden(p));
        }
    }

    private int victoryGarden(Player player) {
        for (int i = 0; i < player.getDiscardPile().getAmount(); i++) {
            if ("Garden".equals(((Card) player.getDiscardPile().getPile().get(i)).getName())) {
                gardenPoints++;
            }
        }
        if (gardenPoints != 0) {
            gardenPoints = gardenPoints * (player.getDiscardPile().getAmount() / 10);
        }
        return gardenPoints;
    }
}
