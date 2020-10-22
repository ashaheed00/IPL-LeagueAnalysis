package com.iplanalysis.fileloaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.iplanalysis.csvclasses.IPLBatting;
import com.iplanalysis.csvclasses.IPLBowling;
import com.opencsv.builder.CSVBuilderFactory;
import com.opencsv.builder.CSVException;

public class CsvFileLoader {

	public List<IPLBatting> loadBattingStats(String csvFilePath) throws CSVException {
		String[] file = csvFilePath.split("[.]");
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			if (!file[1].equals("csv")) {
				throw new CSVException("Wrong File type", CSVException.ExceptionType.WRONG_FILE_TYPE);
			}
			List<IPLBatting> iplBattingList = CSVBuilderFactory.createCSVBuilder().getCsvFileList(reader,
					IPLBatting.class);
			if (iplBattingList == null || iplBattingList.size() == 0)
				throw new CSVException("No Census data found", CSVException.ExceptionType.NO_CENSUS_DATA);

			return iplBattingList;
		} catch (IOException e) {
			throw new CSVException("Incorrect csv file path", CSVException.ExceptionType.WRONG_CSV_FILE);
		} catch (RuntimeException e) {
			throw new CSVException(e.getCause().getMessage(), CSVException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}
	}

	public List<IPLBowling> loadBowlingStats(String csvFilePath) throws CSVException {
		String[] file = csvFilePath.split("[.]");
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			if (!file[1].equals("csv")) {
				throw new CSVException("Wrong File type", CSVException.ExceptionType.WRONG_FILE_TYPE);
			}
			List<IPLBowling> iplBowlingList = CSVBuilderFactory.createCSVBuilder().getCsvFileList(reader,
					IPLBowling.class);
			if (iplBowlingList == null || iplBowlingList.size() == 0)
				throw new CSVException("No Census data found", CSVException.ExceptionType.NO_CENSUS_DATA);

			return iplBowlingList;
		} catch (IOException e) {
			throw new CSVException("Incorrect csv file path", CSVException.ExceptionType.WRONG_CSV_FILE);
		} catch (RuntimeException e) {
			throw new CSVException(e.getCause().getMessage(), CSVException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}
	}

}
