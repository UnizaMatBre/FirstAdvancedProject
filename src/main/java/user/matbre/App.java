package user.matbre;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public interface CollectorMethod {
        int apply(int input);
    }

    public interface SelectorMethod {
        boolean check(int input);
    }

    public interface InjectorMethod {
        int combine(int original, int next);
    }

    public static int[] collect(int[] inputArray, CollectorMethod collector) {
        int[] resultArray = new int[inputArray.length];

        for(int index = 0; index < inputArray.length; index++) {
            resultArray[index] = collector.apply(inputArray[index]);
        }

        return resultArray;
    }


    public static int[] select(int[] inputArray, SelectorMethod selector) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();

		for (int element : inputArray) {
			if (selector.check(element)) {
				resultList.add(element);
			}
		}

        int[] resultArray = new int[resultList.size()];

        for(int index = 0; index < resultArray.length; index++) {
            resultArray[index] = resultList.get(index);
        }

        return resultArray;
    }

    public static int inject(int[] inputArray, InjectorMethod injector) {
        if(inputArray.length == 1) {
            return inputArray[0];
        }


        int result = inputArray[0];

        for(int index = 1; index < inputArray.length; index++) {
            result = injector.combine(result, inputArray[index]);
        }

        return result;

    };


    public static void main( String[] args ) {
        int[] x = new int[]{2,2,2,4};

        int result = inject(x, (int o, int n) -> o + n);


        System.out.println( "Hello World!" );
    }
}
