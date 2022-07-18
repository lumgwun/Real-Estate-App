package com.ls.awajimatradeeder.Classes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;

import com.google.android.gms.maps.model.LatLng;
import com.ls.awajimatradeeder.Database.DBHelper;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static com.ls.awajimatradeeder.Classes.NextOfKin.NOK_PROF_ID;
import static com.ls.awajimatradeeder.Classes.NextOfKin.NOK_TABLE;

@SuppressWarnings("InstantiationOfUtilityClass")
public class Profile implements Serializable, Parcelable {

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
    public static final String PROFILE_ACTIVENESS = "p_Activeness";
    public static final String PROFILE_MEMBERSHIP_TYPE = "p_MembershipType";

    public static final String CREATE_PROFILES_TABLE = "CREATE TABLE " + PROFILES_TABLE + " (" + PROFILE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PROFILE_SURNAME + " TEXT, " + PROFILE_FIRSTNAME + " TEXT, " + PROFILE_PHONE + " TEXT, " + PROFILE_EMAIL + " TEXT, " + PROFILE_DOB + " TEXT, " + PROFILE_GENDER + " TEXT, " +
            PROFILE_ADDRESS + " TEXT, " + PROFILE_ID_TYPE + " TEXT, " + PROFILE_IDENTITY + " TEXT, "+ PROFILE_DEVICE_ID + " TEXT, " + PROFILE_NEXT_OF_KINID + " INTEGER, " + PROFILE_PICTURE + " TEXT, " + PROFILE_STATE + " TEXT, " + PROFILE_COUNTRY + " TEXT, " + PROFILE_OFFICE + " TEXT, " + PROFILE_DATE_JOINED + " TEXT, " + PROFILE_ROLE + " TEXT, " + PROFILE_USERNAME + " TEXT, " + PROFILE_PASSWORD + " TEXT, " + PROFILE_STATUS + " TEXT, " +  PROF_SPONSOR_ID + " INTEGER,"+ PROFILE_ACTIVENESS + " TEXT, " + PROFILE_MEMBERSHIP_TYPE + " TEXT, " + "FOREIGN KEY(" + PROFILE_NEXT_OF_KINID + ") REFERENCES " + NOK_TABLE + "(" + NOK_PROF_ID + "))";


    private String profileIDentity;
    private String profileIdentityType;
    private String profileDeviceID;

    private EOfficeBranch profileEOfficeB;
    private Birthday profileBirthDay;
    private CashOut profileCashOut;
    private Guarantor profileGuarantor;
    private NextOfKin profileNOK;
    private SupportMessage supportMessage;
    private InvestmentDeposit investmentDeposit;
    private AdminUser profileAdminUser;
    private Secretary profileSecretary;
    private SOrderAcct profileSOAcct;
    private TradeAcctWithdrawal profileTradeAcctW;
    private TradeAcctFunding profileTradeAcctF;
    private TradeAccountG profileTradeAcctG;
    private TradeInvestor profileTradeInv;
    private Trader profileTrader;
    private Seller profileSeller;
    private EquityInvestor profileEqtInvestor;

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
    private String profileCountry;


    private int profileSponsorID;


    private int profNOKId;
    private  int messageC=0;
    private  int cashOutC=0;
    private int tranxCodeC=0;
    private int loanNumber=0;
    private int mCountNo=0;

    private String profileStatus;
    private String profileActiveness;
    private String profileMembershipType;
    private Uri profilePicture;



