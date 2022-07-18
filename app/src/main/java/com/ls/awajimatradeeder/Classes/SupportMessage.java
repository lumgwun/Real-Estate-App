package com.ls.awajimatradeeder.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import static com.ls.awajimatradeeder.Classes.Profile.PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;

public class SupportMessage implements Serializable, Parcelable {
    private String messageDetails;
    private int messageID=10;
    private int messageSenderID;
    private String messageSendingAppOwner;
    private String messageSenderName;
    private int messageRecipientID;
    private String messageRecipient;
    private String messageOffice;
    private String messageTime;
    private String messageType;
    private String messageAdminName;
    private int messageNo =0;
    private int messageAdminID;
    private SupportMessage supportMessage1;
    private String messagePhoneNo;
    private int messageOTP;

    protected SupportMessage (){
        super();
    }
    public SupportMessage (int messageID, int messageRecipientID, String messageSendingAppOwner, String messageSenderName, String messageRecipient, String purpose, String messageOffice, String details, String messageTime) {
        this.messageID = messageID;
        this.messageSenderName = messageSenderName;
        this.messageRecipientID = messageRecipientID;
        this.messageSenderID = messageRecipientID;
        this.messageSendingAppOwner = messageSendingAppOwner;
        this.messageDetails = details;
        this.messageTime = messageTime;
        this.messageType = purpose;
        this.messageOffice = messageOffice;
        this.messageRecipient = messageRecipient;

    }
    public static final String MESSAGE_TABLE = "message_table";
    public static final String MESSAGE_ID = "_message_id";
    public static final String MESSAGE_DETAILS = "_message_Details";
    public static final String MESSAGE_VIEWED = "message_viewed";
    public static final String MESSAGE_TIME = "message_time";
    public static final String MESSAGE_SENDER = "message_sender";
    public static final String MESSAGE_SENDING_APP_OWNER = "message_sending_Owner";
    public static final String MESSAGE_RECIPIENT = "message_Recipient";
    public static final String MESSAGE_PURPOSE = "message_purpose";
    public static final String MESSAGE_ADMIN_NAME = "message_admin_name";
    public static final String MESSAGE_ADMIN_ID = "message_admin_id";
    public static final String MESSAGE_RECIPIENT_ID = "message_Recipient_id";
    public static final String MESSAGE_PROF_ID = "message__Prof_id";
    public static final String MESSAGE_BRANCH_OFFICE = "message_office";

    public static final String MESSAGE_PHONENO = "message__Phone";
    public static final String MESSAGE_OTP = "message_OTP";

    public static final String CREATE_MESSAGE_TABLE = "CREATE TABLE IF NOT EXISTS " + MESSAGE_TABLE + " (" + MESSAGE_PROF_ID + " INTEGER, " + MESSAGE_ID + " INTEGER , " +
            MESSAGE_RECIPIENT_ID + " INTEGER , "+ MESSAGE_ADMIN_ID + " TEXT , "+ MESSAGE_ADMIN_NAME + " TEXT , " + MESSAGE_PURPOSE + " TEXT , "+ MESSAGE_DETAILS + " TEXT , " + MESSAGE_SENDER + " TEXT , "+ MESSAGE_RECIPIENT + " TEXT , " + MESSAGE_TIME + " TEXT , " +
            MESSAGE_VIEWED + " INTEGER, " + MESSAGE_BRANCH_OFFICE + " TEXT , "+ MESSAGE_SENDING_APP_OWNER + " TEXT , " + MESSAGE_PHONENO + " TEXT , "+ MESSAGE_OTP + " INTEGER , " + "PRIMARY KEY("  + MESSAGE_ID + "), " +"FOREIGN KEY(" + MESSAGE_RECIPIENT_ID + ") REFERENCES " + PROFILES_TABLE + "(" + PROFILE_ID + "),"+ "FOREIGN KEY(" + MESSAGE_PROF_ID + ") REFERENCES " + PROFILES_TABLE + "(" + PROFILE_ID + "))";

