package udemy.web.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import udemy.web.data.Offer;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Clay on 19/01/15.
 */
@Component( "offerDAO" )
public class OfferDAO
{
    // JdbcTemplate wraps DataSource and provides some useful methods
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public void setDataSource( DataSource jdbc )
    {
        this.jdbc = new NamedParameterJdbcTemplate( jdbc );
    }

    public List<Offer> getOffers()
    {
        return jdbc.query( "SELECT * FROM offer", new RowMapper<Offer>()
        {
            public Offer mapRow( ResultSet rs, int rowNum ) throws SQLException
            {
                Offer offer = new Offer();
                offer.setId( rs.getInt( "id" ) );
                offer.setName( rs.getString( "name" ) );
                offer.setEmail( rs.getString( "email" ) );
                offer.setText( rs.getString( "text" ) );

                return offer;
            }
        } );
    }

    public Offer getOfferById( int id )
    {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue( "id", id );

        return jdbc.queryForObject( "SELECT * FROM offer WHERE id = :id", params, new RowMapper<Offer>()
        {
            public Offer mapRow( ResultSet rs, int rowNum ) throws SQLException
            {
                Offer offer = new Offer();
                offer.setId( rs.getInt( "id" ) );
                offer.setName( rs.getString( "name" ) );
                offer.setEmail( rs.getString( "email" ) );
                offer.setText( rs.getString( "text" ) );

                return offer;
            }
        } );
    }

    public boolean create( Offer offer )
    {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource( offer );

        return jdbc.update( "INSERT INTO offer( name, email, text) VALUES ( :name, :email, :text )", params ) == 1;
    }

    public int[] create( List<Offer> offers )
    {
        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch( offers.toArray() );

        return jdbc.batchUpdate( "INSERT INTO offer( name, email, text) VALUES ( :name, :email, :text )", params );
    }

    @Transactional( isolation = Isolation.READ_UNCOMMITTED )
    public int[] failCreate( List<Offer> offers )
    {
        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch( offers.toArray() );

        return jdbc.batchUpdate( "INSERT INTO offer( id, name, email, text) " +
                                 "VALUES ( :id, :name, :email, :text )", params );
    }

    public boolean update( Offer offer )
    {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource( offer );

        return jdbc.update( "UPDATE offer SET name = :name, email = :email, text = :text WHERE id = :id", params ) == 1;
    }

    public int delete( int id )
    {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue( "id", id );

        return jdbc.update( "DELETE FROM offer WHERE id = :id", params );
    }
}
