package com.iplanalysis.operations;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iplanalysis.csvclasses.IPLBatting;
import com.opencsv.builder.CSVException;

public class IPLAnalyserTest {

	private static final String IPL_BATTING_CSV_FILE_PATH = "C:/Users/user/eclipse-workspace/IPL-LeagueAnalysis/LeaguesStats/IPL2019FactsheetMostRuns.csv";
	IPLAnalyser iplAnalyser;

	IPLBatting ipl = new IPLBatting();

	@Before
	public void initializer() throws NoSuchFieldException, SecurityException {
		iplAnalyser = new IPLAnalyser();
	}

	@Test
	public void givenIPLBattingData_SortByAvg_ShouldReturnMaxAvg() throws CSVException {
		List<IPLBatting> highestBattingAvg = iplAnalyser.sortByBattingAvgDesc(IPL_BATTING_CSV_FILE_PATH);
		assertEquals("83.2", highestBattingAvg.get(0).getAverage());
	}

	@Test
	public void givenIPLBattingData_SortBySR_ShouldReturnMaxSR() throws CSVException {
		List<IPLBatting> sortedBySRList = iplAnalyser.sortByStrikeRateDesc(IPL_BATTING_CSV_FILE_PATH);
		assertEquals(333.33, sortedBySRList.get(0).getStrikeRate(), 0);
	}

	@Test
	public void givenIPLBattingData_SortBySixes_ShouldReturnMaxSixes() throws CSVException {
		List<IPLBatting> sortedListBySixes = iplAnalyser.sortBySixesDesc(IPL_BATTING_CSV_FILE_PATH);
		assertEquals(52, sortedListBySixes.get(0).getSixes());
	}

	@Test
	public void givenIPLBattingData_SortByFours_ShouldReturnMaxFours() throws CSVException {
		List<IPLBatting> sortedListByFours = iplAnalyser.sortByFoursDesc(IPL_BATTING_CSV_FILE_PATH);
		assertEquals(64, sortedListByFours.get(0).getFours());
	}

	@Test
	public void givenIPLBattingData_SortBySRAndSixesFours_ShouldReturnMaxSixFourWithBestSR() throws CSVException {
		List<IPLBatting> sortedListByBoundary = iplAnalyser.getBestSRWithSixesFours(IPL_BATTING_CSV_FILE_PATH);
		assertEquals("Andre Russell", sortedListByBoundary.get(0).getPlayer());
	}
}
