import groovy.json.JsonOutput;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcmeJsonPath<Element> extends Stack<Element>{

    int indent=0;

    public AcmeJsonPath(){super();}


    public String toString(){
        String res="$";
        for (Object a: this
                ) {
            res+=a.toString();
        }
        return res;
    }



    /*
    public Element push(int index, String key){
        AcmeJsonPath.Element e = new AcmeJsonPath.Element(index, key);
        return this.push((Element) e);
    }
    */




    public static class Element{

        boolean isKey;
        String key;
        int index;

        public Element(int index, String key){
            if(key==null) isKey=false;
            else isKey=true;
            this.index=index;
            this.key=key;
        }

        public String toString(){
            if(isKey) return"."+ key;
            else return "["+index+"]";
        }
    }

}
