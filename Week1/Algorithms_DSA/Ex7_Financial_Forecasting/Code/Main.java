package ff;

public class Main {
	public static void main(String[] args) {
		double presentValue = 100000;
		double growthRate = 0.10;
		int years = 5;

		double result = FinancialForecast.futureValue(presentValue, growthRate, years);
		System.out.printf("Future Value (Recursive) after %d years: ₹%.2f\n", years, result);

		double[] memo = new double[years + 1];
		double memoResult = FinancialForecast.futureValueMemo(presentValue, growthRate, years, memo);
		System.out.printf("Future Value (Memoized) after %d years: ₹%.2f\n", years, memoResult);
	}
}
