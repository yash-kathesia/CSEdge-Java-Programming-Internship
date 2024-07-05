import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuizApplication extends JFrame implements ActionListener {
    private Container container;
    private JLabel questionLabel, nameLabel;
    private JRadioButton[] options;
    private ButtonGroup bg;
    private JButton nextButton, submitButton, startButton, exitButton;
    private JTextField nameField;
    private String userName;
    private int currentQuestion = 0, score = 0;

    private String[] questions = {
            "Question 1: Which is used to find and fix bugs in the Java programs.?",
            "Question 2: What is the return type of the hashCode() method in the Object class?",
            "Question 3: In java, JAR stands for?",
            "Question 4: Which keyword is used for accessing the features of a package?",
            "Question 5: Which package contains the Random class?"
    };

    private String[][] optionsData = {
            { "JVM", "JDB", "JDK", "JRE" },
            { "int", "Object", "long", "void" },
            { "Java Archive Runner", "Java Archive", "Java Application Resource", "Java Application Runner" },
            { "import", "extends", "export", "package" },
            { "java.util package", "java.io package", "java.lang package", "java.awt package" }
    };

    private String[] correctAnswers = { "JDB", "int", "Java Archive", "import", "java.util package" };

    private List<UserScore> userScores = new ArrayList<>();

    public QuizApplication() {
        setTitle("Online Quiz Application");
        setBounds(30, 90, 1500, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        container = getContentPane();
        container.setLayout(null);

        nameLabel = new JLabel("Enter your name : ");
        nameLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        nameLabel.setForeground(new Color(30, 144, 254));
        nameLabel.setBounds(500, 100, 200, 30);
        container.add(nameLabel);

        nameField = new JTextField();
        nameField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        nameField.setBounds(700, 100, 200, 30);
        container.add(nameField);

        questionLabel = new JLabel();
        questionLabel.setBounds(550, 400, 700, 30);
        questionLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        container.add(questionLabel);

        options = new JRadioButton[4];
        bg = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setBounds(550, 450 + (i * 30), 400, 50);
            questionLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
            container.add(options[i]);
            bg.add(options[i]);
        }

        startButton = new JButton("Start Quiz");
        startButton.setBounds(550, 250, 100, 30);
        startButton.setBackground(new Color(30, 144, 254));
        startButton.setForeground(Color.WHITE);
        startButton.addActionListener(this);
        container.add(startButton);

        nextButton = new JButton("Next");
        nextButton.setBounds(650, 250, 100, 30);
        nextButton.setBackground(new Color(30, 144, 254));
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(this);
        container.add(nextButton);
        nextButton.setEnabled(true);

        submitButton = new JButton("Submit");
        submitButton.setBounds(750, 250, 100, 30);
        submitButton.setBackground(new Color(30, 144, 254));
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        container.add(submitButton);
        submitButton.setEnabled(true);

        exitButton = new JButton("Exit");
        exitButton.setBounds(850, 250, 100, 30);
        exitButton.setBackground(new Color(30, 144, 254));
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(this);
        container.add(exitButton);

        displayStartScreen();
    }

    private void displayStartScreen() {
        questionLabel.setVisible(false);
        for (int i = 0; i < 4; i++) {
            options[i].setVisible(false);
        }
        nextButton.setVisible(false);
        submitButton.setVisible(false);
        nameLabel.setVisible(true);
        nameField.setVisible(true);
        startButton.setVisible(true);
    }

    private void displayQuestion() {
        if (currentQuestion < questions.length) {
            questionLabel.setText(questions[currentQuestion]);
            for (int i = 0; i < 4; i++) {
                options[i].setText(optionsData[currentQuestion][i]);
            }
            bg.clearSelection();
        } else {
            calculateGradeAndShowRanking();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            userName = nameField.getText();
            if (userName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter your name!");
            } else {
                startQuiz();
            }
        } else if (e.getSource() == nextButton) {
            checkAnswer();
            currentQuestion++;
            displayQuestion();
        } else if (e.getSource() == submitButton) {
            checkAnswer();
            calculateGradeAndShowRanking();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    private void startQuiz() {
        questionLabel.setVisible(true);
        for (int i = 0; i < 4; i++) {
            options[i].setVisible(true);
        }
        nextButton.setVisible(true);
        submitButton.setVisible(true);
        nameLabel.setVisible(true);
        nameField.setVisible(true);
        startButton.setVisible(false);
        displayQuestion();
    }

    private void checkAnswer() {
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) {
                if (options[i].getText().equals(correctAnswers[currentQuestion])) {
                    score++;
                }
                break;
            }
        }
    }

    private void calculateGradeAndShowRanking() {
        String grade = calculateGrade(score);
        userScores.add(new UserScore(userName, score, grade));

        userScores.sort(Comparator.comparingInt(UserScore::getScore).reversed());

        StringBuilder rankingBoard = new StringBuilder("Ranking Board:\n\n");
        for (UserScore us : userScores) {
            rankingBoard.append(us.getName()).append(" - Score: ").append(us.getScore()).append(", Grade: ")
                    .append(us.getGrade()).append("\n");
        }

        JOptionPane.showMessageDialog(this,
                "Quiz Over! Your score is " + score + "\nGrade: " + grade + "\n\n" + rankingBoard);
        resetQuiz();
    }

    private String calculateGrade(int score) {
        if (score == 5) {
            return "AA";
        } else if (score == 4) {
            return "BB";
        } else if (score == 3) {
            return "CC";
        } else if (score == 2) {
            return "DD";
        } else {
            return "FF";
        }
    }

    private void resetQuiz() {
        currentQuestion = 0;
        score = 0;
        nameField.setText("");
        displayStartScreen();
    }

    public static void main(String[] args) {
        QuizApplication quiz = new QuizApplication();
        quiz.setVisible(true);
    }
}

class UserScore {
    private String name;
    private int score;
    private String grade;

    public UserScore(String name, int score, String grade) {
        this.name = name;
        this.score = score;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getGrade() {
        return grade;
    }
}