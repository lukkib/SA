/**
 * This class is generated by jOOQ
 */
package at.tugraz.sa.model.generated.tables.records;


import at.tugraz.sa.model.generated.tables.Venues;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Row1;
import org.jooq.impl.TableRecordImpl;


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
public class VenuesRecord extends TableRecordImpl<VenuesRecord> implements Record1<String> {

    private static final long serialVersionUID = -803377680;

    /**
     * Setter for <code>PUBLIC.VENUES.@id	@lon	@lat	name</code>.
     */
    public VenuesRecord set_40id_9_40lon_9_40lat_9name(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.VENUES.@id	@lon	@lat	name</code>.
     */
    public String get_40id_9_40lon_9_40lat_9name() {
        return (String) get(0);
    }

    // -------------------------------------------------------------------------
    // Record1 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row1<String> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row1<String> valuesRow() {
        return (Row1) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Venues.VENUES._40ID_9_40LON_9_40LAT_9NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return get_40id_9_40lon_9_40lat_9name();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VenuesRecord value1(String value) {
        set_40id_9_40lon_9_40lat_9name(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VenuesRecord values(String value1) {
        value1(value1);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VenuesRecord
     */
    public VenuesRecord() {
        super(Venues.VENUES);
    }

    /**
     * Create a detached, initialised VenuesRecord
     */
    public VenuesRecord(String _40id_9_40lon_9_40lat_9name) {
        super(Venues.VENUES);

        set(0, _40id_9_40lon_9_40lat_9name);
    }
}
