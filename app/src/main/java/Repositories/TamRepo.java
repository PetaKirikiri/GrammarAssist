package Repositories;

import java.util.ArrayList;

import Models.Tam;

/**
 * Created by petakirikiri on 15/02/16.
 */
public class TamRepo {

    ArrayList<Tam> tamArrayList = new ArrayList<Tam>();


    // Method that creates an Arraylist of Tam Objects

    public ArrayList<Tam> getTamArrayList(){
        Tam I = new Tam();
        I.setEng("Past");
        I.setMao("I");
        tamArrayList.add(I);

        Tam Kua = new Tam();
        Kua.setEng("Recent Past");
        Kua.setMao("Kua");
        tamArrayList.add(Kua);

        Tam Keite = new Tam();
        Keite.setEng("Present");
        Keite.setMao("Kei te");
        tamArrayList.add(Keite);

        Tam Eana = new Tam();
        Eana.setEng("Present Continuous");
        Eana.setMao("E ... ana");
        tamArrayList.add(Eana);

        Tam Ka = new Tam();
        Ka.setEng("Relative Future");
        Ka.setMao("Ka");
        tamArrayList.add(Ka);

        Tam Me = new Tam();
        Me.setEng("Should");
        Me.setMao("Me");
        tamArrayList.add(Me);

        return tamArrayList;
    }
}
