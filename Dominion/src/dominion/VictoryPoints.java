package dominion;

/**
 *
 * @author Arthur
 */
public class VictoryPoints extends GameEngine {

    private int gardenPoints;

    public void victoryPointsCalc(GameEngine ge) {
        for (int i = 1; i <= ge.getPlayerList().size(); i++) {

            Player p = ge.getPlayer(i);
            p.getDiscardPile().addAmountOfCardsFrom(p.getDeck().getPile().size(), p.getDeck());
            p.getDiscardPile().addAmountOfCardsFrom(p.getHand().getPile().size(), p.getHand());
            for (int j = 0; j < p.getDiscardPile().getPile().size(); j++) {
                if ("VICTORY".equals(((Card) p.getDiscardPile().getPile().get(j)).getType().toString())) {
                    p.setVictoryPoints(((Card) p.getDiscardPile().getPile().get(j)).getValue());
                }
            }
            p.setVictoryPoints(victoryGarden(p));
        }
    }

    private int victoryGarden(Player player) {
        for (int i = 0; i < player.getDiscardPile().getPile().size(); i++) {
            if ("Garden".equals(((Card) player.getDiscardPile().getPile().get(i)).getName())) {
                gardenPoints++;
            }
        }
        if (gardenPoints != 0) {
            gardenPoints = gardenPoints * (player.getDiscardPile().getPile().size() / 10);
        }
        return gardenPoints;
    }
}
