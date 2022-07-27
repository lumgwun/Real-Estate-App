package com.ls.awajimatradeeder.Classes;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;

import static com.ls.awajimatradeeder.Classes.Profile.PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;

public class Estate implements Serializable, Parcelable {

    public static final String ESTATE_ID = "estate_ID";
    public static final String ESTATE_SUPERADMIN_ID = "estate_SuperAdmin_ID";
    public static final String ESTATE_NAME = "estate_Name";
    public static final String ESTATE_ADDRESS = "estate_Address";
    public static final String ESTATE_LOCALITY = "estate_Locality";
    public static final String ESTATE_STATE = "estate_State";
    public static final String ESTATE_COUNTRY = "estate_Country";
    public static final String ESTATE_LATLNG = "estate_LatLng";
    public static final String ESTATE_STATUS = "estate_status";
    public static final String ESTATE_PROFILEID = "estate_ProfileID";
    public static final String ESTATE_LOGO = "estate_Logo";
    public static final String ESTATE_DESC = "estate_Desc";
    public static final String ESTATE_TABLE = "estate_table";

    public static final String CREATE_ESTATE_TABLE = "CREATE TABLE " + ESTATE_TABLE + " (" + ESTATE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ESTATE_SUPERADMIN_ID + " INTEGER, " + ESTATE_NAME + " TEXT, " + ESTATE_ADDRESS + " TEXT, " + ESTATE_LOCALITY + " TEXT, " + ESTATE_STATE + " TEXT, " + ESTATE_COUNTRY + " TEXT, " +
            ESTATE_LATLNG + " TEXT, " + ESTATE_STATUS + " TEXT, " + ESTATE_PROFILEID + " INTEGER, " + ESTATE_LOGO + " BLOB, " + ESTATE_DESC + " TEXT, " + "FOREIGN KEY(" + ESTATE_PROFILEID + ") REFERENCES " + PROFILES_TABLE + "(" + PROFILE_ID + "))";


    private EstateSuperAdmin estateSuperAdmin;
    private Profile estateProfile;
    private int estateSuperAdminID;
    private int estateProfileID;
    private int estateID;
    private String estateName;
    private String estateDescp;
    private String estateAddress;
    private String estateLocality;
    private String estateState;
    private String estateCountry;
    private String estateStatus;
    private String estateLogo;
    private String estateLatLng;
    private ArrayList<EstateElection> estateElections;
    private ArrayList<EstateChat> estateChats;
    private ArrayList<EstateVisit> estateVisits;
    private ArrayList<EstateDoc> estateDocs;
    private ArrayList<EstateLettingSales> estateLettingSales;
    private ArrayList<EstateSupplier> estateSuppliers;
    private ArrayList<EstateMeeting> estateMeetings;
    private ArrayList<EstateVisitor> estateVisitors;
    private ArrayList<EstateAdmin> estateAdmins;
    private ArrayList<EstateJob> estateJobs;
    private ArrayList<EstateAppartment> estateAppartments;
    private ArrayList<EstateOccupant> estateOccupants;
    private ArrayList<EstateAdminDuty> estateAdminDuties;
    private ArrayList<EstateSupplies> estateSupplies;
    private ArrayList<EstateTimeLine> estateTimeLines;
    private ArrayList<EstateSubcription> estateSubcriptions;
    private ArrayList<EstateTranx> estateTranxes;
    private ArrayList<EstateInvestors> estateInvestors;
    private ArrayList<EstateLoan> estateLoans;
    private ArrayList<EstateEmergency> estateEmergencies;
    private ArrayList<EstateGroupSavings> estateGroupSavings;
    private ArrayList<EstateCoopMembers> estateCoopMembers;
    private String estateCurrency;
    private String estPriceDur;
    private double estPrice;

    public Estate() {
        super();

    }

    protected Estate(Parcel in) {
        estateSuperAdminID = in.readInt();
        estateID = in.readInt();
        estateName = in.readString();
        estateAddress = in.readString();
        estateLocality = in.readString();
        estateCountry = in.readString();
        estateStatus = in.readString();
        estateLatLng = in.readParcelable(LatLng.class.getClassLoader());
    }

