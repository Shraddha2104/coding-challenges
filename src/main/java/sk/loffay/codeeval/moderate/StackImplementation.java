package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Pavol Loffay
 */
public class StackImplementation {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here

            String[] numStr = line.split(" ");
            Integer[] numbers = new Integer[numStr.length];
            for (int i = 0; i < numStr.length; i++) {
                numbers[i] = Integer.parseInt(numStr[i]);
            }

            System.out.println(result(numbers));
        }
    }

    public static String result(Integer[] numbers){
        Stack<Integer> stack = new Stack<>(50);

        for (Integer num: numbers) {
            stack.push(num);
        }

        StringBuilder result = new StringBuilder();
        Integer num = stack.pop();
        boolean even = true;
        while (num != null) {
            if (result.length() > 0 && even) {
                result.append(" ");
            }
            if (even) {
                result.append(num);
                even = false;
            } else {
                even = true;
            }

            num = stack.pop();
        }

        return result.toString();
    }

    private static class Stack<T> {
        private Object[] arr;
        private int top;

        public Stack(int size) {
            this.arr = new Object[size];
            this.top = -1;
        }

        public void push(T element) {
            if (top == arr.length - 1) {
                arr = Arrays.copyOf(arr, arr.length*2);
            }

            top++;
            arr[top] = element;
        }

        public T pop() {
            if (top < 0) {
                return null;
            }
            T element = (T) arr[top];
            top--;

            return element;
        }
    }
}
