/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards1.Functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Quinten
 */
public class KingdomCards {

    private ArrayList firstGame = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 29, 18, 30, 10, 20, 21, 12, 13, 14));
    private ArrayList bigMoney = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 29, 18, 30, 10, 20, 21, 12, 13, 14));
    private ArrayList interaction = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 29, 18, 30, 10, 20, 21, 12, 13, 14));
    private ArrayList sizeDistortion = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 29, 18, 30, 10, 20, 21, 12, 13, 14));
    private ArrayList villageSquare = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 29, 18, 30, 10, 20, 21, 12, 13, 14));

    public ArrayList getKingdomCardsSet(Integer option) {
        switch (option) {
            case 1:
                //selectCustomSet();
                //return   
                break;
            case 2:
                //generateRandomSet();
                //return  
                break;
            case 3:
                return firstGame;
            case 4:
                return bigMoney;
            case 5:
                return interaction;
            case 6:
                return sizeDistortion;
            case 7:
                return villageSquare;
            default:
                System.out.print("Incorrect or unknown letter, please try again!\n");
                break;
        }
        //TEMP
        return firstGame;
    }

    public void generateRandomSet() {
        int RandomNumber;
        Random r = new Random();
        ArrayList<Integer> RandomSet = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            RandomSet.add(i);
        }
        int Low = 8;
        int High = 32;
        System.out.println(RandomSet.size());
        for (int i = 0; i < RandomSet.size(); i++) {
            RandomNumber = r.nextInt(High - Low) + Low;
            while (RandomSet.contains(RandomNumber)) {
                RandomNumber = r.nextInt(High - Low) + Low;
            }
            System.out.println(i + " :: " + RandomNumber);
            RandomSet.set(i, RandomNumber);
        }
        System.out.println(RandomSet.toString());
    }

}
