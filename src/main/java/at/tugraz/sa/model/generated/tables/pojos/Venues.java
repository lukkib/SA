/**
 * This class is generated by jOOQ
 */
package at.tugraz.sa.model.generated.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Venues implements Serializable {

    private static final long serialVersionUID = 939345803;

    private final String _40id_9_40lon_9_40lat_9name;

    public Venues(Venues value) {
        this._40id_9_40lon_9_40lat_9name = value._40id_9_40lon_9_40lat_9name;
    }

    public Venues(
        String _40id_9_40lon_9_40lat_9name
    ) {
        this._40id_9_40lon_9_40lat_9name = _40id_9_40lon_9_40lat_9name;
    }

    public String get_40id_9_40lon_9_40lat_9name() {
        return this._40id_9_40lon_9_40lat_9name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Venues (");

        sb.append(_40id_9_40lon_9_40lat_9name);

        sb.append(")");
        return sb.toString();
    }
}
