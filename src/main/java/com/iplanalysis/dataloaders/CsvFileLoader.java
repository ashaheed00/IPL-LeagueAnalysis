package com.iplanalysis.dataloaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.iplanalysis.pojoclass.IPLAllRounder;
import com.iplanalysis.pojoclass.IPLBatsman;
import com.iplanalysis.pojoclass.IPLBowler;
import com.opencsv.builder.CSVBuilderFactory;
import com.opencsv.builder.CSVException;

public class CsvFileLoader implements IDataLoaders {

	private List<IPLAllRounder> iplAllRounderList = new ArrayList<IPLAllRounder>();;

	@Override
	public <E> List<E> loadStats(String csvFilePath, Class<E> csvClass) throws CSVException {
		String[] file = csvFilePath.split("[.]");
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			if (!file[1].equals("csv"))
				throw new CSVException("Wrong File type", CSVException.ExceptionType.WRONG_FILE_TYPE);
			List<E> csvList = CSVBuilderFactory.createCSVBuilder().getCsvFileList(reader, csvClass);
			if (csvList == null || csvList.size() == 0)
				throw new CSVException("No Census data found", CSVException.ExceptionType.NO_CENSUS_DATA);

			return csvList;
		} catch (IOException e) {
			throw new CSVException("Incorrect csv file path", CSVException.ExceptionType.WRONG_CSV_FILE);
		} catch (RuntimeException e) {
			throw new CSVException(e.getCause().getMessage(), CSVException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}
	}

	public List<IPLAllRounder> loadStats(String batsmanFilePath, String bowlerFilePath) throws CSVException {
		List<IPLBatsman> iplBatsmanList = loadStats(batsmanFilePath, IPLBatsman.class);
		List<IPLBowler> iplBowlerList = loadStats(bowlerFilePath, IPLBowler.class);

		iplBatsmanList.stream().forEach(batsman -> {
			IPLBowler bowlers = iplBowlerList.stream()
					.filter(bowler -> bowler.getPlayer().equalsIgnoreCase(batsman.getPlayer())).findFirst()
					.orElse(null);
			if (bowlers != null) {
				iplAllRounderList.add(new IPLAllRounder(batsman.getPlayer(), batsman.getRuns(), bowlers.getWickets(),
						batsman.getAverage(), bowlers.getAverage()));
			}
		});
		return iplAllRounderList;
	}
}
