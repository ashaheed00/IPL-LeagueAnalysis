package com.iplanalysis.operations;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iplanalysis.csvclasses.IPLBatting;
import com.opencsv.builder.CSVException;

public class IPLAnalyserTest {

	private static final String IPL_BATTING_CSV_FILE_PATH = "C:/Users/user/eclipse-workspace/IPLLeagueAnalysis/LeaguesStats/IPL2019FactsheetMostRuns.csv";
	IPLAnalyser iplAnalyser;

	@Before
	public void initializer() {
		iplAnalyser = new IPLAnalyser();
	}

	@Test
	public void givenIPLData_ShouldReturnNumberOfRecords() throws CSVException {
		List<IPLBatting> highestBattingAvg = iplAnalyser.sortByBattingAvgDesc(IPL_BATTING_CSV_FILE_PATH);
		assertEquals("83.2", highestBattingAvg.get(0).getAverage());
	}
}
