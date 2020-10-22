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
		return iplBattingList
				.stream().sorted(Comparator
						.comparing(batting -> Double.parseDouble(((IPLBatting) batting).getAverage())).reversed())
				.collect(Collectors.toList());
	}

	public List<IPLBatting> sortByStrikeRateDesc(String csvFilePath) throws CSVException {
		iplBattingList = csvFileLoader.loadBattingStats(csvFilePath);
		return iplBattingList.stream().sorted(Comparator.comparing(IPLBatting::getStrikeRate).reversed())
				.collect(Collectors.toList());
	}

	public List<IPLBatting> sortBySixesDesc(String csvFilePath) throws CSVException {
		iplBattingList = csvFileLoader.loadBattingStats(csvFilePath);
		return iplBattingList.stream().sorted(Comparator.comparing(IPLBatting::getSixes).reversed())
				.collect(Collectors.toList());
	}

	public List<IPLBatting> sortByFoursDesc(String csvFilePath) throws CSVException {
		iplBattingList = csvFileLoader.loadBattingStats(csvFilePath);
		return iplBattingList.stream().sorted(Comparator.comparing(IPLBatting::getFours).reversed())
				.collect(Collectors.toList());
	}

	public List<IPLBatting> getBestSRWithSixesFours(String csvFilePath) throws CSVException {
		iplBattingList = sortByStrikeRateDesc(csvFilePath);
		return iplBattingList
				.stream().sorted(Comparator
						.comparing(b -> ((IPLBatting) b).getSixes() * 6 + ((IPLBatting) b).getFours() * 4).reversed())
				.collect(Collectors.toList());
	}
}
