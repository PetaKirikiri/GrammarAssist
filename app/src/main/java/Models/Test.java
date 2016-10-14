package Models;

import java.io.Serializable;

/**
 * Created by petakirikiri on 26/04/16.
 */
public class Test implements Serializable {
    public Test(String test) {
        this.test = test;
    }

    String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
