package com.iplanalysis.operations;

import java.util.Comparator;

import com.iplanalysis.csvclasses.IPLBatting;
import com.iplanalysis.csvclasses.IPLBowling;

public class SortingComparators {

	/* Batting data sorting comparators */
	public final static Comparator<Object> BEST_BATTING_AVG = Comparator
			.comparing(batting -> Double.parseDouble(((IPLBatting) batting).getAverage())).reversed();
	public final static Comparator<IPLBatting> BEST_SR = Comparator.comparing(IPLBatting::getStrikeRate).reversed();
	public final static Comparator<IPLBatting> MOST_SIXES = Comparator.comparing(IPLBatting::getSixes).reversed();
	public final static Comparator<IPLBatting> MOST_FOURS = Comparator.comparing(IPLBatting::getFours).reversed();
	public final static Comparator<Object> MOST_BOUNDARY_RUN_SCORER = Comparator
			.comparing(b -> (((IPLBatting) b).getSixes() * 6 + ((IPLBatting) b).getFours() * 4)).reversed();
	public final static Comparator<Object> MAX_SR_WITH_MOST_6s4s = MOST_BOUNDARY_RUN_SCORER
			.thenComparing(Comparator.comparing(b -> ((IPLBatting) b).getStrikeRate()));
	public final static Comparator<IPLBatting> MAX_RUNS_BEST_SR = Comparator.comparing(IPLBatting::getRuns)
			.thenComparing(Comparator.comparing(IPLBatting::getStrikeRate)).reversed();
	public final static Comparator<Object> BEST_AVG_WITH_BEST_SR = BEST_BATTING_AVG
			.thenComparing(Comparator.comparing(b -> ((IPLBatting) b).getStrikeRate()));

	/* Bowling data sorting comparators */
	public static final Comparator<IPLBowling> BEST_BOWLING_AVG = Comparator
			.comparing(b -> Double.parseDouble(b.getAverage()));
	public static final Comparator<IPLBowling> BEST_BOWLING_SR = Comparator
			.comparing(b -> Double.parseDouble(b.getStrikeRate()));
}
