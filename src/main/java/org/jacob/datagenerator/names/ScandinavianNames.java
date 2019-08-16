package org.jacob.datagenerator.names;

import org.fluttercode.datafactory.NameDataValues;
import org.fluttercode.datafactory.impl.DefaultNameDataValues;

public class ScandinavianNames implements NameDataValues {
    //first name values to use
    String[] firstNames = {"Anders","Freydís","Gerlach","Sigdis"};

    //delegate to the default implementation for the other values
    NameDataValues defaults = new DefaultNameDataValues();

    public String[] getFirstNames() {
        //return our custom list of names
        return firstNames;
    }

    //for the other values, just use the defaults
    public String[] getLastNames() {
        return defaults.getLastNames();
    }

    public String[] getPrefixes() {
        return defaults.getPrefixes();
    }

    public String[] getSuffixes() {
        return defaults.getSuffixes();
    }
}
