package ru.job4j.condition;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 31/12/2017
 */
public class DummyBot {
    /**
     * Answer to questions;
     * @param question;
     * @return answer;
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if 
		("Привет, Бот.".equals(question)) {
		//("Привет, Бот.".equals(question) || ("Привет, бот.".equals(question))) {
		// усложнённый вариант программы
            rsl = "Привет, умник.";                    
        } else if (("Пока.".equals(question))) { 
            rsl = "До скорой встречи.";
        }
        return rsl;
     }
}
