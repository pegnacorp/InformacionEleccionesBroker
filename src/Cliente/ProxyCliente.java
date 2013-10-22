package Cliente;

import Servidor.Candidato;
import Servidor.*;

import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.IOException;

import java.net.UnknownHostException;

public class ProxyCliente {

    private Candidato candidato;
    private String mensaje;
    private ProxyServidor proxyServidor;
    private ClienteTCP clientetcp;

    public ProxyCliente() throws UnknownHostException, IOException {
        proxyServidor = new ProxyServidor();
        clientetcp = new ClienteTCP();
    }

    public void recibirMensaje(Candidato candidato) {
        this.candidato = candidato;

    }

    /**
     * Método que traducirá lo enviado en un xml
     */
    public void empaquetarDatos() {
        XStream xstream = new XStream(new DomDriver());
//[1] alias opcionales
        xstream.alias("candidato", Candidato.class);
        mensaje = xstream.toXML(candidato);




//        XStream xstream = new XStream(new JettisonMappedXmlDriver());
//        xstream.setMode(XStream.NO_REFERENCES);
//        xstream.alias("candidato", Candidato.class);
//        System.out.println(xstream.toXML(candidato));	
//        mensaje = xstream.toXML(candidato);
//Convertir en xml
//        XStream xStream = new XStream(new DomDriver());
//        mensaje = xStream.toXML(candidato);
//        System.out.println(mensaje);

    }

    /**
     * Método que traducirá lo recibido en una clase
     */
    public void desempaquetarDatos() {
    }

    /**
     * Método que enviará el mensaje al servidor      *
     */
    public void enviarMensaje() throws IOException {
        clientetcp.enviarMensaje(mensaje);
    }
}