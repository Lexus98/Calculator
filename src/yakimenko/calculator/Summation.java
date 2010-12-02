package yakimenko.calculator;

public class Summation {

	static int range = Calculator.range;
	static int NUM = 9;

	static int[] add(int[] Arg1, int[] Arg2) {

		int amountUnitArg1 = HelpFunctions.decompositionArg(Arg1);
		int amountUnitArg2 = HelpFunctions.decompositionArg(Arg2);

		int max = (int) Math.pow(NUM, range);
		if ((amountUnitArg1 + amountUnitArg2) >= max) 
			System.out.println("Warning! Out of range!");
		amountUnitArg1 = (amountUnitArg1 + amountUnitArg2) % max;
		return HelpFunctions.restoreArg(amountUnitArg1);
	}

	static int[] sub(int[] Arg1, int[] Arg2) {

		int amountUnitArg1 = HelpFunctions.decompositionArg(Arg1);
		int amountUnitArg2 = HelpFunctions.decompositionArg(Arg2);

		int max = (int) Math.pow(NUM, range);

		if (amountUnitArg1 > amountUnitArg2) {
			amountUnitArg1 -= amountUnitArg2;
			return HelpFunctions.restoreArg(amountUnitArg1);
		} else {
			amountUnitArg2 -= amountUnitArg1;
			amountUnitArg2 = max - amountUnitArg2;
			return HelpFunctions.restoreArg(amountUnitArg2);
		}
	}
}
