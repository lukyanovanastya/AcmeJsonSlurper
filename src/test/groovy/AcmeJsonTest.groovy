import groovy.json.*

import java.util.regex.Matcher
import java.util.regex.Pattern;

class AcmeJsonTest extends GroovyTestCase {

    String json = "{\"o\":{\"a\":1,\"b\":[21,{\"22\":2},23,24],\"c\":3,\"d\":\"z\"}}"
    String path = "\$.o.b";

    /*
    public void testClassic(){
        println "Classic\n"
        JsonSlurperClassic parser = new JsonSlurperClassic();
        def res = parser.parseText(json);
        println JsonOutput.toJson(res);
        println "\n"
    }
    */

    public void testAcmeParserValue(){
        println "\nParser using onValue:"
        println "was:\n"+json+"\nout:"
        println new AcmeJsonParser().onValue(path){jpath, value->1111}.onValue{jpath, value->value=="z"? "zzz" : value}.target(new StringWriter(), true).parseText(json)
    }


    public void testAcmeOutput(){
        println "\nOutput:"
        println "was:\n"+json+"\nout:"
        println new AcmeJsonOutput(new AcmeJsonParser().parseText(json)).setIndent(true).writeTo(new StringWriter())
    }

    public void testAcmeParserEach(){
        println "\nParser using each:"
        println "jpath: "+path
        new AcmeJsonParser().each(path){jpath, obj->println new AcmeJsonOutput(obj).setIndent(true).writeTo(new StringWriter())}.parseText(json);
    }
}
