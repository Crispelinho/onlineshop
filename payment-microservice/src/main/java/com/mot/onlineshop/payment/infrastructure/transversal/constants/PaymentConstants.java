package com.mot.onlineshop.payment.infrastructure.transversal.constants;

import lombok.AllArgsConstructor;

public class PaymentConstants {
    //Constants by comments
    public static final String BASE_PAYU_URL = "https://sandbox.api.payulatam.com/";
    public static final String REQUEST_IN_CONTROLLER = "Se recibe request en controller: ";
    public static final String REQUEST_DTO_TO_MODEL = "Se mapea Request DTO a model: ";
    public static final String CREATE_COMMAND = "Se crea command: ";
    public static final String CREATE_QUERY = "Se crea query: ";
    public static final String REQUEST_MODEL_TO_DTO = "Se mapea Request model a DTO: ";
    public static final String COMMAND_TO_COMMAND_BUS = "Se envía command al commandBus: ";
    public static final String QUERY_TO_QUERYBUS = "Se envía query al querybus";
    public static final String TRANSACTION_TYPE_AUTH_AND_CAPT = "AUTHORIZATION_AND_CAPTURE";
    public static final String TRANSACTION_TYPE_VOID = "VOID";
    public static final String TRANSACTION_CODE_SUCCESS = "SUCCESS";
    public static final String FIND_ORDER_WITH_ORDER_REFERENCE = "Find order with Order Reference:";
    public static final String FIND_PERSON_WITH_PERSON_ID = "Find person with Person id:";
    public static final String FIND_PROVIDER_WITH_REFERENCE = "Find provider with reference:";
    public static final String UUID_REFERENCE_VALIDATION_PATTERN = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$";

    //RESPONSE CODES
    public static final String RESPONSE_CODE_PAGE_ERROR = "ERROR";
    public static final String RESPONSE_CODE_PAGE_APPROVED = "APPROVED";
    public static final String RESPONSE_CODE_PAGE_DECLINED = "DECLINED";
    public static final String RESPONSE_CODE_PAGE_EXPIRED = "EXPIRED";
    public static final String RESPONSE_CODE_PAGE_PENDING = "PENDING";

    //TRANSACTION STATES
    public static final String TRANSACTION_ERROR = "ERROR";
    public static final String TRANSACTION_IN_PROCESS_PAYMENT = "SEND_PAYMENT";
    public static final String TRANSACTION_IN_PROCESS_REFUND = "SEND_REFUND";
    public static final String TRANSACTION_APPROVED = "APPROVED";
    public static final String TRANSACTION_DECLINED = "DECLINED";
    public static final String TRANSACTION_EXPIRED = "EXPIRED";
    public static final String TRANSACTION_PENDING = "PENDING";
    public static final String TRANSACTION_SUBMITTED = "SUBMITTED";

    //PAYMENT_PROVIDERS
    public static final String PAYMENT_PROVIDER_PAYU = "PAYU";

    //COMMANDS
    public static final String COMMAND_SUBMIT_TRANSACTION = "SUBMIT_TRANSACTION";
    public static final String COMMAND_PING = "PING";
    public static final String COMMAND_GET_PAYMENT_METHODS = "GET_PAYMENT_METHODS";
    public static final String COMMAND_GET_BANKS_LIST = "GET_BANKS_LIST";

    public static final String REQUEST_IS_VALIDATED = "Se valida request: ";
    public static final String LANGUAGE_ES = "es";


};
