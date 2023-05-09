package cloud.isaura.experimental.adt;

public class MessaggioOldStyle
{

    private final String contenuto;

    private final Integer tipologiaMessaggio;

    public MessaggioOldStyle(String contenuto, Integer tipologiaMessaggio)
    {
        this.contenuto = contenuto;
        this.tipologiaMessaggio = tipologiaMessaggio;
    }


    public String getContenuto()
    {
        return contenuto;
    }

    public Integer getTipologiaMessaggio()
    {
        return tipologiaMessaggio;
    }
}


