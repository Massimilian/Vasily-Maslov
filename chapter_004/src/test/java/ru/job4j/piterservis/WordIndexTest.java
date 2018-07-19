package ru.job4j.piterservis;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class WordIndexTest {

    private WordIndex wi = new WordIndex();
    private Set<Integer> set = new LinkedHashSet<>();


    @Test
    public void whenAskAWordThenShowThePlaceOneLetterWord() {
        wi.loadFile("Abracadabra!!!");
        set.add(0);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(10);
        assertThat(wi.getIndexes4Word("a"), is(set));
    }

    @Test
    public void whenAskAWordThenShowThePlaceManyLettersWord() {
        wi.loadFile("むかしむかしあるところに，猫とツグミと金のとさかのおんどりがいました。みんなでいっしよに森の小屋に住んでいました。猫とツグミは森に薪を切りに行き、おんどりは家で留守番です。 出かける時、猫とツグミはおんどりにきつく言い聞かせました。");
        set.add(13);
        set.add(57);
        set.add(93);
        assertThat(wi.getIndexes4Word("猫と"), is(set)); // значение слова - кошка.
    }
}
