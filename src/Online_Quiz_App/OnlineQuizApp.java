package Online_Quiz_App;

import java.util.*;

class Question {
    String questionText;
    List<String> options;
    int correctOption; // index starting from 1

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class OnlineQuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Create initial questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Identify the modifier which cannot be used for constructor.?",
                Arrays.asList("Private", "Protected", "Public", "static"), 4));

        questions.add(new Question("What is the implicit return type of constructor?",
                Arrays.asList("No return type", "A class object in which it is defined", "void", "none"), 2));

        questions.add(new Question(
                "Exception created by try block is caught in which block",
                Arrays.asList("catch", "throw", "final", "none"), 1));

        // Step 2: Option to add new questions
        System.out.print("Do you want to add your own questions? (yes/no): ");
        String choice = sc.nextLine().trim().toLowerCase();

        while (choice.equals("yes")) {
            System.out.print("Enter your question: ");
            String questionText = sc.nextLine();

            List<String> options = new ArrayList<>();
            for (int i = 1; i <= 4; i++) {
                System.out.print("Enter option " + i + ": ");
                options.add(sc.nextLine());
            }

            System.out.print("Enter correct option number (1-4): ");
            int correctOption = sc.nextInt();
            sc.nextLine(); // consume newline

            questions.add(new Question(questionText, options, correctOption));

            System.out.print("Do you want to add another question? (yes/no): ");
            choice = sc.nextLine().trim().toLowerCase();
        }

        // Step 3: Start quiz
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.questionText);

            for (int j = 0; j < q.options.size(); j++) {
                System.out.println((j + 1) + ". " + q.options.get(j));
            }

            System.out.print("Your answer: ");
            int answer = sc.nextInt();

            if (answer == q.correctOption) {
                System.out.println(" Correct!");
                score++;
            } else {
                System.out.println(" Wrong! Correct answer: " + q.options.get(q.correctOption - 1));
            }
        }

        // Step 4: Show result
        System.out.println("\n Your Score: " + score + "/" + questions.size());
        sc.close();
    }
}

