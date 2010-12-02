package yakimenko.calculator;

public class GCD {

	public static int[] gcd(int[] arg1, int[] arg2) {
		if (arg1 == null)
			return arg2;
		if (arg2 == null)
			return arg1;
		int amountUnitArg1 = HelpFunctions.decompositionArg(arg1);
		int amountUnitArg2 = HelpFunctions.decompositionArg(arg2);
		while (amountUnitArg1 != amountUnitArg2) {
			if (amountUnitArg1 > amountUnitArg2) {
				arg1 = Summation.sub(arg1, arg2);
				amountUnitArg1 = HelpFunctions.decompositionArg(arg1);
			} else {
				arg2 = Summation.sub(arg2, arg1);
				amountUnitArg2 = HelpFunctions.decompositionArg(arg2);
			}
		}
		return arg1;
	}

}