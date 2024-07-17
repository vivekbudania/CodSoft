import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApplication {
    private static List<Question> questions = new ArrayList<>();
    private static int score = 0;

    public static void main(String[] args) {
        // Initialize questions
        questions.add(new Question("What is the capital of France?", Arrays.asList("Paris", "London", "Berlin", "Madrid"), "Paris"));
        questions.add(new Question("Which planet is known as the Red Planet?", Arrays.asList("Earth", "Mars", "Jupiter", "Saturn"), "Mars"));

        // Start the quiz
        runQuiz();
    }

    private static void runQuiz() {
        Scanner scanner = new Scanner(System.in);
        List<String> correctAnswers = new ArrayList<>();
        List<String> userAnswers = new ArrayList<>();

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            // Start the timer for the question
            QuestionTimer timer = new QuestionTimer(10);  // 10 seconds for each question

            // Get user input
            int userAnswer = -1;
            while (!timer.isTimeUp()) {
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt();
                    break;
                }
            }

            timer.cancel();

            // Check the answer
            if (!timer.isTimeUp() && userAnswer > 0 && userAnswer <= options.size()) {
                String selectedOption = options.get(userAnswer - 1);
                userAnswers.add(selectedOption);
                if (selectedOption.equals(question.getCorrectAnswer())) {
                    score++;
                }
                correctAnswers.add(question.getCorrectAnswer());
            } else {
                System.out.println("Time is up or invalid input!");
                userAnswers.add("No Answer");
                correctAnswers.add(question.getCorrectAnswer());
            }
        }

        // Display the final score
        System.out.println("Your final score is: " + score + "/" + questions.size());

        // Display summary of correct/incorrect answers
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question " + (i + 1) + ": " + questions.get(i).getQuestionText());
            System.out.println("Your answer: " + userAnswers.get(i));
            System.out.println("Correct answer: " + correctAnswers.get(i));
        }

        scanner.close();
    }
}
