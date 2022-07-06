package com.ls.awajimatradeeder.Classes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.location.Address;
import android.net.Uri;
import android.provider.ContactsContract;

import com.google.android.gms.maps.model.LatLng;
import com.ls.awajimatradeeder.Database.DBHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;

import static com.ls.awajimatradeeder.Classes.NextOfKin.NOK_PROF_ID;
import static com.ls.awajimatradeeder.Classes.NextOfKin.NOK_TABLE;

@SuppressWarnings("InstantiationOfUtilityClass")
public class Profile {

    public static final String PROFILE_SURNAME = "P_surname";
    public static final String PROFILE_FIRSTNAME = "P_first_name";
    public static final String PROFILE_EMAIL = "P_email";
    public static final String PROFILE_DOB = "P_dob";
    public static final String PROFILE_ADDRESS = "P_address";
    public static final String PROFILE_GENDER = "P_gender";
    public static final String PROFILE_PHONE = "p_phone";
    public static final String PROFILE_ROLE = "p_role";
    public static final String PROFILE_DATE_JOINED = "p_join_date";
    public static final String PROFILE_NEXT_OF_KINID = "p_next_of_kinId";
    public static final String PROFILE_STATUS = "p_status";
    public static final String PROFILE_PASSWORD = "p_passCode";
    public static final String PROFILE_DEVICE_ID = "p_DeviceID";
    public static final String PROFILES_TABLE = "profiles_table";
    public static final String PROFILE_COUNTRY = "p_country";
    public static final String PROFILE_ID = "profile_id";

    public static final String PROFILE_PICTURE = "p_picture_uri";
    public static final String PROFILE_USERNAME = "p_username";
    public static final String PROFILE_ID_TYPE = "profile_ID_Type";
    public static final String PROFILE_IDENTITY = "profile_Identity";
    public static final String PROFILE_STATE = "p_state";
    public static final String PROFILE_OFFICE = "p_office";
    public static final String PROF_SPONSOR_ID = "prof_SponsorID";

    public static final String CREATE_PROFILES_TABLE = "CREATE TABLE " + PROFILES_TABLE + " (" + PROFILE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PROFILE_SURNAME + " TEXT, " + PROFILE_FIRSTNAME + " TEXT, " + PROFILE_PHONE + " TEXT, " + PROFILE_EMAIL + " TEXT, " + PROFILE_DOB + " TEXT, " + PROFILE_GENDER + " TEXT, " +
            PROFILE_ADDRESS + " TEXT, " + PROFILE_ID_TYPE + " TEXT, " + PROFILE_IDENTITY + " TEXT, "+ PROFILE_DEVICE_ID + " TEXT, " + PROFILE_NEXT_OF_KINID + " INTEGER, " + PROFILE_PICTURE + " TEXT, " + PROFILE_STATE + " TEXT, " + PROFILE_COUNTRY + " TEXT, " + PROFILE_OFFICE + " TEXT, " + PROFILE_DATE_JOINED + " TEXT, " + PROFILE_ROLE + " TEXT, " + PROFILE_USERNAME + " TEXT, " + PROFILE_PASSWORD + " TEXT, " + PROFILE_STATUS + " TEXT, " +  PROF_SPONSOR_ID + " INTEGER,"+ PROFILE_NEXT_OF_KINID + " INTEGER," + "FOREIGN KEY(" + PROFILE_NEXT_OF_KINID + ") REFERENCES " + NOK_TABLE + "(" + NOK_PROF_ID + "))";


    private String identity;
    private String identityType;

    private EOfficeBranch EOfficeBranch;
    private CashOut cashOut;
    private Guarantor guarantor;
    private DepositDoc depositDoc;
    private SupportMessage supportMessage;
    private InvestmentDeposit investmentDeposit;

    private int profileID =10122;

    int payeeID=0;
    int guarantorNo=0;
    private int profTranxID =1011;
    int invID=0;
    int timelineC=0;

    private String profileLastName;

    private String profileFirstName;
    private String profileUserType;


    private String profilePhoneNumber;

    private String profileEmail;

