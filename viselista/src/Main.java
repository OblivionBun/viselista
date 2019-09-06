
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private String word; // Загаданное слово
    private String secretWord=""; // Секртеное слово
    private int guesses; // текущее количество ходов
    public static final int MAX_WRONG = 10; // Максимальное количество ошибок

    public static void main(String[] args) {
        Main game_1 = new Main();
        game_1.setWord();
        game_1.setSecretWord();
        game_1.getSecretWord();
        game_1.Game(game_1);
        System.exit(0);
    }

    public void Game(Main object) {
        int marker = 1;
        char[] char_Secret_Word = object.getSecretWord().toCharArray();
        char[] char_word = object.getWord().toCharArray();
        while (Arrays.equals(char_word,char_Secret_Word) || (object.getGuesses() < MAX_WRONG)) {
            System.out.println("Please,input character");
            Scanner input = new Scanner(System.in);
            char chr = input.next().toUpperCase().charAt(0);
            for(int count = 0;count<word.length();count++) {
                if (char_Secret_Word[count]==chr ) {
                    System.out.println("This symbol already exists!");
                    marker = 1;
                } else if (char_word[count]==chr) {
                    char_Secret_Word[count] = char_word[count];
                    marker = 2;
                }
            }
            if (marker == 1) {
                ++guesses;
                System.out.println("Guess "+(object.getGuesses()+"/10"));
            } else if (marker == 2) {
                System.out.println(char_Secret_Word);
            }
        }
        System.out.println("Tnank you for game!");
        return;
    }


    public void setWord() {
        System.out.println("Please,input word");
        Scanner scan = new Scanner(System.in);
        this.word = scan.next();
    }

    public String getWord() {
        return word;
    }

    public void setSecretWord() {
        int size = getWord().length();
        for (int count = 0; count < size; count++)
            secretWord += "-";
    }


    public String getSecretWord() {
        return secretWord;
    }

    public int getGuesses() {
        return guesses;
    }
}

