import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static final int QUIZ_DURATION_SECONDS = 20; 
    private static int score = 0;
    private static Timer timer;
    private static boolean quizRunning = false;

    public static void main(String[] args) {
        startQuiz();
    }

    private static void startQuiz() {
        quizRunning = true;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            private int timeRemaining = QUIZ_DURATION_SECONDS;

            @Override
            public void run() {
                if (timeRemaining > 0) {
                    System.out.println("Time remaining: " + timeRemaining + " seconds");
                    timeRemaining--;
                } else {
                    endQuiz();
                }
            }
        }, 0, 1000);

        System.out.println("Welcome to the Quiz!");
        System.out.println("Answer the following questions:");

       
        
        askQuestion("Who invented Java Programming?", "A) Guido van Rossum", "B) James Gosling", "C) Dennis Ritchie", "D) Bjarne Stroustrup", "B");
 askQuestion("Which statement is true about Java??", "A)  Java is a sequence-dependent programming language", "B) Java is a code dependent programming language", "C) Java is a platform-dependent programming language", "D)  Java is a platform-independent programming language", "D");
  askQuestion("Which component is used to compile, debug and execute the java programs?", "A) JRE ", "B) JIT", "C) JDK", "D)  JVM", "C");
        

        // Wait for the timer to finish
        try {
            Thread.sleep(QUIZ_DURATION_SECONDS * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        endQuiz();
    }

    private static void askQuestion(String question, String optionA, String optionB, String optionC, String optionD, String correctAnswer) {
        System.out.println(question);
        System.out.println(optionA);
        System.out.println(optionB);
        System.out.println(optionC);
        System.out.println(optionD);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine().toUpperCase();

        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Correct!\n");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is " + correctAnswer + "\n");
        }
    }

    private static void endQuiz() {
        quizRunning = false;
        timer.cancel();
        System.out.println("Quiz ended! Your score is: " + score + " out of the total questions.");
        
        System.exit(0);
    }
}
