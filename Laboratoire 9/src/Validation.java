/*
 * Created by Olivier Blackburn on 01/04/19 1:19 PM.
 */

public class Validation {

    private static String pays = "mexique,états-unis,canada,france,angleterre,chine,autriche,allemagne,russie,australie,belgique,cuba,inde,espagne,italie,brésil";
    private static String[] tabPays = pays.split(",");
    private static String provinces = "alberta,colombie britannique,île-du-prince-édouard,manitoba,nouveau-brunswick,nouvelle-écosse,ontario,québec,saskatchewan,terre-neuve-et-labrador,nunavut,territoires du nord-ouest,yukon";
    private static String[] tabProvinces = provinces.split(",");

    public static boolean pays(String lePays){
        boolean valid = false;
        lePays = lePays.toLowerCase();
        for(int i = 0; i<tabPays.length;i++){
            if(tabPays[i].equals(lePays))
                valid = true;
        }
        return valid;
    }

    public static boolean province(String lePays, String laProvince){
        boolean valid = false;
        lePays = lePays.toLowerCase();
        laProvince = laProvince.toLowerCase();
        if(lePays.equals("canada")) {
            for (int i = 0; i < tabProvinces.length; i++) {
                if (tabProvinces[i].equals(laProvince))
                    valid = true;
            }
        } else {
            valid = true;
        }
        return valid;
    }

    public static boolean numeroTelephone(String leNumero){
        boolean valid = false;
        int longueur = 0;
        if(leNumero.length()==12) {
            for (int i = 0; i < leNumero.length(); i++) {
                if((int)leNumero.charAt(i)<=57 && (int)leNumero.charAt(i)>=48) {
                    if(leNumero.charAt(3) == '-' && leNumero.charAt(7) == '-')
                        longueur++;
                }
            }
            if(longueur == 10) {
                valid = true;
            }
        }
        return valid;
    }
}
