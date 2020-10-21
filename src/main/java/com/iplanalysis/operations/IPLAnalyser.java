package com.iplanalysis.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.builder.CSVBuilderFactory;
import com.opencsv.builder.CSVException;

public class IPLAnalyser {

	private List<IPLBatting> iplBattingList;

	public int loadStatesCSVData(String csvFilePath) throws CSVException {
		return 0;
	}

	public List<IPLBatting> loadBattingStats(String csvFilePath) throws CSVException {
		String[] file = csvFilePath.split("[.]");
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			if (!file[1].equals("csv")) {
				throw new CSVException("Wrong File type", CSVException.ExceptionType.WRONG_FILE_TYPE);
			}
			iplBattingList = CSVBuilderFactory.createCSVBuilder().getCsvFileList(reader, IPLBatting.class);
			return iplBattingList;
		} catch (IOException e) {
			throw new CSVException("Incorrect csv file path", CSVException.ExceptionType.WRONG_CSV_FILE);
		} catch (RuntimeException e) {
			throw new CSVException(e.getCause().getMessage(), CSVException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}
	}

	public List<IPLBatting> sortByBattingAvgDesc(String csvFilePath) throws CSVException {
		loadBattingStats(csvFilePath);
		if (iplBattingList == null || iplBattingList.size() == 0)
			throw new CSVException("No Census data found", CSVException.ExceptionType.NO_CENSUS_DATA);
		iplBattingList = iplBattingList.stream().map(batsman -> {
			try {
				Double.parseDouble(batsman.average);
			} catch (NumberFormatException e) {
				batsman.average = "0";
			}
			return batsman;
		}).collect(Collectors.toList());
		Collections.sort(iplBattingList, Comparator.comparing(batting -> Double.parseDouble(batting.average)));
		Collections.reverse(iplBattingList);
		return iplBattingList;
	}

}
