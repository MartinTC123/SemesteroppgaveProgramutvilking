package Avvikshåndtering;

public class TableViewAvvik {

    int test;

    public boolean navnTVHaandtering(String nyVerdi){
        if (nyVerdi.equals("")){
            return false;
        }
        return Avvik.navnHaandtering(nyVerdi);
    }

    public boolean komponentTVHaandtering(String nyVerdi){
        if (nyVerdi.equals("")){
            return false;
        }
        return Avvik.TableKomponentHaandtering(nyVerdi);
    }

    public boolean prisTVHaandtering(int nyVerdi){
        if (nyVerdi == 0){
            return false;
        }
        return Avvik.prisHaandtering(nyVerdi);
    }
}
