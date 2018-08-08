public interface AcmeJsonHandler {


    public AcmeJsonPath onObjectStart(AcmeJsonPath<AcmeJsonPath.Element> jpath);
    public AcmeJsonPath onObjectEnd(AcmeJsonPath<AcmeJsonPath.Element> jpath);
    public AcmeJsonPath onArrayStart(AcmeJsonPath<AcmeJsonPath.Element> jpath);
    public AcmeJsonPath onArrayEnd(AcmeJsonPath<AcmeJsonPath.Element> jpath);
    public AcmeJsonPath onValue(AcmeJsonPath<AcmeJsonPath.Element> jpath, Object value);
    public Object getRoot();
}
