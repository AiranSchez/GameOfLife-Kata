import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordWrapShould {

    // To-do
    /*
     * 1- ("Hola", -1) => (throw Exception)     done
     * 2- (null, 1) => ("")                     done
     * 3- ("", 1) => ("")                       done
     * 4- ("Hola", 7) => ("Hola")               done
     * 5- ("Hola", 2) => ("Ho\nla")             done
     * 6- ("Hola mundo", 7) => ("Hola\nmundo")  done
     * 7- ("ohlala", 2) => (oh\nla\nla)
     * */

    WordWrap wordWrap = new WordWrap();

    @Test (expected = IllegalArgumentException.class)
    public void throw_exception_if_column_width_is_negative() throws Exception {
        wordWrap.wordWrap("Hola", -1);
    }

    @Test
    public void treat_null_as_empty_string() {
        assertThat(wordWrap.wordWrap(null,1)).isEqualTo("");
    }

    @Test
    public void treat_empty_as_empty_string() {
        assertThat(wordWrap.wordWrap("",1)).isEqualTo("");
    }

    @Test
    public void treat_string_when_word_is_smaller_than_column_width() {
        assertThat(wordWrap.wordWrap("Hola", 7)).isEqualTo("Hola");
    }

    @Test
    public void wrap_word_when_column_width_is_less_than_text_lenght() {
        assertThat(wordWrap.wordWrap("Hola", 2)).isEqualTo("Ho\nla");
    }

    @Test
    public void wrap_if_column_width_is_bigger_than_words() {
        assertThat(wordWrap.wordWrap("Hola mundo", 2)).isEqualTo("Hola\nmundo");
        assertThat(wordWrap.wordWrap("Hola mundo cruel", 2)).isEqualTo("Hola\nmundo\ncruel");
        //assertThat(wordWrap.wordWrap("ohlala", 2)).isEqualTo("oh\nla\nla");
        //assertThat(wordWrap.wordWrap("Hola al mundo", 2)).isEqualTo("Hola al\nmundo");
    }


}
