package com.iplanalysis.operations;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class IPLAnalyserTest {
	IPLAnalyser iplAnalyser;

	@Before
	public void initializer() {
		iplAnalyser = new IPLAnalyser();
	}

	@Test
	public void givenIPLData_ShouldReturnNumberOfRecords() {
		List<IPLAnalyser> highestBattingAvg = iplAnalyser.sortByBattingAvgDesc();
		assertEquals(69.2, highestBattingAvg.get(0));
	}
}
