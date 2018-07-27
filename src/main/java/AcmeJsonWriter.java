import java.io.IOException;
import java.io.Writer;

public class AcmeJsonWriter implements AcmeJsonHandler{

    Writer writer;

    public AcmeJsonWriter(Writer writer){
        this.writer=writer;
    }

    @Override
    public AcmeJsonPath onObjectStart(AcmeJsonPath<AcmeJsonPath.Element> jpath) {
        String str="{\n";
        try {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jpath;
    }


    @Override
    public AcmeJsonPath onObjectEnd(AcmeJsonPath<AcmeJsonPath.Element> jpath) {
        int indent = jpath.size();
        String str="\n";
        for(int i=0; i<indent; i++){
            str+="  ";
        }
        str+="}";
        try {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jpath;
    }

    @Override
    public AcmeJsonPath onArrayStart(AcmeJsonPath<AcmeJsonPath.Element> jpath) {
        String str="[\n";
        try {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jpath;
    }

    @Override
    public AcmeJsonPath onArrayEnd(AcmeJsonPath<AcmeJsonPath.Element> jpath) {
        int indent = jpath.size();
        String str="\n";
        for(int i=0; i<indent; i++){
            str+="  ";
        }
        str+="]";
        try {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jpath;
    }

    @Override
    public AcmeJsonPath onNext(AcmeJsonPath<AcmeJsonPath.Element> jpath) {
        try {
            writer.write(",\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jpath;
    }

    @Override
    public AcmeJsonPath onKey(AcmeJsonPath<AcmeJsonPath.Element> jpath) {
        int indent = jpath.size();
        String str="";
        for(int i=0; i<indent; i++){
            str+="  ";
        }
        str+=jpath.peek().key+":";
        try {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jpath;
    }


    @Override
    public AcmeJsonPath onValue(AcmeJsonPath<AcmeJsonPath.Element> jpath, Object value) {
        String str = "";
        if(!jpath.peek().isKey) {
            int indent = jpath.size();
            for (int i = 0; i < indent; i++) {
                str += "  ";
            }
        }
        str+=value.toString();
        return null;
    }
}