    public SupportMessage(int messageID, int profileID, int messageRecipientID, int messageAdminID, String adminName, String purpose, String details,String sendingAppOwner, String sender, String recipient, String time, int views, String office) {
        this.messageID = messageID;
        this.messageSenderID = profileID;
        this.messageAdminID = messageAdminID;
        this.messageRecipientID = messageRecipientID;
        this.messageAdminName = adminName;
        this.messageSendingAppOwner = sendingAppOwner;
        this.messageDetails = details;
        this.messageTime = time;
        this.messageNo = views;
        this.messageSenderName = sender;
        this.messageType = purpose;
        this.messageOffice = office;
        this.messageRecipient = recipient;
    }

    public SupportMessage(int messageC, SupportMessage supportMessage1) {
        this.messageNo = messageC;
        this.supportMessage1 = supportMessage1;

    }

    protected SupportMessage(Parcel in) {
        messageDetails = in.readString();
        messageID = in.readInt();
        messageSenderID = in.readInt();
        messageSendingAppOwner = in.readString();
        messageSenderName = in.readString();
        messageRecipientID = in.readInt();
        messageRecipient = in.readString();
        messageOffice = in.readString();
        messageTime = in.readString();
        messageType = in.readString();
        messageAdminName = in.readString();
        messageNo = in.readInt();
        messageAdminID = in.readInt();
        supportMessage1 = in.readParcelable(SupportMessage.class.getClassLoader());
    }

    public static final Creator<SupportMessage> CREATOR = new Creator<SupportMessage>() {
        @Override
        public SupportMessage createFromParcel(Parcel in) {
            return new SupportMessage(in);
        }

        @Override
        public SupportMessage[] newArray(int size) {
            return new SupportMessage[size];
        }
    };

    public SupportMessage(String uPhoneNumber, int otpDigit) {
        this.messagePhoneNo = uPhoneNumber;
        this.messageOTP = otpDigit;

    }

    public String getMessageDetails() {
        return messageDetails;
    }

    public void setMessageDetails(String messageDetails) {
        this.messageDetails = messageDetails;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getMessageSendingAppOwner() {
        return messageSendingAppOwner;
    }

    public void setMessageSendingAppOwner(String messageSendingAppOwner) {
        this.messageSendingAppOwner = messageSendingAppOwner;
    }

    public String getMessageSenderName() {
        return messageSenderName;
    }

    public void setMessageSenderName(String messageSenderName) {
        this.messageSenderName = messageSenderName;
    }

    public int getMessageRecipientID() {
        return messageRecipientID;
    }

    public void setMessageRecipientID(int messageRecipientID) {
        this.messageRecipientID = messageRecipientID;
    }

    public String getMessageRecipient() {
        return messageRecipient;
    }

    public void setMessageRecipient(String messageRecipient) {
        this.messageRecipient = messageRecipient;
    }

    public String getMessageOffice() {
        return messageOffice;
    }

    public void setMessageOffice(String messageOffice) {
        this.messageOffice = messageOffice;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public int getMessageNo() {
        return messageNo;
    }

    public void setMessageNo(int messageNo) {
        this.messageNo = messageNo;
    }

    public int getMessageAdminID() {
        return messageAdminID;
    }

    public void setMessageAdminID(int messageAdminID) {
        this.messageAdminID = messageAdminID;
    }

    public int getMessageSenderID() {
        return messageSenderID;
    }

    public void setMessageSenderID(int messageSenderID) {
        this.messageSenderID = messageSenderID;
    }

    public String getMessageAdminName() {
        return messageAdminName;
    }

    public void setMessageAdminName(String messageAdminName) {
        this.messageAdminName = messageAdminName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(messageDetails);
        parcel.writeInt(messageID);
        parcel.writeInt(messageSenderID);
        parcel.writeString(messageSendingAppOwner);
        parcel.writeString(messageSenderName);
        parcel.writeInt(messageRecipientID);
        parcel.writeString(messageRecipient);
        parcel.writeString(messageOffice);
        parcel.writeString(messageTime);
        parcel.writeString(messageType);
        parcel.writeString(messageAdminName);
        parcel.writeInt(messageNo);
        parcel.writeInt(messageAdminID);
        parcel.writeParcelable(supportMessage1, i);
    }

    public String getMessagePhoneNo() {
        return messagePhoneNo;
    }

    public void setMessagePhoneNo(String messagePhoneNo) {
        this.messagePhoneNo = messagePhoneNo;
    }

    public int getMessageOTP() {
        return messageOTP;
    }

    public void setMessageOTP(int messageOTP) {
        this.messageOTP = messageOTP;
    }
}