    public static final Creator<Estate> CREATOR = new Creator<Estate>() {
        @Override
        public Estate createFromParcel(Parcel in) {
            return new Estate(in);
        }

        @Override
        public Estate[] newArray(int size) {
            return new Estate[size];
        }
    };

    public EstateSuperAdmin getEstateSuperAdmin() {
        return estateSuperAdmin;
    }

    public void setEstateSuperAdmin(EstateSuperAdmin estateSuperAdmin) {
        this.estateSuperAdmin = estateSuperAdmin;
    }

    public int getEstateSuperAdminID() {
        return estateSuperAdminID;
    }

    public void setEstateSuperAdminID(int estateSuperAdminID) {
        this.estateSuperAdminID = estateSuperAdminID;
    }

    public int getEstateID() {
        return estateID;
    }

    public void setEstateID(int estateID) {
        this.estateID = estateID;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getEstateAddress() {
        return estateAddress;
    }

    public void setEstateAddress(String estateAddress) {
        this.estateAddress = estateAddress;
    }

    public String getEstateLatLng() {
        return estateLatLng;
    }

    public void setEstateLatLng(String estateLatLng) {
        this.estateLatLng = estateLatLng;
    }

    public String getEstateCountry() {
        return estateCountry;
    }

    public void setEstateCountry(String estateCountry) {
        this.estateCountry = estateCountry;
    }

    public String getEstateLocality() {
        return estateLocality;
    }

    public void setEstateLocality(String estateLocality) {
        this.estateLocality = estateLocality;
    }

    public ArrayList<EstateElection> getEstateElections() {
        return estateElections;
    }

    public void setEstateElections(ArrayList<EstateElection> estateElections) {
        this.estateElections = estateElections;
    }

    public ArrayList<EstateMeeting> getEstateMeetings() {
        return estateMeetings;
    }

    public void setEstateMeetings(ArrayList<EstateMeeting> estateMeetings) {
        this.estateMeetings = estateMeetings;
    }

    public ArrayList<EstateVisitor> getEstateVisitors() {
        return estateVisitors;
    }

    public void setEstateVisitors(ArrayList<EstateVisitor> estateVisitors) {
        this.estateVisitors = estateVisitors;
    }

    public ArrayList<EstateAdmin> getEstateAdmins() {
        return estateAdmins;
    }

    public void setEstateAdmins(ArrayList<EstateAdmin> estateAdmins) {
        this.estateAdmins = estateAdmins;
    }

    public ArrayList<EstateJob> getEstateJobs() {
        return estateJobs;
    }

    public void setEstateJobs(ArrayList<EstateJob> estateJobs) {
        this.estateJobs = estateJobs;
    }

    public ArrayList<EstateAppartment> getEstateAppartments() {
        return estateAppartments;
    }

    public void setEstateAppartments(ArrayList<EstateAppartment> estateAppartments) {
        this.estateAppartments = estateAppartments;
    }

    public ArrayList<EstateOccupant> getEstateOccupants() {
        return estateOccupants;
    }

    public void setEstateOccupants(ArrayList<EstateOccupant> estateOccupants) {
        this.estateOccupants = estateOccupants;
    }

    public ArrayList<EstateAdminDuty> getEstateAdminDuties() {
        return estateAdminDuties;
    }

    public void setEstateAdminDuties(ArrayList<EstateAdminDuty> estateAdminDuties) {
        this.estateAdminDuties = estateAdminDuties;
    }

    public ArrayList<EstateSupplies> getEstateSupplies() {
        return estateSupplies;
    }

    public void setEstateSupplies(ArrayList<EstateSupplies> estateSupplies) {
        this.estateSupplies = estateSupplies;
    }

    public ArrayList<EstateTimeLine> getEstateTimeLines() {
        return estateTimeLines;
    }

    public void setEstateTimeLines(ArrayList<EstateTimeLine> estateTimeLines) {
        this.estateTimeLines = estateTimeLines;
    }

    public ArrayList<EstateSubcription> getEstateSubcriptions() {
        return estateSubcriptions;
    }

    public void setEstateSubcriptions(ArrayList<EstateSubcription> estateSubcriptions) {
        this.estateSubcriptions = estateSubcriptions;
    }

    public ArrayList<EstateTranx> getEstateTranxes() {
        return estateTranxes;
    }

    public void setEstateTranxes(ArrayList<EstateTranx> estateTranxes) {
        this.estateTranxes = estateTranxes;
    }

    public ArrayList<EstateInvestors> getEstateInvestors() {
        return estateInvestors;
    }

    public void setEstateInvestors(ArrayList<EstateInvestors> estateInvestors) {
        this.estateInvestors = estateInvestors;
    }

    public ArrayList<EstateLoan> getEstateLoans() {
        return estateLoans;
    }

    public void setEstateLoans(ArrayList<EstateLoan> estateLoans) {
        this.estateLoans = estateLoans;
    }

    public ArrayList<EstateCoopMembers> getEstateMembers() {
        return estateCoopMembers;
    }

    public void setEstateMembers(ArrayList<EstateCoopMembers> estateCoopMembers) {
        this.estateCoopMembers = estateCoopMembers;
    }

    public String getEstateStatus() {
        return estateStatus;
    }

    public void setEstateStatus(String estateStatus) {
        this.estateStatus = estateStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(estateSuperAdminID);
        parcel.writeInt(estateID);
        parcel.writeString(estateName);
        parcel.writeString(estateAddress);
        parcel.writeString(estateLocality);
        parcel.writeString(estateCountry);
        parcel.writeString(estateStatus);
        parcel.writeString(estateLatLng);
    }

    public ArrayList<EstateVisit> getEstateVisits() {
        return estateVisits;
    }

    public void setEstateVisits(ArrayList<EstateVisit> estateVisits) {
        this.estateVisits = estateVisits;
    }

    public ArrayList<EstateEmergency> getEstateEmergencies() {
        return estateEmergencies;
    }

    public void setEstateEmergencies(ArrayList<EstateEmergency> estateEmergencies) {
        this.estateEmergencies = estateEmergencies;
    }

    public ArrayList<EstateGroupSavings> getEstateGroupSavings() {
        return estateGroupSavings;
    }

    public void setEstateGroupSavings(ArrayList<EstateGroupSavings> estateGroupSavings) {
        this.estateGroupSavings = estateGroupSavings;
    }

    public ArrayList<EstateSupplier> getEstateSuppliers() {
        return estateSuppliers;
    }

    public void setEstateSuppliers(ArrayList<EstateSupplier> estateSuppliers) {
        this.estateSuppliers = estateSuppliers;
    }

    public ArrayList<EstateDoc> getEstateDocs() {
        return estateDocs;
    }

    public void setEstateDocs(ArrayList<EstateDoc> estateDocs) {
        this.estateDocs = estateDocs;
    }

    public ArrayList<EstateLettingSales> getEstateLettingSales() {
        return estateLettingSales;
    }

    public void setEstateLettingSales(ArrayList<EstateLettingSales> estateLettingSales) {
        this.estateLettingSales = estateLettingSales;
    }

    public ArrayList<EstateChat> getEstateChats() {
        return estateChats;
    }

    public void setEstateChats(ArrayList<EstateChat> estateChats) {
        this.estateChats = estateChats;
    }

    public String getEstateState() {
        return estateState;
    }

    public void setEstateState(String estateState) {
        this.estateState = estateState;
    }

    public int getEstateProfileID() {
        return estateProfileID;
    }

    public void setEstateProfileID(int estateProfileID) {
        this.estateProfileID = estateProfileID;
    }

    public String getEstateLogo() {
        return estateLogo;
    }

    public void setEstateLogo(String estateLogo) {
        this.estateLogo = estateLogo;
    }

    public Profile getEstateProfile() {
        return estateProfile;
    }

    public void setEstateProfile(Profile estateProfile) {
        this.estateProfile = estateProfile;
    }

    public String getEstateDescp() {
        return estateDescp;
    }

    public void setEstateDescp(String estateDescp) {
        this.estateDescp = estateDescp;
    }

    public String getEstateCurrency() {
        return estateCurrency;
    }

    public void setEstateCurrency(String estateCurrency) {
        this.estateCurrency = estateCurrency;
    }

    public String getEstPriceDur() {
        return estPriceDur;
    }

    public void setEstPriceDur(String estPriceDur) {
        this.estPriceDur = estPriceDur;
    }

    public double getEstPrice() {
        return estPrice;
    }

    public void setEstPrice(double estPrice) {
        this.estPrice = estPrice;
    }
}