    private ArrayList<MTradeAccount> profileMTradeAccounts;
    private ArrayList<Payee> profilePayees;
    private ArrayList<TimeLine> profileTimeLines;
    private ArrayList<Loan> profileLoans;
    private ArrayList<TranxCode> profileTranxCodes;
    private ArrayList<DepositDoc> profilePaymentDocs;
    private ArrayList<SOrder> profileSOs;
    private ArrayList<Transaction> profileTranx;
    private ArrayList<TellerReport> profileTellerReports;
    private ArrayList<Guarantor> profileGuarantors;
    private ArrayList<InvestmentDeposit> profInvestmentDeposits;
    private ArrayList<PayOutRequest> profPayoutRequest;
    private ArrayList<SupportMessage> profMessages;
    private ArrayList<Membership> profMemberships;
    private ArrayList<PictureImage> profPicImages;
    private ArrayList<Property> profProperties;
    private int profPropNo;
    private  ArrayList<CashOut> profileCashOuts = null;
    private Birthday profileBirthday;
    private ContactsContract.CommonDataKinds.Organization organization;
    private TradeAccountG profTradeAcctG;
    private Membership membership;
    private String authenticationKey;
    Context context;
    protected transient boolean profileAuthenticated = false;

    private SOrderAcct profSOrderAcct;
    private SuperAdmin profileSuperAdmin;
    private Account profileAccount;
    private LatLng profileLastLocation;
    DBHelper dbHelper;

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
        this.profileIDentity = this.profileIDentity;
        this.profileUserName = userName;
    }


    @SuppressLint("SimpleDateFormat")
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public Profile(int profileID, String surname, String firstName, String phone, String email) {
        this.profileID = profileID;
        this.profileLastName = surname;
        this.profileFirstName = firstName;
        this.profilePhoneNumber = phone;
        this.profileEmail = email;
    }

    public Profile(int profileID, String surName, String firstName, String phoneNo, String emailAddress, String dob, String gender, String country, String state, String address, String office, String dateJoined, String membershipType, String userName, String password, String status, String activeness) {
        this.profileID = profileID;
        this.profileLastName = surName;
        this.profileFirstName = firstName;
        this.profilePhoneNumber = phoneNo;
        this.profileEmail = emailAddress;
        this.profileDob = dob;
        this.profilePhoneNumber = dateJoined;
        this.profileEmail = membershipType;
        this.profileGender = gender;
        this.profileCountry = country;
        this.profileState = state;
        this.profileAddress = address;
        this.profileOffice = office;
        this.profileUserName = userName;
        this.profilePassword = password;
        this.profileStatus = status;
        this.profileActiveness = activeness;

    }

    public Profile(int profileID, String surName, String firstName, String phoneNo, String emailAddress, String dob, String gender, String country, String state, String address, String dateJoined, String userName, String password, String status) {
        this.profileID = profileID;
        this.profileLastName = surName;
        this.profileFirstName = firstName;
        this.profilePhoneNumber = phoneNo;
        this.profileEmail = emailAddress;
        this.profileDob = dob;
        this.profilePhoneNumber = dateJoined;
        this.profileGender = gender;
        this.profileCountry = country;
        this.profileState = state;
        this.profileAddress = address;
        this.profileUserName = userName;
        this.profilePassword = password;
        this.profileStatus = status;

    }


    protected Profile(Parcel in) {
        profileIDentity = in.readString();
        profileIdentityType = in.readString();
        profileDeviceID = in.readString();
        supportMessage = in.readParcelable(SupportMessage.class.getClassLoader());
        profileID = in.readInt();
        payeeID = in.readInt();
        guarantorNo = in.readInt();
        profTranxID = in.readInt();
        invID = in.readInt();
        timelineC = in.readInt();
        profileLastName = in.readString();
        profileFirstName = in.readString();
        profileUserType = in.readString();
        profilePhoneNumber = in.readString();
        profileEmail = in.readString();
        profileDob = in.readString();
        profileGender = in.readString();
        profileAddress = in.readString();
        profileOffice = in.readString();
        profileDateJoined = in.readString();
        profileState = in.readString();
        profileRole = in.readString();
        profileUserName = in.readString();
        profilePassword = in.readString();
        profileCountry = in.readString();
        profileSponsorID = in.readInt();
        profNOKId = in.readInt();
        messageC = in.readInt();
        cashOutC = in.readInt();
        tranxCodeC = in.readInt();
        loanNumber = in.readInt();
        mCountNo = in.readInt();
        profileStatus = in.readString();
        profileActiveness = in.readString();
        profileMembershipType = in.readString();
        profilePicture = in.readParcelable(Uri.class.getClassLoader());
        profileMTradeAccounts = in.createTypedArrayList(MTradeAccount.CREATOR);
        profileTimeLines = in.createTypedArrayList(TimeLine.CREATOR);
        profileSOs = in.createTypedArrayList(SOrder.CREATOR);
        profileTranx = in.createTypedArrayList(Transaction.CREATOR);
        profMessages = in.createTypedArrayList(SupportMessage.CREATOR);
        authenticationKey = in.readString();
        profileAccount = in.readParcelable(Account.class.getClassLoader());
        profileLastLocation = in.readParcelable(LatLng.class.getClassLoader());
        payoutNo = in.readInt();
        profileNo = in.readInt();
    }

    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    public String getAuthenticationKey() {
        return authenticationKey;
    }
    public void setAuthenticationKey(String authenticationKey) {
        this.authenticationKey = authenticationKey;
    }


    public void setTransactionsFromDB(ArrayList<Transaction> transactions) {
        this.profileTranx = transactions;

    }


    /*public final boolean authenticateProfile(String password) throws SQLiteException {
        if (DBHelper.getPassword(this.profileID) != null) {
            this.profileAuthenticated = PasswordHelpers.comparePassword(Objects.requireNonNull(DBHelper.getPassword(this.profileID)),
                    password);
        }
        return this.profileAuthenticated;
    }*/
    public void addDepositDoc(DepositDoc depositDoc) {
        profilePaymentDocs = new ArrayList<>();
        int depDocC = profilePaymentDocs.size() + 1;
        DepositDoc paymentDoc = new DepositDoc(depDocC,depositDoc);
        profilePaymentDocs.add(paymentDoc);
    }
    public void addProperty(Property property1) {
        profProperties = new ArrayList<>();
        Property property = new Property(property1);
        profProperties.add(property);
    }
    public void addTranxCode(TranxCode tranxCode1) {
        profileTranxCodes= new ArrayList<>();
        tranxCodeC = profileTranxCodes.size() + 1;
        TranxCode tranxCode = new TranxCode(tranxCodeC,tranxCode1);
        profileTranxCodes.add(tranxCode);
    }
    public void addCashOut(CashOut cashOut) {

        if (profileCashOuts != null) {
            cashOutC = profileCashOuts.size() + 1;
        }
        cashOut = new CashOut(cashOutC,cashOut);
        profileCashOuts.add(cashOut);

    }

    public void addLoans(Loan loan1) {
        profileLoans= new ArrayList<>();
        loanNumber = profileLoans.size() + 1;
        Loan loan = new Loan(loanNumber, loan1);
        profileLoans.add(loan);
    }
    public void addSupportMessage(SupportMessage supportMessage1) {
        profMessages= new ArrayList<>();
        messageC = profMessages.size() + 1;
        supportMessage = new SupportMessage(messageC, supportMessage1);
        profMessages.add(supportMessage);
    }

    public void addTimeLine(TimeLine timeLine1) {
        profileTimeLines= new ArrayList<>();
        timelineC = profileTimeLines.size() + 1;
        TimeLine timeLine = new TimeLine(timelineC,timeLine1);
        profileTimeLines.add(timeLine);
    }
    public void addPayee(Payee payee1) {
        profilePayees = new ArrayList<>();
        payeeID = profilePayees.size() + 1;
        Payee payee = new Payee(payeeID, payee1);
        profilePayees.add(payee);
    }
    public void addInvestmentDeposit(InvestmentDeposit investmentDeposit1) {
        profInvestmentDeposits= new ArrayList<>();
        invID = profInvestmentDeposits.size() + 1;
        investmentDeposit = new InvestmentDeposit(invID,investmentDeposit1);
        profInvestmentDeposits.add(investmentDeposit);
    }
    public void addGuarantor(Guarantor guarantor1) {
        profileGuarantors= new ArrayList<>();
        guarantorNo = profileGuarantors.size() + 1;
        Guarantor guarantor = new Guarantor(guarantorNo,guarantor1);
        profileGuarantors.add(guarantor1);
    }
    public void addMembership(Membership membership1) {
        profMemberships= new ArrayList<>();
        mCountNo = profMemberships.size() + 1;
        membership = new Membership(mCountNo,membership1);
        profMemberships.add(membership);
    }


    public String getProfileIdentityType() {
        return profileIdentityType;
    }

    public void setProfileIdentityType(String profileIdentityType) {
        this.profileIdentityType = profileIdentityType;
    }

    public com.ls.awajimatradeeder.Classes.EOfficeBranch getProfileEOfficeB() {
        return profileEOfficeB;
    }

    public void setProfileEOfficeB(com.ls.awajimatradeeder.Classes.EOfficeBranch profileEOfficeB) {
        this.profileEOfficeB = profileEOfficeB;
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
    public String getProfileIDentity() {
        return profileIDentity;
    }

    public void setProfileIDentity(String profileIDentity) {
        this.profileIDentity = profileIDentity;
    }

    public Uri getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Uri profilePicture) {
        this.profilePicture = profilePicture;
    }


    public ArrayList<MTradeAccount> getProfileMTradeAccounts() {
        return profileMTradeAccounts;
    }

    public void setProfileMTradeAccounts(ArrayList<MTradeAccount> profileMTradeAccounts) {
        this.profileMTradeAccounts = profileMTradeAccounts;
    }

    public void setProfileCashOuts(ArrayList<CashOut> profileCashOuts) {
        this.profileCashOuts = profileCashOuts;
    }


    public ArrayList<Transaction> getProfileTranx() {
        return profileTranx;
    }

    public void setProfileTranx(ArrayList<Transaction> profileTranx) {
        this.profileTranx = profileTranx;
    }

    public ArrayList<TimeLine> getProfileTimelines() {
        return profileTimeLines;
    }

    public void setProfileTimelines(ArrayList<TimeLine> timeLineArrayList) {
        this.profileTimeLines = timeLineArrayList;
    }



    public ContactsContract.CommonDataKinds.Organization getOrganization() {
        return organization;
    }

    public void setOrganization(ContactsContract.CommonDataKinds.Organization organization) {
        this.organization = organization;
    }

    public TradeAccountG getProfTradeAcctG() {
        return profTradeAcctG;
    }

    public void setProfTradeAcctG(TradeAccountG profTradeAcctG) {
        this.profTradeAcctG = profTradeAcctG;
    }

    public SOrderAcct getProfSOrderAcct() {
        return profSOrderAcct;
    }

    public void setProfSOrderAcct(SOrderAcct profSOrderAcct) {
        this.profSOrderAcct = profSOrderAcct;
    }

    public Account getProfileAccount() {
        return profileAccount;
    }

    public void setProfileAccount(Account profileAccount) {
        this.profileAccount = profileAccount;
    }

    public CashOut getProfileCashOut() {
        return profileCashOut;
    }

    public void setProfileCashOut(CashOut profileCashOut) {
        this.profileCashOut = profileCashOut;
    }

    public Guarantor getProfileGuarantor() {
        return profileGuarantor;
    }

    public void setProfileGuarantor(Guarantor profileGuarantor) {
        this.profileGuarantor = profileGuarantor;
    }

    public Birthday getProfileBirthday() {
        return profileBirthday;
    }

    public void setProfileBirthday(Birthday profileBirthday) {
        this.profileBirthday = profileBirthday;
    }

    public LatLng getProfileLastLocation() {
        return profileLastLocation;
    }

    public void setProfileLastLocation(LatLng profileLastLocation) {
        this.profileLastLocation = profileLastLocation;
    }

    public ArrayList<TimeLine> getProfileTimeLines() {
        return profileTimeLines;
    }

    public void setProfileTimeLines(ArrayList<TimeLine> profileTimeLines) {
        this.profileTimeLines = profileTimeLines;
    }

    public ArrayList<Loan> getProfileLoans() {
        return profileLoans;
    }

    public void setProfileLoans(ArrayList<Loan> profileLoans) {
        this.profileLoans = profileLoans;
    }

    public ArrayList<TranxCode> getProfileTranxCodes() {
        return profileTranxCodes;
    }

    public void setProfileTranxCodes(ArrayList<TranxCode> profileTranxCodes) {
        this.profileTranxCodes = profileTranxCodes;
    }

    public AdminUser getProfileAdminUser() {
        return profileAdminUser;
    }

    public void setProfileAdminUser(AdminUser profileAdminUser) {
        this.profileAdminUser = profileAdminUser;
    }

    public Secretary getProfileSecretary() {
        return profileSecretary;
    }

    public void setProfileSecretary(Secretary profileSecretary) {
        this.profileSecretary = profileSecretary;
    }

    public SOrderAcct getProfileSOAcct() {
        return profileSOAcct;
    }

    public void setProfileSOAcct(SOrderAcct profileSOAcct) {
        this.profileSOAcct = profileSOAcct;
    }

    public TradeAcctWithdrawal getProfileTradeAcctW() {
        return profileTradeAcctW;
    }

    public void setProfileTradeAcctW(TradeAcctWithdrawal profileTradeAcctW) {
        this.profileTradeAcctW = profileTradeAcctW;
    }

    public TradeAcctFunding getProfileTradeAcctF() {
        return profileTradeAcctF;
    }

    public void setProfileTradeAcctF(TradeAcctFunding profileTradeAcctF) {
        this.profileTradeAcctF = profileTradeAcctF;
    }

    public TradeAccountG getProfileTradeAcctG() {
        return profileTradeAcctG;
    }

    public void setProfileTradeAcctG(TradeAccountG profileTradeAcctG) {
        this.profileTradeAcctG = profileTradeAcctG;
    }

    public TradeInvestor getProfileTradeInv() {
        return profileTradeInv;
    }

    public void setProfileTradeInv(TradeInvestor profileTradeInv) {
        this.profileTradeInv = profileTradeInv;
    }

    public Trader getProfileTrader() {
        return profileTrader;
    }

    public void setProfileTrader(Trader profileTrader) {
        this.profileTrader = profileTrader;
    }

    public NextOfKin getProfileNOK() {
        return profileNOK;
    }

    public void setProfileNOK(NextOfKin profileNOK) {
        this.profileNOK = profileNOK;
    }

    public EquityInvestor getProfileEqtInvestor() {
        return profileEqtInvestor;
    }

    public void setProfileEqtInvestor(EquityInvestor profileEqtInvestor) {
        this.profileEqtInvestor = profileEqtInvestor;
    }

    public ArrayList<SOrder> getProfileSOs() {
        return profileSOs;
    }

    public void setProfileSOs(ArrayList<SOrder> profileSOs) {
        this.profileSOs = profileSOs;
    }

    public ArrayList<TellerReport> getProfileTellerReports() {
        return profileTellerReports;
    }

    public void setProfileTellerReports(ArrayList<TellerReport> profileTellerReports) {
        this.profileTellerReports = profileTellerReports;
    }

    public ArrayList<Guarantor> getProfileGuarantors() {
        return profileGuarantors;
    }

    public void setProfileGuarantors(ArrayList<Guarantor> profileGuarantors) {
        this.profileGuarantors = profileGuarantors;
    }

    public ArrayList<InvestmentDeposit> getProfInvestmentDeposits() {
        return profInvestmentDeposits;
    }

    public void setProfInvestmentDeposits(ArrayList<InvestmentDeposit> profInvestmentDeposits) {
        this.profInvestmentDeposits = profInvestmentDeposits;
    }



    public ArrayList<SupportMessage> getProfMessages() {
        return profMessages;
    }

    public void setProfMessages(ArrayList<SupportMessage> profMessages) {
        this.profMessages = profMessages;
    }

    public ArrayList<Membership> getProfMemberships() {
        return profMemberships;
    }

    public void setProfMemberships(ArrayList<Membership> profMemberships) {
        this.profMemberships = profMemberships;
    }

    public AdminUser getAdminUser() {
        return profileAdminUser;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.profileAdminUser = adminUser;
    }

    public SuperAdmin getProfileSuperAdmin() {
        return profileSuperAdmin;
    }

    public void setProfileSuperAdmin(SuperAdmin profileSuperAdmin) {
        this.profileSuperAdmin = profileSuperAdmin;
    }

    public ArrayList<PayOutRequest> getProfPayoutRequest() {
        return profPayoutRequest;
    }

    public void setProfPayoutRequest(ArrayList<PayOutRequest> profPayoutRequest) {
        this.profPayoutRequest = profPayoutRequest;
    }

    public Birthday getProfileBirthDay() {
        return profileBirthDay;
    }

    public void setProfileBirthDay(Birthday profileBirthDay) {
        this.profileBirthDay = profileBirthDay;
    }

    public String getProfileCountry() {
        return profileCountry;
    }

    public void setProfileCountry(String profileCountry) {
        this.profileCountry = profileCountry;
    }

    public String getProfileMembershipType() {
        return profileMembershipType;
    }

    public void setProfileMembershipType(String profileMembershipType) {
        this.profileMembershipType = profileMembershipType;
    }

    public String getProfileActiveness() {
        return profileActiveness;
    }

    public void setProfileActiveness(String profileActiveness) {
        this.profileActiveness = profileActiveness;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(profileIDentity);
        parcel.writeString(profileIdentityType);
        parcel.writeString(profileDeviceID);
        parcel.writeParcelable(supportMessage, i);
        parcel.writeInt(profileID);
        parcel.writeInt(payeeID);
        parcel.writeInt(guarantorNo);
        parcel.writeInt(profTranxID);
        parcel.writeInt(invID);
        parcel.writeInt(timelineC);
        parcel.writeString(profileLastName);
        parcel.writeString(profileFirstName);
        parcel.writeString(profileUserType);
        parcel.writeString(profilePhoneNumber);
        parcel.writeString(profileEmail);
        parcel.writeString(profileDob);
        parcel.writeString(profileGender);
        parcel.writeString(profileAddress);
        parcel.writeString(profileOffice);
        parcel.writeString(profileDateJoined);
        parcel.writeString(profileState);
        parcel.writeString(profileRole);
        parcel.writeString(profileUserName);
        parcel.writeString(profilePassword);
        parcel.writeString(profileCountry);
        parcel.writeInt(profileSponsorID);
        parcel.writeInt(profNOKId);
        parcel.writeInt(messageC);
        parcel.writeInt(cashOutC);
        parcel.writeInt(tranxCodeC);
        parcel.writeInt(loanNumber);
        parcel.writeInt(mCountNo);
        parcel.writeString(profileStatus);
        parcel.writeString(profileActiveness);
        parcel.writeString(profileMembershipType);
        parcel.writeParcelable(profilePicture, i);
        parcel.writeTypedList(profileMTradeAccounts);
        parcel.writeTypedList(profileTimeLines);
        parcel.writeTypedList(profileSOs);
        parcel.writeTypedList(profileTranx);
        parcel.writeTypedList(profMessages);
        parcel.writeString(authenticationKey);
        parcel.writeParcelable(profileAccount, i);
        parcel.writeParcelable(profileLastLocation, i);
        parcel.writeInt(payoutNo);
        parcel.writeInt(profileNo);
    }

    public Seller getProfileSeller() {
        return profileSeller;
    }

    public void setProfileSeller(Seller profileSeller) {
        this.profileSeller = profileSeller;
    }

    public ArrayList<PictureImage> getProfPicImages() {
        return profPicImages;
    }

    public void setProfPicImages(ArrayList<PictureImage> profPicImages) {
        this.profPicImages = profPicImages;
    }

    public ArrayList<Property> getProfProperties() {
        return profProperties;
    }

    public void setProfProperties(ArrayList<Property> profProperties) {
        this.profProperties = profProperties;
    }
}
