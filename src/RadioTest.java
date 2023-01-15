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
		assertEquals(540, radio.getAMActualStation());
	}

	@Test
	public void setUnaRadioAM() throws Exception {
		radio.setFrequence("AM");
		radio.setAMActualStation(1610);
		assertEquals(1610, radio.getAMActualStation());
	}

	@Test
	public void BackwardRadioAM() throws Exception {
		radio.setFrequence("AM");
		radio.setAMActualStation(1610);
		radio.Backward();
		assertEquals(1600, radio.getAMActualStation());
	}

	@Test
	public void ForwardRadioFM() throws Exception {
		radio.setFrequence("FM");
		radio.Forward();
		assertEquals(88.1, radio.getFMActualStation(), 0.01);
	}

	@Test
	public void setUnaRadioFM() throws Exception {
		radio.setFrequence("FM");
		radio.setFMActualStation(89.0);
		assertEquals(89.0, radio.getAMActualStation(), 0.01);
	}
}
