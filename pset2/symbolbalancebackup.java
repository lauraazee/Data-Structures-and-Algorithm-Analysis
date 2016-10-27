import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolBalance {


	public static void main(String[] args) throws FileNotFoundException {
		String path = args[0];
		File javaFile = new File(path);
		Scanner fileText = new Scanner(javaFile);
		MyStack symbolStack = new MyStack<Character>();
		char[] openSymbols = {'{', '(', '['};
		
		boolean openCommentSlash = false;
		boolean comment = false;
		boolean closedCommentsAsterisk = false;

		while (fileText.hasNext()) {
			String nextWord = fileText.next();
			for(char nextToken : nextWord.toCharArray()) {

				if (openCommentSlash) {
					if (nextToken == '*') {
						comment = true;
					}
					else {openCommentSlash = false;}
				}

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
				

				else if (symbolStack.isEmpty() == false) {
					if (symbolStack.top() == (Character) '"') {
						if (nextToken == '"') {
							symbolStack.pop();
						}
					}
				}

				else if (comment == false) {

					for (int i = 0; i < openSymbols.length; i++) {
						if (nextToken == openSymbols[i]) {
							symbolStack.push((Character) nextToken);
						}
					}

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