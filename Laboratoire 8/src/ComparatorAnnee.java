/*
 *  Created by Olivier Blackburn
 */

import java.util.Comparator;

public class ComparatorAnnee implements Comparator<Livre> {

    @Override
    public int compare(Livre livre1, Livre livre2){
        return livre1.compareTo(livre2);
    }

}
