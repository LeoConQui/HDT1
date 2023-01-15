import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Sharis Barrios
 *
 */

public class RadioTest {

    Radio radio = new Radio();

    @Test
	public void encenderRadio() {
		radio.on();
		assertEquals(true, radio.isOn());
	}

	@Test
	public void apagarRadio() {
		radio.off();
		assertEquals(false, radio.isOn());
	}

	@Test
	public void cambiarAFM() throws Exception{
		radio.setFrequence("FM");
		assertEquals("FM", radio.getFrequence());
	} 

	@Test
	public void cambiarAAM() throws Exception{
		radio.setFrequence("AM");
		assertEquals("AM", radio.getFrequence());
	}


}
