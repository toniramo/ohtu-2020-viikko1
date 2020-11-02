package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto varastoAlkusaldolla;
    double alkusaldo = 50;
    double tilavuus = 100;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10+10);
        varastoAlkusaldolla = new Varasto(tilavuus+10,alkusaldo+10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void konstuktoriLuoVarastonAlkusaldolla() {
        assertEquals(alkusaldo, varastoAlkusaldolla.getSaldo(),vertailuTarkkuus);
    }
    
    @Test
    public void uudellaVarastollaAlkusaldollaOnOikeaTilavuus() {
        assertEquals(tilavuus,varastoAlkusaldolla.getTilavuus(),vertailuTarkkuus);
    }
    
    @Test
    public void konstruktiLuoKayttokelvottomanVarastonJosTilavuusNegatiivinen() {
        Varasto kelvotonVarasto = new Varasto(-10);
        assertEquals(0,kelvotonVarasto.getTilavuus(),vertailuTarkkuus);
    }
    
    @Test
    public void konstruktiLuoKayttokelvottomanVarastonJosTilavuusNegatiivinen2() {
        Varasto kelvotonVarasto = new Varasto(-10,10);
        assertEquals(0,kelvotonVarasto.getTilavuus(),vertailuTarkkuus);
    }
    
    @Test
    public void tilavuudenYlittavaAlkusaldoHylataan() {
        Varasto testivarasto = new Varasto(10,20);
        assertEquals(10,testivarasto.getSaldo(),vertailuTarkkuus);
    }
    
    @Test
    public void konstruktiAsettaaNegatiivisenAlkusaldonNollaksi() {
        Varasto testivarasto = new Varasto(28, -12.1);
        assertEquals(0,testivarasto.getSaldo(),vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenLisaysEiMuutaVarastosaldoa() {
        varastoAlkusaldolla.lisaaVarastoon(-10);
        assertEquals(alkusaldo,varastoAlkusaldolla.getSaldo(),vertailuTarkkuus);
    }
    
    @Test
    public void saldonYlittaessaTilavuudenYlimaaraHukataan() {
        varastoAlkusaldolla.lisaaVarastoon(varastoAlkusaldolla.getTilavuus()*1.1);
        assertEquals(varastoAlkusaldolla.getTilavuus(),varastoAlkusaldolla.getSaldo(),vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenOttoEiMuutaVarastosaldoa() {
        varastoAlkusaldolla.otaVarastosta(-50.2);
        assertEquals(alkusaldo,varastoAlkusaldolla.getSaldo(),vertailuTarkkuus);
    }
    
    @Test
    public void ottoYliSaldonTyhjentaaVaraston() {
        varastoAlkusaldolla.otaVarastosta(alkusaldo*1.5);
        assertEquals(0,varastoAlkusaldolla.getSaldo(),vertailuTarkkuus);
    }
    
    @Test
    public void ottoYliSaldonPalauttaaSaldon() {
        assertEquals(alkusaldo,varastoAlkusaldolla.otaVarastosta(alkusaldo*1.1),vertailuTarkkuus);
    }
    
    @Test
    public void varastonMerkkijonoesitysOnOikein() {
        assertEquals("saldo = " + alkusaldo + ", vielä tilaa " + (tilavuus-alkusaldo), varastoAlkusaldolla.toString());
    }
}