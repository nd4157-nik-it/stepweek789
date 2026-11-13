import java.util.*;
import java.util.regex.*;

abstract class Question {
    String questionText;
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String questionText, String correctAnswer,
             String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double evaluate();
}

class MCQ extends Question {
    MCQ(String q, String c, String s, double p) {
        super(q, c, s, p);
    }

    double evaluate() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class TF extends Question {
    TF(String q, String c, String s, double p) {
        super(q, c, s, p);
    }

    double evaluate() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String q, String c, String s, double p) {
        super(q, c, s, p);
    }

    double evaluate() {
        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int count = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

class Sol4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        double total = 0;

        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            Matcher matcher = pattern.matcher(line);
            ArrayList<String> tokens = new ArrayList<>();

            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    tokens.add(matcher.group(1));
                } else {
                    tokens.add(matcher.group(2));
                }
            }

            String type = tokens.get(0);
            String questionText = tokens.get(1);
            String correctAnswer = tokens.get(2);
            String studentAnswer = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));

            Question question;

            switch (type) {
                case "MCQ":
                    question = new MCQ(
                            questionText, correctAnswer, studentAnswer, points
                    );
                    break;

                case "TF":
                    question = new TF(
                            questionText, correctAnswer, studentAnswer, points
                    );
                    break;

                default:
                    question = new Essay(
                            questionText, correctAnswer, studentAnswer, points
                    );
            }

            double score = question.evaluate();
            total += score;

            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}