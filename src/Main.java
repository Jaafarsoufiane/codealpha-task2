import java.util.Scanner;

class OnlineQuiz {

    // Question class to store question text and correct answer
    static class Question {
        String questionText;
        String[] options;
        String correctAnswer;

        public Question(String questionText, String[] options, String correctAnswer) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        // Method to display the question and options
        public void displayQuestion() {
            System.out.println(questionText);
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
        }

        // Method to check if the provided answer is correct
        public boolean checkAnswer(String userAnswer) {
            return userAnswer.equalsIgnoreCase(correctAnswer);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array of questions
        Question[] questions = {
                new Question("What is the capital of France?", new String[] {"Berlin", "Madrid", "Paris", "Rome"}, "Paris"),
                new Question("Which language is primarily used for Android development?", new String[] {"Java", "Python", "C#", "Ruby"}, "Java"),
                new Question("Who wrote 'Romeo and Juliet'?", new String[] {"Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen"}, "William Shakespeare"),
                new Question("What is the largest planet in our Solar System?", new String[] {"Earth", "Mars", "Jupiter", "Saturn"}, "Jupiter"),
                new Question("What is the speed of light?", new String[] {"300,000 km/s", "150,000 km/s", "1,000,000 km/s", "100,000 km/s"}, "300,000 km/s")
        };

        int score = 0;

        // Loop through each question
        for (Question q : questions) {
            q.displayQuestion();
            System.out.print("Enter your answer: ");
            String userAnswer = scanner.nextLine().trim();

            // Check if the answer is correct and update score
            if (q.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer was: " + q.correctAnswer);
            }
            System.out.println();
        }

        // Display the final score
        System.out.println("Your final score is: " + score + "/" + questions.length);
        System.out.println("Thank you for participating in the quiz!");

        scanner.close();
    }
}