    private String profileDob;

    private String profileGender;

    private String profileAddress;

    private String profileOffice;

    private String profileDateJoined;


    private String profileState;


    private String profileRole;

    private String profileUserName;

    private String profilePassword;


    private int profileSponsorID;


    private int profNOKId;
    private  int messageC=0;
    private  int cashOutC=0;
    private int tranxCodeC=0;
    private int loanNumber=0;
    private int mCountNo=0;

    private String profileStatus;
    private String profileDeviceID;

    private Uri profilePicture;



    private ArrayList<Address> addresses;
    private ArrayList<MTradeAccount> MTradeAccounts;
    private ArrayList<Payee> payees;
    private ArrayList<TimeLine> timeLines;
    private ArrayList<Loan> loans;

    private ArrayList<TranxCode> tranxCodes;
    private ArrayList<DepositDoc> paymentDocArrayList;

    private ArrayList<AdminUser> adminUsers;
    private ArrayList<AdminBankDeposit> adminBankDeposits;

    private ArrayList<SOrder> standingOrders;
    private ArrayList<Transaction> transactions;
    private ArrayList<TimeLine> timeLineArrayList;
    private ArrayList<TellerReport> tellerReportArrayList;
    private ArrayList<Guarantor> guarantors;
    private ArrayList<InvestmentDeposit> investmentDeposits;
    private ArrayList<PayOutRequest> transactionGrantingArrayList;
    private ArrayList<SupportMessage> supportMessages;
    private ArrayList<Membership> memberships;

    private  ArrayList<CashOut> cashOuts = null;
    private Birthday birthday;
    private ContactsContract.CommonDataKinds.Organization organization;
    private TradeAccountG groupAccount;
    private Membership membership;
    private String authenticationKey;
    Context context;
    protected transient boolean authenticated = false;

    private SOrderAcct sOrderAcct;
    private Payee payee;
    private AdminUser adminUser;
    private SuperAdmin superAdmin;
    private Account account;
    private LatLng lastLocation;
    DBHelper dbHelper;

    String accountBalance;
    private int payoutNo;
    int profileNo;
    public Profile() {

        super();
    }

    public Profile(int profile_id, int sponsor_id, String surName, String firstName, String phone, String profileEmail, String profileDob, String profileGender, String profileAddress,  String profileState, String country,String officeBranch, String joinedDate, String profileRole, String profileIDentity,String profileIDentityType,String profileDeviceID,String userName, String profilePassword, String profileStatus) {
        super();
        this.profileID = profile_id;
        this.profileLastName = surName;
        this.profilePhoneNumber = phone;
        this.profileEmail = profileEmail;
        this.identity = identity;
        this.profileUserName = userName;
    }


    @SuppressLint("SimpleDateFormat")
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");



    public String getAuthenticationKey() {
        return authenticationKey;
    }
    public void setAuthenticationKey(String authenticationKey) {
        this.authenticationKey = authenticationKey;
    }


    public void setTransactionsFromDB(ArrayList<Transaction> transactions) {
        this.transactions = transactions;

    }


    /*public final boolean authenticateProfile(String password) throws SQLiteException {
        if (DBHelper.getPassword(this.profileID) != null) {
            this.authenticated = PasswordHelpers.comparePassword(Objects.requireNonNull(DBHelper.getPassword(this.profileID)),
                    password);
        }
        return this.authenticated;
    }*/
    public void addDepositDoc(DepositDoc depositDoc) {
        paymentDocArrayList = new ArrayList<>();
        int depDocC = paymentDocArrayList.size() + 1;
        DepositDoc paymentDoc = new DepositDoc(depDocC,depositDoc);
        paymentDocArrayList.add(paymentDoc);
    }
    public void addTranxCode(TranxCode tranxCode1) {
        tranxCodes= new ArrayList<>();
        tranxCodeC = tranxCodes.size() + 1;
        TranxCode tranxCode = new TranxCode(tranxCodeC,tranxCode1);
        tranxCodes.add(tranxCode);
    }
    public void addCashOut(CashOut cashOut) {

        if (cashOuts != null) {
            cashOutC = cashOuts.size() + 1;
        }
        cashOut = new CashOut(cashOutC,cashOut);
        cashOuts.add(cashOut);

    }

