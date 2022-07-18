package com.ls.awajimatradeeder.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;

public class Estate implements Serializable, Parcelable {
    private EstateSuperAdmin estateSuperAdmin;
    private int estateSuperAdminID;
    private int estateID;
    private String estateName;
    private String estateAddress;
    private String estateLGA;
    private String estateCountry;
    private String estateStatus;
    private LatLng estateLatLng;
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

    public Estate() {
        super();

    }

    protected Estate(Parcel in) {
        estateSuperAdminID = in.readInt();
        estateID = in.readInt();
        estateName = in.readString();
        estateAddress = in.readString();
        estateLGA = in.readString();
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

    public LatLng getEstateLatLng() {
        return estateLatLng;
    }

    public void setEstateLatLng(LatLng estateLatLng) {
        this.estateLatLng = estateLatLng;
    }

    public String getEstateCountry() {
        return estateCountry;
    }

    public void setEstateCountry(String estateCountry) {
        this.estateCountry = estateCountry;
    }

    public String getEstateLGA() {
        return estateLGA;
    }

    public void setEstateLGA(String estateLGA) {
        this.estateLGA = estateLGA;
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
        parcel.writeString(estateLGA);
        parcel.writeString(estateCountry);
        parcel.writeString(estateStatus);
        parcel.writeParcelable(estateLatLng, i);
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
}
