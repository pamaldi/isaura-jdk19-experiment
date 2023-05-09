package cloud.isaura.experimental.adt;

public sealed interface Notifica permits NotificaPositiva, NotificaErroreInternoSiss, NotificaNonBloccante, NotificaSoapFault
{
        String contenuto();
}
