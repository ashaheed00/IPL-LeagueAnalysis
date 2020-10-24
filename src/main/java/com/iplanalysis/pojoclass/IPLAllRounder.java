package com.iplanalysis.pojoclass;

public class IPLAllRounder {

	private String player;
	private String battingAverage;
	private String bowlingAverage;
	private int runs;
	private int wickets;

	public IPLAllRounder(String player, int runs, int wickets, String battingAverage, String bowlingAverage) {
		this.player = player;
		this.runs = runs;
		this.wickets = wickets;
		this.battingAverage = battingAverage;
		this.bowlingAverage = bowlingAverage;
	}

	public String getPlayer() {
		return player;
	}

	public double getBattingAverage() {
		return Double.parseDouble(battingAverage);
	}

	public double getBowlingAverage() {
		return Double.parseDouble(bowlingAverage);
	}

	public int getRuns() {
		return runs;
	}

	public int getWickets() {
		return wickets;
	}

	public double getPerformanceByAverage() {
		return getBattingAverage() - getBowlingAverage();
	}

	public double getPerformanceByRunsAndWickets() {
		return (this.runs * this.wickets);
	}

	@Override
	public String toString() {
		return "IPLAllRounder [player=" + player + ", battingAverage=" + battingAverage + ", bowlingAverage="
				+ bowlingAverage + ", runs=" + runs + ", wickets=" + wickets + "]";
	}

}
