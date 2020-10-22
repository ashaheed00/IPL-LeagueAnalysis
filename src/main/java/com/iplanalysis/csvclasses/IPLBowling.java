package com.iplanalysis.csvclasses;

import com.opencsv.bean.CsvBindByName;

public class IPLBowling {
	@CsvBindByName(column = "POS")
	private int position;
	@CsvBindByName(column = "PLAYER")
	private String player;
	@CsvBindByName(column = "MAT")
	private int match;
	@CsvBindByName(column = "Inns")
	private int innings;
	@CsvBindByName(column = "Ov")
	private double overs;
	@CsvBindByName(column = "Runs")
	private int runs;
	@CsvBindByName(column = "Wkts")
	private int wickets;
	@CsvBindByName(column = "BBI")
	private int bbi;
	@CsvBindByName(column = "Avg")
	private String average;
	@CsvBindByName(column = "Econ")
	private double economy;
	@CsvBindByName(column = "SR")
	private String strikeRate;
	@CsvBindByName(column = "4w")
	private int fourWickets;
	@CsvBindByName(column = "5w")
	private int fiveWickets;

	public int getPosition() {
		return position;
	}

	public String getPlayer() {
		return player;
	}

	public int getMatch() {
		return match;
	}

	public int getInnings() {
		return innings;
	}

	public double getOvers() {
		return overs;
	}

	public int getRuns() {
		return runs;
	}

	public int getWickets() {
		return wickets;
	}

	public int getBbi() {
		return bbi;
	}

	public String getAverage() {
		try {
			Double.parseDouble(average);
		} catch (NumberFormatException e) {
			return "1000000";
		}
		return average;
	}

	public double getEconomy() {
		return economy;
	}

	public String getStrikeRate() {
		try {
			Double.parseDouble(strikeRate);
		} catch (NumberFormatException e) {
			return "100000";
		}
		return strikeRate;
	}

	public int getFourWickets() {
		return fourWickets;
	}

	public int getFiveWickets() {
		return fiveWickets;
	}

	@Override
	public String toString() {
		return "IPLBowling [position=" + position + ", player=" + player + ", match=" + match + ", innings=" + innings
				+ ", overs=" + overs + ", runs=" + runs + ", wickets=" + wickets + ", bbi=" + bbi + ", average="
				+ average + ", economy=" + economy + ", strikeRate=" + strikeRate + ", fourWickets=" + fourWickets
				+ ", fiveWickets=" + fiveWickets + "]";
	}

}
