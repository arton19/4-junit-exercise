package price.formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Write your tests for the PriceFormatter here. See the specification of the
 * PriceFormatter and formatPrice method in the PriceFormatter class and the
 * readme file.
 */
public class PriceFormatterTest {
    
    private final PriceFormatter formatter = new PriceFormatter();

    @Test
    void valilyontiTuhansienValiin() {
        assertEquals("750,25 €", formatter.formatPrice(750.25));
        assertEquals("2 000 €", formatter.formatPrice(2000));
        assertEquals("45 678,90 €", formatter.formatPrice(45678.9));
        assertEquals("1 234 567,89 €", formatter.formatPrice(1234567.89));
    }
    
    @Test
    void pyoristysSentinTarkkuudella() {
        assertEquals("2,72 €", formatter.formatPrice(2.718281828));
        assertEquals("8,13 €", formatter.formatPrice(8.126));
        assertEquals("8,12 €", formatter.formatPrice(8.123));
        assertEquals("0,99 €", formatter.formatPrice(0.991));
        assertEquals("6,50 €", formatter.formatPrice(6.5));
        assertEquals("6,07 €", formatter.formatPrice(6.07));
        assertEquals("6,20 €", formatter.formatPrice(6.2));
    }
    
    @Test
    void desimaaliPoisJosSePyoristyyNollaan() {
        assertEquals("8 €", formatter.formatPrice(8.0));
        assertEquals("250 €", formatter.formatPrice(250.0));
        assertEquals("0 €", formatter.formatPrice(0));
        assertEquals("8 €", formatter.formatPrice(7.998));
        assertEquals("7 €", formatter.formatPrice(7.002));
        assertEquals("1 000 €", formatter.formatPrice(999.996));
    }
}
