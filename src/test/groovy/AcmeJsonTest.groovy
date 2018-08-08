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
        println "was:\n"+json +"\n"
        println "became:"

        //actual code
        println new AcmeJsonParser().each(path){jpath, value->1111}.each{jpath, value->value=="z"? "zzz" : value}.target(new StringWriter()).parseText(json).toString();
    }

}
