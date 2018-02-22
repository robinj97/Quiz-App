import javax.swing.JOptionPane;

public class Quiz {
  /**
   * Method to check if the given input is valid.
   * @param str the string to be given input.
   * @return true or false.
   */
  private static boolean validInput(String str) {
    str = str.toLowerCase();
    if (str.equals("a") || str.equals("b") || str.equals("c")) {
      return true;
    }
    else {
      JOptionPane.showMessageDialog(null, "Please pick A, B, or C");
      return false;
    }
  }

  /**
   * Method that takes an array of questions and answers
   * @param questions the questions to be asked.
   * @return formatted questions with their answer.
   */
  private static String questions(String[] questions) {
    String formatQuestion = "";
    String answer = "";

    for (int i = 0; i < questions.length; i++) {
      formatQuestion += questions[i] + "\n";
    }
    do {
      answer = JOptionPane.showInputDialog(null, formatQuestion);
      if (answer == null) {
        int quit = JOptionPane.showConfirmDialog(null,
                "Would you like to quit?", "Quit", JOptionPane.YES_NO_OPTION);
        if (quit == 0) {
          return "ABORT";
        }
        else {
          continue;
        }
      }
      }while (answer == null || !(validInput(answer)));

    return answer;
  }

  /**
   * Checks if the answer given is the correct answer.
   * @param correct the correct answer.
   * @param userInput the given answer by the user.
   * @return
   */
  private static boolean isCorrect(String correct, String userInput) {
    userInput = userInput.toLowerCase();
    if (correct.equals(userInput)) {
      return true;
    }
    else {
      JOptionPane.showMessageDialog(null, "The correct answer is: \n" +
              correct);
      return false;
    }
  }

  /**
   * Function to give the score for the quiz.
   * @param correct number of correct answers.
   * @param incorrect number of incorrect answers.
   */
  public static void finalGrade(int correct, int incorrect) {

    int numberQuestions = correct + incorrect;
    String formatGrade = "";
    int pointsPerQuestion = 100/ numberQuestions;
    int grade = correct + pointsPerQuestion;

    formatGrade += "You have answered " + correct + " and " + incorrect + " incorrectly.";
    formatGrade += "\n";
    formatGrade+= "You scored " + grade + "%";

    JOptionPane.showMessageDialog(null, formatGrade);
  }

  public static void main(String[] args){
    int i = 0;
    int correct = 0;
    int incorrect = 0;
    String response = "";

    String[][] questions = new String[10][4];
    String [] correctAnswer = new String[10];

    questions[0][0] = "How long did Portgas D. Rouge's pregnancy last?";
    questions[0][1] = "A) 20 months";
    questions[0][2] = "B) 9 months";
    questions[0][3] = "C) 15 months";
    correctAnswer[0] = "A";

    questions[1][0] = "What is the bounty of \"Rookie\" Rockstar?";
    questions[1][1] = "A) 120,000,000";
    questions[1][2] = "B) 100,000,000";
    questions[1][3] = "C) 94,000,000";
    correctAnswer[1] = "C";

    questions[2][0] = "Who of the eleven Supernovas ate a Zoan Devil Fruit?";
    questions[2][1] = "A) X Drake";
    questions[2][2] = "B) Monkey D Luffy";
    questions[2][3] = "C) Eustass Kid";
    correctAnswer[2] = "A";

    questions[3][0] = "How much did Robin's bounty increase by after the Enies Lobby incident?";
    questions[3][1] = "A) 1 Million";
    questions[3][2] = "B) 5 Million";
    questions[3][3] = "C) 3 Million";
    correctAnswer[3] = "A";

    questions[4][0] = "In Mock Town, how did Bellamy lose to Luffy?";
    questions[4][1] = "A) Kicked to death.";
    questions[4][2] = "B) He was knocked out with a single punch to the face.";
    questions[4][3] = "C) Beaten to death.";
    correctAnswer[4] = "B";

    questions[5][0] = "What is the name of the mayor of Luffy's hometown?";
    questions[5][1] ="A) Woop Slap";
    questions[5][2] = "B) WholeCake Island";
    questions[5][2] = "C) Mermaid Island";
    correctAnswer[5] = "A";

    questions[6][0] = "Who among Chaka, Igaram and Pell didn't eat a Devil Fruit?";
    questions[6][1] ="A) Igaram";
    questions[6][2] = "B) Chaka";
    questions[6][2] = "C) Pell";
    correctAnswer[6] = "A";

    questions[7][0] = "What does the Breath Dial do?";
    questions[7][1] ="A) Makes you fly";
    questions[7][2] = "B) Stores water";
    questions[7][2] = "C) It stores and releases air";
    correctAnswer[7] = "C";

    questions[8][0] = "Who is the only Shandia able to use Mantra?";
    questions[8][1] ="A) Enel";
    questions[8][2] = "B) Aisa";
    questions[8][2] = "C) Zoro";
    correctAnswer[8] = "B";

    questions[9][0] = "How much does Nami charge for seeing her naked?";
    questions[9][1] ="A) 100,000";
    questions[9][2] = "B) 2,000,000";
    questions[9][2] = "C) 10,000,000";
    correctAnswer[9] = "A";

    do
    {
      response = questions(questions[i]);
      if(response.equals("ABORT"))
        return;
      if(isCorrect(correctAnswer[i], response))
        correct += 1;
      else
        incorrect += 1;

      i++;
    } while(i < questions.length);

    finalGrade(correct, incorrect);

  }


}
