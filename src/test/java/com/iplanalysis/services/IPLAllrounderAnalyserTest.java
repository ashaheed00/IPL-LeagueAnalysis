package com.iplanalysis.services;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iplanalysis.pojoclass.IPLAllRounder;
import com.opencsv.builder.CSVException;

public class IPLAllrounderAnalyserTest {
	private static final String IPL_BATTING_CSV_FILE_PATH = "C:/Users/user/eclipse-workspace/IPL-LeagueAnalysis/LeaguesStats/IPL2019FactsheetMostRuns.csv";
	private static final String IPL_BOWLING_CSV_FILE_PATH = "C:/Users/user/eclipse-workspace/IPL-LeagueAnalysis/LeaguesStats/IPL2019FactsheetMostWkts.csv";
	IPLAnalyser iplAnalyser;
	List<IPLAllRounder> sortedAllrounderList;

	@Before
	public void initializer() throws NoSuchFieldException, SecurityException {
		iplAnalyser = new IPLAnalyser();
	}

	@Test
	public void givenIPLBowlingData_SortByAvg_ShouldReturnBestAvg() throws CSVException {
		sortedAllrounderList = iplAnalyser.sortAllrounderData(IPL_BATTING_CSV_FILE_PATH, IPL_BOWLING_CSV_FILE_PATH,
				SortingComparators.BEST_BATTING_AND_BOWLING_AVG);
		assertEquals("Andre Russell", sortedAllrounderList.get(0).getPlayer());
	}

}
