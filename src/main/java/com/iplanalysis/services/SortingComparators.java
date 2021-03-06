package com.iplanalysis.services;

import java.util.Comparator;

import com.iplanalysis.pojoclass.IPLAllRounder;
import com.iplanalysis.pojoclass.IPLBatsman;
import com.iplanalysis.pojoclass.IPLBowler;

public class SortingComparators {

	/* Batting data sorting comparators */
	public final static Comparator<Object> BEST_BATTING_AVG = Comparator
			.comparing(batting -> Double.parseDouble(((IPLBatsman) batting).getAverage())).reversed();
	public final static Comparator<IPLBatsman> BEST_SR = Comparator.comparing(IPLBatsman::getStrikeRate).reversed();
	public final static Comparator<IPLBatsman> MOST_SIXES = Comparator.comparing(IPLBatsman::getSixes).reversed();
	public final static Comparator<IPLBatsman> MOST_FOURS = Comparator.comparing(IPLBatsman::getFours).reversed();
	public final static Comparator<Object> MOST_BOUNDARY_RUN_SCORER = Comparator
			.comparing(b -> (((IPLBatsman) b).getSixes() * 6 + ((IPLBatsman) b).getFours() * 4)).reversed();
	public final static Comparator<Object> MAX_SR_WITH_MOST_6s4s = MOST_BOUNDARY_RUN_SCORER
			.thenComparing(Comparator.comparing(b -> ((IPLBatsman) b).getStrikeRate()));
	public final static Comparator<IPLBatsman> MAX_RUNS_BEST_SR = Comparator.comparing(IPLBatsman::getRuns)
			.thenComparing(Comparator.comparing(IPLBatsman::getStrikeRate)).reversed();
	public final static Comparator<Object> BEST_AVG_WITH_BEST_SR = BEST_BATTING_AVG
			.thenComparing(Comparator.comparing(b -> ((IPLBatsman) b).getStrikeRate()));
	public static final Comparator<IPLBatsman> MOST_HUNDREDS_WITH_BEST_AVG = Comparator
			.comparing(IPLBatsman::getCentury).reversed().thenComparing(BEST_BATTING_AVG);
	public static final Comparator<Object> BEST_AVG_WITH_ZERO_100s_50s = Comparator.comparing(b -> {
		if (((IPLBatsman) b).getCentury() + ((IPLBatsman) b).getHalfCentury() == 0)
			return Double.parseDouble(((IPLBatsman) b).getAverage());
		else
			return 0.0;
	}).reversed();

	/* Bowling data sorting comparators */
	public static final Comparator<IPLBowler> BEST_BOWLING_AVG = Comparator
			.comparing(b -> Double.parseDouble(b.getAverage()));
	public static final Comparator<IPLBowler> BEST_BOWLING_SR = Comparator
			.comparing(b -> Double.parseDouble(b.getStrikeRate()));
	public static final Comparator<IPLBowler> BEST_ECONOMY_BOWLER = Comparator.comparing(IPLBowler::getEconomy);
	public static final Comparator<IPLBowler> BEST_SR_WITH_5W4W = Comparator.comparing(IPLBowler::getFourAndFiveWickets)
			.reversed().thenComparing(BEST_BOWLING_SR);
	public static final Comparator<IPLBowler> BEST_BOWLING_AVG_WITH_BEST_SR = BEST_BOWLING_SR
			.thenComparing(BEST_BOWLING_AVG);
	public static final Comparator<IPLBowler> MAX_WKTS_WITH_BEST_BOWLING_AVG = Comparator
			.comparing(IPLBowler::getWickets).reversed().thenComparing(BEST_BOWLING_AVG);

	/* All-rounder data sorting comparators */
	public static final Comparator<IPLAllRounder> BEST_BATTING_AND_BOWLING_AVG = Comparator
			.comparing(IPLAllRounder::getPerformanceByAverage).reversed();
	public static final Comparator<IPLAllRounder> BEST_ALLROUNDER = Comparator
			.comparing(IPLAllRounder::getPerformanceByRunsAndWickets).reversed();
}
