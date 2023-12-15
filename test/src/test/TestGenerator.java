// Antonio Fabrizio
// December 4th 2023
// Lab 10: Test papers
// This program implements a class hierarchy used to represent test papers that would be given in school. 

package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class Question {
    int points;
    int difficulty;
    int answerSpace;
    String questionText;

    Question(int points, int difficulty, int answerSpace, String questionText) {
        this.points = points;
        this.difficulty = difficulty;
        this.answerSpace = answerSpace;
        this.questionText = questionText;
    }

    @Override
    public String toString() {
        return "Question: " + questionText;
    }
}

class ObjectiveQuestion extends Question {
    String correctAnswer;

    ObjectiveQuestion(int points, int difficulty, int answerSpace, String questionText, String correctAnswer) {
        super(points, difficulty, answerSpace, questionText);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return super.toString() + "\nObjective Question";
    }

    public String toAnswerString() {
        return toString() + "\nCorrect Answer: " + correctAnswer;
    }
}

class FillInTheBlankQuestion extends Question {
    String correctAnswer;

    FillInTheBlankQuestion(int points, int difficulty, int answerSpace, String questionText, String correctAnswer) {
        super(points, difficulty, answerSpace, questionText);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFill in the Blank";
    }

    public String toAnswerString() {
        return toString() + "\nCorrect Answer: " + correctAnswer;
    }
}

class MultipleChoiceQuestion extends Question {
    List<String> possibleAnswers;
    String correctAnswer;

    MultipleChoiceQuestion(int points, int difficulty, int answerSpace, String questionText,
                           List<String> possibleAnswers, String correctAnswer) {
        super(points, difficulty, answerSpace, questionText);
        this.possibleAnswers = possibleAnswers;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        StringBuilder questionString = new StringBuilder(super.toString() + "\nMultiple Choice\n");
        for (String option : possibleAnswers) {
            questionString.append(option).append("\n");
        }
        return questionString.toString();
    }

    public String toAnswerString() {
        return toString() + "\nCorrect Answer: " + correctAnswer;
    }
}

class Test {
    List<Question> questions;
    int totalPoints;

    Test(List<Question> questions) {
        this.questions = questions;
        calculateTotalPoints();
    }

    void calculateTotalPoints() {
        totalPoints = 0;
        for (Question question : questions) {
            totalPoints += question.points;
        }
    }

    @Override
    public String toString() {
        StringBuilder testString = new StringBuilder("Test\n");
        for (Question question : questions) {
            testString.append(question.toString()).append("\n\n");
        }
        testString.append("Total Points: ").append(totalPoints);
        return testString.toString();
    }

    public String toAnswerString() {
        StringBuilder answerKeyString = new StringBuilder("Answer Key\n");
        for (Question question : questions) {
            if (question instanceof ObjectiveQuestion) {
                answerKeyString.append(((ObjectiveQuestion) question).toAnswerString()).append("\n\n");
            } else if (question instanceof FillInTheBlankQuestion) {
                answerKeyString.append(((FillInTheBlankQuestion) question).toAnswerString()).append("\n\n");
            } else if (question instanceof MultipleChoiceQuestion) {
                answerKeyString.append(((MultipleChoiceQuestion) question).toAnswerString()).append("\n\n");
            }
        }
        answerKeyString.append("Total Points: ").append(totalPoints);
        return answerKeyString.toString();
    }
    
    public void saveToFile(String testFileName, String answerKeyFileName) {
        try (BufferedWriter testWriter = new BufferedWriter(new FileWriter(testFileName));
             BufferedWriter answerKeyWriter = new BufferedWriter(new FileWriter(answerKeyFileName))) {

            // Write test to file
            testWriter.write(toString());

            // Write answer key to file
            answerKeyWriter.write(toAnswerString());

            System.out.println("Test and answer key saved to files: " + testFileName + " and " + answerKeyFileName);

        } catch (IOException e) {
            System.err.println("Error writing to files: " + e.getMessage());
        }
    }
}

public class TestGenerator {
    public static void main(String[] args) {
        // Create questions
        ObjectiveQuestion objectiveQuestion = new ObjectiveQuestion(5, 2, 5, "What is 2 + 3?", "5");
        FillInTheBlankQuestion fillInTheBlankQuestion = new FillInTheBlankQuestion(10, 3, 10,
                "______ was the 16th US President.", "Abraham Lincoln");
        List<String> mcqOptions = List.of("Peter Griffin", "Scooby Doo", "Spongebob Squarepants", "Eric Cartman");
        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion(8, 1, 1,
                "Who lives in a pineapple under the sea?", mcqOptions, "Spongebob Squarepants");

        // Create a test
        List<Question> questions = List.of(objectiveQuestion, fillInTheBlankQuestion, multipleChoiceQuestion);
        Test test = new Test(questions);

        // Generate and print the test and answer key
        System.out.println(test.toString());
        System.out.println("\n" + test.toAnswerString());

        // Save test and answer key to files
        test.saveToFile("test.txt", "answer_key.txt");
    }
}
