package udemy.web.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Clay on 19/01/15.
 */
public class Offer
{
    private int id;

    @Size( min = 5, max = 100, message = "Name must be between {min} and {max} characters" )
    private String name;

    @Pattern( regexp = ".*\\@.*\\..*", message = "Please enter a valid email address" )
    private String email;

    @Size( min = 10, max = 100, message = "Text must be between {min} and {max} characters" )
    private String text;

    // more constraints: http://docs.oracle.com/javaee/7/api/javax/validation/constraints/package-summary.html

    public Offer()
    {
    }

    public Offer( int id, String name, String email, String text )
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.text = text;
    }

    public Offer( String name, String email, String text )
    {
        this.name = name;
        this.email = email;
        this.text = text;
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getText()
    {
        return text;
    }

    public void setText( String text )
    {
        this.text = text;
    }

    public String toString()
    {
        return "Offer [id=" + id + ", name=" + name + ", email=" + email + ", text=" + text + "]";
    }
}
