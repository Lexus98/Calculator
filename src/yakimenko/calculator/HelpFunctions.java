package yakimenko.calculator;

public class HelpFunctions {

	static int range = Calculator.range;
	private static int[][] arithmetic = { { 0, 1, 2, 3, 4, 5, 6, 7, 8 },
						{ 1, 3, 4, 5, 0, 7, 2, 8, 6 } };
	static int NUM = 9;

	private static int decompositionOneNum(int number) {
		if (number == 0)
			return 0;
		int cnt = 1, i = 0;
		int buf = number;
		while (buf != 1) {
			for (i = 0; i < NUM; i++) {
				if (arithmetic[1][i] == buf) {
					buf = arithmetic[0][i];
					cnt++;
					i = NUM;
				}
			}
		}
		return cnt;
	}

	public static int decompositionArg(int[] Arg) {
		int amount, res = 0;
		for (int i = 0; i < range - 1; i++) {
			amount = decompositionOneNum(Arg[i]);
			res += amount;
			res *= NUM;
		}
		amount = decompositionOneNum(Arg[range - 1]);
		return res += amount;
	}
	
	public static int[] restoreArg(int amountUnit) {
		int[] result = new int[range];
		int tmpRes;
		Calculator.nullVector(result);
		int units, tmp = amountUnit, i, j;
		j = range - 1;
		while (tmp != 0) {
			units = tmp % NUM;
			tmp /= NUM;
			tmpRes = 0;
			for (i = 0; i < units; i++) {
				tmpRes = arithmetic[1][tmpRes];
			}
			if (j >= 0)
				result[j--] = tmpRes;
		}
		return result;
	}

	public static int NonZeroAmount(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0)
				count++;
		}
		return count;
	}
}
