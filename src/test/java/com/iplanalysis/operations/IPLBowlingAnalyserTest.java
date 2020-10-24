package com.iplanalysis.operations;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iplanalysis.csvclasses.IPLBatting;
import com.iplanalysis.csvclasses.IPLBowling;
import com.opencsv.builder.CSVException;

public class IPLBowlingAnalyserTest {
	private static final String IPL_BOWLING_CSV_FILE_PATH = "C:/Users/user/eclipse-workspace/IPL-LeagueAnalysis/LeaguesStats/IPL2019FactsheetMostWkts.csv";
	IPLAnalyser iplAnalyser;
	List<IPLBowling> sortedBowlingList;

	IPLBatting ipl = new IPLBatting();

	@Before
	public void initializer() throws NoSuchFieldException, SecurityException {
		iplAnalyser = new IPLAnalyser();
	}

	@Test
	public void givenIPLBowlingData_SortByAvg_ShouldReturnBestAvg() throws CSVException {
		sortedBowlingList = iplAnalyser.sortBowlingData(IPL_BOWLING_CSV_FILE_PATH, SortingComparators.BEST_BOWLING_AVG);
		assertEquals("Anukul Roy", sortedBowlingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLBowlingData_SortBySR_ShouldReturnBestSR() throws CSVException {
		sortedBowlingList = iplAnalyser.sortBowlingData(IPL_BOWLING_CSV_FILE_PATH, SortingComparators.BEST_BOWLING_SR);
		assertEquals("Alzarri Joseph", sortedBowlingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLBowlingData_SortByEconomy_ShouldReturnBestEconomyBowler() throws CSVException {
		sortedBowlingList = iplAnalyser.sortBowlingData(IPL_BOWLING_CSV_FILE_PATH,
				SortingComparators.BEST_ECONOMY_BOWLER);
		assertEquals("Shivam Dube", sortedBowlingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLBowlingData_sortByBestSRWith5w4w_shouldReturnBestSRWith5w4wBowler() throws CSVException {
		sortedBowlingList = iplAnalyser.sortBowlingData(IPL_BOWLING_CSV_FILE_PATH,
				SortingComparators.BEST_SR_WITH_5W4W);
		assertEquals("Kagiso Rabada", sortedBowlingList.get(0).getPlayer());
	}
}
