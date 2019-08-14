package ru.job4j.finalwork;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SearcherTest {
    private ArrayList<String> strings = new ArrayList<String>();

    @Test
    public void whenTryToSearchOneStringThenDoIt() {
        strings.add("abracadabra");
        strings.add("abracadi");
        strings.add("rcecefewd");
        strings.add("werwerHOPfwefed");
        strings.add("arepkrpfwdd");
        strings.add("rcecefAer");
        strings.add("werwer");
        strings.add("feoirjffkfkjlkdfjg");
        strings.add("arepkHOPrp");
        strings.add("eewpkrp");
        strings.add("rcegkferdhfjAce");
        strings.add("wegrHrOPwer");
        strings.add("pqHPOakrp");
        CopyOnWriteArrayList<String> resOne = new Searcher(strings).search("HOP");
        assertThat(resOne.size(), is(2));
        CopyOnWriteArrayList<String> resTwo = new Searcher(strings).search("a");
        assertThat(resTwo.size(), is(5));
    }
}
