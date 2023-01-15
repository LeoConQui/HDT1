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
	public void cambiaraAM() throws Exception{
		radio.setFrequence("AM");
		assertEquals("AM", radio.getFrequence());
	}

	@Test
	public void ForwardRadioAM() throws Exception {
		radio.setFrequence("AM");
		radio.Forward();
		assertEquals(540, radio.getFrequence());
	}

	@Test
	public void BackwardRadioAM() throws Exception {
		radio.setFrequence("AM");
		radio.setAMActualStation(530);
		radio.Forward();
		assertEquals(1610, radio.getFrequence());
	}
}
