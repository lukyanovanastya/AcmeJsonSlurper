public interface AcmeJsonHandler {
    AcmeJsonPath onObjectStart(AcmeJsonPath jpath);
    AcmeJsonPath onObjectEnd(AcmeJsonPath jpath);
    AcmeJsonPath onArrayStart(AcmeJsonPath jpath);
    AcmeJsonPath onArrayEnd(AcmeJsonPath jpath);
    AcmeJsonPath onValue(AcmeJsonPath jpath, Object value);
    Object getRoot();
}
