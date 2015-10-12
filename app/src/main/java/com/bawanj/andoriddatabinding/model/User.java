package com.bawanj.andoriddatabinding.model;


import android.databinding.ObservableField;

public class User{
    public final ObservableField<String> userName     = new ObservableField<>();
    public final ObservableField<String> userPassword = new ObservableField<>();
}

//public class User extends BaseObservable {
//
//    private String userName;
//    private String userPassword;
//
//    public User(String userName, String userPassword ) {
//        this.userName = userName;
//        this.userPassword = userPassword;
//    }
//
//    @Bindable // create BR object
//    public String getUserName() {
//        return userName;
//    }
//    @Bindable
//    public String getUserPassword() {
//        return userPassword;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//        notifyPropertyChanged(BR.userName);
//    }
//
//    public void setUserPassword(String userPassword) {
//        this.userPassword = userPassword;
//        notifyPropertyChanged(BR.userPassword);
//    }
//}
