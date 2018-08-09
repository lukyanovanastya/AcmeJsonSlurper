import groovy.json.*

import java.util.regex.Matcher
import java.util.regex.Pattern;

class AcmeJsonTest extends GroovyTestCase {

    String json = "{\"o\":{\"a\":1,\"b\":[21,{\"22\":2},23,24],\"c\":3,\"d\":\"z\"}}"
    String path = "\$.o.b[0]";

    /*
    public void testClassic(){
        println "Classic\n"
        JsonSlurperClassic parser = new JsonSlurperClassic();
        def res = parser.parseText(json);
        println JsonOutput.toJson(res);
        println "\n"
    }
    */

    public void testAcmeParser(){
        println "Parser:"
        println "was:\n"+json+"\nout:"
        println new AcmeJsonParser().each(path){jpath, value->1111}.each{jpath, value->value=="z"? "zzz" : value}.target(new StringWriter(), true).parseText(json).toString();
    }


    public void testAcmeOutput(){
        println "Output:"
        println "was:\n"+json+"\nout:"
        println new AcmeJsonOutput().setIndent(true).parse(new AcmeJsonParser().parseText(json))
    }
}
