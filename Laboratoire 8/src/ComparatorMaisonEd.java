/*
 *  Created by Olivier Blackburn
 */

import java.util.Comparator;

public class ComparatorMaisonEd implements Comparator<Livre> {

    @Override
    public int compare(Livre livre1, Livre livre2) {
        if (livre1.maisonEdition.equals(livre2.maisonEdition)) {
            if (livre1.auteur.equals(livre2.auteur)) {
                if(livre1.titre.equals(livre2.titre)) {
                    if (livre1.anneePub == livre2.anneePub) {
                        return 0;
                    } else if (livre1.anneePub < livre2.anneePub)
                        return -1;
                    return 1;
                }else if (livre1.titre.charAt(0) < livre2.titre.charAt(0))
                    return -1;
                return 1;
            } else if (livre1.auteur.charAt(0) < livre2.auteur.charAt(0))
                return -1;
            return 1;
        } else if (livre1.maisonEdition.charAt(0) < livre2.maisonEdition.charAt(0))
            return -1;
        return 1;
    }

}
