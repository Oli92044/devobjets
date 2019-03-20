/*
 *  Created by Olivier Blackburn
 */

import java.util.Scanner;

public class Programme {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList linkedList = new LinkedList();

        System.out.println(linkedList.size());

        linkedList.add("tyu");
        linkedList.add("allo");
        linkedList.add("nono");
        linkedList.add("1231");
        linkedList.add("tyu");
        linkedList.add("allo");
        linkedList.add("nono");
        linkedList.add("1231");
        linkedList.add("tyu");
        linkedList.add("allo");
        linkedList.add("nono");
        linkedList.add("1231");


        System.out.print("\nGrandeur du ArrayList avant modification : ");
        System.out.print(linkedList.size() +"\n"+"\n");

        System.out.println("Contenu du ArrayList avant modification : ");
        linkedList.afficher();

        //=========Modifications=============

        linkedList.remove(linkedList.size());

        //==================================

        System.out.print("\nGrandeur du ArrayList après modification : ");
        System.out.print(linkedList.size()+"\n"+"\n");

        System.out.println("Contenu du ArrayList après modification : ");
        linkedList.afficher();
    }
}
