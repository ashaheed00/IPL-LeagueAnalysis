package com.iplanalysis.operations;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.iplanalysis.csvclasses.IPLBatting;
import com.iplanalysis.fileloaders.CsvFileLoader;
import com.opencsv.builder.CSVException;

public class IPLAnalyser {

	private List<IPLBatting> iplBattingList;
	private CsvFileLoader csvFileLoader;

	public IPLAnalyser() {
		csvFileLoader = new CsvFileLoader();
	}

	public List<IPLBatting> sortByBattingAvgDesc(String csvFilePath) throws CSVException {
		iplBattingList = csvFileLoader.loadBattingStats(csvFilePath);
		return iplBattingList.stream().sorted(SortingComparators.BEST_BATTING_AVG).collect(Collectors.toList());
	}

	public List<IPLBatting> sortByStrikeRateDesc(String csvFilePath) throws CSVException {
		iplBattingList = csvFileLoader.loadBattingStats(csvFilePath);
		return iplBattingList.stream().sorted(SortingComparators.BEST_SR).collect(Collectors.toList());
	}

	public List<IPLBatting> sortBySixesDesc(String csvFilePath) throws CSVException {
		iplBattingList = csvFileLoader.loadBattingStats(csvFilePath);
		return iplBattingList.stream().sorted(SortingComparators.MOST_SIXES).collect(Collectors.toList());
	}

	public List<IPLBatting> sortByFoursDesc(String csvFilePath) throws CSVException {
		iplBattingList = csvFileLoader.loadBattingStats(csvFilePath);
		return iplBattingList.stream().sorted(SortingComparators.MOST_FOURS).collect(Collectors.toList());
	}

	public List<IPLBatting> sortByBestSRWithSixesFours(String csvFilePath) throws CSVException {
		iplBattingList = csvFileLoader.loadBattingStats(csvFilePath);
		return iplBattingList.stream().sorted(SortingComparators.MAX_SR_WITH_MOST_6s4s).collect(Collectors.toList());
	}

	public List<IPLBatting> sortByBestAvgWithBestSR(String csvFilePath) throws CSVException {
		iplBattingList = csvFileLoader.loadBattingStats(csvFilePath);
		return iplBattingList.stream().sorted(SortingComparators.BEST_AVG_WITH_BEST_SR).collect(Collectors.toList());
	}

	public List<IPLBatting> sortByRunsWithBestSR(String csvFilePath) throws CSVException {
		iplBattingList = csvFileLoader.loadBattingStats(csvFilePath);
		return iplBattingList.stream().sorted(SortingComparators.MAX_RUNS_BEST_SR).collect(Collectors.toList());
	}
}
