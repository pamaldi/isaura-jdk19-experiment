package cloud.isaura.experimental.adt;

import java.util.random.RandomGenerator;

public class AdtOldStyleMain
{


    private static void impostaStatoErogazioneSuRicetta(MessaggioOldStyle messaggio)
    {

    }

    private static void impostaBloccoInStruttura(MessaggioOldStyle messaggio)
    {

    }

    private static void impostaBloccoInRegione(MessaggioOldStyle messaggio)
    {

    }

    private static void impostaSbloccoInRegione(MessaggioOldStyle messaggio)
    {

    }

    private static Boolean isCondizioneErroreInternoSiss(MessaggioOldStyle messaggio)
    {
        return RandomGenerator.getDefault().nextBoolean();
    }

    private static void impostaErroreSiss(MessaggioOldStyle messaggio)
    {

    }

    private static Boolean isCondizioneErroreNonBloccante(MessaggioOldStyle messaggio)
    {
        return RandomGenerator.getDefault().nextBoolean();
    }

    private static void impostaErroreNonBloccante(MessaggioOldStyle messaggio)
    {

    }

    private static Boolean isMessaggioOK(MessaggioOldStyle messaggio)
    {
        return RandomGenerator.getDefault().nextBoolean();
    }

    private static void impostaErroreSconosciuto(MessaggioOldStyle messaggio)
    {

    }

    private static Boolean isCondizioneMessaggioSoapFault(MessaggioOldStyle messaggio)
    {
        return RandomGenerator.getDefault().nextBoolean();
    }

    private static void impostaErroreSoapFault(MessaggioOldStyle messaggio)
    {

    }

    private static Boolean isMessaggioAnnullamentoSenzaPrestazioni(MessaggioOldStyle messaggio)
    {
        return RandomGenerator.getDefault().nextBoolean();
    }

