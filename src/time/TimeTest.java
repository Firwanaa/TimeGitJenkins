/*
 * @name Alqassam Firwana
 * @id 991606962
 * ICE-3 Test Driven Development TDD
 * **/
package time;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	// GetTotalSeconds
	@Test
	public void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue("Seconds not handled properly", seconds == 18305);
	}

	// @Test
	public void testGetTotalSecondsBoundry() {
		int total = Time.getTotalSeconds("00:00:00");
		assertTrue("The Seconds were not calculated properly", total == 0);
	}

	@Test
	public void testGetTotalSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, () -> {
			Time.getTotalSeconds("10:00");
		});
	}

	// GetSeconds
	@Test
	public void testGetSecondsGood() {
		int sec = Time.getSeconds("05:05:15");
		assertTrue("Seconds not correct", sec == 15);
	}

	@ParameterizedTest
	@ValueSource(strings = { "06:10:00", "07:15:30", "08:59:60" })
	public void testGetSecondsBoundry(String values) {
		int sec = Time.getSeconds(values);
		assertTrue("Seconds not correct", (sec >= 0 && sec <= 60));
	}

	@Test
	public void testGetSecondsBad() {
//		int sec = Time.getSeconds("05:05:15");
//		assertFalse("Seconds not correct", sec == 05);
		assertThrows(StringIndexOutOfBoundsException.class, () -> {
			Time.getSeconds("10:00");
		});
	}

	// GetMinutes
	@Test
	public void testGetTotalMinutesGood() {
		int min = Time.getTotalMinutes("05:05:15");
		assertTrue("Minutes not correct", min == 5);
	}

	@ParameterizedTest
	@ValueSource(strings = { "06:00:00", "07:30:30", "08:59:60" })
	public void testGetTotalMinutesBoundry(String values) {
		int min = Time.getTotalMinutes(values);
		assertTrue("Minutes not correct", (min >= 0 && min <= 60));
	}

	@Test
	public void testGetTotalMinutesBad() {
		assertThrows(NumberFormatException.class, () -> {
			Time.getTotalMinutes("05:0:005");
		});
	}

	// GetHours
	@Test
	public void testGetTotalHoursGood() {
		int hr = Time.getTotalHours("05:05:15");
		assertTrue("Hours not correct", hr == 5);
	}

	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15", "05:59:59" })
	public void testGetTotalHoursBoundry(String value) {
		int hr = Time.getTotalHours(value);
		assertTrue("Hours boundry boundry not correct", hr == 5);
	}

	@Test
	public void testGetTotalHoursBad() {
		assertThrows(NumberFormatException.class, () -> {
			Time.getTotalHours("ABC");
		});

	}
	
	/*************************************************************************
	 * 							ICE3 Part                                    * 
	 *************************************************************************/
	@Test
	void testGetMillisecondsGood() {
		int millseconds = Time.getMilliseconds("05:05:15:005");
		assertTrue("Milliseconds not correct", millseconds == 5);
	}
	@Test
	void testGetMillisecondsBad() {
		assertThrows( StringIndexOutOfBoundsException.class, () -> {
			Time.getMilliseconds("05:05:05999");
		});
	}
	@ParameterizedTest
	@ValueSource(strings = { "06:10:00:000", "07:15:50:500", "08:59:59:999" })
	public void testGetMillisecondsBoundry(String values) {
		int millisec = Time.getMilliseconds(values);
		assertTrue("MilliSeconds not correct", (millisec >= 0 && millisec < 1000));
	}
	
	

}

