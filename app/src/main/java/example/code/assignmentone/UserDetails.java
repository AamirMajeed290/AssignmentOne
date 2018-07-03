package example.code.assignmentone;


/*This class can be used to parcel objects and to store data in Realm in next version*/

import android.os.Parcel;
import android.os.Parcelable;

public class UserDetails implements Parcelable {

    private String firstName;
    private String lastName;
    private String dOB;
    private String telephoneNumber;
    private String currencyType;
    private String countryName;
    private String emailAddress;
    private String password;

    public UserDetails(String firstName, String lastName, String dOB,String telephoneNumber,String currencyType, String countryName, String emailAddress,String password){

    this.firstName=firstName;
    this.lastName=lastName;
    this.dOB=dOB;
   // this.address=address;
    this.telephoneNumber=telephoneNumber;
    this.currencyType=currencyType;
    this.countryName=countryName;
    this.emailAddress=emailAddress;
    this.password=password;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getdOB() {
        return dOB;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.dOB);
        dest.writeString(this.telephoneNumber);
        dest.writeString(this.currencyType);
        dest.writeString(this.countryName);
        dest.writeString(this.emailAddress);
        dest.writeString(this.password);
    }

    protected UserDetails(Parcel in) {
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.dOB = in.readString();
        this.telephoneNumber = in.readString();
        this.currencyType = in.readString();
        this.countryName = in.readString();
        this.emailAddress = in.readString();
        this.password = in.readString();
    }

    public static final Parcelable.Creator<UserDetails> CREATOR = new Parcelable.Creator<UserDetails>() {
        @Override
        public UserDetails createFromParcel(Parcel source) {
            return new UserDetails(source);
        }

        @Override
        public UserDetails[] newArray(int size) {
            return new UserDetails[size];
        }
    };
}
