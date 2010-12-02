package yakimenko.calculator;

public class Multiplication {

	static int range = Calculator.range;
	static int NUM = Summation.NUM;

	static int[] mult(int[] Arg1, int[] Arg2) {
		if ((HelpFunctions.NonZeroAmount(Arg1) == 0)
				|| (HelpFunctions.NonZeroAmount(Arg2) == 0))
			return null;

		int amountUnitArg1 = HelpFunctions.decompositionArg(Arg1);
		int amountUnitArg2 = HelpFunctions.decompositionArg(Arg2);
		int max = (int) Math.pow(NUM, range);
		if ((amountUnitArg1 * amountUnitArg2) >= max) 
			System.out.println("Warning! Out of range!");
		amountUnitArg1 = (amountUnitArg1 * amountUnitArg2) % max;
		return HelpFunctions.restoreArg(amountUnitArg1);

	}

	public static int[] div(int[] Arg1, int[] Arg2) {
		if ((HelpFunctions.NonZeroAmount(Arg1) == 0)
				|| (HelpFunctions.NonZeroAmount(Arg2) == 0))
			return null;
		int amountUnitArg1 = 0, amountUnitArg2 = 0;
		amountUnitArg1 = HelpFunctions.decompositionArg(Arg1);
		amountUnitArg2 = HelpFunctions.decompositionArg(Arg2);
		if (amountUnitArg2 == 0) {
			System.out.println("Division by zero\n");
			return null;
		}
		amountUnitArg1 = amountUnitArg1 / amountUnitArg2;
		return HelpFunctions.restoreArg(amountUnitArg1);
	}
}
