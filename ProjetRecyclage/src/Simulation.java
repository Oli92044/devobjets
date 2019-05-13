import Recyclage.*;
import Transport.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.management.Attribute;
import javax.naming.Name;
import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.*;
import java.text.*;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Simulation {

    private static void afficherVaisseau() throws InterruptedException {
        System.out.println("\nSimulation enregistré en date du : " + Date.from(Instant.now()));
        System.out.println("\nLancement de la simulation dans ...");
        TimeUnit.SECONDS.sleep(1);
        System.out.print("\n3...");

        TimeUnit.SECONDS.sleep(1);
        System.out.print("2...");
        TimeUnit.SECONDS.sleep(1);
        System.out.print("1...\n");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("       !\n" +
                "       !\n" +
                "       ^\n" +
                "      / \\\n" +
                "     /___\\\n" +
                "    |=   =|\n" +
                "    |     |\n" +
                "    |     |\n" +
                "    |     |\n" +
                "    |     |\n" +
                "    |     |\n" +
                "    |     |\n" +
                "    |     |\n" +
                "    |     |\n" +
                "    |     |\n" +
                "   /|##!##|\\\n" +
                "  / |##!##| \\\n" +
                " /  |##!##|  \\\n" +
                "|  / ^ | ^ \\  |\n" +
                "| /  ( | )  \\ |\n" +
                "|/   ( | )   \\|\n" +
                "    ((   ))\n" +
                "   ((  :  ))\n" +
                "   ((  :  ))\n" +
                "    ((   ))\n" +
                "     (( ))\n" +
                "      ( )\n" +
                "       .\n" +
                "       .\n" +
                "       .");
    }

    private static int obtenirValeur(int limiteInf, int limiteSup, String nom, Scanner sc) {
        int valeur;
        System.out.print("Combien de " + nom + " voulez-vous envoyer pour sauver l'espace ? Nombre de " + nom + " : ");
        while (true) {
            try {
                valeur = sc.nextInt();
                if (valeur <= limiteSup && valeur >= limiteInf)
                    break;
                else
                    System.out.println("Entrez un nombre entre " + limiteInf + " et " + limiteSup);
            } catch (InputMismatchException ex) {
                System.out.println("Invalide, Entrez un nombre entre " + limiteInf + " et " + limiteSup);
                sc.next();
            }
        }
        return valeur;
    }

    private static boolean finSimulation(LinkedList<centreTri> linkCentreTri) {
        boolean simulation = true;
        boolean filePasPlein = false;
        boolean statutCentreTri = false;
        for (centreTri centreTri : linkCentreTri) {
            if (centreTri.getFile().size() < 10) {
                filePasPlein = true;
            }
            if (centreTri.isStatut()) {
                statutCentreTri = true;
            }
        }
        if (!filePasPlein || !statutCentreTri)
            simulation = false;
        if (!simulation) {
            //Nombre individuel dans chaque centre de tri
            /*for (centreTri centreTri : linkCentreTri) {
                System.out.println("Centre de tri #" + (linkCentreTri.indexOf(centreTri) + 1));
                centreTri.combienDeDechets();
            }*/
            int[] tabNombreTotal = tabDechetTotal(linkCentreTri);
            System.out.println("Nombre de gadolinium total : " + tabNombreTotal[0]);
            System.out.println("Nombre de neptunium total : " + tabNombreTotal[1]);
            System.out.println("Nombre de plutonium total : " + tabNombreTotal[2]);
            System.out.println("Nombre de terbium total : " + tabNombreTotal[3]);
            System.out.println("Nombre de thulium total : " + tabNombreTotal[4]);
            System.out.println("Nombre d'humains total : " + tabNombreTotal[5]);
            System.out.println("\nNombre de déchets total : " + tabNombreTotal[6]);
        }
        return simulation;
    }

    private static int[] tabDechetTotal(LinkedList<centreTri> linkCentreTri) {
        int[] tabNombreTotal = new int[7];
        for (centreTri centreTri : linkCentreTri) {
            int[] tabNombre = centreTri.tabNombreDechet();
            for (int i = 0; i < tabNombre.length; i++) {
                tabNombreTotal[i] += tabNombre[i];
            }
        }
        return tabNombreTotal;
    }

    private static String statFinal(LinkedList<centreTri> linkedList, vaisseau[] tabVaisseau) {
        int[] tabNombreTotal = tabDechetTotal(linkedList);
        String nbDechetFinal = ":Dechets:nbGad" + tabNombreTotal[0] + ":nbNep" + tabNombreTotal[1] + ":nbPluto" + tabNombreTotal[2] + ":nbTer" + tabNombreTotal[3] + ":nbThu" + tabNombreTotal[4] + ":nbHum" + tabNombreTotal[5] + ":nbTotal" + tabNombreTotal[6];

        int[] tabNbVaisseau = new int[5];
        for (vaisseau vaisseau : tabVaisseau) {
            if (vaisseau instanceof heavyShip)
                tabNbVaisseau[0] += 1;
            else if (vaisseau instanceof lightShip)
                tabNbVaisseau[1] += 1;
            else if (vaisseau instanceof lightShipHumain)
                tabNbVaisseau[2] += 1;
            else if (vaisseau instanceof mediumShip)
                tabNbVaisseau[3] += 1;
            else
                tabNbVaisseau[4] += 1;
        }
        String statVaisseau = ":Vaisseaux:nbHShip" + tabNbVaisseau[0] + ":nbLShip" + tabNbVaisseau[1] + ":nbLShipHumain" + tabNbVaisseau[2] + ":nbMShip" + tabNbVaisseau[3] + ":nbMShipHumain" + tabNbVaisseau[4] + ":";

        return nbDechetFinal + statVaisseau;
    }

    private static String dateToString() {
        Date date = Date.from(Instant.now());
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");

        return dateFormat.format(date);
    }

    private static void clean(Node node) {
        NodeList childNodes = node.getChildNodes();

        for (int n = childNodes.getLength() - 1; n >= 0; n--) {
            Node child = childNodes.item(n);
            short nodeType = child.getNodeType();

            if (nodeType == Node.ELEMENT_NODE)
                clean(child);
            else if (nodeType == Node.TEXT_NODE) {
                String trimmedNodeVal = child.getNodeValue().trim();
                if (trimmedNodeVal.length() == 0)
                    node.removeChild(child);
                else
                    child.setNodeValue(trimmedNodeVal);
            } else if (nodeType == Node.COMMENT_NODE)
                node.removeChild(child);
        }
    }

    private static ArrayList<String> sortirInfo(String mere, String enfant, Document doc) {
        ArrayList<String> info = new ArrayList<>();
        NodeList planetes = doc.getElementsByTagName(mere);
        for (int i = 0; i < planetes.getLength(); i++) {
            Element p = (Element) planetes.item(i);
            NodeList types = p.getElementsByTagName(enfant);
            for (int a = 0; a < types.getLength(); a++) {
                Element t = (Element) types.item(a);
                clean(t);
                NamedNodeMap map = t.getAttributes();
                //System.out.println(map.getNamedItem("id"));
                info.add(t.getAttribute("id") + "->" + t.getTextContent());
                //System.out.println(t.getElementsByTagName("pctGadolinium").item(0).getTextContent());
            }
        }
        return info;
    }

    public static void main(String[] args) throws InterruptedException, IOException, SAXException, ParserConfigurationException {

        Scanner sc = new Scanner(System.in);
        Random generator = new Random();
        String nomFichier = dateToString() + ".dat";

        System.out.println("Lancée : " + Date.from(Instant.now()));
        System.out.println("\nBienvenue dans la simulation de Opération Déchet \n\n");

        File fichierXML = new File("/Users/Olivier/Documents/devobjets/ProjetRecyclage/src/config.xml");

        ArrayList<String> infoPlanete = new ArrayList<>();
        ArrayList<String> infoDechet = new ArrayList<>();
        ArrayList<String> infoVaisseau = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(fichierXML);
            infoPlanete = sortirInfo("planete", "type", doc);
            infoDechet = sortirInfo("dechets", "sorte", doc);
            infoVaisseau = sortirInfo("vaisseau", "ship", doc);
        } catch (SAXException e) {
            System.out.println("SAX");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO");
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            System.out.println("PARSE");
            e.printStackTrace();
        }

        for (String string : infoPlanete)
            System.out.println(string);
        for (String string : infoDechet)
            System.out.println(string);
        for (String string : infoVaisseau)
            System.out.println(string);

        /*
        * Pas capable d'influencer les objets à partir des infos dans fichier XML
        * */


        //Quantité de vaisseaux et centres de tri
        int nbShip = obtenirValeur(10, 1000, "vaisseaux", sc);
        System.out.println();
        int nbCentreTri = obtenirValeur(1, 100, "centres de tri", sc);

        //Création des objets nécessaires
        vaisseau[] tabVaisseaux = vaisseau.creerVaisseaux(nbShip, generator);
        LinkedList<centreTri> linkCentreTri = centreTri.creerCentreTris(nbCentreTri);

        //Affichage (facultatif)
        afficherVaisseau();

        //Lancement
        boolean simulation = true;
        while (simulation) {

            for (vaisseau vaisseau : tabVaisseaux) {
                vaisseau.associerPlanete(generator);
                if (vaisseau instanceof lightShipHumain || vaisseau instanceof mediumShipHumain) {
                    vaisseau.viderVaisseauHumain(linkCentreTri);
                } else {
                    vaisseau.ramasserDechetsPlanete();
                    vaisseau.viderVaisseau(linkCentreTri);
                }
                simulation = finSimulation(linkCentreTri);
                if (!simulation)
                    break;
            }
        }

        //Enregistrement dans un fichier binaire
        boolean ok = false;
        while (!ok) {
            System.out.println();
            System.out.println("Voulez-vous enregistrer les résultats de la simulation ?");
            char choix = sc.next().toLowerCase().charAt(0);

            if (choix == 'o') {
                ok = true;
                File file;

                try {
                    file = new File("/Users/Olivier/Documents/devobjets/" + nomFichier);

                    boolean fichierExistant = file.createNewFile();
                    if (fichierExistant) {
                        System.out.println("\nLe fichier a été créer sous le nom de " + nomFichier);
                    } else {
                        System.out.println("\nLe fichier existe déjà");
                    }

                    ObjectOutputStream sortie = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomFichier)));
                    sortie.writeObject(statFinal(linkCentreTri, tabVaisseaux));
                    System.out.println("Les résultats de la simulation sont enregistrer dans le fichier créé.");
                    sortie.close();

                } catch (IOException e) {
                    System.out.println("Il y a une IOException");
                    e.printStackTrace();
                }
                System.out.println();
            } else if (choix == 'n') {
                ok = true;
            }
        }
        System.out.println("Merci d'avoir utiliser ce programme de simulation de sauvetage intergalactique");

    }
}
