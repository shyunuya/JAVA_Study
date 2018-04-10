package practice;

public class ParserTest {

    public static void main(String[] args) {
        Parseable parser = ParseManager.getParser("XML");
        parser.parse("example.xml");
        parser = ParseManager.getParser("HTML");
        parser.parse("example.html");
    }

    /* getParser method of ParseManager class returned either XMLParse instance or HTMLParser instance depends on value of type from parameter.
       reference variable parser obtains XMLParser/HTMLParser instance's address from result of getParser method.
       This is same as running Parseable parse = new XMLParser();
       parser.parse("example.xml"); <-- parse is pointing XMLParser instance.
       Calling parse() through reference variable parser, then parser method of XMLParser instance is called which parser has been referencing.
    */
}

interface Parseable {
    // executing parsing work
    public abstract void parse(String filename);
}

class ParseManager {
    // Return type is Parseable interface.
    public static Parseable getParser(String type) {
        if (type.equals("XML")) {
            return new XMLParser();
        } else {
/*          Parseable p = new HTMLParser();
            return p;*/
            return new HTMLParser();
        }
    }
}

class XMLParser implements Parseable {
    public void parse(String filename) {
        // ...parsing code
        System.out.println(filename + " - XML parsing completed");
    }
}

class HTMLParser implements Parseable {
    public void parse(String filename) {
        // ...parsing code
        System.out.println(filename + "- HTML parsing completed");
    }
}
