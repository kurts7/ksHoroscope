package projectk7.kshoroscope.XMLParseHelper;

import org.simpleframework.xml.core.Persister;

import java.io.Reader;
import java.io.StringReader;

/**
 * Created by alexander.kluev on 03.09.2015.
 */
public abstract class DaylyHoroscopeCreator {

    public static String getHoroscope(String sign, String period, String xml)
    {
        Reader reader = new StringReader(xml);
        Persister serializer = new Persister();


        try
        {
            DaylyHoroscope horo = serializer.read(DaylyHoroscope.class, reader, false);

            Sign mySign = getDaylySign(sign,horo);
            return getDay(period, mySign);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "Не удалось получить предсказание для Вас, проверьте, пожалуйста, интернет соединение...";
        }
    }

    private static Sign getDaylySign(String sign, DaylyHoroscope horo)
    {
        switch (sign) {
            case "aries":
                return horo.getAries();
            case "taurus":
                return horo.getTaurus();
            case "gemini":
                return horo.getGemini();
            case "cancer":
                return horo.getCancer();
            case "leo":
                return horo.getLeo();
            case "virgo":
                return horo.getVirgo();
            case "libra":
                return horo.getLibra();
            case "scorpio":
                return horo.getScorpio();
            case "sagittarius":
                return horo.getSagittarius();
            case "capricorn":
                return horo.getCapricorn();
            case "aquarius":
                return horo.getAquarius();
            case "pisces":
                return horo.getPisces();
            default:
                return null;
        }

    }

    private static String getDay(String day, Sign sign)
    {
        switch(day)
        {
            case "yesterday":
                return sign.getYesterday();
            case "today":
                return sign.getToday();
            case "tomorrow":
                return sign.getTomorrow();
            case "tomorrow02":
                return sign.getTomorrow02();
            default:
                return null;
        }
    }

}
