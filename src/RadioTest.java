import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Sharis Barrios
 *
 */

public class RadioTest {
    Radio radio = new Radio();

    @Test
	void encenderRadio() {
		radio.on();
		assertEquals(true, radio.isOn());
	}
}
