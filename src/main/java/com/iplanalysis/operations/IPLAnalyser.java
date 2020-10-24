package com.iplanalysis.operations;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.iplanalysis.csvclasses.IPLBatting;
import com.iplanalysis.csvclasses.IPLBowling;
import com.iplanalysis.fileloaders.CsvFileLoader;
import com.opencsv.builder.CSVException;

public class IPLAnalyser {

	private CsvFileLoader csvFileLoader;

	public IPLAnalyser() {
		csvFileLoader = new CsvFileLoader();
	}

	/**
	 * This method is a common method using generic to sort any type of data
	 * providing class type and Comparator
	 */
	public <E> List<E> sortData(String csvFilePath, Comparator comparator, Class<E> csvClass) throws CSVException {
		List<E> iplList = csvFileLoader.loadStats(csvFilePath, csvClass);
		return (List<E>) iplList.stream().sorted(comparator).collect(Collectors.toList());
	}
}
