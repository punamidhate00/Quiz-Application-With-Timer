import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    static Scanner scanner = new Scanner(System.in);
    static int score = 0;
    static boolean answered = false;
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz!");
        System.out.println("You have 10 seconds to answer each question.");
        System.out.println("Let's go, All the Best !\n");
        
        
        askQuestion("What is the capital of France?",
                    "1. Berlin", "2. Paris", "3. Madrid", "4. Rome", 2);
        
        askQuestion("What is 5 + 3?",
                    "1. 5", "2. 8", "3. 7", "4. 6", 2);
        
        askQuestion("What is the largest planet in our solar system?",
                    "1. Earth", "2. Venus", "3. Jupiter", "4. Mars", 3);
        
        System.out.println("\nQuiz Over!");
        System.out.println("Your score: " + score);
    }
 
    public static void askQuestion(String question, String option1, String option2, String option3, String option4, int correctAnswer) {
        System.out.println(question);
        System.out.println(option1);
        System.out.println(option2);
        System.out.println(option3);
        System.out.println(option4);
        System.out.print("Enter your answer (1-4): ");
        
        // Timer setup for each question
        answered = false;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!answered) {
                    System.out.println("\nTime's up! Moving to the next question.");
                }
            }
        }, 10000);  // 10 seconds for each question
        
        // Get user input
        long startTime = System.currentTimeMillis();
        int answer = scanner.nextInt();
        long endTime = System.currentTimeMillis();
  
        // Cancel timer if answered in time
        if (endTime - startTime < 10000) {
            answered = true;
            timer.cancel();
            
            // Check if the answer is correct
            if (answer == correctAnswer) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was " + correctAnswer + ".\n");
            }
}
}
}