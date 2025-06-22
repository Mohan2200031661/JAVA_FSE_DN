package ff;

public class FinancialForecast {

	public static double futureValue(double presentValue, double growthRate, int years) {
		if (years == 0) {
			return presentValue;
		}
		return (1 + growthRate) * futureValue(presentValue, growthRate, years - 1);
	}

	public static double futureValueMemo(double presentValue, double growthRate, int years, double[] memo) {
		if (years == 0)
			return presentValue;
		if (memo[years] != 0)
			return memo[years];
		memo[years] = (1 + growthRate) * futureValueMemo(presentValue, growthRate, years - 1, memo);
		return memo[years];
	}
}
