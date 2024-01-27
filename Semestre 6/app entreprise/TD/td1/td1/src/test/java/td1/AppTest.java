package td1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Unit test for StringUtilitaire class.
 */
public class AppTest {

    String input = "The economy is about to";

    @Test
    public void limiteAtteinte_chaineTronquee() {
        int limit = 11;
        assertEquals("The economy…", StringUtilitaire.tronquer(input, limit));
    }

    @Test
    public void limiteNonAtteinte_ChaineNonModifiee() {
        int limit = 32;
        assertEquals("The economy is about to", StringUtilitaire.tronquer(input, limit));
    }

    @Test
    public void limiteEgaleLgChaine_ChaineNonModifiee() {
        int limit = 25;
        assertEquals("The economy is about to", StringUtilitaire.tronquer(input, limit));
    }

    @Test
    public void invalidInput_isRejected() {
        String input = null;
        int limit = 25;
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtilitaire.tronquer(input, limit);
        });
    }

    @ParameterizedTest
    @MethodSource("inputOutputLimitProvider")
    public void invalidLimitInput_isRejected() {
        int limit = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtilitaire.tronquer(input, limit);
        });
    }

    @ParameterizedTest
    @MethodSource("inputOutputLimitProvider")
    public void limiteAtteinte_chaineTronquee(String input, int limit) {
        assertTrue(StringUtilitaire.tronquer(input, limit).length() <= limit);
    }

    @ParameterizedTest
    @MethodSource("inputOutputLimitProvider")
    void limiteNonAtteinte_ChaineNonModifiee(String input, int limit) {
        assertEquals(input, StringUtilitaire.tronquer(input, limit));
    }

    static Stream<Arguments> inputOutputLimitProvider() {
        return Stream.of(Arguments.of("The economy is about to", 32), Arguments.of("The economy is about to", 25));
    }
}