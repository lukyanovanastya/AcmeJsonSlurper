


class AcmeJsonTest {

    public void test1(){
        Stack<AcmeJsonPath.Element> path=new AcmeJsonPath<AcmeJsonPath.Element>();
        AcmeJsonPath.Element a = new AcmeJsonPath.Element(0,"o");
        AcmeJsonPath.Element b = new AcmeJsonPath.Element(1,"b");
        AcmeJsonPath.Element c = new AcmeJsonPath.Element(2,null);
        Object par = path.push(a);
        path.push(b);
        path.push(c);
        System.out.println(path.toString());
        System.out.println(par.toString());
    }

}
