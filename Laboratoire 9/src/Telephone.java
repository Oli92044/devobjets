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
            while(true) {
                System.out.print("\tNuméro (XXX-XXX-XXXX) : ");
                String numeroTelephone = sc.next();
                if (Validation.numeroTelephone(numeroTelephone)){
                    contact.getTelephone(nbtelephone).setNumero(numeroTelephone);
                    break;
                }
            }
    }

    public void setTelephonePrefaite(Contact contact){

        contact.getTelephone(0).setType("Cellulaire");
        while(true) {
            String numeroTelephone = "418-944-2940";
            if (Validation.numeroTelephone(numeroTelephone)){
                contact.getTelephone(0).setNumero(numeroTelephone);
                break;
            }
        }
        contact.getTelephone(1).setType("Maison");
        while(true) {
            String numeroTelephone = "418-548-1416";
            if (Validation.numeroTelephone(numeroTelephone)){
                contact.getTelephone(1).setNumero(numeroTelephone);
                break;
            }
        }
    }

    public static String telephoneToString(Contact contact){

        String telephoneString = contact.getTelephone(0).getType() + "," + contact.getTelephone(0).getNumero();
        for(int i = 1;i<10;i++){
            if(!contact.getTelephone(i).numero.equals("XXX-XXX-XXXX"))
                telephoneString = telephoneString + "," + contact.getTelephone(i).getType() + "," + contact.getTelephone(i).getNumero();
        }
        return telephoneString;
    }
}
