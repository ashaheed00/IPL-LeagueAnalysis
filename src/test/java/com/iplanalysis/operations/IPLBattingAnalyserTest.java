package com.iplanalysis.operations;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iplanalysis.csvclasses.IPLBatting;
import com.opencsv.builder.CSVException;

public class IPLBattingAnalyserTest {

	private static final String IPL_BATTING_CSV_FILE_PATH = "C:/Users/user/eclipse-workspace/IPL-LeagueAnalysis/LeaguesStats/IPL2019FactsheetMostRuns.csv";
	IPLAnalyser iplAnalyser;
	List<IPLBatting> sortedBattingList;

	IPLBatting ipl = new IPLBatting();

	@Before
	public void initializer() throws NoSuchFieldException, SecurityException {
		iplAnalyser = new IPLAnalyser();
	}

	@Test
	public void givenIPLBattingData_SortByAvg_ShouldReturnMaxAvg() throws CSVException {
		sortedBattingList = iplAnalyser.sortBattingData(IPL_BATTING_CSV_FILE_PATH, SortingComparators.BEST_BATTING_AVG);
		assertEquals("MS Dhoni", ((IPLBatting) sortedBattingList.get(0)).getPlayer());
	}

	@Test
	public void givenIPLBattingData_SortBySR_ShouldReturnMaxSR() throws CSVException {
		sortedBattingList = iplAnalyser.sortBattingData(IPL_BATTING_CSV_FILE_PATH, SortingComparators.BEST_SR);
		assertEquals("Ishant Sharma", ((IPLBatting) sortedBattingList.get(0)).getPlayer());
	}

	@Test
	public void givenIPLBattingData_SortBySixes_ShouldReturnMaxSixes() throws CSVException {
		sortedBattingList = iplAnalyser.sortBattingData(IPL_BATTING_CSV_FILE_PATH, SortingComparators.MOST_SIXES);
		assertEquals("Andre Russell", ((IPLBatting) sortedBattingList.get(0)).getPlayer());
	}

	@Test
	public void givenIPLBattingData_SortByFours_ShouldReturnMaxFours() throws CSVException {
		sortedBattingList = iplAnalyser.sortBattingData(IPL_BATTING_CSV_FILE_PATH, SortingComparators.MOST_FOURS);
		assertEquals("Shikhar Dhawan", ((IPLBatting) sortedBattingList.get(0)).getPlayer());
	}

	@Test
	public void givenIPLBattingData_SortBySRAndSixesFours_ShouldReturnMaxSixFourWithBestSR() throws CSVException {
		sortedBattingList = iplAnalyser.sortBattingData(IPL_BATTING_CSV_FILE_PATH,
				SortingComparators.MAX_SR_WITH_MOST_6s4s);
		assertEquals("Andre Russell", ((IPLBatting) sortedBattingList.get(0)).getPlayer());
	}

	@Test
	public void givenIPLBattingData_SortByAvgAndStrikeRate_ShouldReturnBestAvgWithBestSR() throws CSVException {
		sortedBattingList = iplAnalyser.sortBattingData(IPL_BATTING_CSV_FILE_PATH,
				SortingComparators.BEST_AVG_WITH_BEST_SR);
		assertEquals("MS Dhoni", ((IPLBatting) sortedBattingList.get(0)).getPlayer());
	}

	@Test
	public void givenIPLBattingData_SortMaxRunsWithBestSR_ShouldReturnMaxRunsWithBestSR() throws CSVException {
		sortedBattingList = iplAnalyser.sortBattingData(IPL_BATTING_CSV_FILE_PATH, SortingComparators.MAX_RUNS_BEST_SR);
		assertEquals("David Warner", ((IPLBatting) sortedBattingList.get(0)).getPlayer());
	}
}
