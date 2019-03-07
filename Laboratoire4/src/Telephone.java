/*
 *  Created by Olivier Blackburn
 */

import java.util.Scanner;

public class Telephone {
    private String numero;
    private String type;

    public Telephone(){
        numero = "XXX-XXX-XXXX";
        type = "Cellulaire";
    }

    public String getNumero() {
        return numero;
    }

    public String getType() {
        return type;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTelephone(Contact contact, Scanner sc, int nbtelephone){
            System.out.print("Téléphone : " +
                    "\n\tType (cellulaire, maison, travail...): ");
            contact.getTelephone(nbtelephone).setType(sc.next());
            System.out.print("\tNuméro (XXX-XXX-XXXX) : ");
            contact.getTelephone(nbtelephone).setNumero(sc.next());
    }
}
