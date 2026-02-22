package org;

import javax.xml.namespace.QName;

public class Mason extends Parent {

    public boolean birthMarkExist = true;

    public Mason(){}

    public Mason(String name, String eyeColor, String hairColor) {
        super.name = name;
        super.eyeColor = eyeColor;
        super.hairColor = hairColor;
    }

    public Mason(String eyeColor, String hairColor) {
        super(eyeColor, hairColor);
    }

}
