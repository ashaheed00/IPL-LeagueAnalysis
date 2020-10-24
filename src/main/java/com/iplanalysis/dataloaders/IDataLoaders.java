package com.iplanalysis.dataloaders;

import java.util.List;

import com.opencsv.builder.CSVException;

public interface IDataLoaders {
	public <E> List<E> loadStats(String csvFilePath, Class<E> csvClass) throws CSVException;
}
