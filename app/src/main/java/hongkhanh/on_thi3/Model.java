package hongkhanh.on_thi3;

import java.io.Serializable;

public class Model implements Serializable {
    public Model() {
    }

    int mID;
    String mName,mAge,mAvatar;
    String mSex;

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAge() {
        return mAge;
    }

    public void setmAge(String mAge) {
        this.mAge = mAge;
    }

    public String getmAvatar() {
        return mAvatar;
    }

    public void setmAvatar(String mAvatar) {
        this.mAvatar = mAvatar;
    }

    public String getmSex() {
        return mSex;
    }

    public void setmSex(String mSex) {
        this.mSex = mSex;
    }

    public void setmSex(Boolean sex){
        if(sex == true){
            this.mSex = "male";
        }else {
            this.mSex = "Female";
        }
    }

    public Model(int mID, String mName, String mAge, String mAvatar, String mSex) {
        this.mID = mID;
        this.mName = mName;
        this.mAge = mAge;
        this.mAvatar = mAvatar;
        this.mSex = mSex;
    }

    public Model(String mName, String mAge, String mAvatar, String mSex) {
        this.mName = mName;
        this.mAge = mAge;
        this.mAvatar = mAvatar;
        this.mSex = mSex;
    }
}
