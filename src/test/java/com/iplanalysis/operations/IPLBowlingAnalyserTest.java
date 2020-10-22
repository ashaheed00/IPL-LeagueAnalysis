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
	public void givenIPLBattingData_SortByAvg_ShouldReturnMaxAvg() throws CSVException {
		sortedBowlingList = iplAnalyser.sortBowlingDataByField(IPL_BOWLING_CSV_FILE_PATH,
				SortingComparators.BEST_BOWLING_AVG);
		assertEquals("83.2", sortedBowlingList.get(0).getAverage());
	}
}
