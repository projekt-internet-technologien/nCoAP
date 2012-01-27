package de.uniluebeck.itm.spitfire.nCoap.message.header;

import de.uniluebeck.itm.spitfire.nCoap.message.options.OptionRegistry;

import java.util.Arrays;
import java.util.List;

/**
 * This enumeration contains all defined message codes (i.e. methods for requests and status for responses)
 * in CoAPs draft v7
 *@author Oliver Kleine
*/

public enum Code {

    /**
     * corresponds to CoAPs numerical message code 0
     */
    GET(1, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.URI_HOST,
                            OptionRegistry.OptionName.URI_PATH,
                            OptionRegistry.OptionName.URI_PORT,
                            OptionRegistry.OptionName.URI_QUERY,
                            OptionRegistry.OptionName.PROXY_URI,
                            OptionRegistry.OptionName.ACCEPT,
                            OptionRegistry.OptionName.ETAG,
                            OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 1
     */
    POST(2, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.URI_HOST,
                             OptionRegistry.OptionName.URI_PATH,
                             OptionRegistry.OptionName.URI_PORT,
                             OptionRegistry.OptionName.URI_QUERY,
                             OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 2
     */
    PUT(3, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.URI_HOST,
                            OptionRegistry.OptionName.URI_PATH,
                            OptionRegistry.OptionName.URI_PORT,
                            OptionRegistry.OptionName.URI_QUERY,
                            OptionRegistry.OptionName.CONTENT_TYPE,
                            OptionRegistry.OptionName.IF_MATCH,
                            OptionRegistry.OptionName.IF_NONE_MATCH,
                            OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 3
     */
    DELETE(4, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.URI_HOST,
                               OptionRegistry.OptionName.URI_PATH,
                               OptionRegistry.OptionName.URI_PORT,
                               OptionRegistry.OptionName.URI_QUERY,
                               OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 65
     */
    CREATED_201(65, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.CONTENT_TYPE,
                                     OptionRegistry.OptionName.LOCATION_PATH,
                                     OptionRegistry.OptionName.LOCATION_QUERY,
                                     OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 66
     */
    DELETED_202(66, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.CONTENT_TYPE,
                                     OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 67
     */
    VALID_203(67, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.ETAG,
                                   OptionRegistry.OptionName.MAX_AGE,
                                   OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 68
     */
    CHANGED_204(68, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.CONTENT_TYPE,
                                     OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 69
     */
    CONTENT_205(69, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.CONTENT_TYPE,
                                     OptionRegistry.OptionName.MAX_AGE,
                                     OptionRegistry.OptionName.ETAG,
                                     OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 128
     */
    BAD_REQUEST_400(128, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.MAX_AGE,
                                          OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 129
     */
    UNAUTHORIZED_401(129, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.MAX_AGE,
                                           OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 130
     */
    BAD_OPTION_402(130, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.MAX_AGE,
                                         OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 131
     */
    FORBIDDEN_403(131, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.MAX_AGE,
                                        OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 132
     */
    NOT_FOUND_404(132, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.MAX_AGE,
                                        OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 133
     */
    METHOD_NOT_ALLOWED_405(133, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.MAX_AGE,
                                                 OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 140
     */
    PRECONDITION_FAILED_412(140, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.MAX_AGE,
                                                  OptionRegistry.OptionName.TOKEN}),
    /**
     * corresponds to CoAPs numerical message code 141
     */
    REQUEST_ENTITY_TOO_LARGE_413(141, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.MAX_AGE,
                                                       OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 143
     */
    UNSUPPORTED_MEDIA_TYPE_415(143, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.MAX_AGE,
                                                     OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 160
     */
    INTERNAL_SERVER_ERROR_500(160, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.MAX_AGE,
                                                    OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 161
     */
    NOT_IMPLEMENTED_501(161, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.MAX_AGE,
                                              OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 162
     */
    BAD_GATEWAY_502(162, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.MAX_AGE,
                                          OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 163
     */
    SERVICE_UNAVAILABLE_503(163, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.MAX_AGE,
                                                  OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 164
     */
    GATEWAY_TIMEOUT_504(164, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.MAX_AGE,
                                              OptionRegistry.OptionName.TOKEN}),

    /**
     * corresponds to CoAPs numerical message code 165
     */
    PROXYING_NOT_SUPPORTED_505(165, new OptionRegistry.OptionName[]{OptionRegistry.OptionName.MAX_AGE,
                                                     OptionRegistry.OptionName.TOKEN});

    /**
     * The corresponding numerical CoAP message code
     */
    public final int number;
    private final List allowedOptions;

    Code(int number, OptionRegistry.OptionName[] allowedOptions){
        this.number = number;
        this.allowedOptions = Arrays.asList(allowedOptions);
    }

    /**
     * This method is to check whether the specified option is meaningful in the context
     * of the current message code
     * @param opt_name
     * @return <code>true</code> if the given is meaningful in the context of the message code,
     * <code>false</false> otherwise
     */
    public boolean isMeaningful(OptionRegistry.OptionName opt_name){
        if(allowedOptions.contains(opt_name)){
            return true;
        }
        return false;
    }

    /**
     * This method indicates wheter the message code refers to a request or a response
     * @return <code>true</code> in case of a request code, <code>false</code> in case of response code
     */
    public boolean isRequest(){
        if(number < 5){
            return true;
        }
        return false;
    }

    /**
     * This method indicates whether a message may contain payload
     * @return <code>true</code> if payload is allowed, <code>false</code> otherwise
     */
    public boolean allowsPayload(){
        if(number == Code.GET.number || number == Code.DELETE.number){
            return false;
        }
        return true;
    }

    public static Code getCodeFromNumber(int number){
        for(Code c : Code.values()){
            if(c.number == number){
                return c;
            }
        }
        return null;
    }
}

