package data_structures.basic_data_structures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        //int faultPosition = 0;
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if(text.length()==1){
                        // faultPosition = position + 1;
                opening_brackets_stack.add(new Bracket(next,position));
                break;
            }

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                opening_brackets_stack.add(new Bracket(next,position));
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if(opening_brackets_stack.isEmpty()){
                        // faultPosition = position + 1;
                    opening_brackets_stack.add(new Bracket(next,position));
                    break;
                } else {
                    Bracket bracket = opening_brackets_stack.peek();
                    if(bracket.Match(next))
                        opening_brackets_stack.pop();
                    else {
                        // faultPosition = position + 1;
                        //opening_brackets_stack.add(new Bracket(next,position));
                        //break;
                        System.out.printf("%d",position + 1);
                        return;
                    }
                }
            }
        }
        // Printing answer, write your code here
        /*if(faultPosition == 0)
            System.out.printf("%s","Success");
        else
            System.out.printf("%d",faultPosition);*/

        if(opening_brackets_stack.size() == 0)
            System.out.printf("%s","Success");
        else {
            Bracket temp = null;
            while(!opening_brackets_stack.isEmpty()){
                temp = opening_brackets_stack.pop();
            }
            System.out.printf("%d",temp.position + 1);
        }

    }
}