    public static void main(String[] args)
    {
        String contenutoMessaggioInviato = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<m:MIA.comunicaEventoSpecialistico xmlns:m=\"http://www.crs.lombardia.it/schemas/PS_R/SISSWAY/2015-01/comunicaEventoSpecialistico/\"\n" +
                "                                   dataSetVersion=\"1.0\">\n" +
                "   <appl>CUP</appl>\n" +
                "   <listaEventi>\n" +
                "      <eventoAccettazione>\n" +
                "         <idEvento>1</idEvento>\n" +
                "         <codiceRegioneErogatore>030</codiceRegioneErogatore>\n" +
                "         <datiStruttura>\n" +
                "            <idStruttura>030702</idStruttura>\n" +
                "            <idSubStruttura/>\n" +
                "         </datiStruttura>\n" +
                "         <datiCittadino>\n" +
                "            <idAnag>28654900</idAnag>\n" +
                "            <codiceFiscale>ZMPSRN35D63B485K</codiceFiscale>\n" +
                "            <cognomeCittadino>ZAMPIERI</cognomeCittadino>\n" +
                "            <nomeCittadino>ESTERINA ALBINA</nomeCittadino>\n" +
                "            <sessoCittadino>F</sessoCittadino>\n" +
                "            <dataNascitaCittadino>19350423</dataNascitaCittadino>\n" +
                "         </datiCittadino>\n" +
                "         <calcolaIUP>N</calcolaIUP>\n" +
                "         <NRE>0300A4111581001</NRE>\n" +
                "         <numeroCartellaAmbulatoriale>20232218450</numeroCartellaAmbulatoriale>\n" +
                "         <tipoOperazione>2</tipoOperazione>\n" +
                "         <idProvenienzaPaziente>2</idProvenienzaPaziente>\n" +
                "         <idEsenzione>019.365.1</idEsenzione>\n" +
                "         <medicoRichiedente>\n" +
                "            <codiceFiscale>RSSLMR64E18F704H</codiceFiscale>\n" +
                "         </medicoRichiedente>\n" +
                "         <tipoErogazioneSpec>D</tipoErogazioneSpec>\n" +
                "         <quesitoDiagnostico>post capusolotomia</quesitoDiagnostico>\n" +
                "         <quotaFissa>0.00</quotaFissa>\n" +
                "         <franchigia>0.00</franchigia>\n" +
                "         <dataSpedizione>2023-05-08 17:48:55</dataSpedizione>\n" +
                "         <elencoDettagliPrescrInviiErogato>\n" +
                "            <dettaglioPrescrizioneInvioErogato>\n" +
                "               <codProdPrestSISS>3495091</codProdPrestSISS>\n" +
                "               <codProdPrestErogSISS>3495091</codProdPrestErogSISS>\n" +
                "               <flagAggiuntiva>N</flagAggiuntiva>\n" +
                "               <descrProdPrestErog>ESAME DEL FUNDUS OCULI  95.09.1</descrProdPrestErog>\n" +
                "               <codBranca>34</codBranca>\n" +
                "               <prezzo>7.90</prezzo>\n" +
                "               <quantitaErogata>1</quantitaErogata>\n" +
                "               <dataIniErog>2023-05-08 17:48:55</dataIniErog>\n" +
                "               <dataFineErog>2023-05-08 17:48:55</dataFineErog>\n" +
                "               <prezzoRimborso>0.00</prezzoRimborso>\n" +
                "               <codPresidio>702002265</codPresidio>\n" +
                "               <garanziaTempiMax>0</garanziaTempiMax>\n" +
                "               <dataPrenotazione>2023-04-28 00:00:00</dataPrenotazione>\n" +
                "            </dettaglioPrescrizioneInvioErogato>\n" +
                "         </elencoDettagliPrescrInviiErogato>\n" +
                "      </eventoAccettazione>\n" +
                "   </listaEventi>\n" +
                "</m:MIA.comunicaEventoSpecialistico>\n";
        String contenutoResponse = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?> <SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsd=\"http://www.w3.org/1999/XMLSchema\" xmlns:xsi=\"http://www.w3.org/1999/XMLSchema-instance\" SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"> <SOAP-ENV:Body> <FSE.comunicaEventoSpecialisticoResponse xmlns=\"http://www.crs.lombardia.it/schemas/DCSanita/FSE/2015-01/comunicaEventoSpecialistico/\"><param xmlns=\"\"><esitoNegativo><codiceErrore>SPEC001</codiceErrore><descErrore>Anomalia nel servizio di comunica evento specialistico</descErrore><listaEccezioni><eccezione><codiceEccezione>MEF:5176</codiceEccezione><descEccezione>Non utilizzare l'erogazione singola o parziale se il totale delle prescrizioni da erogare ? uguale al numero delle prescrizioni di ricetta</descEccezione><nomeCampo>ProgrPresc</nomeCampo><valoreCampo>0</valoreCampo><descEccezioneCampo/><codiceEccezioneCampo/><ROI/></eccezione></listaEccezioni></esitoNegativo></param></FSE.comunicaEventoSpecialisticoResponse>  </SOAP-ENV:Body> </SOAP-ENV:Envelope> ";
        MessaggioOldStyle messaggioInviato = new MessaggioOldStyle(contenutoMessaggioInviato, 7);
        MessaggioOldStyle messaggioRicevuto = new MessaggioOldStyle(contenutoResponse, 7);

        if (isCondizioneErroreInternoSiss(messaggioRicevuto))
        {

            impostaErroreSiss(messaggioRicevuto);

        } else if (isCondizioneErroreNonBloccante(messaggioRicevuto))
        {

            impostaErroreNonBloccante(messaggioRicevuto);

        } else if (isMessaggioOK(messaggioRicevuto))

            switch (messaggioInviato.getTipologiaMessaggio()

            )
            {
                case 7:     //COMUNICA COMUNICAEVENTOSPECIALISTICO
                    if (messaggioInviato.getContenuto().contains("<tipoOperazione>1</tipoOperazione>") || messaggioInviato.getContenuto().contains("<tipoOperazione>3</tipoOperazione>"))
                    {
                        impostaStatoErogazioneSuRicetta(messaggioRicevuto);

                    }
                    break;

                case 8:     //COMUNICA ANNULLAEVENTOSPECIALISTICO
                    if (messaggioInviato.getContenuto().contains("<codAnnullamento>3</codAnnullamento>"))
                    {
                        impostaBloccoInStruttura(messaggioInviato);

                    } else if (messaggioInviato.getContenuto().contains("<codAnnullamento>1</codAnnullamento>") && isMessaggioAnnullamentoSenzaPrestazioni(messaggioInviato))
                    {
                        impostaStatoErogazioneSuRicetta(messaggioRicevuto);
                    } else
                    {
                        System.out.println("Non faccio niente");
                    }
                    break;

                case 23, 26:    //COMUNICA SBLOCCO IN STRUTTURA
                    impostaBloccoInStruttura(messaggioInviato);
                    break;

                case 24:    //COMUNICA BLOCCO IN REGIONE
                    impostaBloccoInRegione(messaggioInviato);
                    break;
                case 25:    //COMUNICA SBLOCCO IN REGIONE
                   impostaSbloccoInRegione(messaggioInviato);
                    break;

                default:
                    break;
            }
        else if (isCondizioneMessaggioSoapFault(messaggioRicevuto))
        {
            impostaErroreSoapFault(messaggioRicevuto);
        } else
        {
            impostaErroreSconosciuto(messaggioRicevuto);
        }
    }
}
