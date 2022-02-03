import java.math.BigDecimal;
import java.math.RoundingMode;
public class AriSTurkey extends AbstractLocale{
  
    public AriSTurkey(){
      super("Turkey", "Turkish");
      
    }
    public AriSTurkey(String location, String language){
      super(location, language);
      
    }

    public String getGreeting(){
      return "Merhaba";
    }
    public String getLocalTime(int hour, int min){
      hour+=8;
      return String.format("%d:%02d", hour, min);
    }
    public String getCurrencySymbol(){
      return "₺";
    }
    public double getCurrencyValue(double dollarAmount){
      BigDecimal bd = new BigDecimal(dollarAmount*8.12).setScale(2, RoundingMode.HALF_UP);
      
      return bd.doubleValue();
    }

}