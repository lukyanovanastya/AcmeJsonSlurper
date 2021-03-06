
import groovy.json.JsonOutput;

import java.io.IOException;
import java.io.Writer;

public class AcmeJsonWriter implements AcmeJsonHandler{

    Writer writer;
    boolean space=false;  //without indent by default

    public AcmeJsonWriter(Writer writer){
        this.writer=writer;
    }

    public AcmeJsonWriter(Writer writer, boolean space){
        this.space=space;
        this.writer=writer;
    }

    public AcmeJsonWriter setIndent(boolean space){
        this.space = space;
        return this;
    }

    @Override
    public AcmeJsonPath onObjectStart(AcmeJsonPath jpath) {
        String str="";
        if(jpath.size()>0) {
            if(jpath.peek().index>0) str+=",";
            if(space) str+=printIndent(jpath);
            if(jpath.peek().isKey) {
                str+="\""+jpath.peek().key+"\":";
                if(space) jpath.indent += 2;
            }
        }
        if(space) jpath.indent++;
        str+="{";
        try {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jpath;
    }


    @Override
    public AcmeJsonPath onObjectEnd(AcmeJsonPath jpath) {
        if(space) jpath.indent--;
        String str="";
        if(space) str+=printIndent(jpath);
        str+="}";
        if(space) if(jpath.size()>0 && jpath.peek().isKey) jpath.indent-=2;
        try {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jpath;
    }

    @Override
    public AcmeJsonPath onArrayStart(AcmeJsonPath jpath) {
        String str="";
        if(jpath.size()>0) {
            if(jpath.peek().index>0) str+=",";
            if(space) str+=printIndent(jpath);
            if(jpath.peek().isKey) {
                str+=JsonOutput.toJson(jpath.peek().key)+":";
                if(space) jpath.indent += 2;
            }
        }
        if(space) jpath.indent++;
        str+="[";
        try {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jpath;
    }

    @Override
    public AcmeJsonPath onArrayEnd(AcmeJsonPath jpath) {
        if(space) jpath.indent--;
        String str="";
        if(space) str+=printIndent(jpath);
        str+="]";
        if(space) if(jpath.size()>0 && jpath.peek().isKey) jpath.indent-=2;
        try {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jpath;
    }



    @Override
    public AcmeJsonPath onValue(AcmeJsonPath jpath, Object value) {
        String str = "";
        if (jpath.peek().index > 0) str += ",";
        if(space) str+=printIndent(jpath);
        if(jpath.peek().isKey) str+=JsonOutput.toJson(jpath.peek().key)+":";
        str += JsonOutput.toJson(value);

        try {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jpath;
    }

    @Override
    public Object getRoot() {
        return writer;
    }

    private String printIndent (AcmeJsonPath jpath){
        String str="\n";
        for (int i = 0; i < jpath.indent; i++) {
            str += "  ";
        }
        return str;
    }
}
