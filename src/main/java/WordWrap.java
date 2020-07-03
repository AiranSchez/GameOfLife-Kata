public class WordWrap {

    public String wordWrap(String text, int columnWidth)  {
        if(columnWidth < 1){
            throw new IllegalArgumentException("Error");
        }
        if(text == null || text == ""){
            return "";
        }

        if(text.length() > columnWidth){
            if(text.contains(" ")){
                String[] wordString = text.split(" ");
                String cadena = "";
                for (int position = 0; position < wordString.length; position++)
                    if (position == (wordString.length - 1)) {
                        cadena += wordString[position];
                    } else {
                        cadena += wordString[position] + "\n";
                    }
                return cadena;

            }

            return text.substring(0, columnWidth) + '\n' + text.substring(columnWidth);
        }

        return text;
    }
}
