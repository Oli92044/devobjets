public class LinkedList
        implements List {

    private Noeud tete = new Noeud(0);
    private int nbListe = 0;

    public void add(Object contenu){

        Noeud fin = new Noeud(contenu);
        Noeud actuel = tete;

        while (actuel.next!= null){
            actuel = actuel.next;
        }

        actuel.next = fin;
        nbListe++;
    }

    public void add(int index, Object contenu){
        if (index>0 && index <= size()) {
            Noeud fin = new Noeud(contenu);
            Noeud actuel = tete;

            for (int i = 0; i < index - 1; i++) {
                actuel = actuel.next;
            }
            fin.next = actuel.next;
            actuel.next = fin;
            nbListe++;
        }
        else
            System.out.println("ArrayIndexOutOfBoundsException");
    }

    public Object get(){
        Object contenu = new Object();
        Noeud actuel = tete;

        while(actuel.next!=null){
            actuel = actuel.next;
            if(actuel.next==null)
                contenu = actuel.contenu;
        }

        return contenu;
    }

    public void remove(int index){
        Noeud actuel = tete;
        int i;
        if(index>nbListe || index<1){
            System.out.println("ArrayIndexOutOfBoundsException");
        }
        else{
            i=0;
            while(i<index-1){
                actuel = actuel.next;
                i++;
            }
            actuel.next = actuel.next.next;
            nbListe--;
        }
    }

    public void clear(){
        tete = new Noeud(0);
        nbListe = 0;
    }

    public int size(){
        return nbListe;
    }

    public void afficher(){
        Noeud actuel = tete;
        while(actuel.next!=null){
            System.out.println(actuel.contenu);
            actuel = actuel.next;
        }
    }
}
