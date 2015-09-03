package projectk7.kshoroscope.XMLParseHelper;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by alexander.kluev on 03.09.2015.
 */

@Root(name="horo")
public class WeeklyHoroscope
{
    @Element(name="date")
    private HoroscopeWeek horoscopeWeek;

    @Element(name="aries")
    private WeekSign aries;

    @Element(name="taurus")
    private WeekSign taurus;

    @Element(name="gemini")
    private WeekSign gemini;

    @Element(name="cancer")
    private WeekSign cancer;

    @Element(name="leo")
    private WeekSign leo;

    @Element(name="virgo")
    private WeekSign virgo;

    @Element(name="libra")
    private WeekSign libra;

    @Element(name="scorpio")
    private WeekSign scorpio;

    @Element(name="sagittarius")
    private WeekSign sagittarius;

    @Element(name="capricorn")
    private WeekSign capricorn;

    @Element(name="aquarius")
    private WeekSign aquarius;

    @Element(name="pisces")
    private WeekSign pisces;

    public HoroscopeWeek getHoroscopeWeek()
    {
        return horoscopeWeek;
    }

    public WeekSign getAries()
    {
        return aries;
    }
    public WeekSign getTaurus()
    {
        return taurus;
    }
    public WeekSign getGemini()
    {
        return gemini;
    }
    public WeekSign getCancer()
    {
        return cancer;
    }
    public WeekSign getLeo()
    {
        return leo;
    }
    public WeekSign getVirgo()
    {
        return virgo;
    }
    public WeekSign getLibra()
    {
        return libra;
    }
    public WeekSign getScorpio()
    {
        return scorpio;
    }
    public WeekSign getSagittarius()
    {
        return sagittarius;
    }
    public WeekSign getCapricorn()
    {
        return capricorn;
    }
    public WeekSign getAquarius()
    {
        return aquarius;
    }
    public WeekSign getPisces()
    {
        return pisces;
    }
}

class HoroscopeWeek
{
    @Attribute(name = "weekly")
    private String week;

    public String getWeek() {
        return week;
    }
}

class WeekSign
{
    @Element(name="business")
    private String business;

    @Element(name="common")
    private String common;

    @Element(name="love")
    private String love;

    @Element(name="health")
    private String health;

    @Element(name="car")
    private String car;

    @Element(name="beauty")
    private String beauty;

    @Element(name="erotic")
    private String erotic;

    @Element(name="gold")
    private String gold;

    public String getBusiness()
    {
        return business;
    }

    public String getCommon()
    {
        return common;
    }

    public String getLove()
    {
        return love;
    }

    public String getHealth()
    {
        return health;
    }

    public String getCar()
    {
        return car;
    }

    public String getBeauty()
    {
        return beauty;
    }

    public String getErotic()
    {
        return erotic;
    }

    public String getGold()
    {
        return gold;
    }
}
