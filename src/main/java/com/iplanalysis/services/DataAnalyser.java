package com.iplanalysis.services;

import java.util.Comparator;
import java.util.List;

import com.opencsv.builder.CSVException;

public interface DataAnalyser {
	public <E> List<E> sortData(String csvFilePath, Comparator comparator, Class<E> csvClass) throws CSVException;
}
