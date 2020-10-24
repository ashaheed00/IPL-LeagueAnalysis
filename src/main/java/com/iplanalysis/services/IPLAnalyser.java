package com.iplanalysis.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.iplanalysis.dataloaders.CsvFileLoader;
import com.iplanalysis.dataloaders.IDataLoaders;
import com.iplanalysis.pojoclass.IPLAllRounder;
import com.iplanalysis.pojoclass.IPLBatsman;
import com.iplanalysis.pojoclass.IPLBowler;
import com.opencsv.builder.CSVException;

public class IPLAnalyser implements DataAnalyser {

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

	/**
	 * This method takes batting and bowling data and sorts all-rounders data
	 */
	public List<IPLAllRounder> sortAllrounderData(String batsmanFilePath, String bowlerFilePath,
			Comparator<IPLAllRounder> comparator) throws CSVException {

		List<IPLAllRounder> iplAllRounderList = csvFileLoader.loadStats(batsmanFilePath, bowlerFilePath);
		return iplAllRounderList.stream().sorted(comparator).collect(Collectors.toList());
	}
}
