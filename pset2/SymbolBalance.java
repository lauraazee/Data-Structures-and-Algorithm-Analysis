/* Laura Zhang
 * lbz2106
 * Checks for balanced symbols
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolBalance {

	public static void main(String[] args) throws FileNotFoundException {
		String path = args[0];
		File javaFile = new File(path);
		Scanner fileText = new Scanner(javaFile);
		MyStack symbolStack = new MyStack<Character>(); //stack to store symbols
		char[] openSymbols = {'{', '(', '['}; //array of symbols to be checked
		
		boolean openCommentSlash = false;
		boolean comment = false;
		boolean closedCommentsAsterisk = false;

		while (fileText.hasNext()) {//loops through every word in the file
			String nextWord = fileText.next();

			//loops through every character in each word
			for(char nextToken : nextWord.toCharArray()) {

				//checks if there is a beginning of a comment
				if (openCommentSlash) {
					if (nextToken == '*') {
						comment = true;
					}
					else {openCommentSlash = false;}
				}

				//checks if there is an end of a comment
				else if (closedCommentsAsterisk) {
					if (nextToken == '/') {
						comment = false;
					}
					else {closedCommentsAsterisk = false;}
				} 

				else if (nextToken == '/') {
					openCommentSlash = true;
				}
				else if (nextToken == '*') {
					closedCommentsAsterisk = true;
				}
				
				//checks if there is the end of a string
				else if (symbolStack.isEmpty() == false) {
					if (symbolStack.top() == (Character) '"') {
						if (nextToken == '"') {
							symbolStack.pop();
						}
					}
				}

				else {

					//adds all open bracket symbols to stack	
					for (int i = 0; i < openSymbols.length; i++) {
						if (nextToken == openSymbols[i]) {
							symbolStack.push((Character) nextToken);
						}
					}


					//pops open bracket symbols off stack if matching symbol is found
					if (nextToken == '}') {
						if (symbolStack.top() == (Character) '{') {
							symbolStack.pop();
						}
						else {
							System.out.println("Unbalanced! Symbol } is mismatched");
						}
					}
					if (nextToken == ')') {
						if (symbolStack.top() == (Character) '(') {
							symbolStack.pop();
						}
						else {
							System.out.println("Unbalanced! Symbol ) is mismatched");
						}
					}
					if (nextToken == ']') {
						if (symbolStack.top() == (Character) '[') {
							symbolStack.pop();
						}
						else {
							System.out.println("Unbalanced! Symbol ] is mismatched");
						}
					}

					if (nextToken == '"') {
						symbolStack.push((Character) nextToken);

					}

				}

			}
		}

		fileText.close();
		
		if (symbolStack.isEmpty()) {
			System.out.println("Successful Balancing!");
		}
		else {
			System.out.println("Extra symbol. There is one extra " + symbolStack.top());
		}
		
	}
}