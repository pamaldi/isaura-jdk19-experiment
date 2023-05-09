package cloud.isaura.experimental.adt;

import java.util.random.RandomGenerator;

public class AdtMain
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
        String messaggioInviato = """
                <?xml version="1.0" encoding="UTF-8"?>
                <m:MIA.comunicaEventoSpecialistico xmlns:m="http://www.crs.lombardia.it/schemas/PS_R/SISSWAY/2015-01/comunicaEventoSpecialistico/"
                                                   dataSetVersion="1.0">
                   <appl>CUP</appl>
                   <listaEventi>
                      <eventoAccettazione>
                         <idEvento>1</idEvento>
                         <codiceRegioneErogatore>030</codiceRegioneErogatore>
                         <datiStruttura>
                            <idStruttura>030702</idStruttura>
                            <idSubStruttura/>
                         </datiStruttura>
                         <datiCittadino>
                            <idAnag>28654900</idAnag>
                            <codiceFiscale>ZMPSRN35D63B485K</codiceFiscale>
                            <cognomeCittadino>ZAMPIERI</cognomeCittadino>
                            <nomeCittadino>ESTERINA ALBINA</nomeCittadino>
                            <sessoCittadino>F</sessoCittadino>
                            <dataNascitaCittadino>19350423</dataNascitaCittadino>
                         </datiCittadino>
                         <calcolaIUP>N</calcolaIUP>
                         <NRE>0300A4111581001</NRE>
                         <numeroCartellaAmbulatoriale>20232218450</numeroCartellaAmbulatoriale>
                         <tipoOperazione>2</tipoOperazione>
                         <idProvenienzaPaziente>2</idProvenienzaPaziente>
                         <idEsenzione>019.365.1</idEsenzione>
                         <medicoRichiedente>
                            <codiceFiscale>RSSLMR64E18F704H</codiceFiscale>
                         </medicoRichiedente>
                         <tipoErogazioneSpec>D</tipoErogazioneSpec>
                         <quesitoDiagnostico>post capusolotomia</quesitoDiagnostico>
                         <quotaFissa>0.00</quotaFissa>
                         <franchigia>0.00</franchigia>
                         <dataSpedizione>2023-05-08 17:48:55</dataSpedizione>
                         <elencoDettagliPrescrInviiErogato>
                            <dettaglioPrescrizioneInvioErogato>
                               <codProdPrestSISS>3495091</codProdPrestSISS>
                               <codProdPrestErogSISS>3495091</codProdPrestErogSISS>
                               <flagAggiuntiva>N</flagAggiuntiva>
                               <descrProdPrestErog>ESAME DEL FUNDUS OCULI  95.09.1</descrProdPrestErog>
                               <codBranca>34</codBranca>
                               <prezzo>7.90</prezzo>
                               <quantitaErogata>1</quantitaErogata>
                               <dataIniErog>2023-05-08 17:48:55</dataIniErog>
                               <dataFineErog>2023-05-08 17:48:55</dataFineErog>
                               <prezzoRimborso>0.00</prezzoRimborso>
                               <codPresidio>702002265</codPresidio>
                               <garanziaTempiMax>0</garanziaTempiMax>
                               <dataPrenotazione>2023-04-28 00:00:00</dataPrenotazione>
                            </dettaglioPrescrizioneInvioErogato>
                         </elencoDettagliPrescrInviiErogato>
                      </eventoAccettazione>
                   </listaEventi>
                </m:MIA.comunicaEventoSpecialistico>
                                
                                    """;




    }
}
