package projectk7.kshoroscope.XMLParseHelper;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by alexander.kluev on 03.09.2015.
 */
@Root(name="horo")
public class DaylyHoroscope
{
    @Element(name="date")
    private HoroscopeDate horoscopeDate;

    @Element(name="aries")
    private Sign aries;

    @Element(name="taurus")
    private Sign taurus;

    @Element(name="gemini")
    private Sign gemini;

    @Element(name="cancer")
    private Sign cancer;

    @Element(name="leo")
    private Sign leo;

    @Element(name="virgo")
    private Sign virgo;

    @Element(name="libra")
    private Sign libra;

    @Element(name="scorpio")
    private Sign scorpio;

    @Element(name="sagittarius")
    private Sign sagittarius;

    @Element(name="capricorn")
    private Sign capricorn;

    @Element(name="aquarius")
    private Sign aquarius;

    @Element(name="pisces")
    private Sign pisces;

    public HoroscopeDate getHoroscopeDate()
    {
        return horoscopeDate;
    }

    public Sign getAries()
    {
        return aries;
    }
    public Sign getTaurus()
    {
        return taurus;
    }
    public Sign getGemini()
    {
        return gemini;
    }
    public Sign getCancer()
    {
        return cancer;
    }
    public Sign getLeo()
    {
        return leo;
    }
    public Sign getVirgo()
    {
        return virgo;
    }
    public Sign getLibra()
    {
        return libra;
    }
    public Sign getScorpio()
    {
        return scorpio;
    }
    public Sign getSagittarius()
    {
        return sagittarius;
    }
    public Sign getCapricorn()
    {
        return capricorn;
    }
    public Sign getAquarius()
    {
        return aquarius;
    }
    public Sign getPisces()
    {
        return pisces;
    }
}

class HoroscopeDate
{
    @Attribute(name="yesterday")
    private String yesterday;

    @Attribute(name="today")
    private String today;

    @Attribute(name="tomorrow")
    private String tomorrow;

    @Attribute(name="tomorrow02")
    private String tomorrow02;

    public String getYesterdayDate()
    {
        return yesterday;
    }
    public String getTodayDate()
    {
        return today;
    }
    public String getTomorrowDate()
    {
        return tomorrow;
    }
    public String getTomorrow02Date()
    {
        return tomorrow02;
    }

}

class Sign
{
    @Element(name="yesterday")
    private String yesterday;

    @Element(name="today")
    private String today;

    @Element(name="tomorrow")
    private String tomorrow;

    @Element(name="tomorrow02")
    private String tomorrow02;

    public String getYesterday()
    {
        return yesterday;
    }
    public String getToday()
    {
        return today;
    }
    public String getTomorrow()
    {
        return tomorrow;
    }
    public String getTomorrow02()
    {
        return tomorrow02;
    }
}