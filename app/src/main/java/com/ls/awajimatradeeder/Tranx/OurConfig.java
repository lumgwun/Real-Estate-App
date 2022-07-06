package com.ls.awajimatradeeder.Tranx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OurConfig {
    public static final String PAYSTACK_PLAN_CREATE_URL = "https://api.paystack.co/plan";
    public static final String SKYLIGHT_PAYSTACK_ACCT_RESOLVE = "https://api.paystack.co/bank/resolve?account_number=";
    public static final String CREATE_CUSTOMER = "https://api.paystack.co/customer";
    public static final String QUICKTELLER_KYC = "https://kyc-service.k8.isw.la/api/v1/verifications";
    public static final String QUICKTELLER_CREDIT_REPORT = "https://sandbox.interswitchng.com/lending-service/api/v1/credit-report";
    public static final String INTERSWITCH_LS_SECRET_KEY = "1Z9nbdpn7cQBMXXwrhxU8v6aqwpdX+E06+eg4lFOc04=";
    public static final String PAYSTACK_CREATE_TRANSFER_RECEPIENT = "https://api.paystack.co/transferrecipient";
    public static final String PAYSTACK_EXECUTE_TRANSFER = "https://api.paystack.co/transferrecipient";



    private static Environment Environment;

    public static final OurConfig.Environment ENVIRONMENT = OurConfig.Environment;

    public enum Environment {
        STAGING,
        LIVE
    }
    public static final String LIVE_URL = "https://api.ravepay.co/v2/services/confluence";
    public static final String CAPTURE_URL = "https://api.ravepay.co/flwv3-pug/getpaidx/api/capture";
    public static final String VOID_URL = "https://api.ravepay.co/flwv3-pug/getpaidx/api/refundorvoid";
    public static final String BUY_SERVICE = "fly_buy";
    public static final String SKYLIGHT_PAYSTACK_PLAN_UPDATE = "https://api.paystack.co/plan/:";
    public static final String SERVICE_METHOD_POST = "post";
    public static final String SKYLIGHT_SECRET_KEY = "FLWSECK-6fbb0917bddb806a0acfefbaba59e8c7-X";
    public static final String SKYLIGHT_PUBLIC_KEY = "FLWPUBK-a566e27375959648ef33e9d4121b409a-X";
    public static final String OUR_PUBLIC_KEY = "FLWPUBK-a566e27375959648ef33e9d4121b409a-X";
    public static final String OUR_SECRET_KEY = "FLWSECK-6fbb0917bddb806a0acfefbaba59e8c7-X";
    public static final String ENK = "6fbb0917bddb3aaefc7b5ff5";
    public static final String EBILLS_URL = "https://api.ravepay.co/flwv3-pug/getpaidx/api/ebills/";
    public static final String BILLS_PAYMENT_URL = "https://api.flutterwave.com/v3/bills/";
    public static final String CHARGE_VIA_BANK = "https://api.flutterwave.com/v3/charges?type=bank_transfer";
    public static final String CHARGE_VIA_UK_BANK = "https://api.flutterwave.com/v3/charges?type=debit_uk_account";
    public static final String CHARGE_CARD = "https://api.flutterwave.com/v3/charges";
    public static final String CHARGE_VIA_GHANA_MM = "https://api.flutterwave.com/v3/charges?type=mobile_money_ghana";
    public static final String CHARGE_VIA_RW = "https://api.flutterwave.com/v3/charges?type=mobile_money_rwanda";
    public static final String CHARGE_VIA_UG = "https://api.flutterwave.com/v3/charges?type=mobile_money_uganda";
    public static final String CHARGE_VIA_ZAMBIA_MM = "https://api.flutterwave.com/v3/charges?type=mobile_money_zambia";
    public static final String CHARGE_NG_ACCT = "https://api.flutterwave.com/v3/charges?type=debit_ng_account";
    public static final String CHARGE_VIA_FRANC = "https://api.flutterwave.com/v3/charges?type=mobile_money_franco";
    public static final String GET_ALL_TRANSACTIONS = "https://api.flutterwave.com/v3/transactions";
    public static final String CHECK_TRANSFER_RATE = "https://api.flutterwave.com/v3/transfers/rates";
    public static final String CREATE_A_VIRTUAL_CARD = "https://api.flutterwave.com/v3/virtual-cards";
    public static final String CREATE_A_VIRTUAL_ACCTNO = "https://api.flutterwave.com/v3/virtual-account-numbers";
    public static final String CREATE_PAYMENT_PLAN = "https://api.flutterwave.com/v3/payment-plans";
    public static final String GET_ALL_SUBSCRIPTIONS = "https://api.flutterwave.com/v3/subscriptions";
    public static final String CANCEL_A_SUBSCRIPTION = "https://api.flutterwave.com/v3/subscriptions/id/cancel";
    public static final String CREATE_SUBACCT = "https://api.flutterwave.com/v3/subaccounts";
    public static final String BILLS_CATEGORY = "https://api.flutterwave.com/v3/bill-categories";
    public static final String GET_BILL_STATUS = "https://api.flutterwave.com/v3/bills/reference";
    public static final String GET_BILL_PAYMENTS = "https://api.flutterwave.com/v3/bills";
    public static final String GET_BANKS_IN_NIGERIA = "https://api.flutterwave.com/v3/banks/NG";
    public static final String GET_BANKS_IN_GHANA = "https://api.flutterwave.com/v3/banks/GH";
    public static final String GET_BANKS_IN_KENYA = "https://api.flutterwave.com/v3/banks/KE";
    public static final String GET_BANKS_IN_UGANDA = "https://api.flutterwave.com/v3/banks/UG";
    public static final String GET_BANKS_IN_SOUTH_AFRICA = "https://api.flutterwave.com/v3/banks/ZA";
    public static final String GET_BANKS_IN_TANZANIA = "https://api.flutterwave.com/v3/banks/TZ";
    public static final String GET_BANK_BRANCHES_FROM_ID = "https://api.flutterwave.com/v3/banks/id/branches";
    public static final String GET_WALLET_BALANCES = "https://api.flutterwave.com/v3/balances";
    public static final String GET_NAIRA_BALANCES = "https://api.flutterwave.com/v3/balances/currency";
    public static final String RESOLVE_ACCOUNT = "https://api.flutterwave.com/v3/accounts/resolve";
    public static final String RESOLVE_BVN = "https://api.flutterwave.com/v3/kyc/bvns/bvn";
    public static final String RESOLVE_CARD_BIN = "https://api.flutterwave.com/v3/card-bins/bin";
    public static final String CURRENCY_CONVERSION = "https://api.flutterwave.com/v3/rates";
    public static final String CREATE_OTP = "https://api.flutterwave.com/v3/otps";
    public static final String VALIDATE_OTP = "https://api.flutterwave.com/v3/otps/reference/validate";
    public static final String LIST_ALL_CHARGE_BACK = "https://api.flutterwave.com/v3/chargebacks";
    public static final String SERVICE_METHOD_GET = "get";
    public static final String SERVICE_VERSION = "v1";
    public static final String PUBLIC_KEY_PAYSTACK = "pk_live_e71feb3d8f41ceccd2cb26c670e62ceb54113412";
    public static final String SECRET_KEY_PAYSTACK = "v1";
    public static final String SERVICE_CHANNEL = "rave";
    public static final String AIRTIME_BILLERNAME = "AIRTIME";
    public static final String DSTV_BILLERNAME = "DSTV";
    public static final String WEB_HOOK = "https://skylightciacs.com/wc-api/Tbz_WC_Paystack_Webhook/";
    public static final String DSTV_BOX_OFFICE_BILLERNAME = "DSTV BOX OFFICE";
    public static final String LIVE_CHARGE_URL = "https://api.ravepay.co/flwv3-pug/getpaidx/api/charge";
    public static final String LIVE_CHARGE_URL_2 = "https://api.flutterwave.com/v3/charges";

    public static final String REDIRECT_URL = "https://skylightciacs.com/wc-api/Tbz_WC_Paystack_Webhook/";
    public static final String alg = "3DES-24";
    public static final String SUSCRIPTION_LIST_URL = "https://api.ravepay.co/v2/gpx/subscriptions/query";
    public static final String SUSCRIPTION_URL = "https://api.ravepay.co/v2/gpx/subscriptions/";
    public static final String LIVE_REFUND_URL = "https://api.ravepay.co/gpx/merchant/transactions/refund";
    public static final String PAYMENT_PLAN_CREATE_LIVE_URL = "https://api.ravepay.co/v2/gpx/paymentplans/create";
    public static final String PAYMENT_PLAN_LIVE_URL = "https://api.ravepay.co/v2/gpx/paymentplans/query";
    public static final String PAYMENT_PLAN_CANCEL_LIVE_URL = "https://api.ravepay.co/v2/gpx/paymentplans/";
    public static final String BVN_LIVE = "https://api.ravepay.co/v2/kyc/bvn";
    public static final String LIVE_VIRTUAL_CARD_CREATE_URL = "https://api.ravepay.co/v2/services/virtualcards/new";
    public static final String LIVE_VIRTUAL_CARD_FUND_URL = "https://api.ravepay.co/v2/services/virtualcards/fund";
    public static final String EBILLS_LIVE_URL = "https://api.ravepay.co/flwv3-pug/getpaidx/api/ebills/";
    public static final String SUBACCOUNT_LIST_URL = "https://api.ravepay.co/v2/gpx/subaccounts";
    //    public static final String SETTLEMENT_URL_LIVE = "https://ravesandboxapi.flutterwave.com/v2/merchant/settlements";
    public static final String TRANSACTION_VERIFICATION_URL_LIVE = "https://api.ravepay.co/flwv3-pug/getpaidx/api/v2/verify";
    public static final String TRANSFER_URL = "https://api.ravepay.co/v2/gpx/transfers/";
    public static final String VALIDATE_CHARGE_URL = "https://api.ravepay.co/flwv3-pug/getpaidx/api/validatecharge";
    public static final String TOKENIZED_CHARGE_URL_LIVE = "https://api.ravepay.co/flwv3-pug/getpaidx/api/tokenized/charge";
    public static final String TOKEN_UPDATE_URL_LIVE = "https://api.ravepay.co/flwv3-pug/getpaidx/api/tokenized/update_customer";

    public static final String TWILIO_ACCOUNT_SID = "AC5e05dc0a793a29dc1da2eabdebd6c28d";
    public static final String TWILIO_AUTH_TOKEN = "39410e8b813c131da386f3d7bb7f94f7";
    //public static final String ENVIRONMENT = "";

    private final static String BASE_API_ENDPOINT = "https://api.paystack.co";
    private final static String FLUTTERWAVE_BASE_API_ENDPOINT = "https://api.paystack.co";

    public static final String PAYSTACK_INLINE_PAYSTACK_STANDARD = BASE_API_ENDPOINT + "/transaction/initialize";
    public static final String PAYSTACK_INLINE_VERIFY_TRANSACTIONS = BASE_API_ENDPOINT + "/transaction/verify/";
    public static final String PAYSTACK_INLINE_CHARGE_AUTHORIZATION = BASE_API_ENDPOINT + "/transaction/charge_authorization";

    //URL definitions for customer endpoint
    public static final String PAYSTACK_CUSTOMERS_CREATE_CUSTOMER = BASE_API_ENDPOINT + "/customer";
    public static final String PAYSTACK_CUSTOMERS_LIST_CUSTOMERS = BASE_API_ENDPOINT + "/customer";
    public static final String PAYSTACK_CUSTOMERS_FETCH_CUSTOMER = BASE_API_ENDPOINT + "/customer/";
    public static final String PAYSTACK_CUSTOMERS_UPDATE_CUSTOMER = BASE_API_ENDPOINT + "/customer/";

    //URL definitions for transaction endpoints
    public static final String PAYSTACK_TRANSACTIONS_INITIALIZE_TRANSACTION = BASE_API_ENDPOINT + "/transaction/initialize";
    public static final String PAYSTACK_TRANSACTIONS_VERIFY_TRANSACTION = BASE_API_ENDPOINT + "/transaction/verify/";
    public static final String PAYSTACK_TRANSACTIONS_LIST_TRANSACTIONS = BASE_API_ENDPOINT + "/transaction";
    public static final String PAYSTACK_TRANSACTIONS_FETCH_TRANSACTION = BASE_API_ENDPOINT + "/transaction/";
    public static final String PAYSTACK_TRANSACTIONS_CHARGE_AUTHORIZATION = BASE_API_ENDPOINT + "/transaction/charge_authorization";
    public static final String PAYSTACK_TRANSACTIONS_CHARGE_TOKEN = BASE_API_ENDPOINT + "/transaction/charge_token";
    public static final String PAYSTACK_TRANSACTIONS_EXPORT_TRANSACTIONS = BASE_API_ENDPOINT + "/transaction/export";

    //URL definitions for plan endpoint
    public static final String PAYSTACK_PLANS_CREATE_PLAN = BASE_API_ENDPOINT + "/plan";
    public static final String PAYSTACK_PLANS_LIST_PLANS = BASE_API_ENDPOINT + "/plan";
    public static final String PAYSTACK_PLANS_FETCH_PLAN = BASE_API_ENDPOINT + "/plan/";
    public static final String PAYSTACK_PLANS_UPDATE_PLAN = BASE_API_ENDPOINT + "/plan/";

    //URL definitions for subscription endpoints
    public static final String PAYSTACK_SUBSCRIPTIONS_CREATE_SUBSCRIPTION = BASE_API_ENDPOINT + "/subscription";
    public static final String PAYSTACK_SUBSCRIPTIONS_DISABLE_SUBSCRIPTION = BASE_API_ENDPOINT + "/subscription/disable";
    public static final String PAYSTACK_SUBSCRIPTIONS_ENABLE_SUBSCRIPTION = BASE_API_ENDPOINT + "/subscription/enable";
    public static final String PAYSTACK_SUBSCRIPTIONS_FETCH_SUBSCRIPTION = BASE_API_ENDPOINT + "/subscription/";

    //URL definitions for page endpoint
    public static final String PAYSTACK_PAGES_CREATE_PAGE = BASE_API_ENDPOINT + "/page";
    public static final String PAYSTACK_PAGES_LIST_PAGES = BASE_API_ENDPOINT + "/page";
    public static final String PAYSTACK_PAGES_FETCH_PAGE = BASE_API_ENDPOINT + "/page/";
    public static final String PAYSTACK_PAGES_UPDATE_PAGE = BASE_API_ENDPOINT + "/page/";

    public static final int SAVED_CARD_CHARGE = 5699;

    public static final int RESULT_SUCCESS = 111;
    public static final int RESULT_ERROR = 222;
    public static final int RESULT_CANCELLED = 333;

    public static final int RAVE_REQUEST_CODE = 4199;
    public static final int OTP_REQUEST_CODE = 5399;
    public static final int WEB_VERIFICATION_REQUEST_CODE = 5340;
    public static final int BARTER_CHECKOUT_REQUEST_CODE = 5341;
    public static final int PIN_REQUEST_CODE = 5342;
    public static final int ADDRESS_DETAILS_REQUEST_CODE = 5343;
    public static final int MANUAL_CARD_CHARGE = 403;

    public static String PUBLIC_KEY_TEST = "FLWPUBK-e634d14d9ded04eaf05d5b63a0a06d2f-X"; //test
    public static String ENCRYPTION_KEY_TEST = "bb9714020722eb4cf7a169f2";//test
    //    public static String STAGING_URL = "https://ravesandbox.azurewebsites.net";
//    public static String LIVE_URL = "https://raveapi.azurewebsites.net";
    public static String STAGING_URL = "https://ravesandboxapi.flutterwave.com";
    public static String LIVE_URL1 = "https://api.ravepay.co";
    public static String CHARGE_BANK_TRANSFER = "https://api.flutterwave.com/v3/charges?type=bank_transfer";

    public static String CHARGE_CARD_1 = "https://api.flutterwave.com/v3/charges?type=card";
    public static String CHARGE_USSD = "https://api.flutterwave.com/v3/charges?type=ussd";
    public static String CHARGE_ACCT = " https://api.flutterwave.com/v3/charges?type=debit_ng_account";

    public static String CARD_CHECK_URL = "https://9wd5x7szl1.execute-api.eu-west-2.amazonaws.com";
    public static String EVENT_LOGGING_URL = "https://kgelfdz7mf.execute-api.us-east-1.amazonaws.com/";
    public static String FLUTTERWAVE_UK_ACCOUNT = "43271228";
    public static String FLUTTERWAVE_UK_SORT_CODE = "04-00-53";
    public static String FLUTTERWAVE_UK_BENEFICIARY_NAME = "Barter Funding";


    public static String VBV = "VBVSECURECODE";
    public static String GTB_OTP = "GTB_OTP";
    public static String ACCESS_OTP = "ACCESS_OTP";
    public static String NG = "NG";
    public static String NGN = "NGN";
    public static String UGX = "UGX";
    public static String RWF = "RWF";
    public static String NOAUTH = "NOAUTH";
    public static String NOAUTH_SAVED_CARD = "noauth-saved-card";
    public static String PIN = "PIN";
    public static String selectNetwork = "Select network";
    public static String AVS_VBVSECURECODE = "AVS_VBVSECURECODE";
    public static String enterOTP = "Enter your one time password (OTP)";
    public static String NOAUTH_INTERNATIONAL = "NOAUTH_INTERNATIONAL";
    public static String RAVEPAY = "ravepay";
    public static String RAVE_PARAMS = "raveparams";
    public static String RAVE_3DS_CALLBACK = "https://rave-webhook.herokuapp.com/receivepayment";
    public static int TOKEN_CHARGE = 24;
    public static String fieldAmount = "amount";
    public static String fieldPhone = "phone";
    public static String fieldAccountName = "accountname";
    public static String fieldAccountBank = "accountbank";
    public static String fieldAccountNumber = "accountnumber";
    public static String fieldEmail = "email";
    public static String fieldAccount = "account";
    public static String fieldVoucher = "voucher";
    public static String fieldNetwork = "network";
    public static String networkPosition = "position";
    public static String fieldBVN = "bvn";
    public static String fieldDOB = "dob";
    public static String fieldBankCode = "bankcode";
    public static String fieldCvv = "cvv";
    public static String fieldCardExpiry = "cardExpiry";
    public static String fieldcardNoStripped = "cardNoStripped";
    public static String fieldUssdBank = "ussdbank";
    public static String date_of_birth = "Date of Birth";
    public static String isInternetBanking = "bankcode";

    public static String success = "success";
    public static String noResponse = "No response data was returned";
    public static String cardNotAllowed = "You can’t fund with cards from other countries yet. Please add a card issued in your country to proceed.";
    public static String invalidAccountNoMessage = "Enter a valid account number";
    public static String invalidDateOfBirthMessage = "Enter a valid date of birth";
    public static String invalidBvnMessage = "Enter a valid BVN";
    public static String invalidBankCodeMessage = "You need to select bank";
    public static String defaultAccounNumber = "0000000000";
    public static String inValidRedirectUrl = "Invalid redirect url returned";

    public static String response = "response";
    public static String mtn = "MTN";
    public static String tigo = "TIGO";
    public static String vodafone = "VODAFONE";
    public static String airtel = "AIRTEL";
    public static String zamtel = "ZAMTEL";

    public static String tokenNotFound = "token not found";
    public static String expired = "expired";
    public static String tokenExpired = "Token expired";
    public static String cardNoStripped = "cardNoStripped";
    public static String validAmountPrompt = "Enter a valid amount";
    public static String validPhonePrompt = "Enter a valid number";
    public static String validEmailPrompt = "Enter a valid Email";
    public static String validAccountNumberPrompt = "Enter a valid Account Number";
    public static String validAccountNamePrompt = "Enter a valid Account Name";
    public static String validBankNamePrompt = "Enter a valid Bank Name";
    public static String charge = "You will be charged a total of ";
    public static String askToContinue = ". Do you want to continue?";
    public static String yes = "YES";
    public static String no = "NO";
    public static String cancel = "CANCEL";
    public static String checkStatus = "Checking transaction status.  Please wait";
    public static String transactionError = "An error occurred while retrieving transaction fee";
    public static String validCvvPrompt = "Enter a valid cvv";
    public static String validExpiryDatePrompt = "Enter a valid expiry date";
    public static String validCreditCardPrompt = "Enter a valid card number";
    public static String validVoucherPrompt = "Enter a valid voucher code";
    public static String validNetworkPrompt = "Select a network";
    public static String invalidChargeCode = "Invalid charge response code";
    public static String invalidCharge = "Invalid charge card response";
    public static String unknownAuthmsg = "Unknown Auth Model";
    public static String unknownResCodemsg = "Unknown charge response code";
    public static String no_authurl_was_returnedmsg = "No authUrl was returned";
    public static String wait = "Please wait...";
    public static String cancelPayment = "CANCEL PAYMENT";
    public static String bankNameGtb = "Guaranty Trust Bank";
    public static final String BARTER_CHECKOUT = "barter";

    public static final int PAYMENT_TYPE_CARD = 101;
    public static final int PAYMENT_TYPE_ACCOUNT = 102;
    public static final int PAYMENT_TYPE_GH_MOBILE_MONEY = 103;
    public static final int PAYMENT_TYPE_RW_MOBILE_MONEY = 104;
    public static final int PAYMENT_TYPE_MPESA = 105;
    public static final int PAYMENT_TYPE_UG_MOBILE_MONEY = 106;
    public static final int PAYMENT_TYPE_ACH = 107;
    public static final int PAYMENT_TYPE_ZM_MOBILE_MONEY = 108;
    public static final int PAYMENT_TYPE_BANK_TRANSFER = 109;
    public static final int PAYMENT_TYPE_UK = 110;
    public static final int PAYMENT_TYPE_USSD = 111;
    public static final int PAYMENT_TYPE_FRANCO_MOBILE_MONEY = 112;
    public static final int PAYMENT_TYPE_BARTER = 113;
    public static final int PAYMENT_TYPE_SA_BANK_ACCOUNT = 114;

    public static HashMap<Integer, String> paymentTypesNamesList = new HashMap<Integer, String>() {{
        put(PAYMENT_TYPE_CARD, "Card");
        put(PAYMENT_TYPE_ACCOUNT, "Account");
        put(PAYMENT_TYPE_GH_MOBILE_MONEY, "Ghana Mobile Money");
        put(PAYMENT_TYPE_RW_MOBILE_MONEY, "Rwanda Mobile Money");
        put(PAYMENT_TYPE_UG_MOBILE_MONEY, "Uganda Mobile Money");
        put(PAYMENT_TYPE_ZM_MOBILE_MONEY, "Zambia Mobile Money");
        put(PAYMENT_TYPE_FRANCO_MOBILE_MONEY, "Francophone Mobile Money");
        put(PAYMENT_TYPE_MPESA, "M-Pesa");
        put(PAYMENT_TYPE_ACH, "ACH");
        put(PAYMENT_TYPE_BANK_TRANSFER, "Bank Transfer");
        put(PAYMENT_TYPE_UK, "UK Bank Account");
        put(PAYMENT_TYPE_BARTER, "Barter");
        put(PAYMENT_TYPE_USSD, "USSD");
        put(PAYMENT_TYPE_SA_BANK_ACCOUNT, "South Africa Bank Account");
    }};


    public static final String responseParsingError = "Error parsing server response";
    public static String errorParsingError = "An error occurred parsing the error response";
    public static String eTransact_GH = "ETRANZACT_GH";
}