    public void addLoans(Loan loan1) {
        loans= new ArrayList<>();
        loanNumber = loans.size() + 1;
        Loan loan = new Loan(loanNumber, loan1);
        loans.add(loan);
    }
    public void addSupportMessage(SupportMessage supportMessage1) {
        supportMessages= new ArrayList<>();
        messageC = supportMessages.size() + 1;
        supportMessage = new SupportMessage(messageC, supportMessage1);
        supportMessages.add(supportMessage);
    }

    public void addTimeLine(TimeLine timeLine1) {
        timeLines= new ArrayList<>();
        timelineC = timeLines.size() + 1;
        TimeLine timeLine = new TimeLine(timelineC,timeLine1);
        timeLines.add(timeLine);
    }
    public void addPayee(Payee payee1) {
        payees= new ArrayList<>();
        payeeID = payees.size() + 1;
        Payee payee = new Payee(payeeID, payee1);
        payees.add(payee);
    }
    public void addInvestmentDeposit(InvestmentDeposit investmentDeposit1) {
        investmentDeposits= new ArrayList<>();
        invID = investmentDeposits.size() + 1;
        investmentDeposit = new InvestmentDeposit(invID,investmentDeposit1);
        investmentDeposits.add(investmentDeposit);
    }
    public void addGuarantor(Guarantor guarantor1) {
        guarantors= new ArrayList<>();
        guarantorNo = guarantors.size() + 1;
        guarantor = new Guarantor(guarantorNo,guarantor1);
        guarantors.add(guarantor1);
    }
    public void addMembership(Membership membership1) {
        memberships= new ArrayList<>();
        mCountNo = memberships.size() + 1;
        membership = new Membership(mCountNo,membership1);
        memberships.add(membership);
    }


    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public com.ls.awajimatradeeder.Classes.EOfficeBranch getEOfficeBranch() {
        return EOfficeBranch;
    }

    public void setEOfficeBranch(com.ls.awajimatradeeder.Classes.EOfficeBranch EOfficeBranch) {
        this.EOfficeBranch = EOfficeBranch;
    }

    public String getProfileLastName() {
        return profileLastName;
    }

    public void setProfileLastName(String profileLastName) {
        this.profileLastName = profileLastName;
    }
    public int getProfileID() {
        return profileID;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }


    public int getProfTranxID() {
        return profTranxID;
    }

    public void setProfTranxID(int profTranxID) {
        this.profTranxID = profTranxID;
    }

    public String getProfileFirstName() {
        return profileFirstName;
    }

    public void setProfileFirstName(String profileFirstName) {
        this.profileFirstName = profileFirstName;
    }

    public String getProfileUserType() {
        return profileUserType;
    }

    public void setProfileUserType(String profileUserType) {
        this.profileUserType = profileUserType;
    }

    public String getProfilePhoneNumber() {
        return profilePhoneNumber;
    }

    public void setProfilePhoneNumber(String profilePhoneNumber) {
        this.profilePhoneNumber = profilePhoneNumber;
    }

    public String getProfileEmail() {
        return profileEmail;
    }

    public void setProfileEmail(String profileEmail) {
        this.profileEmail = profileEmail;
    }

    public String getProfileDob() {
        return profileDob;
    }

    public void setProfileDob(String profileDob) {
        this.profileDob = profileDob;
    }

    public String getProfileGender() {
        return profileGender;
    }

    public void setProfileGender(String profileGender) {
        this.profileGender = profileGender;
    }

    public String getProfileAddress() {
        return profileAddress;
    }

    public void setProfileAddress(String profileAddress) {
        this.profileAddress = profileAddress;
    }

    public String getProfileOffice() {
        return profileOffice;
    }

    public void setProfileOffice(String profileOffice) {
        this.profileOffice = profileOffice;
    }

    public String getProfileDateJoined() {
        return profileDateJoined;
    }

