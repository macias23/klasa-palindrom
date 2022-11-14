import java.lang.Character;
import java.util.Hashtable;

public class Palindrom {
    public static int liczZnajdzNajdluzszyPalindrom;
    public static int liczAnalizujSubslowo;
    public static int liczCzyPalindrom;
    Palindrom(String tresc){
        tekst=tresc;
        surowyTekst=utworzSurowyTekst();
        najdluzszyPalindrom=znajdzNajdluzszyPalindrom(surowyTekst);
    }
    private String najdluzszyPalindrom;
    private String tekst;
    private String surowyTekst;

    public String getTekst() {
        return tekst;
    }
    public String toString(){
        return tekst+" "+surowyTekst+" "+najdluzszyPalindrom;
    }
    public String getSurowyTekst(){
        return surowyTekst;
    }
    public String getNajdluzszyPalindrom()
    {return najdluzszyPalindrom;}
    public String utworzSurowyTekst(){
        StringBuilder slowo = new StringBuilder(tekst);
        for(int i=0; i<slowo.length()-1; i++){
            if(!Character.isLetter(slowo.charAt(i))){
                slowo.deleteCharAt(i);
            }
            if (Character.isUpperCase(slowo.charAt(i))) {
                slowo.setCharAt(i,Character.toLowerCase(slowo.charAt(i)));
            }
        }
        return slowo.toString();


    }
    public boolean equals(Palindrom obiekt){
        if (obiekt.getClass()!=Palindrom.class) return false;
        if (!tekst.equals(obiekt.getTekst())) return false;
        if (!surowyTekst.equals((obiekt.getSurowyTekst()))) return false;
        if (obiekt==null) return false;
        return true;
    }
    public int hashCode(){
        return tekst.length()*surowyTekst.length()*najdluzszyPalindrom.length();
    }
    /*public int hashCode(){
        return test.hashCode();
    }*/

    public static boolean czyPalindrom(String slowo) {
        liczCzyPalindrom++;
        int i1 = 0;
        int i2 = slowo.length() - 1;
        while (i2 > i1) {
            if (slowo.charAt(i1) != slowo.charAt(i2)) {
                return false;
            }
            i1++;
            i2--;
        }
        return true;
    }

    public static String analizujSubslowo(String slowo) {
        liczAnalizujSubslowo++;
        if (czyPalindrom(slowo)) {
            return slowo;
        } else return "";
    }

    public static String znajdzNajdluzszyPalindrom(String slowo) {
        liczZnajdzNajdluzszyPalindrom++;
        String najdluzszyPalindrom = "";
        String aktualny = "";
        for (int i = 0; i < slowo.length(); i++) {
            String subslowo = slowo.substring(i, slowo.length());
            int index = subslowo.length();
            while (index > 0) {
                String substring = subslowo.substring(0, index);
                aktualny = analizujSubslowo(substring);
                if (najdluzszyPalindrom.length() < aktualny.length())
                    najdluzszyPalindrom = aktualny;
                index--;
            }
        }
        return najdluzszyPalindrom;
    }

    public static void main(String[] args) {
        String N ="ala";
        Palindrom tobiasz=new Palindrom("Do geese see God?");
        String Ndziesiec="qwertyuiopasdfghjklzxcvbnmjhgf";
        System.out.println(tobiasz.toString());
        String Nsto="qwertyuiopasdfghjklzxcvbnm" +
                "mnbbzabvcxzasfghsfjloytwildoiequdaalallalalalalalkamilifhuaedzkjlkdanfeqlk";
        System.out.println(znajdzNajdluzszyPalindrom(N));
        System.out.println("liczCzyPalindrom: " +liczCzyPalindrom);
        System.out.println("liczAnalizujSubslowo: " +liczAnalizujSubslowo);
        System.out.println("liczZnajdzNadluzszyPalindrom " +liczZnajdzNajdluzszyPalindrom);
    }
}
