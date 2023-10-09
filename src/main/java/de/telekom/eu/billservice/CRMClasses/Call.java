package de.telekom.eu.billservice.CRMClasses;

import lombok.Data;
import java.util.Date;

@Data
public class Call {
    private int id;
    private Date timestamp;
    private Type type;

    public enum Type{
        START, END
    }

}
