package com.bawanj.andoriddatabinding.model;


//public class User{
//    public final ObservableField<String> userName     = new ObservableField<>();
//    public final ObservableField<String> userPassword = new ObservableField<>();
//}

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.bawanj.andoriddatabinding.BR;

public class User extends BaseObservable {

    private String userName;
    private String userPassword;
    private int userAge;

    public User(String userName, String userPassword , int userAge) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userAge= userAge;
    }

    @Bindable // create BR object, link to user_item
    public String getUserName() {
        return userName;
    }

    @Bindable
    public String getUserPassword() {
        return userPassword;
    }
    @Bindable
    public int getUserAge() {
        return userAge;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        notifyPropertyChanged(BR.userPassword);
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
        notifyPropertyChanged(BR.userAge);
    }
}
