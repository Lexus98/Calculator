package yakimenko.calculator;

import java.util.Scanner;

public class Calculator {

	public static int range;
	static int[] arg1;
	static int[] arg2;
	static int[] result;
	
	public static void nullVector (int[] Vector) {
		for (int i = 0; i < Vector.length; i++)
			Vector[i] = 0;
	}

	public static void main(String[] args) {

		char symb = 0;
		int operationValue = 0, pos = 0, 
			operationIsEntered = 0, numAB=0,cnt=0;

		Scanner in = new Scanner(System.in);
		System.out.println("Input range, please:");
		range = in.nextInt();
		
		arg1 = new int [range];
		arg2 = new int [range];
		
		Calculator.nullVector(arg1);
		Calculator.nullVector(arg2);
		
		System.out.println("Press \"Q\" to exit\nInput command:");
		String command = in.next();
		while ((symb = command.charAt(pos++)) != 'Q') {
			if ((symb == '+')||(symb == '-')||(symb == '/')||(symb == '*')||(symb == 'g'))
				if(operationIsEntered == 0){
					operationIsEntered = 1;
					operationValue = symb;
					numAB = 1;
					cnt = 0;
					continue;
				}
			if ((symb >= '0')&&(symb <= '8'))
				if(cnt < range){
					if (numAB == 0)
						if (cnt > 0) {
							for (int i = 0; i < range - 1; i++)
								arg1[i] = arg1[i+1];
							arg1[range - 1] = Character.getNumericValue(symb);
						} else
							arg1[range - 1] = Character.getNumericValue(symb);
					else 
						if (cnt > 0) {
							for (int i = 0; i < range - 1; i++)
								arg2[i] = arg2[i+1];
							arg2[range - 1] = Character.getNumericValue(symb);
						} else
							arg2[range - 1] = Character.getNumericValue(symb);
					cnt++;
					continue;
				}
			if (symb == '=')
				switch(operationValue){
					case 0:
						System.out.println("\nBad command!\n");
						break;
					case '+':
						result = Summation.add(arg1, arg2);
						break;
					case '-':
						result = Summation.sub(arg1, arg2);
						break;
					case '*':
						result = Multiplication.mult(arg1, arg2);
						break;
					case '/':
						result = Multiplication.div(arg1, arg2);
						break;
					case 'g':
						result = GCD.gcd(arg1, arg2);
						break;
				}
			if (result != null)	{
				System.out.print("   ");
				for (int i = 0; i < result.length; i++)
					System.out.print(result[i]);
			}
			operationValue=0;
			numAB=0;
			cnt=0;
			operationIsEntered=0;
			Calculator.nullVector(arg1);
			Calculator.nullVector(arg2);
			System.out.println("\nInput command: ");
			command = in.next();
			pos=0;
		}
		System.out.print("Exit. Bye!");
	}
}
