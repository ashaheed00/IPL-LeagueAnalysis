package com.iplanalysis.services;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iplanalysis.pojoclass.IPLBatsman;
import com.iplanalysis.pojoclass.IPLBowler;
import com.iplanalysis.services.IPLAnalyser;
import com.iplanalysis.services.SortingComparators;
import com.opencsv.builder.CSVException;

public class IPLBowlingAnalyserTest {
	private static final String IPL_BOWLING_CSV_FILE_PATH = "C:/Users/user/eclipse-workspace/IPL-LeagueAnalysis/LeaguesStats/IPL2019FactsheetMostWkts.csv";
	IPLAnalyser iplAnalyser;
	List<IPLBowler> sortedBowlingList;

	IPLBatsman ipl = new IPLBatsman();

	@Before
	public void initializer() throws NoSuchFieldException, SecurityException {
		iplAnalyser = new IPLAnalyser();
	}

	@Test
	public void givenIPLBowlingData_SortByAvg_ShouldReturnBestAvg() throws CSVException {
		sortedBowlingList = iplAnalyser.sortData(IPL_BOWLING_CSV_FILE_PATH, SortingComparators.BEST_BOWLING_AVG,
				IPLBowler.class);
		assertEquals("Anukul Roy", sortedBowlingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLBowlingData_SortBySR_ShouldReturnBestSR() throws CSVException {
		sortedBowlingList = iplAnalyser.sortData(IPL_BOWLING_CSV_FILE_PATH, SortingComparators.BEST_BOWLING_SR,
				IPLBowler.class);
		assertEquals("Alzarri Joseph", sortedBowlingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLBowlingData_SortByEconomy_ShouldReturnBestEconomyBowler() throws CSVException {
		sortedBowlingList = iplAnalyser.sortData(IPL_BOWLING_CSV_FILE_PATH, SortingComparators.BEST_ECONOMY_BOWLER,
				IPLBowler.class);
		assertEquals("Shivam Dube", sortedBowlingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLBowlingData_sortByBestSRWith5w4w_shouldReturnBestSRWith5w4wBowler() throws CSVException {
		sortedBowlingList = iplAnalyser.sortData(IPL_BOWLING_CSV_FILE_PATH, SortingComparators.BEST_SR_WITH_5W4W,
				IPLBowler.class);
		assertEquals("Kagiso Rabada", sortedBowlingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLBowlingData_sortByBestAvgWithBestSR_shouldReturnBestAvgWithBestSRBowler() throws CSVException {
		sortedBowlingList = iplAnalyser.sortData(IPL_BOWLING_CSV_FILE_PATH, SortingComparators.BEST_BOWLING_AVG_WITH_BEST_SR,
				IPLBowler.class);
		assertEquals("Alzarri Joseph", sortedBowlingList.get(0).getPlayer());
	}
}
