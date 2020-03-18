import junit.framework.TestCase;

public class TestClass extends TestCase {
    public Polinom P;
    public Polinom Q;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        P = new Polinom();
        Q = new Polinom();
        P.addTermen(new Monom(1,3));
        P.addTermen(new Monom(2,0));
        P.addTermen(new Monom(0,2));
        System.out.println(P.toString());

        Q.addTermen(new Monom(2,3));
        Q.addTermen(new Monom(0,0));
        Q.addTermen(new Monom(0,2));
        System.out.println(Q.toString());
    }

    public void testEqual() throws Throwable {
        Polinom rezultat =  new Polinom(); // P+Q
        rezultat.addTermen(new Monom(3,3));
        rezultat.addTermen((new Monom(2,0)));
        P.adunaPolinom(Q);
        assertEquals(rezultat.toString(), P.toString()); //test care ar da arevarat
        rezultat.scadePolinom(Q);
        assertEquals(Q.toString(), rezultat.toString()); //test ce va esua
        assertEquals(P.toString(), rezultat.toString());
    }
    public void testIntDer() throws Throwable{
        Polinom dummy = new Polinom();
        dummy.addTermen(new Monom(1,2));
        Polinom dummyInit = dummy;
        Polinom rezDer = new Polinom();
        Polinom rezInt = new Polinom();
        rezDer.addTermen(new Monom(2,1));
        rezInt.addTermen(new Monom(0.5,2));

        dummy.deriveaza();
        assertEquals(rezDer.toString(), dummy.toString());
        dummy.integrare();
        assertEquals(dummy.toString(), dummyInit.toString());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        P = null;
        Q = null;
        System.out.println("Test incheiat");
    }
}
