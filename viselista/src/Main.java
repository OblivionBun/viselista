
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1st Player write your word!");
        Scanner in = new Scanner(System.in); //инициализация Scanner'а
        String word = in.next(); //ввод загаданного слова
        String s_word = ""; //создание переменной, которая выводит секретное слово с "-" вместо букв
        s_word += word.charAt(0); //добавление первой буквы слова
        for (int i = 1; i < word.length()-1; i++)
        {
            if (word.charAt(i) == word.charAt(0)) //проверка на схожесть с первым символом
                s_word += word.charAt(i);
            else if (word.charAt(i) == word.charAt(word.length()-1)) //проверка на схожесть с последним символом
                s_word += word.charAt(i);
            else {
                s_word += "-"; //заполнение центра слова "-"
            }
        }
        s_word += word.charAt(word.length()-1); //добавление последней буквы слова
        System.out.println(s_word); //вывод того, что получилось: истребитель -> и-----и---ь
        System.out.println("2nd Player try to guess one of character!");
        int flag; //флаг для проверки, угадал ли игрок букву
        int steps = 0; //счётчик количества жизней
        String first_str;
        String second_str;
        while (word.equals(s_word)!=true) //цикл самой игры
        {
            flag = 1; //подготовка флага
            System.out.println("Write your character.");
            char character  = in.next().charAt(0); //считывание массива символов, состоящий из 1 символа
            String symbol="" + character;
            for (int i = 1; i < word.length() - 1; i++) //цикл проверки - правильный ли символ
            {
                System.out.println("Значение переменной "+i);
                 first_str =""+s_word.charAt(i);
                 second_str=""+word.charAt(i);
                if (first_str.equalsIgnoreCase(symbol)) //проверка на то, что такого же символа нет
                {
                    System.out.println("This symbol already exists!");
                    flag =1;
                    break;
                } else if (second_str.equalsIgnoreCase(symbol)) { //проверка на то, что этот символ есть в изначальном слове
                    s_word="";
                    for (int k = 1; k < word.length()-1; k++)
                    {
                        if (word.charAt(k) == word.charAt(0)) //проверка на схожесть с первым символом
                            s_word += word.charAt(k);
                        else if (word.charAt(k) == word.charAt(word.length()-1)) //проверка на схожесть с последним символом
                            s_word += word.charAt(k);
                        else if(word.charAt(k)==character)
                            s_word+=word.charAt(k);
                        else {
                            s_word += "-"; //заполнение центра слова "-"
                        }
                    }
                    flag = 0;
                }
            }
            if (flag == 1) //проверка флага
            {
                steps += 1; //приближение к проигрышу
                System.out.println("Oh no! You on " + steps + "/10 to death");
            } else if (flag == 0) {
                System.out.println("Nice!" + " Now your progress is "+s_word);
            }
            if (steps == 10)
            {
                for (int j = 0; j < 3; j++)
                {
                    Thread.sleep(500); //создаёт задержку в 1 секунду, сделанно для эффекта
                    System.out.println(".");
                }
                System.out.println("Omae wa mou shindeiru!!");
                Thread.sleep(200);
                System.exit(0); //завершение игры
            }
        }
        System.out.println("Congratulations 2nd Player! You win!!");
    }
}

