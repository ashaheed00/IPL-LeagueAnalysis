package com.iplanalysis.operations;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.iplanalysis.csvclasses.IPLBatting;
import com.iplanalysis.csvclasses.IPLBowling;
import com.iplanalysis.fileloaders.CsvFileLoader;
import com.opencsv.builder.CSVException;

public class IPLAnalyser {

	private List<IPLBatting> iplBattingList;
	private List<IPLBowling> iplBowlingList;
	private CsvFileLoader csvFileLoader;

	public IPLAnalyser() {
		csvFileLoader = new CsvFileLoader();
	}

	// This method is common method to sort batting data providing any Comparator
	public List<IPLBatting> sortBattingData(String csvFilePath, Comparator comparator) throws CSVException {
		iplBattingList = csvFileLoader.loadBattingStats(csvFilePath);
		return (List<IPLBatting>) iplBattingList.stream().sorted(comparator).collect(Collectors.toList());
	}

	// This method is common method to sort bowling data providing any Comparator
	public List<IPLBowling> sortBowlingData(String csvFilePath, Comparator comparator) throws CSVException {
		iplBowlingList = csvFileLoader.loadBowlingStats(csvFilePath);
		return (List<IPLBowling>) iplBowlingList.stream().sorted(comparator).collect(Collectors.toList());
	}
}
