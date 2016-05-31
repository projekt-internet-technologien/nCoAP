/**
 * Copyright (c) 2012, Oliver Kleine, Institute of Telematics, University of Luebeck
 * All rights reserved
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 *  - Redistributions of source messageCode must retain the above copyright notice, this list of conditions and the following
 *    disclaimer.
 *
 *  - Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 *    following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 *  - Neither the name of the University of Luebeck nor the names of its contributors may be used to endorse or promote
 *    products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package de.uniluebeck.itm.ncoap.examples;

import java.net.InetSocketAddress;
import java.net.URI;

import de.uniluebeck.itm.ncoap.application.client.CoapClientApplication;
import de.uniluebeck.itm.ncoap.application.server.CoapServerApplication;
import de.uniluebeck.itm.ncoap.message.CoapRequest;
import de.uniluebeck.itm.ncoap.message.MessageCode;
import de.uniluebeck.itm.ncoap.message.MessageType;

/**
 * Created by olli on 30.03.14.
 */
public class SimpleCoapServer extends CoapServerApplication {

	// Main SSP at the ITM with default port
	private static String SSP_HOST = "141.83.151.196";
	private static int SSP_PORT = CoapServerApplication.DEFAULT_COAP_SERVER_PORT;
	
	// Local SSP with port 22222
	//private static String SSP_HOST = "127.0.0.1";
	//private static int SSP_PORT = 22222;
	
	public SimpleCoapServer() {
		// TODO Auto-generated constructor stub
	}
	
    public static void main(String[] args) throws Exception {
        LoggingConfiguration.configureDefaultLogging();

        SimpleCoapServer server = new SimpleCoapServer(); 

        // Non-Obserable resource, e.g., for static data
        SimpleNotObservableWebservice simpleWebservice = new SimpleNotObservableWebservice("/simple", "Some payload...", 5000, server.getExecutor());
        server.registerService(simpleWebservice);

        // Obserable resource, e.g., for dynamic data
        SimpleObservableTimeService timeService = new SimpleObservableTimeService("/utc-time", 1000, server.getExecutor());
        server.registerService(timeService);

        // Initial call to the SSP to initialize the observation
		URI webserviceURI = new URI("coap://" + SSP_HOST + ":" + SSP_PORT + "/registry");
		CoapRequest coapRequest = new CoapRequest(MessageType.Name.CON, MessageCode.Name.POST, webserviceURI, false);
		SimpleCallback responseProcessor = new SimpleCallback();
		InetSocketAddress recipient = new InetSocketAddress(SSP_HOST, SSP_PORT);
		CoapClientApplication c = new CoapClientApplication();
		c.sendCoapRequest(coapRequest, responseProcessor, recipient);
    }

}