    public void setProfileDateJoined(String profileDateJoined) {
        this.profileDateJoined = profileDateJoined;
    }

    public String getProfileState() {
        return profileState;
    }

    public void setProfileState(String profileState) {
        this.profileState = profileState;
    }

    public String getProfileRole() {
        return profileRole;
    }

    public void setProfileRole(String profileRole) {
        this.profileRole = profileRole;
    }

    public String getProfileUserName() {
        return profileUserName;
    }

    public void setProfileUserName(String profileUserName) {
        this.profileUserName = profileUserName;
    }

    public String getProfilePassword() {
        return profilePassword;
    }

    public void setProfilePassword(String profilePassword) {
        this.profilePassword = profilePassword;
    }

    public int getProfileSponsorID() {
        return profileSponsorID;
    }

    public void setProfileSponsorID(int profileSponsorID) {
        this.profileSponsorID = profileSponsorID;
    }

    public int getProfNOKId() {
        return profNOKId;
    }

    public void setProfNOKId(int profNOKId) {
        this.profNOKId = profNOKId;
    }

    public String getProfileStatus() {
        return profileStatus;
    }

    public void setProfileStatus(String profileStatus) {
        this.profileStatus = profileStatus;
    }

    public String getProfileDeviceID() {
        return profileDeviceID;
    }

    public void setProfileDeviceID(String profileDeviceID) {
        this.profileDeviceID = profileDeviceID;
    }

    public Uri getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Uri profilePicture) {
        this.profilePicture = profilePicture;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public ArrayList<MTradeAccount> getMTradeAccounts() {
        return MTradeAccounts;
    }

    public void setMTradeAccounts(ArrayList<MTradeAccount> MTradeAccounts) {
        this.MTradeAccounts = MTradeAccounts;
    }

    public void setCashOuts(ArrayList<CashOut> cashOuts) {
        this.cashOuts = cashOuts;
    }

    public ArrayList<AdminUser> getAdminUsers() {
        return adminUsers;
    }

    public void setAdminUsers(ArrayList<AdminUser> adminUsers) {
        this.adminUsers = adminUsers;
    }

    public ArrayList<AdminBankDeposit> getAdminBankDeposits() {
        return adminBankDeposits;
    }

    public void setAdminBankDeposits(ArrayList<AdminBankDeposit> adminBankDeposits) {
        this.adminBankDeposits = adminBankDeposits;
    }

    public ArrayList<SOrder> getStandingOrders() {
        return standingOrders;
    }

    public void setStandingOrders(ArrayList<SOrder> standingOrders) {
        this.standingOrders = standingOrders;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public ArrayList<TimeLine> getTimeLineArrayList() {
        return timeLineArrayList;
    }

    public void setTimeLineArrayList(ArrayList<TimeLine> timeLineArrayList) {
        this.timeLineArrayList = timeLineArrayList;
    }

    public ArrayList<TellerReport> getTellerReportArrayList() {
        return tellerReportArrayList;
    }

    public void setTellerReportArrayList(ArrayList<TellerReport> tellerReportArrayList) {
        this.tellerReportArrayList = tellerReportArrayList;
    }

    public ArrayList<PayOutRequest> getTransactionGrantingArrayList() {
        return transactionGrantingArrayList;
    }

    public void setTransactionGrantingArrayList(ArrayList<PayOutRequest> transactionGrantingArrayList) {
        this.transactionGrantingArrayList = transactionGrantingArrayList;
    }

    public ContactsContract.CommonDataKinds.Organization getOrganization() {
        return organization;
    }

    public void setOrganization(ContactsContract.CommonDataKinds.Organization organization) {
        this.organization = organization;
    }

    public TradeAccountG getGroupAccount() {
        return groupAccount;
    }

    public void setGroupAccount(TradeAccountG groupAccount) {
        this.groupAccount = groupAccount;
    }

    public SOrderAcct getsOrderAcct() {
        return sOrderAcct;
    }

    public void setsOrderAcct(SOrderAcct sOrderAcct) {
        this.sOrderAcct = sOrderAcct;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
