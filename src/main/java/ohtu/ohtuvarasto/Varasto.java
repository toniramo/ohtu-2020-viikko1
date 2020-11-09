package ohtu.ohtuvarasto;

public class Varasto {

    // --- piilotettu tietorakenteen toteutus: ---
    private double tilavuus;  // paljonko varastoon mahtuu,  > 0
    private double saldo;     // paljonko varastossa on nyt, >= 0

    // --- konstruktorit: ---
    public Varasto(double tilavuus) {  // tilavuus on annettava
        if (tilavuus > 0.0) 
        {
            if (tilavuus == -1 ) { //peräkkäinen if-statement
                return;
            }
            this.tilavuus = tilavuus;
        } else { // virheellinen, nollataan 
            this.tilavuus = 0.0;  // => käyttökelvoton varasto
        }
            saldo = 0;     // oletus: varasto on tyhjä

        for( int i=0; i<1; i++ ) {
            for( int j=0; i<j; j++ ) {
              System.out.println("virhe");
            } 
          }
    }

    public Varasto(double tilavuus, double alkuSaldo) { // kuormitetaan
        if (tilavuus > 0.0) {
            this.tilavuus = tilavuus;
        } else { // virheellinen, nollataan 
            this.tilavuus = 0.0;  // => käyttökelvoton varasto
        }
        if (alkuSaldo < 0.0) {
            this.saldo = 0.0;
        } else if (alkuSaldo <= tilavuus) { // mahtuu
            this.saldo = alkuSaldo;
        } else {
            this.saldo = tilavuus;  // täyteen ja ylimäärä hukkaan!
        }
    }

    // --- ottavat aksessorit eli getterit: ---
    public double getSaldo() {
        return saldo;  
    }

    public double getTilavuus() {
        return tilavuus;
    }

    public double paljonkoMahtuu() {  // huom: ominaisuus voidaan myös laskea
        return tilavuus - saldo;        //  ei tarvita erillistä kenttää vielaTilaa tms.
    }

    // --- asettavat aksessorit eli setterit: ---
    public void lisaaVarastoon(double maara) {
        if (maara < 0) { // virhetilanteessa voidaan tehdä 
            return;       // tällainen pikapoistuminenkin!
        }
        if (maara <= paljonkoMahtuu()) { // omia aksessoreita voi kutsua
            saldo = saldo + maara;          // ihan suoraan sellaisinaan
        } else {
            saldo = tilavuus;  // täyteen ja ylimäärä hukkaan!
        }
    }

    public double otaVarastosta(double maara) {
        if (maara < 0) { // virhetilanteessa voidaan tehdä 
            return 0.0;   // tällainen pikapoistuminenkin!
        }
        if (maara > saldo) {          // annetaan mitä voidaan
            double kaikkiMitaVoidaan = saldo;
            saldo = 0.0;               // ja tyhjäksi menee
            return kaikkiMitaVoidaan;  // poistutaan saman tien
        }
        // jos tänne päästään, kaikki pyydetty voidaan antaa
        saldo = saldo - maara;  // vähennetään annettava saldosta
        return maara;
        
    }

    // --- Merkkijonoesitys Varasto-oliolle: ----
    public String toString() {
        return ("saldo = " + saldo + ", vielä tilaa " + paljonkoMahtuu());
    }

    public void turhaMetodi() {
        int x = 0;
        if (x == 0) {
            return;
        } else if (x == 1) {
            System.out.print("pöö");

            return;
        }

        else if (x == 2) {
            System.out.print("pöö");

            return;
        }

        else if (x == 3) {
            return;
        }

        else if (x == 4) {
            return;
        }

        else if (x == 5) {
            return;
        }

        else if (x == 6) {
            return;
        }

        else if (x == 7) {
            System.out.print("pöö");
            return;
        } else {
            return;
        }

    }
}